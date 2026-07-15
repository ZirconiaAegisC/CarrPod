# USB Key Master Content Manifest

## Fleet Bridge Protection & Retrofit Program
### Version 1.0 — July 2026

---

## 1. General Information

| Field | Value |
|---|---|
| USB Identifier | TYLIN-FBP-2026-07 |
| Total Capacity Required | 32 GB minimum (64 GB recommended) |
| File System | exFAT |
| Volume Label | FLEET_BRIDGE_PROTECTION |
| SHA-256 Checksum File | /MANIFEST-SHA256.txt |
| Copy | [N] of 5 |

---

## 2. Root Directory Structure

```
FLEET_BRIDGE_PROTECTION/
├── README.txt                                          # USB root instructions
├── MANIFEST-SHA256.txt                                 # Checksums for all files
├── 00-Front-Matter/
│   ├── 00-DOSSIER-COVER-LETTER.pdf                     # Cover letter (Matthew G. Cummings, et al.)
│   ├── 00-SIGNATURE-PAGE.pdf                           # Authorization and receipt
│   ├── 00-DOSSIER-ASSEMBLY-GUIDE.pdf                   # Assembly and distribution instructions
│   └── 00-TABLE-OF-CONTENTS.pdf                        # Master table of contents
├── 01-Executive-Summary/
│   └── 01-Executive-Summary.pdf                        # Standalone executive summary
├── 02-Technical-Foundation/
│   └── 02-Technical-Foundation.pdf                     # Corrosion science, degradation mechanisms
├── 03-Coating-Systems/
│   ├── 03-Coating-Systems.pdf                          # Coating selection, comparison matrices
│   └── Appendix-3A-Specification-Templates.pdf         # Coating specification language
├── 04-Cathodic-Protection/
│   ├── 04-Cathodic-Protection.pdf                      # CP system design and protocols
│   └── Appendix-4A-Anode-Selection-Matrices.pdf        # Anode material selection
├── 05-Fleet-Condition-Assessment/
│   ├── 05-Fleet-Condition-Assessment.pdf               # Tiered inspection methodology
│   └── Appendix-5A-Inspection-Data-Forms.pdf            # Field data collection templates
├── 06-Research-Archive/
│   ├── 01-Research-Memorandum.pdf                      # Research synthesis memorandum
│   ├── Standards-Index.pdf                             # Index of AASHTO, AMPP, FHWA, ISO standards
│   ├── Bibliography-Full.pdf                           # Complete annotated bibliography
│   └── Case-Studies.pdf                                # Domestic and international case studies
├── 07-Lifecycle-Cost-Models/
│   ├── 07-Lifecycle-Cost-Models.pdf                    # NPV models, cost-benefit analysis
│   ├── Cost-Model-Template.xlsx                        # Editable cost spreadsheet model
│   └── Scenario-Analysis.xlsx                          # Multi-scenario sensitivity analysis
├── 08-Implementation-Roadmap/
│   ├── 08-Implementation-Roadmap.pdf                   # Phased deployment strategy
│   └── Gantt-Chart-Implementation.pdf                  # Timeline visualization
├── 09-Regulatory-Funding/
│   ├── 09-Regulatory-Funding.pdf                       # FHWA, Cal/OSHA, Buy America, IIJA
│   └── Funding-Matrix.xlsx                             # Grant program eligibility matrix
├── 10-Risk-Resilience/
│   └── 10-Risk-Resilience.pdf                          # Seismic, climate, supply chain risks
├── 11-Appendices/
│   ├── Appendix-A-Glossary.pdf                         # Technical terminology
│   ├── Appendix-B-Contractor-Qualifications.pdf        # Applicator and installer criteria
│   ├── Appendix-C-Bridge-Inventory-Template.xlsx        # Fleet inventory data structure
│   └── Appendix-D-Reference-Standards-Catalog.pdf      # Full standards catalog
├── Presentation/
│   ├── Executive-Briefing.pptx                         # Executive presentation deck
│   ├── Technical-Deep-Dive.pptx                        # Technical presentation deck
│   └── Client-Pitch-Template.pptx                      # Agency client presentation template
├── Data/
│   ├── Bridge-Inspection-Summaries/                    # Publicly available inspection reports
│   │   ├── Bay-Bridge-East-Span.pdf
│   │   ├── Benicia-Martinez-Bridge.pdf
│   │   ├── Golden-Gate-Bridge-Summary.pdf
│   │   ├── Richmond-San-Rafael-Bridge.pdf
│   │   └── San-Mateo-Hayward-Bridge.pdf
│   ├── Cost-Data/
│   │   ├── FDOT-CP-Cost-Data.pdf                       # Florida DOT CP economic data
│   │   ├── Oregon-DOT-CP-Program-Data.pdf              # Oregon coastal bridge CP data
│   │   └── Norway-TSZ-Cost-Records.pdf                 # Norwegian duplex coating cost history
│   └── Standards-Library/
│       ├── AMPP-Standards-Index.pdf
│       ├── AASHTO-LRFD-Bridge-Design-References.pdf
│       └── FHWA-Technical-Advisories-Index.pdf
└── Templates/
    ├── Inspection-Report-Template.docx
    ├── Cost-Estimate-Template.xlsx
    ├── Specification-Shell.docx
    └── Program-Metrics-Dashboard.xlsx
```

