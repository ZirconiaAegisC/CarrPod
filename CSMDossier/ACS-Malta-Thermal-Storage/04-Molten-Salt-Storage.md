# Molten Salt & Thermal Storage Architecture

## Molten Salt Selection

Malta Inc's hot-side thermal energy storage uses a molten nitrate salt mixture as the heat transfer and storage fluid. Nitrate salt mixtures have been extensively used in concentrated solar power (CSP) plants since the 1980s, most notably in the Solar Two project (California, 1996–1999) and the Crescent Dunes Solar Energy Project (Nevada, 2015–2019), as well as in numerous parabolic trough CSP plants with thermal energy storage in Spain.

### Salt Chemistry

The typical formulation is a binary or ternary eutectic mixture:

- **Solar Salt (binary):** 60% sodium nitrate (NaNO₃) + 40% potassium nitrate (KNO₃) by weight
  - Melting point: approximately 220–240°C
  - Thermal stability limit: approximately 565°C (above which nitrate decomposition begins, producing nitrites and oxygen)
  - Specific heat capacity: approximately 1.5 kJ/(kg·K)
  - Density: approximately 1,900 kg/m³ at 300°C

- **Hitec Salt (ternary):** 53% KNO₃ + 40% NaNO₂ + 7% NaNO₃
  - Lower melting point (~142°C) but lower thermal stability limit (~450°C) and nitrite oxidation concerns at high temperature

Malta's design uses Solar Salt (binary nitrate) to maximize the operating temperature range and therefore the energy storage density per unit volume of salt. The upper temperature limit of 565°C is a well-characterized constraint from the CSP industry; exceeding this temperature causes nitrate decomposition that generates corrosive nitrite compounds and releases oxygen gas, which can cause tank pressurization.

### Salt Sourcing

Sodium nitrate and potassium nitrate are commodity industrial chemicals with established global supply chains:

- **Sodium nitrate:** Produced primarily from natural nitrate deposits in Chile's Atacama Desert (the world's largest natural nitrate source) and via synthetic production (neutralization of nitric acid with sodium carbonate)
- **Potassium nitrate:** Produced primarily via reaction of potassium chloride (from potash mining) with nitric acid, or from sodium nitrate via double decomposition with potassium chloride
- **Cost:** Solar Salt costs approximately $500–800 per metric ton at industrial volumes (5,000+ MT orders), representing a relatively modest fraction of total system capital cost

## Hot Salt Tank Design

The hot salt storage tank is a large, cylindrical, flat-bottomed, above-ground storage tank designed and constructed to API 650 (Welded Steel Tanks for Oil Storage) or API 620 (Design and Construction of Large, Welded, Low-Pressure Storage Tanks) standards. Key design features:

### Tank Dimensions (Representative 100 MW / 1,000 MWh System)
- **Diameter:** 25–40 meters (82–131 feet)
- **Height:** 12–18 meters (39–59 feet)
- **Volume:** 10,000–25,000 cubic meters (2.6–6.6 million gallons)
- **Salt mass:** 19,000–47,500 metric tons
- **Wall thickness:** 10–25 mm (varying by course, thicker at bottom due to hydrostatic pressure)

### Materials of Construction
- **Tank shell and bottom:** Carbon steel (ASTM A516 Grade 70 or ASTM A36) for the structural tank body. Carbon steel is compatible with molten nitrate salts at the operating temperature range provided oxygen and moisture are excluded
- **Internal surfaces:** No internal lining or coating is typically required for nitrate salt service, though a corrosion allowance (1–3 mm) is added to the design thickness
- **Foundation:** A concrete ring wall foundation with a compacted granular fill base, supporting a steel bottom plate. The foundation includes a leak detection system (sand or gravel layer with drainage channels and level sensors) to detect any salt leakage before it reaches the environment

