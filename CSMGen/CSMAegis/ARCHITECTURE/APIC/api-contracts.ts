// ============================================================
// CORTEX ARCHITECTURE — APIC-001: API Contracts v1.0.0
// DIRECTOR-0019 | Kael Forge | 2026-07-06
// Target: FOUNDRY (0020) + SENTINEL (0023) — Endpoint Contracts
// Contract version: 1.0.0
// ============================================================

// ----------------------------------------------------------------
// 1.0 — GLOBAL STANDARDS
// ----------------------------------------------------------------

export const API_VERSION = "v1";
export const BASE_PATH = `/api/${API_VERSION}`;

export enum HttpMethod {
  GET    = "GET",
  POST   = "POST",
  PUT    = "PUT",
  PATCH  = "PATCH",
  DELETE = "DELETE",
}

export enum HttpStatus {
  OK                  = 200,
  CREATED             = 201,
  NO_CONTENT          = 204,
  BAD_REQUEST         = 400,
  UNAUTHORIZED        = 401,
  FORBIDDEN           = 403,
  NOT_FOUND           = 404,
  CONFLICT            = 409,
  UNPROCESSABLE       = 422,
  TOO_MANY_REQUESTS   = 429,
  INTERNAL_ERROR      = 500,
  SERVICE_UNAVAILABLE = 503,
}

// 1.1 — Standard Response Envelope
//   ALL responses use this structure. No bare data at top level.

export interface ApiResponse<T> {
  success: boolean;
  data: T;
  meta?: ResponseMeta;
  error?: ApiError;
}

export interface ResponseMeta {
  timestamp: string;        // ISO 8601
  requestId: string;        // UUID v4 — correlates client→server logs
  version: string;          // API version
  pagination?: Pagination;
}

export interface ApiError {
  code: string;             // Machine-readable, e.g. "VALIDATION_ERROR"
  message: string;          // Human-readable
  details?: unknown;        // Structured error context (field errors, etc.)
  statusCode: HttpStatus;
}

export interface Pagination {
  page: number;
  pageSize: number;
  totalItems: number;
  totalPages: number;
  hasNext: boolean;
  hasPrevious: boolean;
}

// 1.2 — Error Codes (global catalog — SENTINEL tests against these)

export enum ErrorCode {
  VALIDATION_ERROR          = "VALIDATION_ERROR",
  AUTHENTICATION_REQUIRED   = "AUTHENTICATION_REQUIRED",
  INSUFFICIENT_PERMISSIONS  = "INSUFFICIENT_PERMISSIONS",
  RESOURCE_NOT_FOUND        = "RESOURCE_NOT_FOUND",
  RESOURCE_CONFLICT         = "RESOURCE_CONFLICT",
  RATE_LIMIT_EXCEEDED       = "RATE_LIMIT_EXCEEDED",
  INVALID_REQUEST           = "INVALID_REQUEST",
  INTERNAL_ERROR            = "INTERNAL_ERROR",
  DATABASE_ERROR            = "DATABASE_ERROR",
  SHIELD_MEASUREMENT_FAILED = "SHIELD_MEASUREMENT_FAILED",
  MXENE_THICKNESS_OOT       = "MXENE_THICKNESS_OOT",   // 45 μm ± 2 μm violated
  SE_BELOW_MINIMUM          = "SE_BELOW_MINIMUM",      // SE < 148 dB
  TEMPERATURE_OOR           = "TEMPERATURE_OOR",        // Out of operating range
  DEPLOYMENT_VALIDATION     = "DEPLOYMENT_VALIDATION",
}

// ------------------------------------------------------------------
// 2.0 — AUTH ENDPOINTS
// ------------------------------------------------------------------

// POST /api/v1/auth/login
export interface AuthLoginRequest {
  email: string;
  password: string;         // Never logged, never stored in plaintext
}

export interface AuthLoginResponse {
  accessToken: string;      // JWT, 15min expiry
  refreshToken: string;     // Opaque, 7d expiry
  expiresAt: string;        // ISO 8601 — access token expiry
  user: UserProfile;
}

// POST /api/v1/auth/refresh
export interface AuthRefreshRequest {
  refreshToken: string;
}

export interface AuthRefreshResponse {
  accessToken: string;
  expiresAt: string;
}

// POST /api/v1/auth/logout
export interface AuthLogoutRequest {
  refreshToken: string;     // Server invalidates token
}

// POST /api/v1/auth/mfa/setup
export interface MFASetupResponse {
  secret: string;           // TOTP secret
  qrCodeUrl: string;
  recoveryCodes: string[];  // 10 single-use codes
}

// POST /api/v1/auth/mfa/verify
export interface MFAVerifyRequest {
  code: string;
}

export interface UserProfile {
  id: string;
  email: string;
  name: string;
  role: UserRole;
  mfaEnabled: boolean;
  createdAt: string;
}

export enum UserRole {
  ADMIN       = "admin",
  ENGINEER    = "engineer",
  TECHNICIAN  = "technician",
  VIEWER      = "viewer",
  AUDITOR     = "auditor",
}

