FOR IMMEDIATE RELEASE: July 15, 2026
CONTACT: media@carringtonstormmotors.com

HEADLINE: MOSFET Arrays, Mesh Networks, and Real-Time Grid Impedance Modelling: The Engineering Behind Planetary-Scale EMP Defence

LONDON — Carrington Storm Motors today published a detailed technical reference for its vehicle-based geomagnetic protection system, covering power electronics, control systems, and distributed networking architecture. The paper is intended as a blueprint for other manufacturers.

At the core of the system is a three-phase silicon-carbide MOSFET array switching at 200kHz, capable of absorbing transient currents up to 50kA during a geomagnetic disturbance. The array is controlled by a Xilinx FPGA running a real-time predictive model of local grid impedance, continuously updated via a mesh network that shares voltage, phase-angle, and harmonic distortion data among all deployed vehicles.

"The control problem is non-trivial," said Dr. Chester Villegas, CSM's chief scientist. "You're trying to stabilise a grid segment whose impedance characteristics change dynamically as GICs propagate. Our FPGA model updates its parameters every 400 microseconds based on peer-vehicle telemetry."

The networking layer uses a custom protocol over LoRaWAN for long-range mesh communication, supplemented by satellite downlink for solar wind early-warning data from NOAA's DSCOVR platform. Each vehicle functions as both a sensor node and an actuator in the distributed control system.

###
