# 13 — Variable Isp & High Delta-V Analysis

## Classification: Proprietary — ACS Internal Use Only

---

## 1. Variable Specific Impulse Concept

The Helicity Drive achieves variable specific impulse by adjusting the power
deposition profile during each plasma pulse. Specific impulse is proportional
to the square root of the ion temperature at the nozzle throat:

```
I_sp ∝ √(T_i / m_i)
```

where m_i is the ion mass. By controlling the degree of peristaltic compression
(magnetic field gradient) and reconnection heating (current sheet geometry and
number of reconnection sites), the Helicity Drive can modulate T_i — and therefore
I_sp — over a wide range without mechanical reconfiguration.

---

## 2. I_sp Control Mechanisms

| Control Parameter | How It Affects I_sp | Range |
|---|---|---|
| Peristaltic coil current | Higher current → stronger compression → higher T_i → higher I_sp | Adjustable by power supply |
| Gun discharge energy | Higher capacitor bank voltage → faster jet injection → deeper compression → higher T_i | 1–10 kJ per gun |
| Gun count (active) | More guns → more reconnection sites → more total heating → higher T_i | 2–16 guns |
| Fuel mass per pulse | Lower mass → higher energy per ion → higher T_i (but lower thrust) | 10⁻⁶–10⁻⁴ kg |
| Repetition rate | Higher rate → higher time-averaged thrust (does not affect per-pulse I_sp directly) | 1–100 Hz |

The combination of coil current and gun discharge energy provides the primary
I_sp adjustment; gun count and repetition rate provide thrust adjustment.

---

## 3. I_sp vs. Thrust Trade Space

| Operating Point | I_sp (s) | Thrust (N) per Gun | Power per Gun (kW) | Efficiency |
|---|---|---|---|---|
| High-thrust, low-I_sp | 3,000 | 5–50 | 50–500 | 0.3–0.5 |
| Balanced | 10,000 | 1–10 | 10–100 | 0.4–0.6 |
| High-I_sp, low-thrust | 25,000 | 0.1–1 | 1–10 | 0.5–0.7 |

Efficiency is defined as the ratio of directed kinetic power in the exhaust jet
to the total electrical input power to the guns and coils:

```
η = (½ ṁ v_ex²) / P_electrical
```

The efficiency increases with I_sp because a larger fraction of the input energy
appears as ion thermal energy (which converts to exhaust velocity) rather than as
radiation, ionization overhead, or electrode heating.

---

## 4. Delta-V Budget Analysis

The rocket equation governs delta-V:

```
ΔV = g₀ · I_sp · ln(m₀ / m_f)
```

where m₀ is the initial mass (spacecraft + fuel) and m_f is the final mass
(spacecraft after fuel depletion). High I_sp reduces the fuel fraction required
for a given ΔV. The table below compares fuel fractions for a ΔV of 100 km/s:

| I_sp (s) | m_fuel / m₀ | Fuel fraction (%) |
|---|---|---|
| 3,000 | 0.966 | 96.6% |
| 10,000 | 0.640 | 64.0% |
| 25,000 | 0.335 | 33.5% |
| 30,000 | 0.288 | 28.8% |

At I_sp = 30,000 s, a spacecraft can deliver more than 70% of its initial mass
as dry mass (payload + structure + propulsion dry mass) after executing a 100
km/s maneuver — a regime inaccessible to chemical or even nuclear thermal
propulsion.

---

## 5. Comparison to Competing Propulsion Technologies

| Technology | I_sp (s) | Thrust (N) | ΔV for 50% fuel fraction (km/s) | TRL |
|---|---|---|---|---|
| Chemical (H₂/O₂) | 450 | 10⁵–10⁷ | 3.1 | 9 |
| Nuclear Thermal (NTP) | 900 | 10⁴–10⁶ | 6.4 | 5–6 |
| Nuclear Electric (NEP) | 3,000–5,000 | 10⁻¹–10² | 20–35 | 4–5 |
| Solar Electric (SEP) | 2,000–4,000 | 10⁻²–10⁻¹ | 13–27 | 7–8 |
| Helicity Drive (projected) | 3,000–30,000 | 10¹–10⁵ | 20–210 | 2–3 |

The Helicity Drive occupies a unique position: it combines the high I_sp of
electric propulsion with thrust levels approaching those of nuclear thermal
propulsion, and it does so without the mass penalty of a nuclear reactor (for
NEP) or the thermal limits of solid-core NTP.

---

## 6. Mars Transit Application

For a Mars transfer vehicle, the delta-V requirement for a fast conjunction-
class trajectory is approximately 15–30 km/s (depending on the desired transit
time). At I_sp = 10,000 s:

```
m_fuel / m₀ = 1 - exp(-ΔV / (g₀ · I_sp))
            = 1 - exp(-15,000 / 98,100)
            ≈ 0.142  (14.2% fuel fraction for 15 km/s)
```

This compares to approximately 60–80% fuel fraction for a chemical Mars
transfer vehicle, enabling a dramatic reduction in initial mass in low Earth
orbit — or, equivalently, a dramatic increase in payload fraction and crew
habitat capability.

---

## 7. Fuel Mass Claims

Helicity Space claims that fusion propulsion using the Helicity Drive can
extract "10 million times more energy per unit mass of fuel than chemical
rockets." This figure is derived from the ratio of fusion energy density to
chemical energy density:

```
E_fusion (D-He³) ≈ 3.5 × 10¹⁴ J/kg
E_chemical (H₂/O₂) ≈ 1.4 × 10⁷ J/kg
Ratio ≈ 2.5 × 10⁷ (25 million)

Adjusted for propulsion efficiency:
η_fusion × 3.5 × 10¹⁴ / (η_chemical × 1.4 × 10⁷)

With η_fusion ≈ 0.5 and η_chemical ≈ 0.7:
≈ 1.8 × 10⁷ ≈ 10 million
```

This claim is physically consistent with known fusion fuel energy densities but
assumes that the propulsion system can convert fusion energy to thrust with
comparable efficiency to chemical rockets — a proposition that remains to be
validated experimentally.
