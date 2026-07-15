# 16 — HAPS, SPECIALTY APPLICATIONS & NEXT-GENERATION DEPLOYMENTS

## High-Altitude Pseudo-Satellite (HAPS) Program

### Technology Context

High-altitude pseudo-satellites (HAPS) are unmanned aerial vehicles (UAVs) designed to operate at stratospheric altitudes (17–25 km) for extended durations — weeks to months — on solar-electric propulsion. HAPS platforms occupy a unique operational altitude between conventional aircraft and low-Earth-orbit satellites, providing persistent surveillance, communications relay, and environmental monitoring capabilities without the latency and coverage limitations of orbital platforms.

The power system is the single most critical subsystem of a HAPS platform. The photovoltaic array must provide sufficient power for propulsion and payload during daylight hours while charging an energy storage system (typically lithium-ion or lithium-sulfur batteries, or regenerative fuel cells) for nighttime operation. The figure of merit for HAPS photovoltaic arrays is specific power — watts per kilogram — rather than cost per watt or even efficiency per se. Every gram of photovoltaic mass saved cascades through the platform design, reducing structural mass, propulsion power requirements, and energy storage capacity.

### Oxford PV HAPS Module Technology

Oxford PV's HAPS program leverages the intrinsic advantages of the perovskite-silicon tandem architecture for high-specific-power applications:

**Substrate Flexibility**: The perovskite top cell can be deposited on thin (<100 μm) silicon wafers or, in the ultimate lightweight configuration, on flexible metal foil or polymer substrates. For the HAPS product, Oxford PV has developed an ultralight module architecture based on:

- **Flexible substrate**: 25 μm polyimide film with an integrated moisture barrier (alternating polymer/alumina nanolaminate).
- **Perovskite top cell**: Deposited directly on the barrier-coated substrate, eliminating the front glass and reducing mass by over 90% relative to a glass-glass module of equivalent area.
- **Thin-film encapsulation**: Atomic layer deposition (ALD) alumina barrier layer with a combined WVTR and oxygen transmission rate below 10⁻⁵ g/m²/day, providing moisture protection comparable to glass encapsulation at a fraction of the mass.
- **Lightweight interconnects**: Screen-printed low-temperature silver paste with optimized grid geometry for the low-current (high-voltage) operating conditions characteristic of HAPS arrays.

**Performance under Stratospheric Conditions**: The perovskite-silicon tandem architecture is well-suited to stratospheric solar exposure. The AM0 spectrum at 20 km altitude (approximately 1.35 kW/m² irradiance, with enhanced UV content relative to AM1.5G) is partially compensated by the perovskite top cell's efficient absorption of high-energy photons. The low operating temperature (approximately -50°C at altitude) further benefits the tandem architecture, as the temperature coefficient advantage of the high V_oc tandem junction is amplified under cold conditions.

**Preliminary Performance Data** (laboratory conditions, simulated AM0, 200 K):

| Parameter | Value | Unit |
|-----------|-------|------|
| Specific power (module level) | 800–1200 | W/kg |
| Areal power density (AM0) | 350–380 | W/m² |
| Module efficiency (AM0) | 25.9–28.1 | % |
| Bending radius (flexible substrate) | 150 | mm |
| Areal mass (module, excl. edge connector) | 0.35–0.45 | kg/m² |

At 1000 W/kg specific power, the Oxford PV HAPS array achieves approximately 3× the specific power of the best commercially available space-grade triple-junction III-V photovoltaic arrays (typically 300–400 W/kg for rigid panels, 500–600 W/kg for flexible blanket arrays). This specific power advantage is the driving force behind the interest from HAPS platform developers and defense contractors.

### HAPS Market and Customers

The HAPS market is in its formative stage, with several platform developers pursuing parallel commercialization pathways:

- **Airbus Zephyr**: The Zephyr program, initiated by QinetiQ and subsequently acquired by Airbus Defence and Space, holds the endurance record for a stratospheric UAV (64 days continuous flight in 2022). The Zephyr platform requires photovoltaic arrays with specific power exceeding 800 W/kg to achieve operational viability.
- **BAE Systems PHASA-35**: A 35-meter wingspan HAPS platform developed by BAE Systems and Prismatic Ltd., targeting telecommunications applications.
- **SoftBank HAPSMobile**: A Japanese initiative developing the Sunglider platform for stratospheric telecommunications, with a 78-meter wingspan and a target specific power of 1000+ W/kg for the photovoltaic array.
- **Thales Alenia Space Stratobus**: A European stratospheric airship concept requiring large-area, low-mass photovoltaic arrays.

