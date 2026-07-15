# Arris Composites — Manufacturing Automation & Scale (Part 1)

**Analyst:** CSM Research  
**Date:** 15 July 2026  
**Classification:** Proprietary Research

---

## The Automation Imperative

Arris Composites' Additive Molding technology positions its value proposition around a specific claim: replacing 30 or more manual prepreg layup steps with a single automated process. This claim is central to the company's narrative and must be evaluated against the reality of what automation can and cannot achieve in composites manufacturing.

### The Status Quo: Manual Prepreg Layup

To understand the automation opportunity, one must first understand the incumbent process. Manufacturing a structural carbon fiber component via manual prepreg layup involves a sequence of operations that has remained fundamentally unchanged for decades:

1. **Material retrieval.** Prepreg rolls are removed from freezer storage (-18°C) and allowed to thaw to room temperature. Out-time — the cumulative time the material spends at room temperature before cure — is tracked because the epoxy resin advances chemically at room temperature, and prepreg with excessive out-time must be discarded.

2. **Cutting.** Individual plies are cut from the prepreg roll using either a computer-controlled cutting table (Gerber cutter) or manual templates and a knife. Each ply has a specific orientation relative to the part coordinate system — 0°, 90°, +45°, -45° — and must be labeled and kitted in sequence.

3. **Layup.** A technician places each ply onto the tool in the prescribed sequence and orientation, using hand pressure and occasionally a heat gun to tack the ply in place. Each ply must be smoothed to remove wrinkles and ensure conformity to the tool surface. For complex geometries, plies may need to be slit or darted to conform to compound curvatures.

4. **Debulking.** Periodically during layup — typically every 3-5 plies — the layup is vacuum-bagged and subjected to compaction pressure to remove trapped air and consolidate the laminate. Each debulk cycle adds 15-30 minutes.

5. **Bagging.** The completed layup is covered with release film, breather fabric, and a vacuum bag, sealed at the edges, and connected to a vacuum source. Leaks in the bag are detected and repaired.

6. **Autoclave cure.** The bagged layup is placed in an autoclave and subjected to a temperature and pressure cycle: typically 2-4 hours at 120-180°C and 6-7 bar pressure. The autoclave itself is a capital-intensive asset costing $1-5 million, and autoclave capacity is often the bottleneck in composite production facilities.

7. **Demolding and finishing.** The cured part is removed from the tool, the bagging materials are stripped, and the part edges are trimmed, drilled, and inspected.

This sequence, for a moderately complex part with 20-30 plies, requires 4-8 hours of total processing time, of which 80% or more is labor. Labor cost, labor variability, and labor availability are the binding constraints on production capacity and part cost.

### The Additive Molding Alternative

Arris's process compresses this entire sequence into a single manufacturing cell. The operator — or an automated material handling system — loads fiber spools and thermoplastic resin feedstock. The cell handles the rest: fiber alignment, deposition, compression molding, and part ejection. The cycle time, depending on part complexity and thickness, ranges from 90 seconds to 5 minutes rather than 4-8 hours.

The labor content of an Additive Molding part is minimal: one operator can oversee multiple cells, with the primary tasks being material replenishment, tooling changeover, and quality inspection. The direct labor cost per part — a dominant factor in manual prepreg economics — becomes a minor component of total cost, shifting the cost structure toward material, depreciation, and overhead.

### Automation and Quality Consistency

Beyond labor cost reduction, automation addresses a more fundamental issue in composites manufacturing: process variability. Manual layup is inherently variable. Different technicians have different techniques, and even a single technician's work varies over the course of a shift as fatigue sets in. Ply positioning accuracy, compaction pressure, and the presence of foreign object debris in the laminate all vary from part to part.

This variability forces conservative design: the part must be designed to meet structural requirements with the worst-case combination of manufacturing variability, not the average. Safety factors absorb this conservatism, adding weight that negates some of the composite advantage over metal.

Additive Molding, by removing the operator from direct contact with the part, sharply reduces process variability. Every part is produced by the same software-controlled motion system, under the same thermal and pressure conditions. The result is a narrower distribution of mechanical properties, which enables a reduction in design safety factors and a corresponding reduction in part weight — a "virtual" weight saving that adds to the direct weight saving from composite material substitution.

## Production Cell Economics

The Additive Molding production cell is the economic atom of the Arris manufacturing system. Understanding the capital cost, throughput, and operating cost of a single cell is essential for modeling the company's financial trajectory.

### Cell Architecture

Each Additive Molding cell integrates three subsystems: the fiber placement system (creels, tensioners, end-effector), the compression molding press (heated platens, hydraulic system), and the control system (motion control, thermal management, process monitoring). The integration of these subsystems into a single automated unit distinguishes the cell from separate fiber placement and compression molding stations that require part transfer between operations.

The cell is designed to be modular: multiple cells can be installed in parallel to scale production capacity. This modularity is important for manufacturing strategy because it allows capacity to be added incrementally rather than in large, lumpy investments. A factory can start with 2-3 cells serving prototype and low-rate production and add cells as customer demand materializes.

### Capital Expenditure Estimates

Arris has not publicly disclosed the capital cost of an Additive Molding cell. Reasonable estimates can be constructed by benchmarking against comparable manufacturing equipment. An automated fiber placement machine designed for small-to-medium parts costs $500,000 to $1.5 million. A high-speed compression molding press with heated platens costs $200,000 to $500,000. The integrated software and control system adds $100,000 to $300,000.

A conservative estimate for a complete Additive Molding cell is in the range of $1-2 million, exclusive of tooling (molds) and facility infrastructure (power, compressed air, material handling). At this capital cost, and assuming a cycle time of 3 minutes (20 parts per hour) and 6,000 operating hours per year (approximately 70% utilization), a single cell produces 120,000 parts annually. The capital cost per part per year is $8-17, which must be recovered through the part price over the program lifetime.

### Tooling Economics

Tooling — the molds that define the part geometry during compression molding — represents a separate and significant capital investment. Composite compression molding tools are typically machined from tool steel or invar (a nickel-iron alloy with low thermal expansion) and must withstand repeated thermal cycling from room temperature to 350-400°C. Tooling cost for a part of moderate complexity ranges from $50,000 to $200,000 per tool set.

Tooling life is a critical variable: if a tool set produces 100,000 parts before requiring replacement, the per-part tooling cost is $0.50-2.00. If tool life is only 10,000 parts, the per-part cost is $5-20 — potentially the dominant manufacturing cost. The company's ability to extend tool life through optimized molding parameters and tool maintenance practices will significantly influence the economic competitiveness of the process.

---

_Source: CSM proprietary research, manufacturing equipment benchmarking, composite process economics, industrial engineering analysis._
