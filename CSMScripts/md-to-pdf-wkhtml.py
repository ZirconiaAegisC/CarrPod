#!/usr/bin/env python3
"""MD → Beautiful PDF via wkhtmltopdf. Real bold, real headers, real bullet lists.
   Converts Markdown to styled HTML, then renders via WebKit engine."""

import subprocess, os, re, sys

def md_to_html(md_text):
    """Convert markdown to styled HTML suitable for PDF rendering."""
    lines = md_text.split('\n')
    html = ['<!DOCTYPE html><html><head><meta charset="utf-8"><style>',
            'body{font-family:"Helvetica Neue",Helvetica,Arial,sans-serif;font-size:11pt;color:#1a1a1a;line-height:1.5;margin:40px 50px;}',
            'h1{font-size:18pt;color:#1a3a5c;border-bottom:2px solid #1a3a5c;padding-bottom:6px;margin-top:24px;}',
            'h2{font-size:14pt;color:#2a5a8c;border-bottom:1px solid #ccc;padding-bottom:4px;margin-top:20px;}',
            'h3{font-size:12pt;color:#3a6a9c;margin-top:16px;}',
            'strong{color:#1a3a5c;}',
            'hr{border:1px solid #ddd;margin:16px 0;}',
            'li{margin:4px 0;}',
            'ul{margin:4px 0 12px 0;padding-left:20px;}',
            'ol{margin:4px 0 12px 0;padding-left:20px;}',
            'p{margin:6px 0;}',
            'code{background:#f0f0f0;padding:1px 4px;font-family:"Courier New",monospace;font-size:9pt;}',
            'pre{background:#f5f5f5;padding:8px 12px;border:1px solid #ddd;font-size:9pt;}',
            '</style></head><body>']
    
    in_list = False
    in_ol = False
    
    for line in lines:
        stripped = line.rstrip()
        
        if not stripped:
            if in_list:
                html.append('</ul>')
                in_list = False
            if in_ol:
                html.append('</ol>')
                in_ol = False
            continue
        
        # Separators
        if re.match(r'^[-=]{10,}', stripped):
            if in_list: html.append('</ul>'); in_list = False
            if in_ol: html.append('</ol>'); in_ol = False
            html.append('<hr>')
            continue
        
        # Headers
        if stripped.startswith('### '):
            if in_list: html.append('</ul>'); in_list = False
            if in_ol: html.append('</ol>'); in_ol = False
            html.append(f'<h3>{stripped[4:]}</h3>')
            continue
        if stripped.startswith('## '):
            if in_list: html.append('</ul>'); in_list = False
            if in_ol: html.append('</ol>'); in_ol = False
            html.append(f'<h2>{stripped[3:]}</h2>')
            continue
        if stripped.startswith('# '):
            if in_list: html.append('</ul>'); in_list = False
            if in_ol: html.append('</ol>'); in_ol = False
            html.append(f'<h1>{stripped[2:]}</h1>')
            continue
        
        # Bullet lists: - or * or +
        if re.match(r'^[-*+]\s', stripped):
            if in_ol: html.append('</ol>'); in_ol = False
            if not in_list:
                html.append('<ul>')
                in_list = True
            content = re.sub(r'^[-*+]\s+', '', stripped)
            content = inline_format(content)
            html.append(f'<li>{content}</li>')
            continue
        
        # Numbered lists
        if re.match(r'^\d+\.\s', stripped):
            if in_list: html.append('</ul>'); in_list = False
            if not in_ol:
                html.append('<ol>')
                in_ol = True
            content = re.sub(r'^\d+\.\s+', '', stripped)
            content = inline_format(content)
            html.append(f'<li>{content}</li>')
            continue
        
        # Bullet with unicode
        if stripped.startswith('• '):
            if in_ol: html.append('</ol>'); in_ol = False
            if not in_list:
                html.append('<ul>')
                in_list = True
            content = inline_format(stripped[2:])
            html.append(f'<li>{content}</li>')
            continue
        
        # Code blocks
        if stripped.startswith('    ') or stripped.startswith('\t'):
            if in_list: html.append('</ul>'); in_list = False
            if in_ol: html.append('</ol>'); in_ol = False
            html.append(f'<pre>{stripped}</pre>')
            continue
        
        # Regular paragraph
        if in_list: html.append('</ul>'); in_list = False
        if in_ol: html.append('</ol>'); in_ol = False
        content = inline_format(stripped)
        if content:
            html.append(f'<p>{content}</p>')
    
    if in_list: html.append('</ul>')
    if in_ol: html.append('</ol>')
    html.append('</body></html>')
    return '\n'.join(html)


def inline_format(text):
    """Convert inline markdown to HTML."""
    # Bold: **text**
    text = re.sub(r'\*\*(.+?)\*\*', r'<strong>\1</strong>', text)
    # Italic: *text*
    text = re.sub(r'\*(.+?)\*', r'<em>\1</em>', text)
    # Inline code: `text`
    text = re.sub(r'`(.+?)`', r'<code>\1</code>', text)
    return text


def md_to_pdf(input_path, output_path):
    with open(input_path) as f:
        md = f.read()
    
    html = md_to_html(md)
    
    # Write temp HTML
    tmp_html = output_path.replace('.pdf', '.tmp.html')
    with open(tmp_html, 'w') as f:
        f.write(html)
    
    # Convert via wkhtmltopdf
    result = subprocess.run([
        'wkhtmltopdf', '--quiet', '--page-size', 'A4',
        '--margin-top', '15mm', '--margin-bottom', '15mm',
        '--margin-left', '12mm', '--margin-right', '12mm',
        '--encoding', 'UTF-8',
        tmp_html, output_path
    ], capture_output=True, text=True)
    
    # Cleanup
    if os.path.exists(tmp_html):
        os.unlink(tmp_html)
    
    if result.returncode != 0:
        print(f'  ERROR: {result.stderr[:200]}')
        return None
    
    size_kb = os.path.getsize(output_path) / 1024
    return size_kb


if __name__ == '__main__':
    files = [
        ('CSMGeneralOutreach/COMPENDIUM-MINI.md', 'CSMEmailOutgoing/July2026/ATTACHMENTS/COMPENDIUM-MINI.pdf'),
        ('CSMGeneralOutreach/CSMGeneralOutreach-COMPILED-Compendium.md', 'CSMEmailOutgoing/July2026/ATTACHMENTS/CSMGeneralOutreach-COMPILED-Compendium.pdf'),
        ('CSMEval/11-Property-Casualty-Insurance-and-Reinsurance/CSMEval11-COMPILED-Briefing-Packet.md', 'CSMEmailOutgoing/July2026/ATTACHMENTS/CSMEval11-COMPILED-Briefing-Packet.pdf'),
    ]
    
    print('MD → Beautiful PDF (wkhtmltopdf)')
    for src, dst in files:
        if os.path.exists(src):
            size = md_to_pdf(src, dst)
            if size:
                print(f'  {dst}  ({size:.1f} KB)')
            else:
                print(f'  FAILED: {src}')
    
    print('\nDone.')
