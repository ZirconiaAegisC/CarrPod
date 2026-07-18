#!/usr/bin/env python3
"""
MD → Styled PDF Converter — preserves bold, headers, separators, lists.
Uses Python stdlib only. Courier + Courier-Bold. Artful output.
"""

import re, zlib, os, sys

def md_to_styled_pdf_v2(input_path, output_path):
    with open(input_path) as f:
        md = f.read()
    
    lines = md.split('\n')
    
    page_w, page_h = 595, 842  # A4
    margin = 50
    chars_per_line = 80
    lines_per_page = 72
    line_height = 12
    
    # Parse into styled segments: (style, text)
    # styles: H1, H2, H3, BOLD_PARA, NORMAL, HR, BLANK, LIST, BULLET
    segments = []
    
    for line in lines:
        stripped = line.rstrip()
        
        if not stripped:
            segments.append(('BLANK', ''))
            continue
        
        if re.match(r'^[-=]{10,}', stripped):
            segments.append(('HR', ''))
            continue
        
        # Strip markdown bold markers but TRACK them
        if stripped.startswith('### '):
            segments.append(('H3', stripped[4:]))
        elif stripped.startswith('## '):
            segments.append(('H2', stripped[3:]))
        elif stripped.startswith('# '):
            segments.append(('H1', stripped[2:]))
        elif stripped.startswith('- ') or stripped.startswith('* '):
            segments.append(('BULLET', stripped[2:]))
        elif re.match(r'^\d+\.\s', stripped):
            segments.append(('LIST', re.sub(r'^\d+\.\s', '', stripped)))
        else:
            segments.append(('NORMAL', stripped))
    
    # Build text lines with bold markers preserved via underlines (Courier approach)
    text_lines = []
    for style, text in segments:
        if style == 'BLANK':
            text_lines.append(('', False, False))
        elif style == 'HR':
            text_lines.append((chr(0x2500) * 75, False, False))
            text_lines.append(('', False, False))
        elif style == 'H1':
            for ln in wrap_text(text.upper(), chars_per_line):
                text_lines.append((ln, True, False))  # Bold
            text_lines.append(('', False, False))
        elif style == 'H2':
            for ln in wrap_text('  ' + text, chars_per_line):
                text_lines.append((ln, True, False))  # Bold
            text_lines.append(('', False, False))
        elif style == 'H3':
            for ln in wrap_text('> ' + text, chars_per_line):
                text_lines.append((ln, True, False))  # Bold
            text_lines.append(('', False, False))
        elif style == 'BULLET':
            for ln in wrap_text('  * ' + text, chars_per_line - 4):
                text_lines.append((ln, False, False))
        elif style == 'LIST':
            for ln in wrap_text('    ' + text, chars_per_line - 6):
                text_lines.append((ln, False, False))
        elif style == 'NORMAL':
            # Process inline bold: **stuff** → mark as bold segments
            parts = re.split(r'(\*\*[^*]+\*\*)', text)
            current_line = ''
            for part in parts:
                if part.startswith('**') and part.endswith('**'):
                    bold_text = part[2:-2]
                    # Add preceding normal text first
                    if current_line.strip():
                        for ln in wrap_text(current_line, chars_per_line):
                            text_lines.append((ln, False, False))
                        current_line = ''
                    for ln in wrap_text(bold_text, chars_per_line):
                        text_lines.append((ln, True, False))  # Bold
                else:
                    current_line += part
            if current_line.strip():
                for ln in wrap_text(current_line, chars_per_line):
                    text_lines.append((ln, False, False))
    
    # Paginate
    pages = []
    current = []
    for line_info in text_lines:
        current.append(line_info)
        if len(current) >= lines_per_page:
            pages.append(current[:lines_per_page])
            current = current[lines_per_page:]
    if current:
        pages.append(current)
    
    if not pages:
        pages = [[('', False, False)]]
    
    # Build PDF objects
    objects = []
    offsets = []
    
    def add_obj(data):
        offsets.append(len(b''.join(objects)))
        objects.append(data)
    
    add_obj(b'1 0 obj\n<< /Type /Catalog /Pages 2 0 R >>\nendobj\n')
    
    kids = ' '.join([f'{3+i} 0 R' for i in range(len(pages))])
    add_obj(f'2 0 obj\n<< /Type /Pages /Kids [{kids}] /Count {len(pages)} >>\nendobj\n'.encode())
    
    # Font IDs: 3+pages = regular Courier, 4+pages = Courier-Bold
    font_regular_id = 3 + len(pages)
    font_bold_id = font_regular_id + 1
    
    # Page objects
    for i in range(len(pages)):
        page_id = 3 + i
        content_id = font_bold_id + 1 + i
        add_obj(f'{page_id} 0 obj\n<< /Type /Page /Parent 2 0 R /MediaBox [0 0 {page_w} {page_h}] /Contents {content_id} 0 R /Resources << /Font << /F1 {font_regular_id} 0 R /F2 {font_bold_id} 0 R >> >> >>\nendobj\n'.encode())
    
    # Font definitions
    add_obj(f'{font_regular_id} 0 obj\n<< /Type /Font /Subtype /Type1 /BaseFont /Courier >>\nendobj\n'.encode())
    add_obj(f'{font_bold_id} 0 obj\n<< /Type /Font /Subtype /Type1 /BaseFont /Courier-Bold >>\nendobj\n'.encode())
    
    # Content streams
    for i, page_lines in enumerate(pages):
        sb = []
        y = page_h - margin - 14
        sb.append(f'BT\n/F1 9 Tf\n{margin} {y} Td\n{line_height} TL'.encode())
        
        for text, is_bold, _ in page_lines:
            if not text.strip():
                sb.append(b'T*')
                continue
            
            # Switch font if needed
            if is_bold:
                sb.append(b'/F2 9 Tf')
            else:
                sb.append(b'/F1 9 Tf')
            
            safe = text.replace('\\', '\\\\').replace('(', '\\(').replace(')', '\\)')
            sb.append(f'({safe[:chars_per_line]}) Tj T*'.encode())
        
        sb.append(b'ET')
        full = b'\n'.join(sb)
        compressed = zlib.compress(full)
        cid = font_bold_id + 1 + i
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

