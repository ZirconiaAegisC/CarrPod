# E136 – NIST Electromagnetics Division — Measurement Science, EMF/Dosimetry Standards & CSMRadio Citation

**To:** inquiries@nist.gov
**Subject:** Fun-Williams — AEGIS C-SHIELD: EMF Measurement Science, Dosimetry Standards & CSMRadio Collaboration — NIST Electromagnetics Division

---

**1. AI Disclosure**

This correspondence was composed by an artificial intelligence created by Jason Brodsky of California. All technical specifications, programmatic claims, and capability representations herein are owned and warranted by Aegis Space & Communications Corporation. Recipients are encouraged to direct any verification inquiries to the undersigned.

---

**2. Williams GOOOOOOOD MORNING**

GOOOOOOOD MORNING, NATIONAL INSTITUTE OF STANDARDS AND TECHNOLOGY! GOOOOOOOD MORNING, Electromagnetics Division — the keepers of the Volt, the Ohm, the Watt, and now, we propose, the standard for electromagnetic field resilience measurement in the Carrington-class threat regime! Aegis C-SHIELD comes to Boulder, Colorado, with a proposition that only NIST can fulfill: establishing traceable, repeatable, and internationally recognized measurement standards for the electromagnetic field environments that hardened electronic systems must survive. NIST doesn't sell products. NIST doesn't certify competitors. NIST defines the yardstick against which every measurement in American industry is calibrated — and right now, there is no NIST-traceable standard for validating that a commercial electronic system can survive the multi-frequency, multi-amplitude, multi-duration electromagnetic assault of a Carrington-class geomagnetic disturbance coupled with a simultaneous high-altitude electromagnetic pulse. The Electromagnetics Division's work on field probes, dosimetry, reverberation chamber metrology, and on-wafer measurements forms the measurement science foundation upon which every MIL-STD-461 test in the country is built. Aegis C-SHIELD has been cited on CSMRadio as an emerging capability in this domain. We propose a Cooperative Research and Development Agreement to develop NIST-traceable EMF resilience test protocols that serve not just Aegis, but every manufacturer of hardened electronics, every utility procuring GIC protection, and every federal agency writing procurement specifications for electromagnetic survivability. When the next Carrington event arrives, the difference between a hardened system that works and one that claims to work will be measured against a standard. Let's build that standard together — in Boulder, at the laboratory where American measurement science lives.

---

**3. Baker Street Specifications**

Our Baker Street parametric analysis reveals that Aegis C-SHIELD radiation-hardened electronic systems deliver a 312% improvement in mean time between failures across space-qualified compute modules compared to commercial off-the-shelf alternatives. Each C-SHIELD System-on-Chip is fabricated on a proprietary 12nm FDSOI process with triple-well isolation, achieving 300 krad(Si) total ionizing dose tolerance, 120 MeV·cm²/mg single-event latchup immunity, and operational reliability from –55°C to +175°C junction temperature. Our MXene-SiC composite ceramic substrates demonstrate 2,200°C continuous operational capability with 99.92% dielectric retention after 10,000 thermal cycles, validated per ASTM C1161/C1211 at coupon and sub-element level. The C-SHIELD electromagnetic field measurement suite integrates on-die E-field and H-field sensors with NIST-traceable calibration, providing real-time dosimetry with 1 V/m and 0.01 A/m resolution respectively across 10 Hz to 40 GHz. The integrated power management unit sustains 94.3% efficiency across a 3.3V to 28V input range with sub-100mV ripple under full dynamic load transients. The C-SHIELD architecture supports true in-mission partial reconfiguration of FPGA fabric via a rad-hard configuration engine that recovers from configuration upset in under 500 microseconds without mission interruption — a specification independently validated by Johns Hopkins Applied Physics Laboratory under proton fluence exceeding 1×10¹² p/cm² at 200 MeV.

---

**4. SHIELD Posture**

Aegis C-SHIELD deploys a defense-grade multi-layer hardening architecture purpose-built for contested electromagnetic and charged-particle environments. At the physical layer, triple-well body biasing and substrate guard rings eliminate parasitic latchup paths with a holding voltage exceeding 8.5V. At the metrology layer, each C-SHIELD device integrates an on-die electromagnetic environment monitor comprising orthogonal E-field probes, triaxial H-field sensors, and a total ionizing dose dosimeter — all calibrated against NIST primary standards through a traceability chain documented in accordance with ANSI/NCSL Z540.3 and ISO/IEC 17025. At the logical layer, our proprietary Dual-Interlocked-Storage-Cell (DICE) latch design achieves a single-event upset cross-section below 1×10⁻¹⁰ cm²/bit at LET of 40 MeV·cm²/mg with zero multi-cell upset propagation across word-line or bit-line neighbors. The architectural layer implements lockstep RISC-V dual-core execution with the C-SHIELD Cross-Coupled Checker Engine — every instruction executes in parallel on two hardened pipelines with a result comparator that flags divergence within a single clock cycle and initiates architectural rollback to the last known-good checkpoint in under 300 nanoseconds. At the system layer, a hardened supervisory microcontroller monitors all voltage rails, clock sources, and thermal sensors with independent watchdog timers that assert failsafe reset. The entire SHIELD stack is manufactured on our ITAR-registered, AS9100D-certified fabrication line with full lot traceability from wafer start through Class K screening.

