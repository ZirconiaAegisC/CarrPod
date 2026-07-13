# CSMFAB0116-43 — OVER-THE-AIR UPDATE SYSTEM
## 1. UPDATE SERVER ARCHITECTURE
| Component | Technology |
|-----------|------------|
| CDN | Cloudflare / Fastly edge caching |
| Origin | AWS S3 + Lambda@Edge |
| Database | DynamoDB (device registry) |
| Signing | AWS KMS (ECC P-384) |
| Staged rollout | 1% → 10% → 50% → 100% with automatic rollback |
| Monitoring | Crash rate, ANR rate, battery regression |

## 2. DELTA UPDATE PACKAGES
| Parameter | Value |
|-----------|-------|
| Algorithm | bsdiff / courgette (Chromium-style) |
| Typical delta size | 5-15% of full update |
| Full update size | ~500 MB (OS + apps) |
| Delta creation | Server-side, per-version-to-version |

## 3. ROLLBACK PROTECTION
| Mechanism | Description |
|-----------|-------------|
| Version counter | Monotonically increasing in eFuse |
| Anti-rollback | Cannot flash firmware with lower version counter |
| Slot verification | Slot must boot 3 times successfully before marked good |
| Automatic rollback | If 3 consecutive boot failures, revert to previous slot |

## 4. FIN-SPECIFIC UPDATES
| Feature | Description |
|---------|-------------|
| Fin firmware store | Per-fin-type firmware in /firmware/fins/{vendor}/{product}/ |
| Signed by manufacturer | Manufacturer ECDSA key + CSM CA counter-signature |
| Auto-update | finmand queries OTA server for fin FW updates |
| User approval | User must approve fin FW updates |

