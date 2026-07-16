# Volt-Link Multi-Charger Coupling Hub — Cost Analysis
## CSMFAB051 (Hybrid Edition) & CSMFAB052 (Pure-CSM Edition)
### Per-Unit Cost Comparison | July 2026
**Category:** Aegis Embark Vehicle Products — EV Charging Infrastructure
**Document Type:** CSMFAB Cost Study V1.0
**Prepared by:** Carrington Storm Motors — Operational Finance Directorate

---

## 1. Product Summary

The Volt-Link Multi-Charger Coupling Hub is a portable power electronics device that aggregates four to five J1772 Level 2 EV charging inputs into a single CCS/CHAdeMO DC fast-charge output. Two editions are defined:

- **CSMFAB051 (Hybrid Edition):** Commercial off-the-shelf components + CSM materials for thermal, EMI, and structural functions
- **CSMFAB052 (Pure-CSM Edition):** All-CSM materials architecture with only J1772/CCS connectors sourced commercially

Both editions are costed at three scales: Prototype (1 unit), Small Batch (10 units), and Production Volume (100+ units). Costs are in 2026 USD.

---

## 2. CSMFAB051 — Bill of Materials (Prototype Qty 1)

| Component Group | Prototype Cost | Volume Cost (100+) | Cost Driver |
|-----------------|---------------|---------------------|-------------|
| **Enclosure & Structure** | $255.90 | $168.00 | Aluminum enclosure, BFRP ribs, fans, filters, gaskets |
| **Input Stage (4 channels)** | $1,365.80 | $892.00 | SiC rectifier boards at $185 each × 4 |
| **DC Bus & Output Stage** | $812.50 | $524.00 | CCS connector at $245 dominates |
| **Control Electronics** | $245.40 | $158.00 | STM32F4 board, custom PCB, LCD, BLE |
| **Wiring & Hardware** | $167.00 | $98.00 | Copper wire, terminals, connectors |
| **CSM Materials (in-house)** | $195.00 | $112.00 | MXene spray, BFRP ribs, pyrolytic graphite |
| **J1772 Extension Cables** | $756.00 | $512.00 | 4 × 25ft cables at $189 each |
| **TOTAL (with cables)** | **$3,797.60** | **$2,464.00** | |
| **TOTAL (hub only)** | **$3,041.60** | **$1,952.00** | |

---

## 3. CSMFAB051 — Labor, Process & Overhead

| Cost Element | Prototype (1 unit) | Small Batch (10) | Production Volume (100+) |
|-------------|---------------------|-------------------|--------------------------|
| Mechanical Assembly | 4.0 hrs @ $45/hr = $180 | 2.5 hrs @ $45/hr = $112.50 | 1.5 hrs @ $35/hr = $52.50 |
| Electrical Assembly | 3.0 hrs @ $55/hr = $165 | 2.0 hrs @ $55/hr = $110 | 1.0 hrs @ $45/hr = $45 |
| PCB Fabrication (outsourced) | $42 (5 pcs JLCPCB) | $18 (50 pcs) | $8 (500 pcs) |
| Testing & Commissioning | 3.0 hrs @ $55/hr = $165 | 2.0 hrs @ $55/hr = $110 | 1.0 hrs @ $45/hr = $45 |
| Quality Inspection | 1.0 hrs @ $40/hr = $40 | 0.5 hrs @ $40/hr = $20 | 0.3 hrs @ $35/hr = $10.50 |
| MXene Spray Application | 1.0 hrs @ $40/hr = $40 | 0.5 hrs @ $40/hr = $20 | 0.3 hrs @ $35/hr = $10.50 |
| Documentation & Serialization | 0.5 hrs @ $35/hr = $17.50 | 0.3 hrs @ $35/hr = $10.50 | 0.2 hrs @ $30/hr = $6 |
| **Total Labor per Unit** | **$649.50** | **$401.00** | **$177.50** |

---

## 4. CSMFAB051 — Per-Unit Cost Summary

