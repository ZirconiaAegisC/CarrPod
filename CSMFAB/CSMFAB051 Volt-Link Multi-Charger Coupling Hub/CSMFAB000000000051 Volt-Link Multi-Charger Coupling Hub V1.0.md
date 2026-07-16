# CSMFAB000000000051 — Volt-Link Multi-Charger Coupling Hub
## Portable Multi-Input EV Fast-Charging Aggregation Device — Hybrid Edition
### Version 1.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors (CSM) / Safe Pod Engineering Company
**Classification:** Open Source — Civilization Resilience Level 5 | Engineering Design Document
**Series:** CSMFAB — Fabrication Publications | Aegis Embark Vehicle Products

---

## Executive Summary

The Volt-Link Multi-Charger Coupling Hub is a portable power electronics device that aggregates four to five standard J1772 Level 2 Electric Vehicle charging inputs into a single DC fast-charge output via CCS Combo 1 or CHAdeMO connector, delivering 26.4 to 33 kilowatts of combined charging power. The device addresses the critical infrastructure gap between the installed base of 150,000-plus Level 2 public charging ports and the approximately 40,000 DC fast-charging ports in the United States, enabling EV drivers to achieve meaningful charging speeds (0-80% in approximately 90-120 minutes for a 64 kWh battery) using only existing, already-permitted Level 2 infrastructure and standard J1772 extension cables.

**CSMFAB051 (Hybrid Edition)** combines commercial off-the-shelf power electronics components with Carrington Storm Motors advanced materials for thermal management, electromagnetic interference shielding, structural enclosure, and charge-state monitoring. The hybrid approach prioritizes immediate manufacturability using currently available components while integrating CSM materials science where they provide measurable performance advantages over conventional alternatives.

**Vehicle Compatibility:** Hyundai Kona Electric (64 kWh), Kia Niro EV (64 kWh), Kia EV6 (77.4 kWh), Hyundai Ioniq 5 (77.4 kWh), Hyundai Ioniq 6 (77.4 kWh), Genesis GV60, Chevrolet Bolt EV/EUV, Ford Mustang Mach-E, Volkswagen ID.4, and all CCS-enabled or CHAdeMO-enabled electric vehicles.

**Key Specifications:**
- Input: 4-5 × J1772 Type 1, 208-240V AC, 32A max per input
- Output: CCS Combo 1 (primary) or CHAdeMO (via adapter), 26.4-33 kW DC
- Input rectification: 4-5 × 6.6 kW silicon carbide (SiC) active front-end rectifiers
- DC bus voltage: 200-500V DC, configurable per vehicle BMS request
- Charge controller: STM32F4 ARM Cortex-M4 microcontroller with dual CAN bus
- Thermal management: CSM pyrolytic graphite heat spreader with forced-air cooling
- EMI shielding: CSM MXene Ti₃C₂Tₓ spray-coated enclosure interior, 85 dB attenuation at 1 MHz
- Enclosure: Aluminum 6061-T6 with CSM BFRP-Elium composite structural ribs
- Weight: 11.8 kg (26.0 lbs)
- Dimensions: 480 × 320 × 180 mm (18.9 × 12.6 × 7.1 in)
- Operating temperature: -20°C to +50°C ambient
- IP rating: IP65 (dust-tight, water-jet resistant)

---

## Index

| Section | Title | Page |
|---------|-------|------|
| 1 | Executive Summary | 1 |
| 2 | Index | 2 |
| 3 | Safety Warnings and Certifications | 3 |
| 4 | Theory of Operation | 4 |
| 5 | Bill of Materials — Master | 6 |
| 6 | Bill of Materials — CSM Specialized Components | 8 |
| 7 | Required Tools and Equipment | 9 |
| 8 | Workspace Preparation | 10 |
| 9 | Fabrication Steps 1-10: Enclosure and Structural Assembly | 11 |
| 10 | Fabrication Steps 11-20: Input Rectifier Stage | 16 |
| 11 | Fabrication Steps 21-30: DC Bus and Output Stage | 22 |
| 12 | Fabrication Steps 31-40: Control Electronics and Firmware | 28 |
| 13 | Fabrication Steps 41-50: Integration, Testing, and Commissioning | 34 |
| 14 | Quality Acceptance Criteria | 40 |
| 15 | Firmware Architecture and Configuration | 42 |
| 16 | J1772 Extension Cable Specification | 45 |
| 17 | Field Deployment Protocol | 46 |
| 18 | Maintenance Schedule | 48 |
| 19 | Troubleshooting Guide | 49 |
| 20 | Regulatory Compliance Pathway | 51 |
| 21 | Phoenix Protocol — End-of-Life Recycling | 52 |
| 22 | References and Standards | 53 |

---

## 3. Safety Warnings and Certifications

**DANGER — HIGH VOLTAGE:** This device operates at voltages up to 500V DC and currents up to 80A DC. Lethal voltages are present on the DC bus, output connector, and rectifier stages. Only qualified personnel with high-voltage electrical training should attempt fabrication, testing, or operation. Always verify zero energy state before opening the enclosure. Use Lockout/Tagout procedures during maintenance.

**DANGER — ARC FLASH HAZARD:** The DC bus capacitors store significant energy even after disconnection. Discharge time is approximately 120 seconds after power removal. Verify DC bus voltage is below 50V before touching any internal component. Do not rely on bleed resistors alone — always measure with a calibrated multimeter.

**WARNING — THERMAL HAZARD:** The SiC rectifiers and DC bus components can reach surface temperatures of 85°C during sustained 33 kW operation. Allow 30 minutes of cooling before opening the enclosure after high-power use. The pyrolytic graphite heat spreader is thermally conductive — treat as a hot surface during and after operation.

**WARNING — FIRE HAZARD:** Improper assembly, undersized wiring, loose connections, or use of non-rated components can cause electrical fires. Use only components specified in the Bill of Materials. Torque all electrical connections to specification. Install all specified fuses, circuit breakers, and thermal cutoffs. Never bypass safety devices.

**WARNING — CHARGING STATION COMPATIBILITY:** Not all J1772 charging stations will deliver their full rated current simultaneously when multiple connectors are drawing from the same site electrical service. The Volt-Link hub's input current limiting feature (configurable via firmware) must be set appropriately for the installation. Drawing more aggregate current than the site service supports may trip upstream breakers. Always verify site electrical capacity before coupling.

**CERTIFICATION STATUS (July 2026):** This device is a PROTOTYPE DESIGN. It has not yet undergone UL certification, CE marking, or FCC Part 15 testing. The certification pathway is documented in Section 20. Prototype units should only be operated under direct supervision by qualified personnel in controlled environments.

**INSULATION REQUIREMENTS:**
- Primary-to-secondary isolation: 3.75 kV AC, 1 minute (reinforced insulation per IEC 61851-23)
- Creepage distance, DC bus to chassis: 8.0 mm minimum (pollution degree 2, material group IIIa)
- Clearance distance, DC bus to chassis: 6.4 mm minimum (up to 500V DC working voltage)

**PERSONAL PROTECTIVE EQUIPMENT (PPE) REQUIRED:**
- Arc-flash rated face shield (8 cal/cm² minimum)
- Class 0 insulating gloves (tested to 5,000V AC) with leather over-gloves
- Flame-resistant (FR) clothing, long sleeves and pants
- Insulated footwear
- Safety glasses (under face shield)
- No jewelry, watches, or metallic accessories on hands or wrists

---

## 4. Theory of Operation

The Volt-Link Multi-Charger Coupling Hub operates on the principle of **parallel AC-to-DC conversion with common DC bus aggregation**. Each J1772 input channel contains its own active front-end rectifier that converts 208-240V AC single-phase power to regulated DC. The outputs of all rectifier channels feed a common DC bus through isolation diodes and contactors. A central microcontroller manages the charge session by communicating with the vehicle's Battery Management System (BMS) via CCS Power Line Communication (PLC) or CHAdeMO CAN bus, and simultaneously negotiates with each connected J1772 charging station via the standard pilot signal protocol.

### 4.1 Input Stage Architecture

Each of the four (or five, on the expanded model) input channels consists of:
1. **J1772 Inlet Port** — SAE J1772 Type 1 connector receptacle, mounted on the enclosure face
2. **Pilot Signal Interface** — ATmega328P-based module that generates the SAE J1772 Control Pilot (CP) waveform per IEC 61851-1 Annex A, negotiating 32A maximum current draw per input
3. **Input Contactor** — 40A-rated three-pole AC contactor with 12V DC coil, controlled by the main microcontroller
4. **Active Front-End Rectifier** — Silicon Carbide (SiC) MOSFET-based totem-pole PFC rectifier, 6.6 kW rated, converting 240V AC to 400V DC with >97% efficiency
5. **DC Output Contactor** — 20A-rated DC contactor connecting the rectifier output to the common DC bus

The input channels are galvanically isolated from each other on the AC side — each J1772 inlet is a separate single-phase connection to its respective charging station. On the DC side, the rectifier outputs share a common negative rail, with positive outputs connected through blocking diodes and individually-switched DC contactors.

### 4.2 DC Bus and Output Stage

The common DC bus operates at a nominal 400V DC, with an allowable range of 200-500V DC to accommodate different vehicle battery voltages (300V for Kona/Niro, 400V nominal, 800V for E-GMP platform vehicles through a DC-DC boost stage). Key components:
1. **DC Bus Capacitor Bank** — 4 × 680 µF, 500V rated electrolytic capacitors in parallel (2,720 µF total), with 2 × 10 µF film capacitors for high-frequency bypass
2. **Bleed Resistor Network** — 2 × 22 kΩ, 25W wirewound resistors in series for safe bus discharge within 120 seconds
3. **Output Contactor** — 100A-rated DC contactor with economizer circuit, controlling main output to vehicle
4. **Output Filter** — Common-mode choke (2 mH) and differential-mode LC filter for conducted EMI suppression
5. **CCS/CHAdeMO Output Connector** — CCS Combo 1 connector with integrated PLC coupling transformer for CCS communication; CHAdeMO adapter available

### 4.3 Control Architecture

The main controller is an STM32F407VGT6 ARM Cortex-M4 microcontroller operating at 168 MHz. Its responsibilities include:
- **CAN Bus 1 (500 kbps):** Communication with vehicle BMS via CCS/CHAdeMO protocol, receiving charge voltage and current requests
- **CAN Bus 2 (125 kbps):** Internal communication with input channel pilot signal modules and power monitoring units
- **Charge Session State Machine:** Managing the CCS charging sequence — handshake, identification, parameter negotiation, power delivery, termination
- **Load Balancing:** Dynamically adjusting current draw from each input channel to equalize thermal load and respect per-input current limits
- **Fault Detection:** Monitoring DC bus over/under voltage, overcurrent, ground fault, overtemperature, and isolation resistance
- **User Interface:** LCD display showing per-input current, total output power, state of charge, and fault codes; Bluetooth Low Energy module for smartphone companion app
- **Data Logging:** Recording charge session parameters to microSD card for diagnostics

### 4.4 Thermal Management

Thermal dissipation during 33 kW operation is approximately 900W total (97% rectifier efficiency × 4 channels = 792W semiconductor losses, plus ~108W contactor coil and control electronics losses). The thermal management strategy uses a three-layer approach:
1. **SiC MOSFETs** are mounted directly to a CSM pyrolytic graphite heat spreader (thermal conductivity 1,200 W/m·K in-plane, 15 W/m·K through-plane) that distributes heat across the full enclosure base
2. **Forced-air cooling** via two 80mm 12V DC axial fans (PWM-controlled based on internal temperature) drawing ambient air through filtered intake vents and exhausting through the rear panel
3. **CSM MXene-coated** internal surfaces provide EMI shielding (85 dB at 1 MHz) while the aluminum enclosure functions as the primary convective surface

### 4.5 EMI Shielding Strategy

The Volt-Link hub contains multiple switching power converters operating at 65-140 kHz, generating conducted and radiated electromagnetic interference. Shielding measures include:
- CSM MXene Ti₃C₂Tₓ spray-applied coating (45 µm thickness) on all internal enclosure surfaces, providing 85 dB shielding effectiveness at 1 MHz, 72 dB at 100 MHz
- Ferrite common-mode chokes on all input and output power lines
- Differential-mode LC filters on each rectifier output
- Copper ground plane on the control PCB with guard rings around sensitive analog traces
- Shielded CAN bus cables with 120Ω termination resistors
- Continuous ground bonding between enclosure panels using conductive gaskets

---

## 5. Bill of Materials — Master

### 5.1 Enclosure and Structural

| Item # | Description | Qty | Supplier | Part Number | Unit Cost | Extended |
|--------|-------------|-----|----------|-------------|-----------|----------|
| ENC-001 | Aluminum 6061-T6 enclosure, 480×320×180mm, IP65 | 1 | Hammond Mfg | 1456RL3WHC | $78.00 | $78.00 |
| ENC-002 | CSM BFRP-Elium composite structural rib kit (CSMFAB09) | 1 | CSM In-House | CSM-BFRP-RIB-001 | $24.00 | $24.00 |
| ENC-003 | MXene Ti₃C₂Tₓ EMI shielding spray kit, 100mL | 1 | CSM In-House | CSM-MX-SPRAY-100 | $45.00 | $45.00 |
| ENC-004 | EPDM sealing gasket, 5mm × 10mm, self-adhesive, 3m roll | 1 | McMaster-Carr | 93085K64 | $18.00 | $18.00 |
| ENC-005 | Stainless steel M4×12mm screws, hex socket, pack of 50 | 1 | McMaster-Carr | 91292A112 | $6.00 | $6.00 |
| ENC-006 | Cable glands, PG16, nylon, IP68, pack of 10 | 1 | McMaster-Carr | 69915K67 | $12.00 | $12.00 |
| ENC-007 | 80mm 12V DC axial fan, 45 CFM, 28 dBA, PWM | 2 | Noctua | NF-A8 PWM | $17.95 | $35.90 |
| ENC-008 | Fan finger guard, 80mm, stainless steel | 2 | McMaster-Carr | 1957T31 | $4.50 | $9.00 |
| ENC-009 | Air intake filter media, 80mm, washable foam | 2 | McMaster-Carr | 2051K11 | $3.00 | $6.00 |

