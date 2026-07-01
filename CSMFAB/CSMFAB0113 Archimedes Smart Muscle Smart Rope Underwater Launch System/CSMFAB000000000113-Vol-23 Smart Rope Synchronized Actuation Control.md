# CSMFAB000000000113-Vol-23
## Smart Rope Synchronized Actuation: Control Architecture and Timing
**Series:** CSMFAB000000000113 | **Volume:** 23 of 29 | **June 2026**

---

## 1. Timing Requirements Analysis

### 1.1 Synchronization Tolerance

The ropes must fire within a timing window such that the spear doesn't experience destabilizing asymmetric forces.

Maximum asymmetric force before de-stabilization:
If one rope fires 5 ms late, it delivers zero force when others deliver 50,040 N each:
F_asymm = 50,040 N (missing rope contributes no vertical force for that period)
Resulting lateral impulse: J_lateral = 50,040 * sin(11.3°) * 0.005 = 490 N·s

Lateral velocity imparted: v_lateral = 490/2 = 245 m/s — catastrophic!

**Critical requirement:** All ropes must fire within **±0.2 ms** of each other.

### 1.2 LoRa Latency Analysis

LoRa 915 MHz speed of light propagation at R=6m:
```
t_prop = 6 / 3e8 = 20 ns
```

LoRa preamble + symbol processing latency: ~5 ms per device.

**Problem:** 5 ms >> 0.2 ms requirement!

**Solution:** **Pre-load armed state in all rope actuators.**
Protocol:
1. T = -5s: Master transmits ARMED command (all ropes load firing sequence into RAM)
2. T = 0s: Master transmits FIRE pulse (bare 1-byte LoRa packet — minimum latency ~2ms)
3. Each rope fires at local clock tick when FIRE received — local crystal oscillators pre-synchronized
4. Crystal oscillator sync precision: ±0.1 ms (from GPS-disciplined time standard during pre-sync)

**Net timing jitter: ±0.1 ms — meets ±0.2 ms requirement.**

### 1.3 Backup: Optical Fiber Trigger

For maximum precision, the master vessel runs PMMA optical fiber (CSMFAB000000000013) radially to each slave vessel — 6 m per run.

Speed of light in PMMA fiber (n=1.49):
```
t_prop = L / (c/n) = 6 / (2e8) = 30 ns
```

Trigger jitter: < 1 ns (electronic precision of optical pulse)
**Optical trigger achieves <1 ns synchronization — far exceeds requirement.**

For hobbyist scale: 6 m of PMMA POF at $0.25/m = $1.50 per rope — trivially cheap.

---

## 2. Control Architecture Schematic

```
MASTER VESSEL
  [FBG optical sensors] → [DSP control unit] → [LoRa transmitter]
                                                       |
                          ┌────────────────────────────┤
                          |              |             |
                      VESSEL 2       VESSEL 3      VESSEL 4
                     [LoRa RX]      [LoRa RX]     [LoRa RX]
                     [LoRa arm]     [LoRa arm]    [LoRa arm]
                          |
                    [BFRP rope spool]
                    [KNbO3 actuator]
                    [ZrO2 release pin]
                    [UHMWPE fiber]
                          |
                    (rope to spear)
```

All signal paths: PMMA optical fiber or LoRa 915 MHz — zero metallic wire conductors.

---

## 3. Fail-Safe Design

**What if one vessel fails to fire?**

For n=6, any 1 failure: 5 ropes fire symmetrically around center... except now there's a gap at one vertex.
With 5-rope firing:
- Total vertical impulse: 5 * J_rope * eta_v = 83.3% of nominal
- Lateral impulse: F_lateral = J_rope * sin(pi/6) = 0.5 * J_rope (from vector analysis)
- If J_rope = 1001 N·s: lateral impulse = 500 N·s → lateral v = 250 m/s

**5/6 firing is catastrophic.** Fail-safe protocol:

- If any vessel fails to report ARMED within T=-1s: launch ABORT
- Emergency ABORT: all vessels transmit RELEASE command — ropes disconnect harmlessly
- Spear (positively buoyant at surface) can be recovered within 15 minutes

**5-vessel abort with n=6:** possible if configuration rebalanced to pentagon (5-fold symmetric) but this requires vessel repositioning — simpler to abort.

---

## Citations (Vol 23)

- LoRa Alliance, "LoRaWAN Link Layer Specification," v1.0.4, 2020
- Heo, M., Kim, N., Seo, T., "Survey of Clock Synchronization in Wireless Sensor Networks," Sensors 2019
- CSMFAB000000000013 V2.0, PMMA optical fiber data, CSM 2026
- CSMFAB000000000022 V2.0, LoRa daisy-chain synchronization, CSM 2026

*End Vol 23 | CSMFAB000000000113 | CSM Safe Pod Engineering Company | June 2026*
