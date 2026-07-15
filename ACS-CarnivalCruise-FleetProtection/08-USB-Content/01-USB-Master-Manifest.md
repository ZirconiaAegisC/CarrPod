# USB Master Manifest — Fleet Hull Excellence Program Dossier

**Document Number:** ACS-CCL-FP-USB-001
**Version:** 1.0
**Date:** 15 July 2026
**Classification:** Confidential — Carnival Corporation Internal

---

## Drive Identification

- **Volume Label:** ACS-CCL-FLEET-HULL
- **File System:** exFAT (compatible with Windows 10+, macOS 12+, Linux kernel 5.4+)
- **Capacity:** 32 GB minimum (actual content ~2.8 GB)

---

## Root Directory Structure

```
X:\
├── README.txt
├── MANIFEST.txt
├── DOSSIER\
│   ├── ACS-CCL-FP-Full-Dossier.pdf (electronic master, bookmarked)
│   └── ACS-CCL-FP-Full-Dossier.docx (editable source)
├── FINANCIAL-MODEL\
│   ├── ACS-CCL-FP-Financial-Model-v1.0.xlsx
│   └── ACS-CCL-FP-Financial-Model-Assumptions.pdf
├── DATA\
│   ├── Hull-Condition-Index-Database-Q1-2026.xlsx
│   ├── Fuel-Performance-Baseline-Fleet-2024.csv
│   ├── Drydock-Schedule-2025-2035-Rev7.xlsx
│   └── AQUATERRAS-Performance-Data-2018-2025.xlsx
├── REFERENCES\
│   ├── External-Publications\ (14 PDF files)
│   └── Internal-Documents\ (4 PDF files)
├── PRESENTATION\
│   └── ACS-CCL-FP-Executive-Briefing-July-2026.pptx
├── SPECIFICATIONS\
│   └── ACS-CCL-FP-SPEC-001-Coating-Specification.docx
└── APPENDICES\
    ├── Bibliography.pdf
    └── Glossary.pdf
```

---

## File Manifest and SHA-256 Checksums

| Filename | Size (approx.) | SHA-256 Checksum | Verified |
|----------|---------------|------------------|----------|
| README.txt | 4 KB | To be populated at burn time | ☐ |
| MANIFEST.txt | 6 KB | To be populated at burn time | ☐ |
| DOSSIER/ACS-CCL-FP-Full-Dossier.pdf | 18 MB | TBP | ☐ |
| DOSSIER/ACS-CCL-FP-Full-Dossier.docx | 24 MB | TBP | ☐ |
| FINANCIAL-MODEL/ACS-CCL-FP-Financial-Model-v1.0.xlsx | 3 MB | TBP | ☐ |
| FINANCIAL-MODEL/ACS-CCL-FP-Financial-Model-Assumptions.pdf | 1 MB | TBP | ☐ |
| DATA/Hull-Condition-Index-Database-Q1-2026.xlsx | 8 MB | TBP | ☐ |
| DATA/Fuel-Performance-Baseline-Fleet-2024.csv | 12 MB | TBP | ☐ |
| DATA/Drydock-Schedule-2025-2035-Rev7.xlsx | 2 MB | TBP | ☐ |
| DATA/AQUATERRAS-Performance-Data-2018-2025.xlsx | 6 MB | TBP | ☐ |
| REFERENCES/External-Publications/* (14 files) | 380 MB | Per-file checksums on disk | ☐ |
| REFERENCES/Internal-Documents/* (4 files) | 45 MB | Per-file checksums on disk | ☐ |
| PRESENTATION/ACS-CCL-FP-Executive-Briefing-July-2026.pptx | 22 MB | TBP | ☐ |
| SPECIFICATIONS/ACS-CCL-FP-SPEC-001-Coating-Specification.docx | 2 MB | TBP | ☐ |
| APPENDICES/Bibliography.pdf | 1 MB | TBP | ☐ |
| APPENDICES/Glossary.pdf | 1 MB | TBP | ☐ |

**Total content:** ~530 MB (excludes USB drive formatting overhead)

---

## USB Burn Procedure

1. Format USB drive to exFAT file system with volume label ACS-CCL-FLEET-HULL.
2. Copy the complete directory tree from the master build location to the USB root.
3. Verify that all directories, files, and the README.txt at root level are present and match the structure above.
4. Run a virus scan on the complete USB drive (Windows Defender or corporate-standard antivirus).
5. Compute SHA-256 checksums for all files. Populate the checksum column in this manifest. Save the completed manifest as MANIFEST.txt at the USB root.
6. Set all files to read-only attribute.
7. Eject the USB drive safely. Verify on a second machine — open the PDF dossier and at least three data files to confirm file integrity.
8. Insert the verified USB drive into the Tyvek sleeve affixed to the inside back cover of the bound dossier copy.

---

**Document Control**
- Prepared by: Advanced Coatings Strategy Group
- Reviewed by: [Pending]
- Version: 1.0
- USB burn date: To be determined
