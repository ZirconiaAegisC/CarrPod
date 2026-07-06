// ============================================================
// CORTEX ARCHITECTURE — MDM-001: Material Data Model v1.0.0
// DIRECTOR-0019 | Kael Forge | 2026-07-06
// Target: FOUNDRY (0020) — Database Schema + Type System
// Contract version: 1.0.0 — BREAKING changes require version bump
// ============================================================

// ----------------------------------------------------------------
// 1.0 — AEGIS-C COMPOSITE SHIELD: FIVE-LAYER STACK
// ----------------------------------------------------------------

export type LayerIndex = 0 | 1 | 2 | 3 | 4;

export enum ShieldLayer {
  OUTER_ENVIRONMENTAL = 0,   // L0: Outer shell — weather, impact, UV resistance
  ADHESIVE_BONDING   = 1,   // L1: Bonding matrix — inter-layer adhesion
  MXENE_EMI          = 2,   // L2: MXene EMI — electromagnetic interference layer, 45 μm ± 2 μm
  ZRB2_SIC_CERAMIC   = 3,   // L3: ZrB₂-SiC — ceramic armor, primary dielectric
  DIELECTRIC_SUBSTRATE = 4, // L4: Substrate — base dielectric layer
}

export const LAYER_DISPLAY_NAMES: Record<ShieldLayer, string> = {
  [ShieldLayer.OUTER_ENVIRONMENTAL]: "Outer Environmental Shell",
  [ShieldLayer.ADHESIVE_BONDING]:    "Adhesive Bonding Matrix",
  [ShieldLayer.MXENE_EMI]:           "MXene EMI Layer",
  [ShieldLayer.ZRB2_SIC_CERAMIC]:    "ZrB₂-SiC Ceramic Armor",
  [ShieldLayer.DIELECTRIC_SUBSTRATE]: "Dielectric Substrate",
};

export const LAYER_ORDER: ShieldLayer[] = [
  ShieldLayer.OUTER_ENVIRONMENTAL,
  ShieldLayer.ADHESIVE_BONDING,
  ShieldLayer.MXENE_EMI,
  ShieldLayer.ZRB2_SIC_CERAMIC,
  ShieldLayer.DIELECTRIC_SUBSTRATE,
];

// ----------------------------------------------------------------
// 2.0 — MATERIAL PROPERTIES BASE
// ----------------------------------------------------------------

export interface MaterialPropertyRange {
  min: number;
  max: number;
  unit: string;
  nominal: number;
  tolerance: number;   // ± value from nominal
}

export interface FrequencyRange {
  minHz: number;
  maxHz: number;
  stepHz?: number;
}

export interface TemperatureRange {
  minCelsius: number;
  maxCelsius: number;
  operatingMinCelsius: number;
  operatingMaxCelsius: number;
}

// ----------------------------------------------------------------
// 2.1 — SHIELDING EFFECTIVENESS (SE)
//    Core metric: 148-165 dB across 1 kHz to 10 GHz
// ----------------------------------------------------------------

export interface ShieldingEffectiveness {
  frequencyRange: FrequencyRange;
  seRange: MaterialPropertyRange;       // 148-165 dB
  measurementStandard: string;          // IEEE 299, MIL-STD-285
  testConfiguration: "far-field" | "near-field" | "cavity";
}

export const AEGIS_C_SE_DEFAULT: ShieldingEffectiveness = {
  frequencyRange: {
    minHz: 1_000,          // 1 kHz
    maxHz: 10_000_000_000, // 10 GHz
  },
  seRange: {
    min: 148,
    max: 165,
    unit: "dB",
    nominal: 156,
    tolerance: 9,
  },
  measurementStandard: "IEEE 299",
  testConfiguration: "far-field",
};

// ----------------------------------------------------------------
// 3.0 — LAYER-SPECIFIC MATERIAL SPECIFICATIONS
// ----------------------------------------------------------------

