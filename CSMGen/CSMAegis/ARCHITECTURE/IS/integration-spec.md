# ============================================================
# CORTEX ARCHITECTURE — IS-001: Integration Spec v1.0.0
# DIRECTOR-0019 | Kael Forge | 2026-07-06
# Target: PIPELINE (0022) — Build, Deploy, CI/CD, BOM Registry
# Contract version: 1.0.0
# ============================================================

---
## 1.0 — DEPLOYMENT TOPOLOGY
---

### 1.1 — Infrastructure Map

```
                              ┌─────────────┐
                              │   CloudFront │
                              │  (CDN/WAF)   │
                              └──────┬───────┘
                                     │
                    ┌────────────────┼────────────────┐
                    ▼                ▼                 ▼
          ┌──────────────┐ ┌──────────────┐ ┌──────────────┐
          │  S3 (static) │ │  ECS/Fargate │ │  ECS/Fargate │
          │  Next.js SPA │ │  Express API │ │  Worker Srv  │
          │  /dashboard  │ │  /api        │ │  /workers    │
          └──────────────┘ └──────┬───────┘ └──────┬───────┘
                                  │                  │
                          ┌───────┼───────┐  ┌──────┼───────┐
                          ▼       ▼        ▼  ▼      ▼        ▼
                   ┌─────────┐ ┌──────┐ ┌────┐ ┌──────┐ ┌────────┐
                   │ RDS     │ │Redis │ │SQS │ │ S3   │ │ S3     │
                   │(Postgres│ │(cache│ │(job│ │(meas-│ │(backup)│
                   │ 16)     │ │/sess)│ │ Q) │ │ure)  │ │        │
                   └─────────┘ └──────┘ └────┘ └──────┘ └────────┘
```

### 1.2 — Service Map

| Service | Runtime | Source Dir | Build Output | Port | Health Check |
|---------|---------|------------|--------------|------|--------------|
| `dashboard` | Node 20 (static) | `src/frontend/` | `.next/static/` → S3 | — | S3 object exists |
| `api` | Node 20 (Express) | `src/backend/` | Docker image → ECR | 3000 | `GET /api/v1/health/live` |
| `worker` | Node 20 | `src/workers/` | Docker image → ECR | — | SQS queue depth monitor |
| `db-migrator` | Node 20 | `src/db/migrations/` | Docker image (one-shot) | — | Exit code 0 |

### 1.3 — AWS Resource IDs (PIPELINE: replace with actual after provisioning)

```typescript
export interface AWSResources {
  accountId: string;              // 12-digit AWS account
  region: string;                 // e.g. us-east-1
  ecsCluster: string;             // "aegis-c-prod"
  ecsServiceApi: string;          // "aegis-api"
  ecsServiceWorker: string;       // "aegis-worker"
  ecrRepoApi: string;             // "aegis-api"
  ecrRepoWorker: string;          // "aegis-worker"
  rdsInstance: string;            // "aegis-db"
  rdsEndpoint: string;            // writer endpoint
  elasticacheEndpoint: string;    // Redis primary endpoint
  s3Dashboard: string;            // "aegis-dashboard-prod"
  s3Measurements: string;         // "aegis-measurements-prod"
  cloudfrontDistributionId: string;
  route53ZoneId: string;
  domainName: string;             // "shield.carrpod.com"
  acmCertificateArn: string;      // TLS cert ARN
}
```

---
## 2.0 — CI/CD PIPELINE (GitHub Actions)
---

### 2.1 — Pipeline Stages

```
PUSH → LINT → TYPECHECK → UNIT TEST → BUILD → INTEGRATION TEST → DEPLOY STAGING → SMOKE → DEPLOY PROD
 │       │         │           │         │           │               │           │          │
 │      ESLint   tsc --noEmit  jest     docker      API tests       ECS         curl       ECS
 │      Prettier               vitest   build       + SENTINEL      blue/green   health     blue/green
 │      + CSP check
```

### 2.2 — Stage Details

