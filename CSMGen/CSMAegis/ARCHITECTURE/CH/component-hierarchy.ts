// ============================================================
// CORTEX ARCHITECTURE — CH-001: Component Hierarchy v1.0.0
// DIRECTOR-0019 | Kael Forge | 2026-07-06
// Target: RENDER (0021) — Component Tree + State Architecture
// Contract version: 1.0.0
// ============================================================

// ----------------------------------------------------------------
// 1.0 — APP LAYOUT: ROUTE TREE (Next.js 14 App Router)
// ----------------------------------------------------------------
//
// app/
//   layout.tsx              → RootLayout (Providers: Theme, Auth, Store)
//   page.tsx                → DashboardHome (default route)
//   (auth)/
//     layout.tsx            → AuthLayout (login/register wrapper)
//     login/page.tsx        → LoginPage
//     mfa/page.tsx          → MFAPage
//   (dashboard)/
//     layout.tsx            → DashboardLayout (sidebar + header + main)
//     page.tsx              → DashboardHome (shield overview)
//     shields/
//       page.tsx            → ShieldListPage
//       [shieldId]/
//         page.tsx          → ShieldDetailPage
//         measurements/
//           page.tsx        → ShieldMeasurementsPage
//     deployments/
//       page.tsx            → DeploymentsPage
//       [deployId]/page.tsx → DeploymentDetailPage
//     alerts/
//       page.tsx            → AlertsPage
//     admin/
//       page.tsx            → AdminDashboard (role-gated)
//
// ----------------------------------------------------------------
// 2.0 — COMPONENT TREE: HIERARCHY
// ----------------------------------------------------------------

export enum ComponentLayer {
  FOUNDATION = "foundation",   // Providers, layout shells, theme
  LAYOUT     = "layout",       // Page-level structural components
  FEATURE    = "feature",      // Domain-specific composite components
  PRIMITIVE  = "primitive",    // Reusable atomic UI components
  UTILITY    = "utility",      // Hooks, helpers, formatters
}

// 2.1 — FOUNDATION LAYER (app layout + providers)

export interface FoundationComponents {
  RootLayout: {
    path: "app/layout.tsx";
    children: ["ThemeProvider", "AuthProvider", "StoreProvider", "ToastProvider"];
    metadata: { title: string; description: string };
  };
  ThemeProvider: {
    path: "components/foundation/ThemeProvider.tsx";
    type: "context";
    config: ThemeConfig;
  };
  AuthProvider: {
    path: "components/foundation/AuthProvider.tsx";
    type: "context";
    flow: "JWT + refresh token rotation";
  };
  StoreProvider: {
    path: "components/foundation/StoreProvider.tsx";
    type: "wrapper";
    store: "Zustand <StateRoot>";
  };
}

// 2.2 — LAYOUT LAYER

export interface LayoutComponents {
  DashboardLayout: {
    path: "app/(dashboard)/layout.tsx";
    composition: ["Sidebar", "Header", "MainContent", "Footer"];
  };
  Sidebar: {
    path: "components/layout/Sidebar.tsx";
    navigation: NavItem[];
    responsiveBreakpoints: Breakpoint[];
  };
  Header: {
    path: "components/layout/Header.tsx";
    composition: ["BreadcrumbTrail", "UserMenu", "AlertIndicator", "HeartbeatIndicator"];
  };
  AuthLayout: {
    path: "app/(auth)/layout.tsx";
    composition: ["AuthFormContainer"];
  };
}

// 2.3 — FEATURE LAYER

export interface FeatureComponents {
  // Shield Overview
  ShieldCard:         { path: string; props: ShieldCardProps };
  ShieldDetailPanel:  { path: string; props: ShieldDetailPanelProps };
  ShieldLayerVisual:  { path: string; props: ShieldLayerVisualProps };   // 5-layer cross-section
  SEChart:            { path: string; props: SEChartProps };              // SE vs frequency

  // Monitoring
  StatusCard:         { path: string; props: StatusCardProps };
  HeartbeatIndicator: { path: string; props: HeartbeatIndicatorProps };
  SensorGrid:         { path: string; props: SensorGridProps };
  MeasurementTimeline:{ path: string; props: MeasurementTimelineProps };

  // Alerts
  AlertBanner:        { path: string; props: AlertBannerProps };
  AlertTable:         { path: string; props: AlertTableProps };
  AlertFilterBar:     { path: string; props: AlertFilterBarProps };

