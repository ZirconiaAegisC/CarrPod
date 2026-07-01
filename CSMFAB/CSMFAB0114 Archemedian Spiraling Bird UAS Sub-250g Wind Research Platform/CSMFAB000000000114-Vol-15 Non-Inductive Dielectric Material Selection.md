# CSMFAB000000000114 — Vol-15
# Non-Inductive Dielectric Material Selection
## Every Material Tested Against the Stellar-Aegis Protocol
**Carrington Storm Motors / Safe Pod Engineering Company**
**Version 1.0 | June 2026**

*References: CSMFAB0017 (Dielectric Rope Fabrication) | CSMFAB0101 (A-10 Redesign for Immunity) | CSMAegisHome01 (Foundational Research)*

---

## Introduction: The Stellar-Aegis Protocol in Brief

The Carrington Storm Motors design philosophy mandates that all materials in primary structural and electronic pathways must be **non-inductive and dielectric** to prevent Geomagnetically Induced Current (GIC) coupling during Carrington-class solar storm events. This protocol was developed in CSMFAB000000000001 through the Aegis series and represents the baseline material standard across all CSM products.

For the ASB-1, this means:
- No uninsulated conductive loops that could form a closed induction path
- No ferromagnetic materials (avoid paramagnetic steel in structural roles)
- All primary structure in dielectric composites
- Conductive elements (wiring, antennas, sensors) isolated from structural paths with PEEK or BFRP spacers

The bonus: a device that passes the Stellar-Aegis Protocol is also an extremely quiet electromagnetic emitter — it will not interfere with its own sensitive wind pressure sensors through electrical noise.

---

## Part 1: Approved Material Table

| Component | Material | Conductivity | Magnetic | Stellar-Aegis | Source |
|---|---|---|---|---|---|
| Spiral wing/body frame | BFRP (Basalt Fiber Reinforced Polymer) | < 10⁻¹⁰ S/m | Non-magnetic | ✅ PASS | Markforged, CW02, or local composite |
| Nose cone | BFRP | < 10⁻¹⁰ S/m | Non-magnetic | ✅ PASS | Same as body |
| Tail fins | BFRP 0.6mm sheet | < 10⁻¹⁰ S/m | Non-magnetic | ✅ PASS | Same |
| Electronics bay shell | BFRP or PETG | < 10⁻¹² S/m | Non-magnetic | ✅ PASS | PETG also acceptable |
| Speed governor housing | PLA (printed, painted) | < 10⁻¹² S/m | Non-magnetic | ✅ PASS | Standard PLA filament |
| Actuator housing (Smart Rope) | BFRP printed | < 10⁻¹⁰ S/m | Non-magnetic | ✅ PASS | |
| Tether (all sections) | UHMWPE / Dyneema SK-75 | ~10¹⁴ Ω·m | Non-magnetic | ✅ PASS | CSMFAB0017 |
| Micro-parachute canopy | UHMWPE ripstop fabric | ~10¹⁴ Ω·m | Non-magnetic | ✅ PASS | |
| SMA wire (Smart Rope) | Nitinol (NiTi) — conductive | Conductor | Non-magnetic | ⚡ ISOLATED | UHMWPE braid shield; no loop formed |
| Wiring harness | Copper wire with silicone insulation | Conductor | Non-magnetic | ⚡ ISOLATED | Silicone insulation, no closed loops through body |
| LoRa antenna | Copper wire (insulated) | Conductor | Non-magnetic | ⚡ ISOLATED | Heat shrink + PEEK standoff mount |
| Tether swivel | Type 316 stainless steel (low MnS) | Conductor | Slightly paramagnetic | ⚡ ISOLATED | PEEK sleeve between swivel and BFRP body |
| FTS spring plunger | Music wire (carbon steel) | Conductor | Ferromagnetic | ⚡ ISOLATED | Enclosed inside FTS bay; no external loop |
| Wind sensor mast | 3mm carbon fiber tube | ~10⁴ S/m (conductive) | Non-magnetic | ⚡ ISOLATED | PEEK sleeve at base mount, no body contact |
| GPS module housing | FR4 PCB + ABS case | Insulating | Non-magnetic | ✅ PASS | Standard component isolation |
| Flight controller PCB | FR4 | Insulating substrate | Non-magnetic | ✅ PASS | Wiring isolation protocol applied |

---

## Part 2: Material-Specific Notes

### BFRP — The Primary Structural Material