| Scale | COGS (Hub) | COGS (w/ Cables) | Labor | Total COGS | MSRP Suggested | Gross Margin |
|-------|-----------|-------------------|-------|------------|----------------|--------------|
| Prototype (1) | $3,041.60 | $3,797.60 | $649.50 | $4,447.10 | N/A (prototype) | N/A |
| Small Batch (10) | $2,420.00 | $3,176.00 | $401.00 | $3,577.00 | $5,995 | 40.3% |
| Volume (100+) | $1,952.00 | $2,464.00 | $177.50 | $2,641.50 | $3,995 | 33.9% |
| Volume (1,000+) | $1,620.00 | $2,080.00 | $125.00 | $2,205.00 | $2,995 | 26.4% |

---

## 5. CSMFAB052 — Bill of Materials (Prototype Qty 1)

| Component Group | Prototype Cost | Volume Cost (100+) | Notes |
|-----------------|---------------|---------------------|-------|
| **CSM Synthesized Materials** | $340.00 | $198.00 | Precursors for all CSM materials |
| **BFRP-Elium Enclosure** | $48.00 | $28.00 | Basalt roving + Elium resin |
| **Protonic-HFET Processors** | $62.00 | $24.00 | SPEEK, Pd, Pt, AAO wafer processing |
| **MRF Contactors (5 units)** | $45.00 | $22.00 | Carbonyl iron + silicone oil + BFRP housings |
| **KNN-BT Sensors (8 units)** | $28.00 | $14.00 | Ceramic precursors + sintering |
| **Pyrolytic Graphite Spreader** | $38.00 | $22.00 | Polyimide film + furnace processing |
| **MXene EMI Shielding** | $52.00 | $28.00 | Integrated into BFRP laminate |
| **STF Vibration Mounts** | $18.00 | $10.00 | Silica nanoparticles + PEG |
| **SiC Rectifier Boards (DEV-001)** | $740.00 | $460.00 | Wolfspeed CRD-06600FF065N × 4 |
| **PLC Modem IC (DEV-003)** | $32.00 | $18.00 | Qualcomm QCA7000 |
| **J1772/CCS Connectors** | $476.00 | $342.00 | Only commercial connectors |
| **Copper (wiring, electrodes)** | $42.00 | $28.00 | Commodity material |
| **TOTAL (hub only)** | **$1,921.00** | **$1,194.00** | 37% lower than CSMFAB051 |
| **J1772 Extension Cables** | $756.00 | $512.00 | Same as CSMFAB051 |
| **TOTAL (with cables)** | **$2,677.00** | **$1,706.00** | |

---

## 6. CSMFAB052 — Labor, Process & Overhead

| Cost Element | Prototype (1 unit) | Production Volume (100+) | Notes |
|-------------|---------------------|--------------------------|-------|
| Materials Synthesis (all CSM) | 40.0 hrs @ $45/hr = $1,800 | 1.5 hrs @ $45/hr = $67.50 | Dramatic reduction at scale |
| BFRP Filament Winding | 8.0 hrs @ $45/hr = $360 | 0.6 hrs @ $45/hr = $27 | Mandrel setup amortized |
| Protonic-HFET Clean Room Fab | 24.0 hrs @ $65/hr = $1,560 | 0.4 hrs @ $65/hr = $26 | Mask costs amortized over 500+ dice |
| MRF Contactor Assembly | 6.0 hrs @ $45/hr = $270 | 0.5 hrs @ $45/hr = $22.50 | |
| System Assembly | 5.0 hrs @ $45/hr = $225 | 1.5 hrs @ $35/hr = $52.50 | |
| Testing & Commissioning | 4.0 hrs @ $55/hr = $220 | 1.0 hrs @ $45/hr = $45 | |
| Quality & Documentation | 2.0 hrs @ $40/hr = $80 | 0.5 hrs @ $35/hr = $17.50 | |
| **Total Labor per Unit** | **$4,515.00** | **$258.00** | |

*Note: Prototype labor is extreme due to materials synthesis from scratch. At volume, synthesis is batch-processed across hundreds of units.*

---

## 7. CSMFAB052 — Per-Unit Cost Summary

| Scale | COGS (Hub) | COGS (w/ Cables) | Labor | Total COGS | MSRP Suggested | Gross Margin |
|-------|-----------|-------------------|-------|------------|----------------|--------------|
| Prototype (1) | $1,921.00 | $2,677.00 | $4,515.00 | $7,192.00 | N/A | N/A |
| Small Batch (10) | $1,520.00 | $2,276.00 | $1,240.00 | $3,516.00 | $5,995 | 41.4% |
| Volume (100+) | $1,194.00 | $1,706.00 | $258.00 | $1,964.00 | $3,495 | 43.8% |
| Volume (1,000+) | $890.00 | $1,350.00 | $155.00 | $1,505.00 | $2,495 | 39.7% |