// ------------------------------------------------------------------
// 3.0 — SHIELD ENDPOINTS
// ------------------------------------------------------------------

// GET /api/v1/shields
export interface ShieldListParams {
  page?: number;
  pageSize?: number;
  sort?: "serialNumber" | "manufacturingDate" | "qualityGrade";
  order?: "asc" | "desc";
  qualityGrade?: string;
  status?: string;
  search?: string;          // Search serialNumber or site name
}

export type ShieldListResponse = ApiResponse<AegisCShieldAssembly[]>;

// GET /api/v1/shields/:shieldId
export type ShieldDetailResponse = ApiResponse<AegisCShieldAssembly>;

// POST /api/v1/shields
export interface ShieldCreateRequest {
  serialNumber: string;
  layerSpecs: AegisCShieldAssembly["layerSpecs"];
  manufacturingDate: string;
  manufacturedBy: string;
  phoenixProtocol: PhoenixProtocolData;
}

export type ShieldCreateResponse = ApiResponse<AegisCShieldAssembly>;

// PATCH /api/v1/shields/:shieldId
export interface ShieldUpdateRequest {
  qualityGrade?: "A" | "B" | "C" | "reject";
  status?: DeploymentStatus;
}

export type ShieldUpdateResponse = ApiResponse<AegisCShieldAssembly>;

// ------------------------------------------------------------------
// 4.0 — MEASUREMENT ENDPOINTS
// ------------------------------------------------------------------

// GET /api/v1/shields/:shieldId/measurements
export interface MeasurementListParams {
  page?: number;
  pageSize?: number;
  type?: MeasurementType;
  layer?: ShieldLayer;
  startDate?: string;       // ISO 8601 date range start
  endDate?: string;         // ISO 8601 date range end
  passed?: boolean;         // Filter by tolerance check
}

export type MeasurementListResponse = ApiResponse<ShieldMeasurement[]>;

// POST /api/v1/shields/:shieldId/measurements
export interface MeasurementCreateRequest {
  layer: ShieldLayer;
  measurementType: MeasurementType;
  value: number;
  unit: string;
  instrumentId: string;
  technicianId: string;
}

export type MeasurementCreateResponse = ApiResponse<ShieldMeasurement>;

// GET /api/v1/shields/:shieldId/measurements/latest
//   Returns the most recent measurement of each type.
//   SENTINEL: test that all MeasurementType values are covered.
export type LatestMeasurementsResponse = ApiResponse<Record<MeasurementType, ShieldMeasurement | null>>;

// ------------------------------------------------------------------
// 5.0 — DEPLOYMENT ENDPOINTS
// ------------------------------------------------------------------

// GET /api/v1/deployments
export interface DeploymentListParams {
  page?: number;
  pageSize?: number;
  status?: DeploymentStatus;
  region?: string;
  search?: string;
}

export type DeploymentListResponse = ApiResponse<ShieldDeployment[]>;

// GET /api/v1/deployments/:deployId
export type DeploymentDetailResponse = ApiResponse<ShieldDeployment>;

// POST /api/v1/deployments
export interface DeploymentCreateRequest {
  shieldId: string;
  deploymentSiteId: string;
  location: GeoLocation;
  environmentalConditions: EnvironmentalSnapshot;
}

export type DeploymentCreateResponse = ApiResponse<ShieldDeployment>;

// PATCH /api/v1/deployments/:deployId
export interface DeploymentUpdateRequest {
  status?: DeploymentStatus;
  location?: GeoLocation;
}

export type DeploymentUpdateResponse = ApiResponse<ShieldDeployment>;

// POST /api/v1/deployments/:deployId/maintenance
export interface MaintenanceCreateRequest {
  type: MaintenanceRecord["type"];
  layerAffected?: ShieldLayer;
  findings: string;
  resolution: string;
  downtimeMinutes: number;
}

export type MaintenanceCreateResponse = ApiResponse<MaintenanceRecord>;

// ------------------------------------------------------------------
// 6.0 — ALERT ENDPOINTS
// ------------------------------------------------------------------

// GET /api/v1/alerts
export interface AlertListParams {
  page?: number;
  pageSize?: number;
  severity?: AlertSeverity;
  shieldId?: string;
  acknowledged?: boolean;
  startDate?: string;
  endDate?: string;
}

export type AlertListResponse = ApiResponse<ShieldAlert[]>;

// GET /api/v1/alerts/unacknowledged/count
//   Returns counts by severity. SENTINEL: validate returned shape.
export interface UnacknowledgedCountResponse {
  critical: number;
  warning: number;
  info: number;
  total: number;
}

// POST /api/v1/alerts/:alertId/acknowledge
export interface AlertAcknowledgeRequest {
  acknowledgedBy: string;
}

export type AlertAcknowledgeResponse = ApiResponse<ShieldAlert>;

// POST /api/v1/alerts/acknowledge-bulk
export interface AlertBulkAcknowledgeRequest {
  alertIds: string[];
  acknowledgedBy: string;
}

