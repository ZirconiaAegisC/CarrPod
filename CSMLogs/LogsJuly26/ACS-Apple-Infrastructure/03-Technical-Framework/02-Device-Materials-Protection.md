# Advanced Materials Protection Systems for Consumer Electronic Devices

## Document Control

| Field | Value |
|---|---|
| Document ID | ACS-MATL-PROT-002 |
| Classification | Confidential — Internal Use Only |
| Version | 1.8 |
| Last Revised | 15 July 2026 |
| Author | Apple Critical Systems — Materials Science Division |
| Scope | iPhone, iPad, Mac, Apple Watch, Apple Vision Pro Product Lines |

---

## 1. CERAMIC SHIELD EVOLUTION

### 1.1 First-Generation Ceramic Shield (2020)

Introduced with iPhone 12 in October 2020, Ceramic Shield represented a fundamental departure from conventional chemically strengthened alkali-aluminosilicate glass compositions. Developed through an exclusive collaboration between Apple and Corning Incorporated, Ceramic Shield employed a high-temperature crystallization process to nucleate and grow nanoscale ceramic crystallites — predominantly in the petalite and β-spodumene lithium aluminosilicate phases — within an amorphous glass matrix. These crystallites function as crack deflection and crack-tip blunting agents, dissipating fracture energy that would otherwise propagate catastrophic brittle failure across the glass surface.

The manufacturing process involved controlled devitrification through a proprietary thermal profile at Corning's Harrodsburg, Kentucky, facility, which Apple has supported through a cumulative $2.5 billion commitment from its Advanced Manufacturing Fund. The Harrodsburg plant is the world's largest dedicated smartphone glass production line, with furnace capacity exceeding 100,000 metric tons of specialty glass per annum.

First-generation Ceramic Shield achieved approximately 4x improvement in drop survivability on rough surfaces compared to the dual-ion-exchange strengthened glass used in iPhone 11, as measured by standardized face-drop and edge-drop testing protocols on granite, asphalt, and concrete impact surfaces.

### 1.2 Ceramic Shield 2 (2025, iPhone 17 Pro)

Ceramic Shield 2, introduced with iPhone 17 Pro in September 2025, represents a generational advancement in glass-ceramic materials engineering. Key technical enhancements include:

**Atomic-Level Ceramic Bonding.** Ceramic Shield 2 employs a refined crystallization nucleation protocol that produces crystallites of substantially smaller mean diameter — approximately 15 to 40 nanometers versus 50 to 120 nanometers in the first generation — with higher volumetric number density distributed through the full thickness of the glass substrate. This refinement increases the population of crack-deflecting interfaces per unit crack propagation length, improving fracture toughness (KIc) by approximately 35% as measured by Chevron-notched short-bar fracture toughness testing per ASTM C1421.

**Internal Compressive Stress Regions.** Apple United States Patent 12,583,206 B2, issued in 2025, describes a method for creating localized compressive stress regions within the glass-ceramic article through spatially selective ion exchange. By masking selected surface zones during the potassium nitrate salt bath immersion process, regions of differential compressive stress are created, functioning as crack arrest boundaries that limit the maximum crack length achievable from a single impact event. A crack propagating from the impact origin encounters a compressive stress boundary that arrests further propagation, containing damage to a cosmetic blemish rather than a structural failure.

**Scratch Resistance.** Ceramic Shield 2 demonstrates approximately 3x improvement in scratch resistance over first-generation Ceramic Shield as measured by Knoop indentation hardness (ASTM C1326) and linear scratch testing with progressively loaded diamond stylus (ASTM C1624). The improvement derives from increased crystalline phase fraction, refined crystallite size distribution, and an optimized residual surface compressive stress profile exceeding 900 megapascals (MPa).

