# e-Zinc — Long-Duration Energy Storage (12-100+ Hours)

## The Duration Spectrum

Energy storage technologies can be categorized by their characteristic discharge
duration — the length of time they can deliver rated power before depletion:

| Duration Category | Typical Range | Primary Technologies | Primary Applications |
|------------------|---------------|---------------------|---------------------|
| Short duration | <1 hour | Flywheels, supercapacitors | Frequency regulation, power quality |
| Medium duration | 1-4 hours | Lithium-ion batteries | Peak shaving, ancillary services |
| Long duration (LDES) | 4-12 hours | Lithium-ion (large), some flow batteries | Solar shifting, resource adequacy |
| Multi-day / seasonal | 12-100+ hours | Zinc-air, iron-air, flow batteries | Multi-day renewables gaps, resilience |
| Seasonal | 100+ hours | Hydrogen, pumped hydro | Seasonal energy shifting |

e-Zinc targets the multi-day long-duration segment — specifically 12 to 100+
hours of discharge at rated power. This segment is fundamentally distinct from
the 2-4 hour duration that lithium-ion batteries serve economically.

## Why Duration Matters for Grid Decarbonization

Grid modeling consistently demonstrates that achieving very high renewable
electricity penetration (80-100%) requires storage with discharge durations
well beyond the 4-hour capability of lithium-ion batteries. The specific
challenges that long-duration storage addresses include:

1. **Multi-day renewable lulls** — periods of low wind and solar generation
   lasting 2-5 days, driven by weather patterns. In a high-renewables grid,
   bridging these lulls requires storage that can discharge for 48-120 hours.

2. **Seasonal demand patterns** — winter heating demand and summer cooling
   demand create seasonal electricity consumption peaks that don't align
   with renewable generation profiles.

3. **Transmission deferral** — in constrained transmission corridors, long-
   duration storage can absorb excess generation during high-output periods
   and discharge during peak demand, reducing the need for new transmission
   capacity.

4. **Resilience** — extended backup power for critical infrastructure during
   grid outages, particularly in regions prone to extreme weather events.

## Energy Capacity vs. Power Capacity Decoupling

A key economic feature of zinc-air batteries — shared with flow batteries and
other "energy-centric" storage technologies — is the ability to independently
scale power capacity (MW) and energy capacity (MWh):

- **Power capacity** is determined by the electrode area — the total surface
  area available for electrochemical reactions, which scales with the number
  and size of cells
- **Energy capacity** is determined by the zinc inventory — the total mass of
  zinc metal available for oxidation, which scales with the size of the zinc
  storage reservoir

This decoupling means that a system designed for 100 hours of storage (100 MWh
of energy per MW of power) has fundamentally different cost characteristics
than a 4-hour lithium-ion system: the incremental cost of adding an additional
hour of storage duration is proportional to the cost of the additional zinc
and electrolyte, not the cost of additional cells and power electronics.

## Duration Economics

| Storage Duration | Li-ion Cost ($/kWh) | e-Zinc Target ($/kWh) | Cost Ratio |
|-----------------|--------------------|-----------------------|-----------|
| 4 hours | ~$300-400 | ~$250-350 | 1.1-1.3x |
| 12 hours | ~$300-400 | ~$125-175 | 2.0-2.5x |
| 24 hours | ~$300-400 | ~$100-150 | 2.5-3.5x |
| 100 hours | ~$300-400 | ~$70-100 | 3.5-5.0x |

The lithium-ion cost per kWh is approximately constant across durations because
the cell cost dominates; the e-Zinc cost per kWh decreases with duration because
the energy capacity cost (zinc, electrolyte) is much lower than the power
capacity cost (cells, power electronics). This creates a crossover duration
beyond which zinc-air is decisively cheaper than lithium-ion for energy-capacity-
driven applications.

## Target Applications

| Application | Required Duration | Value Proposition |
|------------|------------------|-------------------|
| Solar firming | 12-16 hours | Shift midday solar to evening/night demand |
| Wind balancing | 24-48 hours | Buffer multi-day wind variability |
| Resource adequacy | 24-100 hours | Replace peaking gas plants for reliability |
| Microgrid resilience | 24-72 hours | Multi-day backup for critical facilities |
| Industrial load shifting | 8-16 hours | Align electricity consumption with low-cost periods |
| Transmission-constrained areas | 12-48 hours | Defer or avoid transmission upgrades |