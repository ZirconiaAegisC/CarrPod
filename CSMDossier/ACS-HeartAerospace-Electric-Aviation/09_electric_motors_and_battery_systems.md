# Electric Motors & Battery Systems

## Wing-Mounted Electric Motors

The ES-30 is propelled by four electric motors distributed along the
wing leading edge. Each motor drives a variable-pitch, four-blade propeller
designed for low tip speed to minimize noise. The motors are of the
permanent-magnet synchronous type, chosen for their high power density,
high efficiency across a wide operating range, and reliability in
aerospace applications.

### Motor Specifications

Heart Aerospace has not publicly disclosed the exact motor supplier, but
the performance parameters can be inferred from the ES-30's mission
requirements:

- **Continuous power rating:** Estimated 250–350 kilowatts per motor
  (approximately 335–470 shaft horsepower).
- **Peak power for takeoff:** Approximately 400–500 kilowatts per motor
  for the 90-second takeoff power interval.
- **Total installed propulsion power:** Approximately 1.0–1.4 megawatts
  continuous; 1.6–2.0 megawatts peak.
- **Motor efficiency:** Greater than 95% at cruise power settings.
- **Cooling:** Liquid-cooled stator with air-cooled rotor. Coolant is
  circulated through a heat exchanger in the wing leading edge or in
  an under-fuselage radiator.

Each motor is paired with a silicon-carbide (SiC) inverter converting DC
bus power to variable-frequency AC. Silicon carbide enables higher switching
frequencies, lower losses, and higher operating temperature than silicon
IGBTs. The propeller is directly mounted to the motor output shaft without
a reduction gearbox—electric motors produce maximum torque from zero RPM,
eliminating gearbox weight and complexity.

## Battery Energy Storage System

The battery system is the ES-30's most critical subsystem. It must deliver
high power for takeoff, sustain up to 200-kilometer all-electric cruise,
charge in 30 minutes for turnaround, and maintain safety under all conditions.

### Cell Chemistry and Pack Architecture

Heart Aerospace uses aviation-optimized lithium-ion cells with high specific
energy, 2C–3C discharge capability for takeoff, and certified thermal
stability. The modular pack comprises 10–20 modules at 600–800 VDC nominal,
totaling 800–1,200 kWh capacity with 80–90% usable for 200-kilometer
all-electric range plus reserves. Modules are distributed in the belly
fairing and wing spar box.

### Battery Management System

The BMS performs per-cell voltage, temperature, and internal-resistance
monitoring, state-of-charge estimation, state-of-health tracking, cell
balancing during charging, and active thermal management. Any cell exceeding
limits triggers immediate module isolation and a cockpit alert.

### Thermal Management and Safety

Liquid glycol-water cooling circulates through cold plates between cell
layers, rejecting heat through wing-edge radiators. During winter charging,
the system pre-heats cold-soaked batteries. Safety features include cell-level
fusing and venting, module-level fire barriers with exterior gas vents,
redundant millisecond-contactors for fault isolation, and a gaseous
battery-fire suppression system. Battery certification flight-test hours
may equal or exceed airframe certification hours given EASA/FAA scrutiny.