**Seven-Layer Anti-Reflective Coating.** The outermost surface of Ceramic Shield 2 incorporates a 7-layer anti-reflective (AR) optical coating stack deposited through magnetron sputtering physical vapor deposition (PVD). The alternating high-index (niobium pentoxide, Nb₂O₅, n ≈ 2.3) and low-index (silicon dioxide, SiO₂, n ≈ 1.46) dielectric layers are designed using proprietary thin-film optical modeling methodologies to produce broadband antireflection across the visible spectrum (400–700 nanometers), reducing surface reflectance to below 0.6% per surface compared to approximately 4% for uncoated glass. This coating simultaneously improves display readability in high-ambient-light conditions and reduces the visibility of surface scratches by minimizing the refractive index contrast at the air-to-scratch-floor interface.

### 1.3 Manufacturing and Supply Chain

Corning's Harrodsburg, Kentucky, facility has expanded glass-ceramic production capacity through successive Apple Advanced Manufacturing Fund investments totaling $2.5 billion. The facility operates 24 hours per day, 365 days per year, with continuous-melt glass furnaces that maintain glass temperatures exceeding 1,500°C with temperature uniformity of ±2°C across the melting zone. Post-forming ceramming kilns execute precisely controlled thermal profiles spanning 8 to 14 hours to achieve the specified crystallite size distribution and volumetric fraction. Quality assurance employs automated optical inspection (AOI) systems scanning for inclusions, cord, striae, and surface defects at resolution below 5 micrometers.

---

## 2. ALUMINUM ALLOY ENGINEERING

### 2.1 6000 Series Alloys (6061, 6063)

**Composition and Properties.** The 6000 series aluminum-magnesium-silicon (Al-Mg-Si) alloy family forms the foundation of MacBook, iPad, Mac mini, and Mac Studio enclosure manufacturing. These precipitation-hardenable alloys derive their mechanical properties from the formation of coherent Mg₂Si (magnesium silicide) precipitate particles during controlled artificial aging heat treatment (typically 8 to 12 hours at 160°C to 190°C, designated T6 temper).

Typical mechanical properties for 6061-T6 include: ultimate tensile strength of 310 MPa, yield strength of 276 MPa, elongation at break of 12 to 17%, and Vickers microhardness of 107 HV. These properties provide an optimal balance of structural rigidity, dent resistance, and machinability for consumer electronics enclosure applications requiring wall sections of 0.8 to 2.5 millimeters.

**Anodizing Compatibility.** 6000 series alloys exhibit excellent response to Type II (sulfuric acid) and Type III (hardcoat) anodizing processes, forming a uniform, adherent aluminum oxide (Al₂O₃) layer of 5 to 25 micrometers thickness with pore structure suitable for electrolytic coloring and organic dye absorption. This enables the integration of color into the protective oxide layer itself rather than through applied paint or coating — a hallmark of Apple's industrial design language since the unibody MacBook Pro introduction in 2008.

**Recycled Content.** Apple's 6000 series aluminum supply chain has achieved an aggregate post-industrial and post-consumer recycled content exceeding 85% for MacBook and iPad enclosures, enabled by the metallurgical tolerance of 6000 series alloys to secondary aluminum feedstock without degradation of mechanical properties or anodizing response. This is achieved through tight compositional control at Apple's specified aluminum smelters, where scrap feedstock sorting, alloying element adjustment, and melt purification (degassing, fluxing, filtration) restore secondary aluminum to primary-equivalent quality.

### 2.2 7000 Series Alloys (7075)

**Composition and Properties.** The 7000 series aluminum-zinc-magnesium-copper (Al-Zn-Mg-Cu) alloy family provides substantially higher strength than 6000 series alternatives. 7075-T6 achieves ultimate tensile strength of 572 MPa and yield strength of 503 MPa — approximately 82% higher than 6061-T6 — with elongation at break of 11%. The strengthening mechanism is precipitation of semi-coherent η' (MgZn₂) transition phase particles during artificial aging.

