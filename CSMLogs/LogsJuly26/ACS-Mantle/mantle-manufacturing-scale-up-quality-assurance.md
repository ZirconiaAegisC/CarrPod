# Mantle Manufacturing and Scale-Up — Quality Assurance System

## Quality Framework

Mantle operates a quality management system aligned with ISO 9001:2015
requirements, adapted for the unique challenges of additive manufacturing
of precision tooling. The quality system spans incoming material inspection,
in-process monitoring, final part verification, and field performance tracking.

## Incoming Material Qualification

### FMP Paste Characterization

Every production batch of FMP material undergoes a mandatory qualification
protocol before release to customers:

- **Particle size distribution**: Laser diffraction analysis must show D10,
  D50, and D90 values within specified control limits. Out-of-spec distribution
  indicates potential agglomeration or settling during storage and transport.
- **Binder content**: Thermogravimetric analysis determines the weight fraction
  of metal powder versus thermoplastic binder. Target binder content is 6.2
  to 7.8 weight percent for H13 and 5.8 to 7.2 weight percent for P20.
- **Rheology**: Capillary viscometry measures apparent viscosity at the
  extrusion temperature. Viscosity must fall within a narrow band to ensure
  consistent extrusion behavior across batches.
- **Sinterability**: A standard test coupon is printed, debound, and sintered
  from each batch. The sintered density must exceed 98 percent of theoretical
  density for batch release.

### Certificate of Analysis

Each cartridge ships with a QR-coded certificate of analysis accessible via
the Mantle customer portal. The certificate links to the full qualification
data for the batch from which the cartridge was filled.

## In-Process Monitoring

### Build Monitoring

The P-200 continuously monitors and logs:

- Extrusion head temperature at three zones, sampled at 10 Hz
- Extrusion pressure, sampled at 100 Hz — anomalies indicate nozzle clogs
  or inconsistent material flow
- Build platform temperature distribution from the thermocouple array,
  sampled at 1 Hz
- Ambient temperature and humidity in the machine enclosure
- Layer deposition time — deviations from expected time indicate changes
  in extrusion rate that may affect part quality

All monitoring data is time-stamped and associated with the part serial
number in Mantle's cloud database.

### Furnace Cycle Logging

Both the debinding and sintering furnaces log complete thermal histories
at 1-minute intervals. Key monitored parameters include:

- Chamber temperature at three thermocouple positions
- Gas flow rates for nitrogen and hydrogen
- Oxygen concentration in the sintering atmosphere — must remain below
  50 ppm to prevent oxidation
- Chamber pressure — deviations indicate seal failures or gas supply issues

Post-cycle, the furnace controller compares the actual thermal profile against
the programmed profile and flags any deviations exceeding specified tolerances.
Out-of-tolerance cycles trigger a hold on the affected parts pending
engineering review.

### First Article Inspection

For new tool designs or the first insert produced from a new customer program,
Mantle performs a full first article inspection (FAI) using a coordinate
measuring machine independent of the P-200's on-machine probing. The FAI
report includes:

- Dimensional measurement of all features on the customer's inspection plan,
  typically 50 to 200 measured points
- Surface roughness measurement at multiple locations using a contact
  profilometer
- Hardness measurement at three locations on the insert face
- Dye penetrant inspection for surface cracks or porosity
- Documentation of any non-conformances with disposition (use-as-is, rework,
  or scrap)

The FAI package ships with the insert and serves as the baseline quality
record for the tooling program.

## Production Lot Validation

For multi-insert production programs, Mantle implements statistical process
control with reduced inspection frequency once the process demonstrates
capability:

- **Initial capability study**: 100 percent inspection of the first 10 inserts
  produced for a given geometry
- **Process capability index (Cpk)**: Must exceed 1.33 for critical dimensions
  before transitioning to reduced inspection
- **Reduced inspection**: One insert per lot of 5 undergoes full dimensional
  inspection; remaining inserts receive visual inspection and hardness check only
- **Out-of-control response**: Any measurement exceeding control limits triggers
  100 percent inspection of the affected lot and root cause investigation

## Field Performance Tracking

Mantle maintains a database of field performance data collected from customer
production environments. Key tracked metrics include:

- Insert life in production cycles before failure or retirement
- Failure modes: wear, cracking, corrosion, dimensional drift
- Correlation of failure modes with molding parameters (material, temperature,
  cycle time, injection pressure)
- Comparison of FMP insert life with conventionally manufactured inserts in
  the same application

This field data feeds back into Mantle's design guidelines and process
parameter optimization, creating a continuous improvement loop that
systematically raises the performance ceiling of FMP tooling inserts.
