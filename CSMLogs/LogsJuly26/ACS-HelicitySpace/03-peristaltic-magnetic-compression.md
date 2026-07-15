# 03 — Peristaltic Magnetic Compression

## Classification: Proprietary — ACS Internal Use Only

---

## 1. Conceptual Basis

Peristaltic magnetic compression is the first of the three enabling mechanisms in the
Helicity Drive architecture. The term "peristaltic" draws an analogy to biological
peristalsis — sequential, wave-like constriction that propels material through a conduit.
In the Helicity Drive, a geometrically passive arrangement of electromagnetic coils
generates a three-dimensional magnetic field topology that compresses injected plasma
without requiring active feedback control.

The critical operating principle is that the total magnetic field energy remains
approximately constant throughout the compression cycle. Unlike conventional magnetic
compression schemes that pump energy into the field to drive compression, the peristaltic
approach rearranges existing magnetic flux, converting spatial gradients in the initial
configuration into temporal compression of the plasma column at the nozzle throat.

---

## 2. Coil Geometry

The passive coil arrangement consists of a series of toroidal and poloidal field coils
arranged along the convergent-divergent nozzle axis. The geometry is characterized by:

- **Inlet section**: Low field gradient, large cross-section to accept incoming plasma jets
- **Convergent section**: Progressively tighter coil spacing with interleaved poloidal
  windings producing a helicity-injecting field component
- **Throat section**: Maximum field strength, minimum cross-sectional area — the
  compression peak where fusion-relevant densities and temperatures are achieved
- **Divergent section**: Expanding magnetic nozzle for thrust extraction, analogous to
  the diverging bell of a chemical rocket nozzle but shaped by magnetic flux surfaces

The coil arrangement is fixed during operation; there are no moving mechanical parts in
the compression system. Time-varying compression arises from the plasma's self-consistent
interaction with the static field geometry.

---

## 3. Three-Dimensional Compression

Conventional magnetic mirrors compress plasma primarily along one axis (axial). The
Helicity peristaltic geometry achieves three-dimensional compression due to the
superposition of:

1. **Axial compression** — plasma deceleration against the increasing magnetic field
   gradient in the convergent section
2. **Radial compression** — azimuthal currents induced in the plasma cross the
   increasing radial field component, producing an inward J × B force
3. **Azimuthal compression** — helical field lines wrap the plasma column, providing
   a constrictive hoop stress

The simultaneous 3D compression increases plasma density by a factor of 10² to 10³
over the inlet value, and the associated adiabatic heating raises the ion temperature
by a comparable factor before any reconnection heating occurs.

---

## 4. Constant Magnetic Field Energy Regime

A distinguishing feature of the peristaltic compression scheme is that the total
magnetic field energy in the coil system is approximately conserved during a pulse. The
energy flow is:

```
E_magnetic (coils) → E_kinetic (plasma compression) + E_thermal (adiabatic heating)
                    + E_magnetic (compressed plasma)
```

Because the coils are not driven to higher currents during compression, the system
avoids the pulsed-power scaling challenges that limit other compression approaches.
The coil currents can be maintained at steady-state (DC or low-frequency AC), with
the plasma itself providing the time-varying dynamics through its electromagnetic
interaction with the fixed field.

---

## 5. Scaling Properties

| Parameter | Scaling Law | Implication |
|---|---|---|
| Compression ratio | ∝ (coil current)^(2/3) | Modest current increases yield significant compression |
| Peak density | ∝ (inlet density) × (compression ratio)³ | 3D effect is multiplicative |
| Pulse rate | Independent of compression | 10–100 Hz feasible |
| Coil cooling | ∝ I²R (DC case) | Steady-state thermal management required |
| Thrust | ∝ (mass flow) × (exhaust velocity) | Scales linearly with gun count |

The decoupling of the coil electrical system from the plasma compression timescale is
the feature that enables high repetition rates. Unlike pulsed-power approaches where
capacitor banks must recharge between shots, the Helicity Drive coils operate
continuously with the plasma pulses providing the intermittent compression dynamics.

---

## 6. Comparison to Z-Pinch and Theta-Pinch

| Parameter | Z-Pinch | Theta-Pinch | Peristaltic |
|---|---|---|---|
| Compression axes | Radial only | Radial only | 3D (axial, radial, azimuthal) |
| Current path | Through plasma | External coil | Both (coupled) |
| Stability | Implosion instabilities | End losses | Plectonemic stabilization |
| Repetition rate | Limited by electrode erosion | Limited by capacitor recharge | Limited only by plasma injection rate |