Applications within Apple's product portfolio include: Apple Watch enclosure structural components requiring high strength-to-weight ratio with minimal wall thickness, Mac Studio structural frame elements resisting torsional and flexural loading, and internal structural brackets where yield strength governs design.

**Processing Considerations.** 7000 series alloys exhibit higher quench sensitivity than 6000 series, requiring rapid cooling from solution treatment temperature (typically 460°C to 480°C) to suppress grain boundary precipitation of equilibrium η phase that would otherwise deplete the alloy of solute available for age hardening. This constrains the maximum section thickness achievable with uniform through-thickness properties. Additionally, 7000 series alloys are more susceptible to stress corrosion cracking (SCC) in the short-transverse grain direction, necessitating careful design of extrusion and forging grain flow to orient the short-transverse direction away from sustained tensile stress exposure.

### 2.3 Heat-Forged Aluminum Unibody (iPhone 17 Pro)

The iPhone 17 Pro enclosure employs a heat-forged aluminum unibody manufacturing process that differs fundamentally from the machined-from-billet approach used in earlier iPhone generations. The process sequence includes: aluminum alloy billet preheating to 420°C to 480°C, closed-die forging under 2,000 to 5,000 metric tons of press force to achieve near-net-shape geometry, controlled cooling to room temperature, solution heat treatment, water quenching, artificial aging to target T6 or T7 temper, and final precision CNC machining to achieve dimensional tolerances of ±25 micrometers.

The forging process produces grain flow that follows the contour of the enclosure geometry — rather than the rectilinear grain structure of a rolled or extruded billet — imparting superior strength along the complex curved surfaces of the enclosure and improved resistance to impact-induced deformation. The refined grain structure (ASTM grain size number 8 to 10, corresponding to mean grain diameter of 11 to 22 micrometers) provides enhanced thermal conductivity through reduced phonon scattering at grain boundaries, improving the enclosure's performance as a thermal spreading element for the SoC and RF power amplifier components.

### 2.4 Custom Alloy Development

Apple's materials science organization collaborates with Corning and additional specialty metallurgy suppliers on custom aluminum alloy formulations optimized for specific product requirements. These development programs target combinations of properties not commercially available in standard Aluminum Association registered alloys — for example, simultaneous achievement of high yield strength (exceeding 350 MPa), excellent anodizing response (uniform, light-colored oxide), high recycled content compatibility (above 90%), and favorable carbon intensity (below 4.0 kg CO₂e per kg aluminum). Custom alloy formulations are protected as trade secrets and manufactured under exclusive supply agreements.

### 2.5 100% Recycled Aluminum Goal

Apple has publicly committed to achieving 100% recycled aluminum content across all product enclosures by 2030, as part of the Apple 2030 carbon neutrality initiative. Progress milestones include: 100% recycled aluminum in Mac mini enclosure (2024), 100% recycled aluminum in Apple Watch Series 9 (2023), and increasing recycled content across iPad and MacBook Air product lines. Achieving this goal requires continued investment in aluminum scrap sorting technology (laser-induced breakdown spectroscopy, X-ray fluorescence sorting), closed-loop recycling partnerships with aluminum smelters, and alloy design that accommodates the compositional variability inherent in post-consumer scrap feedstock.

---

## 3. PROTECTIVE COATINGS

### 3.1 Anodizing

**Process Fundamentals.** Anodizing is an electrochemical process that converts the aluminum surface into a controlled-thickness aluminum oxide (Al₂O₃) layer through anodic polarization in an acid electrolyte — typically 15 to 20 weight percent sulfuric acid at 18°C to 22°C for Type II (decorative/protective) anodizing. The applied voltage (12 to 18 volts direct current for Type II) drives oxidation at the aluminum-to-electrolyte interface, forming a porous oxide structure with pore diameters of 10 to 30 nanometers and pore density of approximately 10¹⁰ to 10¹¹ pores per square centimeter.

