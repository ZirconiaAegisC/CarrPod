# Turbomachinery Integration — Siemens Energy Partnership

## Turbomachinery Role in PHES

The turbomachinery is the heart of Malta's Pumped Heat Energy Storage system, performing the mechanical-to-thermal energy conversion during charging (compressing the working fluid) and the thermal-to-mechanical energy conversion during discharging (expanding the working fluid through a turbine). The turbomachinery's performance — specifically its isentropic efficiency — is the single largest determinant of the system's round-trip efficiency.

## Compressor-Turbine Configuration

Malta's design uses a reversible turbomachinery arrangement, which can take two forms:

### Option 1: Reversible Machine (Single Shaft)
A single turbomachine operates as a compressor during charging and as a turbine during discharging, with the direction of rotation maintained constant and the flow paths reconfigured through valves and diverter mechanisms. This configuration:
- **Advantage:** Fewer rotating machines (lower capital cost, smaller footprint)
- **Disadvantage:** Compromised aerodynamic efficiency because the same blade profiles must serve both compression and expansion functions

### Option 2: Separate Compressor and Turbine (Twin Shaft)
Dedicated compressor and turbine trains, with the compressor driven by a motor (charging) or the turbine driving a generator (discharging). The machines are mechanically disconnected, with the working fluid flow path switched between the two via a system of large-diameter valves. This configuration:
- **Advantage:** Each machine is aerodynamically optimized for its single function (compression or expansion), achieving higher isentropic efficiency (90–93% vs. 85–88% for reversible)
- **Disadvantage:** Higher capital cost (two machines) and larger footprint

Malta has publicly indicated a preference for the separate-machine configuration for its first commercial-scale plant, prioritizing efficiency and reliability over minimizing capital cost, which is a conservative engineering choice typical of first-of-a-kind projects.

## Motor-Generator Configuration

The compressor drive motor and turbine-driven generator are large electrical machines designed for continuous-duty industrial operation:

- **Charging Motor:** A synchronous or induction motor, rated for the compressor's maximum shaft power (typically 120–140 MW for a 100 MW (electrical output nameplate) plant), operating at a speed of 3,000 or 3,600 RPM (50 or 60 Hz, direct grid-connected) or variable speed (via a variable-frequency drive). The motor draws power from the grid through the plant's main power transformer
- **Discharging Generator:** A synchronous generator, rated for 100 MW (electrical output), connected to the grid through a step-up transformer (typically 13.8 kV generator voltage stepped up to 115 kV or 230 kV transmission voltage). The generator includes a static excitation system, automatic voltage regulator (AVR), and synchronizing equipment for grid connection
- **Variable-Frequency Drive (VFD):** To enable part-load operation and grid-friendly behavior (soft start, reactive power support), the motor and/or generator may connect to the grid through a VFD system. The VFD provides speed control for the turbomachinery (optimizing efficiency at partial load) and grid code compliance (fault ride-through, reactive power capability per IEEE 1547 or local grid code requirements)

## Siemens Energy Partnership

### Strategic Relationship

In 2020, Malta Inc and Siemens Energy AG (ETR: ENR) announced a strategic partnership to co-develop the turbomachinery package for Malta's PHES system. Siemens Energy is one of the world's largest manufacturers of power generation equipment, with a product portfolio spanning gas turbines (from 5 MW aeroderivative to 600 MW H-class), steam turbines, generators, compressors (reciprocating and centrifugal), and grid technologies.

### Partnership Scope

The Malta-Siemens partnership encompasses:

1. **Turbomachinery Design and Engineering:**
   - Siemens Energy is designing the compressor and turbine trains specifically for Malta's PHES thermodynamic cycle, leveraging Siemens' extensive aerodynamic design capabilities, materials expertise, and manufacturing experience
   - The design process involves computational fluid dynamics (CFD) optimization of blade profiles, secondary flow paths, and casing geometries for the specific working fluid (argon) and operating conditions (closed-loop Brayton cycle at 550–600°C)

