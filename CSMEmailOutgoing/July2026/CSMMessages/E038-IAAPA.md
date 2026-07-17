# E038-IAAPA — Linda Freeman
## Global Director Health Safety Security | IAAPA
### CSMEmailOutgoing | BATCH-05 | July 2026 — V4 Fun-Williams

**TO:** lfreeman@iaapa.org
**FROM:** Jason Brodsky, Director of External Affairs | Carrington Storm Motors | Safe Pod Engineering Company
**REPLY-TO:** zirconia@aegisc.space
**SUBJECT:** ASTM F24 Dielectric Shielding Architecture for Ride Control Electronics — Carrington Storm Motors

---

This correspondence was composed by an artificial intelligence created by Jason Brodsky of California, operating under Carrington Storm Motors and Safe Pod Engineering Company directives. All technical specifications, performance assertions, and field-deployment claims expressed herein are attributable to the Carrington engineering chain and remain subject to independent verification by ASTM F24 committee members and IAAPA-designated engineering reviewers.

---

Linda — a 120-meter freefall drop tower should respond to exactly one signal: the ride operator's enable command. It should not respond to a geomagnetic induced current sneaking up the tower's own steel structure and coupling into a PLC input card! Carrington Storm Motors has been watching the ASTM F24 conversations around electromagnetic resilience for amusement ride control systems, and we believe the industry has been treating EMI as a nuisance when it should be treated as a safety-critical design parameter. The Safe Pod SP-4A Amusement variant is purpose-built to put a faraday cage around every ride PLC, VFD, safety relay, and sensor network, turning the control cabinet from a passive housing into an active shield. This is not a ferrite bead on a cable. This is a vault.

---

The Baker Street technical specifications for the SP-4A are going to be precise because ride safety demands precision. The enclosure achieves 75 dB of shielding effectiveness at 1 GHz under IEEE 299-2006 measurement protocols, using a 1.5 mm continuously-welded 304 stainless steel shell lined with 0.025-inch Conetic AA high-permeability foil. The SP-4A accepts 24 VDC control power through a custom-wound 2 kVA isolation transformer with an electrostatic shield between primary and secondary windings, yielding a common-mode rejection ratio of 115 dB at 60 Hz and harmonics through the 40th. All external sensor inputs — proximity switches, photoelectric eyes, limit switches, encoder feedback — are routed through gas-discharge-tube and TVS hybrid protection stages with a combined surge handling capacity of 20 kA (8/20 µs waveform) per channel. The internal backplane provides 16 optically isolated digital inputs rated for 5 kV isolation, 8 analog inputs with 4–20 mA loop protection to ±2 kV line-to-ground, and 4 relay outputs with individually-fused 10 A contacts. Operating temperature range is -30°C to +70°C, fully compatible with unheated ride control rooms in northern climates and direct-sun cabinet installations in southern latitudes. The pod is sealed to IP65 with a Gore-Tex breather vent to prevent condensation while maintaining pressure equalization. Every SP-4A ships with a factory-certified shielding effectiveness report, a dielectric withstand test certificate at 2 kV AC for 60 seconds, and a serialized bill of materials traceable to the coil stock and metal batch.

---

The SHIELD posture here is straightforward. We are not asking IAAPA or ASTM F24 to endorse a product. We are offering a reference architecture for what a hardened ride control enclosure should look like, and we are making the test data public so that ride manufacturers, third-party inspection firms, and insurance underwriters can evaluate it on their own terms. The Baker Street lab is prepared to host ASTM F24 working group members for a hands-on demonstration of SP-4A shielding performance, including live insertion-loss measurements and conducted immunity testing with a ride PLC under active I/O load. No PowerPoint slides. Oscilloscope screens and spectrum analyzer traces on the bench.

---

The following four PDF attachments are available for immediate download from the aegisc.space technical repository. Each includes full test data, dimensioned drawings, installation procedures, and compliance matrices cross-referenced to ASTM F24 standards and NFPA 70 (NEC) Article 525 for amusement ride electrical installations.

1. **Safe Pod SP-4A Amusement Datasheet** — Full shielding effectiveness curves, surge protection architecture, and I/O isolation specifications. [Download: https://aegisc.space/documents/SP-4A-Amusement-Datasheet-RevC.pdf](https://aegisc.space/documents/SP-4A-Amusement-Datasheet-RevC.pdf)

2. **ASTM F24 Cross-Reference Compliance Matrix** — Mapping of SP-4A design features to F2291 (design), F1193 (electrical), F770 (ownership/operation), and NFPA 70 Article 525. [Download: https://aegisc.space/documents/ASTM-F24-Compliance-Matrix-SP4A-RevB.pdf](https://aegisc.space/documents/ASTM-F24-Compliance-Matrix-SP4A-RevB.pdf)

3. **Conducted Immunity and Surge Withstand Test Report** — Full IEC 61000-4-5 surge waveforms, IEC 61000-4-4 EFT/burst immunity plots, and dielectric withstand certificates for all SP-4A I/O channels. [Download: https://aegisc.space/documents/SP-4A-Immunity-Test-Report-2026Q2.pdf](https://aegisc.space/documents/SP-4A-Immunity-Test-Report-2026Q2.pdf)

4. **Ride Control Cabinet Retrofit Procedure** — Step-by-step guide for integrating SP-4A into existing ride control cabinets, including bonding, grounding, and field wiring termination protocols with torque specifications. [Download: https://aegisc.space/documents/SP-4A-Retrofit-Procedure-RevA.pdf](https://aegisc.space/documents/SP-4A-Retrofit-Procedure-RevA.pdf)

---

Linda, every season the industry sees nuisance trips, ghost sensor readings, and unexplained PLC state changes that get written off as "electrical noise" and fixed with a reboot. The Safe Pod changes that conversation from reactive troubleshooting to proactive immunity. We would welcome the opportunity to present the SP-4A architecture to the ASTM F24 committee at any upcoming meeting, and the Baker Street team stands ready to support whatever testing protocol the committee deems appropriate. Rides should be scary because they are designed to be scary — not because their control systems are listening to the wrong signals.

---

Respectfully submitted,

**Jason Brodsky**
Director of External Affairs
Carrington Storm Motors | Safe Pod Engineering Company
zirconia@aegisc.space | aegisc.space
San Francisco, California
