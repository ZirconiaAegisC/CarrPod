# 03 — PERFORMANCE METRICS, CERTIFICATION & EFFICIENCY DATA

## Certified Performance Milestones

Oxford PV has established a documented record of efficiency achievements independently verified by leading international calibration laboratories. The progression of certified efficiencies demonstrates sustained improvement in both cell-level and module-level performance:

| Date | Achievement | Certifying Body | Efficiency |
|------|------------|-----------------|------------|
| Dec 2020 | Perovskite-silicon tandem cell | NREL | 29.52% |
| May 2023 | Commercial-size tandem cell (M6) | Fraunhofer ISE | 27.30% |
| Nov 2024 | Full-size tandem module (72-cell) | Fraunhofer ISE | 26.80% (median) |
| Jun 2025 | Shingled tandem module (Matrix Shingle) | Fraunhofer ISE | 25.60% |
| Jul 2025 | Production line median module | Fraunhofer ISE | 26.80% |

The 29.52% NREL-certified cell efficiency established a world record for perovskite-silicon tandem devices at the time of certification and exceeded the theoretical Shockley-Queisser limit for single-junction silicon cells (approximately 29.4% for a 1.12 eV bandgap under AM1.5G). The transition from champion cell results on 1 cm² laboratory devices to full-area commercial modules at 26.8% median efficiency represents a cell-to-module loss of approximately 2.7 percentage points, consistent with the losses expected from resistive, optical, and geometric factors inherent in module integration.

## Measurement Protocols

All Oxford PV efficiency certifications are conducted in accordance with IEC 60904 standards for terrestrial photovoltaic devices. Key elements of the measurement protocol include:

- **Spectrum**: AM1.5G (IEC 60904-3), Class A solar simulator with spectral mismatch correction.
- **Temperature**: 25°C ± 1°C, controlled by active thermal management during measurement.
- **Sweep conditions**: Both forward (short-circuit to open-circuit) and reverse sweeps at a sweep rate not exceeding 0.2 V/s; reported values represent stabilized performance after light soaking per IEC 61215-2 MQT 19.1 protocol.
- **Spectral response**: Measured by monochromatic filter-based quantum efficiency system, 300–1200 nm, with bias light to approximate one-sun operating conditions.
- **Module aperture area**: Defined in accordance with IEC 60904-3, excluding frame area.

## Key IV Parameters (Production Module, 2025)

| Parameter | Symbol | Typical Value | Unit |
|-----------|--------|---------------|------|
| Open-circuit voltage | V_oc | 1.88–1.92 | V |
| Short-circuit current density | J_sc | 20.5–21.0 | mA/cm² |
| Fill factor | FF | 76.0–78.0 | % |
| Module power (STC) | P_max | 440–455 | W |
| Module area | A | 1.68 | m² |
| Temperature coefficient (P_max) | γ | -0.26 | %/K |
| Bifaciality factor | φ | 75 ± 5 | % |

The open-circuit voltage of approximately 1.9 V is a distinguishing characteristic of tandem modules, approximately 2.5 times higher than a conventional silicon module and a direct consequence of the series-connected tandem architecture. This higher voltage reduces resistive losses in module interconnects and balance-of-system cabling, providing system-level advantages beyond the module-level efficiency gain.

## Spectral Dependence and Outdoor Performance

The current-matching constraint in two-terminal tandem devices introduces a spectral sensitivity not present in single-junction modules. Under conditions where the incident spectrum differs from the AM1.5G reference — for example, under high air mass (morning/evening) or diffuse irradiance — the current-limiting sub-cell determines the overall tandem current.

Oxford PV's outdoor testing program, conducted at test sites in Oxfordshire (UK), Brandenburg (Germany), and Arizona (US), has characterized the energy yield implications of this spectral sensitivity. Preliminary results indicate:

- Annual energy yield advantage of 15–20% over identically oriented PERC modules at temperate latitude sites (Oxfordshire, 51.7° N).
- Energy yield advantage of 12–17% at high-irradiance desert sites (Arizona, 33.4° N), where higher operating temperatures partially offset the efficiency advantage.
- No statistically significant degradation in spectral matching over diurnal and seasonal cycles for the production-tuned bandgap of 1.65 eV.

## Performance Ratio Modeling

The performance ratio (PR) of Oxford PV tandem modules, defined as the ratio of final system yield to reference yield, is modeled at 82–85% for well-designed systems, compared to 80–83% for conventional silicon modules. The higher PR is attributable to:

1. **Lower temperature coefficient** (-0.26%/K versus -0.34%/K typical for PERC), reducing thermal losses.
2. **Higher voltage operation**, reducing ohmic losses in DC cabling.
3. **Improved low-light response**, attributed to the perovskite cell's high shunt resistance and favorable diode ideality factor at low injection levels.

## Degradation Mechanisms Under Evaluation

### Light-Induced Degradation (LID)

Unlike boron-doped Czochralski silicon, which exhibits LID due to boron-oxygen complex formation, the n-type silicon cells used in Oxford PV tandem modules are inherently LID-resistant. The perovskite top cell has shown negligible LID under standard IEC 61215 light soaking protocols (60 kWh/m² at 50°C).

### Potential-Induced Degradation (PID)

Initial PID testing per IEC 62804 (-1000 V, 85°C, 85% RH, 96 hours) has shown no significant power loss in Oxford PV tandem modules. The glass-glass construction and high-resistivity encapsulant system contribute to PID resistance, though extended-duration testing (500+ hours) remains ongoing.

### Light- and Elevated-Temperature-Induced Degradation (LeTID)

LeTID, a degradation mode associated with hydrogen passivation in silicon, is not expected to be a significant concern for n-type silicon cells. Monitoring of field-deployed modules at the Oxfordshire test site has shown stable performance over 18 months of continuous outdoor exposure.

## References

- NREL. "Best Research-Cell Efficiency Chart." National Renewable Energy Laboratory, accessed April 2025.
- Fraunhofer ISE. "Calibration Certificate CAL-2024-11-087: Oxford PV Tandem Module." November 2024.
- Oxford PV. "Outdoor Performance Characterization: Interim Report." Q1 2025.
- IEC 61215-2:2021. "Terrestrial photovoltaic (PV) modules — Design qualification and type approval — Part 2: Test procedures."
