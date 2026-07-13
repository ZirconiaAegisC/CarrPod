# CSMFAB0116-39 — SECURITY ARCHITECTURE
## 1. HARDWARE ROOT OF TRUST
| Component | Implementation |
|-----------|---------------|
| Root key | Fused in SoC eFuse (256-bit, P-384) |
| Secure boot | Multi-stage with ECDSA P-384 signature chain |
| Secure element | NXP SE050 (CC EAL 6+) |
| TRNG | Hardware true random number generator |
| Memory encryption | Inline DDR encryption (AES-256-XTS) |
| Storage encryption | FBE (File-Based Encryption) with HW-backed keys |

## 2. FIN BUS SECURITY
| Measure | Description |
|---------|-------------|
| Fin authentication | ECDSA signature verification of FDB |
| Encrypted fin bus | Optional AES-GCM over PCIe VC messages |
| Power budget enforcement | OCP per rail, per FDB declaration |
| Memory isolation | IOMMU prevents DMA attacks from fin |
| Fin removal detection | Cryptographic session teardown on FIN_DETECT high |

## 3. BIOMETRIC AUTHENTICATION
| Method | Sensor | Fin Required |
|--------|--------|-------------|
| Fingerprint | Under-display optical sensor | No (built into display) |
| Voice | MEMS microphone | No |
| Face | Camera fin | Yes (27-CAMERA-FIN) |
| Heartbeat | PPG sensor | Yes (56-HEART-RATE-FIN) |

## 4. TAMPER DETECTION
| Trigger | Response |
|---------|----------|
| Housing opened (light sensor trip) | Wipe secure element keys |
| JTAG/SWD detected | Disable debug interface |
| Voltage glitch | Reset SoC, log event |
| Temperature extreme | Wipe volatile keys |
| Excessive auth failures | Exponential backoff, then wipe |

