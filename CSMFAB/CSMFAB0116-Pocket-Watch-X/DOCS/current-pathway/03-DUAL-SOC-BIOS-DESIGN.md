# CSMFAB0116-03 — POCKET WATCH X: DUAL-SOC BIOS DESIGN

**Revision:** A — 2026-07-10
**Classification:** ENGINEERING FABRICATION — INTERNAL
**Dependencies:** 01-CORE-SYSTEM-ARCHITECTURE

## 1. OVERVIEW

The Dual-SoC BIOS (Basic Input/Output Subsystem) implements a resilient failover architecture where two identical System-on-Chip processors cross-monitor each other. If one fails, the surviving SoC assumes full control within 50 ms while attempting to recover the failed unit.

## 2. HARDWARE MONITORING

### 2.1 Cross-Monitoring Signals

| Signal | Source | Destination | Type | Rate |
|--------|--------|-------------|------|------|
| HEARTBEAT_A | SoC-A GPIO12 | SoC-B GPIO_IRQ3 | 50 ms pulse | 20 Hz |
| HEARTBEAT_B | SoC-B GPIO12 | SoC-A GPIO_IRQ3 | 50 ms pulse | 20 Hz |
| FAILOVER_REQ_A | SoC-A GPIO13 | SoC-B GPIO14 | Level | Async |
| FAILOVER_REQ_B | SoC-B GPIO13 | SoC-A GPIO14 | Level | Async |
| RESET_A | SoC-B GPIO15 | SoC-A RSTn | Level | Async |
| RESET_B | SoC-A GPIO15 | SoC-B RSTn | Level | Async |
| HEALTH_A[1:0] | SoC-A GPIO16:17 | SoC-B GPIO18:19 | 2-bit code | 10 Hz |
| HEALTH_B[1:0] | SoC-B GPIO16:17 | SoC-A GPIO18:19 | 2-bit code | 10 Hz |
| I2C_CROSS | SoC-A I2C3 | SoC-B I2C3 | I²C bus | 400 kHz |

### 2.2 Health Status Codes

| Code | Meaning | Action |
|------|---------|--------|
| 00 | HEALTHY | Normal operation |
| 01 | DEGRADED | Non-critical fault, log event |
| 10 | IMPAIRED | Critical fault, prepare failover |
| 11 | FAILED | SoC non-responsive, force failover |

### 2.3 Watchdog Timers

| Watchdog | Timeout | Action |
|----------|---------|--------|
| WDT_SYSTEM | 2s | System reset if not serviced |
| WDT_CROSS_SOC | 500ms | Trigger failover if peer unresponsive |
| WDT_FIN_BUS | 100ms | Reset fin bus if hung |
| WDT_DISPLAY | 200ms | Reset display pipeline if stalled |

## 3. FAILOVER STATE MACHINE

### 3.1 State Definitions

| State | Description |
|-------|-------------|
| INIT | Both SoCs booting, negotiating roles |
| PRIMARY_ACTIVE | SoC-A is primary, SoC-B is standby |
| STANDBY_ACTIVE | SoC-B is primary, SoC-A is standby |
| FAILOVER_IN_PROGRESS | Transition occurring |
| RECOVERY_ATTEMPT | Failed SoC being diagnosed |
| DEGRADED_SOLO | One SoC operational, other unrecoverable |

### 3.2 State Transitions

```
INIT ──(negotiation complete)──▶ PRIMARY_ACTIVE
PRIMARY_ACTIVE ──(peer failure detected)──▶ FAILOVER_IN_PROGRESS
FAILOVER_IN_PROGRESS ──(transfer complete)──▶ STANDBY_ACTIVE
STANDBY_ACTIVE ──(recovery attempt)──▶ RECOVERY_ATTEMPT
RECOVERY_ATTEMPT ──(recovery success)──▶ STANDBY_ACTIVE (with peer)
RECOVERY_ATTEMPT ──(recovery failed)──▶ DEGRADED_SOLO
DEGRADED_SOLO ──(power cycle/replacement)──▶ INIT
```

## 4. FAILOVER TIMING BUDGET

| Phase | Duration (ms) | Cumulative (ms) |
|-------|---------------|-----------------|
| Heartbeat miss detection | 0-50 | 0-50 |
| Verification (3 missed) | 100 | 150 |
| FAILOVER_REQ assertion | < 0.1 | 150.1 |
| Register save to SRAM | 2 | 152.1 |
| Display framebuffer takeover | 5 | 157.1 |
| Fin bus re-enumeration hold | 10 | 167.1 |
| Standby SoC enters ACTIVE | 3 | 170.1 |
| UI responsive | 30 | 200.1 |

**Total max failover latency: 200 ms.** Target: < 50 ms for display stability.

## 5. SHARED MEMORY MAP

### 5.1 Cross-Monitoring SRAM (2 MB)

| Address | Size | Content |
|---------|------|---------|
| 0x0000 | 4 bytes | Primary SoC ID (0=A, 1=B) |
| 0x0004 | 4 bytes | Failover counter |
| 0x0008 | 32 bytes | Last heartbeat timestamps (both SoCs) |
| 0x0028 | 64 bytes | Error log ring buffer |
| 0x0080 | 1 KB | Register save area (SoC-A last state) |
| 0x0480 | 1 KB | Register save area (SoC-B last state) |
| 0x0880 | 512 KB | Shared diagnostic scratchpad |