---

## 3. File Inventory by Category

### 3.1 Core Dossier Documents (PDF)

All dossier sections listed in the printed table of contents, exported as PDF/A-2 compliant files with embedded fonts, searchable text, and bookmarks corresponding to section headings.

### 3.2 Spreadsheet Models (XLSX)

- **Cost-Model-Template.xlsx:** Multi-sheet workbook with lifecycle cost input parameters, NPV calculation engine, cost-benefit ratio outputs, and embedded sensitivity analysis using data tables. All cells locked except designated input cells (highlighted in light yellow).
- **Scenario-Analysis.xlsx:** Pre-configured scenario runs for coating-only, CP-only, and combined strategies across three discount rates (3%, 5%, 7%) and three analysis periods (30, 50, 100 years).
- **Funding-Matrix.xlsx:** Eligibility assessment matrix for IIJA Bridge Formula Program, PROTECT discretionary grants, FHWA AID demonstration projects, and California SHOPP/TIP programs.
- **Bridge-Inventory-Template.xlsx:** Data structure for fleet inventory — bridge ID, location, year built, design type, ADT, deck area, substructure type, environment classification, last inspection date, condition ratings, coating system, CP status.

### 3.3 Presentation Decks (PPTX)

- **Executive-Briefing.pptx:** 15–20 slide executive summary deck suitable for C-suite and agency director briefings.
- **Technical-Deep-Dive.pptx:** 40+ slide technical presentation with detailed coating system comparisons, CP schematics, cost curves, and case study photography.
- **Client-Pitch-Template.pptx:** Customizable template for agency client presentations, with TYLin branding, key charts pre-loaded, and placeholder slides for project-specific content.

### 3.4 Reference and Supplementary Data (PDF)

- Publicly available NBI inspection report summaries for major California bay area bridges
- Florida DOT cathodic protection economic study extracts
- Oregon DOT coastal bridge CP program summary data
- Norwegian Public Roads Administration duplex coating performance records
- Compiled standards indices from AMPP, AASHTO, FHWA, and ISO

### 3.5 Templates (DOCX/XLSX)

Editable templates for inspection reports, cost estimates, technical specifications, and program metrics dashboards.

---

## 4. SHA-256 Checksum Verification

Each USB drive shall contain a file named `MANIFEST-SHA256.txt` in the root directory with SHA-256 hash values for every file on the drive. To verify drive integrity:

**Windows (PowerShell):**
```
Get-FileHash -Algorithm SHA256 -Path (Get-ChildItem -Recurse -File).FullName | Format-Table -AutoSize
```

**macOS / Linux:**
```
find . -type f -exec shasum -a 256 {} \; | sort
```

Compare output against the distributed MANIFEST-SHA256.txt. Any mismatch indicates file corruption or unauthorized modification.

---

## 5. Media Handling Instructions

- Store USB drives in anti-static bags when not in use
- Avoid exposure to temperatures above 140°F (60°C) or below 32°F (0°C)
- Do not expose to strong magnetic fields (MRI equipment, large electric motors)
- Insert drives into the adhesive pocket affixed to the inside back cover of each printed binder
- Before each use, run SHA-256 verification to confirm data integrity

---

## 6. Distribution Log

| Copy | USB Serial | Recipient | Date Issued | Issued By |
|---|---|---|---|---|
| 1 | [Record] | President — M. Cummings | [Date] | [Name] |
| 2 | [Record] | Bridge Sector Mgr — J. Duxbury | [Date] | [Name] |
| 3 | [Record] | Chief Bridge Engineer | [Date] | [Name] |
| 4 | [Record] | Business Development | [Date] | [Name] |
| 5 | [Record] | Corporate Archive | [Date] | [Name] |

---

*End of USB Key Master Content Manifest*

*Version 1.0 — July 2026 — Proprietary and Confidential*
