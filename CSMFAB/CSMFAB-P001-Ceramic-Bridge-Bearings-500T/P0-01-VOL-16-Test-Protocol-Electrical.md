# P0-01-VOL-16: Test Protocol — Electrical (Dielectric + GIC Blocking)
## CSMFAB-P001 | Ceramic Bridge Bearings 500T

---

## ELECTRICAL TEST BATTERY

### TEST E-01: Dielectric Withstand (Factory)

| Parameter | Value |
|-----------|-------|
| Test voltage | 50 kV DC |
| Application | Bolt-to-housing, 60 sec hold |
| Pass criterion | Leakage current <1 μA |
| Failure mode | Arc-over at <42 kV (reject) |
| Frequency | Every unit |

### TEST E-02: Insulation Resistance (Factory)

| Parameter | Value |
|-----------|-------|
| Test voltage | 1 kV DC |
| Measurement | Superstructure bolt → substructure bolt |
| Pass criterion | >100 MΩ |
| Frequency | Every unit |

### TEST E-03: GIC Current Blocking (Field Sim)

| Parameter | Value |
|-----------|-------|
| Applied current | DC, 0-100A sweep |
| Path | Bridge girder → through bearing → substructure |
| Measurement | Current on substructure side (Rogowski coil) |
| Pass criterion | <0.1A substructure current at 100A applied |
| Frequency | First-article only (type test) |

### TEST E-04: Wet Dielectric (Factory Sample)

| Parameter | Value |
|-----------|-------|
| Condition | Bearing submerged in 3% saline, 25°C, 24hr |
| Test voltage | 42 kV DC |
| Pass criterion | Leakage <5 μA |
| Frequency | 1 per 100 units (lot acceptance) |

### TEST E-05: Thermal Cycle + Dielectric (Factory Sample)

| Parameter | Value |
|-----------|-------|
| Cycle | -40°C/4hr → +85°C/4hr, 10 cycles |
| Post-cycle test | E-01 + E-02 |
| Pass criterion | No degradation from baseline |
| Frequency | 1 per 50 units |
