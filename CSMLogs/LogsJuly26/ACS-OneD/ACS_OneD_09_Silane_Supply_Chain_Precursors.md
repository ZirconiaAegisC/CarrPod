# ACS OneD Battery Sciences | Silane & Precursor Supply Chain

## 1. Silane in Lithium-Ion Battery Manufacturing

### Role of Silane in SINANODE
Silane (SiH₄) is the sole silicon precursor in the SINANODE process. During anode slurry mixing, silane gas is introduced into the mixer where it thermally decomposes, depositing silicon atoms that nucleate and grow into nanowires within graphite pores. The silane-to-silicon conversion efficiency is a critical process parameter — unreacted silane must be captured and abated.

### Silane Specifications
For SINANODE process use, silane must meet specific purity requirements:

| Impurity | Maximum Concentration | Rationale |
|----------|----------------------|-----------|
| Total chlorosilanes (SiH₂Cl₂, SiHCl₃, SiCl₄) | <10 ppm | Chlorine is a cathode poison; causes capacity fade |
| Total hydrocarbons (CH₄, C₂H₆) | <5 ppm | Carbon incorporation into silicon nanowires affects crystallinity |
| Disilane (Si₂H₆) | <1,000 ppm | Higher silanes decompose at lower temperatures; affect process control |
| Dopant gases (B₂H₆, PH₃) | <50 ppb | Boron and phosphorus doping changes silicon lithiation behavior |
| Oxygen (O₂) | <1 ppm | Oxygen passivates silicon surface; affects nanowire growth |
| Water (H₂O) | <1 ppm | Water hydrolyzes silane; reduces yield and generates silica particles |
| Nitrogen (N₂) | <5% | Nitrogen is the typical carrier/diluent gas; not an impurity per se |

### Semiconductor-Grade vs. Battery-Grade Silane
Silane for SINANODE does not require semiconductor-grade purity (99.9999%+). Battery-grade silane (99.99-99.999%) is adequate because:
- Trace metals from silane are at concentrations below cathode poisoning thresholds
- Semiconductor doping impurities (boron, phosphorus) at semiconductor-grade specs are irrelevant for battery use
- The cost premium for semiconductor-grade silane ($30-50/kg) vs. battery-grade ($15-25/kg) is significant at scale

## 2. Global Silane Production Landscape

### Major Producers
| Producer | Headquarters | Annual Capacity (est.) | Primary Market |
|----------|-------------|----------------------|----------------|
| REC Silicon | Norway/USA (Moses Lake, WA) | 25,000+ tons | Polysilicon, semiconductor |
| Tokuyama Corporation | Japan | 15,000+ tons | Semiconductor |
| OCI Company | South Korea | 10,000+ tons | Polysilicon |
| GCL-Poly Energy | China | 20,000+ tons | Polysilicon |
| Evonik Industries | Germany | 5,000+ tons | Semiconductor, specialty |
| Linde plc | UK/Ireland | 3,000+ tons | Specialty gases |

### REC Silicon and Moses Lake
REC Silicon's Moses Lake, Washington facility is the largest silane production site in the United States and is co-located with Group14's BAM-1 and BAM-2 facilities. This geographic concentration creates both opportunities and risks:
- REC's existing silane capacity can serve initial SINANODE deployment from Moses Lake
- REC's restart of polysilicon production (after trade disputes with China) will expand silane production at the site
- Geographic concentration of silane supply in Grant County, WA creates a potential single-point-of-failure risk

### Silane Production Process
Silane is produced primarily through two routes:

**Trichlorosilane Disproportionation (REC Silicon process)**:
1. Metallurgical-grade silicon reacted with HCl to produce trichlorosilane (SiHCl₃)
2. Trichlorosilane undergoes redistribution reaction: 2 SiHCl₃ → SiH₄ + SiCl₄
3. Silane purified by distillation
4. Silicon tetrachloride (SiCl₄) recycled to produce more trichlorosilane

**Magnesium Silicide Hydrolysis (smaller-scale process)**:
1. Mg₂Si + 4H₂O → SiH₄ + 2Mg(OH)₂
2. Used for smaller-scale, higher-purity silane production
3. Higher cost than trichlorosilane route