The anodic oxide provides corrosion resistance by serving as a barrier layer between the reactive aluminum substrate and the external environment, surface hardness (300 to 500 HV for Type II, 400 to 600 HV for Type III hardcoat) for scratch and wear resistance, and a porous structure suitable for electrolytic coloring (tin, cobalt, or nickel salt deposition into pore bottoms) or organic dye absorption for cosmetic coloration.

**Apple Applications.** Anodized aluminum is the dominant enclosure finish across Apple's product portfolio: MacBook Air and MacBook Pro (silver, space gray, midnight, starlight colorways), iPad Air and iPad Pro, Mac Studio, Mac mini, and Apple Watch aluminum case models. The anodizing process parameters — electrolyte composition, temperature, current density waveform, sealing protocol — are tuned for each product and color to achieve the specified color coordinates (CIE L*a*b*), gloss level, and durability requirements.

### 3.2 Physical Vapor Deposition (PVD)

**Process Description.** Physical Vapor Deposition encompasses vacuum-based thin-film coating processes in which the coating material is vaporized from a solid source (target) and condenses onto the substrate surface. Apple employs two principal PVD modalities: magnetron sputtering (argon ion bombardment of a metallic target, ejecting target atoms that deposit on the substrate) for uniform-thickness coatings on complex geometries, and cathodic arc evaporation for high-adhesion coatings requiring high ionization fraction of the depositing species.

**Titanium Finishing.** Apple Watch titanium models and the iPhone 15 Pro / iPhone 16 Pro / iPhone 17 Pro titanium frame finish employ PVD-deposited titanium carbonitride (TiCN) and diamond-like carbon (DLC) coatings for surface hardness, scratch resistance, and cosmetic appearance. The PVD process operates at substrate temperatures below 200°C to avoid altering the heat-treated microstructure of the titanium alloy substrate (Ti-6Al-4V).

### 3.3 Oleophobic Coatings

Display cover glass receives a vapor-deposited fluoropolymer oleophobic coating — typically a perfluoropolyether (PFPE) silane that covalently bonds to the glass surface through silanol condensation — providing a water contact angle exceeding 110° and an n-hexadecane (oil simulant) contact angle exceeding 65°. This coating reduces fingerprint oil adhesion, facilitates cleaning, and improves tactile feel during touch interaction. The coating is applied at sub-20-nanometer thickness to maintain optical clarity, and is designed for a service life exceeding 2 years of normal use before hydrophobic/oleophobic performance degradation becomes user-perceptible.

### 3.4 Anti-Reflective Coatings

Ceramic Shield 2 incorporates a 7-layer anti-reflective coating stack deposited through magnetron sputtering PVD. See Section 1.2 for detailed description of the optical design, materials (Nb₂O₅/SiO₂ alternating layers), and performance (broadband reflectance below 0.6% per surface across 400–700 nm).

### 3.5 Water and Dust Sealing

Apple's flagship iPhone and Apple Watch models achieve IP68 ingress protection rating per IEC standard 60529, corresponding to dust-tight construction (first digit 6, no ingress of dust in an 8-hour vacuum test) and protection against continuous immersion in water beyond 1 meter depth (second digit 8, manufacturer-specified conditions: 6 meters depth for 30 minutes for iPhone 17 Pro).

The IP68 sealing system employs: precision laser-welded stainless steel or titanium enclosure seams, compression-molded fluoroelastomer (FKM) O-rings and gaskets at all mechanical interfaces (display-to-enclosure, back glass-to-frame, SIM tray, charging port, speaker and microphone ports), pressure-sensitive adhesive (PSA) bonding of display and back glass with adhesive bead width and placement optimized for hydrostatic pressure resistance, and micro-porous expanded polytetrafluoroethylene (ePTFE) vents that permit pressure equalization while blocking liquid water ingress at speaker and barometric altimeter ports.

### 3.6 Dielectric Coatings for Internal Isolation

