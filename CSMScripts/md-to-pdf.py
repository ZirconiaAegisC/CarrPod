#!/usr/bin/env python3
"""MD → PDF Converter — converts Markdown files to professional PDFs using only Python stdlib."""

import re, zlib, os, sys

def md_to_pdf(input_path, output_path):
    with open(input_path) as f:
        md = f.read()
    
    lines = md.split('\n')
    text_lines = []
    for line in lines:
        line = line.rstrip()
        line = re.sub(r'\*\*(.+?)\*\*', r'\1', line)
        line = re.sub(r'\*(.+?)\*', r'\1', line)
        line = re.sub(r'`+', '', line)
        line = re.sub(r'#{1,6}\s+', '  ', line)
        line = re.sub(r'-{3,}', chr(0x2500) * 50, line)
        line = re.sub(r'={3,}', chr(0x2500) * 50, line)
        line = re.sub(r'[^\x20-\x7E\u2500]', '?', line)
        text_lines.append(line)
    
    content = '\n'.join(text_lines)
    
    page_w, page_h = 595, 842
    margin = 50
    chars_per_line = 90
    lines_per_page = 75
    
    wrapped = []
    for para in content.split('\n'):
        if not para.strip():
            wrapped.append('')
            continue
        while len(para) > chars_per_line:
            wrapped.append(para[:chars_per_line])
            para = para[chars_per_line:]
        wrapped.append(para)
    
    pages = []
    current = []
    for line in wrapped:
        current.append(line)
        if len(current) >= lines_per_page:
            pages.append(current)
            current = []
    if current:
        pages.append(current)
    
    objects = []
    offsets = []
    
    def add_obj(data):
        offsets.append(len(b''.join(objects)))
        objects.append(data)
    
    add_obj(b'1 0 obj\n<< /Type /Catalog /Pages 2 0 R >>\nendobj\n')
    
    kids = ' '.join([f'{3+i} 0 R' for i in range(len(pages))])
    add_obj(f'2 0 obj\n<< /Type /Pages /Kids [{kids}] /Count {len(pages)} >>\nendobj\n'.encode())
    
    font_id = 3 + len(pages)
    
    for i, page_lines in enumerate(pages):
        stream_lines = ['BT', '/F1 9 Tf', f'{margin} {page_h - margin - 18} Td', '10 TL']
        for line in page_lines:
            safe = line.replace('\\', '\\\\').replace('(', '\\(').replace(')', '\\)')
            if safe.strip():
                stream_lines.append(f'({safe[:chars_per_line]}) Tj T*')
            else:
                stream_lines.append('T*')
        stream_lines.append('ET')
        stream = '\n'.join(stream_lines).encode()
        compressed = zlib.compress(stream)
        
        page_id = 3 + i
        content_id = font_id + 1 + i
        add_obj(f'{page_id} 0 obj\n<< /Type /Page /Parent 2 0 R /MediaBox [0 0 {page_w} {page_h}] /Contents {content_id} 0 R /Resources << /Font << /F1 {font_id} 0 R >> >> >>\nendobj\n'.encode())
    
    add_obj(f'{font_id} 0 obj\n<< /Type /Font /Subtype /Type1 /BaseFont /Courier >>\nendobj\n'.encode())
    
    for i in range(len(pages)):
        sb = [b'BT', b'/F1 9 Tf', f'{margin} {page_h - margin - 18} Td'.encode(), b'10 TL']
        for line in pages[i]:
            safe = line.replace('\\', '\\\\').replace('(', '\\(').replace(')', '\\)')
            if safe.strip():
                sb.append(f'({safe[:chars_per_line]}) Tj T*'.encode())
            else:
                sb.append(b'T*')
        sb.append(b'ET')
        full = b'\n'.join(sb)
        compressed = zlib.compress(full)
        cid = font_id + 1 + i
        add_obj(f'{cid} 0 obj\n<< /Length {len(compressed)} /Filter /FlateDecode >>\nstream\n'.encode() + compressed + b'\nendstream\nendobj\n')
    
    xref_offset = sum(len(o) for o in objects)
    result = b'%PDF-1.4\n'
    for o in objects:
        result += o
    result += b'xref\n'
    result += f'0 {len(objects)+1}\n'.encode()
    result += b'0000000000 65535 f \n'
    for off in offsets:
        result += f'{off:010d} 00000 n \n'.encode()
    result += b'trailer\n<< /Size ' + str(len(objects)+1).encode() + b' /Root 1 0 R >>\n'
    result += b'startxref\n' + str(xref_offset).encode() + b'\n%%EOF'
    
    os.makedirs(os.path.dirname(output_path) or '.', exist_ok=True)
    with open(output_path, 'wb') as f:
        f.write(result)
    
    size_kb = os.path.getsize(output_path) / 1024
    return size_kb, len(pages)


if __name__ == '__main__':
    files = [
        ('CSMGeneralOutreach/COMPENDIUM-MINI.md', 'CSMEmailOutgoing/July2026/ATTACHMENTS/COMPENDIUM-MINI.pdf'),
        ('CSMGeneralOutreach/CSMGeneralOutreach-COMPILED-Compendium.md', 'CSMEmailOutgoing/July2026/ATTACHMENTS/CSMGeneralOutreach-COMPILED-Compendium.pdf'),
        ('CSMEval/11-Property-Casualty-Insurance-and-Reinsurance/CSMEval11-COMPILED-Briefing-Packet.md', 'CSMEmailOutgoing/July2026/ATTACHMENTS/CSMEval11-COMPILED-Briefing-Packet.pdf'),
    ]
    
    for src, dst in files:
        if os.path.exists(src):
            size, pages = md_to_pdf(src, dst)
            print(f'  {dst}  ({size:.1f} KB, {pages} pages)')
        else:
            print(f'  SKIP: {src} not found')
    
    print('\nAll PDFs generated.')