### 5.2 Input Stage — Per Channel (×4 standard, ×5 expanded)

| Item # | Description | Qty | Supplier | Part Number | Unit Cost | Extended (×4) |
|--------|-------------|-----|----------|-------------|-----------|---------------|
| INP-001 | J1772 Type 1 inlet port, 32A, 240V AC, panel mount | 4 | Amphenol | J1772-INLET-32A | $34.00 | $136.00 |
| INP-002 | SiC MOSFET totem-pole PFC evaluation board, 6.6kW | 4 | Wolfspeed | CRD-06600FF065N | $185.00 | $740.00 |
| INP-003 | ATmega328P pilot signal module (assembled PCB) | 4 | CSM In-House | CSM-PILOT-PCB-001 | $28.00 | $112.00 |
| INP-004 | 3-pole AC contactor, 40A, 240V AC, 12V DC coil | 4 | TE Connectivity | T9AP1D52-12 | $14.50 | $58.00 |
| INP-005 | DC blocking diode module, 600V, 30A, dual Schottky | 4 | Vishay | VS-30CPQ060-N3 | $8.75 | $35.00 |
| INP-006 | DC output contactor, 20A, 500V DC, 12V coil | 4 | TE Connectivity | LEV200A4NAA | $42.00 | $168.00 |
| INP-007 | Ferrite common-mode choke, 2mH, 30A | 4 | Wurth Elektronik | 744824210 | $11.20 | $44.80 |
| INP-008 | Input AC fuse holder + 40A class CC fuse | 4 | Littelfuse | LFCC-40 | $18.00 | $72.00 |

### 5.3 DC Bus and Output Stage

| Item # | Description | Qty | Supplier | Part Number | Unit Cost | Extended |
|--------|-------------|-----|----------|-------------|-----------|----------|
| BUS-001 | Electrolytic capacitor, 680µF, 500V DC, 105°C | 4 | Nichicon | LGG2W681MELC50 | $8.50 | $34.00 |
| BUS-002 | Film capacitor, 10µF, 630V DC, polypropylene | 2 | WIMA | DCP4I061007J | $5.75 | $11.50 |
| BUS-003 | Aluminum bus bar, 6mm×25mm, 500mm length | 1 | McMaster-Carr | 89825K64 | $14.00 | $14.00 |
| BUS-004 | Bleed resistor, 22kΩ, 25W, wirewound | 2 | Ohmite | TAH25P22K0JE | $9.50 | $19.00 |
| BUS-005 | DC output contactor, 100A, 500V DC, 12V coil | 1 | TE Connectivity | LEV200H5ANA | $126.00 | $126.00 |
| BUS-006 | Common-mode choke, 2mH, 100A, toroidal | 1 | Wurth Elektronik | 74483901000 | $38.00 | $38.00 |
| BUS-007 | CCS Combo 1 connector, 125A, with PLC coupling | 1 | Phoenix Contact | EV-CCS-COMBO1-125A | $245.00 | $245.00 |
| BUS-008 | CHAdeMO adapter cable, 1.5m | 1 | Custom | CHADEMO-ADAPT-1.5M | $95.00 | $95.00 |
| BUS-009 | DC rated fuse, 125A, 500V DC, semiconductor | 1 | Littelfuse | L50QS125.V | $32.00 | $32.00 |
| BUS-010 | Ground fault detection module, 30mA trip | 1 | Bender | RCM420-D-2 | $148.00 | $148.00 |

### 5.4 Control Electronics

| Item # | Description | Qty | Supplier | Part Number | Unit Cost | Extended |
|--------|-------------|-----|----------|-------------|-----------|----------|
| CTL-001 | STM32F407VGT6 development board (STM32F4 Discovery) | 1 | STMicro | STM32F407G-DISC1 | $24.00 | $24.00 |
| CTL-002 | Custom CSM control PCB (open-source Gerber files) | 1 | CSM In-House / JLCPCB | CSM-CTL-PCB-051 | $42.00 | $42.00 |
| CTL-003 | CAN bus transceiver, MCP2551, DIP-8 | 2 | Microchip | MCP2551-I/P | $2.10 | $4.20 |
| CTL-004 | 4.3" TFT LCD display, 480×272, SPI interface | 1 | Newhaven Display | NHD-4.3-480272EF-ASXP | $32.00 | $32.00 |
| CTL-005 | Bluetooth LE module, nRF52840, UART | 1 | Adafruit | Adafruit 4062 | $24.95 | $24.95 |
| CTL-006 | MicroSD card breakout module, SPI | 1 | Adafruit | Adafruit 254 | $7.50 | $7.50 |
| CTL-007 | DS18B20 temperature sensors, 1-Wire, TO-92 | 8 | Maxim | DS18B20+ | $3.50 | $28.00 |
| CTL-008 | ACS758 current sensor, ±100A, Hall effect | 5 | Allegro | ACS758LCB-100B-PFF-T | $9.75 | $48.75 |
| CTL-009 | Isolated DC-DC converter, 12V to 5V/3.3V, 15W | 1 | TRACO Power | TMR 3-1211WI | $22.00 | $22.00 |
| CTL-010 | Power relay module, 8-channel, 5V control, 250V/10A | 1 | SainSmart | SRD-8CH | $12.00 | $12.00 |

### 5.5 Wiring, Connectors, and Hardware

| Item # | Description | Qty | Supplier | Part Number | Unit Cost | Extended |
|--------|-------------|-----|----------|-------------|-----------|----------|
| WIR-001 | 10 AWG silicone wire, 600V rated, black, 10m | 1 | BNTECHGO | 10AWG-SIL-BLK-10M | $28.00 | $28.00 |
| WIR-002 | 10 AWG silicone wire, 600V rated, red, 10m | 1 | BNTECHGO | 10AWG-SIL-RED-10M | $28.00 | $28.00 |
| WIR-003 | 14 AWG silicone wire, 600V rated, assorted colors, 20m | 1 | BNTECHGO | 14AWG-SIL-KIT-20M | $35.00 | $35.00 |
| WIR-004 | Ring terminals, 10 AWG, M6 stud, pack of 25 | 2 | McMaster-Carr | 7113K194 | $8.00 | $16.00 |
| WIR-005 | Ring terminals, 14 AWG, M4 stud, pack of 25 | 1 | McMaster-Carr | 7113K192 | $7.00 | $7.00 |
| WIR-006 | Heat shrink tubing, assorted sizes, 150pcs kit | 1 | McMaster-Carr | 7854K18 | $15.00 | $15.00 |
| WIR-007 | Cable ties, 200mm, UV-resistant, pack of 100 | 1 | McMaster-Carr | 7130K16 | $6.00 | $6.00 |
| WIR-008 | Spiral wrap, 12mm, polyethylene, 10m | 1 | McMaster-Carr | 7402K11 | $9.00 | $9.00 |
| WIR-009 | Silicone sealant, RTV, high-temp, clear, 90mL | 1 | Permatex | 81160 | $14.00 | $14.00 |
| WIR-010 | Isopropyl alcohol, 99.9%, 500mL | 1 | MG Chemicals | 824-500ML | $9.00 | $9.00 |

### 5.6 J1772 Extension Cables (Sold Separately)

| Item # | Description | Qty | Supplier | Part Number | Unit Cost | Extended (×4) |
|--------|-------------|-----|----------|-------------|-----------|---------------|
| CAB-001 | J1772 extension cable, 7.6m (25ft), 40A rated, UL listed | 4 | Lectron | J1772-EXT-25FT | $189.00 | $756.00 |

**Total Master BOM Cost (Hub Only, excluding extension cables):** $2,847.40 (prototype quantity)  
**Estimated Production Cost (100+ units):** $1,450 — $1,780

---

## 6. Bill of Materials — CSM Specialized Components

The following components are manufactured in-house at Carrington Storm Motors using CSMFAB-published processes. They may be substituted with commercial alternatives where noted.

| CSM Part # | Description | Reference Fab | Substitute | Cost |
|------------|-------------|---------------|------------|------|
| CSM-BFRP-RIB-001 | Basalt Fiber Reinforced Polymer structural ribs | CSMFAB09 | Aluminum angle brackets | $24/kit |
| CSM-MX-SPRAY-100 | MXene Ti₃C₂Tₓ EMI shielding spray, 100mL | CSMFAB01 derivative | Copper foil tape | $45/unit |
| CSM-PILOT-PCB-001 | ATmega328P J1772 pilot signal module, assembled | Open-source Gerber | Commercial EVSE controller | $28/unit |
| CSM-CTL-PCB-051 | Custom control PCB for Volt-Link 051 | Open-source Gerber | Point-to-point wiring | $42/unit |
| CSM-PG-SPREADER-001 | Pyrolytic graphite heat spreader, 400×280×3mm | CSMQuantum synthesis | Aluminum heat sink | $38/unit |
| CSM-PIEZO-SENSOR-001 | KNbO₃-BaTiO₃ piezoelectric charge state sensor | CSMQuantum synthesis | Not required (optional) | $18/unit |

**CSM Materials Cost Add:** $195.00 (all six items)  
**Total with CSM components:** $3,042.40

---

## 7. Required Tools and Equipment

