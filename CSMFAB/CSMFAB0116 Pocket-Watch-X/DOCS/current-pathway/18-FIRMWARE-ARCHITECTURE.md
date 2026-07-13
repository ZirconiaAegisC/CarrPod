# CSMFAB0116-18 — POCKET WATCH X: FIRMWARE ARCHITECTURE
## 1. BOOT CHAIN
| Stage | Location | Signed By | Key | Verification |
|-------|----------|-----------|-----|-------------|
| 1. Boot ROM | Mask ROM (immutable) | Factory | Fused root key | Hash of Bootloader |
| 2. Bootloader A/B | NOR Flash (2×1 MB) | CSM Aegis | ECDSA P-384 | Signature vs fused |
| 3. Trusted Firmware-A | NOR Flash | CSM Aegis | ECDSA P-384 | BL validates TF-A |
| 4. U-Boot / UEFI | UFS | CSM Aegis | ECDSA P-384 | TF-A validates |
| 5. Linux Kernel | UFS | CSM Aegis | ECDSA P-384 | U-Boot validates |
| 6. Initramfs | UFS | CSM Aegis | ECDSA P-384 | Kernel validates |
| 7. Rootfs | UFS | CSM Aegis | dm-verity hash tree | Initramfs validates |

## 2. DUAL-BIOS FAILOVER
If Bootloader A fails (3 consecutive boot attempts without reaching init), Bootloader B is selected. If both fail, device enters USB recovery mode (DFU).

## 3. OTA UPDATE PROTOCOL
1. Watch checks for updates via HTTPS (api.carrpod.com/ota/v2/check).
2. Update metadata downloaded: version, size, hash, signing certificate.
3. User approves update; watch must have > 50% battery or be docked.
4. Delta binary downloaded to inactive slot (A←B or B←A).
5. SHA-512 verified against manifest.
6. ECDSA P-384 signature verified against root CA.
7. Bootloader flag set to try new slot on next boot.
8. Device reboots into new slot.
9. If boot succeeds within 3 attempts, new slot marked good and opposite slot updated.
10. If boot fails, bootloader reverts to previous slot.

## 4. FIN FIRMWARE LOADING
1. On fin enumeration, main SoC reads FDB firmware filename field.
2. Checks local firmware store (UFS: /firmware/fins/).
3. If not found, queries OTA server for fin firmware.
4. Downloads and verifies fin firmware signature (manufacturer key, countersigned by CSM CA).
5. Loads firmware to fin via PCIe VC (vendor-defined message).
6. Fin boots firmware; driver probe completes.

## 5. SECURE BOOT CHAIN — KEY HIERARCHY
| Key | Storage | Purpose |
|-----|---------|---------|
| Root Key | eFuse (SoC) | Validates Bootloader signature |
| CSM CA Key | eFuse | Validates OS/App signatures |
| Manufacturer Key | Fin EEPROM | Validates fin firmware |
| User Key | Secure element | Disk encryption, biometric auth |

## 6. RECOVERY MODE
| Trigger | Action |
|---------|--------|
| Both bootloaders fail | Enter USB DFU mode |
| Vol-Down held during boot | Boot to recovery OS |
| Recovery OS not found | USB DFU fallback |
| Tamper detected | Wipe user data, require re-auth |

## 7. VERIFICATION
| Test | Method | Criterion |
|------|--------|-----------|
| Boot time | Power-on to UI | < 150 ms |
| OTA apply time | Delta update, 100 MB | < 5 minutes |
| OTA rollback | Corrupt update | Boots previous slot |
| Secure boot | Unsigned image | Rejected at stage 2 |
| Fin FW load | Insert fin without local FW | Auto-downloads and loads |

