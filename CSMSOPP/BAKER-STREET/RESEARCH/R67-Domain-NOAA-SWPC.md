# R67 — Space Weather Prediction Center: NOAA Data Integration
## Domain Knowledge Research | CSMSOPP000003

---

## NOAA SWPC (Space Weather Prediction Center)

### Function
24/7 monitoring and forecasting of space weather. Issues watches, warnings, and alerts for geomagnetic storms, solar radiation storms, and radio blackouts.

### Scale Classifications
| Scale | G-scale | Kp | Frequency per Cycle | Effects |
|-------|---------|-------|---------------------|---------|
| Minor | G1 | 5 | 1,700 | Weak power grid fluctuations |
| Moderate | G2 | 6 | 600 | Transformer heating; HF radio degradation |
| Strong | G3 | 7 | 200 | Voltage corrections; satellite orbit issues |
| Severe | G4 | 8 | 100 | Widespread voltage problems; satellite surface charging |
| Extreme | G5 | 9 | 4 | Grid collapse; transformer damage; communications blackout |

### Watch/Warning Timeline
- **CME Detection:** 1-4 days before arrival (coronagraph imagery)
- **Geomagnetic Storm Watch:** issued when CME is Earth-directed
- **Geomagnetic Storm Warning:** issued when CME arrival is imminent (<24 hours)
- **Alert:** issued when geomagnetic storm thresholds are crossed at Earth

## Insurance Integration

### The SWPC Data Feed
The Baker Street agent integrates SWPC alerts into:
1. **Underwriting:** G4+ watch triggers exposure review for new business in affected LOBs
2. **Claims:** G3+ alert triggers CAVALRY preparedness (R09)
3. **Reinsurance:** G4+ watch triggers treaty limit review
4. **Client Advisory:** G3+ alert triggers client communication recommending system shutdown/isolation

### January 2026 Precedent
The G4 storm watch (January 2026) explicitly triggered insurer/broker alerts. The Baker Street agent would have issued client advisories 72 hours before the watch, not during it.

---

*End of R67 | Domain Knowledge Research | CSMSOPP000003*
