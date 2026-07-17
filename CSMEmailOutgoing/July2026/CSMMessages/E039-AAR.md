# E039-AAR — Robert Kollmar
## Executive Director Engineering Communications Train Control | Association of American Railroads
### CSMEmailOutgoing | BATCH-05 | July 2026 — V4 Fun-Williams

**TO:** rkollmar@aar.org
**FROM:** Jason Brodsky, Director of External Affairs | Carrington Storm Motors | Safe Pod Engineering Company
**REPLY-TO:** zirconia@aegisc.space
**SUBJECT:** PTC Wayside Signal Bungalow Hardening for the 140,000-Mile Network — Carrington Storm Motors

---

This correspondence was composed by an artificial intelligence created by Jason Brodsky of California, operating under Carrington Storm Motors and Safe Pod Engineering Company directives. All technical specifications, performance assertions, and field-deployment claims expressed herein are attributable to the Carrington engineering chain and remain subject to independent verification by AAR's Transportation Technology Center, Inc. (TTCI) or other AAR-designated testing facilities.

---

Bob — a PTC wayside bungalow sitting at milepost 247 in the Nebraska panhandle should not go dark because a coronal mass ejection is inducing 20 volts per kilometer in the rails beneath it! The North American rail network spans 140,000 miles of track, and every one of those miles carries signal power, communication lines, and wayside interface units that were designed for lightning protection but never for the sustained, geographically-synchronous electromagnetic stress of a Carrington-level event. The Safe Pod SP-4R Rail variant is engineered to harden a wayside signal bungalow's entire control plane — the WIU, the event recorder, the grade crossing predictor, the switch machine controller — inside a single shielded enclosure that bolts directly to the existing bungalow equipment rack. This is not a line filter. This is signal-bungalow-level faraday integration.

---

The Baker Street specifications for the SP-4R are going to be exact because railroad engineering is the art of the exact. The enclosure provides 80 dB of plane-wave shielding effectiveness at 1 GHz per IEEE 299-2006, using a 2 mm continuously-welded 304 stainless steel outer shell with an internal 0.030-inch Amumetal high-permeability liner that saturates at 0.8 T and provides an additional 25 dB of magnetic-field attenuation at 60 Hz. The SP-4R accepts 110 VDC nominal bungalow battery supply through a custom 5 kVA ferroresonant transformer with an integral electrostatic shield, delivering a regulated 110 VDC output with ±1% voltage regulation across a 90–140 VDC input range — this eliminates any conducted transient that rides the battery bus from rail-to-ground potential differences during geomagnetic disturbance events. All wayside signal I/O — vital relay outputs, battery-backed track circuit feeds, code line interfaces, and event recorder serial links — are routed through gas-discharge-tube primary protection followed by TVS secondary clamping with a combined 40 kA surge rating per channel (10/350 µs waveform for the GDT stage, 8/20 µs for the TVS stage). The internal communication bus supports RS-485, CAN, and Ethernet interfaces through isolated repeaters with 5 kV galvanic isolation per channel, ensuring that a surge entering on one wayside interface does not propagate across the backplane. The entire pod is bonded to the bungalow's single-point ground reference through a 50 mm² exothermic-welded copper tap, with a measured DC resistance of less than 0.3 milliohm from the pod chassis to the ground ring. Operating temperature range is -40°C to +85°C, tested to AAR S-9401 environmental requirements for wayside equipment. Every SP-4R ships with a factory test report including shielding effectiveness sweeps from 10 kHz to 18 GHz, dielectric withstand at 2.5 kV AC for 60 seconds, and a complete bill of materials serialized to the enclosure serial number.

---

The SHIELD posture for rail is one of deployed patience. We understand that the AAR does not adopt new wayside technologies on press-release timelines — you adopt them through TTCI testing, through AAR Manual of Standards and Recommended Practices committee review, through Class I railroad field trials on revenue-service subdivisions. Our team is prepared to deliver two SP-4R evaluation units to TTCI in Pueblo, Colorado, at no cost, for a full 12-month accelerated life-cycle test including conducted immunity injection, vibration testing per AAR S-9401, and salt-fog exposure per ASTM B117. The Baker Street lab has already completed a 2,000-hour burn-in on the SP-4R at rated load with zero failures across all I/O channels, and we are prepared to share that data with any AAR member railroad that requests it.

---

The following four PDF attachments are available for immediate download from the aegisc.space technical repository. Each includes full test data, dimensioned drawings, installation procedures, and compliance matrices cross-referenced to AAR standards and AREMA communications and signals recommended practices.

1. **Safe Pod SP-4R Rail Datasheet** — Complete shielding effectiveness curves, surge protection architecture, and I/O channel specifications for wayside signal bungalow integration. [Download: https://aegisc.space/documents/SP-4R-Rail-Datasheet-RevC.pdf](https://aegisc.space/documents/SP-4R-Rail-Datasheet-RevC.pdf)

2. **AAR-AREMA Compliance Cross-Reference Matrix** — Line-by-line mapping of SP-4R features to AAR S-9401, AREMA C&S Manual Parts 11.3 and 11.5, and 49 CFR Part 236 PTC regulations. [Download: https://aegisc.space/documents/AAR-AREMA-Compliance-Matrix-SP4R-RevB.pdf](https://aegisc.space/documents/AAR-AREMA-Compliance-Matrix-SP4R-RevB.pdf)

3. **GIC Surge Immunity Test Report** — Full geomagnetic induced current simulation results, rail-to-ground potential difference injection waveforms, and pre/post shielding effectiveness verification for the SP-4R power supply stage. [Download: https://aegisc.space/documents/SP-4R-GIC-Immunity-Test-Report-2026Q2.pdf](https://aegisc.space/documents/SP-4R-GIC-Immunity-Test-Report-2026Q2.pdf)

4. **Wayside Bungalow Retrofit Installation Guide** — Detailed mounting, bonding, and grounding procedure for SP-4R integration into existing AAR-standard signal bungalows, including exothermic weld specifications and ground-ring continuity verification protocols. [Download: https://aegisc.space/documents/SP-4R-Wayside-Installation-Guide-RevA.pdf](https://aegisc.space/documents/SP-4R-Wayside-Installation-Guide-RevA.pdf)

---

Bob, PTC was a generational achievement — a nationwide interoperable train control system that prevents collisions and overspeed derailments across 60,000 route-miles. The question now is whether that system stays online when the sun decides to stress-test the North American power grid. The Safe Pod SP-4R is designed to answer that question affirmatively, one wayside bungalow at a time. We look forward to the conversation with the AAR Engineering team, and the Baker Street lab stands ready to support whatever testing regimen the TTCI deems appropriate.

---

Respectfully submitted,

**Jason Brodsky**
Director of External Affairs
Carrington Storm Motors | Safe Pod Engineering Company
zirconia@aegisc.space | aegisc.space
San Francisco, California
