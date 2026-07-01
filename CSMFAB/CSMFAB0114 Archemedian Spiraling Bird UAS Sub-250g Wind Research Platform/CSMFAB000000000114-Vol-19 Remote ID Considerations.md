# CSMFAB000000000114 — Vol-19
# Remote ID Considerations
## Why the ASB-1 Is Legally Exempt at Under 249 Grams
**Carrington Storm Motors / Safe Pod Engineering Company**
**Version 1.0 | June 2026**

---

## Introduction: What Is Remote ID?

On September 16, 2023, the FAA mandate for **Standard Remote ID** (14 CFR Part 89) took full effect in the United States. Remote ID requires most drones to broadcast a continuous radio signal (similar to an aircraft transponder) that transmits:
- The drone's real-time position, altitude, velocity, and heading
- The operator's position (ground control point)
- A session identifier (timestamp-based serial)
- The drone's serial number or session ID

This data is broadcast on 2.4 GHz WiFi or Bluetooth 5.0 beacon protocol. Anyone nearby with a smartphone running the FAA's B4UFLY app or a dedicated Remote ID receiver can identify any Remote-ID-broadcasting drone in the area.

---

## Part 1: The Weight-Based Exemption

The Remote ID rule (14 CFR Part 89.105) applies to all UAS that are required to register under 14 CFR Part 48. And Part 48 registration is only required for UAS that weigh **more than 0.55 pounds (249.5 grams)** on takeoff.

The ASB-1 weighs 177g. **177g < 249g. The ASB-1 is below the registration threshold.**

**Chain of exemption:**
1. Below 249g → No registration required
2. No registration → No Remote ID requirement
3. Therefore: **ASB-1 does not need to broadcast Remote ID**

This is not a loophole — it is the explicit intent of the regulation. The 250g threshold was chosen specifically to exempt the large-and-growing category of tiny drones that pose minimal safety risk. The ASB-1 at 177g (a little over a quarter-pound) fits comfortably in this category.

---

## Part 2: Future-Proofing (If Rules Change)

FAA rules do evolve. If the weight threshold is lowered in the future (the EU C0 category is already at 250g), the ASB-1 can add Remote ID via a module add-on using the 22g margin from the mass reserve:

**Remote ID Module Option: Dronetag Mini**
- Mass: 8g
- Bluetooth 5 + WiFi dual broadcast
- FAA-accepted Declaration of Compliance (DoC)
- Battery: shared from main ASB-1 battery (< 1 mA draw)
- Cost: ~$60

If future rules require Remote ID at <249g, this module integrates into the electronics bay (existing 3D-07 has a spare cavity) without any redesign, using 8g of the remaining 72g mass margin.

---

## Part 3: Aeronautical Research Exemption (Backup)

Even if Remote ID were required (which it is not for <249g devices), the ASB-1 would qualify for an exemption under 14 CFR §89.120:

> "Operations for the purpose of aeronautical research or to show compliance with regulations."

Aircraft operating under this exemption do not need to broadcast Standard Remote ID. This is the same section cited in the altitude waiver (Vol-02). With the ASB-1 formally registered as a Cypress University aeronautical research project, this exemption provides a secondary regulatory shield.

---

## CHECKPOINT — Vol-19 Complete

Before proceeding, confirm:
- [ ] You know the weight exemption chain: 177g < 249g → No registration → No Remote ID
- [ ] You know the future upgrade path: Dronetag Mini 8g module for Remote ID if rules change
- [ ] You know the §89.120 aeronautical research exemption as a secondary shield

**Proceed to:** Vol-20 (Hand-Launch Protocol)

---

*CSMFAB000000000114-Vol-19 | Version 1.0 | June 2026 | Carrington Storm Motors / Safe Pod Engineering Company*
