# 08 — USB Content Manifest

**Document Type:** Appendix — Distribution Media Inventory  
**Date:** July 2026  
**Classification:** Confidential

---

## 15.1 Physical Media Specification

| Attribute | Specification |
|-----------|---------------|
| Media Type | USB 3.1 Type-A Flash Drive |
| Capacity | 32 GB |
| File System | exFAT |
| Encryption | AES-256 hardware encryption with PIN entry |
| Labeling | "ACS-Redwood DD — Confidential — July 2026" |
| Quantity | 3 copies (ACS Vault, Program Lead, Redwood C-Suite) |

## 15.2 File Inventory & Directory Structure

```
/
├── README.txt                                          [08-USB-Content/02_README.txt]
├── INDEX.txt                                           [08-USB-Content/03_INDEX.txt]
├──
├── 01_Executive_Summary/
│   └── 01_Executive_Summary.pdf                        [01-Executive-Summary/01_Executive_Summary.md]
│
├── 02_Corporate_Profile/
│   └── 01_Redwood_Corporate_Profile.pdf                [02-Corporate-Profile/01_Redwood_Corporate_Profile.md]
│
├── 03_Technical_Framework/
│   ├── 01_Battery_Recycling_Process.pdf                [03-Technical-Framework/01_Battery_Recycling_Process.md]
│   ├── 02_Cathode_Anode_Production.pdf                 [03-Technical-Framework/02_Cathode_Anode_Production.md]
│   ├── 03_Redwood_Energy_Storage.pdf                   [03-Technical-Framework/03_Redwood_Energy_Storage.md]
│   ├── 04_Strategic_Partnerships.pdf                   [03-Technical-Framework/04_Strategic_Partnerships.md]
│   └── 05_Manufacturing_Infrastructure.pdf             [03-Technical-Framework/05_Manufacturing_Infrastructure.md]
│
├── 04_Financial_Analysis/
│   ├── 01_Revenue_Funding_Growth.pdf                   [04-Financial-Analysis/01_Revenue_Funding_Growth.md]
│   ├── 02_Unit_Economics_Scale.pdf                     [04-Financial-Analysis/02_Unit_Economics_Scale.md]
│   └── 03_DOE_Loan_Capital_Strategy.pdf                [04-Financial-Analysis/03_DOE_Loan_Capital_Strategy.md]
│
├── 05_Implementation_Roadmap/
│   └── 01_Program_Framework.pdf                        [05-Implementation-Roadmap/01_Program_Framework.md]
│
├── 06_Research_Archive/
│   └── 01_Research_Memorandum.pdf                      [06-Research-Archive/01_Research_Memorandum.md]
│
├── 07_Appendices/
│   ├── 01_Bibliography.pdf                             [07-Appendices/01_Bibliography.md]
│   └── 02_Glossary.pdf                                 [07-Appendices/02_Glossary.md]
│
└── 08_Data_Exhibits/
    ├── Exhibit_A_Financial_Model.xlsx                  [Financial model — three-statement projections, 2026–2032]
    ├── Exhibit_B_Supply_Demand_Forecast.xlsx           [Critical minerals supply-demand balance, 2025–2040]
    ├── Exhibit_C_Cap_Table.xlsx                        [Capitalization table — equity rounds, dilution, ownership]
    ├── Exhibit_D_Partner_Matrix.xlsx                   [Partnership summary — OEM, scope, volumes, contract terms]
    ├── Exhibit_E_Competitor_Landscape.xlsx             [Competitive positioning — capacity, funding, technology]
    └── Exhibit_F_Site_Photos.zip                       [Sparks NV and Charleston SC aerial and ground-level imagery]
```

## 15.3 PDF Rendering Specifications

All PDF files shall be rendered from source markdown documents with the following specifications:

| Parameter | Value |
|-----------|-------|
| Page Size | US Letter (8.5 × 11 in) |
| Margins | 1.0 in all sides |
| Font Body | 10.5 pt serif (Garamond or Times New Roman) |
| Font Headings | 12–18 pt sans-serif (Helvetica or Arial) |
| Line Spacing | 1.15× |
| Header | "ACS-Redwood DD — Confidential" + page number |
| Footer | Document title + date |
| Watermark | "CONFIDENTIAL — DO NOT DISTRIBUTE" diagonal, 15% opacity |

## 15.4 Distribution Protocol

1. Each USB drive is to be serialized and logged in the ACS Document Control Register.
2. Drives are to be hand-carried or shipped via bonded courier with chain-of-custody documentation.
3. Recipients must sign an acknowledgment of receipt and confidentiality undertaking prior to delivery.
4. USB drives are to be stored in a locked, access-controlled container when not in active use.
5. Upon conclusion of the engagement, all USB drives are to be returned to ACS Document Control for secure destruction, or destruction may be certified in writing by the recipient.

## 15.5 Digital Access Control

Encrypted USB drives are configured with the following access policy:

- **PIN complexity:** Minimum 8 characters, alphanumeric with at least one special character
- **Auto-lock:** Drive locks after removal from host or 15 minutes of inactivity
- **Brute-force protection:** Drive self-destructs encryption key after 10 consecutive incorrect PIN entries
- **Tamper evidence:** Physical tamper-evident seal across USB connector and enclosure seam
