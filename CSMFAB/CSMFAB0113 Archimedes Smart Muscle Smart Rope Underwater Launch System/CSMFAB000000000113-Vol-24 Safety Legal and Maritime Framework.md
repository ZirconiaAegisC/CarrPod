# CSMFAB000000000113-Vol-24
## Safety, Legal, and Maritime Framework: Operating in International Waters
**Series:** CSMFAB000000000113 | **Volume:** 24 of 29 | **June 2026**

---

## 1. Legal Framework: International Waters

### 1.1 UNCLOS Definition of International Waters

Per the United Nations Convention on the Law of the Sea (UNCLOS, 1982):
- Territorial sea: 12 nautical miles (22.2 km) from baseline
- Exclusive Economic Zone (EEZ): 200 nm (370 km) — resource rights only, freedom of navigation
- High Seas: beyond EEZ — no state jurisdiction

**AMSR-UBSCLS operating zone:** > 12 nm offshore = no territorial jurisdiction over the launch.
Operations in EEZ: legal under UNCLOS Article 58 (freedom of navigation + scientific research).

### 1.2 U.S. Regulatory Analysis

**FAA Space Launch Regulation:**
FAA AST (Office of Commercial Space Transportation) regulates under 14 CFR Part 450:
- Applies to: launches from U.S. territory, by U.S. citizens, or using U.S.-registered vehicles
- International waters with foreign-flagged vessels and non-U.S. citizens: FAA Part 450 likely inapplicable
- Recommendation: Use Marshall Islands- or Panama-flagged vessels for maximum legal clarity

**FCC Frequency Authorization:**
LoRa 915 MHz: Part 15 device — no individual license in U.S.
In international waters: ITU Radio Regulations govern; LoRa at 915 MHz requires coordination but no individual license for low-power devices.

### 1.3 NOTAM/NOTMAR Filing

Aviation safety: file NOTAM (Notice to Airmen) specifying:
- Launch location (lat/lon)
- Launch window (date/time UTC)
- Trajectory corridor (0-200 km altitude, ±50 km lateral)

Maritime safety: file NOTMAR (Notice to Mariners) via USCG or regional authority.

Both filings are voluntary for international operations but strongly recommended for safety and liability protection.

---

## 2. Safety Zones

### 2.1 Minimum Exclusion Zones

| Scale | H_apogee | Downrange (km) | Exclusion Radius | Aviation Alert Alt |
|---|---|---|---|---|
| Nano | 5 km | 10 | 200 m maritime, N/A aviation | Below FL180 — ATC notification |
| Micro | 25 km | 50 | 500 m maritime, 1 km aviation | Below FL650 (above airliners) |
| Small | 100 km | 150 | 2 km maritime, 5 km aviation | Above commercial airspace |
| Medium | 50 km | 300 | 5 km maritime, 10 km aviation | NOTAM required |
| Large | 20 km | 200 | 10 km maritime, 20 km aviation | NOTAM required |

### 2.2 Fail-Safe Hazards Analysis

Primary hazard: spear impact if trajectory fails.
Worst case: spear falls straight back to launch area.
Time of fall from apogee (100 km): t = sqrt(2h/g) = sqrt(20400/9.81) = 144 s
Warning time: 144 seconds from abort decision to impact — adequate for vessel evacuation.

Kinetic energy on impact (worst case, Scale 3, 10 kg spear falls 100 km):
KE = m*g*h = 10 * 9.81 * 100000 = 9.81 MJ (equivalent to 2.35 kg TNT)

**All personnel must maintain 2 km exclusion zone from projected fall zone during flight.**

---

## 3. Dive Safety

Divers attaching ropes to submerged spear:
- Maximum rope attachment depth: 5 m (diver safety limit for breath-hold; SCUBA for deeper)
- But rope attachment at 30m depth requires SCUBA with redundant equipment
- Alternative: ROV (Remotely Operated Vehicle) handles rope attachment at all depths
  - ROV: SeaDronics HD-1 (BFRP/aluminum hybrid, small enough for RIB deployment): ~$8,000-$15,000

---

## Citations (Vol 24)

- United Nations, UNCLOS — United Nations Convention on the Law of the Sea, 1982
- 14 CFR Part 450, FAA Launch and Reentry Regulations, 2021
- ITU Radio Regulations, Edition of 2020
- USCG, COMDTPUB P16502.5, "Procedures for Filing NOTMAR," 2022
- IMCA D 014, "Guidance for Diving Supervisors," 2016

*End Vol 24 | CSMFAB000000000113 | CSM Safe Pod Engineering Company | June 2026*