  // Deployment
  DeploymentMap:      { path: string; props: DeploymentMapProps };
  DeploymentCard:     { path: string; props: DeploymentCardProps };
  PhoenixScore:       { path: string; props: PhoenixScoreProps };        // Circular economy

  // Command
  CommandConsole:     { path: string; props: CommandConsoleProps };
  ExportPanel:        { path: string; props: ExportPanelProps };
  AdminDashboard:     { path: string; props: AdminDashboardProps };
}

// 2.4 — PRIMITIVE LAYER

export interface PrimitiveComponents {
  Button:         { variants: ButtonVariant[] };
  Card:           { padding: "sm" | "md" | "lg" };
  Badge:          { colors: StatusColor[] };
  Table:          { sortable: boolean; filterable: boolean };
  Chart:          { library: "recharts" | "d3" | "chart.js" };
  Modal:          { animated: boolean; backdropBlur: boolean };
  Tooltip:        { position: "top" | "bottom" | "left" | "right" };
  Spinner:        { sizes: "sm" | "md" | "lg" };
  EmptyState:     { icon: string; message: string; action?: string };
  ErrorBoundary:  { fallback: React.ComponentType };
  Skeleton:       { shapes: "text" | "circle" | "rect" };
  Toast:          { positions: "top-right" | "bottom-right" };
  Input:          { types: "text" | "number" | "date" | "select" };
  Tabs:           { orientation: "horizontal" | "vertical" };
  DropdownMenu:   { items: DropdownItem[] };
  Dialog:         { confirm: boolean };
}

// ----------------------------------------------------------------
// 3.0 — STATE ARCHITECTURE (Zustand — 4 Slices)
// ----------------------------------------------------------------

export interface StateRoot {
  shieldStatus: ShieldStatusSlice;
  deploymentTracking: DeploymentTrackingSlice;
  alertPipeline: AlertPipelineSlice;
  userPreferences: UserPreferencesSlice;
}

// 3.1 — Shield Status Slice
export interface ShieldStatusSlice {
  // State
  shields: Map<string, AegisCShieldAssembly>;      // From MDM AegisCShieldAssembly
  selectedShieldId: string | null;
  measurements: Map<string, ShieldMeasurement[]>;    // shieldId → measurements
  loadingStates: { shields: boolean; measurements: boolean };

  // Actions
  fetchShields: () => Promise<void>;                 // GET /api/shields
  fetchShieldById: (id: string) => Promise<void>;    // GET /api/shields/:id
  fetchMeasurements: (shieldId: string, type?: MeasurementType) => Promise<void>;
  selectShield: (id: string) => void;
  clearSelection: () => void;

  // Computed (derived)
  getShieldById: (id: string) => AegisCShieldAssembly | undefined;
  getLatestMeasurement: (shieldId: string, type: MeasurementType) => ShieldMeasurement | undefined;
  getShieldsByStatus: (status: DeploymentStatus) => AegisCShieldAssembly[];
}

// 3.2 — Deployment Tracking Slice
export interface DeploymentTrackingSlice {
  // State
  deployments: Map<string, ShieldDeployment>;
  activeDeploymentCount: number;
  geoClusters: GeoCluster[];
  loadingStates: { deployments: boolean; geoClusters: boolean };

  // Actions
  fetchDeployments: (filters?: DeploymentFilters) => Promise<void>;
  fetchDeploymentById: (id: string) => Promise<void>;
  fetchGeoClusters: () => Promise<void>;
  addMaintenanceRecord: (deployId: string, record: MaintenanceRecord) => Promise<void>;
  updateDeploymentStatus: (deployId: string, status: DeploymentStatus) => Promise<void>;

  // Computed
  getDeploymentsByStatus: (status: DeploymentStatus) => ShieldDeployment[];
  getDeploymentsByRegion: (region: string) => ShieldDeployment[];
  getUptimePercent: (deployId: string) => number;
}

// 3.3 — Alert Pipeline Slice
export interface AlertPipelineSlice {
  // State
  alerts: ShieldAlert[];
  unacknowledgedCount: number;
  criticalCount: number;
  loadingStates: { alerts: boolean };

  // Actions
  fetchAlerts: (filters?: AlertFilters) => Promise<void>;
  acknowledgeAlert: (alertId: string) => Promise<void>;
  acknowledgeAll: (shieldId: string) => Promise<void>;
  dismissAlert: (alertId: string) => void;

  // Computed
  getAlertsByShield: (shieldId: string) => ShieldAlert[];
  getAlertsBySeverity: (severity: AlertSeverity) => ShieldAlert[];
  getCriticalAlerts: () => ShieldAlert[];
}

