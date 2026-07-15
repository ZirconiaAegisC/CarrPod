# ACS Group14 | Porsche Partnership & Taycan Integration

## 1. Porsche-Group14 Relationship

### Partnership Origin and Evolution
Porsche AG's relationship with Group14 has evolved from early-stage investor to strategic development partner:

| Timeline | Milestone |
|----------|-----------|
| 2021 | Porsche Ventures participates in Group14 Series C funding round |
| 2022 | Porsche leads Group14's $400M Series E round; Cellforce Group established |
| 2023 | SCC55 cells enter Cellforce Group development pipeline for Taycan |
| 2024 | SCC55-enhanced prototype cells undergo vehicle-level validation |
| 2025-2026 | Expected production qualification of SCC55 cells for Taycan platform |

### Cellforce Group
Cellforce Group GmbH is a joint venture between Porsche AG (majority) and Customcells Holding GmbH, established to develop and produce high-performance lithium-ion battery cells for Porsche's most demanding applications:

- **Location**: Biberach an der Riß, Germany (near Stuttgart/Porsche HQ)
- **Focus**: High-performance cells for motorsport and premium EV applications
- **Annual capacity**: Initially ~100 MWh (small-scale, high-performance production)
- **SCC55 role**: Cellforce is the primary conduit for SCC55 integration into Porsche vehicles
- **Significance**: Vertical integration of cell development allows Porsche to optimize cell design around SCC55's specific characteristics rather than adapting SCC55 to an off-the-shelf cell design

### BASF Partnership
BASF SE, the world's largest chemical company, is a strategic partner in the Porsche-Cellforce ecosystem:
- BASF supplies high-performance NMC cathode materials to Cellforce
- BASF and Group14 have a separate distribution agreement for SCC55 in certain markets
- The BASF-Group14-Cellforce triangle creates a uniquely integrated European battery materials-to-cell value chain
- BASF's cathode expertise enables co-optimization of cathode and anode for Porsche-specific cell designs

## 2. Taycan Platform Requirements

### Current Taycan Battery (J1 Platform)
- **Cell chemistry**: NMC712 + graphite anode
- **Cell format**: Pouch cells from LG Energy Solution
- **Pack energy**: 79.2 kWh (base) / 93.4 kWh (Performance Battery Plus)
- **Voltage architecture**: 800V
- **Peak charging power**: 270 kW (Performance Battery Plus)
- **Energy density at pack level**: ~150-160 Wh/kg

### Target Specifications with SCC55
Porsche's objectives for SCC55-enhanced cells in the next-generation Taycan:

| Parameter | Current (Graphite) | Target (SCC55) | Improvement |
|-----------|-------------------|----------------|-------------|
| Cell energy density | 265 Wh/kg | 330-350 Wh/kg | +25-32% |
| Pack energy | 93.4 kWh | 110-120 kWh (same volume) | +18-28% |
| Range (WLTP) | 484 km | 570-620 km | +18-28% |
| Peak charging power | 270 kW | 320-350 kW | +18-30% |
| 10-80% charge time | 22.5 min | 18-20 min | -10-20% |
| Cycle life | 1,500 cycles | >1,000 cycles target | Meets spec |

### Performance Charging Requirements
Porsche's 800V architecture imposes specific demands on SCC55 cells:
- **Sustained C-rate**: Must accept 3C+ continuous charging (270+ kW / 93.4 kWh = ~2.9C)
- **Thermal management**: Higher energy density means higher volumetric heat generation; cooling system must manage increased thermal load
- **Lithium plating risk**: Fast charging of silicon anodes at high SOC (>70%) risks lithium plating due to silicon's lower lithiation potential vs. graphite; charge protocol optimization is critical
- **Voltage window**: Silicon's sloping voltage profile (vs. graphite's flat plateau) requires BMS recalibration for accurate SOC estimation

## 3. Motorsport Technology Transfer

### Porsche's Racing Heritage
Porsche's approach follows a motorsport-to-production technology transfer model:
1. **Racing application**: SCC55 cells tested in extreme conditions (high C-rate, thermal stress) in motorsport prototypes
2. **Learnings captured**: Degradation mechanisms under extreme conditions inform cell design improvements
3. **Technology cascade**: Proven in racing → adapted for GT cars → refined for volume Taycan production

