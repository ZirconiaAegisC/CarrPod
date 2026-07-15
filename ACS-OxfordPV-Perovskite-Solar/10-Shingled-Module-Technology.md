# 10 — SHINGLED MODULE TECHNOLOGY & FRAUNHOFER ISE COLLABORATION

## Technology Overview

In June 2026, Oxford PV, in partnership with Fraunhofer Institute for Solar Energy Systems (ISE), demonstrated a shingled perovskite-silicon tandem module achieving 25.6% efficiency. This milestone represents the first public demonstration of shingled interconnection technology applied to tandem cells, combining Oxford PV's perovskite-silicon tandem cells with Fraunhofer ISE's Matrix Shingle technology.

The shingled module architecture replaces conventional ribbon-based cell interconnection with a configuration in which cells are cut into strips (typically five or six strips per M6 cell) and assembled in an overlapping, shingle-like arrangement with electrically conductive adhesive (ECA) bonding the overlap regions. This approach offers several advantages over conventional ribbon-based stringing:

**Elimination of Cell-to-Cell Spacing**: The overlapping geometry eliminates the inter-cell gaps that are present in conventional modules (typically 2–3 mm between cells), increasing the active photovoltaic area within a given module footprint. This geometric gain is estimated at 2–3% absolute improvement in module-level efficiency relative to the same cells in a conventional ribbon-interconnected layout.

**Reduced Resistive Losses**: The shingled configuration divides the cell current among multiple parallel strip strings, reducing the current per interconnection point and consequently reducing the I²R losses that scale with the square of the current. For a tandem cell with I_sc of approximately 12 A, dividing into six strips reduces the strip current to approximately 2 A, reducing interconnect resistive losses by a factor of approximately 36 compared to a full-cell ribbon configuration.

**Improved Shade Tolerance**: The parallel string architecture inherent to shingled modules provides inherent bypass characteristics, reducing the power loss from partial shading relative to series-connected conventional modules. This is particularly advantageous for rooftop and building-integrated applications where partial shading from chimneys, dormers, or adjacent buildings is common.

## Fraunhofer ISE Matrix Shingle Process

The Fraunhofer ISE Matrix Shingle process comprises the following steps:

1. **Laser Scribing and Mechanical Cleaving**: M6-format tandem cells are laser-scribed on the rear side to define cleavage planes, then mechanically cleaved into strips of approximately 27.7 mm × 166 mm (six strips per full cell). The cleavage process requires optimization for the perovskite-silicon tandem cell structure, as the mechanical properties of the perovskite layer and the TCO interlayers differ from those of conventional silicon cells.

2. **Electrically Conductive Adhesive (ECA) Application**: A silver-filled epoxy ECA is dispensed along the busbar region of each strip. The ECA formulation must be compatible with the TCO surface of the tandem cell, maintaining low contact resistivity (<1 mΩ·cm²) and mechanical adhesion over the module lifetime.

3. **Shingle Assembly**: Strips are placed in overlapping configuration with an overlap width of 1.0–1.5 mm. The overlap must be precisely controlled: insufficient overlap compromises mechanical integrity and electrical contact; excessive overlap reduces the active cell area and negates the geometric gain.

4. **ECA Curing**: The assembled shingle strings are cured at 150°C for 15 minutes under uniform mechanical pressure to ensure consistent bond line thickness and low contact resistance.

5. **Module Integration**: Shingle strings are arranged in a matrix configuration, with parallel string interconnection providing fault tolerance against individual cell defects. The strings are laminated in a glass-glass configuration with TPO encapsulant and butyl edge seal, consistent with Oxford PV's standard Gen 3 module architecture.

## Performance Results (June 2026)

The Fraunhofer ISE demonstration module achieved the following performance characteristics:

| Parameter | Value | Unit |
|-----------|-------|------|
| Module efficiency | 25.6 | % |
| Module power (STC) | 432 | W |
| Module aperture area | 1.69 | m² |
| Number of cell strips | 360 | — |
| Shingle overlap | 1.2 | mm |
| Cell-to-module efficiency ratio | 96.2 | % |
| Fill factor | 79.5 | % |

The cell-to-module efficiency ratio of 96.2% is notably higher than the typical 93–95% achieved with conventional ribbon-interconnected tandem modules, reflecting the geometric gain and reduced resistive losses of the shingled configuration.

## Commercial Pathway

The shingled module architecture is positioned as a premium product within Oxford PV's portfolio, targeting applications where module efficiency is the primary value driver and where the higher manufacturing cost of the shingled process can be justified by the incremental energy yield. Key target segments include:

**Residential Rooftop**: Where roof area is constrained and high module efficiency translates directly to higher system capacity within the available space. The shade tolerance of the shingled configuration provides additional value in residential settings with unavoidable partial shading.

**Commercial and Industrial (C&I) Rooftop**: Where flat-roof installations with limited load-bearing capacity benefit from higher power density (W/m²) and reduced balance-of-system costs per watt.

**Vehicle-Integrated Photovoltaics (VIPV)**: Where the curved surfaces and partial shading characteristic of automotive applications favor the mechanical flexibility and shade tolerance of shingled configurations. Oxford PV has initiated exploratory discussions with European automotive OEMs regarding VIPV applications.

## Manufacturing Scale-Up Considerations

Transitioning the shingled module process from Fraunhofer ISE's pilot line to Oxford PV's Brandenburg facility requires capital investment in:

- Laser scribing and cleaving tools rated for tandem cell processing.
- ECA dispensing systems with high-precision volumetric control.
- Automated shingle placement systems capable of maintaining the required overlap tolerance (±0.1 mm) at production throughputs of 500+ strips per hour.
- Modified lamination recipes that accommodate the different thermal mass and mechanical compliance of shingled assemblies.

Oxford PV targets qualified production of shingled tandem modules at Brandenburg by Q2 2027, with initial volumes of 5–10 MW per year directed to premium residential and C&I markets.

## References

- Fraunhofer ISE. "Matrix Shingle Technology for High-Efficiency Photovoltaic Modules." Technical White Paper, 2025.
- Oxford PV Press Release. "Oxford PV and Fraunhofer ISE Demonstrate 25.6% Shingled Tandem Module." June 2026.
- Schulte-Huxel, H. et al. "Silver-free solar cell interconnection using shingling." *Energy Procedia* 124, 420–428 (2017).
- Tonini, D. et al. "Shingling technology for high efficiency PV modules: Status and outlook." *Progress in Photovoltaics* 31, 345–362 (2023).
