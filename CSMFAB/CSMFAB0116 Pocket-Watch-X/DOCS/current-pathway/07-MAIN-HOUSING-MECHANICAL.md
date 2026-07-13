# CSMFAB0116-07 — POCKET WATCH X: MAIN HOUSING MECHANICAL
**Revision:** A — 2026-07-10 | **Dependencies:** 01-CORE-SYSTEM-ARCHITECTURE

## 1. FORM FACTOR
The Pocket Watch X uses a traditional pocket watch form factor with modern materials and internal architecture for electronics integration.

## 2. DIMENSIONS
| Parameter | Value | Tolerance |
|-----------|-------|-----------|
| Overall diameter | 50.00 mm | ±0.05 mm |
| Overall thickness | 16.50 mm | ±0.10 mm |
| Display visible diameter | 40.00 mm | — |
| Crown diameter | 6.00 mm | ±0.02 mm |
| Crown protrusion | 2.50 mm | ±0.10 mm |
| Chain ring diameter | 12.00 mm ID | ±0.05 mm |
| Chain ring position | 12 oclock | ±0.5° |
| Weight (316L steel) | 115 g | ±5 g |
| Weight (Grade 5 Ti) | 85 g | ±3 g |
| Weight (Brass, polished) | 128 g | ±5 g |

## 3. MATERIAL OPTIONS
| Material | Grade | Density | Finish | Price Add |
|----------|-------|---------|--------|-----------|
| Stainless Steel | 316L | 8.0 g/cm³ | Brushed/satin | Base |
| Titanium | Grade 5 (Ti-6Al-4V) | 4.43 g/cm³ | Bead-blasted matte | +$40 |
| Brass | C36000 (free-machining) | 8.5 g/cm³ | Polished, lacquered | +$30 |
| Bronze | C93200 (bearing bronze) | 8.9 g/cm³ | Patinated | +$50 |

## 4. HOUSING CONSTRUCTION
### 4.1 Main Body
- CNC machined from billet (5-axis)
- Internal pocket for electronics stack (40.0mm dia × 12.0mm deep)
- Fin slot openings (12.4mm × 3.8mm) on underside
- Divot recesses machined into rear face
- Crown stem bore (2.0mm dia through-hole)
- Chain ring lug machined integral

### 4.2 Display Bezel
- Separate ring, press-fit into main body
- 0.5mm press-fit interference
- Secured with 4× M1.2 screws (torque: 0.15 Nm)
- Bezel inner edge: polished chamfer (0.3mm × 45°)
- Bezel outer edge: flush with main body

### 4.3 Case Back
- Threaded ring, 48mm thread diameter, 0.5mm pitch
- 8-start thread for quick removal (1 turn to open)
- O-ring groove (1.0mm × 0.8mm cross-section)
- 4× tool slots for case back wrench
- Optional: glass display window (sapphire, 2mm thick)

## 5. INTERNAL CHASSIS
| Component | Material | Thickness |
|-----------|----------|-----------|
| Main PCB tray | FR4, 0.8mm | — |
| Display support plate | 5052 Aluminum | 1.0 mm |
| Battery retainer | 301 Stainless steel | 0.3 mm (spring) |
| Thermal spreader | Copper C11000 | 0.4 mm |
| EMI shield can | Cupronickel (C7521) | 0.15 mm |
| Fin cage | 316L stainless | 0.3 mm wall |

## 6. SEALING
| Location | Method | IP Rating |
|----------|--------|-----------|
| Display bezel | O-ring (FKM, 1.5mm CS) | IP68 |
| Case back | O-ring (FKM, 1.0mm CS) | IP68 |
| Crown stem | Double O-ring + silicone grease | IP68 |
| Fin slot covers | Silicone flap (when no fin) | IP68 |
| Divot recesses | Nano-coating + dock O-ring | IP68 (docked) |
| Microphone port | Gore-Tex membrane (0.5mm) | IP67 |
| Speaker port | Gore-Tex membrane (3.0mm) | IP67 |
| Pressure vent | Gore-Tex membrane (2.0mm) | IP67 |

## 7. MANUFACTURING PROCESS
### 7.1 CNC Machining (Main Body)
1. Rough mill from billet: 40mm DOC, 8000 RPM, 800 mm/min
2. Semi-finish: 0.5mm stock left
3. Finish bore display pocket: 0.05mm DOC, 12000 RPM
4. Thread mill case back threads
5. Drill/tap M1.2 holes for bezel
6. Deburr all edges (tumble, ceramic media)
7. Surface finish per material spec
8. Clean (ultrasonic, isopropyl alcohol)
9. QC: CMM measurement, 25 points

### 7.2 Assembly Sequence
1. Install display module into bezel (adhesive + press)
2. Mate display FPC to main PCB
3. Install main PCB into chassis tray
4. Install battery (adhesive + retainer clip)
5. Connect battery to PMIC
6. Install fin cage assembly
7. Lower assembly into main body
8. Install EMI shield can over PCB
9. Press bezel assembly into body (4× screws + adhesive)
10. Install crown and stem assembly
11. Thread case back (lubricate O-ring)
12. Boot and run factory test

## 8. SURFACE FINISHES
| Material | Finish | Process |
|----------|--------|---------|
| 316L | Brushed satin | 240-grit wheel, linear grain |
| 316L | Polished | Compound wheel, mirror finish |
| 316L | PVD Black | Titanium carbonitride, 2 µm |
| Ti Grade 5 | Bead blast | #220 glass bead, matte |
| Ti Grade 5 | Anodized | Color by voltage (15-110V) |
| Brass | Polished | Rouge compound on buff |
| Brass | Lacquered | Clear acrylic lacquer, 10 µm |

## 9. DROP PROTECTION
| Parameter | Value |
|-----------|-------|
| Internal shock mounts | 4× silicone bumpers (Shore A 40) |
| Glass-to-bezel clearance | 0.2 mm (allows flex) |
| PCB mounting | Floating mount (0.3 mm Z travel) |
| Battery encapsulation | Polyurethane foam wrap |
| Drop height rating | 1.5m onto concrete, 26 orientations |
| MIL-STD-810H | Method 516.8, Procedure IV (transit drop) |

## 10. VERIFICATION
| Test | Method | Criterion |
|------|--------|-----------|
| Dimensional | CMM, 25-point inspection | Within tolerance |
| Water resistance | IP68 test: 2m, 30 min | No ingress |
| Drop test | 1.5m, 26 drops | Glass intact, functional |
| Thermal cycle | -40 to +85°C, 200 cycles | No cracks, no seal failure |
| Salt fog | 96 hr per ASTM B117 | No corrosion |
| UV exposure | 500 hr xenon arc | No discoloration |
| Crown cycle | 50,000 rotations | No slop, no seal failure |
| Case back cycle | 10,000 open/close | Threads functional, O-ring intact |

