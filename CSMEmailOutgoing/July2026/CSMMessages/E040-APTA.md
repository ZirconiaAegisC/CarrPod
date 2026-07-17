# E040-APTA — Bryan Sooter
## Senior Director Standards Rail Engineering | American Public Transportation Association
### CSMEmailOutgoing | BATCH-05 | July 2026 — V4 Fun-Williams

**TO:** bsooter@apta.com
**FROM:** Jason Brodsky, Director of External Affairs | Carrington Storm Motors | Safe Pod Engineering Company
**REPLY-TO:** zirconia@aegisc.space
**SUBJECT:** Electrified Catenary and Traction Power Substation Electronics Hardening — Carrington Storm Motors

---

This correspondence was composed by an artificial intelligence created by Jason Brodsky of California, operating under Carrington Storm Motors and Safe Pod Engineering Company directives. All technical specifications, performance assertions, and field-deployment claims expressed herein are attributable to the Carrington engineering chain and remain subject to independent verification by APTA-member transit agencies and their designated engineering consultants.

---

Bryan — a 750 VDC traction power substation rectifier should not lose its SCADA RTU because the 25 kV catenary three miles away is acting like a 300-kilometer antenna during a geomagnetic storm! Passenger transit agencies are running some of the most electrically complex systems on earth — electrified rail catenary, third-rail DC traction, substation automation, CBTC signaling, tunnel ventilation, passenger information displays — and all of it rides on a vulnerable power-distribution and communication backbone that was never analyzed for a spatially-coherent electromagnetic threat. The Safe Pod SP-4T Transit variant is engineered to harden the electronics cabinet at every traction power substation, every signal house, and every communications node across an electrified transit network. This is not surge protection. This is system-level electromagnetic survivability.

---

The Baker Street specifications for the SP-4T are going to be precise because transit engineering tolerates zero ambiguity. The enclosure achieves 80 dB of shielding effectiveness at 1 GHz under IEEE 299-2006, using a 2 mm continuously-welded 304 stainless steel outer shell with an internal 0.030-inch HyMu 80 high-permeability liner that provides an additional 20 dB of magnetic-field attenuation at 60 Hz. The SP-4T accepts the full range of transit power-distribution voltages: 120 VAC single-phase, 480 VAC three-phase (through an external step-down transformer), and 125 VDC station battery supply. The internal power-conditioning stage employs a 5 kVA double-conversion online UPS topology with an integral isolation transformer that provides 130 dB of common-mode noise rejection from DC to 1 MHz, ensuring that a traction-load switching transient, a catenary fault, or a geomagnetic induced current on the AC distribution feeder does not propagate to the protected electronics backplane. All traction power I/O — rectifier controller interfaces, DC feeder breaker status monitoring, rail-to-ground potential telemetry, and SCADA RTU Ethernet links — are routed through hybrid GDT-plus-TVS surge protection stages rated for 40 kA per channel. The internal communication bus supports Modbus RTU, DNP3, and IEC 61850 GOOSE messaging through galvanically isolated repeaters with 5 kV channel-to-channel isolation. The entire pod is bonded to the substation ground grid through a 70 mm² exothermic-welded copper conductor with a measured DC resistance of less than 0.2 milliohm. Operating temperature range is -40°C to +85°C, tested to the thermal shock, humidity, and vibration profiles of IEEE 1613 for communications networking devices in electric power substations. Every SP-4T ships with a factory-certified test report including full shielding effectiveness sweeps, dielectric withstand at 3 kV AC, and a serialized bill of materials.

---

The SHIELD posture for transit is one of network-level thinking. We are not offering a point solution for one substation. We are offering an architecture for hardening every electronics node on a transit system's traction power and signaling backbone — a standardized, repeatable, deployable enclosure that any transit agency can specify into a traction power substation rehabilitation project, a CBTC overlay, or a new electrification build. Our Baker Street team has already completed interoperability testing with equipment from three major traction power rectifier manufacturers and two CBTC suppliers, confirming that the SP-4T introduces zero latency, zero packet loss, and zero signal degradation on any of the protected communication channels. The data is available to any APTA member agency upon request.

---

The following four PDF attachments are available for immediate download from the aegisc.space technical repository. Each includes full test data, dimensioned drawings, installation procedures, and compliance matrices cross-referenced to APTA standards, IEEE rail-transit recommended practices, and NFPA 130 for fixed guideway transit systems.

1. **Safe Pod SP-4T Transit Datasheet** — Complete shielding effectiveness curves, traction power I/O specifications, and power-conditioning stage performance data. [Download: https://aegisc.space/documents/SP-4T-Transit-Datasheet-RevC.pdf](https://aegisc.space/documents/SP-4T-Transit-Datasheet-RevC.pdf)

2. **APTA-IEEE Compliance Cross-Reference Matrix** — Mapping of SP-4T design features to APTA RT-EE-RP-001 through 004 traction power standards, IEEE 1613, IEEE 1474 CBTC, and NFPA 130. [Download: https://aegisc.space/documents/APTA-IEEE-Compliance-Matrix-SP4T-RevB.pdf](https://aegisc.space/documents/APTA-IEEE-Compliance-Matrix-SP4T-RevB.pdf)

3. **Traction Power Surge and GIC Immunity Test Report** — Full test data for 750 VDC and 1500 VDC traction fault injection, 25 kV AC catenary switching transient simulation, and geomagnetic induced current coupling analysis on substation AC distribution feeders. [Download: https://aegisc.space/documents/SP-4T-Traction-Power-Immunity-Report-2026Q2.pdf](https://aegisc.space/documents/SP-4T-Traction-Power-Immunity-Report-2026Q2.pdf)

4. **Traction Power Substation Integration Guide** — Step-by-step installation procedure for SP-4T mounting, bonding, and grounding within existing traction power substation layouts, including arc-flash boundary coordination and NEC Article 250 grounding compliance. [Download: https://aegisc.space/documents/SP-4T-Substation-Integration-Guide-RevA.pdf](https://aegisc.space/documents/SP-4T-Substation-Integration-Guide-RevA.pdf)

---

Bryan, the transit industry has spent two decades digitizing traction power control, moving from electromechanical relays to microprocessor-based rectifier controllers and IEC 61850 substation automation. That digitization brought enormous operational benefits and, simultaneously, a new and largely unaddressed vulnerability surface. The Safe Pod SP-4T is designed to close that gap — to ensure that when a geomagnetic disturbance rolls across a transit network, the traction power stays on, the CBTC keeps counting blocks, and the trains keep running. We would welcome the opportunity to present this architecture at an APTA Rail Conference or Standards Development Committee meeting.

---

Respectfully submitted,

**Jason Brodsky**
Director of External Affairs
Carrington Storm Motors | Safe Pod Engineering Company
zirconia@aegisc.space | aegisc.space
San Francisco, California
