# Verdagy — Green Hydrogen Cost Economics

## The Levelized Cost of Hydrogen Framework

The levelized cost of hydrogen provides a standardized metric for comparing production
costs across technologies, locations, and time periods. It accounts for all costs
incurred over the system's lifetime — capital, operations, energy, and financing —
expressed per kilogram of hydrogen produced. The framework for electrolytic hydrogen:

```
LCOH = (CAPEX × CRF + Fixed O&M) / (CF × 8760 × η × 39.4) + (Electricity Price × η⁻¹ × 39.4⁻¹)
```

where CAPEX is the installed capital cost per kW, CRF is the capital recovery factor
based on the cost of capital and system lifetime, CF is the capacity factor (utilization
rate), and η is the system efficiency (kWh per kg of hydrogen).

## Capital Cost Advantage

Verdagy claims an **80% lower capital cost** compared to PEM electrolysis systems at
equivalent scale. This claim is rooted in the materials cost differential:

| Cost Element | PEM Electrolysis | Verdagy Alkaline | Savings |
|-------------|-----------------|------------------|---------|
| Catalyst (anode) | Iridium: ~$15,000/kg | Nickel: ~$20/kg | >99% |
| Catalyst (cathode) | Platinum: ~$30,000/kg | Nickel: ~$20/kg | >99% |
| Membrane | PFSA: ~$500/m² | Polymer diaphragm: ~$50/m² | ~90% |
| Bipolar plates | Titanium: ~$150/kg | Stainless steel: ~$5/kg | ~97% |
| Cell frame | Specialty alloys | Stainless steel / polymer | ~80% |

The cumulative effect of these material substitutions, combined with the 3 m² cell
format that reduces component count, drives the claimed capital cost advantage.

## Electricity Cost Sensitivity

Electricity is the dominant operating cost for any electrolytic hydrogen production
system, typically accounting for 60-80% of the levelized cost. The sensitivity is
approximately linear: each $10/MWh reduction in electricity price reduces the
LCOH by roughly $0.50/kg. This makes co-location with low-cost renewable electricity
— such as West Texas wind or solar — the single most important project siting
consideration.

## The $2/kg Target

The U.S. Department of Energy's **Hydrogen Shot** initiative established $1 per
kilogram of clean hydrogen within one decade (the "1 1 1" goal — $1/kg by 2031).
Verdagy targets $2/kg as an achievable near-term milestone that makes green hydrogen
competitive with gray hydrogen (produced from natural gas via steam methane reforming)
in many markets:

| Parameter | Value to achieve $2/kg |
|-----------|----------------------|
| Installed CAPEX | <$500/kW |
| Electricity price | <$30/MWh |
| Capacity factor | >90% (dedicated renewables or grid hybrid) |
| System efficiency | >55 kWh/kg (HHV) |
| Stack lifetime | >80,000 hours |

## Production Tax Credit Impact

The Inflation Reduction Act's Section 45V Clean Hydrogen Production Tax Credit
provides up to $3.00/kg for hydrogen produced with near-zero lifecycle greenhouse
gas emissions. When combined with Verdagy's target production costs, the credit
creates the potential for delivered hydrogen costs well below gray hydrogen
benchmarks, even before accounting for renewable energy credits or state-level
incentives.

## Cost Reduction Roadmap

| Phase | Installed CAPEX ($/kW) | LCOH ($/kg) | Driver |
|-------|----------------------|-------------|--------|
| Pilot (2024) | ~$800-1,000 | ~$3.50-4.00 | Initial production, low volume |
| Early commercial (2026) | ~$500-700 | ~$2.50-3.00 | Manufacturing learning, supply chain scale |
| Volume production (2028) | ~$350-500 | ~$2.00-2.50 | Automated factory, >1 GW/year capacity |
| Mature scale (2030+) | ~$200-300 | ~$1.50-2.00 | >5 GW/year capacity, optimized design |