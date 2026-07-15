
# TECHNICAL FRAMEWORK
## ACS-CISCO-NETWORK-HARDWARE-PROTECTION
### Embedded GIC Protection in Network Equipment

**CLASSIFICATION: COMMERCIAL-IN-CONFIDENCE**

## 1. PSU DESIGN MODIFICATION

**Current Design:** Cisco enterprise PSUs use aluminum electrolytic capacitors on the DC bus. These capacitors have limited ripple current rating and degrade rapidly under quasi-DC GIC exposure.

**Proposed Design:** Replace electrolytic capacitors with CSM-MX-2400 MXene-based DC-link capacitors. MXene provides:
- 5-8x higher capacitance density (F/cm³) than aluminum electrolytic
- 10x longer service life (15 years vs. 1.5-3 years for electrolytic)
- 3x higher ripple current rating
- GIC tolerance: withstands 500V DC offset on AC input without degradation
- Same form factor as replaced component

**Williams Heuristic:** "A network switch power supply is like a water filter. It takes the AC electricity from the wall and filters it into clean DC electricity for the computer chips inside. The capacitors in this filter are like a pressure tank — they smooth out the flow. Standard capacitors can't handle the kind of dirty electricity a solar storm creates. Our MXene capacitors can — same size, same shape, massively better filtering."

## 2. PHY PROTECTION

**Current Design:** Each Ethernet port has a magnetic transformer (the small black box inside every RJ-45 jack) that provides galvanic isolation. Standard magnetics have a common-mode saturation rating of approximately 8 mA DC — sufficient for normal operation but insufficient for GIC.

**Proposed Design:** Add a nanocrystalline common-mode choke in series between the RJ-45 connector and the PHY magnetics. The choke presents high impedance (>2 kOhm) to quasi-DC GIC while passing differential-mode data signals with <0.3 dB insertion loss at 100 MHz (10GBASE-T frequency). Protects PHY silicon from GIC-induced common-mode currents propagating through Ethernet cable shields.

## 3. ENCLOSURE SHIELDING

**CSM-MX-2400 MXene Coating:** Applied to sheet metal enclosure interior surfaces. 40-60 dB attenuation from DC to 10 GHz. Creates a Faraday cage around switching fabric, ASICs, and control plane electronics. Applied as spray coating during sheet metal fabrication — adds ~$5-8 per enclosure in manufacturing cost.

## 4. PROTONIC BACKUP MODULE

**CSM-PC-5000-M (Miniature):** Single-width line card for ISR 4000/8000 routers. Integrated protonic transceiver. 10 Mbps data rate. 5,000 km range. Provides GIC-immune backup WAN connectivity.

---

**CLASSIFICATION: COMMERCIAL-IN-CONFIDENCE**