// ------------------------------------------------------------------
// 7.0 — HEALTH & MONITORING ENDPOINTS
// ------------------------------------------------------------------

// GET /api/v1/health
export interface HealthResponse {
  status: "healthy" | "degraded" | "unhealthy";
  timestamp: string;
  version: string;
  uptimeSeconds: number;
  checks: {
    database: { status: "ok" | "error"; latencyMs: number };
    redis: { status: "ok" | "error"; latencyMs: number };
    queue: { status: "ok" | "error"; pendingJobs: number };
    disk: { status: "ok" | "error"; usedPercent: number };
  };
}

// GET /api/v1/health/live     → 200 if process alive (no dependency check)
// GET /api/v1/health/ready    → 200 if all dependencies healthy (db, redis, etc.)

// ------------------------------------------------------------------
// 8.0 — PHOENIX PROTOCOL ENDPOINTS
// ------------------------------------------------------------------

// GET /api/v1/phoenix/summary
export interface PhoenixSummaryResponse {
  totalShields: number;
  averageRecyclabilityScore: number;
  totalRecycledContentKg: number;
  totalCarbonFootprintKgCO2: number;
  shieldsByEOLPathway: Record<string, number>;
  materialSourceBreakdown: {
    virgin: number;    // percentage
    recycled: number;
    upcycled: number;
    reclaimed: number;
  };
}

// GET /api/v1/shields/:shieldId/phoenix
export type ShieldPhoenixResponse = ApiResponse<PhoenixProtocolData>;

// ------------------------------------------------------------------
// 9.0 — AUTH MIDDLEWARE CONTRACT (FOUNDRY must implement)
// ------------------------------------------------------------------

export interface AuthMiddleware {
  // Extracts and validates JWT from Authorization: Bearer <token>
  // On success: attaches `req.user: UserProfile` to request context
  // On failure: returns 401 ApiError with AUTHENTICATION_REQUIRED
  authenticate: () => void;

  // Checks user role against required roles
  // On failure: returns 403 ApiError with INSUFFICIENT_PERMISSIONS
  authorize: (roles: UserRole[]) => void;

  // Rate limits per user/IP. Default: 100 req/min for standard, 10 req/min for auth.
  // On exceed: returns 429 ApiError with RATE_LIMIT_EXCEEDED
  rateLimiter: (windowMs: number, maxRequests: number) => void;
}

// ------------------------------------------------------------------
// 10.0 — SENTINEL TEST CONTRACTS (what must be tested)
// ------------------------------------------------------------------
//
// For every endpoint, SENTINEL must verify:
//
// 1. Contract Shape:
//    - Response matches ApiResponse<T> envelope
//    - Data field matches the declared type (TypeScript compile-time + runtime)
//    - Error responses match ApiError shape
//
// 2. HTTP Semantics:
//    - Correct status codes per endpoint (200/201/204/400/401/403/404/422/500)
//    - CORS headers present on all responses
//    - Content-Type: application/json on all responses
//    - Security headers: X-Content-Type-Options, X-Frame-Options, CSP, HSTS
//
// 3. Validation:
//    - Invalid request bodies return 422 with VALIDATION_ERROR
//    - Missing required fields return specific field-level errors in `details`
//    - Invalid UUIDs in path params return 404
//    - MXene thickness outside 43-47 μm returns 422 with MXENE_THICKNESS_OOT
//    - SE below 148 dB returns 422 with SE_BELOW_MINIMUM
//
// 4. Auth:
//    - Missing Authorization header → 401
//    - Expired JWT → 401
//    - Invalid role for endpoint → 403
//    - Valid token → 200 with populated req.user
//
// 5. Pagination:
//    - Negative page/pageSize → 422
//    - pageSize > 100 → clamped to 100
//    - hasNext/hasPrevious accurate for first/last/middle pages
//    - totalItems consistent across pages
//
// 6. Rate Limiting:
//    - 429 after exceeding window
//    - Retry-After header present on 429 responses
//    - Different limits for auth vs data endpoints
//
// SENTINEL: Generate API contract tests from this file.
// Use the type definitions to validate response shapes at runtime (zod or io-ts).
// Every new endpoint added must update this contract file — CORTEX gates the change.
//
// ------------------------------------------------------------------
// END APIC-001 v1.0.0 — DIRECTOR-0019 CORTEX
// ================================================================

import type {
  AegisCShieldAssembly,
  ShieldMeasurement,
  ShieldAlert,
  ShieldDeployment,
  ShieldLayer,
  MeasurementType,
  DeploymentStatus,
  AlertSeverity,
  MaintenanceRecord,
  PhoenixProtocolData,
  GeoLocation,
  EnvironmentalSnapshot,
} from "../MDM/material-data-model";

export type {
  AegisCShieldAssembly,
  ShieldMeasurement,
  ShieldAlert,
  ShieldDeployment,
  ShieldLayer,
  MeasurementType,
  DeploymentStatus,
  AlertSeverity,
  MaintenanceRecord,
  PhoenixProtocolData,
  GeoLocation,
  EnvironmentalSnapshot,
};
