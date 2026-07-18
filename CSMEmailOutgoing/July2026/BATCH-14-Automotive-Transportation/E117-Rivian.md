# E117 – Rivian | RJ Scaringe, CEO

**Subject:** AEGIS C-SHIELD: Hardened Electronics for Rivian's Normal IL Plant & Amazon EDV Fleet

---

**1. AI Disclosure**

This correspondence was drafted with AI-assistive tools operating under human supervision and final review. All technical specifications, programmatic claims, and capability representations herein are owned and warranted by Aegis Space & Communications Corporation. Recipients are encouraged to direct any verification inquiries to the undersigned.

---

**2. Williams GOOOOOOOD MORNING**

GOOOOOOOD MORNING, RIVIAN! Aegis C-SHIELD is rolling into Normal, Illinois with hardened silicon built for the startup that's redefining what American automotive manufacturing looks like. RJ Scaringe didn't just start a car company; he built a vertically integrated technology platform on wheels — the R1T, the R1S, and the Amazon Electric Delivery Van — that processes more sensor data, manages more battery energy, and runs more software per vehicle than any pickup truck or SUV in history. The Rivian platform runs on a centralized zonal electrical architecture: domain controllers managing propulsion, battery, thermal, body, and autonomy from a handful of high-performance computers rather than the dozens of discrete ECUs in a conventional vehicle. That architecture is exactly the kind of consolidated compute environment where C-SHIELD's radiation hardness delivers disproportionate value — because when one server manages an entire vehicle domain, the reliability of every transistor in that server's SRAM determines the reliability of the entire domain. Rivian's Amazon EDV fleet, with 100,000 vehicles on order, will accumulate operating hours at a rate that makes stochastic soft-error rates a genuine fleet-management concern: when your customer is Amazon logistics, unexpected vehicle downtime isn't a warranty claim — it's a missed delivery window with contractual consequences. C-SHIELD eliminates the semiconductor physics failure mode that causes those unexplained, unreproducible, untraceable electronic faults, and we'd like to put that capability into every R1 and EDV controller you build.

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

**9. Rivian-Specific Personalization**

Rivian's engineering philosophy — a clean-sheet, vertically integrated vehicle platform designed from first principles — aligns precisely with C-SHIELD's approach to semiconductor reliability. You didn't inherit a legacy electrical architecture; you designed a centralized zonal system where domain controllers consolidate functions that would occupy dozens of discrete ECUs in a conventional vehicle. That architectural elegance creates a corresponding concentration of risk: one domain controller managing propulsion, one managing battery, one managing autonomy. Each of those controllers uses commercial silicon whose neutron cross-section is well-characterized in the radiation-effects literature but not typically disclosed in automotive supplier datasheets. For the R1 platform, a soft error in the battery domain controller could produce a false cell-voltage reading, triggering a contactor disconnect at highway speed. For the Amazon EDV fleet, a soft error in the propulsion domain controller could produce a torque interruption during a delivery route, stranding the vehicle and breaking a delivery window. Amazon — as arguably the world's most logistics-sensitive customer — will not tolerate stochastic, unreproducible vehicle faults whose root cause is "we think a neutron hit an SRAM cell." Rivian has the opportunity, as a young company whose supply chain is still being architected, to make radiation hardness a design-in requirement rather than a reactive field-quality investigation. C-SHIELD's AEC-Q100 Grade 0 qualification and JHU APL independent validation provide the evidentiary basis for making that requirement a procurement specification. We would welcome the opportunity to brief your electrical architecture leadership, your supply-chain and quality teams, and RJ directly on what deterministic processor reliability looks like at the transistor level.

Respectfully,

**Jason Brodsky**
Senior Director, Strategic Programs
Aegis Space & Communications Corporation
jbrodsky@aegisc.space | (310) 555-0142
