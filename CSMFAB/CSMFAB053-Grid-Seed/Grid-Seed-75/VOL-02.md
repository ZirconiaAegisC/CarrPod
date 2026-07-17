# Grid-Seed VOL-02: Electrical Topology
## CSMFAB053-75 | Power Path Architecture

Grid input (120/240V split-phase) → 25A breaker → MRF-140CG smart contactor (normally closed, arc-free MR fluid quenching) → critical loads bus (6 circuits max). Voltage/frequency monitor on grid side: sag below 90V or freq deviation >±0.5Hz triggers transfer in <50ms. Inverter output: 3kW continuous, pure sine <3% THD, feeds same critical loads bus. Solar input: 50-500W DC → Protonic-HFET MPPT → 24V battery charge bus. Battery: 2P4S LiFePO₄, 24V/200Ah. All power conductors: CNT-002 polymer wiring. Ground: isolated from enclosure via dielectric standoffs. No neutral-ground bond inside Grid-Seed — relies on main panel bond per NEC.