Internal printed circuit board assemblies (PCBAs) and flexible printed circuits (FPCs) receive conformal dielectric coatings through plasma-enhanced chemical vapor deposition (PECVD) of parylene (poly-para-xylylene) or through selective spray application of UV-curable acrylic conformal coating. These coatings provide electrical isolation between adjacent components on high-density interconnect substrates, protection against electrochemical migration and dendritic growth in the presence of condensed humidity, and supplementary mechanical stabilization of surface-mount components against vibration and shock.

---

## 4. MATERIALS CIRCULARITY

### 4.1 Recycled Critical Materials

Apple's materials circularity program has achieved industry-leading incorporation of recycled content across critical material categories:

- **Cobalt:** 100% recycled cobalt in all Apple-designed batteries as of 2025. Cobalt is recovered from end-of-life lithium-ion batteries through hydrometallurgical processing (leaching, solvent extraction, electrowinning) at Apple-audited recycling partners, with recovered cobalt sulfate meeting or exceeding virgin-material purity specifications for cathode active material synthesis.
- **Rare Earth Elements:** 100% recycled rare earth elements (neodymium, praseodymium, dysprosium, terbium) in all permanent magnets across Apple products as of 2025. Rare earth recovery employs hydrometallurgical separation and molten salt electrolysis at specialized rare earth recycling facilities.
- **Tin:** 100% recycled tin in all solder alloys and gold surface finishes on printed circuit board assemblies, achieved through closed-loop recovery of tin from electronics manufacturing scrap and end-of-life product disassembly.
- **Lithium:** 95% recycled lithium in iPhone 17 Pro batteries, representing the highest recycled lithium content in any mass-market consumer electronic device. Lithium recovery from end-of-life batteries employs electrochemical extraction and lithium carbonate precipitation.

### 4.2 Disassembly Robotics

Apple's Material Recovery Lab in Austin, Texas, operates three specialized disassembly robot platforms:

- **Daisy:** A 10-meter-long robotic disassembly line capable of processing 1.2 million iPhones per year (approximately 200 devices per hour), with automated removal of display module, battery, camera module, Taptic Engine, speaker, logic board, and enclosure screws. Materials recovered include: aluminum enclosure (sorted by alloy family), cobalt and lithium from battery, rare earth magnets, tungsten from Taptic Engine counterweight, gold and copper from logic boards, and camera module components.
- **Dave:** A dedicated robot for disassembly of the Taptic Engine, recovering tungsten counterweights, rare earth magnets, and steel structural components for material-specific recycling streams.
- **Taz:** A shredder-based separation system employing magnetic, eddy current, and density-based separation to recover materials from mixed electronics scrap streams that are not suitable for automated disassembly due to condition or product generation.

### 4.3 Advanced Recovery Center

Apple's Advanced Recovery Center in Santa Clara Valley, California, serves as both a research and development facility for new recycling process technologies and a production-scale materials recovery operation. The facility integrates robotics, shredding, and advanced separation technologies to maximize material recovery rates from end-of-life Apple products returned through the Apple Trade In program, AppleCare service returns, and manufacturing quality-control rejects.

### 4.4 Supplier Zero Waste Program

Over 400 supplier facilities in Apple's global manufacturing supply chain participate in the Zero Waste Program, which requires facilities to divert 100% of non-hazardous waste from landfill through waste reduction, reuse, recycling, and waste-to-energy pathways, verified through third-party auditing. Participating facilities have cumulatively diverted over 3 million metric tons of waste from landfill since program inception.

---

## 5. DURABILITY ENGINEERING

### 5.1 Mechanical Reliability Testing

Apple's product durability validation program subjects devices to accelerated lifecycle testing protocols that simulate years of consumer use within weeks of continuous testing. Protocols include:

