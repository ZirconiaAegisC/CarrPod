# Levelised Cost of Energy Storage Comparison

## Analytical Framework

This analysis extends the Imperial College London 2018 study by incorporating updated
(2024) cost assumptions for battery storage and by presenting the GraviStore economics
across a range of power-to-energy ratios and site conditions. The analysis uses a
consistent discounted cash-flow methodology with an 8% real discount rate, UK grid
charging costs (£45/MWh average wholesale price assumed for charging), and a 25-year
analysis period for all technologies (though GraviStore's asset life extends beyond this).

## Capital Cost Breakdown: GraviStore 2 MW / 15 MWh

| Cost Element | Low Estimate (£) | High Estimate (£) | Notes |
|-------------|------------------|-------------------|-------|
| Shaft rehabilitation | 500,000 | 2,500,000 | Highly site-dependent |
| Weight fabrication | 800,000 | 1,500,000 | Steel + concrete, modular assembly |
| Hoist system (ABB) | 2,000,000 | 3,500,000 | Motor, drive, drum, brakes |
| Wire rope and suspension | 200,000 | 400,000 | 64 mm galvanised, multiple ropes |
| Guide system | 300,000 | 600,000 | Roller guides, support brackets |
| Power conversion (drive) | 600,000 | 1,000,000 | 2 MW four-quadrant drive |
| Grid connection | 500,000 | 2,000,000 | 110 kV connection, transformer, switchgear |
| Civil works | 800,000 | 2,000,000 | Hoist house, foundations, access |
| Engineering and project mgmt | 1,000,000 | 2,000,000 | FEED, detailed design, commissioning |
| Contingency (15%) | 1,005,000 | 2,325,000 | |
| **Total** | **£7,705,000** | **£17,825,000** | |

The wide range reflects the uncertainty in shaft condition. For the Pyhäsalmi project,
the capital cost was estimated at the lower end of this range owing to the good shaft
condition, existing surface infrastructure, and established grid connection.

## LCOS Comparison Matrix

The following table presents LCOS (£/MWh, real 2024) for a range of storage technologies
at different discharge durations. All LCOS values are calculated on a consistent basis
using the same discount rate, charging cost, and analysis period.

| Technology | 1-Hour | 4-Hour | 8-Hour | 24-Hour | Annual Cycles | Degradation |
|-----------|--------|--------|--------|---------|---------------|-------------|
| Lithium-ion BESS | 132 | 158 | — | — | 365 | 2% p.a. capacity fade |
| Lithium-ion BESS (augmented) | 142 | 175 | — | — | 365 | Augmented at Year 12 |
| Vanadium redox flow | — | 148 | 162 | 185 | 365 | Negligible |
| Pumped hydro | — | 75 | 82 | 95 | 300 | Negligible |
| Liquid air (LAES) | — | 132 | 145 | 170 | 300 | Negligible |
| Compressed air (CAES) | — | 110 | 125 | 150 | 300 | Negligible |
| **GraviStore (favourable shaft)** | **—** | **55** | **62** | **80** | **365** | **None** |
| **GraviStore (adverse shaft)** | **—** | **95** | **108** | **140** | **365** | **None** |
| Green hydrogen (electrolyser + CCGT) | — | — | — | 210 | 50 | Negligible |

GraviStore's LCOS advantage is most pronounced at discharge durations of 4–8 hours,
which aligns with the daily peak-shaving and frequency regulation applications that
the technology targets. At durations beyond 12–24 hours, the LCOS increases as the
required weight mass and shaft depth grow, though it remains competitive with
alternative long-duration storage technologies.

## Sensitivity to Key Parameters

A Monte Carlo sensitivity analysis was performed on the GraviStore LCOS model, varying
the following parameters within their credible ranges:

1. Shaft rehabilitation cost (most sensitive): ±40% impact on LCOS. This parameter alone
   can move GraviStore from the lowest-cost storage option to merely competitive with
   pumped hydro. This underscores the critical importance of rigorous site selection.

2. Discount rate: ±25% impact on LCOS for a ±2% change in discount rate. GraviStore's
   capital intensity and long asset life make it more discount-rate-sensitive than BESS,
   which has a lower capital cost but shorter life.

3. Round-trip efficiency: ±12% impact on LCOS for a ±5% change in efficiency. The base
   case assumes 80%; improvements in power electronics or hoist drive efficiency could
   yield material cost reductions.

4. Weight fabrication cost: ±10% impact on LCOS. Weight fabrication is a relatively
   small component of total capital cost, and the use of high-density concrete (which
   is inexpensive) as ballast limits the sensitivity to steel prices.

5. Wire rope replacement interval: ±5% impact on LCOS, assuming replacement every 15–20
   years. Rope replacement is a modest operating cost relative to the capital
   expenditure.

## Comparison with Ancillary Service Revenue

The LCOS comparison above is based on energy arbitrage revenue only. In practice,
GraviStore's sub-second response time enables participation in frequency response
markets that provide additional revenue streams not captured by the LCOS metric:

- Dynamic Containment (UK): The National Grid ESO's post-fault frequency response
  product, which has historically cleared at £10–£25/MW/hour, providing approximately
  £80,000–£200,000 per annum of additional revenue for a 2 MW system.

- Fast Frequency Response (FFR): GraviStore's ability to deliver full power in under
  one second qualifies it for the fastest FFR service categories, which command a
  premium over slower-responding assets.

- Reactive power and voltage support: The four-quadrant drive can provide reactive
  power independently of real power, generating additional revenue or reducing grid
  connection charges through voltage support services.

Including ancillary service revenues in the analysis can reduce the net LCOS by
approximately 10–25%, further improving GraviStore's competitiveness relative to
technologies with slower response times or limited ancillary service capability.
