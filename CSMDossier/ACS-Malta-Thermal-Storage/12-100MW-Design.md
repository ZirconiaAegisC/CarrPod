# 100 MW / 1,000 MWh Commercial Plant Design

## Design Basis

Malta Inc's first commercial-scale PHES plant design is based on a reference configuration of approximately 100 MW power output and 1,000 MWh energy storage capacity, providing 10 hours of continuous discharge at rated power. This scale was selected based on techno-economic optimization balancing several factors:

- **Minimum economic scale:** The turbomachinery cost does not decline significantly below approximately 100 MW; smaller plants would have disproportionately high specific cost ($/kW)
- **Market compatibility:** 100 MW is a standard "block size" for utility procurement — large enough to be meaningful in a utility's resource portfolio (a typical combined-cycle gas turbine is 200–600 MW) but small enough to be financeable as a first-of-a-kind project
- **Grid interconnection:** 100 MW can typically interconnect at sub-transmission or transmission voltages (69–230 kV) without requiring expensive network upgrades
- **Tank scaling:** 1,000 MWh of thermal storage can be accommodated in a few large tanks (2–4 tanks for hot salt, 2–4 tanks for cold antifreeze), avoiding the complexity of managing dozens of small tanks

## Plant Layout and Site Requirements

### Footprint
A 100 MW / 1,000 MWh PHES plant requires approximately 15–25 acres for the main plant area, including:

| Area | Approximate Footprint | Description |
|------|----------------------|-------------|
| Power block | 2–3 acres | Turbomachinery hall, heat exchangers, control room, electrical equipment |
| Hot salt tank farm | 3–5 acres | 2–4 hot salt tanks plus containment dikes and access roads |
| Cold antifreeze tank farm | 3–5 acres | 2–4 cold tanks plus containment dikes and access roads |
| Electrical switchyard | 2–3 acres | Main power transformer, switchgear, transmission interconnection |
| Balance of plant | 3–5 acres | Water treatment, auxiliary power, fire protection, warehouse, parking |
| Buffer and setbacks | 3–5 acres | Visual screening, noise attenuation, security perimeter |

Total site: 15–25 acres, comparable to a small simple-cycle gas turbine peaker plant.

### Civil Works
Site preparation includes:
- Grading and compaction of the plant pad (typically 2–4 feet of engineered fill)
- Concrete foundations for turbomachinery (dynamic foundations to resist vibration), tanks (ring-wall foundations), and structures
- Stormwater management (detention basins, oil-water separators)
- Access roads capable of supporting heavy equipment delivery (turbomachinery components can weigh 50–100+ tons; large cranes required for installation)
- Security fencing, lighting, and access control

### Site Selection Criteria
Malta evaluates potential sites based on:

1. **Grid interconnection:** Proximity to existing transmission lines (ideally < 1 mile to the point of interconnection to minimize gen-tie line cost)
2. **Land:** Flat or gently sloping terrain (slope < 5%), adequate acreage, zoning compatible with industrial/utility use, avoid environmentally sensitive areas (wetlands, endangered species habitat, floodplains)
3. **Community:** Acceptable noise profile (turbomachinery generates sound comparable to a gas turbine plant; noise modeling and mitigation measures (acoustic enclosures, sound walls) may be required), adequate setback from residential areas
4. **Water:** Minimal water consumption (closed-loop dry cooling); initial tank fill water is a one-time requirement and can be trucked if necessary
5. **Supply chain access:** Road access for heavy equipment delivery, proximity to rail or barge for bulk salt and antifreeze fluid delivery

## Major Equipment List

### Turbomachinery Train
- **Compressor:** Multi-stage centrifugal or axial-centrifugal compressor, argon working fluid, pressure ratio of 2.5–4.0, isentropic efficiency ≥ 90%. Supplied by Siemens Energy
- **Compressor drive motor:** 120–140 MW synchronous or induction motor with VFD, 13.8 kV, water- or air-cooled
- **Power turbine:** Multi-stage axial turbine, argon working fluid, inlet temperature 525–550°C, isentropic efficiency ≥ 92%. Supplied by Siemens Energy
- **Synchronous generator:** 100 MW nameplate, 13.8 kV, 0.85 power factor, hydrogen-cooled or air-cooled, with brushless excitation system. Supplied by Siemens Energy

### Heat Exchangers
- **Hot-side HX (charge mode, argon-to-salt):** Shell-and-tube, salt on shell side, argon on tube side, 565°C design temperature, stainless steel tubes (304H/347H), thermal duty ~250–300 MWth
- **Hot-side HX (discharge mode, salt-to-argon):** Same physical unit or separate unit depending on valving and piping arrangement
- **Cold-side HX (charge mode, argon-to-antifreeze):** Shell-and-tube or plate-fin, low-temperature carbon steel, −60°C design temperature, thermal duty ~150–200 MWth
- **Cold-side HX (discharge mode, antifreeze-to-argon):** Same physical unit or separate unit
- **Recuperator (optional):** Shell-and-tube or plate-fin, argon-to-argon, largest temperature differential in the system (~500°C to −50°C), requires staged design with transition materials between high-temp and low-temp sections

