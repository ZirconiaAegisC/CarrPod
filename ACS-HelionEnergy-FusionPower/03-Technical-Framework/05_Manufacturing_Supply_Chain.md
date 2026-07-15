# Manufacturing Scale & Supply Chain

**Date:** 15 July 2026
**Classification:** Corporate Dossier — Section 03.5

---

## Overview

Helion Energy's fusion architecture demands manufacturing capabilities that do not exist in the commercial supply chain. The company's decision to vertically integrate production of two mission-critical components — high-energy-density capacitors and ultra-high-pressure ceramics — is both a technical necessity and a strategic competitive moat. This section analyzes the manufacturing requirements, supply chain dependencies, and scaling challenges that will determine Helion's ability to transition from prototype to commercial production.

---

## In-House Manufacturing

### High-Energy-Density Capacitors

| Parameter | Specification |
|-----------|---------------|
| Polaris Energy Storage | 50 megajoules (total capacitor bank) |
| Function | Pulsed power delivery for magnetic compression |
| Duty Cycle | Repeated charge-discharge at pulse repetition rate |
| Manufacturing Location | Helion internal facility |
| Supply Chain Dependency | Raw materials (dielectric films, conductors) sourced externally; assembly in-house |

**Technical Requirements:**
- Capacitor banks must deliver megajoules of energy in sub-millisecond discharge pulses.
- Dielectric materials must withstand millions of charge-discharge cycles without significant degradation.
- Energy density must be sufficient to fit within the plant footprint while delivering the required peak power.
- Failure modes (dielectric breakdown, thermal runaway) must be manageable without cascading system failure.

**Strategic Rationale for In-House Production:**
- No commercial off-the-shelf capacitor meets the combined requirements of energy density, repetition rate, and lifetime.
- Capacitor design is intimately coupled with plasma physics — compression waveform shaping requires proprietary knowledge of the magnetic coil load.
- In-house production protects intellectual property and prevents reverse-engineering by potential competitors.

### Ultra-High-Pressure Ceramics

| Parameter | Specification |
|-----------|---------------|
| Application | Vacuum vessel insulators, compression coil standoffs, first-wall components |
| Key Requirements | Dielectric strength, radiation resistance, thermal shock tolerance, ultra-high-vacuum compatibility |
| Manufacturing Location | Helion internal facility |

**Technical Requirements:**
- Ceramics must withstand pulsed mechanical and thermal stresses during each compression cycle.
- Dielectric breakdown under pulsed high-voltage conditions must be eliminated.
- Outgassing rates must be compatible with ultra-high-vacuum conditions required for plasma purity.
- Neutron activation (from D-D side reactions) must be manageable for maintenance and eventual disposal.

**Strategic Rationale for In-House Production:**
- Commercially available ceramics are optimized for steady-state industrial applications, not pulsed fusion environments.
- Custom formulations allow Helion to optimize for the specific stress profile of FRC compression.
- Supply chain control eliminates dependency on third-party vendors whose production priorities may not align with Helion's schedule.

---

## External Supply Chain Dependencies

### Helium-3

| Parameter | Status |
|-----------|--------|
| Commercial Source | None currently operational |
| Proposed Sources | Lunar regolith mining (long-term); tritium decay (medium-term); natural gas extraction (near-term speculative) |
| Current Inventory | Not publicly disclosed |
| Criticality | High — D-He3 commercial fuel cycle depends on He3 availability |

Helium-3 supply is the single largest unresolved supply chain question for Helion's commercial architecture. While D-T operations (for which tritium is available through established DOE supply chains) are viable for testing and initial operations, the commercial value proposition — aneutronic fusion with direct energy conversion — depends on D-He3 fuel.

**Tritium Decay Pathway:** Tritium (half-life 12.3 years) decays to He3. A tritium inventory of sufficient scale could produce He3 as a decay product, but the production rate is governed by the tritium inventory and the decay constant — a slow process that requires large tritium stockpiles to produce meaningful He3 quantities.

**Natural Gas Extraction:** Helium-3 exists in trace quantities in natural gas, but extraction at commercially relevant scale has not been demonstrated.

**Lunar Mining:** The lunar regolith contains He3 implanted by solar wind over geological timescales. Multiple entities have proposed lunar He3 mining, but no mission has demonstrated extraction and return. This pathway is not viable for Helion's 2028–2035 timeframe.

### Tritium

| Parameter | Status |
|-----------|--------|
| Commercial Source | U.S. Department of Energy (DOE) tritium supply chain |
| Availability | Limited but sufficient for R&D and initial D-T operations |
| RML Authorization | Covered under Washington DOH RML (June 2026) |
| Criticality | Medium — required for D-T validation; not required for commercial D-He3 operation |

### Deuterium

Deuterium is abundant (0.0156% of natural hydrogen) and readily extracted from seawater. Deuterium supply is not a constraint.

### Specialized Materials

| Material | Application | Supply Risk |
|----------|-------------|-------------|
| High-purity beryllium | First-wall / plasma-facing components | Medium (limited global suppliers) |
| Superconducting wire | Magnetic compression coils | Low-Medium (if superconducting coils are used; Helion may use copper) |
| Dielectric films | Capacitor manufacturing | Medium (specialized polymer films) |
| High-purity alumina / zirconia | Ceramic components | Low (mature supply chain) |
| Electrical steel | Magnetic core laminations | Low |

---

## Manufacturing Scale-Up Pathway

### Phase 1: Prototype (Current)
- Polaris capacitor banks and ceramics produced in R&D quantities.
- Manual and semi-automated manufacturing processes.
- Quality control focused on physics performance, not production economics.

### Phase 2: Orion First-of-Kind (2026–2028)
- Capacitor production scaled to ~50 MW plant requirements.
- Ceramics production for first commercial generator.
- Process documentation, repeatability, and yield optimization.
- Supply chain qualification for raw materials.

### Phase 3: Serial Production (2028+)
- Standardized capacitor and ceramics production lines.
- Multiple parallel production cells for Nucor-scale (500 MW) deployment.
- Cost reduction through learning curve, automation, and economies of scale.
- Potential spin-off of capacitor/ceramics manufacturing as a standalone business unit.

---

## Workforce Requirements

| Skill Category | Description | Scarcity |
|----------------|-------------|----------|
| Pulsed power engineering | High-voltage, high-energy capacitor system design | High |
| Plasma diagnostics | Instrumentation for FRC plasma characterization | High |
| Ceramics engineering | Ultra-high-purity ceramic formulation and processing | Medium-High |
| Tritium handling | Licensed radioactive material handling and accounting | Medium |
| High-vacuum systems | Large-volume ultra-high-vacuum engineering | Medium |
| Power electronics | Grid interconnection and power conditioning | Low-Medium |

---

## Competitive Implications

Helion's vertical integration strategy creates significant barriers to entry:

1. **Proprietary capacitor technology** embedded in the compression cycle is not commercially available; a competitor would need to develop equivalent pulsed power systems independently.
2. **Ceramic formulations** optimized for FRC compression conditions represent trade secrets — performance data accumulated over seven prototype generations cannot be replicated without equivalent experimental history.
3. **Manufacturing learning curve** for capacitor and ceramics production accrues exclusively to Helion, widening the gap with any potential new entrant pursuing a similar technical approach.
4. **Supply chain control** insulates Helion from vendor qualification timelines that would delay competitors dependent on third-party advanced manufacturing capacity.

Conversely, vertical integration concentrates technical risk: a quality failure in capacitor or ceramics production simultaneously threatens the physics program, the construction schedule, and the financial position — there is no external vendor to absorb schedule or cost overruns.
