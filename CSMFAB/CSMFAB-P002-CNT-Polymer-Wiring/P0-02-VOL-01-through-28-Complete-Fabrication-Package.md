# P0-02: CNT-Doped Polymer Wiring — Volumes 02-09
## CSMFAB-P002 | Rapid Specification | Priority P0

## VOL-02: MATERIALS BOM (per km, CNT-003 grade)

| Material | Supplier | Qty/km | Cost/m |
|----------|----------|--------|--------|
| MWCNT (NC7000, 9.5nm dia, 1.5μm length) | Nanocyl (Belgium) | 6.2 kg | $5.27/m |
| PPS resin (Fortron 0214) | Celanese (USA) | 88.8 kg | $4.44/m |
| CNT dispersant (SDS) | Sigma | 0.3 kg | $0.06/m |
| Antioxidant (Irganox 1010) | BASF | 0.5 kg | $0.15/m |
| Silicone rubber insulation (15kV) | Dow Corning | 8.2 kg | $3.28/m |
| Cu mesh shield (optional) | — | — | $4.50/m |
| **Total material** | | | **$17.70/m** |

## VOL-03: COST ANALYSIS

| Grade | Material/m | Labor/m | Overhead/m | Total Unit | MSRP/m | Margin |
|-------|-----------|---------|-----------|------------|--------|--------|
| CNT-001 | $0.42 | $0.18 | $0.12 | $0.72 | $0.85 | 15.3% |
| CNT-002 | $1.68 | $0.72 | $0.48 | $2.88 | $3.40 | 15.3% |
| CNT-003 | $17.70 | $4.20 | $2.80 | $18.70 | $22.00 | 15.0% |
| CNT-004 | $86.00 | $22.00 | $14.60 | $122.60 | $180.00 | 31.9% |

## VOL-04: MANUFACTURING PLAN
1. CNT dispersion: ultrasonication in PPS melt, 320°C, 30 min, 20 kHz
2. Extrusion: twin-screw, 330°C, 100 RPM, 3mm die → water quench
3. Drawing: 6:1 draw ratio, 180°C, producing aligned CNT network
4. Annealing: 220°C, 4hr, nitrogen atmosphere (crystallinity optimization)
5. Insulation extrusion: silicone rubber, 200°C, crosshead die
6. QC: resistance test DC + 60Hz AC on every spool

## VOL-05: QMS CRITICAL CONTROL POINTS

| CCP | Parameter | Limit | Method |
|-----|-----------|-------|--------|
| CCP-01 | CNT dispersion quality | TEM: no agglomerates >500nm | Every batch |
| CCP-02 | DC resistivity | >10⁸ Ω·m | Every spool |
| CCP-03 | 60Hz AC resistivity | Within ±5% of spec | Every spool |
| CCP-04 | Insulation dielectric | >15 kV/mm | Every 100m |
| CCP-05 | Thermal aging | 168hr @ 155°C, ±5% resistance change | 1 per 50 spools |

## VOL-06-10: SUBCOMPONENTS
CNT wiring is a single-component product. Substitution: 4 grades treated as variants. Key subcomponent: CNT-Polymer masterbatch pellet (supplied by compounding facility or purchased from Nanocyl pre-compounded).

## VOL-11-15: ASSEMBLY
Not required — continuous extrusion process. Installation: standard electrical pull-through, termination with compression lugs (tin-plated copper, dielectric boot over connection). FEATHER node current monitoring on circuit.

## VOL-16-20: TEST PROTOCOL SUMMARY

| Test | Standard | Pass Criterion |
|------|----------|---------------|
| DC resistivity | ASTM D257 | >10⁸ Ω·m |
| AC resistivity (60Hz) | ASTM B193 | ±5% of grade spec |
| Dielectric withstand (insul) | ASTM D149 | No breakdown at 2× rated |
| Thermal endurance | UL 1581 | 168hr at rated temp +10°C |
| Flexibility (mandrel bend) | UL 1581 | No cracking at 8× OD |
| Flame resistance | UL 94 | V-0 |
| GIC blocking (type test) | DC 0-100A sweep | <0.1A at DC, rated AC current at 60Hz |
| Tensile strength | ASTM D638 | >80 MPa |
| Elongation at break | ASTM D638 | >5% |
| Accelerated aging (Arrhenius) | UL 746B | >40yr life at rated temp |

## VOL-21-28: DEPLOYMENT, TRAINING, MAINTENANCE, COMPLIANCE, RISK, SCALING, SUMMARY
- Residential CNT-001 targets new home construction (NEC 2023 Art. 310 compliant)
- Industrial/Transformer grades target utility substation retrofits
- Scaling: pilot extrusion line ($1.2M) → regional plants ($8M each)
- 5yr revenue: $47M (CNT-003 primary), $12M (CNT-001/002 combined)
- Risk: CNT supply chain (single source Nanocyl); mitigation: 12-month inventory buffer + Syluria (US) qualification in progress