// 3.1 — L0: Outer Environmental Shell
export interface EnvironmentalShellSpec {
  material: string;                    // Carbon-fiber reinforced polymer (CFRP) / polycarbonate composite
  thickness: MaterialPropertyRange;    // mm
  uvResistance: "UV-A" | "UV-B" | "UV-C" | "full-spectrum";
  impactResistance: MaterialPropertyRange; // Joules
  ingressProtection: string;           // IP rating, e.g. "IP67"
  colorCode: string;                   // Hex color for dashboard display
  weight: MaterialPropertyRange;       // kg/m²
}

// 3.2 — L1: Adhesive Bonding Matrix
export interface AdhesiveBondingSpec {
  material: string;                    // Epoxy / silicone hybrid
  bondStrength: MaterialPropertyRange; // MPa
  cureTemperature: TemperatureRange;
  thermalExpansionCoefficient: MaterialPropertyRange; // ppm/°C
  thickness: MaterialPropertyRange;    // μm
  shelfLifeDays: number;
}

// 3.3 — L2: MXene EMI Layer (CRITICAL — 45 μm ± 2 μm)
export interface MXeneEMISpec {
  material: string;                    // Ti₃C₂Tₓ MXene
  thickness: MaterialPropertyRange;    // 45 μm ± 2 μm
  conductivity: MaterialPropertyRange; // S/cm
  surfaceChemistry: "OH-terminated" | "F-terminated" | "Cl-terminated" | "mixed";
  delaminationMethod: "MILD" | "HF" | "LiF-HCl" | "electrochemical";
  sheetResistance: MaterialPropertyRange; // Ω/sq
  defectsPerCm2: number;               // Acceptable defect density
}

export const MXENE_EMI_DEFAULT: MXeneEMISpec = {
  material: "Ti₃C₂Tₓ MXene",
  thickness: {
    min: 43,
    max: 47,
    unit: "μm",
    nominal: 45,
    tolerance: 2,
  },
  conductivity: {
    min: 5000,
    max: 15000,
    unit: "S/cm",
    nominal: 10000,
    tolerance: 5000,
  },
  surfaceChemistry: "mixed",
  delaminationMethod: "LiF-HCl",
  sheetResistance: {
    min: 1,
    max: 10,
    unit: "Ω/sq",
    nominal: 5,
    tolerance: 4,
  },
  defectsPerCm2: 0,
};

// 3.4 — L3: ZrB₂-SiC Ceramic Armor
export interface Zrb2SiCCeramicSpec {
  material: string;                    // ZrB₂-SiC composite
  thickness: MaterialPropertyRange;    // mm
  density: MaterialPropertyRange;      // g/cm³
  dielectricConstant: MaterialPropertyRange; // εᵣ at 1 kHz-10 GHz
  dielectricLossTangent: MaterialPropertyRange; // tan δ
  thermalConductivity: MaterialPropertyRange; // W/(m·K)
  flexuralStrength: MaterialPropertyRange; // MPa
  fractureToughness: MaterialPropertyRange; // MPa·√m
  grainSizeMicrons: number;
  porosityPercent: number;
}

// 3.5 — L4: Dielectric Substrate
export interface DielectricSubstrateSpec {
  material: string;                    // Al₂O₃ / AlN / Si₃N₄ base
  thickness: MaterialPropertyRange;    // mm
  dielectricConstant: MaterialPropertyRange;
  breakdownVoltage: MaterialPropertyRange; // kV/mm
  thermalConductivity: MaterialPropertyRange; // W/(m·K)
  surfaceRoughness: MaterialPropertyRange; // nm Ra
}

// ----------------------------------------------------------------
// 4.0 — COMPLETE SHIELD ASSEMBLY
// ----------------------------------------------------------------