| Stage | Command/Tool | Timeout | Blocking | Rollback on Fail |
|-------|-------------|---------|----------|------------------|
| **Lint** | `npm run lint:check` | 2m | Yes | N/A |
| **Typecheck** | `tsc --noEmit` (frontend + backend) | 3m | Yes | N/A |
| **Unit Test** | `npm test -- --coverage` | 5m | Yes | N/A |
| **Build** | `docker build -t aegis-api:$SHA .` | 10m | Yes | N/A |
| **Integration Test** | Playwright E2E + API contract tests | 8m | Yes | N/A |
| **Deploy Staging** | ECS rolling update (10% → 50% → 100%) | 5m | Yes | Yes (ECS rollback) |
| **Smoke Test** | Health check + critical path curl | 2m | Yes | Yes (ECS rollback) |
| **Deploy Prod** | ECS blue/green (traffic shift 10% → 100%) | 10m | No (manual approve) | Yes (ECS rollback) |

### 2.3 — Git Branch Strategy

```
main           → Deploys to production (gated: requires PR + all checks green)
develop        → Deploys to staging (auto-deploy on merge)
feature/*      → Feature branches (CI runs lint+typecheck+unit, no deploy)
hotfix/*       → Hotfix branches (fast-track: bypass staging smoke, direct to prod)
release/v*     → Release branches (freeze for regression testing, tag triggers deploy)
```

### 2.4 — Required GitHub Secrets (PIPELINE: configure in repo settings)

```
AWS_ACCESS_KEY_ID         — IAM user with ECS + ECR + S3 + CloudFront perms
AWS_SECRET_ACCESS_KEY     — IAM secret
AWS_ACCOUNT_ID            — 12-digit account
DOCKER_HUB_USERNAME       — If using Docker Hub for base images
DOCKER_HUB_TOKEN          — Docker Hub access token
SENTRY_DSN                — Error monitoring (backend + frontend)
DATABASE_URL              — RDS connection string (staging)
PROD_DATABASE_URL         — RDS connection string (production — limited access)
REDIS_URL                 — ElastiCache endpoint
JWT_SECRET                — RS256 private key or HMAC secret (rotate quarterly)
SENTINEL_SLACK_WEBHOOK    — Alert notifications
```

---
## 3.0 — BOM REGISTRY (Bill of Materials)
---

### 3.1 — BOM Entry Schema

```typescript
export interface BOMEntry {
  id: string;                    // UUID v4
  component: string;             // e.g. "aegis-api", "aegis-dashboard", "aegis-worker"
  version: string;               // Semver
  gitCommit: string;             // Full SHA of build commit
  buildTimestamp: string;        // ISO 8601
  dependencies: BOMDependency[];
  artifacts: BOMArtifact[];
  deploymentStatus: BOMDeploymentStatus;
  previousVersion?: string;      // Previous deployed version for rollback
}

export interface BOMDependency {
  name: string;                  // npm package or Docker base image
  version: string;
  type: "npm" | "docker" | "system";
  license: string;               // SPDX identifier
  vulnerabilityScan: {
    scannedAt: string;
    critical: number;
    high: number;
    medium: number;
    low: number;
    passed: boolean;             // Must pass (0 critical, 0 high) for deploy
  };
}

export interface BOMArtifact {
  type: "docker-image" | "npm-package" | "static-site" | "migration";
  name: string;
  digest: string;                // SHA256 of artifact
  sizeBytes: number;
  registry: string;              // ECR URI or S3 URI
}

export enum BOMDeploymentStatus {
  BUILT       = "built",
  STAGED      = "staged",
  PRODUCTION  = "production",
  ROLLED_BACK = "rolled_back",
  FAILED      = "failed",
}
```

### 3.2 — BOM Storage

- **Source of truth:** PostgreSQL table `bom_registry` in RDS
- **Immutable:** Once written, never modified — new version creates new entry
- **Query:** `SELECT * FROM bom_registry WHERE component = ? ORDER BY build_timestamp DESC`
- **Retention:** 90 days of history, then archive to S3 (lifecycle policy)
- **Audit:** Every deploy writes a BOM entry. PIPELINE enforces this as a deploy gate.

