# REINSURANCE-TREATY-ANALYZER.md
## CSMSOPP000003-V2-M06 | Treaty Structure, Gap Analysis, Optimization

---

## Treaty Analysis Workflow

### Step 1: Structure Mapping
- Treaty type identified: proportional (QS, surplus) or non-proportional (XOL, aggregate)
- Layers mapped: retention, limit, reinstatements, premium
- Exclusions catalogued
- Special acceptances noted

### Step 2: Exposure Adequacy Check
- PML scenario run against treaty limits
- Gap identified: PML - treaty limit = uncovered exposure
- Aggregate limit test: multi-event scenario vs. aggregate limit
- Reinstatement sufficiency: are reinstatements adequate for realistic event frequency?

### Step 3: Reinsurer Credit Analysis
- Reinsurer rating (AM Best, S&P, Moody's)
- Collateral requirements (if unauthorized/alien reinsurer)
- Recoverable aging: outstanding >90 days flagged
- Dispute history: any contested recoverables

### Step 4: Mitigation Delta Integration
- Pre-mitigation PML: $X (basis for current treaty)
- Post-mitigation PML: $X' (with Aegis-C hardening)
- Treaty optimization: if PML' < current attachment, reduce reinsurance purchase
- Savings: ceded premium reduction - hardening cost

### Step 5: Facultative Needs Assessment
- Risks exceeding treaty capacity
- Risks excluded from treaty
- Facultative placement support: submission preparation, market identification

## The Output: Reinsurance Gap Analysis

```
TREATY GAP ANALYSIS — [Client Name]
DATE: [ISO 8601]

1. CURRENT STRUCTURE
2. GAPS IDENTIFIED
3. RECOMMENDATIONS
4. FINANCIAL IMPACT
5. NEXT RENEWAL CHECKPOINT
```

---

*End of M06 — Reinsurance Treaty Analyzer | CSMSOPP000003-V2*
