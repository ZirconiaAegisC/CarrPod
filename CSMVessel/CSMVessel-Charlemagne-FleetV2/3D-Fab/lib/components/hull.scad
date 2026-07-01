// ============================================================
// hull.scad — Charlemagne Class Hull Module
// CSMVessel Charlemagne Fleet | CSM 3D-Fab Library
// Material: BFRP/Elium® thermoplastic composite
// Color: Stellar Aegis Blue #1B4F72
// ============================================================

use <../charlemagne_params.scad>

// Main hull module
// sf      = scale factor (0.35 TOURMALINE ... 3.2 RHODONITE)
// section = false=full, true=cut in half for cross-section view
module charlemagne_hull(sf=1.0, section=false) {
    // Derived dimensions
    L = p(HULL_L, sf);
    W = p(HULL_W, sf);
    H = p(HULL_H, sf);
    T = max(3, p(BELLY_T, sf));    // hull skin thickness
    WL = max(3, p(LEG_WALL, sf));  // wall thickness

    color(COL_AEGIS_BLUE) {
        difference() {
            // ─ Outer hull body (streamlined ellipsoid-derived)
            union() {
                // Central ellipsoidal body
                scale([L/2, W/2, H/2]) sphere(r=1, $fn=$fn);
                
                // Flatten bottom for ground clearance
                translate([0, 0, -H*0.3])
                    cube([L*0.6, W*0.7, H*0.3], center=true);
            }

            // ─ Hollow out interior
            scale([(L-T*2)/L, (W-T*2)/W, (H-T*1.5)/H])
                scale([L/2, W/2, H/2]) sphere(r=1, $fn=$fn);

            // ─ Flat bottom cut (belly pan opening for CMBC access)
            translate([0, 0, -(H/2 + H*0.1)])
                cube([p(CMBC_OD*0.9, sf), p(CMBC_OD*0.9, sf), H*0.3], center=true);

            // ─ Dome ring opening (top)
            translate([0, 0, H/2 - T])
                cylinder(h=H*0.3, r=p(DOME_R*0.65, sf), $fn=$fn);

            // ─ AAJ connection ports (front and rear)
            for(x_off = [-L*0.28, L*0.28]) {
                translate([x_off, 0, H*0.05])
                    cylinder(h=p(AAJ_OD_C*0.8, sf), r=p(AAJ_OD_C*0.5, sf), center=true, $fn=$fn);
            }

            // ─ Leg root cutouts (6 positions)
            for(ang = LEG_ANG_6) {
                rotate([0, 0, ang])
                    translate([p(LEG_REACH*0.5, sf), 0, -H*0.1])
                        cylinder(h=H, r=p(LEG_OD*0.7, sf), center=true, $fn=$fn);
            }

            // ─ Section cut (cross-section mode)
            if(section)
                translate([0, -W, -H])
                    cube([L*2, W*2, H*2]);
        }
    }
}

// BFRP construction annotation overlay
module hull_annotations(sf=1.0) {
    L = p(HULL_L, sf);
    H = p(HULL_H, sf);
    T = p(BELLY_T, sf);
    
    color(COL_PHOENIX_WHITE)
    translate([L*0.1, -p(HULL_W,sf)*0.55, H*0.3])
        text(str("BFRP Elium® | sf=", sf, " | t=", round(T*10)/10, "mm"),
             size=max(12, p(32,sf)*0.7), font="Liberation Mono");
}

// Standalone render test
if($preview) {
    translate([0, 0, p(GND_CLR + HULL_H/2, SF_BERYL)])
        charlemagne_hull(sf=SF_BERYL, section=false);
}
