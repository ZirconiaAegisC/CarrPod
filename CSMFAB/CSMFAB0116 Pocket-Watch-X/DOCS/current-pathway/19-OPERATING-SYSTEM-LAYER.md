# CSMFAB0116-19 — POCKET WATCH X: OPERATING SYSTEM LAYER
## 1. OS ARCHITECTURE
The Pocket Watch X runs a dual-OS design:
- **Application OS:** Yocto Linux 6.6 LTS kernel with a custom circular Wayland compositor.
- **RTOS Co-processor:** Zephyr RTOS on a Cortex-M33 (sensor hub MCU) for real-time sensor processing and always-on functions.

## 2. LINUX KERNEL CONFIGURATION
| Feature | Configuration |
|---------|---------------|
| Kernel version | Linux 6.6 LTS |
| Scheduler | EAS (Energy-Aware Scheduling) with schedutil governor |
| Preemption | CONFIG_PREEMPT (low-latency desktop) |
| Filesystems | ext4 (root), F2FS (user data) |
| Display | DRM/KMS with custom circular CRTC |
| Input | libinput + custom gesture recognition daemon |
| Audio | ALSA + PulseAudio / PipeWire |
| Networking | NetworkManager + connman |
| Power | systemd-logind + custom suspend daemon |

## 3. CIRCULAR WAYLAND COMPOSITOR — "Cranel"
Named after the cranel (circular + panel). Key features:
- Circular framebuffer clipping (hardware overlay to mask square display to circular).
- Radial menu system.
- Circular app launcher (watch face paradigm).
- Multi-window Desktop Mode when docked (switches to linear compositor).
- Always-On Display (AOD) mode: 1 Hz, minimal pixels, burn-in mitigation.

## 4. FIN DRIVER MODEL
| Component | Implementation |
|-----------|---------------|
| Fin bus driver | PCIe host controller driver with hotplug support |
| Fin class driver | Matches on PCIe Vendor/Device ID + FDB capability flags |
| Fin management daemon | Userspace daemon (finmand) for enumeration, FW loading, power |
| Driver loading | Auto-probed via udev rules triggered by finmand |
| Driver API | Standard Linux kernel interfaces (DRM, ALSA, IIO, netdev, tty) |

## 5. POWER MANAGEMENT INTEGRATION
| Feature | Implementation |
|---------|---------------|
| CPU frequency scaling | schedutil governor (EAS-aware) |
| CPU idle states | C1 (WFI), C2 (retention), C3 (power collapse) |
| Device runtime PM | All peripherals support runtime suspend |
| Wakeup sources | GPIO (crown press), RTC alarm, fin insertion, wireless wake |
| Battery saver | Reduces refresh to 60 Hz, limits background tasks |
| Extreme saver | Black-and-white mode, 1 Hz, cellular/WiFi off |

## 6. FILE SYSTEM LAYOUT
| Path | Purpose | Size |
|------|---------|------|
| / | Root filesystem (read-only, dm-verity) | 4 GB |
| /data | User data (encrypted, F2FS) | 58 GB |
| /firmware | Firmware store | 4 GB |
| /cache | OTA cache and temp files | 2 GB |
| /recovery | Recovery OS | 256 MB |

## 7. USER SPACE SERVICES
| Service | Function |
|---------|----------|
| finmand | Fin enumeration, firmware loading, power management |
| watchmand | Watch face rendering (Qt/QML-based) |
| healthd | Health sensor data aggregation (HR, SpO2, ECG, etc.) |
| dockd | Dock detection and mode switching |
| ota-updated | OTA update download and verification |
| tzd | Time zone daemon (auto-detect from GNSS/cellular) |
| secure-elementd | HSM and key management interface |

## 8. DESKTOP MODE
When docked to projector or keyboard dock, the OS switches to Desktop Mode:
- Windowed compositor (Phoc/Phosh-based).
- Multi-window, taskbar, system tray.
- Fin driver model unchanged.
- External display resolution negotiated via DP Alt Mode.

## 9. VERIFICATION
| Test | Method | Criterion |
|------|--------|-----------|
| Boot time | Systemd-analyze | < 2s to graphical target |
| Memory usage | smem at idle | < 300 MB used |
| Circular rendering | Test pattern at display edge | Zero artifacts at circle boundary |
| Dock transition | Insert into projector dock | Desktop mode within 2s |
| Undock transition | Remove from dock | Watch mode within 0.5s |
| Battery life | Mixed workload, 50% brightness | > 24 hours |

