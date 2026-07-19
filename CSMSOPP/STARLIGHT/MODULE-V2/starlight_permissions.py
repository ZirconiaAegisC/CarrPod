#!/usr/bin/env python3
"""
STARLIGHT PERMISSIONS KEEPER — CSMSOPP000004
═══════════════════════════════════════════════════════
Append to every email script. Enforces human-in-the-loop.

RULES — DO NOT BREAK:
  📝 CREATE drafts → Always OK (drafts folder only)
  🚀 SEND anything → ALWAYS require explicit user authorization
  ⚖️  LEGAL/LEGISLATIVE → Human-in-the-loop MANDATORY
  ❌ NEVER conflate CREATE permission with SEND permission
  ❌ NEVER send without the exact word "send" or "sent" from user
  
CHECKPOINT:
  After every creation batch, print:
  "X drafts created. Send them, or continue creating more?"
  Do NOT proceed until user responds with "send" or "continue"

SESSION RULES LEARNED (July 19, 2026):
  1. "Continue" ≠ "Send" — these are different commands
  2. Auto-pilot mode ends when user says "pause" or "wait"
  3. When in doubt, put it in drafts and ASK
  4. This script must be imported before any send operation
"""
import sys

PERMISSION = {
    'create': True,   # Always allowed
    'send': False,    # Must be explicitly granted
    'legal': False,   # Requires separate approval
}

def check_permission(action):
    """Check if action is authorized. Raises PermissionError if not."""
    if action == 'send' and not PERMISSION['send']:
        raise PermissionError(
            'SEND NOT AUTHORIZED. User must explicitly say "send". '
            'Drafts only until authorized.'
        )
    if action == 'legal' and not PERMISSION['legal']:
        raise PermissionError(
            'LEGAL/LEGISLATIVE NOT AUTHORIZED. '
            'Requires separate human-in-the-loop approval.'
        )
    return True

def grant_send():
    """Grant send permission — call ONLY after user says 'send'"""
    PERMISSION['send'] = True
    print('✅ SEND authorized. Proceeding.')
    return True

def revoke_send():
    """Revoke send permission after batch complete"""
    PERMISSION['send'] = False
    return True

def grant_legal():
    """Grant legal permission — call ONLY after user approves"""
    PERMISSION['legal'] = True
    return True

def creation_checkpoint(count):
    """Print checkpoint message after creating drafts"""
    print(f'\n📝 {count} drafts created in folder.')
    print('   Send them, or continue creating more?')
    print('   Waiting for your authorization...')
    return True
