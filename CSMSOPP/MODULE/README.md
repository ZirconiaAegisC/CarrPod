# THE WILLIAMS HEURISTIC — MODULE DIRECTORY
## CSMSOPP000001 | Module Folder README

---

## FILES IN THIS FOLDER

### `SKILL.md`
**Primary activation file for Kilo platform deployment.**
Complete SKILL.md specification: YAML frontmatter (name, description, tags, version) + full XML metaprompt body containing `<role>`, `<situational_directives>`, `<output_format>`, `<constraints>`, `<execution_logic>`, `<examples>`.

**Deploy as:** `~/.kilo/skills/upbeat-williams-drafter/SKILL.md`

### `WILLIAMS-HEURISTIC-CORE-MODULE.md`
**Primary context document for direct LLM loading.**
Complete operational specification: who the persona is, values, severity calibration, output format, prohibitions, quality standards. Primary document to include in system prompt or context when deploying outside the Kilo skill framework.

**Use as:** Full system context / prepended context / RAG-retrievable document

### `PERSONA-VALUES.md`
**Deep values and character architecture.**
The human story behind the technical specification. Why the persona operates as it does, grounded in Williams' psychological architecture. Critical for ensuring the AI understands the difference between performing warmth and orienting toward genuine human service.

**Use as:** Companion to CORE-MODULE.md for full contextual grounding

### `LETTERHEAD-TEMPLATES.md`
**Document template library.**
Five complete templates (Memo, SOP, Emergency, External Letter, Email) plus a motto library. LLM populates with specific content per SKILL.md instructions.

**Use as:** Reference or Level 3 asset loaded when document generation requested

---

## HOW TO DEPLOY

### Option A: Kilo Platform
1. Create: `~/.kilo/skills/upbeat-williams-drafter/`
2. Copy `SKILL.md` there
3. Copy `LETTERHEAD-TEMPLATES.md` to `~/.kilo/skills/upbeat-williams-drafter/assets/`
4. Skill auto-discovers at startup (Level 1: ~100 tokens)
5. Activates when user requests correspondence (Level 2: full instructions)
6. Templates load on demand (Level 3: assets)

### Option B: Direct System Context (any LLM)
Load in order:
1. `WILLIAMS-HEURISTIC-CORE-MODULE.md`
2. `PERSONA-VALUES.md`
3. `LETTERHEAD-TEMPLATES.md`

Then assign the communication task.

### Option C: Parallel Agent Deployment (Kilo multi-agent)
Orchestrator distributes tasks to sub-agents each loaded with SKILL.md. Each generates at the appropriate severity level. Orchestrator verifies consistency of critical data across all outputs.

---

## WHAT THE MODULE GENERATES

Every output contains exactly two sections:

**SECTION 1 — META-COMMENTARY:** Williams-register banter proportional to severity. Always ends with a bridge line to the deliverable.

**SECTION 2 — CORE DELIVERABLE:** SOP/memo/letter/email — precisely formatted, completely accurate, imperative-led, bulleted where appropriate. Every number exact. One warm closing line.

---

## THE REMINDER

This module is not humor layered on documents. It is a communication architecture that uses humor as medicine — the psychological mechanism that opens human attention to receive information it might otherwise fail to absorb under stress.

The humor serves the document's effectiveness. The empathy serves the recipient's capacity to act. The precision is the gift that makes everything else matter.

*Nanu Nanu.*

---

*CSMSOPP000001 | Williams Heuristic LLM Module v1.0*
