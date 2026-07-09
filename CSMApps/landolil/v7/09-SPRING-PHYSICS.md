# PLAN 2 — STAGE 09: SPRING PHYSICS
## Land O' Lil v7 | Director Kairos Steele, CITADEL
## Estimated Duration: 25 minutes | Verification: Daemon Protocol V1

---

## OBJECTIVE

Implement spring-based physics animations for element movement. When a user taps
an element, the camera/view "springs" to center on it. When auto-jump fires,
the selected element has a spring overshoot animation. Elements subtly float/drift
with spring forces between them. Configurable stiffness and damping.

---

## PHASE 1: SPRING PHYSICS ENGINE

### STEP 9.1 — SpringForce Data Class
**Estimated Time:** 3 minutes
**Daemon Timeout:** 6 minutes

**AI Studio Prompt:**

```
Create physics/SpringForce.kt:

data class SpringForce(
    val stiffness: Float = 200f,    // N/m equivalent
    val damping: Float = 0.5f,       // 0.1 = bouncy, 0.9 = stiff
    val restLength: Float = 100f     // natural distance
) {
    fun calculateForce(
        position: Float,
        velocity: Float,
        targetPosition: Float
    ): Float {
        val displacement = position - targetPosition
        val springForce = -stiffness * displacement
        val dampingForce = -damping * velocity
        return springForce + dampingForce
    }

    fun calculateForce2D(
        currentX: Float, currentY: Float,
        targetX: Float, targetY: Float,
        vx: Float, vy: Float
    ): Pair<Float, Float> {
        val distX = currentX - targetX
        val distY = currentY - targetY
        val distance = sqrt(distX * distX + distY * distY)

        if (distance < 0.001f) return 0f to 0f

        val springMagnitude = -stiffness * (distance - restLength)
        val dampingMagnitudeX = -damping * vx
        val dampingMagnitudeY = -damping * vy

        val nx = distX / distance
        val ny = distY / distance

        val fx = nx * springMagnitude + dampingMagnitudeX
        val fy = ny * springMagnitude + dampingMagnitudeY

        return fx to fy
    }

    companion object {
        val MIN_STIFFNESS = 50f
        val MAX_STIFFNESS = 500f
        val MIN_DAMPING = 0.05f
        val MAX_DAMPING = 0.95f
        val DEFAULT_STIFFNESS = 200f
        val DEFAULT_DAMPING = 0.5f
    }
}
```

**Verification:**
- [ ] SpringForce compiles
- [ ] calculateForce() produces Hooke's law + damping
- [ ] calculateForce2D() for 2D space
- [ ] Constants defined with valid ranges
- [ ] Compiles

### STEP 9.2 — SpringAnimationState
**Estimated Time:** 5 minutes
**Daemon Timeout:** 10 minutes

**AI Studio Prompt:**

```
Create physics/SpringAnimation.kt:

class SpringAnimation(
    stiffness: Float = SpringForce.DEFAULT_STIFFNESS,
    damping: Float = SpringForce.DEFAULT_DAMPING
) {
    var stiffness by mutableFloatStateOf(stiffness)
    var damping by mutableFloatStateOf(damping)

    private var springForce = SpringForce(stiffness, damping)

    fun animate(
        currentX: Float, currentY: Float,
        currentVx: Float, currentVy: Float,
        targetX: Float, targetY: Float,
        deltaTime: Float
    ): Quadruple<Float, Float, Float, Float> {
        // quadruple: (newX, newY, newVx, newVy)

        val sForce = springForce.copy(
            stiffness = this.stiffness,
            damping = this.damping
        )

        val (fx, fy) = sForce.calculateForce2D(
            currentX, currentY, targetX, targetY,
            currentVx, currentVy
        )

        val ax = fx  // mass = 1 for simplicity
        val ay = fy

        val newVx = currentVx + ax * deltaTime
        val newVy = currentVy + ay * deltaTime

        val newX = currentX + newVx * deltaTime
        val newY = currentY + newVy * deltaTime

        return Quadruple(newX, newY, newVx, newVy)
    }

    fun isSettled(
        currentX: Float, currentY: Float,
        targetX: Float, targetY: Float,
        currentVx: Float, currentVy: Float,
        threshold: Float = 1.0f
    ): Boolean {
        val dx = currentX - targetX
        val dy = currentY - targetY
        val distance = sqrt(dx * dx + dy * dy)
        val speed = sqrt(currentVx * currentVx + currentVy * currentVy)
        return distance < threshold && speed < threshold
    }
}

// Helper data class
data class Quadruple<A, B, C, D>(
    val first: A, val second: B, val third: C, val fourth: D
)
```