// 3.4 — User Preferences Slice
export interface UserPreferencesSlice {
  // State
  theme: "dark" | "light" | "system";
  sidebarCollapsed: boolean;
  defaultShieldView: "grid" | "list" | "map";
  alertNotificationSound: boolean;
  refreshIntervalMs: number;       // Default: 30000 (30s)
  selectedBreakpoint?: string;     // For responsive dev tools

  // Actions
  setTheme: (theme: "dark" | "light" | "system") => void;
  toggleSidebar: () => void;
  setDefaultShieldView: (view: "grid" | "list" | "map") => void;
  setRefreshInterval: (ms: number) => void;
  resetToDefaults: () => void;

  // Persistence
  hydrateFromLocalStorage: () => void;
  persistToLocalStorage: () => void;
}

// ----------------------------------------------------------------
// 4.0 — DATA FLOW: CORTEX Types → API → Zustand → Components
// ----------------------------------------------------------------
//
// ┌─────────────────────────────────────────────────────────────────┐
// │                    CORTEX Type System (MDM)                     │
// │  AegisCShieldAssembly, ShieldMeasurement, ShieldAlert, etc.     │
// └─────────────────────────┬───────────────────────────────────────┘
//                           │ imported by
//                           ▼
// ┌─────────────────────────────────────────────────────────────────┐
// │              FOUNDRY API Layer (Express/Fastify)                 │
// │  REST endpoints return typed JSON per CORTEX APIC contracts     │
// └─────────────────────────┬───────────────────────────────────────┘
//                           │ HTTP + JSON (typed responses)
//                           ▼
// ┌─────────────────────────────────────────────────────────────────┐
// │                RENDER API Client (lib/api/)                      │
// │  apiClient.ts — typed fetch wrapper, error handling, auth       │
// │  Generated from APIC contracts, returns MDM types               │
// └─────────────────────────┬───────────────────────────────────────┘
//                           │ typed data
//                           ▼
// ┌─────────────────────────────────────────────────────────────────┐
// │          Zustand Store (stores/)                                 │
// │  shieldStatus, deploymentTracking, alertPipeline, userPrefs    │
// │  Actions call API layer, store results with loading/error      │
// └─────────────────────────┬───────────────────────────────────────┘
//                           │ useStore() selector hooks
//                           ▼
// ┌─────────────────────────────────────────────────────────────────┐
// │          React Components (components/feature/)                  │
// │  Read from store. Dispatch actions. Pure rendering.             │
// │  Presentational components receive props, not stores.           │
// └─────────────────────────────────────────────────────────────────┘
//
// ----------------------------------------------------------------
// 5.0 — THEME CONFIGURATION
// ----------------------------------------------------------------

export interface ThemeConfig {
  dark: {
    background:       "#0a0a0f";
    surface:          "#1a1a2e";
    surfaceElevated:  "#16213e";
    border:           "#2a2a4a";
    accent:           "#00ff88";   // Primary green
    accentDim:        "#00cc6a";
    text: {
      primary:        "#e4e4e7";
      secondary:      "#a1a1aa";
      muted:          "#71717a";
    };
    status: {
      ok:             "#00ff88";
      warning:        "#f59e0b";
      critical:       "#ef4444";
      info:           "#3b82f6";
    };
    chart: string[];               // 8-color palette for data visualization
  };
  breakpoints: {
    mobile:    320;
    tablet:    768;
    laptop:    1024;
    desktop:   1440;
  };
  motion: {
    reducedMotion: boolean;        // WCAG — respects prefers-reduced-motion
    springConfig: { stiffness: number; damping: number };
  };
}

export const DEFAULT_THEME: ThemeConfig = {
  dark: {
    background:       "#0a0a0f",
    surface:          "#1a1a2e",
    surfaceElevated:  "#16213e",
    border:           "#2a2a4a",
    accent:           "#00ff88",
    accentDim:        "#00cc6a",
    text: {
      primary:        "#e4e4e7",
      secondary:      "#a1a1aa",
      muted:          "#71717a",
    },
    status: {
      ok:             "#00ff88",
      warning:        "#f59e0b",
      critical:       "#ef4444",
      info:           "#3b82f6",
    },
    chart: [
      "#00ff88", "#3b82f6", "#f59e0b", "#ef4444",
      "#8b5cf6", "#06b6d4", "#f97316", "#84cc16",
    ],
  },
  breakpoints: {
    mobile:  320,
    tablet:  768,
    laptop:  1024,
    desktop: 1440,
  },
  motion: {
    reducedMotion: true,
    springConfig: { stiffness: 200, damping: 20 },
  },
};

