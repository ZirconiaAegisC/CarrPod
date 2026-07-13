# CSMFAB0116-38 — USER INTERFACE SPECIFICATION
## 1. CIRCULAR UI PRINCIPLES
- Content must remain visible within 38mm diameter safe zone.
- Text at edges wraps or uses radial layout.
- Lists scroll vertically but content area is clipped circular.
- Icons and touch targets minimum 7mm diameter (accessibility).
- Carousel navigation for primary functions (swipe left/right).
- Crown: rotate to scroll, press to select, double-press for home.

## 2. WATCH FACE API
| Feature | Description |
|---------|-------------|
| Complications | Small widgets on watch face (weather, steps, battery, calendar) |
| Custom faces | User loads image + chooses complication layout |
| Always-On | Simplified face, 1 Hz, under 8 mW |
| Animations | Second hand sweep, weather animations |
| Color themes | Automatic based on time of day, manual override |

## 3. NOTIFICATION SYSTEM
| Type | Behavior |
|------|----------|
| Banner | Slides in from top, auto-dismiss 5s |
| Haptic | Custom vibration pattern per app |
| Priority | Urgent (always), Normal (when wrist raised), Silent (notification dot only) |
| Do Not Disturb | Scheduled or manual, overrides all |
| Focus Modes | Work, Sleep, Driving, Exercise — custom notification filters |

## 4. ACCESSIBILITY
| Feature | Implementation |
|---------|---------------|
| Screen reader | VoiceOver-style (TalkBack compatible) |
| Font scaling | 80% — 200% |
| High contrast | Inverted or boosted contrast mode |
| Mono audio | Downmix stereo to mono |
| Haptic clock | Tap time via vibration patterns |

