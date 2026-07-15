# 01 — USB MASTER MANIFEST

## 08-USB-Content | ACS-CalState-Infrastructure-Protection Dossier

---

### DEVICE SPECIFICATIONS

| Attribute | Value |
|---|---|
| Device | Kingston DataTraveler Vault Privacy 3.0 |
| Capacity | 64 GB |
| Encryption | AES 256-bit XTS mode, hardware-based |
| Authentication | Complex alphanumeric passphrase (8+ characters) |
| Volume Label | ACS-CSU-INFRA-PROTECTION-2026 |
| Serial Number | [Recorded on physical device label] |
| Date Imaged | July 15, 2026 |
| Prepared By | ACS Infrastructure Protection Division — IT Security |

---

### DIRECTORY STRUCTURE

```
ACS-CSU-INFRA-2026/
│
├── 00-Dossier-Frontmatter/
│   ├── 00-DOSSIER-COVER-LETTER.md
│   ├── 00-DOSSIER-COVER-LETTER.pdf
│   ├── 00-SIGNATURE-PAGE.md
│   ├── 00-SIGNATURE-PAGE.pdf
│   └── 00-DOSSIER-ASSEMBLY-GUIDE.md
│
├── 03-Technical-Framework/
│   ├── 01-Deferred-Maintenance-Management.md
│   ├── 01-Deferred-Maintenance-Management.pdf
│   ├── 02-Seismic-Safety-Infrastructure.md
│   ├── 02-Seismic-Safety-Infrastructure.pdf
│   ├── 03-Campus-Energy-Modernization.md
│   ├── 03-Campus-Energy-Modernization.pdf
│   ├── 04-Enrollment-Aligned-Facilities.md
│   └── 04-Enrollment-Aligned-Facilities.pdf
│
├── 04-Financial-Analysis/
│   ├── 01-Capital-Funding-Model.md
│   ├── 01-Capital-Funding-Model.pdf
│   ├── 02-Deferred-Maintenance-Economics.md
│   ├── 02-Deferred-Maintenance-Economics.pdf
│   ├── 03-Energy-Savings-Analysis.md
│   └── 03-Energy-Savings-Analysis.pdf
│
├── 05-Implementation-Roadmap/
│   ├── 01-Program-Framework.md
│   ├── 01-Program-Framework.pdf
│   ├── 02-Campus-Prioritization.md
│   └── 02-Campus-Prioritization.pdf
│
├── 06-Research-Archive/
│   ├── 01-Research-Memorandum.md
│   └── 01-Research-Memorandum.pdf
│
├── 07-Appendices/
│   ├── 01-Research-Bibliography.md
│   ├── 01-Research-Bibliography.pdf
│   ├── 02-Glossary.md
│   └── 02-Glossary.pdf
│
├── 08-USB-Content/
│   ├── 01-USB-Master-Manifest.md
│   └── 02-README.txt
│
└── _MANIFEST.SHA256
```

---

### FILE INVENTORY

| # | File Name | Format | Size (KB) | SHA-256 Checksum |
|---|---|---|---|---|
| 1 | 00-DOSSIER-COVER-LETTER.md | Markdown | — | [Generated at imaging] |
| 2 | 00-DOSSIER-COVER-LETTER.pdf | PDF | — | [Generated at imaging] |
| 3 | 00-SIGNATURE-PAGE.md | Markdown | — | [Generated at imaging] |
| 4 | 00-SIGNATURE-PAGE.pdf | PDF | — | [Generated at imaging] |
| 5 | 00-DOSSIER-ASSEMBLY-GUIDE.md | Markdown | — | [Generated at imaging] |
| 6 | 01-Deferred-Maintenance-Management.md | Markdown | — | [Generated at imaging] |
| 7 | 01-Deferred-Maintenance-Management.pdf | PDF | — | [Generated at imaging] |
| 8 | 02-Seismic-Safety-Infrastructure.md | Markdown | — | [Generated at imaging] |
| 9 | 02-Seismic-Safety-Infrastructure.pdf | PDF | — | [Generated at imaging] |
| 10 | 03-Campus-Energy-Modernization.md | Markdown | — | [Generated at imaging] |
| 11 | 03-Campus-Energy-Modernization.pdf | PDF | — | [Generated at imaging] |
| 12 | 04-Enrollment-Aligned-Facilities.md | Markdown | — | [Generated at imaging] |
| 13 | 04-Enrollment-Aligned-Facilities.pdf | PDF | — | [Generated at imaging] |
| 14 | 01-Capital-Funding-Model.md | Markdown | — | [Generated at imaging] |
| 15 | 01-Capital-Funding-Model.pdf | PDF | — | [Generated at imaging] |
| 16 | 02-Deferred-Maintenance-Economics.md | Markdown | — | [Generated at imaging] |
| 17 | 02-Deferred-Maintenance-Economics.pdf | PDF | — | [Generated at imaging] |
| 18 | 03-Energy-Savings-Analysis.md | Markdown | — | [Generated at imaging] |
| 19 | 03-Energy-Savings-Analysis.pdf | PDF | — | [Generated at imaging] |
| 20 | 01-Program-Framework.md | Markdown | — | [Generated at imaging] |
| 21 | 01-Program-Framework.pdf | PDF | — | [Generated at imaging] |
| 22 | 02-Campus-Prioritization.md | Markdown | — | [Generated at imaging] |
| 23 | 02-Campus-Prioritization.pdf | PDF | — | [Generated at imaging] |
| 24 | 01-Research-Memorandum.md | Markdown | — | [Generated at imaging] |
| 25 | 01-Research-Memorandum.pdf | PDF | — | [Generated at imaging] |
| 26 | 01-Research-Bibliography.md | Markdown | — | [Generated at imaging] |
| 27 | 01-Research-Bibliography.pdf | PDF | — | [Generated at imaging] |
| 28 | 02-Glossary.md | Markdown | — | [Generated at imaging] |
| 29 | 02-Glossary.pdf | PDF | — | [Generated at imaging] |
| 30 | 01-USB-Master-Manifest.md | Markdown | — | [Generated at imaging] |
| 31 | 02-README.txt | Plain Text | — | [Generated at imaging] |
| 32 | _MANIFEST.SHA256 | Plain Text | — | [Generated at imaging] |

**Total Files: 32 (17 Markdown + 14 PDF + 1 README + 1 Manifest)**
**Checksums generated using: `sha256sum` (GNU coreutils)**

---

### VERIFICATION PROCEDURE

1. Mount USB drive on a Linux or macOS system with FUSE/exFAT support
2. Enter passphrase when prompted by hardware encryption controller
3. Navigate to root directory: `/Volumes/ACS-CSU-INFRA-PROTECTION-2026/` (macOS) or `/media/ACS-CSU-INFRA-PROTECTION-2026/` (Linux)
4. Run: `sha256sum -c _MANIFEST.SHA256`
5. Verify all 32 files pass checksum validation
6. If any file fails validation, the USB image is corrupt — contact ACS IT Security at security@acs-ca.com

---

### SECURITY NOTICE

This USB drive contains proprietary financial projections and infrastructure vulnerability assessments produced under contract CSU-RFP-2024-INFRA-0047. The contents are classified SENSITIVE — FOR OFFICIAL USE ONLY. Unauthorized copying, distribution, or access is prohibited. The hardware encryption passphrase is communicated separately via secure channel. Lost or compromised drives must be reported immediately to ACS IT Security at (213) 555-0199.

---

*Section 08 — File 01 of 02 | Version 2.4 | July 15, 2026*
*Security Classification: SENSITIVE — FOR OFFICIAL USE ONLY*