**Verification:**
- [ ] SpringAnimation class compiles
- [ ] animate() returns updated position/velocity
- [ ] isSettled() detects equilibrium
- [ ] Stiffness and damping mutable
- [ ] Compiles

---

## PHASE 2: SPRING JUMP ANIMATION

### STEP 9.3 — Camera Spring to Element
**Estimated Time:** 5 minutes
**Daemon Timeout:** 10 minutes

**Rather than moving a camera, we animate the target element with spring
overshoot to indicate selection. The element "pulses" outward and settles.**

**AI Studio Prompt:**

```
Update ElementCanvas to add spring pulse animation on selection:

Create a map of element ID -> SpringAnimation state.

When an element is selected:
- Get/create SpringAnimation for that element
- Target radius = 48f (overshoot), then settle back to 40f
- Target glowRadius = 70f (overshoot), then settle to 50f

Add an animation loop that updates all active spring animations each frame.

The element radius and glow radius animate with spring physics for a
"boing" effect when selected. The animation starts at current radius,
overshoots to target_overshoot, then settles to target_rest.

After 500ms of being settled at the overshoot, begin settling to rest.
```

**Verification:**
- [ ] Elements "boing" when selected
- [ ] Radius overshoots then settles
- [ ] Glow overshoots then settles
- [ ] Smooth spring animation visible
- [ ] Multiple elements can animate simultaneously
- [ ] Compiles

### STEP 9.4 — Element Floating/Drifting with Springs
**Estimated Time:** 5 minutes
**Daemon Timeout:** 10 minutes

**AI Studio Prompt:**

```
Add subtle spring-based drift to all elements:

Each element has a "home position" (its initial spawn point).
Apply a weak spring force pulling it back to home (low stiffness = 20, low damping = 0.3).
Also apply a random perturbation every 2-3 seconds to create gentle drifting.

Elements should slowly orbit their home positions with spring physics,
creating a living, breathing canvas rather than static positions.

Use ElementState.updatePhysics(deltaTime) with spring forces.
```

**Verification:**
- [ ] Elements subtly drift around home positions
- [ ] Spring forces pull them back
- [ ] Canvas feels alive (not static)
- [ ] No elements fly off-screen
- [ ] Compiles

---

## PHASE 3: CONFIGURABLE SPRING PARAMETERS

### STEP 9.5 — Wire Spring Controls to State
**Estimated Time:** 3 minutes
**Daemon Timeout:** 6 minutes

**AI Studio Prompt:**

```
The elementState has springStiffness and springDamping fields.

Wire them so that changing these values affects the active springs:
- Update all SpringAnimation instances when values change
- Apply to both selection pulse animations and drift animations

The unified menu (Stage 11) will provide sliders for these values.
For now, ensure the state wiring works.
```

**Verification:**
- [ ] Changing springStiffness affects animations
- [ ] Changing springDamping affects animations
- [ ] Real-time updates (no restart needed)
- [ ] Compiles

### STEP 9.6 — Spring Parameter Debug Overlay (Temporary)
**Estimated Time:** 2 minutes
**Daemon Timeout:** 4 minutes

**AI Studio Prompt:**

```
Add a small debug overlay that shows current spring parameters:
- Top-left corner (next to FPS)
- "K: 200 | D: 0.50" in 10sp white text
- Move this to unified menu in Stage 11
```

**Verification:**
- [ ] Spring parameters visible
- [ ] Values update when state changes
- [ ] Compiles

---

## STAGE 09 COMPLETION CHECKLIST

- [ ] SpringForce data class with Hooke's law
- [ ] SpringAnimation class with 2D animation
- [ ] isSettled() equilibrium detection
- [ ] Selection pulse animation (radius overshoot)
- [ ] Element floating drift with weak springs
- [ ] Random perturbations for liveliness
- [ ] Stiffness/damping wired to state
- [ ] Debug overlay for spring parameters
- [ ] Smooth 60fps animation
- [ ] No jitter or instability
- [ ] Errors logged

## NEXT STAGE
Proceed to `10-PROXIMITY-COLORS.md` — Proximity-based color shifts.

---

*"The spring is the most honest mechanical element. It stores energy and 
returns it. It oscillates but settles. It is the mathematics of resilience. 
Our elements don't jump — they spring, overshoot, and find equilibrium. 
Just like the shield layers after a CME strike."* — CITADEL
