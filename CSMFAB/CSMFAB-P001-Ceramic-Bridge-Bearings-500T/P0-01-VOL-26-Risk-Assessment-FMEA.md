# P0-01-VOL-26: Risk Assessment — FMEA
## CSMFAB-P001 | Ceramic Bridge Bearings 500T

---

## FAILURE MODE AND EFFECTS ANALYSIS

| # | Failure Mode | Severity (1-10) | Probability (1-10) | Detection (1-10) | RPN | Mitigation |
|---|-------------|-----------------|--------------------|--------------------|-----|------------|
| F1 | ZTA disc brittle fracture under overload | 10 | 2 | 1 | 20 | 1.5× design proof test (750T) on every 50th unit; FEATHER displacement anomaly alert |
| F2 | PTFE surface wear exceeding 2mm | 6 | 5 | 2 | 60 | Annual ultrasonic thickness measurement; lubricant-free design (no maintenance dependency) |
| F3 | BFRP housing delamination (moisture ingress) | 7 | 3 | 3 | 63 | Marine-grade BF-002 with <0.15% water absorption; weather seal prevents moisture |
| F4 | Anchor bolt loosening (vibration) | 8 | 4 | 2 | 64 | Post-install torque check at 7d/30d/annual; nylon lock insert in BFRP nut |
| F5 | Dielectric breakdown (contamination bridge) | 9 | 2 | 1 | 18 | 50 kV DC hipot on every unit; weather seal prevents salt bridge formation |
| F6 | Flash sintering process excursion (under-sinter) | 5 | 3 | 1 | 15 | CCP-05/06 monitor temp + current; density check on every part |
| F7 | Grout pad settlement (substructure) | 7 | 3 | 2 | 42 | Geopolymer grout CSM-MAT-GP-001 with 85 MPa compressive; leveling survey before install |
| F8 | GIC bypass via wet bearing (flood event) | 9 | 1 | 1 | 9 | Weather seal rated to 50kPa water spray; saline dielectric test validates |
| F9 | Fatigue crack from translation cycling | 8 | 2 | 2 | 32 | 2M cycle fatigue test (Vol-17 M-04); ZTA has fatigue limit >60% UTS |
| F10 | Theft/vandalism (rare but possible) | 4 | 1 | 5 | 20 | Bearing enclosed in bridge structure; crane required to remove; serial tracking |

**RPN = Severity × Probability × Detection** (lower is better, <50 is acceptable, <20 is excellent)
