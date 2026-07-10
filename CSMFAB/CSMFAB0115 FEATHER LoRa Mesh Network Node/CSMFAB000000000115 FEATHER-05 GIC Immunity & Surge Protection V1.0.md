# CSMFAB000000000115 V1.0
## FEATHER-05: GIC Immunity & Surge Protection Design
### Version 1.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications
**Classification:** Electromagnetic Protection Engineering Document

---

## 1. Threat Characterization

### EMP Components

| Component | Mechanism | Rise Time | Duration | Field Strength |
|-----------|-----------|-----------|----------|---------------|
| E1 (early) | Compton scatter gamma → EMP | 1–5 ns | < 1 μs | 50 kV/m (HEMP), 1–5 kV/m (CME-induced) |
| E2 (intermediate) | Scattered gamma + inelastic neutron | 1 μs | < 1 s | 100 V/m |
| E3 (late-time) | Magnetohydrodynamic dB/dt | 1 s | 100–1000 s | 10–50 V/km surface E-field |

FEATHER's primary threat is E3 — geomagnetically induced currents. The Aegis-C enclosure (SE ≥ 148 dB) handles E1/E2. The mount and internal electronics must resist E3.

### 1.1 GIC Coupling Pathway

```
Solar Flux → Ionospheric Ring (100 km) → dB/dt = 2,000 nT/min
→ E_ind = 15–25 V/km (CA, σ_earth = 0.001 S/m)
→ Steel pole (8m) → pole-to-ground ~0.2V → but pole IS grounded
→ I = 0.2V / 0.01Ω ≈ 20A peak GIC through pole
→ If FEATHER shares ground → 20A through CPU → catastrophic failure
```

## 2. Dielectric Citadel Isolation Strategy

### Complete galvanic isolation at EVERY electrical interface:

| Interface | Isolation Method | Standoff Voltage |
|-----------|-----------------|------------------|
| Enclosure to pole | PTFE standoff ring, 25 mm creepage | 1,500 kV dielectric / 450 kV detated |
| Mounting bolts | PTFE shoulder sleeves | Same |
| Solar panel cables | 100 nF DC-block capacitor, 1 kV X7R (×2 series) | 2 kV DC |
| LoRa antenna | DC-block capacitor in bias tee | 500V DC |
| RS-485 to traffic controller | ISO3082 galvanic isolator | 2.5 kV RMS |
| All external sensor connectors | TVS diode to local ground + common-mode choke + DC-block | 600W peak pulse per TVS |

## 3. Internal Star Ground Topology

FEATHER electronics use a SINGLE-POINT star ground on a 60 × 60 mm copper pour on the BFRP main PCB, electrically FLOATING with respect to the Aegis-C ceramic interior (surface resistivity 10¹⁴ Ω/sq — no chassis ground reference). The Aegis-C shell is an insulator — there is NO conductive path from interior to exterior. No GIC can enter through the shell. No ground loop can form.

## 4. Surge Protection Network

### Antenna Feedthrough Chain
```
[External DRA] → GDT 90V surge arrester → pole grounding strap (bypasses dielectric mount)
→ DC-Block 100 nF 1 kV X7R (bias tee)
→ TVS array (Semtech RClamp0524P, ±15 kV, clamp 6.5V) → star ground
→ SAW BPF 902–928 MHz (2.5 dB IL)
→ [SX1262 LNA Input]
```

### Solar Panel Input Protection
```
[MC4 Connectors] → TVS diode array (Littelfuse SM6T22CA, 22V standoff, 35.5V clamp, 600W)
→ 2 × 100 nF 1 kV X7R DC-block in series (2 kV standoff)
→ [MPPT Controller Input]
```

### ESD Protection on Connectors
All external connectors (BLE button, USB-OTG) have: TVS diode (Nexperia PESD5V0S1BA) + 100 Ω series resistor + ferrite bead (Murata BLM18PG121SN1, 120 Ω at 100 MHz).

## 5. Grounding Philosophy

**The FEATHER node has NO permanent ground connection. It is a floating system.**

This is counterintuitive to NEC 250 (which requires grounding), but NEC 250.4(A)(5) permits ungrounded systems with effective ground-fault current paths. FEATHER's solar panel is Class II (double-insulated, IEC 61140) — requires no grounding. The battery is isolated. The enclosure is an insulator. There is nothing to ground.

The GDT on the antenna provides a lightning transient path — a SAFETY shunt, not a functional ground. Under normal conditions, the 90V DC standoff presents an open circuit.

## 6. Verification Testing

| Test | Standard | Method | Pass Criteria |
|------|----------|--------|---------------|
| GIC immunity | NERC GMD benchmark | Inject 50A DC into test pole | I_star_ground < 1 μA |
| HEMP E1 | MIL-STD-461G RS105 | 50 kV/m, 1.8/30 ns, 5 pulses | No MCU reset |
| Lightning surge | IEC 61000-4-5 | 2 kV line-to-ground, 1.2/50 μs | Node resumes < 1 s |
| ESD | IEC 61000-4-2 | ±15 kV air discharge | No MCU reset |
| Isolation resistance | Custom | Megger at 5 kV DC enclosure-to-pole | > 100 GΩ |
| Partial discharge | IEC 60270 | 5 kV AC across PTFE standoff | < 10 pC at inception |

---

*The FEATHER floats. The GIC finds no path. The mesh persists.*