- **Drop Testing:** Instrumented drop testing from heights of 0.5 to 2.5 meters onto granite, asphalt, concrete, ceramic tile, and steel impact surfaces, with high-speed video capture (50,000 to 100,000 frames per second) and accelerometer instrumentation to characterize impact dynamics and damage initiation. Devices are dropped in multiple orientations (face-down, edge-down, corner-down, back-down) across a statistically significant sample size to establish failure probability distributions.
- **Fatigue Testing:** Cyclic mechanical loading of enclosure structures (3-point and 4-point bending, torsional loading) at frequencies of 1 to 5 Hz for 10,000 to 100,000 cycles to characterize fatigue life under repeated stress conditions simulating years of in-pocket and in-bag flexural loading.
- **Thermal Cycling:** Exposure to temperature extremes of -20°C to +65°C with dwell times of 2 to 4 hours per extreme, cycled for 100 to 500 cycles, to validate material compatibility across differential thermal expansion coefficients and to identify delamination, cracking, or seal degradation failure modes.

### 5.2 IP68 Water Resistance with Aging Compensation

IP68 water resistance is validated on production-equivalent devices and on devices subjected to accelerated aging protocols that simulate 1 to 3 years of consumer use (including repeated charge-port insertion cycles, button actuation cycles, and thermal cycling). Seal compression set and adhesive bond degradation are characterized through finite element analysis (FEA) modeling and physical teardown of aged devices, with seal design margins adjusted to maintain water resistance through the designed product service life.

### 5.3 Scratch and Dent Resistance

Enclosure materials and surface treatments are evaluated for scratch resistance per ASTM D7027 (progressive-load scratch testing) and for dent resistance through instrumented quasi-static indentation and dynamic impact testing. Acceptance criteria are defined as a function of indentation depth, scratch visibility under standardized lighting conditions (D65 illuminant, 500 lux, 45-degree viewing angle), and post-damage cosmetic acceptability thresholds established through consumer perception studies.

### 5.4 Repairability Enhancements

The iPhone 17 Pro incorporates a redesigned battery attachment system employing electrically released adhesive technology, enabling battery removal through application of a low-voltage electrical current that debonds the adhesive interface without requiring heat-gun or solvent-based adhesive softening techniques used in previous iPhone generations. This design change reduces battery replacement time, decreases the probability of battery damage during removal (a safety concern with lithium-ion cells), and improves service yield. This advancement aligns with Apple's expanding Self Service Repair program, which provides genuine Apple parts, tools, and repair manuals to consumers and independent repair providers.

---

## 6. TITANIUM ALLOY ENGINEERING

### 6.1 Grade 5 Titanium (Ti-6Al-4V)

Grade 5 titanium alloy (Ti-6Al-4V, ASTM B348 Grade 5) is employed for structural frame components in iPhone 15 Pro, iPhone 16 Pro, iPhone 17 Pro, and Apple Watch Edition and Ultra models. Ti-6Al-4V offers an exceptional strength-to-weight ratio: ultimate tensile strength of 950 MPa at a density of 4.43 grams per cubic centimeter — yielding a specific strength of 214 kN·m/kg, approximately 2.5 times that of 7075-T6 aluminum (114 kN·m/kg) and approximately 4 times that of 316L stainless steel (58 kN·m/kg). This enables enclosure frame designs that achieve equivalent structural rigidity to stainless steel at approximately 40% weight reduction.

### 6.2 Manufacturing Process

Apple's titanium frame manufacturing employs a multi-step process: titanium alloy billet forging to near-net-shape geometry, solution treatment and aging to achieve target mechanical properties, precision 5-axis CNC machining to final dimensional tolerances of ±15 micrometers, media blasting or chemical etching for surface texture development, and PVD coating deposition for cosmetic finish and enhanced surface hardness. The machining process requires specialized tooling (polycrystalline diamond or cubic boron nitride cutting tools) and optimized cutting parameters (reduced cutting speed, increased feed rate relative to aluminum) to manage titanium's low thermal conductivity and tendency toward work hardening.

### 6.3 Diffusion Bonding

