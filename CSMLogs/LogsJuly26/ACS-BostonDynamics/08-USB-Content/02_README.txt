================================================================================
ACS-BostonDynamics-Robotics-Fleet — USB Access Instructions
================================================================================

CLASSIFICATION: ACS Internal — Confidential
DATE: 15 July 2026
MEDIA SERIAL: ACS-BD-2026-0715-01

================================================================================
BEFORE YOU BEGIN
================================================================================

This USB drive contains a classified ACS dossier on Boston Dynamics, Inc.
and its robotics fleet (Spot, Stretch, Atlas) with supporting analysis on
the Orbit software platform, Hyundai Motor Group manufacturing integration,
financial models, and IPO valuation analysis.

DO NOT:
  - Connect this drive to any network-connected device
  - Copy files to cloud storage, email, or messaging platforms
  - Share this drive or its contents outside the authorized engagement team
  - Leave this drive unattended in unsecured locations

================================================================================
DRIVE ENCRYPTION
================================================================================

This drive is encrypted with LUKS2 (AES-256-XTS).

The decryption passphrase has been transmitted to the engagement lead via
a separate secure channel. Contact the ACS Information Security Officer
if you have not received the passphrase.

================================================================================
FILE FORMAT
================================================================================

All files are plain-text Markdown (.md / .txt) with UTF-8 encoding and
Unix-style (LF) line endings.

Files can be read with:
  - Any text editor (VS Code, Sublime Text, Notepad++, vim, etc.)
  - Any Markdown viewer or renderer
  - Standard Unix tools (less, cat, grep)

================================================================================
DRIVE CONTENTS
================================================================================

01-Executive-Summary/       — Dossier overview, key findings, recommendations
02-Corporate-Profile/       — BD corporate history, ownership, products
03-Technical-Framework/     — Five platform deep-dives (Spot, Stretch, Atlas,
                               Orbit, Hyundai integration)
04-Financial-Analysis/      — Revenue models, TCO analysis, IPO valuation
05-Implementation-Roadmap/  — Three-phase ACS engagement framework
06-Research-Archive/        — Research methodology and market context
07-Appendices/              — Bibliography and glossary
08-USB-Content/             — This manifest and README

See 08-USB-Content/01_USB_Manifest.md for the complete file inventory.

================================================================================
READING ORDER
================================================================================

First-time readers should follow this sequence:

1.  01-Executive-Summary/01_Executive_Summary.md
2.  02-Corporate-Profile/01_BostonDynamics_Corporate_Profile.md
3.  03-Technical-Framework/ (all files, in numbered order)
4.  04-Financial-Analysis/ (all files, in numbered order)
5.  05-Implementation-Roadmap/01_Program_Framework.md
6.  06-Research-Archive/01_Research_Memorandum.md
7.  07-Appendices/ (as reference)
8.  08-USB-Content/01_USB_Manifest.md

================================================================================
INTEGRITY VERIFICATION
================================================================================

Before accessing files, verify drive integrity:

1. Open a terminal in the USB root directory.
2. Run: sha256sum -c ACS-BD-2026-0715-01.hash
3. All files must return "OK".
4. If any file fails verification, DO NOT OPEN IT. Contact ACS InfoSec.

To verify the manifest signature:
  gpg --verify ACS-BD-2026-0715-01.asc ACS-BD-2026-0715-01.hash

================================================================================
QUESTIONS
================================================================================

Engagement Lead: [Contact information distributed separately]
ACS Information Security: [Contact information distributed separately]

================================================================================
END OF README
================================================================================
