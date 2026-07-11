# R47 — Premium Calculation Architecture: Rate Making and Classification
## Insurance Domain Research | CSMSOPP000003

---

## The Rating Formula

### Base Rate Calculation
```
Pure Premium = (Loss + LAE) / Exposure Units
Expense Provision = (UW Expenses + General Expenses + Premium Tax + Commission) / Premium
Profit & Contingency Provision = Target Underwriting Profit Margin
Indicated Rate = Pure Premium / (1 - Expense Provision - Profit Provision)
```

### Rating Variables (Common to Most LOBs)
| Category | Examples |
|----------|----------|
| Exposure Base | Payroll (WC), Sales (GL), Vehicle Count (Auto), Building Value (Property) |
| Classification | Industry code, construction type, protection class, territory |
| Experience Modification | Loss history relative to class average |
| Schedule Credits/Debits | Safety programs, management quality, maintenance |
| Deductible | Risk retention by insured; premium credit varies by deductible size |
| Limits | Increased limits factors; higher limits = higher premium (sub-linear) |
| Territory | Geographic risk variation (hurricane zones, earthquake zones, crime rates) |

### Premium Audit
For policies with variable exposure bases (payroll, sales), premium is estimated at inception and adjusted at audit:
- **Deposit Premium:** Estimated premium paid at inception
- **Audit Premium:** Actual premium based on audited exposure
- **Additional/Return Premium:** Difference paid or refunded after audit

### Baker Street Premium Architecture
The agent's counting engine (R12) processes premium calculations across all policies simultaneously. Rate adequacy is monitored continuously, not just at renewal.

---

*End of R47 | Insurance Domain Research | CSMSOPP000003*