---
## 4.0 — ENVIRONMENT CONFIGURATION
---

### 4.1 — Environment Variables Contract

Every service reads configuration from environment variables. No hardcoded values. No config files committed to repo.

```typescript
export interface ServiceConfig {
  // Common (all services)
  NODE_ENV: "development" | "staging" | "production";
  LOG_LEVEL: "debug" | "info" | "warn" | "error";

  // API Service
  PORT: number;                  // 3000
  DATABASE_URL: string;          // postgresql://user:pass@host:5432/aegis
  REDIS_URL: string;             // redis://host:6379
  JWT_PUBLIC_KEY: string;        // Public key for token verification
  CORS_ORIGINS: string;          // Comma-separated allowed origins
  RATE_LIMIT_WINDOW_MS: number;  // Default: 60000
  RATE_LIMIT_MAX: number;        // Default: 100

  // Worker Service
  SQS_QUEUE_URL: string;         // Measurement processing queue
  SQS_POLL_INTERVAL_MS: number;  // Default: 5000
  S3_MEASUREMENTS_BUCKET: string;

  // Dashboard (build-time, injected via Next.js)
  NEXT_PUBLIC_API_URL: string;   // API base URL for client-side fetches
  NEXT_PUBLIC_SENTRY_DSN: string;
}
```

### 4.2 — Secrets Management

- **AWS Secrets Manager** for `DATABASE_URL`, `REDIS_URL`, `JWT_SECRET`
- Rotated via Lambda — PIPELINE deploys rotation function
- Secrets never appear in environment variable output or logs
- Application reads secrets at startup via AWS SDK — caches for connection lifetime

---
## 5.0 — MONITORING & OBSERVABILITY
---

### 5.1 — Metrics (CloudWatch)

| Metric | Namespace | Unit | Alarm Threshold |
|--------|-----------|------|-----------------|
| `api.latency.p95` | AegisC/API | ms | > 500ms for 5m |
| `api.error.rate` | AegisC/API | count/min | > 10/min |
| `api.requests.count` | AegisC/API | count | — |
| `shield.se.drift` | AegisC/Shields | dB | > 5 dB from nominal |
| `mxene.thickness.drift` | AegisC/Materials | μm | Outside 43-47 μm |
| `worker.queue.depth` | AegisC/Worker | count | > 1000 for 10m |
| `db.connections.active` | AegisC/DB | count | > 80% of max |

### 5.2 — Logging

- **Format:** Structured JSON (one log event per line)
- **Required fields:** `timestamp`, `level`, `service`, `requestId`, `message`
- **Output:** stdout (ECS captures to CloudWatch Logs)
- **Retention:** 30 days CloudWatch → archive to S3 (90d lifecycle)

### 5.3 — Alerting Pipeline

```
Metric Alarm → SNS Topic → Lambda → Slack Webhook (SENTINEL channel)
                                     → PagerDuty (critical only)
```

---
## 6.0 — PIPELINE GATES (what must pass before deploy proceeds)
---

### 6.1 — Quality Gates (fail = no deploy)

| Gate | Threshold | Measured By |
|------|-----------|-------------|
| Lint errors | 0 | ESLint exit code |
| TypeScript errors | 0 | `tsc --noEmit` exit code |
| Unit test coverage | ≥ 80% lines | jest/vitest coverage report |
| Vulnerabilities (critical) | 0 | `npm audit` or Snyk |
| Vulnerabilities (high) | 0 | `npm audit` or Snyk |
| Lighthouse Performance (dashboard) | ≥ 90 | Lighthouse CI |
| Lighthouse Accessibility (dashboard) | = 100 | Lighthouse CI |
| axe-core violations | 0 | axe-core CI |
| BOM entry written | Yes | DB check |
| All integration tests pass | 100% | Playwright exit code |

### 6.2 — Staging-to-Production Promotion Gate

