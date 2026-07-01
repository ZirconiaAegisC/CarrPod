// ============================================================
// cmbc_vault.scad — Centralized Modular Battery Core (CMBC)
// Outer shell: ZrB2-SiC composite (flash-sintered 1800°C)
// Inner: polyimide-silica aerogel + LiFePO4 cell modules
// rho > 10^10 Ohm.m | T_melt 3245°C | GIC immune
// ============================================================

use <../charlemagne_params.scad>

module charlemagne_cmbc(sf=1.0, open=false, show_cells=true) {
    OD   = p(CMBC_OD, sf);    // outer diameter
    H    = p(CMBC_H, sf);     // height
    Wall = p(CMBC_WALL, sf);  // ZrB2-SiC shell wall (30mm at sf=1)
    ID   = OD - Wall*2;       // inner diameter

    // ─ ZrB2-SiC outer vault (silver-grey)
    color(COL_ZRB2_SILVER)
    difference() {
        cylinder(h=H, r=OD/2, $fn=$fn, center=true);
        if(open) {
            // Remove top half for open view
            translate([0, 0, H*0.25])
                cylinder(h=H, r=OD, $fn=$fn, center=true);
        } else {
            // Just hollow out interior
            cylinder(h=H - Wall*2, r=ID/2, $fn=$fn, center=true);
        }
        // Cooling circuit ports
        for(ang = [0, 90, 180, 270]) {
            rotate([0, 0, ang])
                translate([OD/2, 0, H*0.2])
                    rotate([0, 90, 0])
                        cylinder(h=Wall*3, r=max(4, p(8,sf)), $fn=$fn_fast);
        }
        // Pressure relief valve ports (3x at 120°)
        for(ang = [0, 120, 240]) {
            rotate([0, 0, ang])
                translate([OD/2*0.9, 0, H*0.4])
                    sphere(r=max(5, p(12,sf)), $fn=$fn_fast);
        }
    }

    // ─ Aerogel thermal break liner (opaque white, inside vault)
    if(open) {
        color(COL_PHOENIX_WHITE, 0.6)
        difference() {
            cylinder(h=H - Wall*2 - 2, r=ID/2 - 1, $fn=$fn, center=true);
            cylinder(h=H, r=ID/2 - p(25,sf), $fn=$fn, center=true);
        }
    }

    // ─ LiFePO4 cell modules (Iron Red blocks — visible only in open view)
    if(open && show_cells) {
        cell_r = max(10, p(20,sf));
        cell_h = max(20, p(200 * 0.4, sf));
        rows = max(2, round(4*sf));
        cols = max(3, round(6*sf));
        
        color(COL_IRON_RED, 0.8)
        for(r = [0:rows-1]) {
            for(c = [0:cols-1]) {
                x = (c - cols/2 + 0.5) * (cell_r*2.5);
                y = (r - rows/2 + 0.5) * (cell_r*3);
                if(sqrt(x*x + y*y) < ID/2 - cell_r*1.5) {
                    translate([x, y, -(cell_h/2)])
                        cylinder(h=cell_h, r=cell_r, $fn=$fn_fast);
                }
            }
        }
    }

    // ─ Vault lid (ZrB2-SiC, removable — slightly different shade)
    color([0.800, 0.840, 0.920])
    translate([0, 0, H/2 - Wall/2])
        cylinder(h=Wall, r=OD/2 + max(5,p(10,sf)), $fn=$fn, center=true);
    
    // ─ Bottom mounting ring (PEEK CF40)
    color(COL_VOID_BLACK)
    translate([0, 0, -H/2 - p(15,sf)])
        cylinder(h=p(30,sf), r=OD/2 + p(20,sf), $fn=$fn, center=true);

    // ─ Label
    color(COL_SCHUMANN_GRN)
    translate([OD/2 + p(50,sf), 0, 0])
        text(str("CMBC | OD=", round(OD), "mm | sf=", sf),
             size=max(8, p(20,sf)), font="Liberation Mono");
}

if($preview) {
    charlemagne_cmbc(sf=SF_BERYL, open=true, show_cells=true);
}
