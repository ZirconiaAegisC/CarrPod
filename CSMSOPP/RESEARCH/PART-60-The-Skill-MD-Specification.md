# PART 60 — The SKILL.md Specification: Full Technical Architecture

**Research Category:** Kilo Platform / Agent Skills / Technical Implementation

The complete SKILL.md file for deployment is in the MODULE folder. This Part provides the technical rationale for each architectural decision and the specification details.

**Frontmatter — name:** `upbeat-williams-drafter` — lowercase alphanumeric with hyphens, max 64 characters, per the Agent Skills open standard. The name is descriptive (upbeat, drafter) and identifies the persona source (williams) without being so specific as to be confusing.

**Frontmatter — description:** This field is loaded at Level 1 (~100 tokens) and is the ONLY content the agent sees during metadata discovery. It must be precise enough that the agent knows to activate this skill when correspondence or communications are requested, and descriptive enough that the activation is accurate. The description specifies: the dual output format; the emotional register; the use cases (correspondence, document templates, crisis communications, difficult situations); and the key quality promises (warm, kinetic, funny, accurate).

**The five XML body blocks and their rationale:**

`<role>` — Establishes identity before any task is assigned. All subsequent behavior flows from this identity statement. The role block defines: the persona source (Williams); the core values (empathy first, wonder, defiant optimism, data integrity); the language characteristics of the meta-commentary register; and the explicit statement that empathy is the engine, not the decoration.

`<situational_directives>` — The context-reading and cadence-selection system. This is where the severity calibration lives. Without this block, the persona would apply the same energy level to a routine maintenance notice and a tsunami warning. With it, the persona reads severity signals in the input context and selects the appropriate register automatically.

`<output_format>` — The bifurcation enforcement. This block ensures that every output, regardless of how excellent or energetic the meta-commentary is, still contains a complete and precisely formatted deliverable. Without explicit format specification, LLMs tend to let the meta-commentary expand and the deliverable contract. This block prevents it.

`<constraints>` — The ethical hard stops. Placed after the role and format blocks but stated as absolute prohibitions. Per Anthropic's documented architectural best practice, critical constraints placed at the end of a prompt receive heightened weight. The constraints block in the SKILL.md includes both absolute prohibitions and positive constraints.

`<execution_logic>` — The `<thinking>` tag mandate. This ensures the pre-generation verification process runs for every output. This block also contains the final instruction, which per Anthropic's models receives the highest weight: the deliverable must be completed with full precision regardless of meta-commentary quality.

**The three-tier loading architecture during operation:**
- Level 1 (~100 tokens): YAML frontmatter — agent knows skill exists
- Level 2 (<5,000 tokens): Full SKILL.md body — agent has complete instructions
- Level 3 (on-demand): Templates from assets/ folder — loads only when documents are generated

---
*End of Part 60*
