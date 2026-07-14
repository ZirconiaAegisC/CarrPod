# CSMFAB0116-08 — POCKET WATCH X: THERMAL MANAGEMENT
**Revision:** A — 2026-07-10 | **Dependencies:** 01-CORE-SYSTEM-ARCHITECTURE, 06-POWER-MANAGEMENT-SYSTEM

## 1. THERMAL BUDGET
| Component | Max Power (W) | Notes |
|-----------|---------------|-------|
| SoC-A + SoC-B | 12.0 | Both at full load |
| Display | 1.8 | 2000 nit HDR peak |
| Fin 0 (CPU fin) | 6.0 | Typical upgrade CPU |
| Fin 1 (GPU fin) | 4.0 | Typical upgrade GPU |
| Wireless/BT/NFC | 1.2 | All radios active |
| PMIC losses | 0.5 | Conversion inefficiency |
| Total max sustained | 25.5 | All systems max |

## 2. THERMAL SOLUTION
| Component | Material | Thickness | Conductivity |
|-----------|----------|-----------|-------------|
| SoC thermal interface | Thermal paste (Shin-Etsu X-23) | 50 µm | 6.0 W/m·K |
| Heat spreader | Copper C11000 | 0.4 mm | 391 W/m·K |
| Vapor chamber | Copper sintered wick | 0.4 mm | 5000+ W/m·K (effective) |
| Graphite spreader | Pyrolytic graphite sheet (PGS) | 25 µm | 1700 W/m·K (in-plane) |
| Gap filler to housing | Silicone pad (Fujipoly GR80A) | 0.5 mm | 8.0 W/m·K |
| Housing | 316L stainless steel | 0.8 mm wall | 16 W/m·K |

## 3. THERMAL PATH
1. SoC die → thermal paste → copper lid
2. Copper lid → vapor chamber → heat spreader plate
3. Heat spreader → graphite sheet → fin thermal interface pads
4. Fin insert → fin copper thermal pad → graphite sheet
5. Graphite sheet → gap filler → housing inner wall
6. Housing outer wall → ambient air (natural convection + radiation)

## 4. THERMAL RESISTANCE BUDGET
| Junction | Resistance (°C/W) | Material/Limitation |
|----------|-------------------|---------------------|
| SoC junction-to-case | 2.0 | Package limitation |
| Case-to-spreader | 0.5 | TIM resistance |
| Spreader-to-housing | 8.0 | Gap filler bottleneck |
| Housing-to-ambient | 17.5 | Natural convection, 50mm dia |
| Total Theta-JA | 28.0 | At 25°C ambient |

## 5. TRANSIENT THERMAL BEHAVIOR
| Scenario | Time to 95°C | Notes |
|----------|--------------|-------|
| 25.5W sustained | ~120 seconds | Will throttle at 95°C |
| 15W sustained | ~300 seconds | Manageable |
| 10W sustained | Indefinite | Stable at ~65°C junction |
| 5W (typical use) | Indefinite | Stable at ~40°C junction |

## 6. PHASE CHANGE MATERIAL (PCM)
For burst thermal management, 2.0g of PCM is placed between the heat spreader and housing:

| Parameter | Value |
|-----------|-------|
| Material | Paraffin-based PCM (PCM45F) |
| Melting point | 45°C |
| Latent heat | 200 J/g |
| Total energy absorption | 400 J (2.0g) |
| Burst time extension | ~16 seconds at 25.5W |

## 7. THERMAL THROTTLING
| Temperature | Action |
|-------------|--------|
| SoC 85°C | Reduce CPU freq by 25% |
| SoC 90°C | Reduce GPU freq by 50% |
| SoC 95°C | Reduce to minimum clock, disable fin boost |
| SoC 105°C | Emergency shutdown |
| Battery 45°C | Reduce charge rate |
| Battery 50°C | Stop charging |
| Housing surface 43°C | Reduce total power budget |

## 8. THERMAL SIMULATION REQUIREMENTS
| Parameter | Target |
|-----------|--------|
| Mesh size | < 0.5 mm element size |
| Solver | Conjugate heat transfer (CHT) |
| Ambient | 25°C still air |
| Radiation | Included (emissivity 0.3 for steel) |
| Steady-state | All components at max power |
| Transient | 600s run, 1s timesteps |
| Correlation | Within 5°C of physical measurement |

## 9. ACTIVE COOLING (DOCKED MODE)
When docked, the dock may provide:
- Forced air (fan in projector/keyboard dock)
- Larger thermal mass (vehicle dock uses vehicle chassis)
- Thermoelectric assist (optional dock accessory, 2W Peltier, 10°C drop)

## 10. VERIFICATION
| Test | Method | Criterion |
|------|--------|-----------|
| Theta-JA | JEDEC 51-1 (still air) | ≤ 30°C/W |
| Steady-state | 25.5W load, 25°C ambient, 1 hr | SoC junction < 95°C at steady throttle |
| Burst capability | 25.5W for 120s from cold | No thermal shutdown |
| PCM function | Monitor temperature plateau at 45°C | Plateau visible for > 10s |
| Docked cooling | In keyboard dock, 25.5W load | No throttling |
| Hot touch temperature | Thermocouple on housing | < 43°C surface temp |
| Thermal cycle | 100 cycles, -20 to +85°C | No TIM degradation |

