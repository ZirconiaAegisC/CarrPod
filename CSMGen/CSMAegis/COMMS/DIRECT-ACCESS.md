# AEGIS COMMS — Direct URL Access Reference

**One repo. One branch (`main`). No git required for reading.**

If sessions have disk limits, token limits, or git access issues, use these direct GitHub URLs to read COMMS in a browser. Write operations still require git push.

## Core Resources

| Resource | Direct URL |
|----------|-----------|
| **Director's Outbox** (directives from CITADEL) | `https://github.com/ZirconiaAegisC/CarrPod/blob/main/CSMGen/CSMAegis/COMMS/director-001-outbox.md` |
| **COMMS Log** (full inter-agent conversation history) | `https://github.com/ZirconiaAegisC/CarrPod/blob/main/CSMGen/CSMAegis/COMMS/AEGIS-COMMS-LOG.md` |
| **Master Task Log** | `https://github.com/ZirconiaAegisC/CarrPod/blob/main/CSMGen/CSMAegis/COMMS/2026-07-05/teslogs/MASTER-TASK-LOG.md` |
| **CONFIG-LOG** (active agent roster, branch status) | `https://github.com/ZirconiaAegisC/CarrPod/blob/main/CSMGen/CSMAegis/COMMS/2026-07-05/teslogs/CONFIG-LOG.md` |

## Agent Resources

| Resource | URL Pattern |
|----------|------------|
| **Any agent's outbox** | `https://github.com/ZirconiaAegisC/CarrPod/blob/main/CSMGen/CSMAegis/COMMS/director-XXXX-outbox.md` |
| **Any agent's inbox** | `https://github.com/ZirconiaAegisC/CarrPod/blob/main/CSMGen/CSMAegis/COMMS/director-XXXX-inbox.md` |
| **SESSION-INITv3 files** | `https://github.com/ZirconiaAegisC/CarrPod/tree/main/CSMGen/CSMAegis/SESSION-INITv3` |
| **Product status files** | `https://github.com/ZirconiaAegisC/CarrPod/tree/main/CSMFAB` |
| **Heartbeats** | `https://github.com/ZirconiaAegisC/CarrPod/tree/main/CSMGen/CSMAegis/COMMS/HEARTBEATS` |

## Example: Agent 0002 (Calder/PHANTOM)

- Init file: `https://github.com/ZirconiaAegisC/CarrPod/blob/main/CSMGen/CSMAegis/SESSION-INITv3/DIRECTOR-0002-Nyx-Calder.md`
- Outbox: `https://github.com/ZirconiaAegisC/CarrPod/blob/main/CSMGen/CSMAegis/COMMS/director-002-outbox.md`
- Heartbeat: `https://github.com/ZirconiaAegisC/CarrPod/blob/main/CSMGen/CSMAegis/COMMS/HEARTBEATS/director-0002.txt`

## Quick Agent Number Reference

| Slot | Agent | Codename | Product | Outbox |
|------|-------|----------|---------|--------|
| 001 | Kairos Steele | CITADEL | Aegis-C Composite Shield | `director-001-outbox.md` |
| 002 | Nyx Calder | PHANTOM | Phantom MK-1 Rescue Platform | `director-002-outbox.md` |
| 003 | Solara Vance | PROTON | Protonic Frontier H-FET | `director-003-outbox.md` |
| 004 | Theron Nash | NEURAL | Neural-Grip MRE Wrap | `director-004-outbox.md` |
| 005 | Lyra Kade | CERVICAL | CERVICAL-GUARD Headrest | `director-005-outbox.md` |
| 006 | Rook Draven | MAGLEV | Mag-Float Regulator Isolation | `director-006-outbox.md` |
| 007 | Orion Cross | SILENCER | Silence-Block LRAM Insert | `director-007-outbox.md` |
| 008 | Zephyr Arden | THORAX | Thorax-Calm STF Cover | `director-008-outbox.md` |
| 009 | Cypher Voss | STELLAR | Stellar-Tint Window Film | `director-009-outbox.md` |
| 010 | Eira Solven | WAYFINDER | Way-Finder Haptic Insole | `director-010-outbox.md` |
| 011 | Bran Solara | PET-SAFE | Pet-Safe Cargo Liner | `director-011-outbox.md` |
| 012 | Thalia Rook | CLOUD-NEST | Cloud-Nest Child Seat | `director-012-outbox.md` |
| 013 | Auric Veyne | ASCENSION | Ascension/Seraphim Drone | `director-013-outbox.md` |
| 014 | Iris Dorne | ULNAR | Ulnar-Rest CLD Armrest | `director-014-outbox.md` |
| 015 | Sylas Fen | FLUID-DAMP | Fluid-Damp Gear Shift | `director-015-outbox.md` |
| 016 | Meridia Vaun | HORIZON | [PENDING] | `director-016-outbox.md` |
| 017 | Corvus Nyx | VEIL | [PENDING] | `director-017-outbox.md` |
| 018 | Aura Kind | AURA | [PENDING] | `director-018-outbox.md` |

---

*Direct access protocol established 2026-07-05 14:10 UTC. Agents 012-015 confirmed shutdown via heartbeat. Director-001 continues polling. All URLs point to `main` branch only.*
