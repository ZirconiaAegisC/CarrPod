# ACS-Redwire-Space-Infrastructure Dossier
## Document 03 — SabreSat: VLEO Platform and DARPA Otter

### 3.1 Platform Design Philosophy

SabreSat represents Redwire's dedicated very-low-Earth-orbit spacecraft bus,
optimized for sustained operations in orbital altitudes between 100 and 350
kilometers. At these altitudes, residual atmospheric drag would cause a
conventional satellite to deorbit within days to weeks. SabreSat addresses this
challenge through an integrated design approach combining aerodynamic shaping,
air-breathing electric propulsion, and high-efficiency power generation.

### 3.2 Aerodynamic Configuration

The SabreSat bus employs a low-drag profile with aspect ratios and surface
treatments designed to minimize the coefficient of drag while maximizing usable
payload volume. The spacecraft body functions as a lifting surface at VLEO
altitudes, generating modest aerodynamic lift that reduces the propulsive
energy required to maintain orbit. Computational fluid dynamics simulations
validated through the ESA Skimsat precursor work informed the SabreSat
aerodynamic design envelope.

### 3.3 Air-Breathing Electric Propulsion

The defining feature of the SabreSat platform is its integration with an
air-breathing electric propulsion system developed under the DARPA Otter
program. Unlike conventional electric propulsion, which carries its entire
propellant mass at launch, an air-breathing system collects residual
atmospheric particles at orbital altitude, ionizes them, and accelerates the
resulting plasma to generate thrust. This approach effectively eliminates the
propellant mass penalty that limits conventional VLEO mission life.

The propulsion system comprises an intake collector, an ionization chamber, and
a gridded ion thruster optimized for operation across a range of atmospheric
densities encountered between 150 and 300 kilometers. Key technical challenges
include maintaining ionization efficiency as atmospheric composition varies
with altitude and solar activity, managing thermal loads from atmospheric
heating during intake, and preventing electrode erosion over multi-year mission
durations.

### 3.4 Power Subsystem Architecture

SabreSat incorporates high-efficiency multi-junction solar arrays sized to
generate sufficient power for both the electric propulsion system and the
payload suite. Power management electronics condition the solar array output
for direct-drive operation of the electric thruster, minimizing conversion
losses that would otherwise reduce system efficiency.

### 3.5 Attitude Determination and Control

Operating in the VLEO regime complicates attitude control due to aerodynamic
torques that can overwhelm conventional reaction wheels. SabreSat employs a
hybrid attitude control system combining high-torque reaction wheels, magnetic
torquers for momentum desaturation, and aerodynamic control surfaces that
leverage the spacecraft's body shape to produce control moments. The guidance,
navigation, and control algorithm incorporates real-time atmospheric density
estimates derived from onboard accelerometer data and GPS-derived orbital
decay rates.

### 3.6 Mission Applications

SabreSat enables several mission classes previously constrained by VLEO
endurance limitations:

- Ultra-high-resolution optical imaging at resolutions exceeding those
  achievable from traditional LEO altitudes.
- Radio-frequency geolocation and signals intelligence with reduced range to
  target emitters.
- Responsive tactical reconnaissance with rapid revisit rates enabled by short
  orbital periods at VLEO altitudes.
- Atmospheric science and space weather monitoring within the poorly sampled
  thermosphere layer.

### 3.7 DARPA Otter Program Status

The DARPA Otter program, awarded to Redwire as prime contractor, is structured
in multiple phases culminating in an on-orbit demonstration of air-breathing
electric propulsion at VLEO altitudes. Phase-specific milestones include
ground-based propulsion testing in relevant vacuum and flow conditions,
integrated spacecraft bus qualification, and a launch-ready flight unit. The
program's success metrics include demonstrated thrust levels sufficient to
overcome atmospheric drag, sustained orbital operations for a defined duration,
and the collection of performance telemetry validating the air-breathing
concept at flight scale.

### 3.8 Competitive Positioning

SabreSat occupies a unique position in the VLEO market, where competitors
include the European Space Agency's Skimsat reference designs and classified
U.S. government programs. Redwire's dual-track approach — SabreSat for U.S.
defense and intelligence customers and Phantom for European partners —
positions the company as the only supplier with operational VLEO platforms
addressing both transatlantic markets.
