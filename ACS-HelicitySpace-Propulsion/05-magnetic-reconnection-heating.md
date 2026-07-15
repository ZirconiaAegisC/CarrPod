# 05 — Magnetic Reconnection Heating

## Classification: Proprietary — ACS Internal Use Only

---

## 1. Conceptual Basis

Magnetic reconnection heating is the third enabling mechanism in the Helicity Drive
architecture and is responsible for raising the plasma to fusion-relevant temperatures
after compression. Reconnection is the topological rearrangement of magnetic field lines
that converts stored magnetic energy directly into thermal energy — predominantly ion
thermal energy — through processes occurring in thin current sheets.

The Helicity Drive leverages reconnection as a heating mechanism by designing the
plectonemic braiding process to create multiple current sheets at contact points between
adjacent flux tubes. As the braided structure tightens during peristaltic compression,
these current sheets thin below the ion inertial length, triggering fast reconnection
that deposits energy into the ion distribution function.

---

## 2. Reconnection Physics in the Helicity Context

Magnetic reconnection in the Helicity Drive operates in the collisionless or
weakly-collisional regime, characterized by:

- **Ion inertial length (d_i ≈ cm)** — the spatial scale below which ions decouple from
  the magnetic field, setting the current sheet thickness at the onset of fast
  reconnection
- **Lundquist number (S ≈ 10³–10⁵)** — intermediate values where fast reconnection
  (Sweet-Parker rate exceeded by anomalous resistivity or Hall effects) can occur
  without transitioning to fully turbulent, energetically inefficient regimes
- **Guide field (B_g/B_reconnect ≈ 0.1–1.0)** — the magnetic field component
  perpendicular to the reconnection plane, which controls the energy partition between
  ions and electrons

The predicted reconnection inflow velocity in the ECLAIR-relevant regime is:

```
v_in ≈ 0.1 v_A   (where v_A is the Alfvén speed)
```

This yields reconnection timescales of 1–10 μs, compatible with the 10–100 μs pulse
duration.

---

## 3. Direct Ion Heating

A key advantage of reconnection heating is its preferential deposition of energy into
ions rather than electrons. In a propulsion context, ion thermal energy converts to
directed thrust with higher efficiency than electron thermal energy because:

- Ions carry the majority of the mass flux through the magnetic nozzle
- Ion temperature directly determines the exhaust velocity (I_sp ∝ √T_i)
- Electron temperature contributes primarily to ionization balance, not thrust

The energy partition ratio (ion heating / electron heating) in the Helicity Drive
reconnection regime is estimated at 3:1 to 10:1, depending on the guide field magnitude
and the plasma beta at the reconnection site.

---

## 4. Reconnection Site Distribution

Unlike a single X-point reconnection event in a tokamak disruption or the solar corona,
the Helicity Drive produces a distributed network of reconnection sites. The plectonemic
topology contains N(N-1)/2 pairwise flux tube contacts for N braided tubes. For the
prototypical 4-gun configuration, this yields up to 6 reconnection sites distributed
throughout the compressed plasma volume.

The volumetric distribution of heating sites provides:

- **Heating uniformity** — no single hot spot that would trigger an instability
- **Redundancy** — if one current sheet fails to reconnect, the remaining sites
  compensate
- **Scalability** — increasing the gun count increases the number of reconnection
  sites, providing a natural path to higher total heating power

---

## 5. Relationship to Plectonemic Confinement

Reconnection and plectonemic confinement exist in a controlled tension. Reconnection
topologically simplifies the magnetic field — it untwists and unlinks flux tubes —
counteracting the helicity injection that maintains the braided topology. This
competition sets the pulse duration:

- **Helicity injection**: τ_inject ≈ 10 μs (jets merge and braid)
- **Confinement phase**: τ_confine ≈ 50–100 μs (braided topology holds)
- **Reconnection phase**: τ_reconnect ≈ 1–10 μs (per current sheet event)
- **Topology decay**: τ_decay ≈ 100–300 μs (cumulative reconnection simplifies the
  topology to the point where confinement is lost)

The Helicity Drive pulse is timed so that maximum reconnection heating coincides with
peak compression at the nozzle throat, extracting the magnetic energy stored in the
braided topology before it can leak away through gradual resistive diffusion.

---

## 6. Observational Signatures in ECLAIR

| Signature | Diagnostic | Target Value |
|---|---|---|
| Ion temperature spike | Doppler broadening spectroscopy | T_i > 1 keV |
| Reconnection outflow jets | High-speed imaging (5M fps) | Visible plasma jets from X-points |
| Current sheet thinning | Magnetic probe array | d_i-scale gradient |
| Soft X-ray emission | Filtered photodiodes | Bremstrahlung from heated electrons |
| Topological unwinding | 3D MHD reconstruction | Decrease in helicity over pulse |
