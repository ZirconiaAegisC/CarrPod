// ============================================================
// leg.scad — Hexapedal Leg Assembly Module
// Material: BFRP filament-wound tubes (basalt/Elium matrix)
// Joints: ZrO2 ceramic ball joints (AI2O3 ball, PEEK socket)
// Mini-AAJ: scaled KNbO3 bellows at knee joint
// ============================================================

use <../charlemagne_params.scad>

// Complete leg assembly: upper tube + mini-AAJ knee + lower tube
// angle_deg = current leg deployment angle from vertical (0=straight down)
module charlemagne_leg(sf=1.0, angle_deg=15, show_mini_aaj=true) {
    OD   = p(LEG_OD, sf);       // leg tube OD
    Wall = p(LEG_WALL, sf);     // BFRP wall
    LU   = p(LEG_UP, sf);       // upper segment length
    LL   = p(LEG_LOW, sf);      // lower segment length
    
    // Mini-AAJ knee dimensions
    aaj_od = OD * 1.6;
    aaj_l  = OD * 1.2;

    // ─ Upper leg segment (BFRP tube, Aegis Blue)
    color(COL_AEGIS_BLUE)
    difference() {
        cylinder(h=LU, r=OD/2, $fn=$fn, center=false);
        cylinder(h=LU, r=OD/2 - Wall, $fn=$fn, center=false);
    }

    // ─ Mini-AAJ knee joint (PEEK/polyimide, Phoenix White)
    if(show_mini_aaj) {
        translate([0, 0, LU]) {
            color(COL_PHOENIX_WHITE)
            cylinder(h=aaj_l, r=aaj_od/2, $fn=$fn, center=false);
            
            // KNbO3 piezo patches (tiny cobalt orange dots on knee)
            n_p_knee = max(4, round(aaj_n_piezo(sf) / 5));
            color(COL_COBALT_ORANGE)
            for(j = [0:n_p_knee-1]) {
                rotate([0,0, j*360/n_p_knee])
                    translate([aaj_od/2, 0, aaj_l/2])
                        sphere(r=max(3, p(8,sf)*0.3), $fn=$fn_fast);
            }
        }
    }

    // ─ Lower leg segment (angle applies here)
    translate([0, 0, LU + (show_mini_aaj ? aaj_l : 0)]) {
        rotate([angle_deg, 0, 0]) {
            color(COL_AEGIS_BLUE)
            difference() {
                cylinder(h=LL, r=OD/2, $fn=$fn, center=false);
                cylinder(h=LL, r=OD/2 - Wall, $fn=$fn, center=false);
            }
        }
    }

    // ─ Hip root ball joint (ZrO2 ceramic)
    color(COL_ZRB2_SILVER)
    sphere(r=OD*0.85, $fn=$fn);
    
    // ─ Ankle joint (ZrO2)
    translate([0, 0, LU + (show_mini_aaj ? aaj_l : 0) + LL*0.9])
        color(COL_ZRB2_SILVER)
        sphere(r=OD*0.7, $fn=$fn);
}

// Leg Length annotation
module leg_dim_label(sf=1.0) {
    L_total = p(LEG_UP + LEG_LOW, sf) + p(LEG_OD * 1.2, sf);
    color(COL_SCHUMANN_GRN)
    translate([p(LEG_OD,sf)*1.5, 0, L_total*0.5])
        text(str("L=", round(L_total), "mm | BFRP"),
             size=max(6, p(16,sf)*0.7), font="Liberation Mono");
}

if($preview) {
    charlemagne_leg(sf=SF_BERYL, angle_deg=10, show_mini_aaj=true);
    leg_dim_label(sf=SF_BERYL);
}
