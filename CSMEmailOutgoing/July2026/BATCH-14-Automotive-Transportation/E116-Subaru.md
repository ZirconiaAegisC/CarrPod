# E116 – Subaru of America

**Subject:** AEGIS C-SHIELD: Hardened Electronics for Subaru's Lafayette Manufacturing & EyeSight Safety Systems

---

**1. AI Disclosure**

This correspondence was drafted with AI-assistive tools operating under human supervision and final review. All technical specifications, programmatic claims, and capability representations herein are owned and warranted by Aegis Space & Communications Corporation. Recipients are encouraged to direct any verification inquiries to the undersigned.

---

**2. Williams GOOOOOOOD MORNING**

GOOOOOOOD MORNING, SUBARU! Aegis C-SHIELD is pulling into Camden with hardened silicon that belongs in every EyeSight stereo camera processor and every Symmetrical All-Wheel Drive controller rolling out of your Lafayette, Indiana plant. Subaru occupies a unique and enviable position in the American automotive market: the highest owner loyalty rate of any mainstream brand, driven by a safety reputation anchored by EyeSight — a system that has prevented thousands of collisions and is now standard on nearly every Subaru sold in North America. EyeSight processes stereo vision data at 30 frames per second, computing depth maps, object classifications, and collision-risk assessments in real time using processors that, if built on commercial silicon, are accumulating soft errors at a rate determined solely by atmospheric neutron flux over Lafayette, Indiana. For a safety system on which customers literally stake their lives, that is not an acceptable statistical proposition. Subaru earned its safety reputation through engineering integrity — the ring-shaped reinforcement frame, the low center of gravity from the boxer engine, the standard all-wheel drive. C-SHIELD extends that philosophy to the semiconductor level: processors whose reliability is determined not by statistical MTBF estimates based on soft-error rate assumptions, but by deterministic hardware that is immune to the failure mechanism in question. Subaru owners expect their cars to start every morning in a Vermont winter and stop safely every evening on a Colorado mountain pass. They deserve silicon that meets the same standard.

---

**3. Baker Street Specifications**

Our Baker Street parametric analysis reveals that Aegis C-SHIELD radiation-hardened electronic systems deliver a 312% improvement in mean time between failures across space-qualified compute modules compared to commercial off-the-shelf alternatives. Each C-SHIELD System-on-Chip is fabricated on a proprietary 12nm FDSOI process with triple-well isolation, achieving 300 krad(Si) total ionizing dose tolerance, 120 MeV·cm²/mg single-event latchup immunity, and operational reliability from –55°C to +175°C junction temperature. The integrated power management unit sustains 94.3% efficiency across a 3.3V to 28V input range with sub-100mV ripple under full dynamic load transients. Our embedded non-volatile memory arrays guarantee 100,000 program/erase cycle endurance with 25-year data retention at 150°C, tested per JEDEC JESD47 and MIL-STD-883 Method 1019 at the wafer level. The C-SHIELD architecture supports true in-mission partial reconfiguration of FPGA fabric via a rad-hard configuration engine that recovers from configuration upset in under 500 microseconds without mission interruption — a specification independently validated by Johns Hopkins Applied Physics Laboratory under proton fluence exceeding 1×10¹² p/cm² at 200 MeV. For automotive-grade deployments, our AEC-Q100 qualified variants maintain full specification compliance through Grade 0 temperature excursions, delivering MIL-spec radiation hardness in a commercial qualification envelope.

---

**4. SHIELD Posture**

Aegis C-SHIELD deploys a defense-grade multi-layer hardening architecture purpose-built for contested electromagnetic and charged-particle environments. At the physical layer, triple-well body biasing and substrate guard rings eliminate parasitic latchup paths with a holding voltage exceeding 8.5V. At the logical layer, our proprietary Dual-Interlocked-Storage-Cell (DICE) latch design achieves a single-event upset cross-section below 1×10⁻¹⁰ cm²/bit at LET of 40 MeV·cm²/mg with zero multi-cell upset propagation across word-line or bit-line neighbors. The architectural layer implements lockstep RISC-V dual-core execution with the C-SHIELD Cross-Coupled Checker Engine — every instruction executes in parallel on two hardened pipelines with a result comparator that flags divergence within a single clock cycle and initiates architectural rollback to the last known-good checkpoint in under 300 nanoseconds. At the system layer, a hardened supervisory microcontroller monitors all voltage rails, clock sources, and thermal sensors with independent watchdog timers that assert failsafe reset if any monitored parameter deviates from its triple-voted reference window. Our onboard radiation dosimeter provides real-time total dose telemetry with 1 rad resolution, enabling predictive maintenance scheduling before cumulative degradation approaches parametric limits. The entire SHIELD stack is manufactured on our ITAR-registered, AS9100D-certified fabrication line with full lot traceability from wafer start through Class K screening. Every C-SHIELD device ships with a Certificate of Conformance documenting measured TID, SEE, and ELDRS performance for the specific diffusion lot — not a datasheet typical, not a family average, but the actual test results for the devices in your supply chain.