---

## 8. Cost Comparison: CSMFAB051 vs CSMFAB052

| Scale | CSMFAB051 COGS | CSMFAB052 COGS | Delta | Winner |
|-------|---------------|---------------|-------|--------|
| Prototype | $4,447 | $7,192 | +61.7% | CSMFAB051 |
| Volume (100+) | $2,642 | $1,964 | -25.6% | CSMFAB052 |
| Volume (1,000+) | $2,205 | $1,505 | -31.7% | CSMFAB052 |

**Key Insight:** CSMFAB052 is dramatically cheaper at scale due to elimination of expensive COTS components (SiC boards, STM32, contactors, capacitors), but has a MUCH higher barrier to entry due to materials synthesis labor. The crossover point is approximately 25 units — below this, CSMFAB051 is cheaper to produce; above this, CSMFAB052 becomes cheaper.

---

## 9. Key Cost Drivers

| Driver | CSMFAB051 | CSMFAB052 | Mitigation |
|--------|-----------|-----------|------------|
| SiC MOSFET Boards | $740 (24% of hub cost) | $740 (38% — shared via DEV-001) | Custom SiC PCB eliminates eval board markup at volume; eventually replaced by protonic power switches |
| CCS Connector | $245 (8%) | $245 (13%) | Volume pricing from Phoenix Contact; second-source from Amphenol |
| J1772 Extension Cables | $756 (17% of total) | $756 (28% of total) | Wholesale custom cable manufacturing; push for standardized extension cable market |
| Protonic-HFET Fab (CSMFAB052) | N/A | $1,560 (prototype labor) | Amortized mask and wafer costs over 500+ units; eventual dedicated protonic foundry |
| MXene Synthesis | $45 (spray) | $52 (integrated into BFRP) | Scale MXene production; currently lab-scale, target industrial-scale by 2028 |

---

## 10. Break-Even Analysis — CSMFAB052 Investment Recovery

The CSMFAB052 prototype requires approximately $7,192 in total costs (materials + labor). With a suggested volume MSRP of $3,495 and COGS of $1,964, the gross margin per unit is $1,531 (43.8%). 

**Investment recovery at volume production:**
- Initial setup costs (masks, mandrels, clean room certification): $45,000
- Units needed to recover setup: $45,000 / $1,531 = 30 units
- At 100 units/year production rate: recovery in 3.6 months

---

## 11. Five-Year Cost Projection (Both Editions)

| Year | CSMFAB051 Volume | CSMFAB051 Unit COGS | CSMFAB052 Volume | CSMFAB052 Unit COGS |
|------|-----------------|---------------------|-----------------|---------------------|
| 2026 (H2) | 25 | $2,950 | 5 (prototype) | $7,192 |
| 2027 | 250 | $2,420 | 50 | $3,200 |
| 2028 | 500 | $2,100 | 200 | $2,400 |
| 2029 | 750 | $1,950 | 500 | $1,750 |
| 2030 | 500 | $1,850 | 2,000 | $1,350 |

*Projection assumes: CSMFAB051 dominates early market, CSMFAB052 overtakes as protonic technology matures and MXene production scales. CSMFAB051 volume declines after 2029 as CSMFAB052 becomes the primary product. MXene price drops from $2,000/kg to $400/kg by 2030 per CSMFAB Master Cost Analysis projections.*

---

## 12. Phoenix Protocol Recovery Value

| Edition | Unit Recovery Value | Percentage of COGS Recovered |
|---------|---------------------|------------------------------|
| CSMFAB051 | $42.75 | 1.6% of volume COGS |
| CSMFAB052 | $58.25 | 3.7% of volume COGS |

CSMFAB052 has higher recovery value due to precious metal content in protonic electrodes (Pd, Pt). Both recovery values are low relative to COGS, consistent with electronics products.

---

*CSMFAB Volt-Link Cost Analysis V1.0 — Carrington Storm Motors*
*"The numbers are ready. The rest is up to you." — Zirconia*
*Document Control: CSM-COST-FAB-051-052-V1.0 | July 2026*
