# Arris Composites — Continuous Fiber Alignment (Part 1)

**Analyst:** CSM Research  
**Date:** 15 July 2026  
**Classification:** Proprietary Research

---

## The Fiber Alignment Advantage

At the heart of Arris Composites' Additive Molding technology lies the capability to orient continuous carbon fiber filaments along precisely calculated three-dimensional trajectories within a part. This capability — continuous fiber alignment — represents a fundamental departure from both conventional composite manufacturing and competing automation technologies.

In traditional composite laminate design, fiber orientation is limited to the angles at which fabric or unidirectional tape can be cut and stacked: typically 0°, 90°, and ±45° in two-dimensional planes. The resulting part achieves its structural properties through the superposition of these discrete orientations across multiple layers. This approach is well-understood, extensively certified, and deeply embedded in aerospace design practices. It is also inherently wasteful: substantial fractions of the fiber reinforcement are oriented in directions that carry minimal structural load.

## The Physics of Fiber-Dominated Properties

Carbon fiber composites are anisotropic materials: their mechanical properties vary dramatically with the direction of measurement relative to fiber orientation. Along the fiber axis, carbon fiber/epoxy composites exhibit tensile strengths approaching 2,000 MPa and tensile moduli exceeding 130 GPa. Perpendicular to the fiber axis — in the matrix-dominated direction — strength drops by an order of magnitude, to approximately 50-80 MPa.

This anisotropy is both the great advantage and the great challenge of composites engineering. A part designed with fibers optimally aligned to the principal stress trajectories can achieve specific stiffness and strength values that exceed any isotropic metal. A part with fibers poorly aligned — or worse, aligned randomly — performs no better than a short-fiber injection-molded plastic component at a much higher material cost.

Arris's fiber alignment capability directly addresses this challenge. By using computational stress analysis to determine the optimal fiber trajectory at every point within a part, and by possessing the manufacturing technology to place fiber along those trajectories, the company closes the gap between theoretically optimal composite structures and practically manufacturable ones.

## Load Path Optimization

The concept of load path optimization is central to understanding the fiber alignment value proposition. Consider a typical aerospace bracket: a structural component that transfers mechanical loads between two or more attachment points. The bracket experiences a complex stress state — tension along some paths, compression along others, shear in certain regions — all distributed non-uniformly throughout the part geometry.

A bracket machined from aluminum billet addresses this complexity through material isotropy: the aluminum has the same strength in all directions, so as long as the minimum cross-section is adequate, the part is structurally sound. The penalty is weight — the bracket must be thick enough everywhere to handle the worst-case stress at any single point.

A composite bracket with optimized fiber alignment can address the same structural requirements with substantially less material. Fiber is concentrated along the principal load paths — the lines of force connecting the attachment points — and is sparse or absent in regions of the part that experience only secondary loading. The result is a component that is simultaneously lighter, stiffer, and stronger than the aluminum equivalent, with no increase in envelope dimensions.

## The Software Architecture

Arris's fiber path optimization software operates at the intersection of finite element analysis (FEA), computational geometry, and manufacturing constraints. The workflow begins with a CAD model of the target part and the specified loading conditions — forces, moments, and boundary constraints that define how the part will be loaded in service.

The FEA solver computes the stress tensor field throughout the part volume. From this tensor field, the software extracts principal stress directions — the orientations along which tensile and compressive stresses are maximized at each point. These principal stress trajectories form vector fields that define the ideal fiber orientation at every location.

The software then converts these continuous vector fields into discrete, manufacturable fiber tow paths, respecting constraints including minimum tow turning radius, maximum tow density, and the geometry of the deposition end-effector. The output is a G-code-like instruction set that drives the fiber placement hardware.

This software capability is itself a significant intellectual property asset. The algorithms that translate stress tensor fields into manufacturable fiber trajectories are non-trivial and represent years of development effort. Competitors seeking to replicate the Additive Molding approach would need to independently develop equivalent software capability or license it from third parties.

## Comparison to Topology Optimization

The fiber alignment approach has conceptual parallels with topology optimization, a design methodology widely used in aerospace and automotive engineering. Topology optimization algorithms start with a design volume and iteratively remove material from regions carrying low stress, converging on a structure that uses minimal material to meet specified stiffness or strength targets.

The difference is that topology optimization assumes isotropic material properties — it distributes material density but not material orientation. Fiber path optimization adds a second degree of design freedom: not only where material is placed, but how it is oriented. The combination of topology optimization for overall geometry and fiber path optimization for local material orientation represents a powerful design methodology that has not yet been fully exploited in commercial practice.

---

_Source: CSM proprietary research, engineering publications, composite mechanics texts, patent analysis._
