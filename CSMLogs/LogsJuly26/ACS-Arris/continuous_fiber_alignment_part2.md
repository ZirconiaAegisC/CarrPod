# Arris Composites — Continuous Fiber Alignment (Part 2)

**Analyst:** CSM Research  
**Date:** 15 July 2026  
**Classification:** Proprietary Research

---

## Three-Dimensional Fiber Placement: Technical Challenges

Achieving precise fiber alignment in three dimensions presents engineering challenges that distinguish Arris's approach from planar composite manufacturing. When fiber tows are deposited onto a tool surface, several physical constraints govern the achievable alignment accuracy.

### Minimum Turning Radius

Continuous carbon fiber tows have a finite minimum bending radius, typically in the range of 3-5 millimeters for commercially available 12K tows. Attempting to steer a tow around a tighter radius causes fiber buckling on the inside of the curve and fiber breakage on the outside. The fiber path optimization software must incorporate this constraint, ensuring that calculated trajectories respect the manufacturing limits of the material.

This constraint has design implications: parts with sharp corners or rapid changes in curvature may require discontinuous fiber paths, where individual tows terminate and new tows initiate from different approach directions. Managing these fiber discontinuities without creating stress concentrations at fiber ends is a key challenge for the software and process engineers.

### Through-Thickness Fiber Placement

Many structural components require fiber reinforcement that transitions between planes — for example, a bracket that connects an upper attachment point to a lower one, or a fitting that wraps around a bearing surface. Achieving continuity of fiber through these geometric transitions is essential for load transfer between part regions.

Traditional composite manufacturing handles this through ply drops and overlaps: individual plies are terminated at different locations within the laminate to create a tapered thickness transition. Arris's approach, benefiting from additive-style deposition, can produce more sophisticated three-dimensional fiber architectures, including fiber paths that curve smoothly through the thickness of the part and around geometric features.

### Compaction and Void Content

A challenge inherent to any fiber placement process is achieving adequate compaction — ensuring that fibers are packed densely and resin fully impregnates the fiber bundle before consolidation. Inadequate compaction results in void content — microscopic air pockets trapped within the laminate — which degrades mechanical properties, particularly interlaminar shear strength and compression after impact.

The compression molding step in Additive Molding plays a critical role here. While the fiber deposition step aligns the reinforcement architecture, the high-pressure molding step achieves the compaction and void elimination that determines final part quality. The interplay between the two process steps — how fiber placement geometry affects the ability to achieve complete consolidation during molding — is a domain of proprietary process knowledge.

## Fiber Volume Fraction Control

The fiber volume fraction — the proportion of the composite occupied by fiber versus matrix — is the single most important parameter governing mechanical properties. Aerospace-grade composites typically target a fiber volume fraction of 55-65%. Too little fiber, and the part loses the stiffness and strength benefits of the reinforcement. Too much fiber, and there is insufficient resin to fully wet out the fiber bundle and transfer load between individual filaments.

In traditional prepreg layup, fiber volume fraction is determined at the material manufacturing stage: the prepreg supplier controls the resin content of the tape or fabric, and the layup technician controls only the number of plies. In Additive Molding, by contrast, the process controls fiber volume fraction dynamically through the software that regulates tow feed rate, deposition speed, and compression pressure.

This dynamic control offers potential advantages: fiber volume could be intentionally varied within a single part, concentrating fiber in highly stressed regions and allowing resin-rich regions in areas that require toughness or damage tolerance rather than maximum stiffness. Whether this capability is being exploited in current production parts is unclear from public disclosures.

## Fiber Architecture and Failure Modes

The fiber architecture established during alignment determines not only the stiffness and strength of the finished part but also its failure mode — how the part behaves when loaded beyond its ultimate capacity. This is particularly important for aerospace applications, where certification authorities require demonstrated damage tolerance and predictable failure behavior.

A composite laminate that fails in a brittle, catastrophic manner — sudden fracture with minimal energy absorption — is generally unacceptable for primary structure. A laminate with a more distributed failure mode — progressive damage accumulation, load redistribution, and visible indications of impending failure — is preferred.

Fiber alignment can be engineered to promote desirable failure modes. By interspersing fibers oriented in secondary directions among the primary load-carrying fibers, the laminate can be designed to develop distributed micro-cracking before ultimate failure, absorbing energy and providing visible warning of overload. This design philosophy, known as "softening" the laminate, is well-established in aerospace composite design but requires the manufacturing capability to place fibers in optimal architectures — which Additive Molding provides.

## Testing and Validation Methodology

Validating the structural performance of parts with optimized fiber architectures presents challenges not encountered with conventional quasi-isotropic laminates. Standard aerospace test methods — open-hole tension, compression after impact, bearing strength — were developed for laminates with uniform, repeating ply sequences. When fiber orientation varies continuously throughout a part, extracting representative test coupons that capture the full range of local fiber architectures becomes more complex.

Arris's approach to this validation challenge likely involves a combination of building-block testing — coupon, element, sub-component, and full-scale — combined with extensive use of finite element analysis to correlate predicted and measured structural response. The digital process record generated during manufacturing provides a traceable link between the as-designed and as-built fiber architecture, satisfying the configuration management requirements of aerospace quality systems.

---

_Source: CSM proprietary research, composite mechanics references, aerospace certification standards, patent filings._
