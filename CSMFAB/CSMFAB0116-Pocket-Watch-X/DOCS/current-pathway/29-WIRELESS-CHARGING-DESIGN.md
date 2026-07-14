# CSMFAB0116-29 — POCKET WATCH X: WIRELESS CHARGING DESIGN
## 1. QI2 MPP SPECIFICATION
| Parameter | Value |
|-----------|-------|
| Standard | Qi 2.0 MPP (Magnetic Power Profile) |
| Receiver coil | Single layer, 40 mm OD, Litz wire |
| Coil inductance | 12.0 µH ±10% |
| Resonant capacitor | 132 nF (series, 127.7 kHz) |
| Max received power | 15 W |
| Magnetic ring | 38 pcs NdFeB N52, 2 × 3 mm, alternating poles |
| Alignment | Magnetic auto-alignment ±2 mm |

## 2. RECTIFIER STAGE
| Parameter | Value |
|-----------|-------|
| IC | NXP MWPR1516 or Renesas P9243 |
| Topology | Synchronous full-bridge rectifier |
| Output voltage | 5-12 V programmable |
| Efficiency | 92% (rectifier stage) |
| Foreign object detection | Q-factor + power loss |
| Communication | ASK modulation on power carrier |

## 3. CHARGING EFFICIENCY BUDGET
| Stage | Efficiency |
|-------|------------|
| TX coil → RX coil (5 mm gap) | 82% |
| Rectifier | 92% |
| Buck charger | 95% |
| Battery charge acceptance | 98% |
| Total coil-to-battery | 72% |

## 4. THERMAL
| Parameter | Value |
|-----------|-------|
| Coil temperature at 15W | < 40°C (with graphite spreader) |
| Thermal shutdown | 55°C coil temp |
| Charge rate reduction | 45°C → 10W, 50°C → 5W |

## 5. VERIFICATION
| Test | Method | Criterion |
|------|--------|-----------|
| Power received | Qi2 MPP test tool | > 14.5W |
| FOD | Steel disc on coil | Charging stops < 2s |
| Efficiency | DC in to battery | > 70% |
| Alignment tolerance | Offset ±3 mm | Still charges at > 10W |