### Insulation System
Thermal insulation is critical to minimizing heat loss from the hot tank. A typical insulation system includes:
- **Tank shell insulation:** Mineral wool or calcium silicate blocks, 300–500 mm thickness, protected by aluminum or stainless steel weather jacketing, achieving an external surface temperature of <50°C
- **Tank roof insulation:** Mineral wool batts or cellular glass insulation installed on the tank roof, 200–400 mm thickness. The roof is a fixed cone or dome roof (not a floating roof, which would allow air ingress and salt oxidation)
- **Foundation insulation:** Foam glass (cellular glass) or insulating firebrick beneath the tank bottom, 200–300 mm thickness, to prevent heat conduction into the ground and protect the concrete foundation from excessive temperatures

### Thermal Losses
For a tank of this size, the surface-area-to-volume ratio is favorable. Estimated thermal losses:

| Tank Component | Heat Loss (kW) | Percentage of Stored Energy per Day |
|---------------|---------------|-------------------------------------|
| Shell | 150–300 kW | 0.36–0.72% |
| Roof | 50–100 kW | 0.12–0.24% |
| Foundation | 30–50 kW | 0.07–0.12% |
| **Total** | **230–450 kW** | **0.55–1.08%** |

These losses are acceptable for durations up to several weeks; for very long-duration seasonal storage (>30 days), additional insulation thickness or active trace heating using a small fraction of the stored energy may be required.

### Freeze Protection
The most significant operational risk for the hot salt system is salt freezing. If the salt temperature drops below approximately 220°C anywhere in the system (tank, piping, heat exchanger, pump), the salt will solidify, potentially causing equipment damage and requiring expensive thawing operations.

Freeze protection measures include:
- Electric heat tracing on all salt piping, valves, pump casings, and instrument connections
- Redundant temperature monitoring throughout the salt circuit
- Automated recirculation pumps that circulate salt back to the tank when the plant is idle, preventing stagnation-induced cooling
- Backup heating systems (gas-fired or electric immersion heaters) to maintain minimum tank temperature during extended outages
- Design of all salt-wetted components for drainability, so that salt can be gravity-drained back to the tank (or to a dedicated drain tank) in the event of an extended outage

## Cold Salt Tank ("Warm Tank")

After the salt transfers its thermal energy to the working fluid during discharge, it returns to the "cold" salt tank at approximately 250°C. This tank is functionally identical to the hot tank in terms of materials and construction but operates at a lower temperature. The 250°C temperature is maintained above the salt freezing point with margin, and the insulation requirements are proportionally lower than for the hot tank.

## Salt Pumping

Molten salt is circulated between the tanks and the heat exchanger using vertical turbine pumps (also called vertical cantilever pumps or sump pumps) that are partially submerged in the salt within the tank. These pumps are a specialized but established technology from the CSP industry. Key design features:

- **Materials:** Stainless steel (304 or 316) or nickel-based alloy (Alloy 625 or Hastelloy C-276) for salt-wetted components
- **Sealing:** No mechanical seal (which would be unreliable at 565°C); instead, the pump shaft is supported by bearings within the pump column, and the drive motor is mounted above the tank roof, with a long shaft extending down into the salt
- **Flow control:** Variable-frequency drive (VFD) on the pump motor to modulate salt flow rate based on the instantaneous charge/discharge power level
- **Redundancy:** Typically 2 × 100% or N+1 pump configuration to ensure availability; salt pumps are the most maintenance-intensive component in a CSP plant and are expected to require scheduled replacement on 5–10 year intervals

## Safety and Environmental Considerations

- **Pressure:** Both hot and cold salt tanks operate at atmospheric pressure, eliminating the catastrophic pressure-vessel failure modes associated with compressed gas or steam storage
- **Toxicity:** Nitrate salts are not classified as hazardous substances; they are essentially fertilizers (both NaNO₃ and KNO₃ are used as agricultural fertilizers). A tank leak would release warm salt onto the secondary containment basin, where it would cool and solidify into a relatively benign solid mass that could be mechanically removed
- **Fire risk:** Nitrate salts are oxidizing agents but are not themselves combustible; at the operating temperature range, they do not pose a fire risk to the tank steel or surrounding equipment
- **Environmental permitting:** Molten salt storage is well-understood by permitting agencies due to its extensive use in CSP plants, reducing the permitting timeline and uncertainty relative to novel storage technologies