This model accelerates technology maturation by stress-testing cells under conditions that simulate years of road use in weeks of track use.

### Formula E Perspective
Porsche competes in Formula E with the 99X Electric race car. While Formula E currently uses spec batteries (Williams Advanced Engineering), Porsche's experience with:
- 350 kW regenerative braking
- Thermal management under race conditions
- Energy management strategy optimization

directly informs Taycan battery system design. SCC55 adoption in future Formula E or GT racing programs would provide additional accelerated aging data.

## 4. Beyond Taycan: Porsche's Electric Portfolio

### Macan Electric
- **Launch**: 2024 (PPE platform, shared with Audi Q6 e-tron)
- **Battery**: ~100 kWh pack, 800V architecture
- **SCC55 potential**: Second-generation Macan Electric (post-2028) could adopt SCC55 cells for range and performance improvements

### Cayenne Electric
- **Expected launch**: 2026-2027
- **Platform**: PPE or SSP (Scalable Systems Platform)
- **SCC55 fit**: Cayenne's large platform provides packaging flexibility for higher-density cells; SCC55 enables extended range without battery pack size increase

### 718 Boxster/Cayman Electric
- **Expected launch**: 2025-2026
- **Significance**: Smaller, lighter sports car platform where energy density premium is most valuable (weight savings multiplied through chassis, suspension, and braking systems)
- **SCC55 value proposition**: 50% higher energy density at cell level enables smaller, lighter battery pack while maintaining range — critical for a sports car where driving dynamics are paramount

### Future Hypercar (Mission X successor)
- Purpose-built electric hypercar platform
- SCC55 at maximum silicon content (60+ wt%) for extreme energy density
- Low-volume, high-performance application where material cost is least constraining
- Technology demonstrator for Porsche's battery capabilities

## 5. Competitive Benchmarking: SCC55 vs. Competitor Cells

### Porsche's Cell Options for Taycan
| Cell Type | Anode | Cathode | Cell Energy Density | Source |
|-----------|-------|---------|---------------------|--------|
| Current Taycan | Graphite | NMC712 | 265 Wh/kg | LG Energy Solution |
| SCC55-enhanced | SCC55 (30-50% Si) | NMC811 | 330-350 Wh/kg | Cellforce / Group14 |
| Sila Titan Silicon | Titan Silicon | NMC811 | 320-340 Wh/kg | Mercedes (competitor reference) |
| Amprius Si Nanowire | Si nanowire | NMC811 | 350-400 Wh/kg | Amprius (aviation-focused) |

### Why Porsche Chose Group14 vs. Competitors
Plausible factors in Porsche's supplier selection:
1. **Drop-in compatibility**: SCC55 integrates with Porsche/Cellforce's existing electrode manufacturing process more easily than nanowire or silicon-dominant approaches
2. **Balance of performance**: SCC55's middle-ground position (higher capacity than oxide blends, better cycle life than silicon-dominant) aligns with Porsche's 1,000+ cycle durability requirement
3. **Supply security**: Group14's Moses Lake production provides geographic diversification from Asian supply chains
4. **Investment alignment**: Porsche's significant equity stake in Group14 creates alignment beyond a typical supplier-customer relationship
5. **BASF synergy**: The existing BASF-Cellforce cathode relationship extends naturally to Group14 anode materials through the BASF-Group14 distribution agreement

## 6. Volume and Revenue Implications

### Porsche SCC55 Demand Estimate
| Year | Taycan Production | SCC55 per Vehicle | Annual SCC55 Demand |
|------|------------------|-------------------|---------------------|
| 2025 | 40,000 units | ~80 kg/cell × cells | ~10-20 tons (prototype/qualification) |
| 2027 | 60,000 units | ~80 kg/cell × cells | ~150-300 tons (initial production) |
| 2029 | 80,000 units | ~80 kg/cell × cells | ~400-800 tons (scaled production) |
| 2030+ | 100,000+ (incl. Macan/Cayenne) | varies by model | 1,000-2,000+ tons |

Porsche volumes alone do not justify BAM-2 scale. Porsche is the anchor customer and technology validation platform; the addressable volume across all automotive OEMs is orders of magnitude larger.
