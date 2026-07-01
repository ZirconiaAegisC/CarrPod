# CSMFAB000000000114 — Vol-22
# Component Procurement List and Cost Analysis
## Full BOM with Suppliers, Part Numbers, and Costs
**Carrington Storm Motors / Safe Pod Engineering Company**
**Version 1.0 | June 2026**

---

## Per-Unit Bill of Materials (BOM) — Target < $200 Per ASB-1

| Item | Component | Supplier | Part Number / Keyword | Qty | Unit Price | Total |
|---|---|---|---|---|---|---|
| 1 | Flight Controller SpeedyBee F405 Wing Mini | GetFPV, AliExpress | SpeedyBee F405 Wing Mini | 1 | $35 | $35 |
| 2 | GPS u-blox M8N module | Amazon, AliExpress | "u-blox M8N GPS drone" | 1 | $12 | $12 |
| 3 | LoRa module RFM95W 915 MHz | AliExpress, Mouser | RFM95W-915S2 | 1 | $6 | $6 |
| 4 | LiFePO₄ 2S 300mAh battery | GNB, Amazon | "GNB 2S 300mAh LiFePO4" | 1 | $14 | $14 |
| 5 | Brushless motor 1105 4000KV (optional) | GetFPV, AliExpress | "1105 4000KV motor" | 1 | $9 | $9 |
| 6 | ESC 10A BLHeli_S (optional) | AliExpress | "10A mini BLHeli_S ESC" | 1 | $5 | $5 |
| 7 | MPXV7002DP differential pressure sensor | Mouser, Digikey | MPXV7002DP | 4 | $4 | $16 |
| 8 | SHT31 temperature/humidity breakout | Adafruit, AliExpress | SHT31-D breakout | 1 | $5 | $5 |
| 9 | ATtiny85 DIP-8 microcontroller | Mouser, Amazon | ATTINY85-20PU | 1 | $1.50 | $1.50 |
| 10 | AO3400 N-MOSFET SOT-23 (×5 pack) | AliExpress, Mouser | AO3400 | 1 pack | $1 | $1 |
| 11 | SG90 micro servo | Amazon, AliExpress | SG90 9g micro servo | 1 | $2 | $2 |
| 12 | AMS1117-5.0 LDO regulator | AliExpress | AMS1117-5V | 2 | $0.50 | $1 |
| 13 | AMS1117-3.3 LDO regulator | AliExpress | AMS1117-3.3V | 2 | $0.50 | $1 |
| 14 | Nitinol SMA wire 0.1mm (1m minimum) | Dynalloy.com, Amazon | Flexinol 100 HT, or "0.1mm nitinol wire" | 1 m | $4 | $4 |
| 15 | JST-PH 2.0 connector set (10 pairs) | Amazon, AliExpress | "JST PH 2.0 connectors" | 1 set | $5 | $5 |
| 16 | XT30 connector pair | GetFPV, Amazon | XT30 male/female | 2 pair | $1 | $2 |
| 17 | 28AWG silicone wire (red/black/green 3m each) | Amazon | "28AWG silicone wire" | 1 set | $6 | $6 |
| 18 | M2 × 6mm stainless screws (20 pack) | Amazon, McMaster | M2 × 6mm SS pan head | 1 pack | $4 | $4 |
| 19 | M2 heat inserts (20 pack) | Amazon | "M2 heat set inserts 3mm OD" | 1 pack | $4 | $4 |
| 20 | M3 × 8mm hex screws (10 pack) | Amazon | M3 × 8mm SS hex socket | 1 pack | $2 | $2 |
| 21 | Type 316 SS ball swivel (pack of 5) | Amazon fishing | "SS ball bearing swivel size 8" | 1 pack | $3 | $3 |
| 22 | PEEK standoffs M3 × 5mm (pack of 10) | McMaster, AliExpress | "PEEK M3 standoff" | 1 pack | $4 | $4 |
| 23 | 0.5mm UHMWPE fishing line / tether (100m) | Amazon fishing | "Dyneema 0.5mm 30lb braid" | 1 spool | $8 | $8 |
| 24 | Carbon fiber tube 3mm OD (500mm) | CST Composites, Amazon | "3mm OD carbon fiber tube" | 1 | $3 | $3 |
| 25 | PETG filament 1kg | Amazon, Hatchbox | PETG 1.75mm 1kg | share spool | $7 | $7 |
| 26 | PLA filament for governor | Amazon | PLA 1.75mm | share spool | $3 | $3 |
| 27 | Silicone grommets M2 (pack of 20) | Amazon | "M2 vibration isolation grommet" | 1 pack | $3 | $3 |
| 28 | Polypropylene knotless mesh 30cm sample | Amazon fishing net | "knotless mesh polypropylene" | 1 | $5 | $5 |
| 29 | 6mm OD compression spring (pack of 10) | Amazon, local hardware | "6mm compression spring" | 1 pack | $4 | $4 |
| 30 | Miscellaneous (heat shrink, CA glue, flux, foam tape) | Local hardware | Various | 1 lot | $10 | $10 |
| | | | | | **TOTAL** | **~$186** |

**Under $200 per unit target: ACHIEVED at $186**

---

## Notes on Procurement

1. **AliExpress vs. Local:** AliExpress pricing is used for most components — delivery 2-4 weeks. For faster assembly, use Mouser, Digikey, or Amazon for critical components (FC, GPS, LoRa module).

2. **Bulk pricing:** For 10-unit swarm build, many components can be bulk ordered for 30-40% discount (especially SMA wire, connectors, screws).

3. **University surplus:** Cypress University makerspace may already have PETG/PLA filament, screws, breadboard supplies, and soldering equipment. Check the lab inventory before purchasing.

4. **Battery source:** GNB, Lumenier, or GenX all produce quality LiFePO₄ 2S packs. Search "2S LiFePO₄ 300mAh" on GetFPV or HobbyKing.

5. **SMA Wire critical source note:** Do NOT substitute standard steel wire or other alloys for the nitinol SMA wire. The shape memory effect is unique to nickel-titanium alloy. The Dynalloy Flexinol product line (dynalloy.com) is the most reliable source for the 0.1mm HT (High Temperature, 45-90°C) variety.

---

## Ground Station Cost (Separate — One Per Research Team)

| Item | Cost |
|---|---|
| Raspberry Pi 4B 2GB | $45 |
| LoRa gateway HAT (RAK831 or TTGO LoRa32) | $80 |
| 3dBi 915 MHz yagi antenna | $15 |
| 7" touchscreen display | $30 |
| USB power bank 10,000 mAh | $20 |
| Pelican 1150 case | $40 |
| 32GB microSD card | $8 |
| **Ground Station Total** | **~$238** |

---

*CSMFAB000000000114-Vol-22 | Version 1.0 | June 2026 | Carrington Storm Motors / Safe Pod Engineering Company*
