# Chilled Antifreeze — Cold Storage System

## Cold Reservoir Function

The cold-side storage subsystem stores thermal energy in the form of a chilled hydrocarbon-based antifreeze fluid at approximately −60°C. During charging, the antifreeze is cooled from its "warm" tank temperature (approximately −10°C) to its "cold" tank temperature (−60°C) as it passes through the cold-side heat exchanger, absorbing heat from the working fluid (argon) that has been expanded through the turbine and is at cryogenic temperatures. During discharging, the chilled antifreeze serves as the cold reservoir for the heat engine, absorbing waste heat rejected from the power cycle and warming from −60°C back to approximately −10°C.

In thermodynamic terms, the cold reservoir provides the low-temperature sink that enables the heat engine to operate — without a cold sink, heat cannot be converted to work. This is the same role that a river, cooling tower, or atmosphere plays for a conventional steam power plant.

## Antifreeze Fluid Selection

Malta uses a hydrocarbon-based heat transfer fluid formulated for low-temperature service. Likely candidates include:

### Syltherm XLT (Dow Chemical)
- **Chemistry:** Polydimethylsiloxane (silicone-based polymer)
- **Operating range:** −111°C to 260°C (manufacturer recommended)
- **Key properties:** Low viscosity at low temperatures, high flash point, non-corrosive, chemically stable
- **Disadvantage:** Higher cost than hydrocarbon alternatives

### Dynalene MV (Dynalene Inc.)
- **Chemistry:** Hydrocarbon mixture with proprietary additives
- **Operating range:** −112°C to 163°C
- **Key properties:** Low viscosity, industrially proven in low-temperature refrigeration and process cooling

### Paratherm CR (Paratherm)
- **Chemistry:** Hydrocarbon-based (synthetic isoparaffinic hydrocarbon)
- **Operating range:** −80°C to 177°C
- **Key properties:** Low-temperature pumpability, non-toxic, non-hazardous classification

The specific fluid selection involves tradeoffs between low-temperature viscosity (lower is better for pumping power), cost, thermal stability, materials compatibility, and environmental/handling characteristics.

## Cold Tank Design

The cold antifreeze storage tank is mechanically similar to the hot salt tank (cylindrical, flat-bottomed, API 650-type) but requires low-temperature-rated materials and insulation designed to prevent heat ingress rather than heat loss.

### Tank Dimensions (Representative 100 MW / 1,000 MWh System)
- **Diameter:** 25–40 meters
- **Height:** 12–18 meters
- **Volume:** 10,000–25,000 cubic meters
- **Insulation thickness:** 400–600 mm (thicker than hot tank due to larger ΔT with ambient)

### Materials of Construction
- **Tank shell and bottom:** Low-temperature carbon steel (ASTM A516 Grade 70 or A537 Class 1), impact-tested at −60°C per ASTM A20 supplementary requirements to ensure adequate notch toughness (resistance to brittle fracture) at the minimum design metal temperature
- **Internal surfaces:** No lining required for hydrocarbon antifreeze service
- **Foundation:** Similar to hot tank (concrete ring wall with granular fill), but the foundation insulation is designed to prevent frost heave of the underlying soil. If the foundation temperature drops below freezing, moisture in the soil can freeze, expand, and heave, damaging the foundation. Electric soil heating cables or a ventilated air gap beneath the foundation may be incorporated to maintain above-freezing soil temperature

### Insulation System
The cold tank insulation system must prevent ambient heat from warming the chilled antifreeze and must also prevent condensation and ice formation on the tank exterior:

- **Tank shell insulation:** Closed-cell foam insulation (polyisocyanurate or cellular glass), 400–600 mm thickness, with a continuous vapor barrier (aluminum foil laminate or PVC jacket) on the warm side (exterior) to prevent moisture ingress. Moisture that penetrates the insulation and freezes can cause insulation degradation and loss of thermal performance
- **Tank roof insulation:** Similar closed-cell foam system, 300–500 mm thickness, with the vapor barrier on the top (exterior) surface
- **Foundation insulation:** Cellular glass (foam glass) is preferred for foundation applications because it is impermeable to water, has high compressive strength, and maintains insulation performance even if groundwater infiltrates the foundation zone. Thickness of 300–500 mm

