// ============================================================
// aaj.scad — Active Articulation Joint (AAJ) Module
// Material: PEEK/polyimide bellows + KNbO3-BaTiO3 piezo lattice
// + ZrB2-SiC annular reinforcement rings
// Inspired by: Tardigrada (Hypsibius dujardini) accordion body
// ============================================================

use <../charlemagne_params.scad>

// AAJ module — the biomimetic accordion spine of the Charlemagne
// sf        = scale factor
// expanded  = true for amphibious expanded state (buoyancy mode)
// show_piezo= show KNbO3-BaTiO3 piezo elements
module charlemagne_aaj(sf=1.0, expanded=false, show_piezo=true, show_rings=true) {
    OD_c = p(AAJ_OD_C, sf);           // compressed OD
    OD_e = p(AAJ_OD_E, sf);           // expanded OD
    OD   = expanded ? OD_e : OD_c;    // current state OD
    L_c  = p(AAJ_L_C, sf);            // compressed length
    L    = expanded ? L_c * 1.43 : L_c;  // length varies with expansion
    Wall = aaj_wall_t(sf);             // bellows wall (min 3mm)
    n_p  = aaj_n_piezo(sf);            // piezo element count
    n_pl = round(AAJ_PLEAT * sf) + 1;  // pleat count
    ring_h = max(4, p(6,sf));          // ring cross-section height
    ring_w = max(4, p(6,sf));          // ring cross-section width

    // ─ Bellows body (PEEK/polyimide — grey-white)
    color(COL_PHOENIX_WHITE)
    union() {
        // Bellows accordion profile
        for(i = [0:n_pl-1]) {
            seg_z = -L/2 + i * (L/n_pl);
            seg_r = (i % 2 == 0) ? OD/2 : OD*0.42;  // alternating peaks/troughs
            translate([0, 0, seg_z])
                cylinder(h=L/n_pl, r=seg_r, $fn=$fn);
        }
        
        // End flanges
        for(z = [-L/2, L/2 - ring_h]) {
            translate([0, 0, z])
                cylinder(h=ring_h, r=OD/2 + ring_w, $fn=$fn);
        }
    }

    // ─ ZrB2-SiC reinforcement rings (silver-grey)
    if(show_rings) {
        color(COL_ZRB2_SILVER)
        for(i = [0:n_pl-1]) {
            if(i % 2 == 0) {  // rings at peak positions only
                seg_z = -L/2 + i * (L/n_pl) + (L/n_pl)*0.5;
                translate([0, 0, seg_z])
                    difference() {
                        cylinder(h=ring_h, r=OD/2 + ring_w*2, $fn=$fn, center=true);
                        cylinder(h=ring_h*2, r=OD/2 - Wall, $fn=$fn, center=true);
                    }
            }
        }
    }

    // ─ KNbO3-BaTiO3 piezo elements (cobalt orange — 20..570 per vessel)
    if(show_piezo) {
        d_piezo = max(10, p(50, sf));    // disc diameter
        t_piezo = max(3, p(6, sf));      // disc thickness
        rows = max(4, round(8 * sf));
        per_row = max(5, round(n_p / rows));
        
        color(COL_COBALT_ORANGE)
        for(row = [0:rows-1]) {
            z = -L*0.4 + row * (L*0.8/rows);
            for(j = [0:per_row-1]) {
                ang = j * 360/per_row;
                rotate([0, 0, ang])
                translate([OD/2 + t_piezo/2, 0, z])
                    rotate([0, 90, 0])
                        cylinder(h=t_piezo, r=d_piezo/2, $fn=$fn_fast);
            }
        }
    }

    // ─ State annotation
    color(COL_SCHUMANN_GRN)
        translate([OD/2 + p(60,sf), 0, 0])
            text(expanded ? "AAJ: EXPANDED (float mode)" : "AAJ: COMPRESSED (land mode)",
                 size=max(8, p(20,sf)), font="Liberation Mono");
}

if($preview) {
    charlemagne_aaj(sf=SF_BERYL, expanded=false, show_piezo=true, show_rings=true);
}
