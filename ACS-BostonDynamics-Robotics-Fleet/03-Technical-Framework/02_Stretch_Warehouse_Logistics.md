# Stretch — Warehouse Logistics Platform

**Classification:** ACS Internal — Confidential  
**Date:** 15 July 2026  
**Version:** 1.0

---

## 1. Platform Overview

Stretch is a mobile automated case-handling robot purpose-built for warehouse and logistics center unloading, induction, and material-handling operations. It features a custom 7-degree-of-freedom robotic arm mounted on an omnidirectional mobile base, equipped with a vacuum-based gripping array optimized for heterogeneous parcel and carton handling.

### 1.1 Technical Specifications

| Parameter | Specification |
|-----------|--------------|
| **Arm Configuration** | 7-DOF custom manipulator; 2,200mm vertical reach |
| **End Effector** | Multi-cup vacuum gripping array with individual cup actuation |
| **Mobility** | Omnidirectional wheeled base; 1.5 m/s maximum speed |
| **Throughput** | 500 parcels per hour (sustained) |
| **Maximum Payload per Lift** | 23 kg |
| **Perception** | Stereo depth cameras, 2D barcode scanner, package dimensioning sensors |
| **Battery Runtime** | 8+ hours continuous operation |
| **Autonomy** | Vision-guided pick-and-place; autonomous trailer/container wall-following; dynamic package sequencing |
| **Safety** | IEC 62061 SIL 2; ISO 13849 PLd; 360° lidar safety zone; E-stop and protective stop |
| **System Price** | $1M+ per system (negotiated enterprise pricing; includes integration, training, first-year support) |

### 1.2 Operational Workflow

Stretch's core workflow targets the most labor-intensive node in warehouse logistics: truck-trailer and container unloading.

1. **Approach & Docking.** Stretch autonomously navigates to an assigned trailer bay. A conveyor extension bridges the gap between Stretch and the facility's fixed sortation system.
2. **Wall-Following Unload.** Stretch enters the trailer and uses depth-camera wall-following to systematically clear packages from the trailer face inward. The vision system identifies graspable surfaces, classifies package orientation, and selects optimal vacuum-cup configurations on each lift cycle.
3. **Dynamic Sequencing.** Packages are placed onto the onboard conveyor in a sequence optimized to prevent downstream sortation bottlenecks. Packages exceeding dimensional or weight thresholds are flagged and skipped.
4. **Induction & Sortation Handoff.** The conveyor transfers packages to the facility's fixed material-handling system for sorting, routing, and dispatch.
5. **Continuous Operation.** Stretch operates until the trailer is emptied, autonomously advancing into the trailer as the package wall recedes. Hot-swappable batteries enable multi-shift operation.

## 2. Deployment Footprint

### 2.1 Enterprise Customers

| Customer | Deployment Scope | Facility Count |
|----------|-----------------|----------------|
| **DHL Supply Chain** | Truck unloading; cross-dock induction | Multiple US/EU facilities |
| **Maersk** | Container unloading; port-adjacent logistics centers | Multiple facilities |
| **Hermes Fulfillment (Otto Group)** | E-commerce parcel unloading; 500 parcels/hr throughput | 20+ facilities |
| **H&M Group** | Inbound logistics; returns processing | Multiple EU distribution centers |
| **Gap Inc.** | Distribution center inbound/outbound | US facilities |

### 2.2 Operational Metrics

| Metric | Value |
|--------|-------|
| Sustained Throughput | 500 parcels per hour |
| Maximum Per-Parcel Weight | 23 kg |
| Typical Unload Time (53-ft trailer) | 4–6 hours (varies by package density) |
| Packages per 8-Hour Shift | ~4,000 |
| Manual Labor Displacement per Shift | 2–3 workers per trailer door |
| Uptime (enterprise deployments) | 97%+ (reported) |

## 3. Economic Analysis

### 3.1 Cost Structure