export interface AegisCShieldAssembly {
  id: string;                          // UUID v4
  serialNumber: string;                // AG-XXXX-YYYY-ZZZ
  revision: string;                    // Semver of this specification
  layerSpecs: {
    [ShieldLayer.OUTER_ENVIRONMENTAL]: EnvironmentalShellSpec;
    [ShieldLayer.ADHESIVE_BONDING]:    AdhesiveBondingSpec;
    [ShieldLayer.MXENE_EMI]:           MXeneEMISpec;
    [ShieldLayer.ZRB2_SIC_CERAMIC]:    Zrb2SiCCeramicSpec;
    [ShieldLayer.DIELECTRIC_SUBSTRATE]: DielectricSubstrateSpec;
  };
  overallThickness: MaterialPropertyRange; // mm total
  overallWeight: MaterialPropertyRange;   // kg/m² total
  shieldingEffectiveness: ShieldingEffectiveness;
  temperatureRange: TemperatureRange;     // -40°C to +125°C
  manufacturingDate: string;              // ISO 8601
  manufacturedBy: string;                 // Facility ID
  qualityGrade: "A" | "B" | "C" | "reject";
  phoenixProtocol: PhoenixProtocolData;   // Circular economy tracking
}

// ----------------------------------------------------------------
// 5.0 — QUALITY & MEASUREMENT
// ----------------------------------------------------------------

export interface ShieldMeasurement {
  id: string;
  shieldId: string;                    // FK → AegisCShieldAssembly.id
  timestamp: string;                   // ISO 8601
  layer: ShieldLayer;
  measurementType: MeasurementType;
  value: number;
  unit: string;
  passed: boolean;
  toleranceCheck: {
    nominal: number;
    actual: number;
    deviationPercent: number;
    withinTolerance: boolean;
  };
  instrumentId: string;
  technicianId: string;
}

export enum MeasurementType {
  SE_DECIBELS               = "se_db",
  THICKNESS                 = "thickness",
  CONDUCTIVITY              = "conductivity",
  DIELECTRIC_CONSTANT       = "dielectric_constant",
  DIELECTRIC_LOSS_TANGENT   = "dielectric_loss_tangent",
  THERMAL_CONDUCTIVITY      = "thermal_conductivity",
  BOND_STRENGTH             = "bond_strength",
  SURFACE_ROUGHNESS         = "surface_roughness",
  IMPACT_RESISTANCE         = "impact_resistance",
  DEFECT_DENSITY            = "defect_density",
  WEIGHT                    = "weight",
  UV_DEGRADATION            = "uv_degradation",
  BREAKDOWN_VOLTAGE         = "breakdown_voltage",
  SHEET_RESISTANCE          = "sheet_resistance",
  ENVIRONMENTAL_STRESS      = "environmental_stress",
}

// ----------------------------------------------------------------
// 6.0 — PHOENIX PROTOCOL (Circular Economy)
// ----------------------------------------------------------------

export interface PhoenixProtocolData {
  materialProvenance: MaterialProvenance[];
  recyclabilityScore: number;          // 0-100
  recycledContentPercent: number;      // % of shield mass from recycled sources
  endOfLifePathway: EndOfLifePathway;
  carbonFootprintKgCO2: number;        // Total lifecycle CO₂
  recoveryProcessId: string;
}

export interface MaterialProvenance {
  material: string;
  sourceLocation: string;
  sourceType: "virgin" | "recycled" | "upcycled" | "reclaimed";
  certificateUrl?: string;
  batchId: string;
  percentageOfTotal: number;
}

export interface EndOfLifePathway {
  disassemblyDifficulty: "easy" | "moderate" | "difficult";
  layerRecovery: Partial<Record<ShieldLayer, string>>; // Layer → recovery process
  hazardousMaterials: boolean;
  reusablePercent: number;             // % recoverable for direct reuse
  recyclablePercent: number;           // % recyclable through processing
  landfillPercent: number;             // % non-recoverable (target: 0)
}

// ----------------------------------------------------------------
// 7.0 — DEPLOYMENT TRACKING
// ----------------------------------------------------------------

