# Field-Reversed Configuration (FRC) Fundamentals

## What is an FRC?
A Field-Reversed Configuration is a compact toroidal plasma configuration where the magnetic field lines close entirely within the plasma volume. Unlike a tokamak, an FRC has no toroidal field coils linking the plasma — the confining magnetic field is generated almost entirely by plasma currents. This gives the FRC an extremely high plasma beta (β), the ratio of plasma pressure to magnetic pressure. While tokamaks operate at β ~ 0.05 (5%), FRCs routinely achieve β > 0.8 (80%), making them far more efficient in terms of fusion power per unit of magnetic field energy.

### Key FRC Properties
- **High Beta:** β > 0.8 enables compact, high-power-density reactors.
- **Simply Connected Geometry:** No central solenoid or toroidal field coils; linear topology simplifies engineering.
- **Natural Divertor:** Open field lines at the ends of the FRC provide a natural exhaust channel for fusion ash and impurities.
- **Axial Translation:** FRCs can be formed in one section and translated axially into a compression section, decoupling formation from heating.
- **Scalability:** Fusion power scales as B^4 * R^2 (magnetic field to the fourth power times radius squared), favoring compact, high-field devices.

## Helion's Magneto-Inertial Fusion (MIF) Cycle
Helion's approach combines FRC formation with pulsed electromagnetic compression. Each pulse follows a four-phase cycle:

### Phase 1: Formation (Formation Section)
Deuterium and helium-3 gas is injected into two quartz formation tubes at opposite ends of the device. Pulsed magnetic fields ionize the gas and form two counter-propagating FRC plasmoids. These plasmoids are accelerated toward the center of the device at velocities exceeding 300 km/s.

### Phase 2: Merging (Central Chamber)
The two FRCs collide and merge in the central chamber. The kinetic energy of translation is converted to thermal energy during the merge. This merging process heats the plasma to temperatures of 10-20 keV before compression begins. The merged FRC is a single, stable plasmoid centered in the compression section.

### Phase 3: Compression (Compression Section)
A pulsed magnetic field from the compression coil system radially and axially compresses the FRC. The compression is driven by discharging massive capacitor banks (50 MJ on Polaris) through the compression coils. The adiabatic compression raises the ion temperature to fusion-relevant conditions (100-200 million °C). The entire compression cycle lasts approximately 1 millisecond.

### Phase 4: Expansion & Energy Recovery
As the compressed plasma undergoes fusion reactions, it expands. The expanding, electrically conducting plasma pushes back against the magnetic field of the compression coils. Faraday's law of induction converts this mechanical work directly back into electrical current in the coils. This is the "direct electricity recovery" mechanism — the fusion plasma itself acts as the working fluid in a magnetic piston, and the compression coils serve dual purpose as both the compression driver and the generator stator.

### Phase 5: Reset & Recharge
After energy recovery, the system must reset for the next pulse. This involves:
- Pumping out fusion ash (helium-4, unburned fuel) through the divertor.
- Recharging the capacitor banks from the recovered energy plus make-up power from the grid.
- Injecting fresh fuel gas into the formation sections.
- Target pulse repetition rate: 1 Hz (one full cycle per second).

## Advantages Over Other Fusion Approaches
| Property | Helion FRC | Tokamak (ITER/SPARC) | Stellarator (W7-X) | Laser ICF (NIF) |
|----------|-----------|----------------------|-------------------|-----------------|
| Beta (β) | >0.8 | ~0.05 | ~0.05 | N/A |
| Magnetic Field | Pulsed, ~10-15 T | Steady-state, ~5-13 T | Steady-state, ~3 T | N/A |
| Energy Conversion | Direct inductive | Steam turbine | Steam turbine | Boiler/steam |
| Fuel | D-He3, D-D | D-T | D-T | D-T |
| 14.1 MeV Neutrons | Minimal (D-He3) | Abundant | Abundant | Abundant |
| Tritium Breeding | In-situ from D-D | Required (Li blanket) | Required (Li blanket) | Required |
| Device Footprint | ~60 ft (Polaris) | ~30 m major radius (ITER) | ~5.5 m major radius | ~10 m target chamber |
| Capital Intensity | Lower | Highest | High | Very High |

## Neutron Management
Helion's D-He3 fuel cycle produces significantly fewer high-energy neutrons than D-T fusion. The primary D-He3 reaction:
  D + He3 → p (14.7 MeV) + He4 (3.6 MeV)
produces no neutrons. However, unavoidable D-D side reactions produce neutrons:
  D + D → He3 (0.82 MeV) + n (2.45 MeV) — 50% branch
  D + D → T (1.01 MeV) + p (3.02 MeV) — 50% branch

These 2.45 MeV neutrons are far less energetic than D-T neutrons (14.1 MeV), substantially reducing neutron activation of structural materials and enabling a simpler shielding design. The D-D side reaction also generates tritium as a byproduct, which requires handling and regulatory compliance but also provides a pathway for He-3 breeding through tritium decay.

## Key Technical Challenges
1. **FRC Stability:** FRCs are susceptible to the n=2 rotational (rotating) instability and the n=1 tilt instability. Helion's approach of rapid compression during the merge phase, combined with active feedback stabilization, is designed to suppress these modes before they grow.
2. **Closed-Flux Lifetime:** The FRC's magnetic flux decays resistively over time. Helion's pulsed approach turns this into a feature — the pulse is completed before significant flux dissipation occurs.
3. **Compression Symmetry:** Asymmetric compression reduces fusion yield and can cause plasma-wall contact. Helion's Formation Section design and active coil control are critical for maintaining symmetry.
4. **Electrode & Wall Erosion:** The FRC plasma can interact with the formation tube walls and electrodes, causing material erosion and plasma contamination. Boronization and other wall-conditioning techniques are employed.