Oxford PV has confirmed engagement with "multiple aerospace and defense prime contractors" for HAPS module evaluation but has not publicly disclosed specific customer relationships.

## Other Specialty Applications

### Building-Integrated Photovoltaics (BIPV)

The tandem module architecture can be adapted for BIPV applications where aesthetic requirements demand custom form factors, colors, or semi-transparency. Oxford PV has explored:

- **Semi-transparent tandem modules**: By adjusting the perovskite thickness and rear electrode transparency, modules with controlled visible light transmission (10–30%) can be produced for atrium roofs, skylights, and facade elements where daylighting and photovoltaic power generation must be balanced.
- **Colored modules**: Through modification of the anti-reflection coating or the incorporation of dielectric mirror layers, the module's reflected color can be tuned for architectural integration. The Bragg-mirror-based coloring approach is preferred over pigment-based approaches because it can be implemented without significant efficiency loss.

### Space Photovoltaics

The ultimate extension of the HAPS program is space deployment — low Earth orbit (LEO), medium Earth orbit (MEO), and geostationary orbit (GEO). Space photovoltaics present extreme environmental challenges:

- **Radiation hardness**: Energetic particle radiation (electrons, protons) in the Van Allen belts and during solar particle events can displace atoms in the perovskite lattice, creating deep-level defects that increase recombination. Preliminary proton irradiation testing (3 MeV, 10¹²–10¹⁴ p/cm² fluence) at the University of Oxford's particle accelerator facility has shown that perovskite-silicon tandem cells exhibit radiation tolerance comparable to or exceeding that of III-V multi-junction cells, with the high defect tolerance of the perovskite absorber partially compensating for radiation-induced defect generation.
- **Thermal cycling**: LEO satellites experience 16 thermal cycles per day (90-minute orbit, alternating between direct sunlight and Earth shadow), with temperature extremes of approximately +120°C to -120°C. The glass-glass tandem module architecture, adapted with space-qualified materials, must survive thousands of such cycles without delamination or performance degradation.
- **Atomic oxygen**: In LEO, atomic oxygen erodes exposed organic materials (polymers, some encapsulants). The ALD alumina encapsulation developed for the HAPS program provides effective atomic oxygen resistance, as alumina is inherently resistant to atomic oxygen attack.

Oxford PV's space photovoltaic program is at the early feasibility stage, with no publicly announced space-customer engagements or flight heritage.

### Vehicle-Integrated Photovoltaics (VIPV)

The integration of photovoltaic modules into vehicle body panels (roof, hood, trunk lid) to extend electric vehicle range is an emerging application. VIPV requirements include:

- **Curved surface compatibility**: Module must conform to the compound curvature of vehicle body panels, requiring flexible substrate technology similar to that developed for HAPS.
- **Partial shading tolerance**: Vehicle roofs are frequently partially shaded by buildings, trees, and other vehicles. The shingled module architecture provides inherent shade tolerance.
- **Aesthetic integration**: Module color and finish must match or complement the vehicle's paint scheme.
- **Safety certification**: Automotive-grade mechanical (impact, vibration) and electrical (high-voltage isolation) safety certification.

Oxford PV has confirmed exploratory discussions with European automotive OEMs but has not announced any VIPV development partnership.

## References

- Oxford PV. "HAPS and Specialty Products: Technology Overview." Internal Briefing Document, Q1 2025.
- Airbus Defence and Space. "Zephyr: The High Altitude Pseudo-Satellite." Program Overview, 2025.
- Kirmani, A.R. et al. "Countdown to perovskite space launch: Guidelines to performing relevant radiation-hardness experiments." *Joule* 6, 1015–1031 (2022).
- SoftBank Corp. "HAPSMobile Sunglider: Stratospheric Telecommunications Platform." Technical Overview, 2024.
