# MITIGATION-DELTA-CALCULATOR.md
## CSMSOPP000003-V2-M10 | Loss Reduction Quantification for Underwriting Credits

---

## The Mitigation Delta Formula

```
Delta = Loss(unmitigated) - Loss(mitigated)
Delta% = Delta / Loss(unmitigated) x 100
Premium Credit = f(Delta%, Confidence Level, Implementation Verification)
```

## Calculation Workflow

### Step 1: Baseline Model
- Load unmitigated catastrophe model for client portfolio
- Scenario: G5 Carrington-level CME (Lloyd's Futureset parameters)
- Output: PML, AAL, return-period losses

### Step 2: Apply Hardening
- Map Aegis-C specifications (SE 148-165 dB, ZrB₂-SiC + MXene) to client assets
- Modify vulnerability curves per hardened asset classification
- Recalculate losses

### Step 3: Calculate Delta
```
Asset Class          | Pre-Mitigation     | Post-Mitigation    | Delta       | Delta%
---------------------|--------------------|--------------------|-------------|-------
Power Transformers   | $12,400,000        | $3,100,000         | $9,300,000  | 75.0%
Data Center          | $8,200,000         | $1,640,000         | $6,560,000  | 80.0%
Commercial Building  | $4,500,000         | $1,800,000         | $2,700,000  | 60.0%
Fleet Vehicles       | $2,100,000         | $1,050,000         | $1,050,000  | 50.0%
TOTAL                | $27,200,000        | $7,590,000         | $19,610,000 | 72.1%
```

### Step 4: Insurance Application
- **PML Reduction:** $19.61M → reinsurance attachment point can be lowered, saving ceded premium
- **AAL Reduction:** proportionally similar → pure premium decreases
- **Premium Credit:** base rate x (1 - Delta adjustment factor)
- **Hardening ROI:** (Premium Savings per Year - Hardening Amortized Cost) = NPV of investment

---

*End of M10 — Mitigation Delta Calculator | CSMSOPP000003-V2*
