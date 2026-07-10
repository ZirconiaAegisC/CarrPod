# CSMFAB000000000115 V1.0
## FEATHER-04: Dielectric Pole Mount & Physical Installation
### Version 1.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications
**Classification:** Installation & Mounting Specification

---

## 1. The GIC Isolation Imperative

Every metallic mounting bracket is a potential GIC pathway during a Carrington event. A standard galvanized steel bracket connecting a grounded steel pole to a FEATHER enclosure creates a conductive loop — exactly the failure mode the Aegis-C enclosure is designed to prevent.

The FEATHER mount provides: complete galvanic isolation, mechanical integrity to survive 120 mph winds (AASHTO LTS-6 fatigue category E), creepage distance ≥ 25 mm (IEC 60664-1 Pollution Degree 4), and single-technician installation in ≤ 25 minutes.

## 2. BFRP C-Channel Bracket

| Parameter | Value |
|-----------|-------|
| Material | Basalt Fiber Reinforced Polymer (BFRP), Elium® thermoplastic |
| Profile | C-channel, 80 × 40 × 5 mm wall |
| Tensile strength | 680 MPa |
| Compressive strength | 420 MPa |
| Flexural modulus | 38 GPa |
| Dielectric strength | 17 kV/mm |
| Surface resistivity | 10¹⁴ Ω/sq |
| Weight (per bracket pair) | 0.85 kg |

### 2.1 Pole Clamp Assembly

**For 2-3/8" OD sign poles:** 2 × BFRP half-shell clamps, 4 × M10 × 80 mm PTFE shoulder bolts (A2-70 stainless cores with 2 mm PTFE sleeve), PTFE washers (3 mm thick, 30 mm OD). Stainless cores are electrically floating.

**For 4" OD mast arm poles:** Same design scaled to M12 × 120 mm.

**For bridge pier mounting:** Hilti HIT-HY 200 adhesive anchors with BFRP threaded rod (M12). No metallic anchor bolts — BFRP maintains dielectric isolation through concrete.

### 2.2 Creepage Distance Analysis

At 10 kV/m induced surface E-field during a Carrington-class G5 event (NERC GMD benchmark):
- PTFE dielectric strength: 60 kV/mm → 25 mm withstands 1,500 kV
- Pollution Degree 4 derating (0.3×) → 450 kV withstand
- Actual expected voltage: ≤ 500V differential
- **Safety factor: 900:1**

## 3. Installation Procedure (25 Minutes)

| Time | Step |
|------|------|
| T-0:00 | Unbox FEATHER node. Verify tamper-evident seal intact. |
| T-0:30 | Attach BFRP half-shell clamps to pole. Finger-tighten PTFE bolts. |
| T-2:00 | Mount BFRP bracket to clamps. Torque 15 N·m ± 2 N·m. |
| T-4:00 | Position enclosure on bracket. Align mounting holes. |
| T-6:00 | Insert M8 PTFE shoulder bolts + washers + standoff ring. Torque 8 N·m. |
| T-8:00 | Verify PTFE standoff compression: 0.5–1.0 mm visible. |
| T-10:00 | Connect MC4 solar panel cables. Confirm click. |
| T-12:00 | Power-on test. BLE button → green LED triple blink. |
| T-15:00 | Smartphone FEATHER App: commission (GPS lock, mesh join, channel assign, firmware check). |
| T-25:00 | Commissioning complete. Lock BLE pairing. Descend. Node is live. |

## 4. Installation Scenarios

**Standard Roadside:** Solar panel at 35° tilt, enclosure at 3.5 m on sign pole.

**CMS Gantry:** Enclosure at 8–10 m → extended LoRa range (15–25 km next gantry). DRA on CMS sign face top — metal sign acts as ground plane enhancement (+2.1 dB gain). RS-232/NTCIP 1203 direct connection to CMS controller.

**Flood-Zone Drop-Pack:** Tripod base (BFRP, 1.2–3.5 m telescoping, 3.1 kg). Folding solar panel. 60-second helicopter deployment. Gas-strut tripod deployment + spring-loaded panel unfold. Auto-mesh within 60s of power-on.

## 5. Vibration & Fatigue

Per AASHTO LTS-6:
- Wind-induced vortex shedding at 30 mph: 32 Hz
- BFRP bracket natural frequency (FEA): 127 Hz (first mode)
- Frequency ratio: 3.97 → no resonance lock-in
- Cyclic stress at 10⁷ cycles (50-year service): 4.2 MPa
- BFRP endurance limit at 10⁷ cycles: 68 MPa
- **Fatigue safety factor: 16.2:1**

## 6. Lightning Protection

PTFE standoff ring provides 25 mm physical gap → breakdown > 150 kV. DC-blocking capacitors (100 nF, 1 kV X7R, ×2 series for 2 kV) on antenna + solar inputs. GDT (90V DC, Bourns 2027) on antenna shunts to pole via dedicated grounding strap BYPASSING dielectric mount.

---

*The mount does not conduct. The Citadel does not ground. The network does not fail.*