def wrap_text(text, max_chars):
    result = []
    while len(text) > max_chars:
        brk = max_chars
        while brk > max_chars * 0.7 and brk < len(text) and not text[brk].isspace():
            brk -= 1
        if brk <= max_chars * 0.7:
            brk = max_chars
        if brk >= len(text):
            brk = len(text) - 1
        result.append(text[:brk].rstrip())
        text = text[brk:].lstrip()
    if text:
        result.append(text)
    return result if result else ['']

if __name__ == '__main__':
    WS='/workspace/bb8f9c5f-e866-4346-a29c-8d72daa0ad2d/sessions/agent_66c9dc83-0ae4-46ee-9f4d-67ca2d344f74'
    files = [
        ('CSMGeneralOutreach/COMPENDIUM-MINI.md', 'CSMEmailOutgoing/July2026/ATTACHMENTS/COMPENDIUM-MINI.pdf'),
        ('CSMGeneralOutreach/CSMGeneralOutreach-COMPILED-Compendium.md', 'CSMEmailOutgoing/July2026/ATTACHMENTS/CSMGeneralOutreach-COMPILED-Compendium.pdf'),
        ('CSMEval/11-Property-Casualty-Insurance-and-Reinsurance/CSMEval11-COMPILED-Briefing-Packet.md', 'CSMEmailOutgoing/July2026/ATTACHMENTS/CSMEval11-COMPILED-Briefing-Packet.pdf'),
    ]
    
    print('Generating styled PDFs with bold preservation...')
    for src, dst in files:
        full_src = os.path.join(WS, src)
        full_dst = os.path.join(WS, dst)
        if os.path.exists(full_src):
            size, pages = md_to_styled_pdf_v2(full_src, full_dst)
            print(f'  ✅ {dst}  ({size:.1f} KB, {pages} pages) — bold preserved')
        else:
            print(f'  ⚠️  {src} not found')
    
    print('\nPDFs regenerated with Courier-Bold formatting.')