### Salt System
- **Hot salt tanks:** 2–4 tanks, API 650, each 30–40 m diameter × 15–20 m height, carbon steel shell, mineral wool or calcium silicate insulation, electric heat tracing on nozzles and piping
- **Cold salt tanks ("warm" tanks):** 2–4 tanks, identical construction to hot tanks but operating at ~250°C
- **Salt pumps:** Vertical turbine (cantilever) pumps, 2 × 100% or N+1 per tank, VFD-driven, stainless steel or nickel alloy wetted components
- **Salt piping:** Stainless steel (304H or 316H), insulated and heat-traced, design for drainability to tank during shutdown

### Antifreeze System
- **Cold antifreeze tanks:** 2–4 tanks, API 650, low-temperature carbon steel (A516 Gr. 70 impact-tested), each 30–40 m diameter × 15–20 m height, polyisocyanurate or cellular glass insulation, vapor barrier
- **Warm antifreeze tanks:** 2–4 tanks, similar construction but thinner insulation (smaller ΔT with ambient)
- **Antifreeze pumps:** Horizontal centrifugal or vertical turbine, 2 × 100% or N+1 per tank, VFD-driven, low-temperature materials
- **Antifreeze piping:** Low-temperature carbon steel, insulated, design for thermal expansion/contraction

### Electrical Equipment
- **Main power transformer:** 120–150 MVA, 13.8 kV / 115 kV or 230 kV, ONAN/ONAF cooling, with LTC
- **Medium-voltage switchgear:** 13.8 kV, metal-clad, vacuum or SF6 circuit breakers
- **Auxiliary transformer:** Station service power for pumps, controls, HVAC, lighting
- **Variable-frequency drives:** For compressor motor and possibly generator (if variable-speed operation is implemented)

### Control System
- **Distributed control system (DCS):** Siemens SPPA-T3000 or equivalent, with redundant controllers, operator workstations, historian, and engineering workstation
- **SCADA interface:** DNP3 or ICCP to transmission operator
- **Protective relaying:** Multifunction microprocessor relays (SEL or GE Multilin), with redundant protection schemes per NERC PRC standards

## Construction Schedule

A representative construction schedule for a first commercial 100 MW / 1,000 MWh PHES plant:

| Phase | Duration | Key Activities |
|-------|----------|---------------|
| Front-End Engineering Design (FEED) | 9–12 months | Detailed engineering, procurement specifications, permitting |
| Permitting and Site Preparation | 6–12 months | Conditional Use Permit, building permits, interconnection agreement, site grading |
| Major Equipment Procurement | 18–24 months | Turbomachinery (longest lead item), heat exchangers, transformers |
| Civil Construction | 12–18 months | Foundations, tank construction, power block building, electrical yard, roads |
| Mechanical Installation | 9–12 months | Tank internals, piping, heat exchangers, pumps, turbomachinery setting |
| Electrical and Controls Installation | 6–9 months | Cable tray and conduit, switchgear, DCS panels, instrumentation |
| Commissioning | 4–6 months | Subsystem testing, salt melting and fill, antifreeze fill, turbomachinery first run, integrated testing |
| **Total (from FEED start to COD)** | **30–42 months** | |

The turbomachinery is the critical path item (18–24 month manufacturing lead time). Overlapping turbomachinery procurement with civil construction can reduce the overall schedule.

## First-of-a-Kind Capital Cost Estimate

Malta has not publicly disclosed a detailed capital cost estimate for the first commercial plant. Based on industry analysis and analogy to comparable projects, a representative estimate:

| Cost Category | Estimated Cost ($M) |
|--------------|---------------------|
| Turbomachinery package (Siemens Energy) | $50–70M |
| Heat exchangers (Alfa Laval/other) | $15–25M |
| Salt and antifreeze fluid fill | $10–20M |
| Tanks (hot salt + cold antifreeze) | $20–30M |
| Electrical equipment (transformer, switchgear, VFD) | $10–15M |
| Balance of plant (piping, civil, structures) | $15–25M |
| EPC management, engineering, owner's costs | $20–30M |
| Contingency (25–35% for FOAK) | $25–40M |
| **Total Installed Cost** | **$165–255M** |

This range represents $1,650–2,550/kW or $165–255/kWh, consistent with the economic analysis presented in the Duration Economics discussion. The wide range reflects the inherent uncertainty in first-of-a-kind project cost estimation for a novel technology — the actual cost will depend on site-specific conditions, commodity price fluctuations (steel, copper), and the aggressiveness of the EPC contracting strategy.