# P0-01-VOL-05: QMS Protocol — ISO 9001:2015 Compliance
## CSMFAB-P001 | Ceramic Bridge Bearings 500T

---

## QUALITY MANAGEMENT SYSTEM — Critical Control Points

| CCP | Stage | Parameter | Limit | Method | Frequency | Corrective Action |
|-----|-------|-----------|-------|--------|-----------|-------------------|
| CCP-01 | Raw powder | Purity ZrO₂ | ≥99.5% | XRF spectroscopy | Every batch | Reject batch, notify supplier |
| CCP-02 | Ball milling | Particle size D50 | 145-155μm | Laser diffraction | Every batch | Extend milling ±2hr |
| CCP-03 | CIP | Green density | ≥55% TD | Archimedes | Every part | Reject, recycle powder |
| CCP-04 | Green machining | Dimensions | ±0.05mm | CMM | Every part | Rework or reject |
| CCP-05 | Flash sintering | Flash temp | 850°C ±25 | Optical pyrometer | Every cycle | Adjust voltage ±5% |
| CCP-06 | Flash sintering | Current density | 80±10 mA/mm² | Ammeter log | Every cycle | Abort cycle, inspect |
| CCP-07 | Post-sinter | Density | ≥99.5% TD | Archimedes | Every part | Reject if <99.3% |
| CCP-08 | Post-sinter | Grain size | 300-500nm | SEM image analysis | Every 10th part | Adjust hold time |
| CCP-09 | Grinding | Surface Ra | <0.2μm | Profilometer | Every part | Re-polish |
| CCP-10 | Final | Dielectric test | >50 kV, <1μA leakage | Hipot tester | Every part | Reject, root cause |
| CCP-11 | Final | Compressive proof | 750 MPa (1.5x design) | Universal tester | Every 50th part | Batch hold, investigate |

## DOCUMENTATION REQUIREMENTS
- Certificate of Conformance (CoC) per bearing
- Material certs for each powder batch
- Sintering cycle log with temp/current curves
- Dimensional inspection report
- Dielectric test report
- Serial number traceability to raw material lots

## REJECTION CRITERIA
- Any CCP out of tolerance without approved deviation
- Visible surface crack or spall >0.5mm
- Density <99.3% theoretical
- Dielectric failure at <42 kV
