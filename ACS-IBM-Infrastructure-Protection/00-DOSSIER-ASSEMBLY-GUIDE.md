# DOSSIER ASSEMBLY GUIDE

**Document Classification:** ACS Internal — Reference
**Reference:** ACS-IBM-IP-2026-001
**Version:** 1.0
**Date:** July 2026

---

## Purpose

This guide provides the complete assembly instructions for the ACS-IBM Infrastructure Protection dossier. It defines the directory structure, physical and digital assembly procedures, document ordering, and quality control checklist.

---

## Directory Structure

```
ACS-IBM-Infrastructure-Protection/
├── 00-DOSSIER-COVER-LETTER.md
├── 00-SIGNATURE-PAGE.md
├── 00-DOSSIER-ASSEMBLY-GUIDE.md         ← THIS DOCUMENT
├── 05-Implementation-Roadmap/
│   ├── 01-Program-Framework.md
│   └── 02-Technology-Timeline.md
├── 06-Research-Archive/
│   └── 01-Research-Memorandum.md
├── 07-Appendices/
│   ├── 01-Research-Bibliography.md
│   └── 02-Glossary.md
└── 08-USB-Content/
    ├── 01-USB-Master-Manifest.md
    └── 02-README.txt
```

---

## Document Ordering for Physical Assembly

The dossier is to be assembled in a single bound volume with tabbed dividers. Document order:

### Volume 1: Primary Documents

| Tab | Document | Description |
|---|---|---|
| 1 | 00-DOSSIER-COVER-LETTER.md | Cover letter to IBM executive leadership |
| 2 | 00-SIGNATURE-PAGE.md | Signature page for ACS and IBM executives |
| 3 | 05-Implementation-Roadmap/01-Program-Framework.md | Five-phase implementation framework (250+ lines) |
| 4 | 05-Implementation-Roadmap/02-Technology-Timeline.md | IBM technology timeline 2026–2035 (150+ lines) |
| 5 | 06-Research-Archive/01-Research-Memorandum.md | Research memorandum synthesizing 70+ sources (200+ lines) |

### Volume 1: Appendices

| Tab | Document | Description |
|---|---|---|
| A | 07-Appendices/01-Research-Bibliography.md | Full bibliography (70+ citations) |
| B | 07-Appendices/02-Glossary.md | Glossary of 50+ technical terms |

### Accompanying Materials

| Item | Content | Reference |
|---|---|---|
| USB Drive A | Digital dossier files, supplementary research, patent documents, and reference materials | 08-USB-Content/01-USB-Master-Manifest.md |
| USB Drive B | Encrypted backup of USB Drive A | — |

---

## Physical Assembly Specifications

- **Format:** Letter size (8.5" × 11"), double-sided printing.
- **Binding:** Three-ring binder with clear front cover pocket for cover sheet.
- **Paper:** 24 lb bright white, acid-free archival quality.
- **Tabs:** 5-tab set for Volume 1 primary documents; 2-tab set for Appendices.
- **Cover:** Clear acetate front; navy blue linen-textured back cover. ACS logo centered on front cover.
- **Spine Insert:** "ACS-IBM Infrastructure Protection — Quantum & AI Leadership Program — July 2026 — ACS Internal — Confidential."
- **Enclosure:** USB Drive A and USB Drive B in adhesive-backed sleeve affixed to inside back cover.

---

## Digital Assembly Instructions

1. All documents are authored in Markdown (`.md`) format for version control compatibility. Conversion to PDF for physical assembly is via the `pandoc` toolchain using the Eisvogel template with ACS corporate styling.

2. Document filenames follow the convention: `[two-digit section]-[descriptive-title].[extension]`. Section prefixes: `00` = front matter, `05` = implementation roadmap, `06` = research archive, `07` = appendices, `08` = USB content.

3. All documents include a Document Control table at the end recording version, date, author, and changes.

4. Cross-references between documents use the relative path from the dossier root, e.g., `05-Implementation-Roadmap/01-Program-Framework.md`.

---

## Quality Control Checklist

Before delivery to IBM executive leadership, verify the following:

- [ ] All documents present and accounted for per the directory structure.
- [ ] No placeholder text, template fields, or "FIXME" comments remain.
- [ ] All IBM product names, trademarks, and version numbers are accurate as of July 2026.
- [ ] All financial figures have been reviewed by ACS Legal and Finance.
- [ ] Classification markings ("ACS Internal — Confidential") appear on every document.
- [ ] Signature pages are properly formatted with name, title, and date lines.
- [ ] USB drives (A and B) loaded with full digital dossier and verified.
- [ ] USB README.txt is reader-friendly plain-text with no markup.
- [ ] Physical binder assembled with correct tab ordering and spine insert.
- [ ] Second copy produced for ACS archive at Infrastructure Protection headquarters.

---

## Document Control

| Version | Date | Author | Changes |
|---|---|---|---|
| 1.0 | July 2026 | ACS Infrastructure Protection | Initial assembly guide |
