# F2-051 — Preliminary Reverse Version — Second Pass Discrepancy Log
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Purpose

This document is the **second-pass collation placeholder**. When all F2-001 to F2-449
documents are completed in their first pass, this document will be populated with:

1. All specification discrepancies found across vessel documents
2. All scaling errors where sf-dependent values were calculated incorrectly
3. All cross-reference links that were incomplete in first-pass documents
4. All part number inconsistencies
5. All materials specifications that were contradicted across vessels

## 2. Known First-Pass Issues (to be Addressed in Second Pass)

### Issue 001: TOURMALINE Lattice-Lock Density Exception
- Location: F2-020, F2-039, F2-110 (TOURMALINE interior floor)
- Issue: Standard platform spec (8% relative density) insufficient for TOURMALINE load
- Resolution: Use 25% relative density for TOURMALINE only
- ECO Number: ECO-TOUR-001
- Status: DOCUMENTED — TOURMALINE interior docs updated in second pass

### Issue 002: TOURMALINE AAJ Dome Viscoelastic Mount
- Location: F2-009, F2-069 (TOURMALINE dome mount)
- Issue: Standard Sorbothane A20 gives dome f_n = 6.9 Hz (inside 4–8 Hz band)
- Resolution: Switch TOURMALINE to Sorbothane A10 (softer) → f_n = 3.7 Hz
- ECO Number: ECO-TOUR-002
- Status: DOCUMENTED — Update F2-069 in second pass for f_n recalculation

### Issue 003: RHODONITE CMBC Exceeds Single-Piece Vault Feasibility
- Location: F2-010, F2-388–F2-393 (RHODONITE battery system)
- Issue: sf=3.2 gives CMBC OD = 2,100 mm — physically impractical single piece
- Resolution: Modular 4-vault cluster (4× 1,050 mm OD units)
- ECO Number: ECO-RHOD-001
- Status: DOCUMENTED — RHODONITE vault documents use 4-vault cluster design

## 3. Second-Pass Action Items (Future)

When all 449 documents are complete:

1. Run cross-reference audit: confirm every "see F2-XXX" links to an existing document
2. Run sf value audit: every sf-scaled number must match F2-005 equations
3. Run materials audit: every material must appear in F2-007 reference
4. Run PN audit: every part number must appear in F2-050 registry
5. Update Vol-000 (F2-001) ToC with revised document descriptions after depth review
6. Stamp all documents Rev 1.1 after second pass completion
7. Create final binding version of complete 449-document compendium


---
*End F2-051 | CSMVessel-Charlemagne-FleetV2 | June 2026*