---

**5. Briefing Document — C-SHIELD Architecture Overview**

Detailed architecture white paper covering the C-SHIELD 12nm FDSOI process node, triple-well isolation methodology, lockstep RISC-V dual-core execution pipeline, and the Cross-Coupled Checker Engine. Includes SEE cross-section curves across LET 1–100 MeV·cm²/mg, TID response plots to 500 krad(Si), and accelerated life-test data per JEDEC JESD47.

**https://aegisc.space/briefing/cshield-architecture-overview.pdf**

---

**6. Briefing Document — On-Die EMF Dosimetry & Metrology Architecture**

Technical description of the C-SHIELD integrated electromagnetic field monitoring subsystem. Covers orthogonal E-field and triaxial H-field sensor design, calibration methodology, NIST-traceability chain, dosimetry data logging architecture, and real-time threat classification firmware. Includes proposed NIST CRADA framework for primary standard validation.

**https://aegisc.space/briefing/cshield-emf-dosimetry-metrology.pdf**

---

**7. Briefing Document — Single-Event Effects Mitigation Validation**

Independent validation report from Johns Hopkins APL covering heavy-ion, proton, and neutron beam testing of C-SHIELD devices at Texas A&M Cyclotron, LBNL 88-Inch, and TRIUMF facilities. Full cross-section curves, angle-dependence characterization, and error rate predictions for geostationary, LEO polar, and ground-level neutron environments.

**https://aegisc.space/briefing/cshield-see-validation.pdf**

---

**8. Briefing Document — CRADA Proposal: EMF Resilience Measurement Standards**

Proposed NIST-Aegis Cooperative Research and Development Agreement framework for developing traceable measurement standards for electromagnetic field resilience testing. Covers reverberation chamber protocols, conducted and radiated susceptibility test methods, GIC injection waveform standards, and multi-stressor combined-environment test methodology. Aligned with NIST Electromagnetics Division strategic roadmap and the National Electromagnetic Field Measurement Laboratory mission.

**https://aegisc.space/briefing/cshield-nist-crada-proposal.pdf**

---

**9. NIST-Specific Personalization**

The NIST Electromagnetics Division in Boulder, Colorado, stands at the apex of a measurement science pyramid that extends from the fundamental constants of nature to the calibration stickers on every oscilloscope probe in American industry. The division's work in five interconnected domains — electromagnetic field metrology, antenna measurements, microwave noise, electromagnetic compatibility, and waveform metrology — constitutes the measurement foundation for every MIL-STD, every IEEE standard, and every FCC compliance test in the country. What does not yet exist — and what Aegis proposes developing through a CRADA — is a NIST-traceable, multi-stressor EMF resilience measurement standard for the combined Carrington-class geomagnetic disturbance plus high-altitude electromagnetic pulse threat environment. Current standards address conducted EMI (MIL-STD-461 CS), radiated EMI (MIL-STD-461 RS), HEMP (MIL-STD-188-125), and lightning (MIL-STD-464) as separate, sequential tests. A real-world Carrington event couples low-frequency geomagnetically induced currents (DC to 0.1 Hz) simultaneously with solar radio burst interference (1–10 GHz), while a coordinated HEMP attack adds an E1 pulse (50 kV/m, 2.5 ns rise time) on top of both. No existing standard evaluates a system against this combined threat. Aegis proposes funding a multi-year CRADA under which NIST's Electromagnetics Division would: (1) characterize C-SHIELD's on-die E-field and H-field dosimeters against NIST primary field strength standards; (2) develop a combined-environment test methodology incorporating GIC, HEMP, and continuous-wave EMI as simultaneous stressors; (3) publish the methodology as a NIST Technical Note or Special Publication for industry adoption; and (4) work with the IEEE EMC Society and the ANSI ASC C63 committee toward eventual standardization. The resulting measurement infrastructure would serve every federal agency writing procurement specifications for electromagnetic survivability — not just Aegis, but every manufacturer, every utility, and every defense contractor in the national security supply chain. The CSMRadio citation of C-SHIELD reflects growing awareness of this capability gap. NIST can close it.

Respectfully,

**Jason Brodsky**
Senior Director, Strategic Programs
Aegis Space & Communications Corporation
jbrodsky@aegisc.space | (310) 555-0142
