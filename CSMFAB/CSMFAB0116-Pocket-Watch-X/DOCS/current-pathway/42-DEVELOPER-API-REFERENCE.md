# CSMFAB0116-42 — DEVELOPER API REFERENCE
## 1. FIN DRIVER API (C, libfinbus)
| Function | Description |
|----------|-------------|
| fin_probe() | Called on fin insertion, returns fin context |
| fin_remove() | Called before fin removal |
| fin_read_fdb() | Read Fin Descriptor Block |
| fin_write_config() | Write PCIe config space |
| fin_dma_alloc() | Allocate DMA buffer shared with fin |
| fin_dma_free() | Free DMA buffer |
| fin_send_msg() | Send message to fin over PCIe VC |
| fin_recv_msg() | Receive message from fin |
| fin_get_power() | Read current power draw |
| fin_set_power_limit() | Cap power draw |

## 2. DISPLAY COMPOSITOR API
| Function | Description |
|----------|-------------|
| surface_create(int w, int h) | Create render surface |
| surface_clip_circular() | Apply circular mask |
| surface_present() | Commit to display |
| watch_face_register() | Register watch face plugin |

## 3. SENSOR STREAM API
| Function | Description |
|----------|-------------|
| sensor_open(SENSOR_TYPE) | Open sensor |
| sensor_set_rate(int Hz) | Set sample rate |
| sensor_read(buf, len) | Read samples |

## 4. POWER MANAGEMENT HOOKS
| Function | Description |
|----------|-------------|
| pm_register_wakelock(name) | Prevent sleep |
| pm_unregister_wakelock(name) | Allow sleep |
| pm_get_state() | Get current power state |