Basalt Fiber Reinforced Polymer is the CSM preferred composite (established in CSMFAB000000000102 V2.0). It is:
- Made from basalt rock (natural volcanic mineral), pulled into fibers
- Combined with epoxy resin matrix
- **Electrically resistive:** < 10⁻¹⁰ S/m (essentially an insulator at electromagnetic frequencies)
- **Non-magnetic:** basalt is silicon dioxide / iron oxide composite, but processed into fiber with epoxy is non-magnetic in practical measurement
- **Stronger than fiberglass (E-glass):** tensile strength ~1,100 MPa vs. 1,100 MPa (similar); BUT better fatigue resistance and thermal stability
- **Cheaper than carbon fiber:** $25-35/kg vs. $45-100/kg for CF
- **Available in filament form** for Markforged printers or as chopped fiber + epoxy for hand layup

### UHMWPE (Dyneema) — Tether and Parachute

Already covered in Vol-10. Key note: the braid pattern used for Smart Rope actuator housings follows CSMFAB0017 at 30° braid angle, 28-strand braiding pattern with 0.1mm diameter strands in a carrier thread count of 4.

### Nitinol — Isolated Not Excluded

Nitinol (SMA wire) is electrically conductive. It is NOT excluded from the Stellar-Aegis Protocol — it is listed as "isolated." This means:
1. The SMA wire runs as a straight segment from driver board to wire housing — it does NOT form a closed loop
2. The UHMWPE braid surrounding it prevents any inductive coupling to adjacent structures
3. The current path: driver PCB → SMA wire in housing → return wire alongside → driver PCB. This tight pair (outgoing + return wires run parallel within 1mm) has near-zero loop area → near-zero magnetic moment → near-zero GIC coupling susceptibility.

### Carbon Fiber Wind Sensor Mast — The Exception

Carbon fiber (CF) is prohibited in structural roles (forms conductive loops). The wind sensor mast is CF because no non-conductive tube at 3mm OD provides adequate stiffness for the probe tip without being excessively heavy. At 40mm length, the CF mast weighs 0.3g — no practical alternative.

**Mitigation:** Mount the CF mast in a PEEK (polyether ether ketone) sleeve insert into the nose cone. PEEK resistivity = 10¹⁴ Ω·m. This breaks the conductive path from the CF mast to the BFRP body. The mast is electrically floating — any charge on it dissipates through the wind to ground rather than through the device body.

---

## Part 3: Materials Procurement Summary

| Material | Supplier | Approximate Cost | Minimum Order |
|---|---|---|---|
| BFRP filament (for Markforged Mark Two) | Markforged online store | $175/spool | 1 spool (good for 20 units) |
| BFRP chopped fiber + epoxy (hand layup) | Basalt.com or ACP Composites | $25/kg fiber | 500g |
| PETG filament (for electronics bay) | Any local 3D print supplier | $20-25/kg | 1 kg spool |
| UHMWPE fishing line 0.5mm (tether) | Amazon, fishing supply | $8/300m spool | 1 spool (enough for 5 units) |
| UHMWPE braiding strand 0.1mm | Dyneema direct or specialty supplier | $15/200m | 1 spool |
| PLA filament (governor, general) | Amazon/Hatchbox | $12-18/kg | 1 kg spool |
| Nitinol 0.1mm (SMA wire) | Dynalloy Flexinol, Wire-SMA | $3/m | 3m minimum order |
| PEEK standoffs M3 | McMaster-Carr, Digikey | $0.50 each | Pack of 10 |
| Type 316 SS swivels | Amazon fishing/hardware | $2-3/pack of 5 | 1 pack |
| Carbon fiber tube 3mm OD | CST The Composites Store | $3 per 470mm | 1 tube (6 uses) |

---

## CHECKPOINT — Vol-15 Complete

Before proceeding, confirm:
- [ ] You understand the Stellar-Aegis Protocol: dielectric non-inductive primary structure; isolated conductive elements
- [ ] You know that BFRP is the primary material (non-magnetic, highly insulating, printed or laminated)
- [ ] You know that Nitinol (SMA wire) is permitted via isolation protocol (tight pair, no closed loop)
- [ ] You know that carbon fiber is only used for the wind mast with PEEK electrical isolation at mount
- [ ] You have reviewed the procurement table for all needed materials

**Proceed to:** Vol-16 (Spiral Body Frame Design) or Vol-21 (Assembly Manual)

---

*CSMFAB000000000114-Vol-15 | Version 1.0 | June 2026 | Carrington Storm Motors / Safe Pod Engineering Company*
