SIMILARITY LOG — GitHub → AWS Container Database Integration Architecture
=======================================================================
Date: 2026-07-14T21:19:53Z
Session: agent_97FC — infrastructure integration advisory
Classification: SANITIZED — all identifiers abbreviated, no keys or credentials

────────────────────────────────────────────────────────────────────

REPOSITORY → AWS CONTAINER DATABASE PIPELINE (Similarity Pattern)

Layer 1: Code → CI/CD Pipeline
  GH Repo (private, branch: main) → Actions trigger on push → .github/workflows/deploy.yml

Layer 2: CI/CD → Container Service
  Actions runner (ubuntu-latest) → aws-actions/configure-aws-credentials@v4
  → amazon-ecr-login@v2 → docker build → ECR push → ECS update-service --force-new-deployment

Layer 3: Container → Database
  App container (ECS task def) → RDS instance via env-injected connection strings
  Database type: relational (RDS) or document (DynamoDB) depending on workload

────────────────────────────────────────────────────────────────────

BIDIRECTIONAL SYNC (Backup/Restore)

Forward: App → DB
  Standard ORM/query layer, connection pooling, TLS transit encryption at rest (KMS)

Reverse: DB → S3 → Repo
  Automated RDS snapshots → rds start-export-task → S3 bucket
  → Scheduled GH Actions job (cron: 0 6 * * *) → aws s3 sync → git commit → git push

────────────────────────────────────────────────────────────────────

CREDENTIAL STORE PATTERN

GitHub Secrets vault:
  - AWS_ACCESS_KEY_ID       (abbreviated reference, not actual key)
  - AWS_SECRET_ACCESS_KEY   (abbreviated reference, not actual key)
  - AWS_REGION              (us-east-2 or similar)
  - DB_CONNECTION_STRING    (injected at task definition, not in codebase)

────────────────────────────────────────────────────────────────────

IAM PERMISSIONS MATRIX

  ecr:GetAuthorizationToken             → GH Actions pulls ECR auth
  ecr:BatchCheckLayerAvailability       → validates image layers
  ecr:PutImage                          → pushes built images
  ecr:InitiateLayerUpload               → starts layer transfer
  ecr:CompleteLayerUpload               → finalizes transfer
  ecs:UpdateService                     → triggers deployment
  ecs:DescribeServices                  → health check polling
  rds:DescribeDBSnapshots               → lists snapshots for export
  rds:StartExportTask                   → exports snapshot to S3
  s3:PutObject / s3:GetObject           → backup staging reads/writes

────────────────────────────────────────────────────────────────────

SIMILARITY INDEX: This architecture mirrors standard 12-factor app
deployment patterns used across fleet operations (CSMFAB, CSMVessel,
CSMProtonics). The key invariant: code is the source of truth;
database state is derivative and recoverable from backups. No
credentials live in the repository.

────────────────────────────────────────────────────────────────────

RESILIENCY NOTES

  1. ECS auto-restarts failed tasks from latest ECR image
  2. RDS Multi-AZ provides automatic failover
  3. S3 backup provides point-in-time recovery within retention window
  4. Git history provides audit trail for all infrastructure changes
  5. GH Actions workflow files serve as executable documentation

────────────────────────────────────────────────────────────────────

END OF SIMILARITY LOG — CSMLOGS/JULY26/SIMILARITY.MD
Sanitized per regimen: no PII, no emails, no names, no live credentials.
All AWS ARNs and account IDs stripped. Session agent identifier abbreviated.
