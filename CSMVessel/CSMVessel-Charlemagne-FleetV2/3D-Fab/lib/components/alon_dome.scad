// ============================================================
// alon_dome.scad — Charlemagne ALON Geodesic Dome Module
// Material: Aluminum Oxynitride (ALON) Al23O27N5
// Knoop 1800 | E=334 GPa | rho > 10^12 Ohm.m | T=200-5000nm
// Color: ALON transparent tint (semi-transparent cyan-clear)
// ============================================================

use <../charlemagne_params.scad>

// Geodesic dome — Class II 3v for sf<=1.0, 6v for sf>1.0
// Rendered as smooth sphere cap for 3D fabrication clarity
module alon_dome(sf=1.0, transparency=0.3, show_hatch=true, show_nodes=true) {
    R     = p(DOME_R, sf);
    Wall  = max(DOME_WALL, DOME_WALL * sf);  // Never below 8mm
    HAT_W = p(HATCH_W, sf);
    HAT_H = p(HATCH_H, sf);
    
    // Dome coverage angle: 120° arc from equator
    coverage_h = R * (1 - cos(60));  // height of 120° spherical cap

    color(concat(COL_ALON_TINT, [transparency])) {
        difference() {
            // ─ Outer sphere cap
            intersection() {
                sphere(r=R + Wall/2, $fn=$fn_hi);
                translate([0, 0, -R*0.05])
                    cylinder(h=R*2, r=R*2, $fn=$fn);
            }
            
            // ─ Inner sphere (hollow shell)
            intersection() {
                sphere(r=R - Wall/2, $fn=$fn_hi);
                translate([0, 0, -R*0.04])
                    cylinder(h=R*2, r=R*2, $fn=$fn);
            }
            
            // ─ Bottom cut (dome sits on hull ring)
            translate([0, 0, -(R+Wall)])
                cube([R*4, R*4, R*2], center=true);
            
            // ─ Hatch cutout (rear, 130° from front)
            if(show_hatch)
                rotate([0, 0, 150])
                    translate([R*0.6, 0, R*0.3])
                        cube([HAT_W, HAT_H, Wall*4], center=true);
        }
    }

    // ─ Geodesic structural nodes (PEEK CF40, cobalt orange)
    if(show_nodes) {
        node_r = max(8, p(22, sf));
        color(COL_COBALT_ORANGE)
        for(lat = [30, 60, 90]) {
            n_nodes = lat == 30 ? 5 : lat == 60 ? 10 : 10;
            for(i = [0:n_nodes-1]) {
                rotate([0, lat, i * 360/n_nodes])
                    translate([R*0.98, 0, 0])
                        sphere(r=node_r, $fn=$fn_fast);
            }
        }
        // Apex node
        color(COL_COBALT_ORANGE)
            translate([0, 0, R*0.98]) sphere(r=node_r, $fn=$fn_fast);
    }

    // ─ Hatch frame (PEEK CF40, Iron Red)
    if(show_hatch) {
        color(COL_IRON_RED)
        rotate([0, 0, 150])
        translate([R*0.6, 0, R*0.3]) {
            frame_t = max(6, p(12, sf));
            difference() {
                cube([HAT_W + frame_t*2, HAT_H + frame_t*2, frame_t], center=true);
                cube([HAT_W, HAT_H, frame_t*3], center=true);
            }
        }
    }
    
    // ─ Dome mounting ring (PEEK CF40 base ring)
    ring_h = max(20, p(45, sf));
    ring_t = max(10, p(25, sf));
    color(COL_VOID_BLACK)
    cylinder(h=ring_h, r1=R*0.65, r2=R*0.65, $fn=$fn, center=true);
}

// Standalone render test
if($preview) {
    translate([0, 0, p(GND_CLR + HULL_H, SF_BERYL)])
        alon_dome(sf=SF_BERYL, transparency=0.25, show_hatch=true, show_nodes=true);
}