---

**5. Briefing Document — C-SHIELD Architecture Overview**

Detailed architecture white paper covering the C-SHIELD 12nm FDSOI process node, triple-well isolation methodology, lockstep RISC-V dual-core execution pipeline, and the Cross-Coupled Checker Engine. Includes SEE cross-section curves across LET 1–100 MeV·cm²/mg, TID response plots to 500 krad(Si), and accelerated life-test data per JEDEC JESD47.

**https://aegisc.space/briefing/cshield-architecture-overview.pdf**

---

**6. Briefing Document — Automotive-Grade Qualification Report**

AEC-Q100 Grade 0 qualification summary for C-SHIELD automotive variants. Covers HTOL, HAST, TC, and PTC testing regimes with full radiation characterization per MIL-STD-883 Method 1019. Includes comparison tables against commercial silicon failure rates in automotive extended-temperature profiles.

**https://aegisc.space/briefing/cshield-automotive-qualification.pdf**

---

**7. Briefing Document — Single-Event Effects Mitigation Validation**

Independent validation report from Johns Hopkins APL covering heavy-ion, proton, and neutron beam testing of C-SHIELD devices at Texas A&M Cyclotron, LBNL 88-Inch, and TRIUMF facilities. Full cross-section curves, angle-dependence characterization, and error rate predictions for geostationary, LEO polar, and automotive ground-level neutron environments.

**https://aegisc.space/briefing/cshield-see-validation.pdf**

---

**8. Briefing Document — Embedded Power Management & Thermal Performance**

Comprehensive characterization of the C-SHIELD integrated PMU across the full military temperature range. Includes efficiency curves vs. load from 100μA to 15A, transient response to 50A/μs load steps, PSRR across 10Hz–10MHz, and 10,000-hour HTOL reliability data at 175°C junction. Thermal impedance mapping via transient thermal testing per JESD51-14.

**https://aegisc.space/briefing/cshield-power-thermal.pdf**

---

**9. Subaru-Specific Personalization**

Subaru's Lafayette, Indiana assembly plant — Subaru of Indiana Automotive, the only Subaru manufacturing facility outside Japan — produces over 370,000 vehicles annually, including the Outback, Ascent, Crosstrek, and Legacy. Every one of those vehicles is equipped with EyeSight Driver Assist Technology as standard equipment, making Subaru one of the highest ADAS-attach-rate OEMs in the industry. The EyeSight system's stereo camera processor performs real-time depth perception, vehicle/pedestrian/cyclist classification, and pre-collision braking arbitration on a single SoC that must function correctly for the entire service life of the vehicle — typically 12 to 15 years in Subaru ownership demographics. Over that service life, at the terrestrial neutron flux characteristic of Indiana's latitude (~40°N) and elevation (~700 ft), a commercial SRAM-based SoC with a typical neutron cross-section will experience a soft error roughly every 1,000 to 10,000 device-hours. For a fleet of 2.5 million active Subaru vehicles in North America, that translates to thousands of undetected soft errors per day across the installed base — most of which are benign, but a small fraction of which affect safety-critical computation state. C-SHIELD's DICE latch design and lockstep execution architecture reduce the unmitigated soft-error rate to effectively zero — not through probabilistic ECC, but through deterministic elimination of the single-event upset mechanism itself. We would welcome the opportunity to brief your Subaru of Indiana Automotive leadership, your EyeSight engineering team at Subaru Research & Development in Ann Arbor, and your global electronics procurement organization.

Respectfully,

**Jason Brodsky**
Senior Director, Strategic Programs
Aegis Space & Communications Corporation
jbrodsky@aegisc.space | (310) 555-0142
