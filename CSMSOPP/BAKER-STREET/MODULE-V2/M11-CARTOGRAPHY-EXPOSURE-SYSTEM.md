# CARTOGRAPHY-EXPOSURE-SYSTEM.md
## CSMSOPP000003-V2-M11 | Geographic and Concentration Risk Mapping

---

## The Exposure Map

For every client portfolio, the Baker Street agent builds a multi-layer exposure map:

### Layer 1: Geographic Concentration
- Property locations plotted by zip code, county
- Values aggregated by geographic unit
- PML calculated by storm track / earthquake zone / GIC corridor

### Layer 2: Line of Business Concentration
- Premium by LOB as % of total portfolio
- Loss ratio by LOB over 5-year trailing
- Reserve adequacy by LOB

### Layer 3: Reinsurance Dependency
- Ceded premium by treaty as % of gross premium
- Reinsurer credit quality mapped to ceded amounts
- Single-reinsurer concentration: any reinsurer >10% of total ceded flagged

### Layer 4: Solar Storm Vulnerability
- GIC-prone corridors mapped (geologic conductivity zones)
- Transformer locations mapped against GIC models
- BI dependency: customers reliant on grid for >48 hours without backup power

### Layer 5: Interdependency Exposure
- Supplier concentration: any single supplier >25% of COGS for key insureds
- Utility dependency: customers served by single substation
- Communication dependency: customers reliant on single tower/carrier

## Flag Thresholds

| Metric | Threshold | Action |
|--------|-----------|--------|
| Geographic concentration | >20% of TIV in single county | Reinsurance review |
| LOB concentration | >40% of premium in single LOB | Diversification recommendation |
| Reinsurer concentration | >25% with single reinsurer | Collateral / rating review |
| GIC vulnerability | >10% of assets in Kp6+ corridor | Hardening recommendation |
| Single-supplier dependency | >30% of COGS | Contingent BI review |

---

*End of M11 — Cartography Exposure System | CSMSOPP000003-V2*
