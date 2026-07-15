# Ampaire Core Technology — Battery Systems and In-Flight Charging

## Battery Cell Technology

Ampaire's battery strategy leverages the rapid advancement and cost reduction
in automotive-grade lithium-ion cells. Rather than developing aviation-specific
cell chemistries — a path that would require billions in investment and a
decade of development — Ampaire adapts automotive cells to aviation
requirements through packaging, thermal management, and safety system design.

### Cell Selection Criteria

Cell selection for aviation applications involves a different optimization
than automotive applications:

- **Energy density**: Critical for aircraft weight. Automotive cells achieving
  250 to 280 Wh/kg at the cell level are preferred. Aviation applications can
  tolerate higher cell cost per kWh because fuel cost savings provide rapid
  payback.
- **Power density**: Required for takeoff boost. Cells must support 3 to 5C
  continuous discharge without excessive voltage sag or heating.
- **Cycle life**: Regional aircraft operating 3 to 6 flights daily accumulate
  charge-discharge cycles rapidly. A 3000-cycle life enables 3 to 5 years of
  operation at 600 to 1000 flight hours annually.
- **Safety**: Cell-level thermal runaway containment is mandatory. Ampaire
  selects cells with demonstrated resistance to propagation — typically
  cylindrical cells with integral current interrupt devices and pressure
  relief vents.

### Cell Format

Ampaire uses cylindrical 21700 and 46800 format cells — the same formats used
in automotive applications — configured in series-parallel arrays within each
battery module. Cylindrical cells offer inherent advantages for aviation:

- **Mechanical robustness**: The cylindrical can provides crush resistance
  superior to pouch cells
- **Thermal management**: Cylindrical geometry enables efficient radial
  cooling with liquid-cooled aluminum inter-cell cooling plates
- **Manufacturing quality**: High-volume automotive cell production achieves
  defect rates below 1 part per million, essential for aviation safety
- **Supply chain**: Multiple qualified cell suppliers (Panasonic, Samsung SDI,
  LG Energy Solution) ensure supply continuity

## Battery Module Design

Each battery module integrates approximately 200 to 400 cells into a
self-contained unit with:

- **Cell interconnects**: Ultrasonic wire bonding or laser-welded nickel bus
  bars providing low-resistance electrical connections with redundant current
  paths to tolerate single interconnect failures
- **Battery Management System (BMS)**: Per-module BMS monitoring individual
  cell voltages (accuracy 5 mV), temperatures (accuracy 1C at 4 to 6
  measurement points per module), and state of charge through coulomb
  counting with voltage-based recalibration
- **Thermal management**: Liquid-cooled aluminum cold plates between cell
  rows, maintaining cell-to-cell temperature differential below 3C. Cooling
  liquid is a water-glycol mixture circulated by an electrically driven pump
  through an air-cooled radiator mounted in the engine nacelle.
- **Structural enclosure**: Aluminum or composite enclosure providing
  structural load path, electromagnetic interference shielding, and
  containment of any cell venting or thermal event

### Module-Level Safety

Each module incorporates multiple safety barriers:

- **Cell-level**: Current interrupt device, positive temperature coefficient
  layer, and pressure vent in each cell
- **Module-level**: Thermal barriers between cell groups to prevent
  propagation, pressure relief vents to direct vent gases away from
  adjacent modules and aircraft structure
- **System-level**: Modules are physically separated within the aircraft,
  with fireproof barriers between modules and from the cabin, cockpit, and
  fuel system

## In-Flight Charging

### Generator-Based Charging

During cruise flight, the range extender generator supplies charging power
to the battery system. The generator produces 540 to 750 VDC through an
active rectifier that controls output voltage and current to match the
battery's charging requirements. Charging power is modulated by the power
management system to maintain battery temperature within the optimal 25 to
35C range.

### Charge Rate Optimization

The charge rate during cruise is optimized for battery longevity:

- **Standard charge**: 0.3 to 0.5C (60 to 125 kW for a 250 kWh pack),
  achievable during all cruise phases
- **Fast charge**: 0.5 to 1.0C (125 to 250 kW), available when range extender
  has surplus capacity — typically during descent when motor demand is low
- **Charge termination**: Charging terminates at 90 to 95 percent state of
  charge to avoid the accelerated degradation associated with charging into
  the upper voltage knee of lithium-ion cells

### Thermal Management During Charging

Charging generates heat in the battery cells — approximately 3 to 5 percent
of charging power at 1C rate. The liquid cooling system must reject this heat
to ambient air through the radiator. At altitude, where ambient air
temperature is -30 to -50C at typical regional aircraft cruise altitudes of
8000 to 15000 feet, cooling capacity is abundant and the cooling system
operates efficiently.

## Ground Charging

### DC Fast Charging

For operators with high aircraft utilization, DC fast charging between flights
enables rapid turnaround:

- Charging power: 150 to 350 kW through CCS Combo or MCS connector standards
- Charge time: 20 to 80 percent state of charge in 30 to 45 minutes at 250 kW
- Infrastructure: Compatible with emerging electric vehicle charging standards,
  leveraging the massive investment in automotive charging infrastructure

### Overnight AC Charging

For overnight charging between operating days:

- Charging power: 22 to 44 kW through standard AC connection
- Charge time: 4 to 8 hours from 20 to 90 percent state of charge
- Infrastructure: Standard industrial AC power connection available at most
  airports

## Battery Lifecycle Economics

Battery replacement represents a significant operating cost for electric and
hybrid-electric aircraft. Ampaire's battery lifecycle model accounts for:

- **Acquisition cost**: Estimated 200 to 300 USD per kWh at the pack level
  for aviation-qualified battery modules, declining as automotive cell
  production scales
- **Replacement interval**: 3000 to 5000 cycles or 5 to 8 years of regional
  airline service, whichever occurs first
- **Residual value**: End-of-aviation-life batteries retain 70 to 80 percent
  of initial capacity, suitable for second-life stationary energy storage
  applications that recover 20 to 30 percent of initial acquisition cost
- **Effective cost per flight hour**: Approximately 25 to 50 USD for battery
  depreciation on a typical 2-hour regional mission, compared with 150 to
  250 USD in fuel savings — a net positive contribution to operating economics
