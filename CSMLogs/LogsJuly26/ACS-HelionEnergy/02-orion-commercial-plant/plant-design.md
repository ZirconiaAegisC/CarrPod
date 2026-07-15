# Orion: First Commercial Fusion Plant — Design & Engineering

## Facility Overview
Orion is Helion Energy's first commercial fusion power plant, under construction in Malaga, Washington. At 50 MW net electrical output, Orion is designed to be the world's first grid-connected fusion power plant delivering electricity under a commercial power purchase agreement (PPA) with Microsoft. The facility represents the scale-up from Polaris's technology demonstration to a revenue-generating power asset.

| Parameter | Value |
|-----------|-------|
| Net Electrical Output | 50 MW |
| Gross Fusion Power | ~55-60 MW (estimated, accounting for parasitic loads) |
| Number of Fusion Cores | Not publicly disclosed; likely modular architecture |
| Core Dimensions (per unit) | ~1.5-2x Polaris scale |
| Site Footprint | ~30 acres |
| Construction Start | July 2025 (groundbreaking) |
| Target First Plasma | Late 2027 / Early 2028 |
| Target Commercial Operation | 2028 (per Microsoft PPA) |
| Design Life | 20-30 years |
| Fuel | D-He3 (with D-D side reactions) |
| Energy Conversion | Direct inductive recovery + power electronics |
| Grid Interconnection | Chelan County PUD substation |

## Plant Layout
The Orion facility is organized into the following functional zones:

### 1. Fusion Island
The central facility housing the fusion cores, compression systems, and direct energy recovery:
- Fusion core hall (shielded, restricted-access area)
- Capacitor bank room (climate-controlled, fire-suppressed)
- Formation section gas handling room
- Cryogenic helium and vacuum system room

### 2. Power Conversion & Grid Interface
- Power electronics building (AC/DC converters, inverters, grid-synchronization)
- Step-up transformers (to Chelan County PUD distribution voltage)
- Switchyard and grid interconnection point
- On-site backup power (diesel generators or battery storage)

### 3. Fuel Handling & Tritium Management
- Deuterium gas storage and delivery system
- He-3 gas storage (imported + in-situ bred)
- Tritium separation, storage, and decay management
- Fusion product exhaust processing (helium-4, unburned fuel recycling)

### 4. Balance of Plant
- Administrative and control room building
- Maintenance workshop and spare parts storage
- Cooling system (minimal — no steam condenser, primarily coil and capacitor bank cooling)
- Fire suppression and safety systems
- Security perimeter and access control

### 5. Site Infrastructure
- Access roads and parking
- Stormwater management
- Underground utility corridors
- Helium-3 delivery/receiving area

## Key Engineering Challenges

### Pulse Repetition Rate at Commercial Scale
Polaris operates at low repetition rates (single-shot to <0.1 Hz). Orion must sustain 1 Hz continuously for commercial operation. This requires:
- Capacitor bank charge/discharge cycling at 1 Hz without degradation
- Formation section gas injection and evacuation within <1 second
- Divertor heat management over thousands of cumulative pulses
- Coil cooling systems rated for continuous pulsed operation
- Reliability engineering: >90% uptime target across all subsystems

### Tritium Inventory Management
D-D side reactions in Orion will produce tritium at a rate proportional to the D-D fusion rate. Tritium is:
- Radioactive (half-life 12.3 years, beta emitter)
- A controlled nuclear material under NRC and DOE regulations
- A valuable resource for He-3 production via decay
- A potential environmental release concern requiring continuous monitoring

Orion must implement:
- Real-time tritium accounting and inventory tracking
- Tritium-compatible materials in all wetted components
- Tritium removal systems for vacuum pump exhaust
- Environmental monitoring network around the site perimeter

### He-3 Fuel Supply Chain
Orion's nominal fuel is D-He3. Helion's strategy relies on:
1. **In-situ Breeding:** D-D side reactions produce He-3 directly. The D-D → He3 + n branch occurs ~50% of the time in D-D fusion events.
2. **Tritium Decay:** Tritium from D-D reactions decays to He-3 with a 12.3-year half-life. A closed tritium inventory cycle converts D-D tritium to He-3 over time.
3. **External Supply (Long Term):** Existing He-3 stockpiles from nuclear weapons tritium decay programs and potential future lunar mining.

The net He-3 breeding ratio (He-3 produced / He-3 consumed) is a critical but unverified parameter for Orion's economic viability.

### Direct Energy Recovery at Scale
The direct energy recovery system must:
- Efficiently capture the plasma expansion work as electrical energy
- Synchronize with the grid at 60 Hz despite pulsed operation (capacitor bank buffering)
- Achieve >85% round-trip efficiency (energy recovered / energy invested in compression)
- Operate reliably for millions of cycles without degradation

### First-of-a-Kind (FOAK) Risk
Orion carries all the typical cost and schedule risks of a first-of-a-kind commercial facility:
- No prior fusion plant construction experience exists
- Supply chain for fusion-specific components (beryllium, superconducting materials, tritium-compatible seals) is immature
- Commissioning timeline is highly uncertain
- Regulatory inspections and approvals may introduce schedule delays