### Heat Ingress
Estimated ambient heat ingress to the cold tank:

| Tank Component | Heat Ingress (kW) | Percentage of Stored Energy per Day |
|---------------|-------------------|-------------------------------------|
| Shell | 200–400 kW | 0.48–0.96% |
| Roof | 50–150 kW | 0.12–0.36% |
| Foundation | 20–40 kW | 0.05–0.10% |
| **Total** | **270–590 kW** | **0.65–1.42%** |

Note that heat ingress to the cold tank is effectively a "round-trip" loss — the heat that warms the antifreeze during storage must be re-extracted during the next charging cycle (additional compressor work), and also reduces the temperature differential available for power generation during the next discharge cycle.

## Glycol Loop and Refrigeration Integration

The cold antifreeze system is not typically chilled by direct contact with the Brayton cycle working fluid, but through an intermediate heat transfer loop using a secondary refrigerant (e.g., a glycol-water mixture or a low-temperature hydrocarbon). This intermediate loop:

1. Transfers cold from the Brayton cycle working fluid (at −60°C after expansion) to the antifreeze storage tank
2. Provides a buffer between the closed argon loop and the large-volume storage tanks, simplifying leak detection, fluid make-up, and maintenance
3. May incorporate a supplemental mechanical refrigeration system (vapor-compression chillers) to maintain the cold tank temperature during extended idle periods or to "top up" the cold reservoir if ambient heat ingress exceeds the Brayton cycle's cooling capacity during a given charge cycle

## Safety and Environmental Considerations

- **Toxicity:** Hydrocarbon-based antifreeze fluids are generally classified as non-toxic or low-toxicity (unlike ethylene glycol, which is toxic if ingested). Dow's Syltherm XLT is classified as non-hazardous under OSHA Hazard Communication Standard
- **Flammability:** Silicone-based fluids like Syltherm XLT have flash points above 47°C and are classified as combustible (Class IIIB) rather than flammable, with relatively low fire risk. Hydrocarbon-based fluids may have lower flash points and require standard flammable liquid storage precautions (grounding, bonding, fire suppression per NFPA 30)
- **Spill containment:** Secondary containment (concrete dike or berm) sized per EPA SPCC regulations (110% of largest tank volume) captures any leak
- **Pressure:** Atmospheric pressure storage, eliminating catastrophic pressure-vessel failure modes

## Comparison: Hot vs. Cold Storage

| Parameter | Hot Storage (Molten Salt) | Cold Storage (Antifreeze) |
|-----------|--------------------------|---------------------------|
| Fluid | NaNO₃/KNO₃ (Solar Salt) | Hydrocarbon or silicone-based |
| Hot tank temp | 565°C | −10°C |
| Cold tank temp | 250°C | −60°C |
| ΔT utilized | 315°C | 50°C |
| Mass (for 1,000 MWh) | ~20,000–40,000 MT | ~10,000–20,000 MT |
| Main tank cost driver | High-temp material spec | Low-temp material spec |
| Insulation focus | Prevent heat loss | Prevent heat ingress |
| Freeze risk | Salt solidification at <220°C | Minimal (fluid remains liquid to <−100°C) |
| CSP industry precedent | Extensive (Solar Two, Crescent Dunes, NOORo) | Limited |

The asymmetry in hot vs. cold ΔT (315°C vs. 50°C) reflects the thermodynamic reality that extracting useful work from a temperature difference is far more effective at high absolute temperatures. The hot reservoir stores more energy per degree of temperature change, and the cold reservoir's primary function is to provide the low-temperature sink — its modest ΔT is sufficient for efficient heat rejection in the power cycle.