export interface ShieldDeployment {
  id: string;
  shieldId: string;                    // FK → AegisCShieldAssembly.id
  deploymentSiteId: string;
  deploymentDate: string;              // ISO 8601
  installationTechnician: string;
  location: GeoLocation;
  environmentalConditions: EnvironmentalSnapshot;
  status: DeploymentStatus;
  maintenanceHistory: MaintenanceRecord[];
}

export interface GeoLocation {
  latitude: number;
  longitude: number;
  altitudeMeters?: number;
  siteName: string;
  region: string;
}

export interface EnvironmentalSnapshot {
  temperatureCelsius: number;
  humidityPercent: number;
  altitudeMeters: number;
  emFieldBackground: number;           // μT ambient EMI
  timestamp: string;
}

export enum DeploymentStatus {
  PRE_PRODUCTION  = "pre_production",
  IN_PRODUCTION   = "in_production",
  SHIPPED         = "shipped",
  INSTALLING      = "installing",
  OPERATIONAL     = "operational",
  DEGRADED        = "degraded",
  MAINTENANCE     = "maintenance",
  DECOMMISSIONED  = "decommissioned",
}

export interface MaintenanceRecord {
  id: string;
  date: string;
  type: "inspection" | "repair" | "replacement" | "upgrade" | "recalibration";
  technician: string;
  layerAffected?: ShieldLayer;
  findings: string;
  resolution: string;
  downtimeMinutes: number;
}

// ----------------------------------------------------------------
// 8.0 — ALERT SYSTEM
// ----------------------------------------------------------------

export enum AlertSeverity {
  CRITICAL = "critical",   // Immediate shield failure risk
  WARNING  = "warning",    // Degradation detected
  INFO     = "info",       // Scheduled maintenance
  OK       = "ok",         // All nominal
}

export interface ShieldAlert {
  id: string;
  shieldId: string;
  timestamp: string;
  severity: AlertSeverity;
  layer: ShieldLayer;
  measurementType: MeasurementType;
  actualValue: number;
  expectedRange: { min: number; max: number };
  deviationPercent: number;
  message: string;
  acknowledged: boolean;
  acknowledgedBy?: string;
  acknowledgedAt?: string;
  escalationLevel: 0 | 1 | 2 | 3;   // 0=site, 1=regional, 2=national, 3=global
}

// ----------------------------------------------------------------
// 9.0 — DATABASE SCHEMA NOTES (for FOUNDRY/0020)
// ----------------------------------------------------------------
//
// TABLES:
//   shields              → AegisCShieldAssembly
//   layer_specs          → Individual layer specs (JSONB for flexibility)
//   measurements         → ShieldMeasurement (time-series, partition by month)
//   deployments          → ShieldDeployment
//   maintenance_records  → MaintenanceRecord
//   phoenix_protocol     → PhoenixProtocolData
//   material_provenance  → MaterialProvenance
//   alerts               → ShieldAlert (partition by week)
//   environmental_snaps  → EnvironmentalSnapshot
//
// INDEXES:
//   shields(serial_number)            — UNIQUE
//   measurements(shield_id, timestamp) — time-series query
//   measurements(shield_id, measurement_type) — type-filtered query
//   alerts(shield_id, timestamp)      — alert timeline
//   alerts(severity, acknowledged)    — unacknowledged critical filter
//   deployments(status)               — active deployment filter
//   phoenix_protocol(recyclability_score) — sustainability reporting
//
// MIGRATIONS:
//   V1: Core shield assembly + layer specs + measurements
//   V2: Phoenix Protocol + material provenance (add columns, not breaking)
//   V3: Alert system + deployment tracking (new tables)
//
// FOUNDRY — SQL dialects: Use JSONB for layer specs in PostgreSQL,
// TEXT/JSON for SQLite. All timestamps as TIMESTAMPTZ or ISO 8601 TEXT.
// FK constraints: ON DELETE RESTRICT for shield→measurement, shield→alert.
//
// ============================================================
// END MDM-001 v1.0.0 — DIRECTOR-0019 CORTEX
// ============================================================
