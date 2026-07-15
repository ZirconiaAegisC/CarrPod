# Weight and Hoist System Design

## Weight Architecture

The GraviStore weight assembly is the core energy-carrying component. At full commercial
scale, each weight comprises a fabricated steel frame filled with high-density concrete
ballast, achieving a total mass between 500 and 5,000 tonnes depending on the shaft
diameter and target power rating.

The modular design allows weights to be assembled underground within the shaft sump or
at the surface and lowered into position. Individual steel sections are bolted together
using high-tensile friction-grip connections, with concrete ballast cast in situ or
pre-cast into interlocking segments.

Weight dimensions are constrained by the available shaft cross-section. A typical UK
coal mine shaft of 6 metres diameter accommodates a cylindrical weight of approximately
5.2 metres diameter, leaving 400 mm radial clearance for guide systems, ventilation, and
emergency access. At a height of 12 metres, such a weight with steel-reinforced concrete
at 4,000 kg/m³ achieves roughly 1,000 tonnes.

## Wire Rope and Suspension

The suspension system employs multiple high-tensile steel wire ropes, each rated to carry
the full suspended load with a statutory safety factor of not less than 5:1 under the UK
Mines Regulations 2014 (as applied to the specific shaft usage category).

Wire rope diameter for a 1,000-tonne suspended load: typically 64–72 mm, using
galvanised right-hand ordinary lay construction with fibre or steel core, depending on
the drum diameter ratio. Rope life is conservatively estimated at 15–20 years under
cyclic loading, after which non-destructive testing and magnetic rope inspection
determine replacement timing.

Tension equalisation across multiple ropes is achieved through a patented pivoting
equaliser bar at the weight attachment point, which distributes load variations arising
from differential rope stretch, drum winding geometry, and thermal expansion.

## Hoist Drum and Drive Train

The hoist drum is a welded steel fabrication with machined grooving (Lebus or parallel
groove pattern) to ensure orderly rope layering. Drum diameter is selected to achieve a
D/d ratio exceeding 80:1 (drum-to-rope diameter), which is industry-standard for
production hoists in mining applications and minimises bending fatigue in the rope.

The drive train consists of:
- A low-speed high-torque synchronous or induction motor directly coupled to the drum
  shaft via a flexible coupling
- A service brake (calliper type acting on a brake disc mounted to the drum flange)
- An emergency brake (fail-safe, spring-applied, hydraulically released) acting
  independently on the drum
- Over-speed and over-travel protection systems with redundant position encoders

For a 10 MW system, the hoist motor is approximately 12,500 hp, operating at 30–60 rpm
drum speed, which corresponds to a weight travel velocity of 0.5–1.5 m/s depending on
the drum diameter and gear ratio (if a gearbox is used between the motor and drum).

## Power Electronics

The motor drive is a four-quadrant voltage-source inverter with active front end,
enabling bidirectional power flow at unity or controlled power factor. During raising
(charging), the drive rectifies grid AC to variable-frequency AC for the motor. During
lowering (discharging), the motor acts as a generator, and the drive inverts the
regenerated power back to the grid.

The active front end provides reactive power capability independent of real power flow,
allowing the system to contribute to voltage support even when not actively charging or
discharging. This is a valuable ancillary service in distribution networks with high
penetration of inverter-based resources.

## Mechanical Wear and Maintenance

Unlike battery storage, the primary wear components in GraviStore are mechanical:
wire ropes, drum linings, guide shoes, and brake pads. All are inspectable,
replaceable, and subject to well-established maintenance regimes drawn from the mining
hoist industry, where similar systems operate for decades with high reliability.

The absence of electrochemical degradation mechanisms eliminates the capacity fade,
internal resistance growth, and thermal management challenges that dominate the BESS
operating cost profile. This is the fundamental economic advantage of gravity storage
over lithium-ion for long-duration, high-cycle applications.