2. **Prototype Manufacturing and Testing:**
   - Siemens Energy is fabricating and testing prototype turbomachinery components at its manufacturing and test facilities (likely in Germany — Mülheim an der Ruhr for steam turbines, Duisburg for compressors, or Erlangen for gas turbine R&D)
   - Testing includes aerodynamic performance mapping, mechanical vibration analysis, rotor dynamics validation, and thermal endurance testing

3. **Heat Exchanger Integration:**
   - Siemens Energy is designing the integration of the high-temperature heat exchangers (hot side: working fluid to molten salt) with the turbomachinery, optimizing the compactness of the power block layout

4. **Balance of Plant Engineering:**
   - Siemens Energy contributes to the overall plant design, including the power block layout, piping and instrumentation diagrams (P&IDs), control system architecture (potentially Siemens' SPPA-T3000 DCS platform for power plants), and electrical system design

5. **Supply Chain and Manufacturing Scale-Up:**
   - Siemens Energy will manufacture the turbomachinery packages for commercial PHES plants, leveraging its global supply chain, factories, and field service organization
   - This provides Malta with a pathway to multi-unit production without having to develop its own turbomachinery manufacturing capability — a critical barrier to entry that would require billions of dollars and decades to replicate

### Strategic Value for Both Parties

**For Malta Inc:**
- Access to world-class turbomachinery engineering and manufacturing without the capital investment of building in-house capability
- Siemens' reputation and balance sheet provide credibility with utility customers, project finance lenders, and insurers
- Siemens' global field service organization can provide O&M support for deployed plants, reducing Malta's need to build a global service network

**For Siemens Energy:**
- Entry into the LDES market with a differentiated technology that leverages Siemens' core competencies in turbomachinery and thermal systems
- A new product line (PHES power blocks) that can offset potential revenue declines as the energy transition reduces demand for new fossil gas turbines
- Alignment with Siemens Energy's corporate strategy to expand in energy transition technologies (hydrogen-ready gas turbines, offshore wind grid connections, electrolysis, energy storage)
- Potential to bundle PHES systems with Siemens' broader grid technology portfolio (substations, transformers, HVDC, grid automation) for integrated utility solutions

## Industrial Gas Turbine Heritage

Malta's turbomachinery benefits from the extensive heritage of industrial gas turbine technology:

- **Materials:** Nickel-based superalloys (Inconel 718, Waspaloy) and single-crystal blade technology developed for gas turbine hot sections provide the high-temperature strength and creep resistance needed for 565°C operation in an oxidizing environment
- **Coatings:** Thermal barrier coatings (TBCs) — yttria-stabilized zirconia (YSZ) applied via air plasma spray or electron-beam physical vapor deposition — can be applied to hot-section components to reduce metal temperatures and extend component life
- **Sealing:** Advanced abradable coatings and active clearance control systems (developed for gas turbines to minimize blade-tip leakage) can be adapted for the PHES turbomachinery to minimize internal leakage losses
- **Bearings:** Tilting-pad journal bearings and active magnetic bearings (for oil-free operation, avoiding contamination of the working fluid) are mature technologies from the turbomachinery industry
- **Manufacturing quality:** Siemens' manufacturing quality systems, developed over decades of producing thousands of gas turbine and compressor units, provide the precision and repeatability needed for high-efficiency turbomachinery

## Cost and Schedule Considerations

The turbomachinery package is estimated to represent 40–55% of the total plant capital cost for a first-of-a-kind PHES plant, making it the dominant cost driver alongside the thermal storage tanks. The first commercial turbomachinery package is expected to:

- **Engineering, design, and testing:** 3–4 years
- **Manufacturing lead time:** 18–24 months (comparable to a large industrial gas turbine or steam turbine)
- **Cost:** $40–60 million for the 100 MW power block (Siemens' internal estimate, not publicly confirmed)

Subsequent units are expected to benefit from learning curve effects, with cost reductions of 15–25% from first-of-a-kind to Nth-of-a-kind, driven by:
- Engineering cost amortization across multiple units
- Manufacturing learning curve (reduced labor hours per unit)
- Supply chain optimization (long-term agreements with key component suppliers)
- Design standardization (eliminating one-off engineering for each plant)