### 5.2 Display Framebuffer (256 MB)

| Address | Size | Content |
|---------|------|---------|
| 0x0000_0000 | 128 MB | SoC-A framebuffer (double-buffered) |
| 0x0800_0000 | 128 MB | SoC-B framebuffer (double-buffered) |

Only the primary SoC writes. Standby SoC reads for display pipeline passthrough. Mutex via shared memory flag at 0x0FFF_FFF0.

## 6. BOOT SEQUENCE

### 6.1 Power-On Reset

1. PMIC power good signal asserted.
2. SoC-A internal RC oscillator starts (32 kHz).
3. SoC-A PLL locks to external 38.4 MHz TCXO.
4. Boot ROM executes, validates Bootloader 0 image.
5. Bootloader validates OS image signature (ECDSA P-384).
6. OS boots, L1 firmware initializes.
7. L1 firmware reads SoC-B presence via I²C.

### 6.2 Role Negotiation

1. Both SoCs read shared SRAM at address 0x0000.
2. If value is 0xFF (uninitialized): SoC-A writes 0x00 and becomes primary.
3. If value is 0x00 or 0x01: joining SoC accepts existing primary.
4. PRIMARY writes its hostname, IP (inter-SoC bus), and capability flags to shared SRAM.
5. STANDBY ACKs via I²C and begins monitoring heartbeat.

### 6.3 Secure Boot Chain

| Stage | Signer | Key | Verification |
|-------|--------|-----|-------------|
| Boot ROM | Mask ROM (immutable) | HW root key | Hash of Bootloader |
| Bootloader | Carrington Storm Motors | ECDSA P-384 | Signature vs. fused key |
| OS Kernel | CSM Aegis Operations | ECDSA P-384 | Signature in header |
| Fin firmware | Fin manufacturer | Manufacturer key | Signed by CSM CA |
| OTA updates | CSM OTA service | ECDSA P-384 | Rollback-protected |

## 7. ERROR HANDLING

### 7.1 Error Categories

| Category | Severity | Response |
|----------|----------|----------|
| Single bit-flip (ECC correctable) | LOW | Log, continue |
| Double bit-flip (ECC uncorrectable) | MEDIUM | Reload page from flash |
| DDR ECC multi-bit error | HIGH | Failover to standby SoC |
| SoC PLL unlock | HIGH | Reset SoC, re-lock |
| Fin bus CRC failure | MEDIUM | Re-enumerate fin |
| Cross-monitoring I²C hang | CRITICAL | Assume peer dead, failover |
| Thermal shutdown (105°C) | CRITICAL | Immediate throttling, log |
| Power rail out of spec | CRITICAL | Shutdown non-essential rails |

### 7.2 Recovery Actions

1. **Cold reset:** Assert RSTn for 100 ms, full re-initialization.
2. **Warm reset:** Jump to bootloader without power cycling.
3. **Fin reset:** Assert PCIe PERST for each fin slot independently.
4. **Display reset:** Assert DDIC reset via GPIO, re-send MIPI init sequence.

## 8. DIAGNOSTIC INTERFACE

### 8.1 Built-In Self-Test (BIST)

| Test | Duration | Coverage |
|------|----------|----------|
| DRAM marching pattern | 2s | Full address space |
| SRAM tests | 200 ms | Cross-monitoring SRAM |
| PCIe loopback (internal) | 500 ms | Fin bus PHY |
| Display test pattern | 1s | RGB ramp, grid, checkerboard |
| I²C bus scan | 100 ms | All addresses responded |
| GPIO boundary scan | 200 ms | All pins toggled |
| Temperature sensor | 50 ms | Die temp within operating range |

### 8.2 Diagnostic Log Access

Via UART console (115200 bps 8N1) on external divot pads, or via ADB over USB (debug builds).

## 9. FIRMWARE ARRANGEMENT

| Partition | Size | Flash type | Remarks |
|-----------|------|------------|---------|
| Boot ROM | 64 KB | Mask ROM | Immutable |
| Bootloader A | 1 MB | NOR flash | Primary bootloader slot |
| Bootloader B | 1 MB | NOR flash | Redundant bootloader slot |
| OS A | 2 GB | UFS 3.1 | Primary OS slot |
| OS B | 2 GB | UFS 3.1 | Secondary OS slot (OTA target) |
| Diag partition | 256 MB | UFS | Diagnostic and recovery tools |
| User data | 64 GB | UFS | Encrypted user storage |
| Fin FW store | 4 GB | UFS | Fin-specific firmware images |

## 10. VERIFICATION

| Test | Method | Criterion |
|------|--------|-----------|
| Failover latency | Logic analyzer on FAILOVER_REQ and display | < 50 ms to display stable |
| Boot time | Timer from power-on to UI ready | < 150 ms |
| Secure boot | Attempt boot with unsigned image | Must reject |
| ECC injection | DRAM error injector | Single-bit: corrected. Double-bit: detected. |
| Fin hot-plug | 10,000 cycles automated | Zero enumeration failures |
| Thermal cycle | -40 to +85°C, 500 cycles | All BIST pass post-cycle |
| SoC restart loop | 1000 cold resets | Zero failures to boot |