### 7.1 Hand Tools
- Screwdriver set (Phillips #0, #1, #2; flat 2mm, 3mm, 5mm)
- Hex key set (metric, 1.5mm-10mm)
- Socket set (metric, 4mm-13mm, with ratchet)
- Torque screwdriver (0.5-6.0 N·m range)
- Wire strippers (10-26 AWG, automatic)
- Crimping tool (for insulated terminals, 10-22 AWG)
- Crimping tool (for open-barrel terminals, heavy-duty, up to 6 AWG)
- Cable cutter (up to 2 AWG)
- Needle-nose pliers
- Diagonal cutters (flush)
- Utility knife
- Deburring tool
- Center punch
- Step drill bit set (for enclosure panel holes, 4-32mm)
- Drill and drill bit set (HSS, 1mm-13mm)
- Bench vise with soft jaws
- Files (flat, round, half-round)
- Digital calipers (0.01mm resolution)
- Steel ruler (600mm)
- Scriber

### 7.2 Electrical and Electronic Tools
- Digital multimeter (CAT III 600V minimum, true RMS) — Fluke 87V or equivalent
- Insulation resistance tester (megohmmeter, 500V/1000V test voltages)
- Oscilloscope (100 MHz, 4-channel, isolated inputs recommended)
- DC power supply (0-30V, 0-5A, dual output)
- Electronic load (0-500V, 0-10A, programmable — for rectifier testing)
- LCR meter (for capacitor and inductor verification)
- Thermal camera or infrared thermometer (-20°C to +150°C range)
- Soldering station (temperature-controlled, 60W minimum, with fine tip)
- Desoldering pump and solder wick
- Solder (lead-free, SnCuAg, 0.5mm, flux core)
- Flux pen (no-clean)
- Helping hands / PCB holder
- Anti-static mat (ESD safe, with wrist strap and ground cord)
- Heat gun (for heat shrink, variable temperature)
- CAN bus analyzer (PCAN-USB or equivalent, with D-Sub 9 connector)
- J1772 test adapter (with status LEDs, for verifying pilot signal)
- CCS protocol analyzer (for end-to-end communication testing)
- EV charge station simulator (for testing without vehicle)

### 7.3 Fabrication Equipment
- Drill press (or CNC mill for enclosure panel work)
- Bench grinder or belt sander (for aluminum edge finishing)
- Tap and die set (M3-M8, metric)
- Rivet nut tool (M3-M8, for threaded inserts in enclosure)
- 3D printer (FDM, for jigs and brackets — optional but recommended)
- Spray booth or well-ventilated area with respirator (for MXene spray application)
- Ultrasonic cleaner (for PCB cleaning)
- Hot air rework station (for SMD rework if needed)

### 7.4 Test and Safety Equipment
- CAT III 1000V insulated hand tools (screwdrivers, pliers)
- Arc flash PPE (face shield 8 cal/cm², FR clothing, Class 0 gloves)
- Lockout/Tagout kit
- Emergency stop button (temporary, for prototype testing)
- Fire extinguisher (Class C, for electrical fires)
- First aid kit
- Ventilation fan (for solder fumes and MXene spray application)

---

## 8. Workspace Preparation

### 8.1 Environmental Requirements
- Ambient temperature: 18-25°C (64-77°F)
- Relative humidity: 30-60% (non-condensing)
- Lighting: 500-750 lux at work surface
- ESD protection: Conductive flooring or anti-static mat, humidity control
- Ventilation: Fume extraction for soldering station, spray booth ventilation for MXene application
- Cleanliness: ISO Class 8 (Class 100,000) or better for PCB assembly area

### 8.2 Work Surface Layout
- Primary bench (2m × 1m minimum): Mechanical assembly, enclosure work
- Secondary bench (1.5m × 1m): PCB assembly, soldering, electronics testing
- Test area: Designated high-voltage zone with safety barriers, warning signs, emergency stop
- Storage: ESD-safe component bins, wire rack, chemical storage cabinet for MXene spray

### 8.3 Documentation
Before beginning fabrication, review all referenced documents:
- CSMFAB09: BFRP Rebar Fabrication Plan (structural rib production)
- CSMFAB01: Aegis-C Composite Shielding Design (MXene spray application procedure)
- CSMQuantum: MXene Synthesis and Characterization
- CSMQuantum: Pyrolytic Graphite Production Methodology
- IEC 61851-1: Electric vehicle conductive charging system — General requirements
- IEC 61851-23: DC electric vehicle charging station
- ISO 15118: Road vehicles — Vehicle to grid communication interface
- SAE J1772: Electric Vehicle Conductive Charge Coupler
- UL 2202: Electric Vehicle (EV) Charging System Equipment
- NEC Article 625: Electric Vehicle Charging System

### 8.4 Safety Briefing
Conduct a mandatory safety briefing with all personnel involved in fabrication:
1. Location of emergency stop, fire extinguisher, first aid kit, and eyewash station
2. High-voltage safety protocols: no lone working, verify zero energy, LOTO procedures
3. Capacitor discharge hazards: wait 120 seconds, measure voltage before touching
4. Chemical safety: MXene spray SDS, proper respirator use, ventilation requirements
5. Arc flash boundaries: 18-inch minimum approach distance for exposed 500V DC conductors
6. Emergency procedures: electrical shock response, fire response, incident reporting

---

## 9. Fabrication Steps 1-10: Enclosure and Structural Assembly

### Step 1: Enclosure Inspection and Preparation
1. Remove the aluminum 6061-T6 enclosure from packaging
2. Inspect all surfaces for dents, scratches, or sharp edges
3. Mark the front panel layout using a scriber and steel ruler:
   - Four J1772 inlet ports (95mm × 55mm cutouts), evenly spaced at 90mm centers, centered vertically
   - LCD display cutout (105mm × 65mm), centered in upper front panel
   - Emergency stop button (22mm diameter hole), top right corner
   - Status indicator LED holes (4 × 5mm), below LCD display
4. Mark the rear panel layout:
   - CCS Combo 1 output connector cutout (80mm × 65mm), centered
   - Two fan cutouts (80mm × 80mm), centered on left and right rear quadrants
   - Ventilation slot pattern (6 × 100mm slots, 4mm wide, 8mm spacing), lower rear panel
5. Mark side panel ventilation (both left and right sides):
   - Inlet vent pattern (8 × 80mm slots, 4mm wide, 8mm spacing), lower side panels
6. Center punch all hole locations

### Step 2: Front Panel Machining
1. Secure the front panel to the drill press table with soft-jaw clamps, protecting the finish with masking tape
2. Drill pilot holes (3mm) at all marked locations
3. Drill 5mm holes for status indicator LEDs
4. Drill 22mm hole for emergency stop button using step drill
5. Drill M4 clearance holes (4.5mm) for J1772 inlet port mounting flanges (4 holes per inlet, 16 holes total)
6. Drill M3 clearance holes (3.5mm) for LCD display mounting brackets (4 holes)
7. Enlarge J1772 inlet port cutouts using a jigsaw or CNC mill — cut 2mm inside the marked line, then file to final dimension
8. File all cut edges smooth and deburr thoroughly
9. Clean front panel with isopropyl alcohol (IPA) to remove cutting oil and metal dust
10. Verify all components fit their respective cutouts before proceeding

### Step 3: Rear Panel and Side Panel Machining
1. Drill 80mm fan mounting holes (4 × M4 clearance per fan, 8 holes total) on rear panel
2. Cut fan cutouts using jigsaw or CNC mill — leave mounting flange area intact
3. Cut ventilation slots using jigsaw — 4mm wide slots, 8mm spacing, 100mm length
4. Drill CCS connector mounting holes (6 × M5 clearance, pattern per Phoenix Contact datasheet)
5. File and deburr all cut edges
6. Repeat ventilation slot cutting and deburring for left and right side panels (inlet vents)
7. Drill CHAdeMO adapter strain relief mounting hole (M6 clearance) on bottom panel
8. Clean all panels with IPA

### Step 4: EMI Shielding Application — Interior Coating
1. **SAFETY:** Don nitrile gloves, safety glasses, and organic vapor respirator
2. Work in a well-ventilated spray booth or outdoor area with no ignition sources
3. Mask all connector cutouts from the interior side using painter's tape — MXene coating must not contact connector terminals
4. Mask threaded inserts, ground stud locations, and screw hole areas (5mm radius around each) — maintaining electrical continuity at grounding points
5. Shake CSM-MX-SPRAY-100 bottle vigorously for 60 seconds
6. Apply first coat: hold bottle 200mm from surface, spray in even, overlapping passes, achieving approximately 15µm wet thickness
7. Allow 30 minutes drying time at 25°C (or 45 minutes below 20°C)
8. Apply second coat: perpendicular to first coat direction, achieving target 45µm total dry thickness
9. Allow full cure: 4 hours at 25°C, or 2 hours at 40°C (use heat lamp if available)
10. Verify coating coverage with a bright flashlight — no bare aluminum should be visible through the coating
11. Measure coating thickness at 5 random points using a digital coating thickness gauge — acceptable range 38-52µm
12. Verify electrical continuity between coating and enclosure grounding points using multimeter continuity test — all points should show <1Ω

### Step 5: BFRP Structural Rib Installation
1. Inspect CSM-BFRP-RIB-001 composite structural ribs for delamination or fiber exposure
2. Test-fit the ribs in the enclosure — they should fit snugly against the long internal walls, positioned at 1/3 and 2/3 of the enclosure depth
3. Mark rib mounting hole locations through the enclosure side walls (4 holes per rib, M4 clearance)
4. Remove ribs, drill M4 clearance holes (4.5mm) at marked locations
5. Install M4 rivet nuts in enclosure side wall holes using rivet nut tool
6. Re-insert BFRP ribs and secure with M4 × 12mm stainless steel screws (do not overtighten — 1.5 N·m torque maximum for composite material)
7. Apply a small bead of silicone sealant along the rib-to-enclosure interfaces for vibration damping
8. Allow sealant to cure for 24 hours before proceeding

### Step 6: Grounding System Installation
1. Identify the enclosure grounding point — the bottom panel, near the rear
2. Drill and tap M6 hole for main ground stud
3. Install M6 × 20mm brass ground stud with internal and external toothed lock washers
4. Measure resistance between ground stud and all enclosure panels: must be <0.5Ω
5. Install grounding bus bar (4-position, brass) adjacent to ground stud on bottom panel, secured with M4 screws into rivet nuts
6. Prepare ground bonding straps (10 AWG wire with M6 ring terminals, 150mm length) — quantity 6: one for each rectifier module, one for control PCB, one for output contactor
7. Label each bonding strap with its destination using heat shrink label tubing
8. Install all bonding straps to grounding bus bar, routing along enclosure walls to their destinations — leave unterminated at destination end until component installation

### Step 7: Fan and Filter Installation
1. Install 80mm fan finger guards on the exterior side of rear panel fan cutouts using M4 × 20mm screws and nylon lock nuts
2. Install fans on the interior side, oriented for exhaust (airflow arrow pointing OUT of enclosure), using M4 × 30mm screws, nylon standoffs, and nylon lock nuts
3. Crimp 2-pin 0.1" connector onto fan power leads (red = 12V+, black = GND)
4. Route fan power leads along enclosure wall to control PCB area using cable tie mounts and spiral wrap
5. Install intake filter media foam in side panel ventilation slots, securing with adhesive-backed filter retainer clips
6. Test fan operation: connect to 12V DC bench supply, verify rotation direction, check for excessive vibration or noise

### Step 8: J1772 Inlet Port Installation
1. Inspect each J1772 inlet port for damage to pins or sealing surfaces
2. Apply a thin bead of silicone sealant around the mounting flange of each inlet
3. Insert each inlet through its respective front panel cutout from the exterior
4. Secure each inlet with four M4 × 16mm stainless steel screws and nylon lock nuts from the interior — torque to 1.5 N·m
5. Verify the J1772 latch mechanism on each inlet operates smoothly
6. Connect the pilot/proximity signal wires (22 AWG) from each inlet to its corresponding ATmega328P pilot signal module:
   - Pin 1 (L1): Not connected (rectifier handles AC input directly)
   - Pin 2 (N/Neutral): Not connected
   - Pin 3 (Equipment Ground/PE): Connect to enclosure grounding bus bar via 10 AWG green wire with ring terminal
   - Pin 4 (Control Pilot/CP): Connect to pilot module CP input via 22 AWG wire, soldered and heat-shrink insulated
   - Pin 5 (Proximity Detect/PD): Connect to pilot module proximity input via 22 AWG wire
7. Secure AC power leads from each inlet (L1 and N — 10 AWG) to the input contactor input terminals — leave contactor output unterminated until rectifier installation
8. Label all wires with inlet number using heat shrink labels

### Step 9: CCS Combo 1 Output Connector Installation
1. Inspect the CCS connector for any damage
2. Apply silicone sealant around the connector's rear panel mounting flange
3. Insert the connector through the rear panel cutout from the exterior
4. Secure with six M5 × 20mm stainless steel screws and nylon lock nuts — torque per Phoenix Contact specification (typically 3-4 N·m)
5. The CCS connector has the following internal connections:
   - DC+ (Pin 1): 50mm² contact — connect to output contactor output via 6 AWG red wire, ring terminal
   - DC- (Pin 2): 50mm² contact — connect to DC bus negative rail via 6 AWG black wire, ring terminal
   - PE (Ground): Connect to main ground stud via 10 AWG green/yellow wire
   - CP (Control Pilot, Pin 3): Connect to control PCB J1772 pilot output — 22 AWG
   - PP (Proximity Pilot, Pin 4): Connect to control PCB proximity input — 22 AWG
   - PLC coupling transformer secondary: Connect to STM32 board via 22 AWG twisted pair, 100mm maximum length, for HomePlug Green PHY CCS communication
6. Secure the CCS cable with a cable tie mount near the strain relief point inside the enclosure
7. Verify all contacts are fully seated and locked in the connector housing

### Step 10: Cable Gland and Strain Relief Installation
1. Install PG16 cable glands in the bottom panel for:
   - J1772 extension cable entries (one gland per channel, though extension cables connect externally — these glands are for internal auxiliary power and communications)
   - External 12V auxiliary power supply input (if not using vehicle 12V battery)
   - USB-C port for firmware updates (waterproof bulkhead connector)
2. Install strain relief clamps on the interior near each cable entry point
3. Apply silicone sealant around each gland where it enters the enclosure for IP65 compliance
4. Allow sealant to cure for 2 hours before handling cables

---

## 10. Fabrication Steps 11-20: Input Rectifier Stage

### Step 11: SiC Rectifier Module Preparation — Channel 1
1. Unpack the Wolfspeed CRD-06600FF065N evaluation board
2. Inspect for shipping damage, missing components, or solder defects
3. Install the board on an anti-static mat
4. Review the board's schematic and identify test points:
   - AC input terminals (L and N)
   - DC output terminals (+ and -)
   - Auxiliary power input (12V DC)
   - Enable signal input
   - Fault output signal
   - I²C/SMBus communication header (for temperature and status monitoring)
5. Configure the board for the Volt-Link application:
   - Set output voltage trim potentiometer to achieve 400V DC open-circuit output (measure with DMM during bench test — do NOT adjust with power applied)
   - Verify the default switching frequency is 65 kHz (per CRD-06600FF065N datasheet)
   - Connect the I²C header to a 4-pin JST connector with 150mm wire length for connection to the control PCB
   - Install a 40mm × 40mm × 10mm aluminum heat sink on the auxiliary gate driver IC if not factory-installed
6. Label the board "CH1" with a permanent marker on the PCB edge

### Step 12: SiC Rectifier Module Bench Test — Channel 1
1. Place the rectifier board in the test area, secured to a non-conductive surface
2. Connect a 12V DC bench supply to the auxiliary power input — verify current draw < 500mA (gate driver quiescent)
3. Connect the enable signal to GND (disabled state)
4. Connect an AC variable autotransformer (Variac) set to 0V to the AC input terminals through a 5A circuit breaker
5. Connect a 200W resistive load (e.g., 800Ω at 400V) to the DC output terminals through a DC-rated switch (open)
6. Power sequence:
   a. Apply 12V auxiliary power
   b. Verify no fault signal (FAULT pin high = no fault)
   c. Slowly increase Variac output to 120V AC while monitoring DC output with isolated oscilloscope probe
   d. DC output should track approximately 1.7 × Vrms (200V DC at 120V AC input with open-loop operation)
   e. Increase to 240V AC — verify DC output reaches 340V DC minimum, 400V DC nominal
7. Close the DC load switch — verify the board delivers power to the load (200W at 400V DC = 0.5A)
8. Monitor board temperature with thermal camera — no component should exceed 60°C at 200W load with free-air convection
9. Test the overcurrent protection: momentarily short the DC output through a high-power resistor (10Ω, 500W) — the board should enter fault mode (FAULT pin LOW)
10. Remove power, discharge all capacitors, verify zero energy
11. Record test results: efficiency at 240V/6.6kW simulated load, thermal profile, fault response time
12. Repeat Steps 11-12 for Channels 2, 3, and 4

### Step 13: Pilot Signal Module Assembly — Channel 1
1. Retrieve a CSM-PILOT-PCB-001 assembled board
2. Inspect solder joints on the ATmega328P, 12V to 5V regulator, and CP output driver (op-amp with ±12V swing capability per SAE J1772 specification)
3. Program the ATmega328P with the Volt-Link pilot signal firmware:
   a. Connect USBasp programmer to ISP header
   b. Flash CSM-PILOT-FW-V1.0.hex using AVRDUDE:
      `avrdude -c usbasp -p m328p -U flash:w:CSM-PILOT-FW-V1.0.hex`
   c. Set fuses for 16 MHz external crystal: `avrdude -c usbasp -p m328p -U lfuse:w:0xFF:m -U hfuse:w:0xD9:m -U efuse:w:0xFD:m`
4. Configure the module's communication address via DIP switch:
   - Channel 1: Address 0x01 (SW1 ON, SW2-SW4 OFF)
5. Install a 4-pin JST connector for the CAN bus interface (CAN_H, CAN_L, +12V, GND)
6. Label "CH1 PILOT" with permanent marker

### Step 14: Pilot Signal Module Bench Test — Channel 1
1. Connect 12V DC power to the pilot module
2. Connect an oscilloscope to the CP output
3. Verify the 1 kHz, ±12V square wave pilot signal is generated (State A — vehicle not connected)
4. Connect a J1772 test adapter to simulate a connected vehicle — the pilot voltage should drop to +9V/-12V (State B — vehicle detected)
5. Place a 2.74kΩ resistor between CP and PE to simulate "ready to charge" — pilot should transition to +6V/-12V (State C — charging enabled)
6. Verify the pilot module reports status correctly on CAN bus (use CAN analyzer to monitor address 0x01, message ID 0x100)
7. Test the module's GFCI function: inject a 25mA current imbalance between L1 and N — the module should de-assert the CP signal within 200ms
8. Record test results: CP waveform quality, CAN communication integrity, GFCI trip time
9. Repeat Steps 13-14 for Channels 2, 3, and 4 (address 0x02, 0x03, 0x04)

### Step 15: Input Contactor Assembly — Channel 1
1. Retrieve a TE Connectivity T9AP1D52-12 AC contactor
2. Install the contactor on a DIN rail segment (50mm length) inside the enclosure, lower section, near Channel 1's J1772 inlet
3. The DIN rail should be secured to the enclosure bottom panel using 3M VHB tape and two M4 screws into rivet nuts
4. Connect J1772 inlet AC leads (L1 and N, 10 AWG) to contactor input terminals (L1_IN and L2_IN): strip 12mm, insert fully, torque to 2.0 N·m
5. Connect contactor output terminals to the SiC rectifier AC input using 10 AWG wire — label "CH1 AC RECT IN" — leave unterminated at rectifier end until rectifier installation
6. Connect contactor coil (A1 = 12V+, A2 = GND) to the relay module using 18 AWG wire:
   - Route wire through spiral wrap to the SainSmart relay module location
   - Label "CH1 CONT COIL"
7. Install a reverse-biased 1N4007 flyback diode across the contactor coil terminals (cathode to A1/12V+, anode to A2/GND) to suppress inductive kickback
8. Install an AC-rated fuse holder with 40A class CC fuse in series with the contactor input line — mounted on DIN rail adjacent to contactor
9. Repeat for Channels 2, 3, and 4

### Step 16: Rectifier Module Mounting — All Channels
1. Position the pyrolytic graphite heat spreader (CSM-PG-SPREADER-001, 400×280×3mm) on the enclosure bottom panel
2. The spreader should rest on 6mm silicone thermal pads at four corner mounting points for vibration isolation — do NOT rigidly bolt the spreader directly to the aluminum base (thermal expansion mismatch)
3. Mark rectifier board mounting positions on the heat spreader — each rectifier occupies a 120mm × 80mm footprint
4. Layout (looking down into enclosure from front to rear):
   - Channel 1: Front-left (20mm from front, 15mm from left)
   - Channel 2: Front-right (20mm from front, 15mm from right)
   - Channel 3: Rear-left (flush with rear fan wall, 15mm from left)
   - Channel 4: Rear-right (flush with rear fan wall, 15mm from right)
5. Apply a thin, even layer of thermal paste (Arctic MX-6 or equivalent, thermal conductivity >6 W/m·K) to the area beneath each rectifier
6. Secure each rectifier board to the heat spreader using M3 nylon screws and nylon standoffs (6mm height) — do NOT use metal fasteners that could short PCB traces
7. Connect each rectifier's AC input to its corresponding contactor output (10 AWG wire, ring terminals, torque 2.0 N·m)
8. Connect each rectifier's DC output (+ and -) to the DC bus bar assembly using 10 AWG wire with ring terminals — leave bus connections unterminated until Step 22
9. Connect each rectifier's auxiliary power (12V), enable signal, fault signal, and I²C/SMBus wires to the control PCB area using labeled 22-24 AWG wires — group by channel, secured with cable ties every 50mm
10. Connect the CSM piezo charge state sensor (optional, CSM-PIEZO-SENSOR-001) to each rectifier's DC output using a voltage divider to scale 400V to the sensor's 5V input range — mount sensor on rectifier heat sink for temperature-compensated charge rate monitoring

### Step 17: Pilot Module Mounting — All Channels
1. Locate the pilot module mounting area: top section of enclosure side walls, between the J1772 inlets and the BFRP structural ribs
2. Install 3D-printed or aluminum mounting brackets on the side wall using M3 rivet nuts
3. Secure each CSM-PILOT-PCB-001 to its bracket with M3 nylon screws and standoffs
4. Route the CP and proximity wires from each J1772 inlet to its corresponding pilot module
5. Connect the CAN bus daisy chain:
   - Channel 1 CAN_H to Channel 2 CAN_H, Channel 1 CAN_L to Channel 2 CAN_L
   - Continue daisy chain through Channels 3 and 4
   - Terminate with 120Ω resistor between CAN_H and CAN_L at the last module (Channel 4)
6. Connect Channel 1's CAN bus to the control PCB CAN2 port via twisted pair (22 AWG, 3 twists per 25mm)
7. Connect 12V power to each pilot module in parallel from a central 12V bus (18 AWG wire, fused at 5A)
8. Verify all pilot module DIP switches are set to unique addresses (0x01, 0x02, 0x03, 0x04)

### Step 18: DC Output Contactor Assembly — Per Channel
1. For each channel, retrieve a TE Connectivity LEV200A4NAA DC contactor (20A rated)
2. Mount each contactor on a DIN rail segment adjacent to its corresponding rectifier's DC output
3. Connect each rectifier's DC positive output through a Vishay VS-30CPQ060-N3 dual Schottky blocking diode module (anode to rectifier, cathode to DC bus) to the DC contactor input:
   - Rectifier DC+ → Diode Anode via 10 AWG red wire, ring terminal
   - Diode Cathode → Contactor input (L1) via 10 AWG red wire, ring terminal
4. Connect the rectifier's DC negative output directly to the DC bus negative rail — no contactor or diode on the negative leg
5. Connect the DC contactor output to the main DC bus positive rail via 10 AWG red wire — leave bus bar unterminated until Step 22
6. Connect contactor coil (A1 = 12V+, A2 = GND) to the relay module using 18 AWG wire, labeled per channel
7. Install flyback diode across each contactor coil
8. Install a 500V-rated 1µF film capacitor between each DC contactor output terminal and chassis ground for noise suppression — keep lead length <25mm

### Step 19: Wiring Harness — Input Stage
1. Create a master wiring document mapping every wire by color, gauge, length, origin, and destination
2. Build the AC power wiring harness using 10 AWG silicone wire:
   - Four inlet-to-contactor pairs (red L1, black N)
   - Four contactor-to-rectifier pairs (red L1, black N)
   - Each pair is 300mm maximum length, twisted at 2 twists per 25mm for EMI reduction
3. Build the DC power wiring harness using 10 AWG silicone wire:
   - Four rectifier-to-diode pairs (red DC+, 200mm max)
   - Four diode-to-contactor pairs (red DC+, 150mm max)
   - Four contactor-to-bus pairs (red DC+, 200mm max)
   - Four rectifier-to-bus negative pairs (black DC-, 200mm max)
4. Build the signal wiring harness using 22-24 AWG wire:
   - Four CP/proximity pairs from inlets to pilot modules (200mm max, shielded)
   - CAN bus daisy chain for pilot modules (22 AWG twisted pair, 3 twists per 25mm)
   - I²C/SMBus wires from each rectifier to control PCB (4 × 4-pin, 300mm)
   - Contactor coil wires to relay module (8 × 2-pin, 18 AWG, 400mm max)
5. All harness wires must be:
   - Crimped with correct terminals for their destination
   - Labeled at both ends with heat shrink labels showing origin→destination
   - Secured with cable ties at 75mm intervals
   - Routed separately from signal wires (minimum 50mm separation between AC/DC power and signal bundles)

### Step 20: Input Stage System Test
1. **SAFETY BRIEFING:** Before applying any power, verify:
   - All personnel behind arc flash boundary
   - Emergency stop accessible and tested
   - Fire extinguisher present
   - No loose tools or debris in enclosure
   - All connections torqued to specification
2. Connect only Channel 1 to a J1772 test adapter (simulating a charging station)
3. Apply 12V auxiliary power to the system
4. Verify the pilot module reports "vehicle not connected" state on CAN bus
5. Connect a vehicle simulator (CCS protocol) to the output connector
6. The pilot module should detect the vehicle and transition through States A, B, C as described in SAE J1772
7. Enable only Channel 1 rectifier via the control system
8. On the test bench (with resistive load, NOT a real vehicle), verify:
   - Channel 1 draws AC current from the J1772 simulator
   - DC output voltage rises to commanded level
   - No fault signals asserted
9. Record all measurements
10. Repeat for Channels 2, 3, and 4 individually
11. Test combined operation of all four channels at 50% load (3.3 kW per channel, 13.2 kW total) into a resistive load bank
12. Monitor temperatures for 30 minutes — no component should exceed 70°C
13. Shut down, discharge all capacitors, verify zero energy

---

## 11. Fabrication Steps 21-30: DC Bus and Output Stage

### Step 21: DC Bus Bar Fabrication
1. Cut the 6mm × 25mm aluminum bus bar stock to required lengths:
   - Positive bus bar: 400mm length (spans all four channel DC contactor outputs to the main output contactor)
   - Negative bus bar: 400mm length (spans all four rectifier negative returns)
2. Mark and drill M5 clearance holes (5.5mm) at 90mm spacing for positive bus (4 connections for channels, 1 connection for output contactor)
3. Mark and drill M5 clearance holes at 90mm spacing for negative bus (4 connections, plus main negative output lug)
4. File all edges smooth and deburr all holes
5. Clean bus bars with IPA and apply a thin coat of antioxidant compound (Noalox or equivalent) to all contact surfaces
6. Install positive bus bar on insulated standoffs (M5 nylon, 15mm height) on the enclosure bottom panel, positioned between the rectifier/contactor area and the output contactor
7. Install negative bus bar similarly on separate insulated standoffs, minimum 25mm separation from positive bus bar for creepage/clearance requirements
8. Install clear polycarbonate shield over bus bars (3mm thick, 50mm clearance above bars) secured with M4 nylon screws — label "DANGER — 500V DC BUS"

### Step 22: DC Bus Capacitor Bank Assembly
1. Prepare the four 680µF electrolytic capacitors:
   - Verify capacitance and ESR using LCR meter (each capacitor should measure 680µF ±20%, ESR <150mΩ at 100 Hz)
   - DO NOT use capacitors that have been in storage >2 years without reforming (gradually apply rated voltage through current-limiting resistor over 2 hours)
2. Mount capacitor clamp brackets to the enclosure bottom panel using M4 rivet nuts — position between the rectifier DC output contactors and the main output contactor
3. Secure each capacitor in its clamp with the supplied band — do NOT overtighten (capacitor cans may deform)
4. Wire the capacitors in parallel on the bus bars:
   - Positive terminals to positive bus bar via 10 AWG wire × 50mm length with ring terminals (M5)
   - Negative terminals to negative bus bar via 10 AWG wire × 50mm length
   - Use exactly matched wire lengths for all capacitors to ensure equal current sharing
5. Install the two 10µF film capacitors directly on the bus bars using M4 screw terminals — one at the input end (near the rectifiers) and one at the output end (near the output contactor) for high-frequency bypass
6. Install the bleed resistor network: two 22kΩ, 25W resistors in series between positive and negative bus bars
   - Total resistance: 44kΩ
   - Discharge time constant (RC): 44,000Ω × 2,740µF = 120.5 seconds
   - Time to safe voltage (<50V from 500V): approximately 277 seconds (2.3 × RC)
   - Mount resistors on ceramic standoffs with 25mm minimum clearance to other components (they will reach approximately 85°C during discharge from 500V)
7. Label the capacitor bank area: "WARNING — STORED ENERGY — DISCHARGE TIME 277 SECONDS"

### Step 23: Output Filter Assembly
1. Build the differential-mode LC output filter:
   - Inductor: 47µH, 100A rated, ferrite core (custom wound — 12 turns of 6 AWG magnet wire on Kool Mµ 0077092A7 toroid)
   - Capacitor: 4.7µF, 630V DC, polypropylene film
2. Mount the inductor on the enclosure bottom panel near the output contactor using a non-conductive bracket — do NOT use a metal bracket (eddy current heating in the bracket)
3. Connect the inductor in SERIES with the positive bus bar, between the channel DC contactor outputs and the main output contactor:
   - Inductor input side: Connect to positive bus bar at the output (vehicle) end
   - Inductor output side: Connect to main output contactor input
   - Use 6 AWG wire × 100mm for connections, ring terminals, torque to 5 N·m
4. Connect the filter capacitor between the inductor output (bus side after inductor) and the negative bus bar — keep capacitor leads <50mm
5. Build the common-mode output filter:
   - Common-mode choke: Wurth 74483901000 (2mH, 100A)
   - Connect in series with BOTH positive and negative output lines, between the output contactor output and the CCS connector
6. Install two Y-capacitors (4.7nF, Y1 safety rated, 500V AC) between each output line (DC+ and DC-) and chassis ground, AFTER the common-mode choke, for conducted EMI compliance

### Step 24: Main Output Contactor Installation
1. Retrieve the TE Connectivity LEV200H5ANA output contactor (100A rated, 500V DC)
2. Mount the contactor on a DIN rail segment near the rear of the enclosure, between the output filter and the CCS connector
3. Connect the contactor input:
   - Positive input: From the differential-mode filter inductor output (6 AWG red, ring terminal)
   - Negative input: From the negative bus bar (6 AWG black, ring terminal)
4. Connect the contactor economizer wiring:
   - The LEV200 uses a pulse-width modulated economizer to reduce coil hold current after pull-in
   - Connect economizer control wires to the relay module: ENABLE+ and ENABLE- (18 AWG twisted pair)
   - Connect the economizer's auxiliary contact feedback to a digital input on the control PCB for contactor state monitoring
5. Install the DC-rated semiconductor fuse (Littelfuse L50QS125.V, 125A, 500V DC) in series with the contactor output, mounted on a fuse holder bolted to the enclosure
6. Connect the fuse output to the CCS connector positive terminal via 6 AWG red wire
7. Connect the negative output directly from the negative bus bar to the CCS connector negative terminal via 6 AWG black wire

### Step 25: Ground Fault Detection
1. Install the Bender RCM420-D-2 ground fault detection module:
   - Mount on DIN rail, upper section of enclosure, near the control PCB
   - The RCM420 monitors the vector sum of DC+ and DC- currents — any imbalance >30mA indicates a ground fault
2. Route both DC+ and DC- output wires (AFTER the output contactor, BEFORE the CCS connector) through the RCM420's 25mm diameter current transformer core — both wires must pass through in the SAME direction
3. Connect the RCM420's 12V DC power supply (consume approximately 2W)
4. Connect the RCM420's alarm relay output (normally-closed contact) in series with the output contactor coil power — a ground fault will de-energize the output contactor
5. Connect the RCM420's RS-485 communication to the control PCB for ground fault current monitoring and data logging
6. Configure the RCM420 via the front-panel DIP switches:
   - Response value IΔn: 30 mA
   - Operating mode: DC
   - Fault memory: ON (latching)
   - Reset: Manual (via control PCB digital output or front panel button)
7. Test the ground fault function:
   - Connect a 33kΩ, 10W resistor between DC+ and chassis ground (creates approximately 15mA leakage at 500V — NOT enough to trip)
   - Verify the RCM420 does NOT trip at 15mA
   - Remove test resistor
   - Connect a 15kΩ, 25W resistor between DC+ and chassis ground (creates approximately 33mA leakage — SHOULD trip)
   - Verify the RCM420 trips within 200ms and de-energizes the output contactor
   - Remove test, reset the RCM420, verify normal operation

### Step 26: Junction Temperature Sensor Network
1. Install the eight DS18B20 temperature sensors at critical monitoring points:
   - TS1: Channel 1 SiC rectifier heat sink (attach with thermally conductive epoxy to MOSFET case)
   - TS2: Channel 2 SiC rectifier heat sink
   - TS3: Channel 3 SiC rectifier heat sink
   - TS4: Channel 4 SiC rectifier heat sink
   - TS5: DC bus capacitor bank (attach to capacitor can midpoint with Kapton tape)
   - TS6: Output contactor terminal (attach to output lug with Kapton tape)
   - TS7: CCS connector cable entry (ambient reference, near cable gland)
   - TS8: Control PCB area (ambient interior)
2. Wire all DS18B20 sensors using the 1-Wire bus (daisy chain):
   - VDD (red) to 3.3V power bus
   - DQ (yellow) — data line — daisy chain all sensors, terminate with 4.7kΩ pull-up to 3.3V at the control PCB end
   - GND (black) to common ground
3. Route the 1-Wire bus to the control PCB using 22 AWG ribbon wire, secured with cable tie mounts
4. Verify each sensor reports the correct 64-bit ROM address using the STM32's 1-Wire driver — record all addresses for firmware configuration
5. Test all sensors at ambient temperature — readings should be within ±2°C of ambient

### Step 27: Current Sensor Installation
1. Install ACS758 Hall-effect current sensors:
   - CS1 through CS4: One per input channel, installed in series with each rectifier DC output BEFORE the blocking diode (measures per-channel DC output current, 0-20A range)
   - CS5: Main output current, installed in series with the output contactor positive lead (0-100A range)
2. Each ACS758 is a PCB-mount device — solder each to a small breakout PCB (2.54mm pitch) with:
   - IP+ and IP- terminals (the current-carrying path — use 10 AWG wire to connect in series with the measured circuit)
   - VCC (5V power from control PCB)
   - GND
   - VIOUT (analog output, 0.5V at 0A, ratiometric to VCC, 20mV/A sensitivity for ±100B variant)
3. Mount each current sensor PCB on a 3D-printed bracket secured to the enclosure bottom panel near its measurement point
4. Connect each VIOUT signal to an analog input on the control PCB — use 100nF bypass capacitor at the ADC input
5. Calibrate each sensor:
   - With zero current, measure VIOUT — should be VCC/2 (typically 2.5V) ±25mV
   - Pass a known current (e.g., 10.00A from a calibrated DC supply) through the sensor
   - Record VIOUT and calculate the calibration factor: sensitivity = (VIOUT_at_current - VIOUT_zero) / current
   - Store calibration factors in firmware configuration

### Step 28: Control PCB Assembly
1. Order the CSM-CTL-PCB-051 printed circuit board from a PCB manufacturer using the open-source Gerber files:
   - 2-layer FR-4, 1.6mm thickness, 1oz copper
   - Green solder mask, white silkscreen
   - HASL (lead-free) surface finish
2. Upon receipt, inspect all traces for shorts or opens using a multimeter
3. Solder the STM32F407VGT6 onto the PCB (or use the Discovery board's pin headers if using the development board approach)
4. Solder all supporting components:
   - Two MCP2551 CAN transceivers with 120Ω termination resistors and common-mode chokes
   - 3.3V and 5V voltage regulators (LM1117-3.3 and LM7805) with appropriate input/output capacitors
   - MicroSD card socket (push-push type)
   - 32.768 kHz crystal for RTC
   - Reset button (tactile switch, through-hole)
   - JTAG/SWD programming header (10-pin, 1.27mm pitch)
   - All screw terminal blocks for field wiring connections
   - ESD protection diodes on all external-facing I/O lines
5. Solder the relay driver section:
   - ULN2803A Darlington transistor array for driving 12V relay coils from 3.3V logic
   - Flyback diodes per output channel
   - 8 × 3-pin screw terminals for relay/contactor coil connections
6. Clean the PCB with IPA and an anti-static brush
7. Inspect all solder joints under magnification (10×)
8. Apply conformal coating (acrylic spray) to protect against moisture and dust — mask all connectors, buttons, and the SD card socket before spraying
9. Allow conformal coating to cure for 24 hours

### Step 29: Control PCB Bench Test
1. Before connecting to ANY high-voltage circuits, test the control PCB independently:
2. Connect 12V DC bench supply — verify 5V and 3.3V rails are within ±5% (use oscilloscope to check for noise)
3. Connect ST-Link/V2 programmer to the SWD header — verify communication with the STM32F4
4. Flash the Volt-Link firmware (CSM-VL-FW-V1.0.bin) using STM32CubeProgrammer
5. Verify firmware boots — the LCD should display the Volt-Link splash screen and system status
6. Test all I/O:
   - CAN1: Connect a PCAN-USB, transmit a test message from the STM32, verify reception
   - CAN2: Same test
   - 1-Wire: Verify all 8 DS18B20 sensors are detected and report correct ROM addresses
   - Analog inputs: Apply known voltages (0-3.3V) to each ADC input, verify converted values
   - Digital outputs: Toggle each relay driver output, verify corresponding relay on the SainSmart module activates
   - SD card: Insert formatted FAT32 card, write a test log file, read back and verify
   - Bluetooth: Connect to the nRF52840 module via UART, verify advertising packet is visible on a smartphone BLE scanner
7. Test the LCD: Verify all pixels display correctly, backlight brightness controllable via PWM
8. Test the emergency stop input: Assert the E-stop, verify the firmware enters FAULT state and de-asserts all contactor enables
9. Record all test results — any failures must be debugged and resolved before proceeding

### Step 30: Control PCB Installation in Enclosure
1. Mount the assembled and tested control PCB in the enclosure:
   - Position: Upper section of the enclosure, above the rectifier/contactor area, accessible through the top lid
   - Secure with M3 nylon standoffs (12mm height) into rivet nuts on the enclosure side wall
2. Connect all field wiring to the control PCB screw terminals:
   - CAN1 to CCS connector's PLC coupling transformer (22 AWG twisted pair, 100mm max)
   - CAN2 to pilot module daisy chain (22 AWG twisted pair)
   - 1-Wire bus to DS18B20 sensor network (22 AWG)
   - Analog inputs to ACS758 current sensor VIOUT lines
   - Digital outputs to relay module inputs (8 × 18 AWG)
   - Emergency stop input (normally-closed contact to GND)
   - I²C/SMBus to rectifier modules (4 × 4-pin connectors via I²C multiplexer)
   - LCD display ribbon cable (40-pin FPC, 150mm)
   - Bluetooth UART (4-wire: TX, RX, 3.3V, GND)
   - MicroSD card slot (on-board — accessible through slot in enclosure lid)
3. Mount the relay module:
   - Position adjacent to control PCB, upper section
   - Connect input side to control PCB digital outputs
   - Connect output side to all contactor coils (8 × 2-pin screw terminals)
4. Mount the isolated 12V to 5V/3.3V DC-DC converter (TRACO TMR 3-1211WI):
   - Input: 12V from main auxiliary power bus
   - Output: +5V and +3.3V regulated for control electronics
   - Install on a small DIN rail segment adjacent to the control PCB
5. Wire the auxiliary power bus:
   - 12V input from external supply (or vehicle 12V battery via auxiliary connector)
   - Distributed to: TRACO converter, fans (PWM controller on control PCB), relay module coil power, RCM420 module, pilot signal modules
   - Protected by a 15A automotive-style blade fuse at the input
6. Apply silicone sealant to all cable entry points for IP65 compliance
7. Install the enclosure lid and verify it closes without pinching any wires

---

## 12. Fabrication Steps 31-40: Control Electronics and Firmware

### Step 31: Firmware Architecture Overview
The Volt-Link firmware (CSM-VL-FW-V1.0) is organized into the following modules:

1. **main.c** — System initialization, RTOS task creation, watchdog timer
2. **can_handler.c** — CAN1 (CCS/CHAdeMO vehicle communication) and CAN2 (internal pilot module communication)
3. **ccs_state_machine.c** — CCS charging protocol state machine (per ISO 15118 / DIN 70121)
4. **chademo_handler.c** — CHAdeMO CAN protocol handler
5. **pilot_manager.c** — J1772 pilot signal management and input channel coordination
6. **load_balancer.c** — Dynamic current allocation across input channels
7. **thermal_monitor.c** — DS18B20 temperature monitoring and fan PWM control
8. **fault_manager.c** — Fault detection, logging, and response
9. **ui_manager.c** — LCD display, status LEDs, Bluetooth LE interface
10. **data_logger.c** — microSD card charge session logging
11. **FreeRTOSConfig.h** — Real-time operating system configuration

The firmware uses FreeRTOS with preemptive multitasking:
- Charge control loop: 100 Hz (10ms period)
- Thermal monitoring: 1 Hz
- CAN bus processing: Interrupt-driven, 500 kbps (CAN1) / 125 kbps (CAN2)
- UI update: 10 Hz
- Data logging: Event-driven (on state change)

### Step 32: Firmware Flashing and Configuration
1. Connect ST-Link/V2 programmer to the control PCB's SWD header (10-pin connector)
2. Launch STM32CubeProgrammer on the host PC
3. Connect to the STM32F407VGT6 via SWD interface
4. Perform a full chip erase
5. Flash CSM-VL-FW-V1.0.bin to address 0x08000000 (flash memory start)
6. Set option bytes:
   - Read protection: Level 0 (no protection)
   - BOR level: Level 3 (2.7V threshold)
   - Watchdog: Hardware watchdog enabled
   - Reset: nRST configured as reset input (not GPIO)
7. Verify flash contents against the binary image (checksum comparison)
8. Disconnect ST-Link
9. Power cycle the control PCB
10. Verify the firmware boots correctly:
    - LCD displays "Volt-Link V1.0 — CSMFAB051"
    - Status LED blinks green (1 Hz) indicating "idle, no vehicle connected"
    - CAN bus traffic visible on PCAN-USB for both CAN1 and CAN2
11. Connect to the Bluetooth LE interface using the Volt-Link companion app:
    - Scan for BLE device "VoltLink-XXXX" (XXXX = last 4 digits of serial number)
    - Connect and verify the app displays system status, temperatures, and log access

### Step 33: CCS Protocol Implementation
1. The CCS communication protocol follows DIN 70121 / ISO 15118-2 for DC charging
2. Implement the CCS state machine with the following states:
   - STATE_IDLE: No vehicle connected, output contactor open
   - STATE_CABLE_CHECK: Vehicle detected, performing cable integrity check
   - STATE_PRECHARGE: Output contactor closed with current limiting, DC bus voltage matching vehicle battery voltage
   - STATE_CHARGE_PARAMETER_DISCOVERY: Communication established via HomePlug Green PHY, exchanging charge parameters (max voltage, max current, target SOC)
   - STATE_CHARGE: Active power delivery, current controlled per vehicle BMS request
   - STATE_CHARGE_SUSPEND: Vehicle requested pause
   - STATE_TERMINATE: Normal charge complete or vehicle requested stop
   - STATE_FAULT: Any fault condition — immediate contactor open
3. HomePlug Green PHY modem configuration:
   - The PLC coupling transformer provides the physical layer interface to the CCS connector
   - Use the Qualcomm QCA7000 or QCA7005 PLC modem IC on the control PCB (included in CSM-CTL-PCB-051 design)
   - Configure the QCA7000 via SPI from the STM32F4
   - Set the Network Membership Key (NMK) per the SECC (Supply Equipment Communication Controller) role
4. Test the CCS protocol using a CCS vehicle simulator (e.g., Keysight EV charging test system or open-source pyPLC simulator running on a laptop):
   - Verify the full charging sequence executes without errors
   - Test fault insertion: simulate communication timeout, verify the state machine transitions to STATE_FAULT
   - Test isolation monitoring: the CCS standard requires the EVSE to monitor isolation resistance — verify the RCM420 integration satisfies this requirement

### Step 34: CHAdeMO Protocol Implementation
1. The CHAdeMO protocol uses CAN bus communication at 500 kbps on CAN1 (shared with CCS — only one protocol active at a time)
2. Implement the CHAdeMO state machine (simplified from the CCS state machine):
   - STATE_CHADEMO_IDLE: Waiting for vehicle CHAdeMO connector insertion
   - STATE_CHADEMO_HANDSHAKE: Exchange CAN messages 0x100-0x102 (vehicle and charger identification)
   - STATE_CHADEMO_CHARGE_PARAM: Vehicle sends 0x102 with max voltage, target voltage, and charging time estimate
   - STATE_CHADEMO_CHARGE: Charger sends 0x102 with present voltage setpoint and current limit; vehicle responds with battery status
   - STATE_CHADEMO_TERMINATE: Charger sends 0x102 with charge stop flag
3. Physical layer: CHAdeMO connector has dedicated CAN bus pins — connect these to CAN1 through an opto-isolator (ISO1050) for galvanic isolation per CHAdeMO specification
4. Test the CHAdeMO protocol using a CHAdeMO vehicle simulator

### Step 35: Load Balancing Algorithm
1. The load balancer distributes total requested charge current across the available input channels
2. Algorithm parameters:
   - Max per-channel current: 27.5A DC (6.6 kW / 240V AC → approximately 27.5A at 240V DC equivalent)
   - Channel temperature limit: 85°C SiC MOSFET junction, 75°C heat sink (derate above 65°C)
   - Minimum operating channels: 1 (graceful degradation)
3. Allocation algorithm (executed at 100 Hz):
   a. Read total requested charge current from vehicle BMS (via CCS/CHAdeMO)
   b. Read per-channel available current (limited by J1772 pilot negotiation, typically 27.5A DC after rectification)
   c. Read per-channel heat sink temperatures
   d. For each channel, calculate thermal derating: I_max_ch = 27.5A × (1 - max(0, (T_heatsink - 65°C) / 20°C))
   e. Distribute total current request across channels proportionally to their thermal headroom
   f. If a channel's current allocation exceeds its limit, redistribute excess to other channels
   g. Apply per-channel setpoints via I²C/SMBus commands to each rectifier module
4. Test the load balancer:
   - Simulate progressive thermal rise in one channel — verify current is redistributed to cooler channels
   - Simulate a channel fault — verify the faulted channel is disabled and current redistributed within one control cycle (10ms)
   - Simulate all-four-channel full-load (33 kW) operation — verify stable current sharing within 5% across channels

### Step 36: Thermal Management Control
1. Implement PID control for the two PWM-controlled 80mm fans:
   - Control variable: Maximum of all SiC MOSFET temperatures (use the highest of TS1-TS4)
   - Setpoint: 55°C (fans start at 0% duty at 40°C, ramp to 100% duty at 70°C)
   - PID gains (tuned experimentally): Kp = 3.0, Ki = 0.15, Kd = 0.5 (update rate 1 Hz)
2. Implement overtemperature protection:
   - Warning threshold (any channel): 75°C — reduce charge current by 25%
   - Critical threshold (any channel): 85°C — suspend charging on the affected channel
   - Shutdown threshold (any channel): 95°C — immediately terminate charge session, open contactors, assert fault
3. Implement fan failure detection:
   - Monitor fan tachometer output (RPM signal) on both fans
   - If either fan RPM drops below 500 RPM, assert a warning
   - If both fans fail, suspend charging and assert a fault
4. Test the thermal control loop:
   - Run the system at 33 kW output into a load bank
   - Monitor all eight temperature sensors
   - Verify fans ramp up as temperature increases past 40°C
   - Verify thermal steady-state is reached (temperatures stable within ±2°C) within 30 minutes
   - Document the thermal equilibrium temperatures for the test report

### Step 37: Fault Detection and Response
Implement the following fault detection mechanisms:

1. **Overcurrent Protection:**
   - Per-channel: ACS758 sensor, hardware trip at 30A DC (125% of rated)
   - Main output: ACS758 sensor, hardware trip at 110A DC
   - Firmware: Fast loop (1 kHz) monitors currents, software trip 5% below hardware trip

2. **Overvoltage / Undervoltage Protection:**
   - DC bus voltage monitored via voltage divider and ADC
   - Overvoltage: Above 520V DC for >100ms → immediate contactor open
   - Undervoltage: Below 180V DC while charging → suspect input loss, gracefully terminate

3. **Ground Fault Protection:**
   - RCM420 module provides hardware trip at 30mA leakage
   - Firmware monitors RS-485 data from RCM420 for trending (5mA resolution)

4. **Isolation Monitoring:**
   - Per IEC 61851-23, monitor isolation resistance between DC bus and chassis ground
   - Acceptable: >100 Ω/V (at 400V: >40kΩ)
   - Warning: 50-100 Ω/V
   - Fault: <50 Ω/V — terminate charge session

5. **Communication Loss:**
   - CCS communication timeout: No valid message for 5 seconds → terminate per CCS spec
   - CAN bus errors: >10% error rate over 1 second → flag communication fault
   - Pilot module CAN timeout: >2 seconds no response → disable affected channel

6. **Contactor Feedback:**
   - Monitor auxiliary contacts on all DC output contactors
   - If commanded CLOSED but auxiliary contact reports OPEN → contactor fault
   - If commanded OPEN but auxiliary contact reports CLOSED → welded contactor fault (critical — do not proceed)

7. **Emergency Stop:**
   - NC contact wired to dedicated digital input
   - Must open all contactors within 100ms of E-stop activation
   - Requires manual reset before resuming operation

### Step 38: User Interface Development
1. Configure the 4.3" TFT LCD for the Volt-Link display:
   - Main screen layout (idle/no vehicle):
     - Header: "Volt-Link V1.0 — READY" (centered, 24pt)
     - Status area: "Connect vehicle to begin charging" (centered, 18pt)
     - Footer: Internal temperature, 12V voltage, system uptime
   - Main screen layout (charging active):
     - Header: "CHARGING — XX.X kW" (current total power, large 36pt font)
     - Grid display: 4 (or 5) channel indicators showing per-channel current draw as horizontal bar graphs
     - Center: Vehicle battery SOC, estimated time to 80%, elapsed time
     - Alert area: Any active warnings or faults (yellow/red background)
     - Footer: Internal temperature, fan speed percentage, session energy delivered (kWh)
   - Navigation: Two tactile buttons below the LCD — "MENU" and "BACK"
   - Menu screens: Settings (brightness, BLE pairing, date/time), Diagnostics (sensor readings), Logs (view session history)
2. Implement the Bluetooth LE companion app interface:
   - UUID service: 0x180A (Device Information) and custom 128-bit UUID for Volt-Link
   - Characteristics:
     - Session status (read/notify): Charge state, power, SOC, time estimate, per-channel currents
     - Session control (write): Start, pause, resume, terminate (requires authentication — 6-digit PIN)
     - Diagnostics (read): All temperatures, voltages, currents, fault codes
     - Firmware update (write): Over-the-air update via BLE (firmware binary transfer with CRC verification)
3. Test the UI:
   - Verify all display elements render correctly at all operating states
   - Verify BLE connection and data streaming at 30m range (open air)
   - Test touch/button responsiveness through the enclosure lid (if applicable)

### Step 39: Data Logging Implementation
1. Implement charge session logging to microSD card (FAT32 formatted):
   - Log file format: CSV with timestamp, session ID, and all relevant parameters
   - Column headers: timestamp_ms, session_id, state, v_batt_v, i_batt_a, p_total_kw, ch1_i_a, ch1_temp_c, ch2_i_a, ch2_temp_c, ch3_i_a, ch3_temp_c, ch4_i_a, ch4_temp_c, dc_bus_v, fault_code
   - Logging rate: 1 Hz during idle, 10 Hz during charging
   - File naming: VL_LOG_YYYYMMDD_HHMMSS.csv
   - Automatic log rotation: New file per session
2. Implement system event logging (circular buffer, also written to SD):
   - Boot events, firmware version
   - Charge session start/end with cumulative energy
   - All fault events with timestamp and fault code
   - Firmware update events
   - Configuration changes
3. Test the data logger:
   - Insert a blank FAT32 microSD card (8-32 GB recommended)
   - Verify firmware detects the card and mounts the filesystem
   - Start a simulated charge session, verify log file is created and data is written
   - Terminate the session, remove the SD card, verify file integrity on a PC
   - Test Card Full scenario: fill the card with dummy files until <10MB free — verify firmware handles gracefully (stop logging, notify user)

### Step 40: System-Level Integration Test — Low Power
1. **SAFETY:** Full arc flash PPE, safety observer present, emergency stop tested
2. Connect the fully assembled Volt-Link hub to a CCS vehicle simulator (NOT a real vehicle for this test)
3. Connect Channel 1 and Channel 2 inputs to J1772 charging station simulators (or actual Level 2 EVSEs on dedicated circuits)
4. Power on the auxiliary 12V supply
5. Verify system boots to READY state
6. Simulate a vehicle connection via the CCS simulator — the pilot modules should detect the "vehicle present" state
7. The firmware should transition through the CCS state machine:
   - Verify the correct DC bus voltage is achieved during PRECHARGE (within ±5V of vehicle simulator's reported battery voltage)
   - Verify the charge parameter negotiation completes (max voltage, max current as limited by two channels = 55A DC)
8. Initiate charging at 25% power (approximately 3.3 kW, or 1.65 kW per channel):
   - Verify both channels deliver approximately equal current
   - Monitor all temperatures — should remain <40°C at this power level
   - Verify the LCD shows correct per-channel and total power
9. Ramp power to 50% (6.6 kW total), then 75% (9.9 kW), then 100% (13.2 kW with 2 channels):
   - At each step, hold for 5 minutes, verify stable operation
   - Document all sensor readings
10. Test the normal charge termination sequence:
    - Simulate vehicle BMS requesting charge termination
    - Verify the output contactor opens, DC bus discharges, pilot signals transition to State B
11. Test the emergency stop:
    - While charging at 6.6 kW, press the emergency stop button
    - Verify ALL contactors open within 100ms
    - Verify DC bus voltage decays to <50V within the specified time
    - Verify the firmware reports E-STOP fault
    - Reset emergency stop, verify normal restart sequence
12. Document all test results in the Test Report

---

## 13. Fabrication Steps 41-50: Integration, Testing, and Commissioning

### Step 41: Full System Integration Test — High Power
1. **SAFETY:** This test involves 26.4-33 kW of total power — two safety observers required, fire watch designated
2. Connect all four input channels to J1772 charging station simulators (rated for 32A continuous each)
3. Connect the CCS output to a high-power DC electronic load bank (rated 500V, 100A minimum) programmed to simulate an EV battery (constant voltage mode at 350V, current limit 80A)
4. Initial power-up: Enable one channel and ramp to 6.6 kW — verify the system is stable for 10 minutes
5. Enable Channel 2 — verify the load balancer distributes current equally — hold 13.2 kW for 10 minutes
6. Enable Channel 3 — verify three-channel balancing — hold 19.8 kW for 15 minutes
7. Enable Channel 4 — full 26.4 kW operation
8. Hold full power for 60 minutes, monitoring:
   - Each SiC rectifier heat sink temperature (should stabilize <70°C with fans at appropriate duty)
   - DC bus voltage ripple (<5V peak-to-peak at 400V DC)
   - AC input current harmonic distortion on each channel
   - EMI radiation (pre-compliance scan using near-field probes)
   - All contactor temperatures (<60°C at terminals)
9. Record the thermal equilibrium data:
   - Ambient temperature
   - Fan duty cycle at equilibrium
   - All eight temperature sensor readings
   - Per-channel current and voltage
   - Total power delivered
10. Thermal stress test: Block one fan (simulate fan failure) and verify the remaining fan ramps to 100% duty and the firmware reduces total charge current to maintain safe temperatures

### Step 42: Vehicle Compatibility Testing
1. **SAFETY:** First real-vehicle tests must be performed with a vehicle that has manufacturer approval for testing with prototype charging equipment, at a facility with HV-trained personnel and fire suppression capability
2. Test vehicles by priority:
   a. Hyundai Kona Electric (64 kWh) — target test vehicle, 400V architecture
   b. Kia Niro EV (64 kWh) — same platform, verify compatibility
   c. Hyundai Ioniq 5 (77.4 kWh) — 800V E-GMP architecture, test DC boost stage if implemented
   d. Chevrolet Bolt EV (66 kWh) — verify CHAdeMO operation (if equipped) or CCS
3. For each test vehicle:
   a. Connect the Volt-Link output cable to the vehicle's charge port
   b. Connect up to four J1772 extension cables to available Level 2 charging stations
   c. Verify the vehicle recognizes the charger and begins communication handshake
   d. Monitor the charge session:
      - Verify the vehicle's BMS accepts the charger's maximum current/power offer
      - Verify the charge rate ramps up smoothly (no oscillations in current demand)
      - Verify the vehicle's cooling system activates as needed (battery fan/pump)
   e. Charge from 20% to 80% SOC and record:
      - Total charge time
      - Average charge power
      - Per-channel utilization (did all four channels deliver?)
      - Any communication errors or retries
      - Vehicle-reported charge curve (power vs. SOC)
   f. Compare charge time to the vehicle's published Level 2 and DC fast charge times
4. Document all vehicle test results with photos of the charge screen on the vehicle's dashboard and the Volt-Link LCD display
5. Known vehicle-specific considerations:
   - Kona/Niro: 400V battery, max DC charge rate ~77 kW — 26.4 kW is well within the charge curve, so no BMS rejection expected
   - Ioniq 5/EV6: 800V battery architecture — if the Volt-Link only outputs 400V DC, the vehicle's onboard DC-DC converter will boost to 800V, which is transparent to the charger but may limit effective charging speed — test and document
   - Bolt EV: Some model years have a 400V architecture but a charge curve limited to ~55 kW at peak — 26.4 kW represents approximately 50% of peak capability

### Step 43: J1772 Extension Cable Validation
1. Test all four J1772 extension cables (Lectron J1772-EXT-25FT, or equivalent) for:
   - Continuity: All pins pass through correctly (verify with cable tester or multimeter)
   - CP signal integrity: Oscilloscope measurement at the far end shows the same waveform as at the source (amplitude, frequency, duty cycle)
   - Proximity signal: Verify the proximity resistor network passes through correctly (150Ω at "connected," 480Ω at "button pressed")
   - Voltage drop: At 32A continuous load, the voltage drop across the 25ft cable should be <3% (240V × 3% = 7.2V maximum drop)
   - Thermal: At 32A continuous load for 60 minutes, no point on the cable should exceed 50°C (monitor with thermal camera)
2. Test with extension cables daisy-chained (if needed for distant chargers):
   - Two 25ft cables in series = 50ft
   - Verify CP signal is still valid at the end (the J1772 specification allows up to 50m/164ft)
   - Verify total voltage drop at 50ft with 32A is <6%
3. Label each cable with its maximum continuous current rating and lot number
4. Include cable care and storage instructions in the user manual:
   - Do not coil tightly when in use (inductive heating)
   - Store at 0-40°C, away from direct sunlight
   - Inspect for damage before each use (cuts, kinks, melted insulation)
   - Replace if any damage is found

### Step 44: Environmental Testing
1. Perform environmental chamber testing (if available) or controlled field testing:
2. High-temperature operation:
   - Place the Volt-Link hub in an environmental chamber at 40°C ambient
   - Operate at 26.4 kW for 30 minutes
   - Verify internal temperatures do not exceed design limits
   - Verify the firmware thermal derating activates appropriately
3. Low-temperature operation:
   - Place the hub in an environmental chamber at -10°C
   - Verify the system boots successfully (LCD may be slow to respond — acceptable)
   - Operate at 13.2 kW (reduced power for cold conditions)
   - Verify no condensation forms inside the enclosure
4. Humidity testing:
   - Place the hub in a 40°C / 93% RH environment (non-condensing) for 2 hours
   - Verify IP65-rated enclosure integrity (no water ingress visible at cable glands or seams)
   - Verify ground fault detection does not false-trip due to moisture
5. Vibration testing:
   - Secure the hub to a vibration table
   - Apply random vibration profile per IEC 60068-2-64 (transportation profile, 1 hour per axis)
   - Verify no mechanical damage, loose fasteners, or electrical faults after testing
6. Dust ingress:
   - Place the hub in a dust chamber with fine talcum powder for 2 hours
   - Verify no dust ingress through filtered vents or cable glands
   - Verify fans are not obstructed

### Step 45: Burn-In Test
1. After passing all integration and compatibility tests, perform a 24-hour continuous burn-in:
2. Connect all four channels to J1772 simulators
3. Connect output to DC electronic load programmed for a simulated charge profile:
   - 0-2 hours: 26.4 kW constant power
   - 2-4 hours: 19.8 kW (simulating charge curve taper)
   - 4-6 hours: 13.2 kW
   - 6-8 hours: 6.6 kW
   - 8-24 hours: Cycle through the above profile twice more
4. During burn-in:
   - Log all sensor data at 1 Hz
   - Check data logs every 2 hours for anomalies
   - Perform thermal camera scan of all accessible components every 4 hours
5. Acceptance criteria for burn-in:
   - No uncommanded shutdowns or resets
   - No fault events except those intentionally injected
   - All temperatures within design limits throughout
   - Cumulative energy delivered matches the expected profile within ±5%
6. After burn-in, perform a post-test inspection:
   - Torque check on all electrical connections — retorque any that have loosened
   - Visual inspection of all components for discoloration, deformation, or degradation
   - Verify enclosure seal integrity remains IP65 compliant

### Step 46: EMI Pre-Compliance Testing
1. Perform conducted emissions testing using a Line Impedance Stabilization Network (LISN) and spectrum analyzer:
   - Frequency range: 150 kHz to 30 MHz
   - Measure conducted emissions on the J1772 AC input lines
   - Measure conducted emissions on the CCS DC output
   - Reference standard: CISPR 11 / FCC Part 15 Class A limits
2. Perform radiated emissions pre-scan:
   - Use near-field probes (H-field and E-field) and spectrum analyzer
   - Scan all enclosure seams, cable entries, and ventilation slots
   - Frequency range: 30 MHz to 1 GHz
   - Identify any "hot spots" of radiated EMI
3. If emissions exceed limits:
   - Additional ferrite clamp-on chokes on input/output cables
   - Copper foil tape over enclosure seams (internal)
   - Increase MXene coating thickness in identified leakage areas
   - Add additional common-mode filtering on DC output
4. Document all EMI measurements BEFORE and AFTER mitigation

### Step 47: Safety Compliance Documentation
1. Compile the following documentation package for UL/ETL/CSA certification submission:
   - Complete schematic diagrams (all pages, revision controlled)
   - PCB layout files (Gerber format) and assembly drawings
   - Bill of Materials with manufacturer part numbers and ratings
   - Enclosure mechanical drawings with dimensions and materials
   - Theory of operation description (Section 4 of this document, expanded)
   - Failure Mode and Effects Analysis (FMEA) — create for all critical subsystems
   - List of all critical components and their safety certifications (recognized components per UL)
   - Thermal test results
   - Dielectric withstand test results (3.75 kV AC primary-to-secondary, 1 minute — test each channel)
   - Ground bond test results (<0.1Ω between ground stud and all accessible metal parts with 25A test current)
   - IP65 enclosure integrity test results
   - Software/firmware version control documentation
   - User manual draft with all required safety warnings
2. Prepare the certification test plan:
   - Normal operating condition tests
   - Single-fault condition tests (open contactor, shorted rectifier, fan failure, etc.)
   - Abnormal operating tests (overload, blocked ventilation, -20°C cold start)
   - Mechanical tests (drop test, handle strength, cable strain relief)
3. Submit to a Nationally Recognized Testing Laboratory (NRTL) — estimated certification timeline: 12-16 weeks

### Step 48: User Manual and Documentation Package
1. Create the Volt-Link User Manual including:
   - Safety warnings and precautions (front matter, with pictograms)
   - Quick start guide (connect cables, plug in, charge)
   - Detailed operating instructions (all UI screens explained)
   - J1772 extension cable selection and usage guidelines
   - Compatible vehicles list
   - Compatible charging stations (Level 2, J1772, up to 40A per station)
   - Site selection guidelines (how to find four adjacent chargers, verify site electrical capacity)
   - Bluetooth app installation and pairing instructions
   - Maintenance schedule (cleaning, inspection, firmware updates)
   - Troubleshooting guide (common error codes and solutions)
   - Technical specifications (reference to this fabrication document)
   - Warranty information
   - Disposal and recycling information (Phoenix Protocol, Section 21)
2. Create the firmware update guide:
   - How to check current firmware version
   - How to download the latest firmware from the CSM repository
   - BLE update procedure (recommended)
   - SWD update procedure (for developers/recovery)
3. Create the open-source hardware documentation package:
   - All CAD files in STEP and FreeCAD format
   - All Gerber files and PCB design files (KiCad format)
   - All firmware source code (GitHub repository, MIT license)
   - All test procedures and acceptance criteria
4. Publish the documentation package to the CSMFAB repository

### Step 49: Final Quality Acceptance Criteria
The completed Volt-Link hub must pass ALL of the following tests before being considered production-ready:

| Test ID | Test Description | Acceptance Criteria |
|---------|------------------|---------------------|
| QA-01 | Visual inspection | No mechanical damage, all labels present and legible, connectors properly seated |
| QA-02 | Ground bond test | <0.1Ω from ground stud to all exposed metal, tested at 25A |
| QA-03 | Dielectric withstand | 3.75 kV AC, 1 minute, each channel's AC input to DC output, no breakdown |
| QA-04 | Insulation resistance | >100 MΩ at 500V DC, all power circuits to ground |
| QA-05 | Functional test — communications | CAN1 and CAN2 operational, HomePlug Green PHY modem responsive, BLE advertising |
| QA-06 | Functional test — pilot signal | All four channels generate correct J1772 pilot waveform per SAE J1772 |
| QA-07 | Functional test — rectifiers | Each channel delivers 6.6 kW into resistive load, efficiency >96% |
| QA-08 | Functional test — full power | All four channels operational simultaneously at 6.6 kW each into load bank for 30 minutes |
| QA-09 | Thermal test | No component exceeds maximum rated temperature during 30-minute full-power test |
| QA-10 | Ground fault test | RCM420 trips within 200ms at 30mA leakage, contactors open |
| QA-11 | E-stop test | ALL contactors open within 100ms of E-stop activation |
| QA-12 | Discharge test | DC bus voltage <50V within 300 seconds of power removal |
| QA-13 | CCS protocol test | Full CCS charge sequence completes with vehicle simulator |
| QA-14 | CAN bus error rate test | <1% error rate during 30-minute charge session |
| QA-15 | Firmware integrity | Flash memory checksum matches release binary |
| QA-16 | IP65 enclosure test | No water ingress after 15-minute spray test at 12.5 L/min |
| QA-17 | Cable strain relief test | Cables withstand 100N pull force without connector damage or electrical discontinuity |

### Step 50: Production Readiness and Release
1. Once the prototype has passed all QA acceptance criteria:
   - Document all lessons learned during fabrication and testing
   - Update the fabrication document with any corrections or improvements discovered during the build
   - Capture "Version 1.0 to Version 2.0" change log entries for the next revision
2. Identify production optimization opportunities:
   - Custom PCB for rectifier stage (eliminate the evaluation board overhead, integrate all four channels onto a single PCB)
   - Custom enclosure tooling (CNC or die-cast aluminum for volume >100 units)
   - Pre-cut wiring harness (reduce assembly time from ~8 hours to ~3 hours)
   - Automated test fixture development
3. Establish supplier relationships:
   - Wolfspeed: SiC MOSFET procurement agreement
   - Phoenix Contact: CCS connector volume pricing
   - JLCPCB/PCBWay: Production PCB fabrication and assembly
   - Hammond Manufacturing: Custom enclosure modification
4. Prepare the production Bill of Materials with:
   - Volume pricing for 10, 100, 1,000 units
   - Lead times for all components
   - Alternate sources for critical components (second-source qualification)
5. Publish the CSMFAB051 Version 1.0 fabrication document as open source
6. Commence CSMFAB052 (Pure CSM version) development using the lessons learned from CSMFAB051

---

## 14. Quality Acceptance Criteria

[See Section 13, Step 49 — the full QA matrix is defined there. This section provides supplementary quality requirements.]

### 14.1 Component-Level Quality
- All purchased components must be from authorized distributors to ensure traceability and authenticity
- Counterfeit electronic components (a known issue for MOSFETs and capacitors) must be screened using X-ray inspection or decapsulation for high-risk parts
- All CSM in-house materials (MXene spray, BFRP ribs, pyrolytic graphite) must pass the quality control tests defined in their respective CSMFAB documents before use in Volt-Link assembly

### 14.2 Process Quality
- All crimped connections: Sample 5% for pull-test verification (must withstand 50N minimum)
- All soldered connections: Visual inspection at 10× magnification, rework any joints with insufficient wetting, bridging, or cold joints
- All torqued connections: Mark with tamper-evident torque seal after verification
- All cable labels: Scan all barcodes/test all heat shrink labels for legibility and adhesion

### 14.3 Traceability
- Assign a unique serial number to each completed Volt-Link hub
- Record in the CSM manufacturing database:
  - Serial number
  - Build date and technician ID
  - Major component serial numbers/lot codes (rectifier boards, contactors, control PCB)
  - Firmware version at time of shipment
  - Test results summary (all QA-01 through QA-17)
- Apply serial number label (laser-etched aluminum) to the enclosure exterior

---

## 15. Firmware Architecture and Configuration

### 15.1 Firmware Build Environment
- IDE: STM32CubeIDE 1.14.0 (or newer)
- RTOS: FreeRTOS v10.6.2
- HAL: STM32CubeF4 firmware package v1.27.0
- Compiler: ARM GCC 12.3.0 (arm-none-eabi-gcc)
- Debugger: ST-Link/V2 or V3 with OpenOCD 0.12.0

### 15.2 Firmware Build Procedure
```bash
# Clone the repository
git clone https://github.com/carringtonstormmotors/voltlink-firmware.git
cd voltlink-firmware

# Initialize submodules (FreeRTOS, HAL drivers)
git submodule update --init --recursive

# Build
cd build
cmake .. -DCMAKE_BUILD_TYPE=Release -DTOOLCHAIN_PREFIX=arm-none-eabi-
make -j$(nproc)

# Output: build/voltlink-fw-v1.0.bin
# Flash using STM32CubeProgrammer or OpenOCD
openocd -f interface/stlink-v2.cfg -f target/stm32f4x.cfg -c "program build/voltlink-fw-v1.0.bin 0x08000000 verify reset exit"
```

### 15.3 Firmware Configuration Parameters
These parameters can be modified via the Bluetooth companion app or the configuration file on the microSD card:

| Parameter | Default | Range | Description |
|-----------|---------|-------|-------------|
| max_output_power_kw | 26.4 | 6.6-33.0 | Maximum total DC output power |
| max_per_channel_current_a | 27.5 | 1.0-27.5 | Maximum DC current per channel |
| dc_bus_voltage_v | 400 | 200-500 | Nominal DC bus voltage |
| thermal_derate_start_c | 65 | 50-75 | Temperature at which current derating begins |
| thermal_fault_c | 85 | 80-95 | Temperature at which channel is disabled |
| fan_start_temp_c | 40 | 30-50 | Fan minimum temperature |
| fan_full_temp_c | 70 | 60-80 | Fan maximum temperature |
| ground_fault_trip_ma | 30 | 6-30 | Ground fault current threshold (as supported by RCM420) |
| isolation_warning_kohm | 40 | 20-100 | Isolation resistance warning threshold |
| charge_timeout_min | 720 | 60-1440 | Maximum charge session duration before automatic termination |
| ble_pairing_pin | 000000 | 6 digits | Bluetooth LE pairing PIN |

---

## 16. J1772 Extension Cable Specification

The Volt-Link hub REQUIRES J1772 extension cables to connect to multiple charging stations. The cables are NOT included in the hub BOM and must be sourced separately. This section defines the minimum requirements for compatible cables.

### 16.1 Required Specifications
- Connector type: SAE J1772 Type 1, male-to-female (extension)
- Current rating: 32A continuous minimum (40A recommended for future-proofing)
- Voltage rating: 240V AC minimum
- Cable length: 7.6m (25ft) recommended; 15.2m (50ft) maximum
- Wire gauge: 10 AWG for power conductors (L1, N, PE); 18 AWG for signal conductors (CP, CS)
- UL listing: UL 2594 (EV supply equipment)
- Cable jacket: Thermoplastic elastomer (TPE) or PVC, outdoor-rated (UV stabilized), -40°C to +60°C
- IP rating: IP55 minimum (connected), IP44 minimum (disconnected, with protective caps)

### 16.2 Recommended Products
| Brand | Model | Length | Rating | Approx. Cost |
|-------|-------|--------|--------|--------------|
| Lectron | J1772-EXT-25FT | 7.6m (25ft) | 40A | $189 |
| Primecom | J1772-EXT-20FT | 6.1m (20ft) | 40A | $165 |
| MUSTART | J1772-EXT-25FT | 7.6m (25ft) | 40A | $179 |

### 16.3 Cable Management
- Store cables in a dedicated carry bag (included with Volt-Link recommended accessory kit)
- Do not coil cables with a bend radius <5× cable diameter (approximately 75mm for 15mm cable)
- Use cable ramps or cord covers when cables cross pedestrian walkways
- Do not daisy chain more than two extension cables in series (total maximum 15.2m per channel)

---

## 17. Field Deployment Protocol

### 17.1 Site Selection
When selecting a location to deploy the Volt-Link hub:
1. Identify a parking location that is within 7.6m (25ft) of at least four J1772 Level 2 charging stations
2. Verify the charging stations are operational (check for status lights, use plug-sharing apps to confirm recent successful check-ins)
3. If possible, verify the site's electrical service capacity — a site with four 32A Level 2 chargers needs a minimum of 128A of 240V service (plus margin for other loads)
4. Avoid sites where all chargers are on the same electrical feeder — if the feeder trips, ALL connected chargers will lose power simultaneously

### 17.2 Connection Sequence
1. Park the vehicle in the identified location
2. Place the Volt-Link hub on a stable surface near the vehicle's charge port
3. Verify the hub is OFF (no auxiliary power applied)
4. Uncoil the J1772 extension cables fully (do NOT deploy while coiled — inductive heating risk)
5. Route cables safely: avoid trip hazards, protect from vehicle traffic, use cable ramps if crossing pedestrian areas
6. Connect each extension cable to a J1772 charging station — WAIT for the "connected" click and verify the station indicates a valid connection
7. Connect the four extension cables to the Volt-Link hub's input ports — secure the connectors fully
8. Connect the Volt-Link output cable to the vehicle's charge port
9. Power on the Volt-Link hub (auxiliary 12V supply)
10. The hub will perform self-test, detect the vehicle, negotiate charging parameters, and begin charging
11. Monitor the charge via the LCD display or Bluetooth app

### 17.3 Disconnection Sequence
1. Terminate the charge session:
   a. Via the vehicle: Unlock charge port, the car will send a charge stop command
   b. Via the Volt-Link app: Tap "Stop Charging"
   c. Via the Volt-Link LCD: Navigate to "Stop" and confirm
2. Wait for the output contactor to open (audible click + LCD confirmation "Charge Complete")
3. Disconnect the output cable from the vehicle
4. Power OFF the Volt-Link hub
5. Disconnect all J1772 extension cables from the Volt-Link input ports
6. Disconnect extension cables from the charging stations — return station connectors to their holsters
7. Coil cables loosely (minimum 150mm loop diameter) and store in cable bag
8. Store the Volt-Link hub in a clean, dry location (vehicle trunk is acceptable for transport)

### 17.4 Emergency Disconnection
If immediate disconnection is required:
1. Press the Emergency Stop button on the Volt-Link front panel
2. ALL contactors will open within 100ms
3. Disconnect the output cable from the vehicle
4. Disconnect all extension cables
5. If safe to do so, leave the hub powered OFF and do not attempt to restart until the fault condition is identified and resolved

---

## 18. Maintenance Schedule

| Interval | Task | Details |
|----------|------|---------|
| Before each use | Visual inspection | Check all cables for cuts, kinks, melted insulation. Check connectors for bent pins, debris, or corrosion. Clean with compressed air if needed. |
| Before each use | Connector contact check | Verify all J1772 connector pins are clean and free of oxidation. Apply dielectric grease sparingly to the ground pin only (DO NOT apply to power or signal pins). |
| Monthly | Cable resistance test | Using a milliohmmeter or Kelvin (4-wire) resistance measurement, verify each extension cable's power conductor resistance is within 10% of the baseline measurement taken at first use. Increased resistance indicates conductor degradation. |
| Monthly | RCM420 ground fault test | With the hub powered on but no vehicle connected, press the TEST button on the RCM420 module. Verify the unit trips and the firmware registers the fault. |
| Quarterly | Firmware update check | Check the CSM firmware repository for updates. Review the changelog for safety-related fixes (always apply immediately) or feature improvements (apply at convenience). |
| Quarterly | Fan inspection | Open the enclosure (POWER OFF, DISCHARGE CAPS FIRST), remove dust from fan blades with compressed air, verify fans spin freely without bearing noise. Replace fans that show bearing wear. |
| Semi-annually | Full calibration check | Verify all current and voltage sensor calibrations using calibrated test equipment. Adjust firmware calibration factors if any reading has drifted >2%. |
| Semi-annually | Enclosure seal inspection | Inspect the IP65 sealing gasket for compression set, cracking, or contamination. Replace gasket if any degradation is observed. Inspect cable glands for tightness. |
| Annually | Contact resistance test | Using a microohmmeter, measure the resistance across each contactor's main contact while energized. Must be <200µΩ. Replace contactors exceeding this limit. |
| Annually | Full dielectric test | Perform dielectric withstand testing per IEC 61851-23 at 3.75 kV AC for 1 minute between all power circuits and ground. Any breakdown is a FAIL — identify and replace failed insulation before returning to service. |

---

## 19. Troubleshooting Guide

| Symptom | Possible Cause | Diagnostic Steps | Solution |
|---------|----------------|------------------|----------|
| Hub does not power on | Blown auxiliary fuse, dead 12V supply | Check 15A blade fuse on auxiliary input. Measure 12V supply voltage at input terminals. | Replace fuse. Ensure 12V supply is rated for 8A continuous minimum. |
| LCD blank but fans running | Loose LCD ribbon cable, LCD backlight failure | Reseat the 40-pin FPC ribbon cable. In a dark room, check for faint image (backlight failed, panel OK). | Reseat cable. Replace LCD if backlight failed. |
| Pilot module not detecting vehicle | Faulty CP signal, broken proximity wire | Use J1772 test adapter — check CP waveform at the hub inlet. Verify proximity resistance values (150Ω connected, 480Ω button press). | Replace the pilot module if CP signal absent. Check proximity wiring continuity from vehicle charge port. |
| Channel won't draw power from station | Station not delivering power, contactor not closing, fuse blown | Check if the station indicates "charging." Measure voltage at rectifier AC input. Check 40A AC fuse continuity. | If station doesn't deliver power, try another station. Replace blown fuse. Check contactor coil voltage — if 12V present but contactor not closing, replace contactor. |
| Low total output power (less than expected) | One or more channels not delivering rated current, thermal derating active | Check LCD for per-channel currents. If one channel shows 0A, investigate that channel. If all channels show reduced current but temperature <65°C, check input AC voltage. | If thermal derating is active (temperature >65°C), improve ventilation. If AC input voltage is low (<208V), the rectifier cannot achieve rated power — relocate to site with higher line voltage. |
| GFCI trip during charging | Ground fault — current leaking to earth | Check extension cable for damage (cut insulation). Check vehicle for ground faults. Disconnect channels one at a time to isolate which input path has the ground fault. | Replace damaged cable. If vehicle has a ground fault, charging with this equipment is not possible until the vehicle is repaired. |
| Communication error with vehicle | PLC modem not connecting, CAN bus error, incompatible vehicle | Verify the vehicle supports CCS Combo 1 DC charging. Check CAN bus termination. Verify the QCA7000 PLC modem is powered and communicating with the STM32. | If vehicle does not support CCS (e.g., Nissan Leaf with CHAdeMO only), use the CHAdeMO adapter. Check CAN bus wiring for errors. |
| Enclosure exterior hot to touch | Normal at full power — exterior can reach 45°C in 40°C ambient. If >60°C exterior, suspect internal issue. | Check internal fan operation. Check air intake filters are not clogged. | Clean filters. If fan failed, replace fan before next use. Do not operate with failed cooling. |
| Error code E001 (Overcurrent) | Short circuit on output, load bank/test vehicle drawing excessive current | Check output cable for damage. Verify vehicle's BMS is requesting current within the Volt-Link's capability. | If output cable is damaged, replace. If vehicle is requesting excessive current, the hub's overcurrent protection is functioning correctly — investigate why the vehicle exceeded the negotiated current limit. |
| Error code E004 (Isolation fault) | Insulation breakdown in the hub, in the extension cables, or in the vehicle | Disconnect all extension cables and test the hub alone. If isolation returns to normal, test each cable individually. If cables pass, the fault may be in the vehicle. | Replace the faulty component. If the vehicle has an isolation fault, charging is not possible with this equipment. |

---

## 20. Regulatory Compliance Pathway

The Volt-Link Coupling Hub is a PROTOTYPE design as of Version 1.0. The following regulatory pathway is identified for commercialization:

### 20.1 United States
- **UL 2202:** Standard for Electric Vehicle (EV) Charging System Equipment — DC output, portable equipment
- **UL 2231-1/-2:** Personnel Protection Systems for EV Supply Circuits
- **FCC Part 15:** Radio frequency emissions (Class A — industrial/commercial)
- **NEC Article 625:** Electric Vehicle Charging System — installation requirements
- **Energy Star:** EVSE program (voluntary efficiency certification)
- **Certification body:** UL LLC, ETL (Intertek), or CSA Group

### 20.2 European Union
- **IEC 61851-1:** General requirements for EV conductive charging
- **IEC 61851-23:** DC EV charging station
- **EN 55011:** Industrial, scientific, and medical equipment — RF disturbance characteristics
- **CE Marking:** Low Voltage Directive (2014/35/EU), EMC Directive (2014/30/EU)
- **Certification body:** TÜV Rheinland, TÜV SÜD, DEKRA

### 20.3 Anticipated Timeline
- Pre-compliance testing: Complete (see Section 13, Step 46)
- NRTL submission: TBD (target Q3 2026)
- Certification completion: 12-16 weeks after submission
- Estimated certification cost: $18,000-$35,000 (UL), €15,000-€30,000 (CE)

---

## 21. Phoenix Protocol — End-of-Life Recycling

### 21.1 Material Recovery
| Material | Weight (kg) | Recovery Method | Recovery Rate | Recovered Value |
|----------|-------------|-----------------|---------------|-----------------|
| Aluminum (enclosure) | 4.2 | Mechanical separation, melt/recast | 98% | $8.40 |
| Copper (wiring, bus bars) | 1.8 | Mechanical separation, smelting | 95% | $16.20 |
| Steel (fasteners, contactors) | 1.4 | Magnetic separation, steel recycling | 90% | $0.70 |
| Electronics (PCBs, semiconductors) | 0.9 | Precious metal recovery (hydrometallurgical) | 85% | $5.40 |
| MXene coating (Ti₃C₂Tₓ) | 0.05 | Acid wash from aluminum, reprecipitation | 70% | $3.50 |
| BFRP composite (structural ribs) | 0.4 | Thermal depolymerization (Elium resin), basalt fiber recovery | 75% | $2.00 |
| Pyrolytic graphite (heat spreader) | 0.3 | Reuse (if undamaged) or grind for lubricant | 90% | $5.70 |
| Capacitors (electrolytic) | 0.3 | Aluminum/electrolyte separation | 80% | $0.60 |
| Plastics (fans, connectors, cable glands) | 0.5 | Mechanical recycling or waste-to-energy | 60% | $0.25 |
| **Total** | **11.8 (adds to weight)** | | | **$42.75** |

### 21.2 Disassembly Procedure
1. Remove all external cables
2. Remove enclosure lid
3. Discharge all capacitors — verify zero energy
4. Document serial number for decommissioning record
5. Remove control PCB, relay module, LCD, and all electronics — segregate as "e-waste — precious metal recovery"
6. Remove fan assemblies — segregate as "plastic/electronic mixed waste"
7. Remove contactors and bus bars — segregate as "copper-bearing electrical"
8. Remove rectifier boards — segregate as "e-waste — semiconductor recovery"
9. Remove BFRP structural ribs — segregate as "composite — thermal depolymerization"
10. Remove pyrolytic graphite heat spreader — evaluate for reuse, otherwise "graphite — lubricant/refractory"
11. Scrape MXene coating from enclosure interior using a plastic scraper — collect powder for acid wash/reprecipitation
12. Enclosure (bare aluminum after MXene removal) — standard aluminum recycling

---

## 22. References and Standards

1. IEC 61851-1:2017 — Electric vehicle conductive charging system — Part 1: General requirements
2. IEC 61851-23:2014 — DC electric vehicle charging station
3. IEC 61851-24:2014 — Digital communication between a DC EV charging station and an EV
4. ISO 15118-2:2014 — Road vehicles — Vehicle-to-Grid Communication Interface — Part 2: Network and application protocol requirements
5. ISO 15118-3:2015 — Physical and data link layer requirements
6. SAE J1772:2017 — SAE Electric Vehicle and Plug-in Hybrid Electric Vehicle Conductive Charge Coupler
7. SAE J2847/2:2015 — Communication Between Plug-in Vehicles and Off-Board DC Chargers
8. UL 2202:2022 — Standard for Electric Vehicle (EV) Charging System Equipment
9. UL 2231-1:2022 — Personnel Protection Systems for Electric Vehicle (EV) Supply Circuits
10. UL 2231-2:2022 — Personnel Protection Systems for Electric Vehicle (EV) Supply Circuits — Charging System Protective Devices
11. NEC NFPA 70:2026 — National Electrical Code, Article 625
12. FCC 47 CFR Part 15 — Radio Frequency Devices
13. CHAdeMO Association — CHAdeMO Protocol Specification Rev 3.0
14. DIN 70121:2014 — Electromobility — Digital communication between a DC EV charging station and an electric vehicle
15. Wolfspeed CRD-06600FF065N — 6.6 kW Totem-Pole PFC Evaluation Board User Guide
16. STMicroelectronics AN4031 — Using the STM32F4 Discovery Board for CCS Communication
17. CSMFAB09 — BFRP Rebar Fabrication Plan V2.0
18. CSMFAB01 — Aegis-C Composite Shielding Design V2.0
19. CSMQuantum — MXene Synthesis and Characterization
20. CSMQuantum — Pyrolytic Graphite Production Methodology
21. CSMQuantum — KNbO₃-BaTiO₃ Piezoelectric Sensor Synthesis
22. CSMinsurance/INS-08 — Volt-Link Multi-Charger Coupling Hub Insurance Framework

---

*CSMFAB000000000051 V1.0 — Carrington Storm Motors / Safe Pod Engineering Company*
*"The chargers are there. The power is there. Build the box."*
*"One coupled kilowatt at a time."*
*Document Control: CSM-AEGIS-FAB-051-V1.0 | July 2026*
*Open Source — Civilization Resilience Level 5*
