# CSMFAB000000000114 — 3D-01
# 3D Generation Prompt Document
## Component: Archimedes Spiral Wing Assembly — Full Body
**Carrington Storm Motors / Safe Pod Engineering Company**
**Version 1.0 | June 2026**

---

## Component Identity

**Name:** ASB-1 Spiral Wing Body Assembly
**Function:** Primary airframe, aerodynamic surface, and structural spine of the Archemedian Spiraling Bird UAS. This is the main flying surface — a three-turn helical wing that generates lift in wind by autorotating.
**Mass target:** 60g
**Material:** PETG (prototype) / BFRP (production)
**Color for rendering:** Matte white or natural off-white PETG; accent ribs in matte orange

---

## Precise Dimensions

| Feature | Dimension |
|---|---|
| Outer diameter | 150 mm |
| Inner hub diameter | 30 mm |
| Total height (nose-to-tail) | 200 mm |
| Number of helical turns | 3 complete turns |
| Pitch per turn (rise per 360°) | 67 mm |
| Blade chord (width) | 20 mm |
| Wall thickness | 1.2 mm |
| Hub wall thickness | 2.0 mm |
| Blade root angle (inner, r=15mm) | 35 degrees |
| Blade mid-span angle (r=45mm) | 28 degrees |
| Blade tip angle (outer, r=75mm) | 18 degrees |
| Nose cone socket (top) | 25 mm diameter, 15 mm deep |
| Tail assembly socket (bottom) | 30 mm diameter, 20 mm deep |
| Electronics bay cavity (mid-body) | 42 mm diameter × 65 mm deep cylindrical pocket |
| Governor shaft bore | 8 mm diameter through centerline |
| Actuator housing slots × 4 | 10 mm × 35 mm × 8 mm deep, at r=60mm, 90° spacing |

---

## Feature Description

The component is a right-hand (clockwise when viewed from top) three-turn Archimedes helix shell. The helix begins at the bottom (tail end) and rises to the top (nose end) through three complete 360° rotations. Each turn of the helix is a blade with continuous cross-section that tapers in pitch angle from 35° at the inner radius to 18° at the outer tip — this twist is built into the blade geometry.

The inner hub is a hollow cylinder running the full height of the body. The mid-section of the hub has a cylindrical pocket (42mm × 65mm) with a clamshell lid opening (hinged on one side, clip-locked on the other) for electronics installation access.

The outer surface of each blade is smooth and aerodynamically curved (slight upper surface camber, flat lower surface). The inner surface (facing the hub) is webbed for structural support — 6 radial ribs per turn connecting blade to hub.

The base (tail end) has a 4-arm adapter socket for the tail fin assembly mounting ring. The top (nose end) has a ring socket for the nose cone to press-fit into.

Four rectangular slots at 90° spacing on the hub exterior (at 130mm height from base) accept the Smart Rope actuator housings.

---

## Interface Connections

| Interface | Adjacent Component | Connection Type |
|---|---|---|
| Nose socket (top) | Nose Cone (3D-04) | Press-fit snap ring, 25mm |
| Tail socket (bottom) | Tail Vane Assembly (3D-05) | 4× M2 screw into heat inserts |
| Electronics bay lid | Electronics Bay Shell (3D-07) | The bay shell IS a sub-cavity within this body |
| Governor bore (center) | Speed Governor (3D-10) | Press-fit 8mm shaft bore |
| Actuator slots (×4) | Smart Rope Housings (3D-06) | Press-fit + CA adhesive spot |

---

## 3D Generation Prompt — Version A (Detailed Technical)

Generate a 3D model of a drone airframe body with the following precise geometry: a three-turn right-hand helical Archimedes screw body, 150mm outer diameter, 200mm tall, with a 30mm diameter hollow central hub running the full height. The helical blade completes exactly three full 360-degree rotations from bottom to top, with a pitch of 67mm per revolution. The blade is 20mm wide (chord length) and 1.2mm thick, with a variable twist angle graduating smoothly from 35 degrees at the inner radius (15mm from center) to 18 degrees at the outer tip (75mm from center). The blade has a slightly cambered upper surface (convex, 3mm maximum camber height) and a flat lower surface. The inner hub features a mid-body cylindrical pocket 42mm in diameter and 65mm deep for electronics installation, with a hinged clamshell lid on the outer hub wall. Six internal radial support ribs per helix turn connect the blade inner face to the hub. A 25mm diameter 15mm deep socket is at the top for a nose cone press-fit. A 30mm diameter 20mm deep socket with four M2 insert positions at 90° spacing is at the base for the tail assembly. Four 10×35×8mm rectangular slots at 90° spacing at 60mm radius from center appear at 130mm height. A 8mm bore runs through the full centerline of the hub. Material appearance: matte white BFRP composite. Render in isometric view with all three spiral turns visible.

---

## 3D Generation Prompt — Version B (Bird/Artistic Emphasis)

Create a 3D model of a flying bird-inspired aeronautical device body. The shape should evoke an Archimedes screw or a dramatic helical DNA strand standing vertically. It is a continuous spiral wing that coils three times around a central cylindrical spine, like a large maple seed scaled up and standing upright. The outer diameter of the full spiral is 150mm top to bottom view (about the diameter of an orange). The body stands 200mm tall (about the height of a large wine glass). The spiral blade is 20mm wide and tapers in twist angle from steep (35°) at the center spine to nearly flat (18°) at the outer tips, like a propeller blade but in a continuous helix instead of discrete blades. The central spine is hollow, with a service bay opening in the middle section. The base of the body has four small fins in an X-pattern emerging from the spine's base. The nose end (top) tapers into a socket for a pointed nose cone. The overall aesthetic: clean, white, futuristic, organic — like a shell or a nautilus fused with an airplane propeller.

---

## 3D Generation Prompt — Version C (Simple Parametric)

3D printable Archimedes screw drone body: 150mm diameter, 200mm tall, 3 complete helix turns, right-hand winding, 67mm pitch per turn. Blade width 20mm, wall 1.2mm, variable pitch from 35° root to 18° tip. Central hollow hub 30mm OD × full height. Mid-body cylindrical cavity 42mm × 65mm with hinged lid (clamshell style). Top: 25mm press-fit socket for nose cone. Bottom: 30mm socket with 4× M2 inserts for tail assembly. Center bore 8mm throughout. Print orientation: vertical (Z-axis = helix axis). Material: PETG. Export STL with top of helix = positive Z direction.

---

## Fabrication Notes for 3D Generator

- Export as STL or OBJ with manifold (watertight) mesh
- No intersecting geometry (boolean union all sub-elements before export)
- The helix blade and hub must be a single solid body
- Minimum feature size respected: no features thinner than 1.0mm
- The clamshell lid should be modeled as a separate body to Vol-07 (Electronics Bay Shell), hinged at one edge and clip-locked at the other
- Print should be sliced vertically (helix axis = Z). Include this note in file name: "PRINT_VERTICAL_Z"

---

*CSMFAB000000000114-3D-01 | Version 1.0 | June 2026 | Carrington Storm Motors / Safe Pod Engineering Company*
