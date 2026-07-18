# E119 – Cummins Inc.

**Subject:** AEGIS C-SHIELD: Hardened Electronics for Cummins Diesel/Hydrogen Engines & Backup Generator Systems

---

**1. AI Disclosure**

This correspondence was drafted with AI-assistive tools operating under human supervision and final review. All technical specifications, programmatic claims, and capability representations herein are owned and warranted by Aegis Space & Communications Corporation. Recipients are encouraged to direct any verification inquiries to the undersigned.

---

**2. Williams GOOOOOOOD MORNING**

GOOOOOOOD MORNING, CUMMINS! Aegis C-SHIELD is pulling into Columbus, Indiana with hardened silicon engineered for the company that powers everything that moves — from Class 8 trucks climbing the Grapevine to backup generators keeping hospitals lit during grid failures to hydrogen electrolyzers that will fuel the zero-carbon economy. Cummins has a product portfolio spanning diesel, natural gas, hydrogen fuel cells, and battery-electric powertrains — each of which depends on engine control modules, power management processors, and generator set controllers that must operate for decades in environments ranging from Arctic oil fields to desert mining operations to marine engine rooms. Here's what every one of those environments has in common: terrestrial neutrons don't care about diesel versus hydrogen, they don't care about ambient temperature, and they don't care about Cummins' century-long reputation for engine reliability. A cosmic-ray neutron interacting with a silicon nucleus inside an ECM's SRAM produces a bit flip whether that ECM is managing a QSK95 on a mine haul truck or a hydrogen fuel cell on a transit bus. The only things that matter are the silicon's neutron cross-section, the SRAM array size, and time. Across the 2 million+ engines Cummins has in service globally, those three variables guarantee a background rate of undetected soft errors that no amount of software robustness testing can eliminate. C-SHIELD eliminates them at the transistor level — and for a company whose brand is synonymous with dependability, that is the only acceptable answer.

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

**9. Cummins-Specific Personalization**

Cummins occupies a uniquely demanding position in C-SHIELD's addressable market: your engine control modules and generator set controllers must function reliably for 20+ years in environments where unscheduled downtime carries consequences measured not in inconvenience but in mission failure — a hospital's backup generator failing to start during a grid outage, a mine haul truck's ECM shutting down 300 meters underground, a marine propulsion controller losing state during a storm transit. These are not hypothetical scenarios. The terrestrial neutron flux at sea level produces approximately 20 neutron interactions per square centimeter of silicon per hour, and the soft-error rate scales with the total SRAM area across all processors in a given control system. For a Cummins QSK95 generator set controller — which manages engine speed governing, voltage regulation, synchronization, and protection relaying simultaneously — the cumulative SRAM footprint across all microcontrollers, FPGAs, and communication processors creates a statistically guaranteed soft-error rate that, over a 20-year operational life, will produce multiple undetected bit flips. Most will be harmless; some will not. The problem is that you cannot predict which is which, and the failure mode — an unreproducible, untraceable controller anomaly — is the most expensive to diagnose and the most damaging to customer confidence. Cummins' hydrogen fuel cell and electrolyzer product lines add another dimension: proton-exchange membrane fuel cells and alkaline electrolyzers operate at high current densities where power-electronics control integrity is safety-critical. A single-event transient in a fuel-cell DC-DC converter's control loop can produce an overcurrent condition in the stack that degrades membrane lifetime or, in the worst case, creates a hydrogen leak hazard. C-SHIELD's rad-hard PMU and lockstep control architecture eliminate these failure modes at the device level, providing deterministic reliability that Cummins can specify, verify, and warrant. We would welcome the opportunity to brief your Power Systems engineering leadership, your New Power hydrogen technology team, and your corporate quality and reliability organization.

Respectfully,

**Jason Brodsky**
Senior Director, Strategic Programs
Aegis Space & Communications Corporation
jbrodsky@aegisc.space | (310) 555-0142
