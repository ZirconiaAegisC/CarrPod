# R48 — Reserve Setting Protocol: IBNR, Case Reserves, and Loss Development
## Insurance Domain Research | CSMSOPP000003

---

## Reserve Types

### Case Reserves
Set by adjusters for individual known claims. Reflects best estimate of ultimate settlement cost including indemnity, legal expense, and allocated loss adjustment expense.

### IBNR (Incurred But Not Reported)
Claims that occurred during the policy period but haven't been reported. Estimated using statistical methods (loss development triangles, Bornhuetter-Ferguson, chain-ladder).

### Bulk Reserves
Reserves set in aggregate for types of claims that are expected but not yet specifically identified. Common in long-tail lines.

## Loss Development Triangle

```
Accident    | Development Age (months)
Year        | 12    | 24    | 36    | 48    | 60    | 72
------------|-------|-------|-------|-------|-------|----
2020        | 1000  | 1200  | 1350  | 1400  | 1420  | 1430
2021        | 1100  | 1300  | 1450  | 1500  | 1520  |
2022        | 1050  | 1250  | 1400  |       |       |
2023        | 1200  | 1400  |       |       |       |
2024        | 1300  |       |       |       |       |
```

Each diagonal is the current valuation. The trend upward from left to right shows reserve development. The chain-ladder method projects ultimate losses by multiplying current cumulative losses by age-to-ultimate factors.

## Baker Street Reserve Adequacy Protocol

The counting engine:
1. Pulls all open case reserves
2. Pulls all closed claims with matching characteristics
3. Projects ultimate development for each open claim
4. Flags reserves deviating by >1 standard deviation from projected ultimate
5. Generates Reserve Adequacy Report

---

*End of R48 | Insurance Domain Research | CSMSOPP000003*
