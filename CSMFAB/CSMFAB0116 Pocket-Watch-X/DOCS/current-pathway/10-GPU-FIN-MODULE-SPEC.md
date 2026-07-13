# CSMFAB0116-10 — POCKET WATCH X: GPU FIN MODULE SPECIFICATION
**Revision:** A — 2026-07-10 | **Dependencies:** 04-FIN-INTERFACE-SPECIFICATION

## 1. PURPOSE
The GPU Fin adds dedicated graphics processing capability to the Pocket Watch X for gaming, rendering, AI/ML inference, and display driving.

## 2. GPU ARCHITECTURE OPTIONS
| GPU | Architecture | Cores | TFLOPS (FP32) | VRAM | TDP | Process |
|-----|-------------|-------|---------------|------|-----|---------|
| ARM Mali-G720-Immortalis | Valhall 5th gen | 16 cores | 3.5 | Shared system RAM | 4W | 3nm |
| ARM Mali-G820 | Valhall 6th gen | 20 cores | 5.0 | 4 GB LPDDR5X | 6W | 3nm |
| Imagination BXT-48-1536 | B-Series | 1536 ALUs | 2.8 | 4 GB LPDDR5X | 4W | 5nm |
| Custom RDNA3-derived | RDNA3 | 4 CUs | 2.0 | 4 GB LPDDR5X | 5W | 4nm |

## 3. GRAPHICS API SUPPORT
| API | Version |
|-----|---------|
| Vulkan | 1.3 |
| OpenGL ES | 3.2 |
| OpenCL | 3.0 |
| Metal (via translation) | 3.0 |
| DirectX (via translation) | 12 Ultimate |

## 4. DISPLAY PIPELINE
| Parameter | Value |
|-----------|-------|
| Display interface | MIPI DSI-2 (passthrough to main display) |
| External output | DP 2.1 via divot / USB4 Alt Mode |
| Max resolution (internal) | 1440 × 1440 |
| Max resolution (external) | 7680 × 4320 @ 60 Hz |
| HDR support | HDR10, HDR10+, HLG |
| HDCP | HDCP 2.3 |
| Max displays | 3 simultaneous (1 internal + 2 external) |

## 5. COMPUTE CAPABILITIES
| Feature | Specification |
|---------|---------------|
| Compute shaders | Full support (Vulkan/OpenCL) |
| Ray tracing | Hardware RT cores (if applicable) |
| AI/ML inference | Via OpenCL / Vulkan ML / NN API |
| INT8/INT4 acceleration | For quantized inference |
| FP16 throughput | 2× FP32 |
| Video decode | H.264, H.265, VP9, AV1 (up to 8K) |
| Video encode | H.264, H.265 (up to 4K) |
| JPEG decode/encode | Hardware acceleration |

## 6. VRAM
| Parameter | Value |
|-----------|-------|
| Type | LPDDR5X |
| Capacity | 4 GB / 8 GB options |
| Bus width | 64-bit |
| Bandwidth | 68 GB/s |
| ECC | Optional (for compute workloads) |

## 7. POWER MANAGEMENT
| State | Power |
|-------|--------|
| Peak 3D (games) | 4-6 W |
| Video playback (4K AV1) | 1.5 W |
| UI rendering (idle) | 0.5 W |
| Sleep | < 1 mW |

## 8. THERMAL INTERFACE
| Parameter | Value |
|-----------|-------|
| Contact pad | 10 × 8 mm copper |
| Thermal resistance (junction-to-pad) | 3.0 °C/W |
| Max junction | 100°C |
| Throttle onset | 90°C |

## 9. DISPLAY PASSTHROUGH
When no GPU fin is present, the main SoC integrated GPU drives the display. When a GPU fin is inserted:
1. GPU fin enumerates on PCIe bus.
2. GPU driver loads.
3. Main SoC reads GPU fin display capability via FDB extension.
4. Main SoC negotiates display handoff: routes DSI-2 through GPU fin (passthrough mode).
5. GPU fin takes over rendering. Main SoC GPU enters low-power retention.
6. On fin removal, main SoC GPU resumes rendering.

## 10. CROSS-FIN COLLABORATION
GPU fins may collaborate with:
- **CPU fin:** Off-loads rendering, CPU handles game logic.
- **AI Accelerator fin:** GPU runs inference if no dedicated NPU fin present.
- **Memory fin:** GPU uses fin RAM for texture cache if local VRAM insufficient.

## 11. VERIFICATION
| Test | Method | Criterion |
|------|--------|-----------|
| Vulkan conformance | Khronos VK CTS | Pass all required tests |
| Display handoff | Insert GPU fin while rendering | < 1 frame glitch |
| Thermal | 6W sustained GPU load, 1 hr | Junction < 90°C |
| External display | Connect 4K monitor via divot | 3840×2160 @ 60 Hz stable |
| Video decode | 8K AV1 playback, 1 hr | No frame drops |
| Fin removal | Remove during rendering | Main GPU resumes < 100 ms |

