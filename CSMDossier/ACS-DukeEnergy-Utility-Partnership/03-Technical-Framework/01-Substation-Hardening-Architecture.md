
# TECHNICAL FRAMEWORK
## ACS-DUKEENERGY-UTILITY-PARTNERSHIP
### Substation GIC Hardening Architecture for Transmission Utilities

**CLASSIFICATION: COMMERCIAL-IN-CONFIDENCE**

## 1. NBC DEPLOYMENT ARCHITECTURE

**Installation per Substation:**
- One CSM-NBC-2400 per transformer neutral connection
- Outdoor enclosure (NEMA 4X), adjacent to transformer
- 8-12 hour planned outage for installation
- Post-installation GIC injection testing using Phantom Robot (CSM-PR-900)
- Integration with substation RTU via Modbus TCP/IP for SCADA monitoring

**Substation Prioritization Framework:**
1. Geomagnetic latitude score (0-30 points, higher latitude = higher score)
2. Soil resistivity score (0-25 points, igneous/metamorphic >1,000 ohm-m = max)
3. Transformer criticality score (0-20 points, customer count + replacement difficulty)
4. Transmission line orientation and length (0-15 points, E-W lines > 300 km = max)
5. Regional stability contribution (0-10 points, voltage support role)

## 2. SCADA INTEGRATION

CSM-EWG-2000 gateway integrates with Duke Energy's:
- EMS (Energy Management System) — real-time transformer neutral current display
- ADMS (Advanced Distribution Management System) — GIC detection alarms
- OMS (Outage Management System) — automated GIC-related outage correlation

**Space Weather Feed:** DSCOVR/NOAA SWPC integration via CSM's telemetry gateway. 15-60 minute warning before CME shockwave arrival.

## 3. MUTUAL AID FRAMEWORK

During GMD events, Duke's hardened substations become "voltage anchors" for the regional grid. CSM's system provides automated data feeds to neighboring utilities via NERCnet RCIS (Reliability Coordinator Information System), enabling coordinated GMD response across control areas.

## 4. CSM PRODUCTS

| Product | Application |
|---------|------------|
| CSM-NBC-2400 | Transformer GIC blocking |
| CSM-PR-900 (Phantom Robot) | Substation monitoring, soil mapping |
| CSM-EWG-2000 | Early warning and SCADA integration |
| CSM-MX-2400 Series | Substation control system PDU filtering |

---

**CLASSIFICATION: COMMERCIAL-IN-CONFIDENCE**
