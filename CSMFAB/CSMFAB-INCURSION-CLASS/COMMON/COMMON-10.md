# INCURSION COMMON-10: Safety and Fail-Safe Protocols
## CSMFAB-INCURSION | Common Architecture | All 5 Vessel Classes

Geofence: user-defined boundary, auto-return at 80% limit. Low battery: return-to-home at 20% SOC, emergency beacon at 10%. Lost comms: loiter 5 min, then return-to-home via GPS breadcrumb. Hydrofoil jam: retract, surface-drive home on screws alone. Flood detection: emergency ballast blow + surface beacon + FEATHER distress message.

Applies to: I-SCOUT, I-COURIER, I-SURVEYOR, I-GUARDIAN, I-DEEP. Commonality ensures 70% parts sharing across fleet.
