
# TECHNICAL FRAMEWORK
## ACS-US-DOE-GRID-RESILIENCE-PROGRAM
### National GIC Vulnerability Assessment and Hardening Methodology

**CLASSIFICATION: COMMERCIAL-IN-CONFIDENCE / PRIVILEGED GOVERNMENT PROPOSAL**

---

## 1. NATIONAL GIC VULNERABILITY ASSESSMENT METHODOLOGY

**Phase A — Geoelectric Hazard Mapping:**
- Update and enhance the USGS National Geoelectric Hazard Map with higher resolution (1 km grid spacing vs. current 20 km)
- Integrate CSM's proprietary magnetometer network data (12 stations at key geomagnetic latitudes)
- Incorporate real-time SuperMAG ground magnetometer data for validation
- Produce NERC-region-specific GIC risk maps with transformer-level resolution
- Duration: Year 1, Cost: $125M

**Phase B — Transformer Vulnerability Scoring:**
- Multi-factor prioritization framework applied to all 55,000+ U.S. substation transformers:
  1. Geomagnetic latitude exposure (0-30 points)
  2. Soil resistivity at substation site (0-25 points)
  3. Transformer MVA rating and replacement difficulty (0-20 points)
  4. Customers served and critical infrastructure dependence (0-15 points)
  5. Transmission line orientation and length (0-10 points)
- Score range: 0-100. Score >65: Priority 1 (immediate hardening). Score 50-65: Priority 2 (5-year program). Score 35-49: Priority 3 (10-year program). Score <35: Monitor.
- Estimated Priority 1 transformers nationally: 800-1,200
- Duration: Years 1-2, Cost: $85M

**Phase C — Field Verification:**
- Phantom Robot (CSM-PR-900) deployment at 100 highest-scoring substations
- Automated soil resistivity mapping (Wenner 4-pin method)
- 6-month neutral current baseline monitoring at each site
- Live GIC injection testing to validate blocking performance design parameters
- Duration: Years 2-3, Cost: $180M

## 2. STANDARDIZED HARDENING KIT

**CSM-NBC-2400 Standard Kit (per transformer):**
- NBC unit (size-matched to transformer MVA: 50/100/200/500 MVA variants)
- Bypass thyristor and protection relays
- Modbus TCP/IP + protonic backup communications module
- Outdoor enclosure (NEMA 4X)
- Phantom Robot monitoring unit
- Installation toolkit (conduit, cable, grounding)
- Estimated cost per transformer: $1.2-3.4M (installed)

**Regional Hardening Centers:**
- 7 centers serving NERC regions (one per Regional Entity)
- Each center: NBC fabrication, testing, storage, and installation coordination
- Staffed by utility-embedded CSM technical teams (6-8 per center)
- Phantom Robot fleet management and data aggregation
- Estimated cost per center: $28M (capital) + $12M/year (operations)

## 3. OE-417 INTEGRATION

**GIC Monitoring Module for DOE OE-417:**
- New event type: "GMD-GIC Transformer Event"
- Real-time transformer neutral current telemetry from NBC-equipped sites
- Integration with NOAA SWPC alert system for automated event correlation
- Post-event transformer DGA data integration for damage assessment
- Public-facing dashboard: state-level GIC exposure maps during active GMD events
- Duration: Years 1-3, Cost: $45M

## 4. GRID RESILIENCE STATE FORMULA GRANTS INTEGRATION

- ACS/CSM provides standardized technical specifications for states to include GIC hardening in their IIJA Section 40101 grant applications
- Pre-approved "AEGIS-Ready" equipment list qualifies for formula grant funding
- State-level cost-share matching: federal 60-80%, utility 20-30%, state 0-10%
- Technical assistance to state energy offices for grant application preparation
- Duration: Years 1-5 (aligned with IIJA authorization period)

## 5. CSM PRODUCTS IN DOE PROGRAM

| Product | DOE Program Application |
|---------|------------------------|
| CSM-NBC-2400 | Universal transformer GIC blocking standard |
| CSM-PR-900 (Phantom Robot) | Automated substation monitoring fleet |
| CSM-MX-2400 Series | Substation control system PDU filtering |
| CSM-PC-5000 (Protonic) | GIC-immune grid control center backup communications |
| CSM-EWG-2000 | OE-417 integration and NOAA SWPC feed gateway |
| CSM-CF-700 (Charlemagne) | Coastal substation amphibious access for installation |

---

**CLASSIFICATION: COMMERCIAL-IN-CONFIDENCE / PRIVILEGED GOVERNMENT PROPOSAL**
