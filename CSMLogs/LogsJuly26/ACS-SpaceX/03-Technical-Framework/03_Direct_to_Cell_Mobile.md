# Framework 3: Direct-to-Cell and Mobile Connectivity

**Classification:** ACS Proprietary — Technical Framework
**Domain:** Mobile Satellite Service (MSS), Supplemental Coverage from Space (SCS), LTE/NR NTN

---

## 5.1 Service Architecture

### 5.1.1 Direct-to-Cell Overview

Starlink Direct-to-Cell provides LTE-compatible connectivity to unmodified, standard mobile handsets using Starlink V2 Mini satellites equipped with a dedicated eNodeB payload operating in the SCS (Supplemental Coverage from Space) configuration. The service eliminates the dead-zone problem by extending terrestrial mobile network operator (MNO) coverage via space-based infrastructure, requiring no specialized user equipment.

As of Q2 2026, Direct-to-Cell reached **7.4 million monthly unique devices** across partner MNO networks, establishing the service as the largest space-based direct-to-handset connectivity platform globally.

### 5.1.2 Technical Specifications

| Parameter | Specification |
|---|---|
| Frequency Band | 1910–1915 MHz / 1990–1995 MHz (PCS G-Block, US) |
| Channel Bandwidth | 1.4 MHz / 3 MHz / 5 MHz NR |
| Modulation | QPSK, 16QAM (LTE); QPSK (initial NR) |
| Satellite Altitude | ~530 km (LEO) |
| Beam Footprint | ~25–50 km diameter per beam |
| Satellite eNodeB | Integrated LTE/NR baseband, phased array |
| Max Uplink Power | 23 dBm (handset typical) |
| Latency | <40 ms (one-way satellite hop) |
| Throughput Per Beam | ~1–3 Mbps (shared); ~6–12 Mbps per cell aggregate |
| Handoff | Inter-satellite seamless handover via ISL mesh |

### 5.1.3 Regulatory Framework

The FCC adopted the Supplemental Coverage from Space (SCS) regulatory framework in March 2024 (FCC 24-26), authorizing satellite operators to use terrestrial mobile spectrum — under lease agreements with licensed MNOs — for space-to-handset direct connectivity. SpaceX holds the first SCS authorization and has partnered with T-Mobile (USA), Rogers (Canada), Optus (Australia), KDDI (Japan), One NZ (New Zealand), Salt (Switzerland), and entel (Chile/Peru), among others.

## 5.2 Deployment Status

### 5.2.1 Current Capabilities

| Phase | Status | Capability |
|---|---|---|
| Phase 1 — SMS | **Operational** (Jan 2025) | Two-way SMS globally, emergency alerts |
| Phase 2 — Voice/Data | **Operational** (Mar 2026) | Voice calls, low-bandwidth data (<4 Mbps) |
| Phase 3 — Broadband | **In Deployment** (2026) | V2 Mobile satellites; 5G NR NTN targeting 2027 |

### 5.2.2 Satellites with D2C Payload

As of July 2026, approximately 836 V2 Mini satellites incorporate the Direct-to-Cell payload. Each satellite supports multiple simultaneous beams with non-contiguous spectrum aggregation, allowing a single spacecraft to serve multiple MNO partners across different regulatory domains.

### 5.2.3 Device Compatibility

Compatible with all LTE Cat-M1 and NB-IoT capable handsets manufactured after 2019, covering approximately 98% of active smartphones globally. No firmware update, application installation, or hardware modification is required on the user device. The network presents to the handset as a standard terrestrial LTE PLMN with MCC/MNC values assigned per partner MNO.

## 5.3 Commercial Model

### 5.3.1 MNO Partnership Structure

The Direct-to-Cell business model is wholesale: SpaceX provides the orbital network infrastructure, and partner MNOs resell connectivity to their subscribers. Revenue is structured as a capacity lease or revenue share, typically:

- **Fixed capacity lease:** MNO pays monthly for a dedicated beam allocation over a defined geographic area
- **Revenue share:** MNO shares 25–40% of incremental subscriber revenue attributed to satellite coverage
- **Tiered usage:** Pay-as-you-go capacity for overflow and disaster response scenarios

### 5.3.2 Addressable Market

| Market Segment | Addressable Devices | Service Penetration (2030E) |
|---|---|---|
| Rural dead-zone coverage (developed markets) | ~200M | 15–25% |
| Underserved emerging markets | ~1.5B | 5–12% |
| Maritime / offshore workers | ~15M | 40–60% |
| Aviation (over-ocean corridors) | ~25M annual fliers | 30–50% |
| IoT / remote monitoring | ~3B devices | 2–5% |
| Emergency / disaster response | Ad-hoc | N/A (elastic) |

### 5.3.3 Revenue Contribution

Direct-to-Cell revenue is embedded within Starlink's $11.4B segment revenue for FY2025 but is estimated at approximately **$800M–1.2B** on a standalone basis, making it one of the fastest-growing sub-segments within Starlink. Q1 2026 run-rate suggests a potential **$2.5–3.5B** annualized contribution.

## 5.4 Technology Evolution: V2 Mobile and 5G NR NTN

### 5.4.1 V2 Mobile Satellite

The next-generation D2C satellite — designated V2 Mobile — is purpose-built for broadband direct-to-handset services rather than the V2 Mini's SMS-and-voice-first architecture. Key enhancements:

- **Larger antenna aperture:** 25 m² phased array (vs. 5 m² on V2 Mini)
- **Multi-band support:** Extension into 2 GHz S-band and mid-band (future)
- **5G NR NTN (Non-Terrestrial Network) compliant:** 3GPP Release 18/19 compatibility
- **Beam count:** 60+ simultaneous beams per satellite
- **Per-beam throughput:** 15–30 Mbps shared
- **Aggregate capacity:** ~1 Gbps per satellite D2C payload

### 5.4.2 5G Quality by 2027

SpaceX has publicly stated that V2 Mobile satellites, launching on Starship beginning in 2027, will deliver **5G-quality broadband** directly to handsets, achieving 10–50 Mbps per device with latency under 20 ms. This capability fundamentally blurs the line between satellite and terrestrial mobile broadband, positioning Starlink D2C as a structurally disruptive competitive force against terrestrial-only MNOs in low-density geographies.

## 5.5 Competitive Landscape: Direct-to-Handset

| Provider | Constellation | Spectrum | Peak Throughput | Status |
|---|---|---|---|---|
| Starlink (SpaceX) | V2 Mini / V2 Mobile | PCS G-Block (licensed) | ~6 Mbps/cell | Operational (SMS + Voice + Data) |
| AST SpaceMobile | BlueWalker 3 / Block 1 | 850 MHz cellular | ~14 Mbps (tested) | 5 satellites; commercial launch 2026 |
| Lynk Global | Lynk Tower | MSS L-band | ~1 Mbps | ~10 satellites; SMS operational |
| Apple/Globalstar | Globalstar Gen2 | MSS L/S-band | ~1 Mbps | Emergency SOS operational |
| T-Mobile/Starlink | V2 Mini | PCS (T-Mobile lease) | ~6 Mbps/cell | Operational |
| Iridium | Iridium NEXT | MSS L-band | ~128 kbps | Operational (narrowband) |

---

*Direct-to-Cell specifications from FCC SCS filings (IBFS SES-LIC-2022), 3GPP TR 38.821 (NTN), and SpaceX public statements.*
