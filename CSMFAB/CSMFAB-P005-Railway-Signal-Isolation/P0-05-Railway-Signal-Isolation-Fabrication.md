# P0-05: Railway Signal Isolation System — Complete Fabrication
## CSMFAB-P005 | IF-04 | Priority P0

**Function:** Dielectric rail joint isolators every 500m + GIC blocking devices on signaling + CarrPod battery backup at each substation, preventing GIC-induced signal failures that cause false red signals and collision risk.

| Component | Spec | Unit Cost |
|-----------|------|-----------|
| Dielectric rail joint isolator | ZTA ceramic insert, 150mm × 186mm, 500T compressive | $1,850/unit |
| GIC blocking device (signal circuit) | CNT-002 polymer conductor, 2.5mm², inline | $340/circuit |
| CarrPod battery backup | 100Ah LiFePO₄, MXene-shielded, off-grid 72hr | $4,200/unit |
| FEATHER mesh node | Track-side, 1 per km, Rogowski coil on rail | $1,847/unit |
| **Per-km cost (material)** | | **$8,237/km** |
| **Per-km cost (installed)** | | **$14,500/km** |

## US ROLLOUT (2,000 track-miles priority)
- 2,000 miles × $28,000/mile (installed) = $56M
- Priority: Northeast Corridor (456 miles, $12.8M), California Corridor (380 miles, $10.6M), Chicago Hub (290 miles, $8.1M)

## GIC FAILURE PREVENTION
Railway signaling uses track circuits — low-voltage DC through the rails to detect train presence. GIC entering the rails creates phantom voltage that mimics train occupation, causing signals to falsely display red (fail-safe) or — in degraded track circuit configurations — falsely display clear (dangerous). Post-1989 Hydro-Québec event, railway signaling failures were documented across the eastern US. The P0-05 system breaks the GIC path at 500m intervals, limiting induced voltage to <0.5V per segment (below track circuit detection threshold).
