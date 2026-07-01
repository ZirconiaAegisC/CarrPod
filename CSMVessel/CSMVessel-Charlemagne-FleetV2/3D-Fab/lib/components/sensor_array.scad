// ============================================================
// sensor_array.scad — Front Sensory Array and Nose Structure
// Material: BFRP cone + ZrO2/PEEK optical windows for LiDAR
// Color: Cobalt Forge Orange (identification / sensory zone)
// ============================================================

use <../charlemagne_params.scad>

module sensor_array(sf=1.0) {
    NL = p(NOSE_L, sf);
    NR = p(NOSE_BASE, sf);
    
    // ─ Main nose cone (BFRP, Cobalt Orange)
    color(COL_COBALT_ORANGE)
    cylinder(h=NL, r1=NR, r2=NR*0.08, $fn=$fn, center=false);
    
    // ─ LiDAR window (ZrO2, forward-facing — 180°H x 30°V)
    color(COL_ZRB2_SILVER)
    translate([0, 0, NL*0.5])
        rotate([90, 0, 0])
            cylinder(h=NR*0.1, r=NR*0.35, $fn=$fn, center=true);
    
    // ─ Side LiDAR x2 (±90°)
    color(COL_ZRB2_SILVER)
    for(ang = [-90, 90]) {
        rotate([0, 0, ang])
            translate([NR*0.45, 0, NL*0.45])
                sphere(r=max(8, p(20,sf)*0.4), $fn=$fn_fast);
    }
    
    // ─ Camera mounts (8× around waist of nose)
    color(COL_VOID_BLACK)
    for(ang = [0:45:315]) {
        rotate([0, 0, ang])
            translate([NR*0.6, 0, NL*0.3])
                sphere(r=max(5, p(14,sf)*0.3), $fn=$fn_fast);
    }
    
    // ─ Annotation
    color(COL_PHOENIX_WHITE)
    translate([NR*1.2, 0, NL*0.5])
        text(str("LiDAR 250m | 8× cam"),
             size=max(6, p(16,sf)*0.6), font="Liberation Mono");
}

if($preview) {
    sensor_array(sf=SF_BERYL);
}
