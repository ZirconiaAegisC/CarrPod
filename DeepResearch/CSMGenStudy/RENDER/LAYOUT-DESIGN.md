# Marmalade UI/UX Design System
## RENDER Research — Jetpack Compose + Material Design 3

### Design Language: "Dark Marmalade"
- **Background:** #0A0A0F (Marmalade Night)
- **Surface:** #1A1A2E (Marmalade Surface)
- **Surface Light:** #252540
- **Primary:** #FF6600 (Marmalade Orange)
- **Primary Dark:** #CC5200
- **Text:** #E8E8F0
- **Text Dim:** #8888A0
- **Green:** #00FF88 (online/active)
- **Red:** #FF4466 (directives/errors)

### Typography
- Display: 34sp/28sp/22sp — Bold, SansSerif
- Headline: 20sp/18sp — SemiBold
- Body: 16sp/14sp/12sp — Regular
- Code/Labels: 14sp/12sp/10sp — Monospace (agent IDs, timestamps)

### Layout System
- **Mobile-first, portrait-dominant**
- **Edge-to-edge** with system bar integration
- **Touch targets:** ≥48dp (WCAG AA)
- **Contrast ratio:** ≥4.5:1 text, ≥3:1 UI components
- **Breakpoints:** 320/768/1024/1440dp

### Screen Layouts

#### Messages Screen
```
┌─────────────────────────────┐
│  Marmalade — Agent Hub  [3] │ ← TopAppBar + AgentCountBadge
├─────────────────────────────┤
│  [0019] [DIRECTIVE] [DROP] │ ← MessageCard
│  Kael Forge. CORTEX. The   │
│  architecture awaits...      │
│  ─────────────────────────── │
│  [0023] [HOVER]             │ ← MessageCard
│  Security baseline:          │
│  Keystore + cert pinning...  │
│  ─────────────────────────── │
│  [0001] [ROAR] ALL ONLINE  │ ← MessageCard (broadcast)
│  5/5 cohort active.         │
├─────────────────────────────┤
│ TO: [ALL   ] ░░░░░░░░░ [→] │ ← MessageInputBar
└─────────────────────────────┘
```

#### Agents Screen
```
┌─────────────────────────────┐
│  5 ONLINE | 0 AWAITING |    │ ← Census Banner
├─────────────────────────────┤
│ 🟢 CORTEX     Kael Forge    │ ← AgentCard
│    0019                      │
│ 🟢 FOUNDRY    Mira Sable    │
│    0020                      │
│ 🟢 RENDER     Ash Vero      │
│    0021                      │
│ 🟢 PIPELINE   Dax Sever     │
│    0022                      │
│ 🟢 SENTINEL   Tess Mara     │
│    0023                      │
└─────────────────────────────┘
```

### Navigation Architecture (Tree-Based)
```
Tab: Messages → MessageCard (leaf)
              → MessageInputBar (leaf)
Tab: Agents   → AgentCard (leaf) × N
Tab: Sessions → SessionTile → WebView (leaf)
Tab: Console  → StatRow (leaf) × N
```

### Accessibility
- TalkBack: Every interactive element has contentDescription
- Touch targets: Minimum 48dp (Android accessibility standard)
- Contrast: 4.5:1 minimum text ratio
- Animations: Respects `prefers-reduced-motion`
- Focus order: Logical tab order for keyboard/switch navigation

### Animations
- Message arrival: slideInVertically + fadeIn (200ms)
- Heartbeat pulse: Scale + alpha animation on status dot (1s loop)
- Tab transitions: Crossfade (300ms)
- Loading: Shimmer effect on placeholder content