### Capacity Expansion Dynamics
Global silane capacity is driven primarily by polysilicon demand for solar panels and semiconductors, not battery applications. SINANODE deployment at scale would create a new demand category:

**Current global silane demand**: ~50,000-60,000 metric tons/year
**SINANODE demand at 100 GWh**: ~5,000-8,000 metric tons/year (10-16% of current market)
**SINANODE demand at 500 GWh**: ~25,000-40,000 metric tons/year (50-80% of current market)

At the upper end, SINANODE-scale demand would require dedicated silane capacity expansion. Lead times for new silane production capacity are 3-5 years, creating a potential bottleneck if SINANODE adoption accelerates faster than silane supply.

## 3. Logistics and Handling

### Transportation
Silane is transported as a compressed gas in:
- **Cylinders** (50-100 kg capacity): Used for pilot and small-scale operations
- **Tube trailers** (5,000-10,000 kg capacity): Used for commercial-scale production
- **ISO containers** (10,000-15,000 kg capacity): Used for intercontinental shipping

Silane is classified as a Division 2.1 flammable gas and a Division 2.3 toxic gas (by inhalation risk from SiO₂ decomposition products) for transportation purposes. Shipping requires:
- UN 2203 hazardous materials placarding
- DOT-specification pressure vessels
- Ventilated transport vehicles
- Route planning avoiding tunnels and population centers where restrictions apply

### On-Site Storage
Battery factory silane storage systems are designed to semiconductor industry standards:
- Outdoor storage with weather protection (NFPA 55 compliant)
- Separation distances from occupied buildings per fire code
- Automatic fire suppression (dry chemical or water deluge, not sprinklers — silane reactions with water are controllable in a deluge scenario)
- Continuous gas detection with automatic isolation

### Supply Chain Resilience
For a 50 GWh/year battery factory, silane consumption is 2,500-4,000 metric tons/year (7-11 tons/day). This requires:
- Multiple tube trailer deliveries per week
- On-site storage of 2-4 weeks' consumption (~50-150 tons)
- Qualification of at least two silane suppliers for supply chain redundancy

## 4. Alternative Silicon Precursors

### Research-Grade Alternatives
While silane is the primary SINANODE precursor, OneD's patent portfolio covers alternative silicon precursors:

| Precursor | Formula | Decomposition Temperature | Advantages | Disadvantages |
|-----------|---------|--------------------------|------------|---------------|
| Disilane | Si₂H₆ | 300-400°C (lower) | Faster growth rate; lower temperature | More expensive; less available |
| Trisilane | Si₃H₈ | 250-350°C (lower) | Liquid at room temperature (easier handling) | Limited commercial production |
| Dichlorosilane | SiH₂Cl₂ | 600-800°C (higher) | Cheaper than silane | Chlorine contamination risk; higher temperature |
| Trichlorosilane | SiHCl₃ | 800-1,000°C (higher) | Cheapest Si precursor | High temperature incompatible with binder; Cl contamination |
| Monosilane (SiH₄) | SiH₄ | 350-500°C | Optimal temperature range; clean decomposition | Pyrophoric; requires gas handling |

For the foreseeable commercial future, silane remains the only practical precursor for SINANODE. Alternative precursors are active areas of research that could reduce cost or improve safety in later technology generations.

## 5. Strategic Supply Chain Recommendations

### For OneD
1. Develop preferred supplier relationships with multiple silane producers (REC Silicon primary, at least one secondary)
2. Provide silane supply chain guidance as part of licensee support package
3. Consider facilitating collective silane procurement for licensees to aggregate demand and secure favorable pricing
4. Invest in silane-to-silicon conversion efficiency improvements to reduce silane consumption per kWh

### For Licensees
1. Qualify silane from at least two geographically diverse suppliers
2. Size on-site storage for supply chain disruption resilience (4+ weeks)
3. Establish tolling or dedicated capacity arrangements with silane producers if annual consumption exceeds 1,000 tons
4. Design silane handling systems with expansion capacity for future SINANODE silicon loading increases
