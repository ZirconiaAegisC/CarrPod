// ============================================================
// belly_pan.scad — Sealed Belly Pan + Pontoon Pods
// Material: BFRP/Elium® honeycomb belly + BFRP pontoon foam pods
// Pontoons retract flush for ground traverse, extend for float
// ============================================================

use <../charlemagne_params.scad>

module belly_pan(sf=1.0, pontoons_deployed=false) {
    L = p(HULL_L * 0.72, sf);
    W = p(HULL_W * 0.68, sf);
    T = p(BELLY_T, sf);
    
    PL = p(PON_L, sf);
    PR = p(PON_R, sf);
    
    // ─ Main belly pan plate (BFRP, Aegis Blue-dark)
    color(COL_VOID_BLACK)
    difference() {
        cube([L, W, T], center=true);
        // Drain ports (ZrO2 check valves)
        for(x = [-L*0.3, 0, L*0.3]) {
            for(y = [-W*0.25, W*0.25]) {
                translate([x, y, 0])
                    cylinder(h=T*3, r=max(5, p(12,sf)*0.5), $fn=$fn_fast, center=true);
            }
        }
        // CMBC vault cutout
        cylinder(h=T*3, r=p(CMBC_OD*0.46, sf), $fn=$fn, center=true);
    }
    
    // ─ Pontoon pods (3× foam-filled BFRP)
    pod_positions = [[-L*0.25, 0], [L*0.2, W*0.2], [L*0.2, -W*0.2]];
    color(COL_ARGENT_CYAN)
    for(i = [0:len(pod_positions)-1]) {
        px = pod_positions[i][0];
        py = pod_positions[i][1];
        pz_off = pontoons_deployed ? -(PR*2 + T) : -T/2;
        
        translate([px, py, pz_off]) {
            // Pod body
            hull() {
                translate([-PL/2, 0, 0]) sphere(r=PR, $fn=$fn_fast);
                translate([ PL/2, 0, 0]) sphere(r=PR, $fn=$fn_fast);
            }
        }
    }
    
    // ─ State annotation
    color(COL_SCHUMANN_GRN)
    translate([L*0.55, 0, T*0.5])
        text(pontoons_deployed ? "FLOAT MODE" : "LAND MODE",
             size=max(6, p(18,sf)*0.6), font="Liberation Mono");
}

if($preview) {
    belly_pan(sf=SF_BERYL, pontoons_deployed=false);
}