- Manual approval required (GitHub Environments protection rule)
- Staging must be green for ≥ 5 minutes (soak period)
- No open critical alerts in staging
- BOM entry comparison: staging BOM matches expected production BOM
- PIPELINE (0022) + SENTINEL (0023) both sign off

---
## 7.0 — ROLLBACK PROCEDURE
---

```
1. TRIGGER: Smoke test fails OR manual rollback command
2. PIPELINE executes: aws ecs update-service --force-new-deployment
   (ECS retains previous task definition → automatic rollback)
3. If ECS rollback fails: manual deploy of previous BOM entry's artifact digest
4. POST-ROLLBACK:
   - Write new BOM entry with status = ROLLED_BACK
   - SENTINEL: investigate root cause → write incident report
   - Alert Slack #aegis-alerts: "ROLLBACK: [service] v[X]→v[Y] — investigating"
5. No deploy to production until root cause resolved + regression test passes
```

---
## 8.0 — SCHEDULED JOBS (ECS + EventBridge)
---

| Job | Schedule | Service | Description |
|-----|----------|---------|-------------|
| `measurement-cleanup` | Daily 03:00 UTC | Worker | Archive measurements > 90d to S3, prune DB |
| `bom-archive` | Daily 04:00 UTC | Worker | Archive BOM entries > 90d to S3 |
| `se-drift-check` | Hourly | Worker | Compare latest SE to baseline, alert if > 5 dB drift |
| `cert-renewal` | Weekly Mon 02:00 UTC | Lambda | Check ACM cert expiry, alert if < 30 days |
| `db-backup` | Daily 05:00 UTC | RDS automated | Automated snapshot, 30d retention |
| `vulnerability-scan` | Daily 06:00 UTC | GitHub Actions | `npm audit` across all services, alert on new CVEs |

---
## 9.0 — CROSS-SIBLING INTEGRATION POINTS
---

| Sibling | Needs From PIPELINE | Dependencies |
|---------|-------------------|--------------|
| **FOUNDRY (0020)** | Staging environment for API testing, RDS connection string, Redis endpoint | VPC + subnets + security groups provisioned |
| **RENDER (0021)** | S3 bucket + CloudFront for dashboard deploy, CI/CD pipeline for `npm run build` | S3 bucket policy + CloudFront invalidation on deploy |
| **SENTINEL (0023)** | Staging environment for E2E tests, CI pipeline integration, test artifact storage | GitHub Actions integration, test report aggregation |
| **CORTEX (0019)** | BOM registry endpoint for architecture verification, deployment audit trail | BOM registry table + API |

---
## 10.0 — IaC REQUIREMENT (Terraform / CDK / Pulumi)

PIPELINE must maintain Infrastructure-as-Code for ALL resources listed in Section 1.3. No console-created resources. No manual provisioning. The IaC repo is the single source of truth for infrastructure state.

```typescript
// IaC directory structure (src/infrastructure/)
//
// infrastructure/
//   main.tf              → Provider config, backend (S3 + DynamoDB lock)
//   vpc.tf               → VPC, subnets (public + private), NAT gateway
//   ecs.tf               → ECS cluster, task definitions, services
//   ecr.tf               → ECR repositories (api, worker, migrator)
//   rds.tf               → RDS PostgreSQL instance, subnet group, parameter group
//   elasticache.tf       → Redis cluster, subnet group
//   s3.tf                → S3 buckets (dashboard, measurements, backups, BOM archive)
//   cloudfront.tf         → CloudFront distribution, origin access identity
//   route53.tf            → DNS records, ACM validation
//   iam.tf                → Task execution roles, service roles, CI/CD deploy user
//   secrets.tf            → Secrets Manager secrets (DB URL, JWT, Redis URL)
//   monitoring.tf         → CloudWatch dashboards, alarms, log groups
//   outputs.tf            → Exported values for CI/CD pipeline consumption
```

---
END IS-001 v1.0.0 — DIRECTOR-0019 CORTEX
