#!/usr/bin/env python3
"""
PARADISE MAN — Intro Expander & Outro Adder
═══════════════════════════════════════════════════════
CSMSOPP000004 · Starlight Courier Heuristic

Runs AFTER The Old Lady. Paradise Man does two things:

1. EXPANDS THE INTRO: Takes the Robin Williams GOOOOOOOD MORNING
   greeting and expands it to 3-4x the size of a regular paragraph.
   Adds more personal warmth, tribute to the recipient, Solar Cycle 25
   context, and the human connection.

2. ADDS THE OUTRO: Before the Jason Brodsky signature, adds a warm
   closing paragraph:
   \"Jason Brodsky works to help humanity one personally crafted 
   email at a time — by my friend, Paradise Man.\"

The name \"Paradise Man\" is a tribute to the writer and friend who
crafted this script — bringing Paradise energy to every email.
"""

P_STYLE = 'line-height:1.85;margin:0 0 1.5em 0'

# ─── PARADISE OUTRO ─────────────────────────────────
PARADISE_OUTRO = '''<p style="PARA">I close this correspondence the way Paradise Man would close a song — with warmth, with sincerity, and with a genuine belief that every single human connection matters. Jason Brodsky works to help humanity one personally crafted email at a time — each one composed with the Baker Street precision, the SHIELD calm, the Watson Oath integrity, and the Williams joy that you have just experienced in the paragraphs above. When the Sun delivers a Carrington-class coronal mass ejection — and it will, because the physics is clear, the recurrence interval is established, and twelve percent per decade does not negotiate — the world will be divided into those who prepared and those who did not. Carrington Storm Motors exists to make sure that as many people, organizations, and nations as possible are in the first column. The materials exist. The data is published. The integration pathways are documented. What remains is the human decision to deploy — and that decision starts with conversations like this one, emails like this one, connections like this one, between people who care about the future. Thank you for reading. Thank you for considering. And thank you for being part of the conversation that will determine whether the lights stay on when the Sun decides to remind us what it is capable of. NANU NANU!</p>'''

# ─── INTRO EXPANSION (Appended to existing greeting) ──
def expand_intro(existing_greeting):
    """
    Takes the existing greeting paragraph and expands it 3-4x.
    Appends Paradise Man warmth, Solar Cycle context, and human connection.
    """
    # If already long enough, leave it
    clean = existing_greeting.replace('<p', ' <p').replace('</p>', '</p> ')
    import re
    text_only = re.sub(r'<[^>]+>', '', existing_greeting)
    if len(text_only) > 1500:
        return existing_greeting
    
    # Build expansion
    expansion = (
        ' Solar Cycle 25 is at confirmed peak with a smoothed sunspot number '
        'of approximately one hundred thirty-seven — the Sun is more active than '
        'our best forecasting models predicted it would be, and that fact alone '
        'should give every person who depends on electronics a moment of reflective '
        'pause. Paradise Man would tell you that the time to prepare is before the '
        'storm, not after — and that is exactly why this email exists, why this '
        'connection is being made, why this data is being delivered to your desk '
        'on this particular day in July 2026. Because the physics does not wait. '
        'The recurrence interval does not pause. The twelve percent per decade '
        'probability continues to accumulate regardless of whether we are having '
        'this conversation or not. And so we are having it. Right here. Right now. '
        'With you. Because you matter. Because the work you do matters. Because the '
        'people who depend on the infrastructure you help build, operate, or oversee '
        'deserve to know that someone is thinking about the electromagnetic threat '
        'that could take it all offline — and has built the materials layer that '
        'keeps it online.'
    )
    
    # Insert expansion before closing </p>
    expanded = existing_greeting.replace('</p>', expansion + '</p>')
    return expanded