| Cost Element | Estimate (per system) |
|-------------|----------------------|
| System Hardware (Stretch unit) | $750,000–$1,100,000 |
| Site Integration & Conveyor Modifications | $150,000–$300,000 |
| Annual Software/WMS Integration License | $40,000–$75,000 |
| Annual Maintenance Contract | $35,000–$50,000 |
| Operator Training (per cohort) | $10,000 |
| **Year-1 All-In Cost** | **$1,000,000–$1,535,000** |

### 3.2 ROI Framework

Warehouse operators evaluating Stretch against manual labor typically achieve payback within 18–30 months, driven by:

- **Direct Labor Savings:** 2–3 workers per trailer door across 2–3 shifts = 4–9 FTE displacement per Stretch unit.
- **Injury Cost Avoidance:** Trailer unloading is a top-3 source of warehouse worker injury (shoulder, back, repetitive strain). Stretch eliminates the ergonomic injury exposure.
- **Throughput Gains:** Stretch operates at a sustained 500 parcels/hour without fatigue, meal breaks, or shift-change downtime — providing a ~20–30% throughput improvement over average manual unload rates.
- **Workforce Reallocation:** Displaced workers are typically reassigned to higher-value sortation, quality control, and exception-handling roles rather than terminated — reducing labor-relations friction.

### 3.3 Total Addressable Market

The global warehouse automation market is projected at $30B+ by 2027, with truck/container unloading representing a $5B–$8B addressable subsegment. Key demand drivers:

- Persistent warehouse labor shortages in North America and Western Europe.
- E-commerce parcel volume growth (CAGR 8–12%).
- Increasing parcel heterogeneity and dimensional complexity.
- Regulatory pressure on warehouse working conditions (California AB 701, EU Platform Work Directive).

## 4. Competitive Positioning

| Competitor | Platform | Key Differentiator |
|------------|----------|-------------------|
| **Honeywell Intelligrated** | Robotic Unloader (RU) | Established WMS integration; large installed base |
| **Mujin** | TruckBot | AI-driven motion planning; Japan-based |
| **Pickle Robot** | Dill | Lower-cost truck unloading alternative |
| **Dexterity** | Dexterity Unloader | Full-truck autonomy; AI-first approach |

Stretch's primary differentiation lies in (a) BD's three-decade heritage in dynamic manipulation, providing superior handling of irregular and unstable packages; (b) the Hyundai corporate relationship providing direct warehouse deployment environments within Hyundai Glovis logistics operations; and (c) integration with the Orbit platform for fleet-level operational analytics.

## 5. Technology Roadmap

| Timeline | Capability |
|----------|-----------|
| **2026 (Current)** | 500 parcels/hr; trailer unloading; WMS API integration with major platforms (Manhattan Associates, Blue Yonder, SAP EWM) |
| **2027 (Planned)** | Mixed-SKU palletizing; outbound trailer loading; enhanced parcel classification via Gemini Robotics vision integration |
| **2028 (Projected)** | Cross-dock sortation; multi-Stretch coordinated workflows within single facilities; AI-driven dynamic workforce allocation |

## 6. Risk Factors

1. **WMS Integration Complexity.** Warehouse management system integration remains a bottleneck for deployment velocity. Each facility's unique WMS configuration, conveyor topology, and operational workflow requires bespoke integration engineering.
2. **Throughput Ceiling.** Stretch's 500 parcels/hour sustained rate is competitive with manual labor but below the 800–1,000 parcels/hour achievable by fixed automation and certain competitors.
3. **Package Heterogeneity Limits.** Polybags, envelopes, and non-rigid packaging below dimensional thresholds challenge Stretch's vision-based grasp planning. Manual exception handling is required for these items.
4. **Union Sensitivity.** Warehouse labor unions (Teamsters, Ver.di) increasingly target automation as a collective bargaining issue. Stretch deployments at unionized facilities may face work-rule constraints and job-protection clauses.
