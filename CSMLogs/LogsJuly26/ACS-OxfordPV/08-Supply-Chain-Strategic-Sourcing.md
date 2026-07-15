# 08 — SUPPLY CHAIN, RAW MATERIALS & STRATEGIC SOURCING

## Material Bill of Materials (BOM)

The Oxford PV tandem module integrates materials from multiple global supply chains, combining established silicon photovoltaic commodities with specialized perovskite-specific materials. The following bill of materials represents the Gen 3 product platform as manufactured in Q2 2025:

| Material | Quantity per Module | Unit | Sourcing Region | Supplier Count |
|----------|-------------------|------|-----------------|----------------|
| Silicon cells (HJT/TOPCon, M6 format) | 72 | cells | Asia (China, Malaysia, S. Korea) | 3 qualified |
| Front glass (low-iron tempered, ARC) | 1 | sheet (2.0 mm) | Europe, Southeast Asia | 3 qualified |
| Rear glass (low-iron tempered) | 1 | sheet (2.0 mm) | Europe, Southeast Asia | 3 qualified |
| Lead iodide (PbI₂, 99.999% purity) | 12.5 | g | Europe, China | 2 qualified |
| Lead bromide (PbBr₂, 99.999% purity) | 2.8 | g | Europe, China | 2 qualified |
| Formamidinium iodide (FAI, 99.9% purity) | 5.2 | g | Europe | 2 qualified |
| Methylammonium bromide (MABr, 99.9% purity) | 1.1 | g | Europe | 1 qualified |
| Cesium iodide (CsI, 99.999% purity) | 0.9 | g | Europe | 2 qualified |
| DMF and DMSO solvents (anhydrous) | 85 | mL | Europe, China | 3 qualified |
| TCO sputtering targets (ITO, 4N purity) | 0.3 | kg | Japan, Germany | 2 qualified |
| Encapsulant (TPO, UV-stabilized) | 2.8 | m² | Europe, US | 2 qualified |
| Edge seal (butyl rubber/PIB) | 48 | m (linear) | Europe, Japan | 2 qualified |
| Junction box (bypass diode, IP68) | 1 | unit | China, Europe | 3 qualified |
| Module frame (aluminum, anodized) | 1 | set | Europe, Turkey | 3 qualified |
| Silver paste (front contacts, if not HJT) | 0.8 | g | Japan, US, China | 3 qualified |
| Flux (no-clean, for stringing) | 12 | mL | Europe | 2 qualified |
| Interconnect ribbon (SnPbAg-coated Cu) | 90 | m | China, Europe | 3 qualified |

## Critical Material Risk Assessment

### Lead Compounds

Lead-based perovskite precursors represent the most significant supply chain risk due to the combination of tight purity specifications (99.999% metals basis) and the strategic sensitivity of lead supply chains, which are dominated by Chinese smelting capacity. Oxford PV's lead precursor consumption at 100 MW production scale is approximately 3.5 tonnes per year of lead iodide and 0.8 tonnes per year of lead bromide. At 600 MW scale, this rises to approximately 21 tonnes and 4.8 tonnes respectively — still negligible relative to global lead production (approximately 12 million tonnes per year), but requiring secure, long-term supply agreements with qualified high-purity chemical suppliers.

Oxford PV maintains a six-month forward inventory of lead-based precursors as a buffer against supply disruption, stored in a dedicated, climate-controlled chemical warehouse at the Brandenburg site.

### Indium (ITO Targets)

Indium is classified as a critical raw material by the European Commission due to its geopolitical supply concentration (China produces approximately 60% of primary indium) and its essential role in transparent conductive oxides. Oxford PV's ITO consumption at 100 MW is approximately 3.5 tonnes per year. The company's TCO research program includes qualification of indium-reduced and indium-free alternatives (aluminum-doped zinc oxide, hydrogen-doped indium oxide with lower indium loading) as risk mitigation.

### Organic Precursor Chemicals

Formamidinium iodide (FAI) and methylammonium bromide (MABr) are not commodity chemicals and have limited industrial-scale production capacity. Oxford PV has developed in-house synthesis capability for these precursors as a strategic hedge, with small-scale production at the Oxford R&D center providing technical capability and cost benchmarking against external suppliers. For high-volume production, the company has established toll-manufacturing agreements with European fine chemical producers under confidentiality agreements that protect the proprietary precursor specifications.