Apple United States Patent filings describe a solid-state diffusion bonding process for joining titanium frame segments without the localized microstructural alteration and heat-affected zone associated with fusion welding. Diffusion bonding occurs at temperatures of 850°C to 920°C under compressive pressure in a vacuum or inert atmosphere, producing a bond line with mechanical properties approaching those of the parent material. This process is employed for joining titanium frame segments where mechanical fasteners would add unacceptable mass or volume.

---

## 7. ADVANCED GLASS AND OPTICAL MATERIALS

### 7.1 Ion-Exchange Strengthening

Chemically strengthened glass — employed for non-Ceramic-Shield display surfaces and internal optical components — undergoes a dual-ion-exchange process: immersion in a molten potassium nitrate (KNO₃) salt bath at 400°C to 450°C for 4 to 8 hours. Potassium ions (ionic radius 138 picometers) replace smaller sodium ions (ionic radius 102 picometers) in the glass surface layer, creating a compressive stress layer 40 to 100 micrometers deep with peak compressive stress exceeding 800 MPa. The compressive stress layer functions as a crack-arrest barrier: a surface flaw must overcome the compressive stress field before it can propagate as a tensile crack into the glass interior.

### 7.2 Sapphire Crystal

Synthetic single-crystal sapphire (α-aluminum oxide, Al₂O₃, Mohs hardness 9) is employed for Apple Watch display covers on stainless steel and titanium models, iPhone camera lens covers, and Touch ID sensor covers. Sapphire is grown by the Kyropoulos or edge-defined film-fed growth (EFG) method, producing boules up to 200 kilograms, which are then diamond-wire-sawn into wafers, ground, lapped, and polished to optical-grade surface finish. Sapphire's extreme hardness provides near-immunity to scratching from common environmental abrasives (quartz sand, metal keys), though its higher elastic modulus and lower fracture toughness relative to ion-exchange glass result in lower drop-impact survivability.

### 7.3 Micro-OLED and Waveguide Optics (Apple Vision Pro)

The Apple Vision Pro spatial computer employs dual micro-OLED displays — each with 23 million pixels across two panels totaling approximately 3,400 pixels per inch — fabricated on silicon backplanes using organic light-emitting diode (OLED) deposition on complementary metal-oxide-semiconductor (CMOS) substrates. The optical system employs three-element catadioptric pancake lenses with precision-molded aspheric polymer elements, achieving wide field-of-view with compact optical path length. These advanced optical materials and fabrication processes represent Apple's most demanding consumer electronics optical specification to date.

---

## References

1. Apple Inc. United States Patent 12,583,206 B2. *Strengthened Glass Articles and Methods of Forming Same*, issued 2025.
2. Corning Incorporated. *Corning Gorilla Glass and Ceramic Shield: Technical Data Sheet*, 2025.
3. ASTM C1326. *Standard Test Method for Knoop Indentation Hardness of Advanced Ceramics*.
4. ASTM C1421. *Standard Test Methods for Determination of Fracture Toughness of Advanced Ceramics at Ambient Temperature*.
5. ASTM C1624. *Standard Test Method for Adhesion Strength and Mechanical Failure Modes of Ceramic Coatings by Quantitative Single Point Scratch Testing*.
6. ASTM D7027. *Standard Test Method for Evaluation of Scratch Resistance of Polymeric Coatings and Plastics Using an Instrumented Scratch Machine*.
7. IEC 60529. *Degrees of Protection Provided by Enclosures (IP Code)*, Edition 2.2, 2013.
8. Aluminum Association. *International Alloy Designations and Chemical Composition Limits for Wrought Aluminum and Wrought Aluminum Alloys*, 2023.
9. Apple Inc. *Environmental Progress Report*, FY2025.
10. Apple Inc. *Apple 2030: A Plan as Innovative as Our Products*, 2024.

---

*Document prepared by Apple Critical Systems — Materials Science Division. Distribution limited to authorized personnel. © 2026 Apple Inc. All rights reserved.*
