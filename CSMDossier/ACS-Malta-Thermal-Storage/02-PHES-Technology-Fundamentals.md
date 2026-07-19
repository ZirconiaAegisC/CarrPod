# Pumped Heat Energy Storage — Technology Fundamentals

## Concept Overview

Pumped Heat Energy Storage (PHES), also known as a "Carnot battery" or "thermal battery," is a thermodynamic energy storage technology that converts electrical energy into thermal energy (heat and cold) for storage, and then converts the stored thermal energy back to electrical energy on demand. PHES is distinct from electrochemical batteries in that the storage medium is not chemical potential but thermal potential — specifically, a temperature differential between two separate fluid reservoirs.

## Thermodynamic Foundation

PHES operates on the fundamental principles of thermodynamics:

### First Law (Energy Conservation)
The electrical energy consumed during charging is converted to thermal energy and stored in the hot and cold reservoirs. During discharging, the stored thermal energy is reconverted to electrical energy. The round-trip efficiency (RTE) is the ratio of electrical energy output during discharge to electrical energy input during charge, typically targeting 55–65% for PHES systems.

### Second Law (Entropy and Carnot Efficiency)
The maximum theoretical efficiency of converting heat to work is determined by the Carnot efficiency: η = 1 − T_cold / T_hot, where temperatures are in Kelvin. For Malta's design (T_hot ≈ 838 K or 565°C, T_cold ≈ 213 K or −60°C), the theoretical Carnot efficiency is approximately 1 − 213/838 = 74.6%. Practical PHES systems achieve 55–65% RTE, representing approximately 75–85% of the theoretical Carnot limit, which is comparable to the realized vs. theoretical efficiency of modern combined-cycle gas turbines.

## System Architecture

The PHES system consists of four primary subsystems:

### 1. Charging System (Heat Pump)
During charging, a motor-driven compressor pressurizes a gaseous working fluid (typically argon or an argon-helium mixture), raising its temperature to approximately 600°C. The hot, high-pressure gas passes through a heat exchanger where it transfers heat to the molten salt stream, heating the salt from its "cold" tank temperature (~250°C) to its "hot" tank temperature (~565°C). The now-cooled working fluid is expanded through a turbine to further reduce its temperature, chilling it to approximately −60°C, at which point it passes through a cold-side heat exchanger where it extracts heat from the antifreeze stream, chilling it. The working fluid then returns to the compressor inlet, completing the charging cycle.

### 2. Storage System (Thermal Reservoirs)
The stored energy resides in two insulated tank farms:
- **Hot storage:** Molten salt at approximately 565°C, stored in insulated carbon steel or stainless steel tanks
- **Cold storage:** Chilled hydrocarbon-based antifreeze at approximately −60°C, stored in insulated, low-temperature-rated carbon steel tanks

The tanks are standard cylindrical, flat-bottomed, API 650-type atmospheric pressure tanks, identical in design to those used in the oil & gas and chemical industries for decades.

### 3. Discharging System (Heat Engine)
During discharge, the thermodynamic cycle reverses. The molten salt from the hot tank heats the working fluid through the hot-side heat exchanger. The hot, high-pressure working fluid expands through a turbine, driving a generator to produce electricity. The working fluid, now cooler and at lower pressure, passes through the cold-side heat exchanger where it is further cooled by the chilled antifreeze stream, condensing (if a phase-change working fluid is used) or simply cooling further. The working fluid is then recompressed and the cycle repeats, continuously extracting heat from the hot salt, converting it to electricity, and rejecting waste heat to the cold antifreeze.

### 4. Power Conversion System
The turbine-generator set and motor-compressor set are coupled to the electrical grid through power electronics. Variable-speed drives allow the system to operate at optimal thermodynamic efficiency across a range of charge and discharge power levels ("part-load operation").

## Working Fluid Selection

Malta's design uses argon as the primary working fluid, selected for several advantages:

- **Monatomic gas:** Simple thermodynamic behavior; no molecular vibrational modes that cause non-ideal behavior at extreme temperatures
- **Chemically inert:** No combustion, corrosion, or decomposition concerns at 600°C operating temperatures
- **Well-characterized properties:** Extensively studied in closed-cycle gas turbine applications (nuclear power, space power systems)
- **Abundant:** Argon constitutes approximately 1% of Earth's atmosphere and is produced as a byproduct of liquid oxygen and liquid nitrogen production

Some PHES designs use argon-helium mixtures or supercritical CO₂ (sCO₂) as the working fluid. The sCO₂ Brayton cycle offers higher power density and potentially higher efficiency but requires more complex turbomachinery design to handle the non-ideal gas behavior near the critical point.

## Comparison to Other Storage Technologies

| Technology | Storage Medium | Round-Trip Efficiency | Duration Range | Key Limitation |
|-----------|---------------|----------------------|----------------|---------------|
| PHES (Malta) | Thermal (molten salt + antifreeze) | 55–65% | 10–200+ hours | Pre-commercial; turbomachinery cost |
| Pumped Storage Hydro | Gravitational potential (water) | 70–85% | 6–24+ hours | Geographic constraints; 7–10 year build |
| Lithium-Ion Battery | Electrochemical (Li intercalation) | 85–95% | 1–4 hours | Cost scales linearly with duration |
| Iron Flow Battery (ESS) | Electrochemical (Fe redox) | 70–75% | 4–12 hours | Lower power density; pump maintenance |
| Compressed Air (CAES) | Mechanical (compressed air) | 40–70% | 6–24+ hours | Geologic constraints; natural gas co-fire (conventional) |
| Green Hydrogen | Chemical (H₂) | 25–35% | Days–seasonal | Very low efficiency; early commercial |

## Key Design Challenges

### Heat Exchanger Performance
The hot-side and cold-side heat exchangers must operate across extreme temperature differentials (ΔT > 600°C between the working fluid and storage fluid) with high effectiveness (>90%) to achieve target round-trip efficiency. Heat exchanger design involves tradeoffs between effectiveness (which impacts RTE), pressure drop (which impacts pumping power), and cost (more surface area = higher cost). Malta leverages heat exchanger expertise from its investor Alfa Laval, a global leader in industrial heat transfer equipment.

### Turbomachinery Efficiency
The compressor and turbine must achieve high isentropic efficiency (90%+) at the target pressure ratios and mass flow rates. Losses in these components directly reduce round-trip efficiency. Custom turbomachinery design is one of the most significant cost elements in a first-of-a-kind PHES plant.

### Thermal Losses
While large tanks have favorable surface-area-to-volume ratios (minimizing thermal losses per unit of stored energy), insulation design is critical. Malta targets thermal losses of <0.5% of stored energy per day, which requires high-performance insulation (vacuum-insulated panels, aerogel blankets, or thick mineral wool layers) on tank external surfaces.

### Materials Compatibility
The combination of high temperatures (molten salt at 565°C) and low temperatures (antifreeze at −60°C) requires careful material selection:
- Hot-side components: Stainless steel (304, 316, or 347H) or nickel-based alloys for high-temperature strength and corrosion resistance
- Cold-side components: Low-temperature carbon steel (ASTM A516 Grade 70 or similar) rated for brittle fracture prevention at −60°C
- Pump seals, valve seats, and gaskets must be compatible with both the temperature extremes and the specific fluids (nitrate salts, hydrocarbon antifreeze)