// ============================================================
// hub_motor.scad — Hexapedal In-Wheel Hub Motor Module
// Housing: PEEK CF40 composite
// Bearings: Si3N4 ceramic (rho > 10^12 Ohm.m — GIC immune)
// Wheel: BFRP paddle-capable deep-tread tire
// IP68+ marine sealed
// ============================================================

use <../charlemagne_params.scad>

// Complete hub motor assembly (motor + tire)
module hub_motor_assembly(sf=1.0, show_bearing=true, paddle_mode=false) {
    OD    = p(HUB_OD, sf);       // wheel OD
    T     = p(HUB_T, sf);        // hub thickness
    bore  = p(HUB_BORE, sf);     // bore diameter
    spk   = p(HUB_SPOKE, sf);    // spoke width
    tire_t= OD * 0.12;           // tire thickness ~12% of OD
    
    // ─ BFRP Wheel rim (Aegis Blue)
    color(COL_AEGIS_BLUE)
    difference() {
        cylinder(h=T, r=OD/2 - tire_t*0.3, $fn=$fn, center=true);
        cylinder(h=T*2, r=bore/2 + spk, $fn=$fn, center=true);
        // Spoke cutouts (6 spokes)
        for(a = [0:60:350]) {
            rotate([0,0,a])
                translate([OD*0.25, 0, 0])
                    cube([OD*0.3, spk, T*2], center=true);
        }
    }

    // ─ Tire (deep-tread, cobalt orange / black — nitrile rubber)
    color(COL_VOID_BLACK)
    difference() {
        cylinder(h=T*1.05, r=OD/2, $fn=$fn, center=true);
        cylinder(h=T*2, r=OD/2 - tire_t, $fn=$fn, center=true);
    }
    
    // ─ Paddle fins on tire (for amphibious paddle-wheel mode)
    if(paddle_mode) {
        n_paddles = 8;
        fin_h = tire_t * 1.2;
        fin_l = T * 0.7;
        color(COL_ARGENT_CYAN)
        for(a = [0:360/n_paddles:359]) {
            rotate([0, 0, a])
                translate([OD/2, 0, 0])
                    cube([fin_h, fin_l, T*0.15], center=true);
        }
    }
    
    // ─ PEEK CF40 motor housing (void black)
    color(COL_VOID_BLACK)
    difference() {
        cylinder(h=T*0.7, r=bore*1.8, $fn=$fn, center=true);
        cylinder(h=T, r=bore/2, $fn=$fn, center=true);
    }
    
    // ─ Si3N4 Ceramic bearing races (silver, innermost)
    if(show_bearing) {
        color(COL_ZRB2_SILVER)
        for(z = [-T*0.25, T*0.25]) {
            translate([0, 0, z]) difference() {
                cylinder(h=T*0.12, r=bore*1.1, $fn=$fn, center=true);
                cylinder(h=T, r=bore/2 + p(2,sf), $fn=$fn, center=true);
            }
        }
        // Label: Si3N4 on bearing face
        color(COL_COBALT_ORANGE)
        translate([bore*1.2, 0, T*0.35])
            text("Si3N4", size=max(4, p(10,sf)*0.8), font="Liberation Mono");
    }
    
    // ─ IP68 cable gland (PEEK — small cylinder on side)
    color(COL_NICKEL_AMBER)
    translate([bore*2.0, 0, 0])
        cylinder(h=p(30,sf), r=p(15,sf), $fn=$fn_fast, center=true);
    
    // ─ Power annotation
    P_W = round(hub_power(sf));
    color(COL_PHOENIX_WHITE)
    translate([OD*0.55, 0, T*0.52])
        text(str(P_W >= 1000 ? str(P_W/1000, "kW") : str(P_W, "W"), " | IP68"),
             size=max(5, p(14,sf)*0.6), font="Liberation Mono");
}

if($preview) {
    hub_motor_assembly(sf=SF_BERYL, show_bearing=true, paddle_mode=false);
}