## Silicon Cell Supply Strategy

The silicon bottom cell constitutes the single largest material cost in the tandem module BOM, accounting for approximately 45–55% of total material cost. Oxford PV's strategy is to maintain a multi-supplier, technology-agnostic approach:

**Technology Compatibility**: Both HJT and TOPCon silicon cells are qualified for tandem integration. HJT cells provide a small efficiency advantage (approximately 0.3–0.5 percentage points at the module level) due to superior surface passivation and higher V_oc of the silicon sub-cell. TOPCon cells offer a lower cost base and more established high-volume manufacturing ecosystem.

**Supplier Qualification**: Three tier-1 cell manufacturers have achieved qualified supplier status. Two additional suppliers are in the qualification pipeline. Supply agreements are structured as multi-year frame contracts with quarterly price adjustments indexed to polysilicon and wafer market prices.

**Geographic Diversification**: Oxford PV maintains qualified suppliers in China, Malaysia, and South Korea, providing geographic diversification against trade policy disruptions. The European silicon cell manufacturing ecosystem, which has contracted significantly, remains a long-term strategic interest but does not currently provide competitive supply at the required scale.

## Logistics and Warehousing

**Inbound Logistics**: Perovskite precursors are shipped by air freight in UN-certified packaging (Class 9 miscellaneous dangerous goods for lead compounds, Class 3 flammable liquid for solvents) from supplier facilities to Berlin Brandenburg Airport (BER), with final delivery by temperature-controlled road transport. Silicon cells are shipped by sea freight in nitrogen-purged, humidity-controlled containers, with a typical lead time of 6–8 weeks from Asian suppliers.

**On-Site Warehousing**: The Brandenburg facility maintains a 3,000 m² warehouse operating under controlled conditions (21 ± 3°C, <60% RH). Inventory is managed through an ERP system with automated reorder point calculation based on production scheduling and supplier lead times.

**Outbound Logistics**: Finished modules are palletized (26–30 modules per pallet, depending on frame design) and shipped by road transport to European customers. For non-European destinations, modules are containerized at the Hamburg or Bremerhaven ports for sea freight, or shipped by air freight for time-critical deliveries.

## Cost Structure Analysis

At 100 MW scale and 85% module yield, the estimated cost structure (EUR per watt, DC) is:

| Cost Category | EUR/W (DC) | % of Total |
|--------------|-----------|------------|
| Silicon cells | 0.14–0.16 | 45–50% |
| Perovskite materials (precursors, solvents) | 0.02–0.03 | 6–9% |
| TCO and metallization | 0.03–0.04 | 10–12% |
| Glass (front + rear) | 0.03–0.04 | 10–12% |
| Encapsulant and edge seal | 0.02–0.03 | 6–9% |
| Other BOM (frame, J-Box, ribbon, flux) | 0.03–0.04 | 10–12% |
| Direct labor | 0.03–0.04 | 10–12% |
| Manufacturing overhead | 0.02–0.03 | 6–9% |
| **Total Manufacturing Cost** | **0.32–0.41** | **100%** |

At projected 600 MW scale with 92% yield, the total manufacturing cost is expected to decline to EUR 0.24–0.30/W through silicon cell cost reduction (volume pricing), improved perovskite materials utilization (reduced solvent waste), lower per-unit capital depreciation, and improved labor productivity. At this cost level, Oxford PV tandem modules are projected to be cost-competitive with premium monofacial PERC modules on a levelized cost of electricity (LCOE) basis, with the LCOE advantage driven by the 20% higher energy yield per watt of installed capacity.

## References

- European Commission. "Study on the EU's list of Critical Raw Materials." 2023 Final Report.
- Oxford PV. "Supply Chain Risk Assessment: 2025 Annual Review." Internal Document.
- Wood Mackenzie. "Solar PV Module Technology Market Report." Q1 2025.
- U.S. Geological Survey. "Mineral Commodity Summaries: Indium." January 2025.
