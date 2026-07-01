// ============================================================
// charlemagne_params.scad
// CSMVessel Charlemagne Fleet — Master Parameters Library
// Carrington Storm Motors / Safe Pod Engineering Company
// Version: 1.0 | June 2026 | OpenSCAD parametric 3D library
// ============================================================
// All dimensions in millimeters (mm)
// BERYL (sf=1.0) is the reference platform.
// All vessels: dimension = BERYL_ref * sf
// ============================================================

$fn = 64;           // Preview quality
$fn_hi = 128;       // High-detail exports
$fn_fast = 32;      // Fast preview

// ─── FLEET SCALE FACTORS ───────────────────────────────────
SF_TOURMALINE = 0.35;   // Child toy
SF_OBSIDIAN   = 0.55;   // Adult motorcycle
SF_BERYL      = 1.00;   // 4-seat reference
SF_AMETHYST   = 1.50;   // 8-seat SUV
SF_RHODONITE  = 3.20;   // 3/4-bus transit

// ─── CURIE HARMONIC COLORS (CSMMetal20250004 V2.0) ─────────
COL_AEGIS_BLUE    = [0.106, 0.310, 0.443];  // #1B4F72 primary exterior
COL_COBALT_ORANGE = [1.000, 0.396, 0.000];  // #FF6500 warning/heat zones
COL_IRON_RED      = [0.753, 0.224, 0.169];  // #C0392B emergency handles
COL_NICKEL_AMBER  = [0.839, 0.533, 0.063];  // #D68910 moderate hazard
COL_SCHUMANN_GRN  = [0.153, 0.682, 0.376];  // #27AE60 interior/calm
COL_ARGENT_CYAN   = [0.102, 0.737, 0.612];  // #1ABC9C wet/amphibious zones
COL_VOID_BLACK    = [0.110, 0.157, 0.196];  // #1C2833 void background
COL_PHOENIX_WHITE = [0.992, 0.996, 0.996];  // #FDFEFE thermal insulation
COL_ZRB2_SILVER   = [0.722, 0.776, 0.859];  // ZrB2-SiC ceramic
COL_ALON_TINT     = [0.600, 0.820, 0.980];  // ALON transparent dome

// ─── BERYL REFERENCE DIMENSIONS (sf=1.0) — all in mm ───────
// Hull body
HULL_L  = 3200;   // overall length
HULL_W  = 2100;   // overall width (legs retracted)
HULL_H  = 800;    // hull body height (not including dome)
GND_CLR = 380;    // ground clearance nominal

// ALON Dome
DOME_R    = 1000;   // sphere radius
DOME_WALL = 8;      // minimum wall thickness (never less than 8mm any vessel)

// Active Articulation Joint (AAJ)
AAJ_OD_C  = 480;   // OD compressed
AAJ_OD_E  = 680;   // OD fully expanded
AAJ_L_C   = 350;   // length compressed
AAJ_WALL  = 8;     // bellows wall (min by F2-005)
AAJ_PLEAT = 12;    // accordion pleat count

// CMBC Battery Vault
CMBC_OD   = 900;   // outer diameter
CMBC_H    = 920;   // height
CMBC_WALL = 30;    // ZrB2-SiC shell wall

// Hub Motor Assembly (per wheel)
HUB_OD    = 620;   // wheel outer diameter
HUB_T     = 140;   // hub axle thickness
HUB_BORE  = 80;    // bore diameter
HUB_SPOKE = 60;    // spoke width

// Leg Tubes (BFRP)
LEG_OD    = 80;    // outer diameter
LEG_WALL  = 8;     // BFRP wall
LEG_UP    = 460;   // upper segment length
LEG_LOW   = 460;   // lower segment length
LEG_REACH = 1050;  // center to hub center (Y, half-track)

// Nose Sensor Array
NOSE_L    = 320;   // cone length
NOSE_BASE = 160;   // base radius

// Belly Pan
BELLY_T   = 12;    // BFRP belly pan thickness

// Entry Hatch
HATCH_W   = 520;   // opening width
HATCH_H   = 380;   // opening height (in dome)

// Pontoon Pods (3 per vehicle, belly)
PON_L     = 600;   // pod length
PON_R     = 80;    // pod radius

// ─── SCALING FUNCTIONS ─────────────────────────────────────
function p(dim, sf) = dim * sf;
function aaj_wall_t(sf) = max(3, 8 * sf);
function aaj_n_piezo(sf) = round(96 * pow(sf, 1.5));
function hub_count(sf) = sf <= 1.1 ? 6 : sf <= 1.6 ? 8 : 10;
function aaj_count(sf) = sf <= 1.6 ? 2 : 3;

// Leg angles (degrees from +X forward axis)
// 6-leg hex: front pair, mid pair, rear pair, symmetric port/stbd
LEG_ANG_6 = [-150, -90, -30,  30,  90, 150];    // port side first
LEG_ANG_8 = [-157.5, -112.5, -67.5, -22.5,
               22.5,   67.5, 112.5, 157.5];
LEG_ANG_10= [-162, -126, -90, -54, -18,
                18,  54,  90, 126, 162];

// ─── EXPLODE OFFSETS (mm, multiplied by explode factor 0..1) 
EX_DOME   = 900;    // dome lifts up
EX_AAJ    = 550;    // AAJ sections separate
EX_VAULT  = 350;    // vault drops / forward
EX_LEG    = 450;    // legs spread radially
EX_MOTOR  = 650;    // motors extend on legs
EX_NOSE   = 520;    // nose pulls forward
EX_HATCH  = 220;    // hatch opens backward
EX_PON    = 280;    // pontoons extend downward

// ─── VIEW MODES ───────────────────────────────────────────
ASSEMBLED = 0;
CONNECTED = 1;    // 0.4 explode
EXPLODED  = 2;    // 1.0 explode
SECTION   = 3;    // cross-section half

// Explode factors per mode
function explode_f(mode) =
    mode == ASSEMBLED ? 0.0 :
    mode == CONNECTED ? 0.4 :
    mode == EXPLODED  ? 1.0 : 0.0;

// End charlemagne_params.scad
