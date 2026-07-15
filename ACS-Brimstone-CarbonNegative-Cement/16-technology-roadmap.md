# 16 — Technology Roadmap & Scalability

## Technology Readiness Level (TRL) Trajectory

| Stage | TRL | Year | Milestone |
|-------|-----|------|-----------|
| Lab-scale proof of concept | TRL 3–4 | 2019–20 | CaSiO3 → clinker at gram scale |
| Bench-scale continuous | TRL 4–5 | 2020–21 | 1–10 kg/hr rotary tube furnace |
| Pilot kiln | TRL 5–6 | 2021–23 | ~1,000 t/yr pilot; ASTM testing |
| Demonstration plant (current) | TRL 7–8 | 2023–27 | 250–500k t/yr; first commercial |
| Full commercial replicate | TRL 9 | 2028+ | 1.5M+ t/yr plants |

## Manufacturing Scale-Up Challenges

### Kiln Scale Risk

The chemistry has been validated at pilot scale (1–10 t/day). The primary scaling
risk is the transition to a full-scale rotary kiln (2,000–5,000 t/day). Key
uncertainties that the demonstration plant resolves:

1. **Feed behavior in large preheater cyclones:** Silicate raw meal may have different
   particle agglomeration and sticking behavior compared to limestone-based raw meal.
2. **Coating formation on refractory:** Stable coating (frozen clinker layer on kiln
   brick) is essential for refractory life (typically 6–18 months in the burning zone).
   Silicate-derived liquid phase may exhibit different wetting and coating dynamics.
3. **Ring formation:** Sulfur and alkali cycles in the preheater can cause sulfate-spurrite
   rings; Brimstone's inherently lower sulfur feed (no limestone-associated pyrite) may
   mitigate this.
4. **Clinker grindability:** Different clinker nodule morphology from silicate feed may
   affect Bond Work Index for finish grinding.

Mitigation: The first kiln includes instrumented zones (thermocouple arrays, gas
sampling ports, shell scanners) and extended commissioning with conservative ramp-up.

### Feedstock Variability

Basalt chemistry varies by quarry location and even within a single quarry. Unlike
limestone (relatively homogeneous CaCO3), basalt spans a range of CaO:SiO2:MgO:Al2O3:Fe2O3
ratios. Mitigation:

- **Mine planning:** 3D geochemical block model of the quarry
- **Blending beds:** Longitudinal (chevron) stacker/reclaimer stockpile homogenization
- **Real-time PGNAA (Prompt Gamma Neutron Activation Analysis):** Online elemental
  analysis on conveyor belt; feedback to weigh feeders
- **Corrective material dosing:** Automated bauxite and iron ore addition to hit
  target LSF, SM, and AM (lime saturation factor, silica modulus, alumina modulus)

### MgO Carbonation at Scale

The engineered carbonation system for MgO byproduct is a novel unit operation with
no direct precedent at cement plant scale. Design considerations:

- **Footprint:** At 500,000 t/yr, the MgO stream is ~35,000–50,000 t/yr (before
  carbonation), requiring ~2–5 acres for carbonation cells
- **Water management:** MgO hydration to Mg(OH)2 is exothermic; carbonation proceeds
  faster through the hydroxide pathway (Mg(OH)2 + CO2 → MgCO3 + H2O)
- **Heat management:** Exothermic carbonation (1.18 GJ/t CO2) may require passive
  cooling in cell design to avoid over-temperature
- **Throughput optimization:** Counter-current air flow, intermittent turning
  (windrow-style), moisture sensors, and in-situ CO2 concentration monitoring

## Next-Generation Process Improvements (R&D Pipeline)

### 1. Low-Temperature Clinkering with Mineralizers

Fluoride (CaF2) or sulfate (CaSO4) mineralizers can reduce clinkering temperature
by 100–200°C, proportionally reducing fuel consumption and combustion CO2. Fluoride
mineralization also promotes C3S formation at lower temperatures, potentially
improving throughput. Studies underway at Caltech.

### 2. Electrified Kiln (Plasma or Resistive Heating)

Replacing the main kiln burner with an electric plasma torch or resistive heating
element eliminates combustion CO2 entirely. The precalciner can also be electrified
using microwave-assisted or induction heating. At $0.03–0.05/kWh (renewable PPA),
electric cement production becomes cost-competitive with fossil fuel at $20–30/ton
carbon price.

### 3. CO2-Enriched MgO Carbonation

Using concentrated CO2 streams (from any residual combustion or from DAC units)
instead of ambient air accelerates carbonation kinetics by 5–20×, reducing residence
time and cell footprint.

### 4. Ex-Situ Carbonation of Mine Tailings

Expanding carbonation to basalt quarry fines and overburden (not just process
byproduct) can increase the net carbon-negative balance. Ultramafic mine tailings
worldwide have an estimated CO2 sequestration capacity of 1–4 Gt/yr.

### 5. Electrochemical MgO Activation

Applying a mild electrochemical potential to MgO slurries can generate reactive
oxygen species at the MgO surface, accelerating carbonation by orders of magnitude.
Early-stage collaboration with electrochemical engineering groups at Stanford and
MIT.

## Global Replicability Assessment

| Region | Basalt Resource | Regulatory Pull | Market Size | Viability |
|--------|----------------|-----------------|-------------|-----------|
| US West Coast | Excellent (Cascades, CRBG) | Strong (CA Buy Clean) | Large | **High** |
| US East Coast | Good (CAMP basalts, imported) | Emerging (NY LECCLA) | Large | **High** |
| EU | Moderate (EU has less basalt) | Strong (CBAM, EU-ETS) | Very large | Medium (licensing) |
| India | Good (Deccan Traps) | Emerging | Very large | **High** (licensing) |
| Middle East | Good (ophiolites in Oman, UAE) | Emerging (sovereign green push) | Large | **High** (JV) |
| Brazil | Excellent (Paraná Basin) | Emerging | Large | **High** |
| SE Asia | Moderate | Weak | Large | Lower priority |
| Africa | Good (Karoo, East African Rift) | Weak | Growing | Longer-term |

## 2035 Production Target

Brimstone's stated ambition (per investor materials) is to achieve **10–20 million
metric tons per year of global production capacity by 2035**, representing ~0.2–0.5%
of the global cement market — or approximately 2–5% of the US market. At 10M t/yr
and a carbon-negative balance of −100 kg CO2/t, this represents **1 million metric
tons of net CO2 removal annually**, equivalent to the annual sequestration from
approximately 45 million mature trees.
