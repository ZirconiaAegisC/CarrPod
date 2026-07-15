# USB Master Manifest — ACS-IBM Infrastructure Protection Dossier

**Document Classification:** ACS Internal — Confidential
**Reference:** ACS-IBM-IP-2026-001-USB
**Version:** 1.0
**Date:** July 2026

---

## Drive Identification

| Property | Value |
|---|---|
| Volume Label | ACS-IBM-IP-2026-001 |
| Drive Serial | [TO BE RECORDED AT BURN TIME] |
| Capacity | 64 GB USB 3.2 Gen 1 |
| File System | exFAT |
| Encryption | AES-256 (LUKS2), passphrase delivered separately via secure channel |
| Integrity Hash | SHA-256 of root directory tree, stored in MANIFEST.sha256 |

---

## Root Directory Structure

```
ACS-IBM-IP-2026-001/
├── README.txt
├── MANIFEST.sha256
├── 01-Dossier-Documents/
│   ├── 00-DOSSIER-COVER-LETTER.pdf
│   ├── 00-SIGNATURE-PAGE.pdf
│   ├── 05-Implementation-Roadmap/
│   │   ├── 01-Program-Framework.pdf
│   │   └── 02-Technology-Timeline.pdf
│   ├── 06-Research-Archive/
│   │   └── 01-Research-Memorandum.pdf
│   └── 07-Appendices/
│       ├── 01-Research-Bibliography.pdf
│       └── 02-Glossary.pdf
├── 02-Supplementary-Research/
│   ├── IBM-2025-10K-Excerpts.pdf
│   ├── IBM-2026-Q1-10Q-Excerpts.pdf
│   ├── IBM-Quantum-Roadmap-2026-Annotated.pdf
│   ├── Nature-2024-qLDPC-Bravyi-et-al.pdf
│   ├── ISSCC-2026-Cryo-CMOS-Plenary.pdf
│   ├── CBRE-2026-Data-Center-Trends-Report.pdf
│   ├── Gartner-2026-Mainframe-Market-Forecast.pdf
│   └── NIST-PQC-Standards-FIPS-203-204-205.pdf
├── 03-Patent-Analysis/
│   └── IBM-Quantum-Patent-Portfolio-Analysis-2026.pdf
├── 04-Financial-Models/
│   └── ACS-IBM-IP-Program-Budget-Model.xlsx
├── 05-Presentations/
│   └── ACS-IBM-Infrastructure-Protection-Executive-Briefing.pptx
└── 06-Technical-Specifications/
    ├── Lightwell-Platform-Architecture-v1.0.pdf
    ├── Anderon-Foundry-Site-Specification-v1.0.pdf
    └── Nighthawk-Quantum-Advantage-Test-Plan-v1.0.pdf
```

---

## File Count and Size Summary

| Directory | Files | Estimated Size |
|---|---|---|
| 01-Dossier-Documents | 7 | 12 MB |
| 02-Supplementary-Research | 8 | 85 MB |
| 03-Patent-Analysis | 1 | 15 MB |
| 04-Financial-Models | 1 | 3 MB |
| 05-Presentations | 1 | 25 MB |
| 06-Technical-Specifications | 3 | 45 MB |
| **Total** | **21** | **~185 MB** |

---

## Integrity Verification

To verify the integrity of the USB content, execute the following command from the root of the mounted volume:

```bash
sha256sum -c MANIFEST.sha256
```

All files listed in MANIFEST.sha256 must report "OK" status before the USB content is considered authentic and complete.

---

## Document Control

| Version | Date | Author | Changes |
|---|---|---|---|
| 1.0 | July 2026 | ACS Infrastructure Protection | Initial USB manifest |