// ----------------------------------------------------------------
// 6.0 — COMPONENT CONTRACTS (what each feature component needs)
// ----------------------------------------------------------------

export interface ShieldCardProps {
  shield: AegisCShieldAssembly;
  latestSE: number | null;
  alertCount: { critical: number; warning: number };
  onClick: (shieldId: string) => void;
  compact?: boolean;
}

export interface StatusCardProps {
  title: string;
  value: string | number;
  subtitle?: string;
  trend?: { direction: "up" | "down" | "flat"; percent: number };
  icon: React.ReactNode;
  color: "ok" | "warning" | "critical" | "info";
  loading?: boolean;
}

export interface HeartbeatIndicatorProps {
  lastBeatTimestamp: string;
  pollingActive: boolean;
  staleThresholdMs: number;   // > 30s = STALE display
  offlineThresholdMs: number; // > 120s = OFFLINE display
  onManualRefresh: () => void;
}

export interface SensorGridProps {
  shieldId: string;
  measurements: ShieldMeasurement[];
  selectedLayers: ShieldLayer[];
  onLayerToggle: (layer: ShieldLayer) => void;
  timeRange: { start: string; end: string };
  onTimeRangeChange: (range: { start: string; end: string }) => void;
}

export interface AlertBannerProps {
  alerts: ShieldAlert[];
  onDismiss: (alertId: string) => void;
  onAcknowledgeAll: () => void;
  maxVisible?: number;
  autoHideTimeoutMs?: number;
}

export interface CommandConsoleProps {
  quickActions: CommandAction[];
  recentCommands: CommandHistory[];
  onExecute: (command: string) => void;
}

export interface DeploymentMapProps {
  deployments: ShieldDeployment[];
  selectedDeploymentId: string | null;
  onDeploymentSelect: (id: string) => void;
  clusterByRegion: boolean;
}

// ----------------------------------------------------------------
// 7.0 — WCAG 2.1 AA REQUIREMENTS (must pass SENTINEL checks)
// ----------------------------------------------------------------

export interface AccessibilityContract {
  colorContrast: {
    minimumRatio: 4.5;            // AA for normal text
    accentOnDark: number;         // #00ff88 on #0a0a0f = 15.3:1 ✓
  };
  keyboardNavigation: {
    allInteractiveElements: "focusable";
    tabOrder: "logical DOM order";
    focusIndicators: "visible 2px #00ff88 outline";
    skipLinks: boolean;
  };
  screenReader: {
    ariaLabels: "all interactive elements";
    ariaLiveRegions: "alert pipeline, status changes";
    semanticHTML: "enforced via eslint-plugin-jsx-a11y";
    altText: "all non-decorative images";
  };
  motion: {
    prefersReducedMotion: "respected globally";
    animationDuration: "max 300ms when reduced-motion active";
  };
  zoomSupport: "200% without horizontal scroll";
}

// ----------------------------------------------------------------
// END CH-001 v1.0.0 — DIRECTOR-0019 CORTEX
// ================================================================

// Re-export MDM types for RENDER consumption
// These must match MDM-001 exactly — no deviation allowed.
// RENDER imports from here to guarantee type consistency across layers.

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
};

// Supporting types for RENDER

export type Breakpoint = 320 | 768 | 1024 | 1440;

export interface NavItem {
  label: string;
  href: string;
  icon: string;
  children?: NavItem[];
  requiresRole?: string;
}

export interface GeoCluster {
  region: string;
  center: { lat: number; lng: number };
  count: number;
  status: "all_operational" | "partial_degraded" | "all_degraded";
}

export interface DeploymentFilters {
  status?: DeploymentStatus[];
  region?: string;
  dateRange?: { start: string; end: string };
}

export interface AlertFilters {
  severity?: AlertSeverity[];
  shieldId?: string;
  acknowledged?: boolean;
  dateRange?: { start: string; end: string };
}

export type StatusColor = "ok" | "warning" | "critical" | "info" | "neutral";

export type ButtonVariant = "primary" | "secondary" | "ghost" | "destructive";

export interface DropdownItem {
  label: string;
  action: () => void;
  disabled?: boolean;
  separator?: boolean;
  icon?: string;
}

export interface CommandAction {
  id: string;
  label: string;
  shortcut?: string;
  category: string;
  execute: () => void;
}

export interface CommandHistory {
  id: string;
  command: string;
  timestamp: string;
  success: boolean;
}
