# Performance Metrics and Technical Validation

## Demonstrator Performance Data

The Port of Leith 250 kW demonstrator generated empirical performance data across over
5,000 charge-discharge cycles. This section presents the key measured performance
parameters and compares them against the design targets for full-scale commercial
systems.

### Round-Trip Efficiency

The demonstrator achieved a measured round-trip efficiency of 78–82% at the point of
common coupling, measured as AC electrical energy discharged divided by AC electrical
energy consumed, integrated over a full charge-discharge cycle.

Loss breakdown:

| Loss Component | Loss Contribution | Comment |
|---------------|-------------------|---------|
| Power electronics (drive) | 7–9% | Typical for four-quadrant MV drives of this rating |
| Motor-generator | 6–8% | Standard industrial AC machine; larger machines improve |
| Mechanical (friction, windage) | 3–5% | Rope bending, drum friction, guide shoe contact |
| Auxiliary loads | 0.5–1% | Control system, cooling fans, brake hydraulics |

At commercial scale (2 MW+), the motor-generator efficiency is expected to improve to
95–97% (versus 92–94% for the 250 kW demonstrator unit) as larger machines operate at
higher efficiency points. The power electronics efficiency is relatively constant with
scale. The overall full-scale efficiency was projected at 80–85%, consistent with the
Imperial College assumptions.

### Response Time

The transition from zero power (standby, brakes engaged) to full rated power output was
measured at 0.8 seconds on average across 200 test events. The sequence involves:

- Brake release: 0.15 seconds (hydraulic pressure build-up to release spring-applied brake)
- Drive enable and synchronisation: 0.25 seconds (inverter synchronises to grid voltage
  and begins to deliver current)
- Ramp to full power: 0.40 seconds (controlled acceleration of the motor-generator under
  closed-loop speed control)

The 0.8-second response time places GraviStore in the "fast frequency response" category
alongside flywheels and BESS, and significantly ahead of open-cycle gas turbines (10–30
seconds), combined-cycle gas turbines (30–60 minutes for a cold start), and pumped hydro
(10–30 seconds from spinning reserve, 60–120 seconds from standstill).

### Cycle Endurance

After 5,000 full-depth charge-discharge cycles, the demonstrator showed:

- No measurable change in wire rope tension characteristics (measured via load cells at
  the equaliser bar)
- No measurable change in round-trip efficiency (within the ±0.5% measurement uncertainty
  of the power analyser)
- No measurable change in weight alignment (laser tracking of weight position within the
  guide rails, showing ±2 mm repeatability, identical to commissioning values)
- Visual inspection of wire ropes showed surface wear consistent with 5,000 bending cycles
  on the drum; no broken wire strands detected in magnetic rope inspection (MRT)
- Brake pad wear: 0.3 mm per 1,000 cycles, projecting a brake pad replacement interval of
  approximately 15,000–20,000 cycles

### Availability

The demonstrator achieved 97.2% availability over the test programme period, with
downtime attributed to:

- Planned maintenance (rope inspection, brake adjustment, lubrication): 2.1%
- Unplanned downtime (control system software updates, sensor recalibration): 0.7%

This availability figure was consistent with Gravitricity's 97% target for commercial
systems and compares favourably with the UK onshore wind fleet average of approximately
97% (though note that wind turbines are exposed to weather, while GraviStore equipment
is housed and underground).

## Technology Readiness Assessment

Using the NASA/DOE Technology Readiness Level (TRL) scale:

| Subsystem | TRL at Liquidation | Evidence |
|-----------|-------------------|---------|
| Hoist and drive system | TRL 9 | Proven in thousands of mine hoist installations; ABB-supplied equipment is commercially mature |
| Weight assembly | TRL 6 | Demonstrated at 25-tonne scale (Port of Leith); 1,200-tonne scale requires engineering scale-up but no fundamental novelty |
| Shaft guide system | TRL 4 | Component testing conducted; full-scale deployment in a mine shaft not demonstrated |
| Control system | TRL 6 | Demonstrated at Port of Leith; grid service modes tested in simulation only |
| Integrated system | TRL 5 | Subsystems validated individually; integrated full-scale demonstration not achieved |

The key gap is the absence of a full-scale integrated demonstration in an actual mine
shaft environment. The TRL 5–6 rating reflects that the core electromechanical
technology is proven (TRL 9 for the hoist) but the system integration, shaft-specific
engineering, and operational validation in a production environment remain incomplete.

## Projected Full-Scale Performance

Based on the demonstrator data and engineering analysis:

| Parameter | Demonstrator (Measured) | Full-Scale (Projected) |
|-----------|------------------------|------------------------|
| Power rating | 250 kW | 1–10 MW |
| Energy capacity | ~250 kWh | 1–25 MWh |
| RTE (AC-AC) | 78–82% | 80–85% |
| Response time (0–100%) | 0.8 s | <1.0 s |
| Design life | 50,000 cycles | 50,000 cycles |
| Availability | 97.2% | >97% |
| Weight mass | 25 tonnes (×2) | 500–5,000 tonnes |
| Travel speed | 0.5 m/s | 0.5–1.0 m/s |
| Shaft depth | 15 m (tower) | 150–1,500 m |
