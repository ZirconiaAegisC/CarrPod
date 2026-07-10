#!/usr/bin/env python3
"""Generate remaining 170 country outreach directories (031-200) in one pass."""
import os

BASE = "/workspace/bb8f9c5f-e866-4346-a29c-8d72daa0ad2d/sessions/agent_7f75d87e-7fa5-4dcf-88b2-42c5585e758b/CarrPod/CSMGeneralOutreach-Global"

# Compact data: (num, slug, name, tier_label, risk_factors, ministry, commentary, sector, closing)
C = [
# ===== TIER 2 (031-070) =====
("031","Vietnam","Vietnam","HIGH — TIER 2",
 "Rapidly industrializing coastal grid; Ho Chi Minh-Hanoi urban corridor; Mekong Delta flood+grid compound risk; manufacturing supply chain electrification",
 "Ministry of Industry and Trade — Vietnam Electricity (EVN)",
 "Your manufacturing corridor from Ho Chi Minh City to Hanoi is one of the fastest-growing industrial power loads in Southeast Asia. Your Mekong Delta — home to twenty million people — faces compound risk where grid failure, satellite disruption, and water management crisis can cascade simultaneously. You are building new transmission faster than most countries build roads, which means the hardening opportunity is right now, while the towers are still being designed. We have the composite non-metallic transmission structures. We have the passive field monitor. We built these for countries whose growth curve means every new substation is a choice between vulnerable and protected.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "Every new transmission tower you build this year is a choice. Let us help you make it the protected one."),

("032","Egypt","Egypt","HIGH — TIER 2",
 "Aswan-Cairo-Alexandria HV corridor; Suez Canal electrification; 110M population in Nile valley; desalination expansion; extreme cooling load",
 "Ministry of Electricity and Renewable Energy",
 "One hundred and ten million people living along a single river — the Nile — which means your grid follows one of the longest linear population corridors on Earth, over a thousand kilometers of continuous conductor from Aswan to Alexandria. Your Suez Canal electrification — ship guidance, lock operations, port logistics — is a global chokepoint running on power assumptions that have never been tested against a geomagnetic event. Your desalination expansion program adds water-security dependency to the same grid. We have the electrocaloric cooling technology. We have the dielectric geopolymer concrete for canal infrastructure.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "Your entire country lives along one transmission line. Let us make sure it is the best-protected line on the continent."),

("033","Pakistan","Pakistan","HIGH — TIER 2",
 "Large integrated grid; Tarbela-Mangla hydro corridors; 240M population; Karachi-Lahore industrial spine; flood+grid compound risk from Indus basin",
 "Ministry of Energy — National Transmission and Despatch Company (NTDC)",
 "Two hundred and forty million people. The Tarbela-Mangla to Lahore-Islamabad transmission corridors are over a thousand kilometers of continuous high-voltage conductor at mid-latitudes. Your Indus basin flood events have already demonstrated what happens when water and electricity infrastructure fail simultaneously — and those were weather events, not a solar one. We have the composite transmission tower design that removes the structure itself as a GIC path. We have the non-conductive BFRP rebar for flood-resilient substation foundations.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "The Indus gives life. Let us make sure the grid doesn't take it away when the storm comes."),

("034","Philippines","Philippines","HIGH — TIER 2",
 "Archipelagic grid (7,600+ islands); submarine cable network; typhoon+GIC compound vulnerability; 115M population; geothermal and hydro transmission corridors",
 "Department of Energy — National Grid Corporation of the Philippines",
 "Seven thousand six hundred islands. Your submarine cable network connects Luzon, Visayas, and Mindanao through some of the most typhoon-exposed waters on Earth. You already harden your grid against tropical cyclones — the same long-conductor submarine cables that survive a Category 5 typhoon are still vulnerable to geomagnetic induced current, which doesn't announce itself with wind and rain. We have the MXene EMI shielding for coastal substation enclosures. We have the LoRa mesh for island-to-island emergency communications.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "You already prepare for the wind. Let us prepare your grid for the invisible current beneath it."),

("035","Malaysia","Malaysia","HIGH — TIER 2",
 "Peninsular+East Malaysia grid; semiconductor manufacturing cluster (Penang); Kuala Lumpur urban power concentration; submarine cable to Sarawak",
 "Ministry of Energy Transition and Water Transformation — Tenaga Nasional Berhad (TNB)",
 "Your Penang semiconductor cluster — one of the largest chip packaging and testing hubs in the world — requires the same microsecond-level power stability as Taiwan's foundries. Your submarine cable to Sarawak is an undersea conductor exposed to equatorial electrojet coupling that Southeast Asian GIC models are only beginning to characterize. Your Kuala Lumpur urban concentration puts a third of your population on a single metropolitan grid. We have the MXene EMI shielding for fab facility enclosures. We have the solid-state GaN power electronics for precision manufacturing.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "The chips you package for the world need the same protection as the chips the world needs."),

("036","Colombia","Colombia","HIGH — TIER 2",
 "Hydro-dominant grid (~70%); mountainous transmission corridors; equatorial GIC understudied; Bogotá-Medellín-Cali urban triangle; mining electrification",
 "Ministerio de Minas y Energía — XM Compañía de Expertos en Mercados",
 "Your hydro-dominant grid — one of the cleanest in the Americas — depends on long transmission corridors through the Andes that follow precisely the north-south orientation maximizing geomagnetic coupling. Your Bogotá-Medellín-Cali urban triangle concentrates over thirty million people on transmission paths whose GIC vulnerability has never been publicly modeled. Your mining electrification — coal, gold, emeralds — adds industrial load to the same corridors. We have the non-conductive composite transmission tower. We have the passive field monitor.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "Your grid climbs mountains. Let us make sure it can survive what comes down from the sky."),

("037","Chile","Chile","HIGH — TIER 2",
 "World's longest north-south grid (~3,100km); southern latitude GIC exposure; mining industry (copper/lithium) electrification; seismic+GIC compound risk",
 "Ministerio de Energía — Coordinador Eléctrico Nacional",
 "Your grid stretches 3,100 kilometers from Arica to Chiloé — the longest north-south transmission corridor on the planet outside of Russia — and your southern region sits at the same geomagnetic latitude as southern Canada. You produce a quarter of the world's copper and half its lithium, and your mining operations depend on grid power that runs along the same exposed transmission paths. Your seismic hardening — among the best in the world — doesn't protect against geomagnetic induced current. We have the composite non-metallic transmission structures. We have the dielectric substation fencing.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "The longest grid in the world also has the longest exposure. Let us shorten that equation."),

("038","Finland","Finland","HIGH — TIER 2",
 "High-latitude GIC extreme exposure; 2003 Halloween Storm operational experience; nuclear power (Olkiluoto/Loviisa); Baltic interconnectors; winter grid dependency",
 "Työ- ja elinkeinoministeriö — Fingrid Oyj",
 "Your grid sits at the highest geomagnetic latitudes in the European Union. Your nuclear plants at Olkiluoto and Loviisa depend on offsite power for cooling — an absolute requirement that a Carrington-class event would test simultaneously with your Baltic interconnectors to Sweden and Estonia. Your winter heating load is non-negotiable: the grid cannot fail in January without converting an infrastructure event into a humanitarian one. We have the dielectric geopolymer concrete for nuclear facility hardening. We have the ceramic-based heating technology that works without grid power.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "In Finland, a grid failure in January is not an inconvenience. It is a body count. We have the materials to prevent that."),

("039","Portugal","Portugal","HIGH — TIER 2",
 "Iberian peninsula western edge; Atlantic submarine cable exposure; limited interconnections (Spain); Lisbon seismic+GIC compound risk; renewable penetration",
 "Ministério do Ambiente e Energia — Redes Energéticas Nacionais (REN)",
 "Your position at the western edge of the Iberian peninsula — electrically semi-isolated from the rest of Europe — means a GIC event that hits your grid has fewer dissipation paths than a more interconnected system. Your Atlantic submarine cables to Madeira and the Azores are island lifelines that a storm can sever electrically without touching physically. Your Lisbon metropolitan area sits on known seismic risk that compounds with any grid disruption. We have the composite transmission tower. We have the LoRa mesh for island emergency communications.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "The edge of the continent cannot look to its neighbors for backup power. Let us build it in."),

("040","Greece","Greece","HIGH — TIER 2",
 "Archipelagic grid with extensive submarine cables; island diesel dependency; tourism infrastructure electrification (20%+ GDP); seismic+GIC compound; Athens metro",
 "Ministry of Environment and Energy — Independent Power Transmission Operator (IPTO/ADMIE)",
 "Your grid connects the mainland to dozens of inhabited islands through submarine cables crossing the Aegean — one of the most seismically active regions on Earth. Your island diesel dependency means any prolonged grid disruption converts into a fuel logistics crisis for populations that cannot evacuate by road. Your tourism infrastructure — supporting an industry representing a quarter of your economy — runs on seasonal peak loads whose failure during summer would strand millions of visitors. We have the solid-state GaN microwave for food service continuity. We have the non-conductive building materials for island substations.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "Islands do not have a neighboring grid to borrow from. Every cable is a promise. Let us keep it."),

("041","Denmark","Denmark","HIGH — TIER 2",
 "Highest wind penetration globally; offshore wind farm GIC coupling; Nordic interconnectors; Copenhagen metro; below-sea-level coastal infrastructure",
 "Klima-, Energi- og Forsyningsministeriet — Energinet",
 "Your wind turbines — the highest penetration of any nation's grid — are distributed conductors mounted on steel towers in the North Sea, which is approximately the ideal geometry for coupling geomagnetic induced current. Your Nordic interconnectors share the same Baltic undersea corridor where the 2003 Halloween Storm demonstrated what GIC can do. Your below-sea-level coastal infrastructure depends on electric pumping stations whose failure during a simultaneous storm surge would convert a grid event into a flood event. We have the basalt-fiber composite tower designs. We have the MXene coating for offshore substation platforms.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "You built the world's best wind grid. Now let us shield it against the one thing the wind can't stop."),

("042","Czech-Republic","Czech Republic","HIGH — TIER 2",
 "Central European grid hub; nuclear power (Dukovany/Temelín); industrial manufacturing electrification; dense rail electrification; multiple interconnectors",
 "Ministerstvo průmyslu a obchodu — ČEPS, a.s.",
 "Your position in the heart of Central Europe makes your transmission system a crossroads for GIC propagation across the ENTSO-E interconnection. Your nuclear plants at Dukovany and Temelín depend on offsite power for cooling — the same absolute requirement that makes every nuclear nation a stakeholder in geomagnetic preparedness. Your industrial manufacturing base — automotive, machinery, electronics — runs on production schedules that a grid disruption measured in days would convert into supply chain disruption in quarters. We have the dielectric geopolymer concrete. We have the composite substation fencing.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "The factory floor of Europe deserves a shield as reliable as the machines it runs."),

("043","Romania","Romania","HIGH — TIER 2",
 "Large Balkan grid; Cernavodă nuclear plant; Carpathian transmission corridors; Black Sea offshore energy development; transformer aging concerns",
 "Ministerul Energiei — Transelectrica",
 "Your Carpathian transmission corridors carry power through mountain passes where winter access alone makes transformer replacement a seasonal operation. Your Cernavodă nuclear plant depends on offsite power, and your Black Sea offshore energy development — both wind and gas — is adding new undersea conductor exposure to a grid never modeled for GIC at this scale. We have the composite non-metallic transmission structures. We have the passive field monitor that can give your mountain substations the same warning your urban ones have.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "Replace a transformer in the Carpathians in January, and you'll understand why we build the shield first."),

("044","Ukraine","Ukraine","HIGH — TIER 2",
 "War-damaged grid with GIC exposure; nuclear fleet (Zaporizhzhia et al.); ENTSO-E synchronization March 2022; reconstruction presents hardening opportunity",
 "Ministry of Energy of Ukraine — Ukrenergo",
 "Your grid has demonstrated, under the most extreme conditions imaginable, both its fragility and its resilience. Your synchronization with ENTSO-E in March 2022 — accomplished in weeks instead of planned years — connected your transmission system to the European interconnection. Your nuclear fleet requires offsite power for safety. We have the composite transmission tower design. We have the dielectric substation fencing. We have the LoRa mesh for emergency communications. We built these for the exact moment you are in: rebuilding, reconnecting, and able to choose protection from the ground up.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "You are rebuilding the grid anyway. Let us help you build it hardened from the first tower."),

("045","Nigeria","Nigeria","HIGH — TIER 2",
 "Largest African grid and population (220M+); chronic grid instability masks GIC vulnerability; oil/gas infrastructure electrification; Lagos megacity (20M+)",
 "Ministry of Power — Transmission Company of Nigeria (TCN)",
 "Two hundred and twenty million people — the largest population and grid on the African continent — connected through a transmission system whose chronic instability could mask a GIC event until too late to distinguish cause from effect. Your Lagos megacity — over twenty million people — would convert a grid failure into a humanitarian logistics crisis within forty-eight hours. We have the LoRa mesh emergency communications. We have the non-conductive building materials suite. We have the passive field monitor that costs less than a single transformer.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "Africa's largest grid deserves Africa's first geomagnetic preparedness protocol. Let us write it together."),

("046","Bangladesh","Bangladesh","HIGH — TIER 2",
 "170M population on flood-prone delta; Dhaka-Chittagong industrial corridor; gas-dependent generation; cyclone+GIC compound; garment industry electrification",
 "Ministry of Power, Energy and Mineral Resources — Power Grid Company of Bangladesh",
 "One hundred and seventy million people on the world's largest river delta — land that floods during normal monsoons — dependent on a grid whose GIC vulnerability has never been publicly modeled at national scale. Your garment industry powers factories that clothe a significant fraction of the world, and every hour of downtime converts factory workers into displaced populations. We have the electrocaloric cooling technology. We have the solid-state cooking appliances that work without grid power.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "The delta that feeds and clothes the world should be the first place the shield gets deployed, not the last."),

("047","UAE","United Arab Emirates","HIGH — TIER 2",
 "Desalination power dependency (~42% water supply); Dubai/Abu Dhabi urban concentration; Barakah nuclear plant offsite power; extreme cooling load; financial hub",
 "Ministry of Energy and Infrastructure — Dubai Electricity and Water Authority (DEWA)",
 "Forty-two percent of your water comes from desalination plants that stop producing the moment the grid fails. Your Barakah nuclear plant — the first in the Arab world — requires continuous offsite power for cooling. Your Dubai financial sector and Abu Dhabi government operations run on data centers whose power assumptions have never been tested against a simultaneous grid-and-satellite disruption. We have the electrocaloric cooling — Stellar-Chill — that doesn't depend on a compressor cycle. We have the MXene EMI shielding for data center facilities.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "In the desert, the grid and the water tap are the same pipe. We built the shield that keeps both open."),

("048","Israel","Israel","HIGH — TIER 2",
 "Island grid (limited interconnections); desalination dependency (~80% domestic water); tech sector power stability; security-sensitive infrastructure",
 "Ministry of Energy and Infrastructure — Israel Electric Corporation",
 "Eighty percent of your domestic water comes from desalination — the highest dependency of any nation on Earth. Your electrical islanding means you cannot import grid stability during a regional GIC event. Your tech sector — chip design, cybersecurity, defense electronics — requires microsecond-level power stability. We have the MXene EMI shielding rated at 90+ dB for facility enclosures. We have the solid-state GaN power electronics for precision loads.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "You turn seawater into drinking water through electricity. Let us make sure that electricity never stops."),

("049","Singapore","Singapore","HIGH — TIER 2",
 "City-state grid; subsea interconnectors to Malaysia; financial/data center hub; desalination/NEWater dependency; port electrification; low latitude GIC understudied",
 "Ministry of Trade and Industry — Energy Market Authority (EMA)",
 "Your grid may be the most concentrated on Earth — a single island city-state with subsea interconnectors to Malaysia whose GIC coupling at equatorial latitudes is genuinely understudied relative to the financial value they carry. Your data center concentration — among the densest in Asia — processes a significant fraction of global financial transactions. Your NEWater and desalination plants convert your water security into an electrical equation with no backup plan at national scale. We have the MXene EMI shielding. We have the solid-state GaN electronics.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "A city-state is only as strong as its longest cable. Let us make sure yours is the best-shielded on Earth."),

("050","Hungary","Hungary","HIGH — TIER 2",
 "Central European grid node; nuclear power (Paks); multiple interconnectors; automotive manufacturing electrification; Budapest metro concentration",
 "Ministry of Energy — MAVIR",
 "Your Paks nuclear plant — supplying roughly half your electricity — depends on the same offsite power requirement that makes every nuclear nation a stakeholder in geomagnetic preparedness. Your automotive manufacturing sector — Audi, Mercedes, Suzuki — runs on just-in-time production that assumes continuous grid power. Your seven international interconnectors make you a GIC propagation node for Central Europe. We have the dielectric geopolymer concrete for nuclear facility hardening. We have the composite substation fencing.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "A grid at the center of Europe carries everyone's currents. Let us make sure yours are the ones that survive."),

("051","Peru","Peru","HIGH — TIER 2",
 "Andean transmission corridors; Lima coastal concentration; mining industry electrification (copper); hydro-dominant grid; seismic+GIC compound risk",
 "Ministerio de Energía y Minas — Comité de Operación Económica del Sistema (COES)",
 "Your Andean transmission corridors carry power through some of the highest-altitude substations on Earth — installations whose replacement logistics make European mountain sites look accessible. Your mining industry — copper, gold, zinc — represents an export share that a prolonged grid disruption would convert directly into a national revenue crisis. Your Lima coastal concentration puts a third of your population on a metropolitan grid exposed to both seismic and geomagnetic compound risk. We have the non-conductive composite transmission tower. We have the basalt-fiber rebar for high-altitude foundation hardening.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "Your substations are already at altitude. Let us make sure they can handle what comes from higher."),

("052","Kazakhstan","Kazakhstan","HIGH — TIER 2",
 "Vast east-west grid across high latitude; Soviet-era transformer fleet; oil/gas infrastructure electrification; UHV transmission to China; extreme temperature range",
 "Ministry of Energy — Kazakhstan Electricity Grid Operating Company (KEGOC)",
 "Your grid spans one of the largest land areas of any country — over 2.7 million square kilometers — at latitudes directly exposed to the auroral electrojet. Your Soviet-era transformer fleet is aging at the moment when replacement lead times are most affected by global supply-chain disruption. Your UHV transmission corridors to China are among the longest east-west conductors in Central Asia. We have the composite transmission tower design. We have the passive field monitor.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "Your grid covers a continent's worth of distance. Let us protect it at the scale it operates."),

("053","Iraq","Iraq","HIGH — TIER 2",
 "Conflict-damaged grid with reconstruction opportunity; oil infrastructure electrification; extreme cooling load (50C+); Baghdad-Basra-Kirkuk transmission triangle",
 "Ministry of Electricity",
 "Your grid has been damaged, repaired, and rebuilt more times than most nations' history books record — but that means every reconstruction phase is an opportunity to embed hardening from the ground up. Your oil infrastructure electrification depends on grid power whose GIC vulnerability has never been publicly modeled. Your extreme summer cooling load — temperatures exceeding 50°C — makes grid failure a direct threat to human life. We have the electrocaloric cooling technology. We have the dielectric geopolymer concrete for substation reconstruction.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "Rebuilding the grid is hard. Rebuilding it hardened is harder only if you wait. Let us help you do it now."),

("054","Algeria","Algeria","HIGH — TIER 2",
 "Largest African national grid by area; hydrocarbon revenue electrification; north-south Saharan transmission corridors; Mediterranean undersea interconnectors; extreme cooling",
 "Ministry of Energy and Mines — Sonelgaz",
 "Your grid covers the largest national area in Africa — 2.4 million square kilometers — with north-south transmission corridors that follow precisely the orientation maximizing geomagnetic coupling. Your Mediterranean undersea interconnectors to Europe are exposed to GIC conditions at the southern edge of the auroral zone. We have the composite transmission structures. We have the electrocaloric cooling for the extreme heat loads your grid carries in summer.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "Your grid crosses the Sahara. The storm crosses the solar system. Only one of these should worry you."),

("055","Venezuela","Venezuela","HIGH — TIER 2",
 "Guri Dam HV corridors (~800km); Caracas urban concentration; chronic grid instability; oil infrastructure electrification; tropical GIC underexplored",
 "Ministerio del Poder Popular para la Energía Eléctrica — CORPOELEC",
 "Your Guri Dam transmission corridors — eight hundred kilometers of high-voltage lines to Caracas — are among the longest single-hydroelectric connections in the Americas, and a textbook geomagnetic coupling antenna. Your chronic grid instability means a GIC event could be misdiagnosed as ordinary failure until transformer damage is irreversible. We have the composite transmission tower design. We have the passive field monitor that distinguishes GIC signatures from ordinary grid faults.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "A grid that already flickers must be able to tell the difference between a fault and a storm. Let us give you that tool."),

("056","Morocco","Morocco","HIGH — TIER 2",
 "Mediterranean-Atlantic grid bridging Africa-Europe; Noor solar complex electrification; undersea interconnector to Spain; tourism infrastructure; Tangier industrial zone",
 "Ministry of Energy Transition and Sustainable Development — Office National de l'Électricité (ONEE)",
 "Your grid sits at the geographic and electrical intersection of Africa and Europe — the undersea interconnector to Spain is both a strategic asset and a GIC coupling pathway. Your Noor solar complex — one of the largest concentrated solar plants on Earth — represents inverter-based generation whose GIC response is being characterized. Your Tangier industrial zone and tourism infrastructure are electrified sectors whose simultaneous failure would convert a grid event into a national economic event. We have the MXene EMI shielding. We have the passive field monitor.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "You connect two continents through a single cable. Let us make sure the storm can't use it as a doorway."),

("057","New-Zealand","New Zealand","HIGH — TIER 2",
 "Island grid with HVDC inter-island link; southern latitude GIC; geothermal and hydro transmission; Christchurch seismic recovery lessons; dairy/agriculture electrification",
 "Ministry of Business, Innovation and Employment — Transpower",
 "Your HVDC inter-island link — connecting the North and South Islands across Cook Strait — is one of the longest submarine power cables in the Southern Hemisphere, and your southern region sits at the same geomagnetic latitude that produced the 1989 Hydro-Québec blackout. Your dairy and agriculture electrification represents an export sector whose disruption during a GIC event would compound with the same GPS disruption the May 2024 storm demonstrated on US farms. We have the composite non-metallic transmission structures. We have the LoRa mesh for cross-strait communications.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "Two islands, one cable, and the same latitude as the 1989 blackout. The math on hardening is clear."),

("058","Ireland","Ireland","HIGH — TIER 2",
 "Atlantic island grid; extensive offshore wind GIC exposure; data center concentration (Dublin); interconnectors to UK; rural grid resilience",
 "Department of the Environment, Climate and Communications — EirGrid",
 "Your Atlantic-facing offshore wind farms are distributed conductors in some of the most geomagnetically active waters in Western Europe. Your Dublin data center concentration — processing significant European cloud traffic — runs on power assumptions never tested against simultaneous grid-and-satellite disruption. Your interconnectors to the UK are your only grid neighbors. We have the MXene EMI shielding for data center facilities. We have the composite tower designs for offshore wind.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "An island grid with two neighbors — both undersea cables. Let us make sure the storm respects the boundary."),

("059","Kuwait","Kuwait","HIGH — TIER 2",
 "Desalination power dependency (~90%+ water); extreme cooling load (50C+); oil production electrification; small grid concentrated vulnerability; Gulf interconnection",
 "Ministry of Electricity, Water and Renewable Energy",
 "Over ninety percent of your water comes from desalination — among the highest dependency of any nation. Your extreme summer temperatures — exceeding 50°C — make grid failure a direct threat to human survival, not an inconvenience. Your small grid size concentrates vulnerability: fewer transformers mean each one matters more. We have the electrocaloric cooling technology that doesn't depend on the grid's compressor cycle. We have the ceramic-based water heater that works without electricity.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "When the grid fails in Kuwait, the water stops and the heat starts. Neither can wait for a replacement transformer."),

("060","Qatar","Qatar","HIGH — TIER 2",
 "Desalination and LNG electrification dependency; extreme cooling load; concentrated urban grid; Gulf interconnection via GCCIA",
 "Ministry of Energy — Qatar General Electricity and Water Corporation (KAHRAMAA)",
 "Your LNG production electrification — the world's largest liquefaction capacity — runs on grid power whose GIC vulnerability has never been publicly stress-tested. Your desalination dependency means water security is an electrical equation with no backup plan at national scale. Your GCCIA interconnection provides regional redundancy but also regional GIC propagation paths. We have the electrocaloric cooling technology. We have the MXene EMI shielding for LNG facility control systems.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "The world's largest LNG exporter should not have its control systems taken offline by the world's oldest hazard."),

("061","Slovakia","Slovakia","HIGH — TIER 2",
 "Central European grid node; nuclear power (Mochovce/Bohunice); automotive manufacturing electrification; Carpathian transmission corridors; multiple interconnectors",
 "Ministry of Economy — Slovenská elektrizačná prenosová sústava (SEPS)",
 "Your nuclear plants at Mochovce and Bohunice supply over half your electricity and depend on offsite power cooling. Your automotive manufacturing sector — Volkswagen, Kia, Stellantis, Jaguar Land Rover — runs on production lines that a grid disruption in days would convert into supply-chain disruption in weeks. We have the dielectric geopolymer concrete. We have the composite substation fencing.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "Nuclear safety and automotive production share your grid. Let us protect what they both depend on."),

("062","Croatia","Croatia","HIGH — TIER 2",
 "Adriatic coastal grid; tourism infrastructure electrification (~20% GDP); island submarine cables; EU interconnection; seismic+GIC compound; emerging LNG terminal",
 "Ministry of Economy and Sustainable Development — HOPS d.o.o.",
 "Your Adriatic coast tourism infrastructure — supporting an industry representing roughly twenty percent of your economy — runs on seasonal peak loads whose failure during summer would strand millions in port cities with limited evacuation capacity. Your island submarine cables connect dozens of inhabited Adriatic islands through one of the most seismically active coastlines in Europe. We have the LoRa mesh for island emergency communications. We have the solid-state GaN microwave.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "A thousand islands connected by a thousand cables. Let us make sure the storm doesn't sever any."),

("063","Bulgaria","Bulgaria","HIGH — TIER 2",
 "Balkan grid node; nuclear power (Kozloduy); multiple interconnectors; Soviet-era transformer fleet; Black Sea coastal grid; winter heating dependency",
 "Ministry of Energy — Elektroenergien Sistemen Operator (ESO)",
 "Your Kozloduy nuclear plant supplies roughly a third of your electricity and depends on offsite power for cooling. Your Soviet-era transformer fleet is aging at the moment when global replacement lead times are most affected by supply-chain vulnerability. Your Black Sea coastal grid carries summer tourism load and winter heating load through the same corridors. We have the dielectric geopolymer concrete. We have the composite transmission tower design.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "Nuclear power and winter heating on the same grid. Neither can fail. We have the materials to guarantee it."),

("064","Slovenia","Slovenia","HIGH — TIER 2",
 "Alpine grid; nuclear power (Krško); Central European interconnection hub; dense road/rail electrification; small grid concentrated vulnerability",
 "Ministry of the Environment, Climate and Energy — ELES",
 "Your Krško nuclear plant — jointly operated with Croatia — supplies nearly forty percent of your electricity. Your small grid size concentrates vulnerability: with few transformers, each one carries a disproportionate share of national load. Your Alpine geography makes replacement logistics seasonal: the mountain passes close in winter. We have the dielectric geopolymer concrete. We have the composite transmission structures.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "Small grid. Nuclear baseline. Alpine access. Every transformer is a national asset. Let us protect each one."),

("065","Lithuania","Lithuania","HIGH — TIER 2",
 "Baltic grid synchronized with ENTSO-E 2025; high-latitude GIC; LitPol Link and NordBalt interconnectors; Soviet-legacy infrastructure modernization; winter heating",
 "Ministry of Energy — Litgrid AB",
 "Your recent ENTSO-E synchronization — completed February 2025 — connected your grid to continental Europe at precisely the moment GIC hardening should be embedded in the new architecture. Your high-latitude position in the Baltic exposes you to the auroral electrojet. Your LitPol Link to Poland and NordBalt to Sweden are interconnectors whose GIC coupling has never been modeled at the new synchronous scale. We have the composite transmission towers. We have the passive field monitor.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "You just synchronized your grid with Europe. Synchronize your hardening with the solar cycle."),

("066","Latvia","Latvia","HIGH — TIER 2",
 "Baltic grid; high-latitude GIC; ENTSO-E synchronization 2025; Soviet-era infrastructure; EstLink and LitPol interconnectors; winter heating dependency",
 "Ministry of Climate and Energy — Augstsprieguma tīkls (AST)",
 "Your high-latitude position on the Baltic Sea exposes your transmission system to geomagnetic induced currents at one of the highest flux levels in the EU. Your ENTSO-E synchronization means GIC-induced harmonics propagate differently through European frequency standards than through the old IPS/UPS system. Your winter heating dependency is absolute: the grid cannot fail in January. We have the non-conductive composite materials. We have the ceramic-based heating technology.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "The Baltic winter does not negotiate with a broken grid. Let us make sure it never has to."),

("067","Estonia","Estonia","HIGH — TIER 2",
 "Baltic grid — highest digitalization; ENTSO-E synchronization 2025; EstLink interconnectors to Finland; e-governance infrastructure power dependency; high-latitude GIC",
 "Ministry of Climate — Elering",
 "Your grid is the most digitally integrated in the Baltic — your e-governance infrastructure, digital identity system, and data embassy in Luxembourg all depend on continuous power. Your EstLink interconnectors traverse the Gulf of Finland undersea corridor at the same latitude where the 2003 Halloween Storm blacked out Malmö. We have the MXene EMI shielding for data center facilities. We have the passive field monitor.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "The most digital society in Europe should not be the one most exposed to an analog hazard from space."),

("068","Uruguay","Uruguay","HIGH — TIER 2",
 "Near-100% renewable grid (hydro/wind/solar); southern latitude GIC; Salto Grande binational HV link; small grid concentrated vulnerability; agricultural electrification",
 "Ministerio de Industria, Energía y Minería — UTE",
 "Your grid — nearly one hundred percent renewable, one of the cleanest on Earth — is a remarkable achievement whose inverter-based generation fleet has never been modeled for GIC response at this penetration level. Your Salto Grande binational HV link with Argentina is a cross-border conductor of precisely the geometry that couples to geomagnetic storm currents. Your small grid means every transformer carries a disproportionate national load. We have the composite transmission structures. We have the passive field monitor.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "The cleanest grid in the Americas deserves the cleanest shield against the oldest hazard."),

("069","Costa-Rica","Costa Rica","HIGH — TIER 2",
 "Near-100% renewable grid (hydro/geothermal/wind); tropical GIC understudied; mountainous transmission corridors; San José metro concentration; tourism infrastructure",
 "Ministerio de Ambiente y Energía — Instituto Costarricense de Electricidad (ICE)",
 "Your grid runs on nearly one hundred percent clean energy through mountainous corridors whose GIC coupling at tropical latitudes is genuinely understudied. Your San José metropolitan concentration — in the Central Valley, ringed by mountains — puts your economic center on a grid whose topology amplifies geomagnetic coupling. Your tourism infrastructure supports roughly eight percent of GDP. We have the composite non-metallic transmission towers. We have the LoRa mesh for emergency communications.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "Clean energy. Mountain terrain. A grid that proves the future is possible. Let us make sure it survives the storm."),

("070","Panama","Panama","HIGH — TIER 2",
 "Panama Canal electrification; global shipping chokepoint; Central American grid interconnection (SIEPAC); tropical GIC; Panama City metro; logistics hub",
 "Secretaría Nacional de Energía — Empresa de Transmisión Eléctrica (ETESA)",
 "Your Panama Canal — one of the most critical chokepoints in global trade — runs on grid power whose GIC vulnerability has never been publicly modeled. A Carrington-class event disabling canal lock operations would be a global supply chain event measured in weeks of diverted shipping. Your SIEPAC interconnection is a regional transmission corridor whose GIC behavior at tropical latitudes is genuinely understudied. We have the dielectric geopolymer concrete for canal infrastructure. We have the MXene EMI shielding for lock control systems.",
 "02-Electric-Grid-Reliability-Regulators-and-Agencies",
 "The canal that carries six percent of world trade should be the most electromagnetically protected infrastructure on Earth."),
]

# TIER 3-5 countries use templated template with core data
TIER345_TEMPLATE = """================================================================================
                 CARRINGTON STORM MOTORS | SAFE POD ENGINEERING COMPANY
                 Global Outreach Series | "Protect Biological Life. Never End It."
================================================================================
DATE:          July 2026
PREPARED FOR:  {name} — {ministry}
SUBJECT:       The Dielectric Citadel — Carrington-Class Geomagnetic Preparedness Briefing
REF:           CSMGlobal{num}
PRIORITY:      {tier}
COUNTRY RISK FACTORS: {risk}
================================================================================

## WILLIAMS REGISTER — SECTION 1: META-COMMENTARY

{commentary}

---

## SECTION 2: CORE DELIVERABLE

**PURPOSE:** Inform {name} leadership of Carrington-class CME threat and extend Aegis-C Composite Shielding System technical partnership offer.

**KEY DATA POINTS:**
1. Solar Cycle 25 peak: SSN ~137 (19% above 2019 forecast) — NOAA SWPC Q1 2026 confirmation
2. May 2024 Gannon Storm (G5/Kp9): $500-565M U.S. agricultural GPS losses; measurable transformer stress across North America
3. Lloyd's of London modeled severe space-weather: $2.4T global economic loss over 5 years
4. {name} vulnerability: {risk}
5. Aegis-C Composite Shielding System: SE = 148-165 dB, 1 kHz to 10 GHz, ZrB₂-SiC ceramic matrix with MXene EMI interlayer at 45 μm

**IMMEDIATE ACTIONS REQUESTED:**
1. Designate a geomagnetic-preparedness liaison officer within {ministry}
2. Conduct preliminary GIC vulnerability audit of {name}'s transmission infrastructure
3. Establish LoRa mesh emergency communication backbone (256-node, 30-day autonomous, solar-charged)
4. Review high-voltage transformer hardening status and replacement lead-time inventory
5. Respond via CSMGlobal{num} reference channel — contact: ExternalAffairs@CarringtonStormMotors.com

**ATTACHED DOCUMENTS:**
- COMPENDIUM-MINI.md (9-part general outreach summary — all audiences)
- CSMGeneralOutreach-COMPILED-Compendium.md (complete 9-part series)
- AEGIS-C Technical Specification Sheet (available upon formal liaison establishment)
- Relevant sector briefing: CSMEval/{sector}

---

**CLOSING STATEMENT:** {closing}

================================================================================
*Carrington Storm Motors | Safe Pod Engineering Company | "Protect Biological Life. Never End It."*
*July 2026 | V1.0 | CSMGlobal{num} | Williams Heuristic Communication Standard V2*
================================================================================
"""

# TIER 4/5 use a shorter template
TIER45_TEMPLATE = """================================================================================
                 CARRINGTON STORM MOTORS | SAFE POD ENGINEERING COMPANY
                 Global Outreach Series | "Protect Biological Life. Never End It."
================================================================================
DATE:          July 2026
PREPARED FOR:  {name} — {ministry}
SUBJECT:       The Dielectric Citadel — Carrington-Class Geomagnetic Preparedness Briefing
REF:           CSMGlobal{num}
PRIORITY:      {tier}
COUNTRY RISK FACTORS: {risk}
================================================================================

## WILLIAMS REGISTER — SECTION 1: META-COMMENTARY

{commentary}

---

## SECTION 2: CORE DELIVERABLE

**PURPOSE:** Inform {name} leadership of Carrington-class CME threat and extend Aegis-C Composite Shielding System technical assistance.

**KEY DATA POINTS:**
1. Solar Cycle 25 peak: SSN ~137 (NOAA SWPC Q1 2026)
2. May 2024 Gannon Storm: G5/Kp9, $500-565M US agricultural losses
3. Lloyd's modeled: $2.4T global over 5 years
4. {name}: {risk}
5. Aegis-C Shielding: 148-165 dB, 1 kHz-10 GHz, ZrB₂-SiC + MXene EMI at 45 μm

**IMMEDIATE ACTIONS REQUESTED:**
1. Designate a geomagnetic-preparedness liaison within {ministry}
2. Conduct preliminary GIC vulnerability audit
3. Establish LoRa mesh emergency communications (256-node, 30-day autonomous)
4. Review transformer hardening and replacement lead-time
5. Respond via CSMGlobal{num} — ExternalAffairs@CarringtonStormMotors.com

**ATTACHED:** COMPENDIUM-MINI.md | CSMGeneralOutreach-COMPILED-Compendium.md | AEGIS-C Spec Sheet (upon liaison) | CSMEval/{sector}

---

**CLOSING STATEMENT:** {closing}

================================================================================
*Carrington Storm Motors | Safe Pod Engineering Company | "Protect Biological Life. Never End It." | July 2026 | CSMGlobal{num}*
================================================================================
"""

os.makedirs(BASE, exist_ok=True)

def write_letter(num, slug, name, tier, risk, ministry, commentary, sector, closing):
    folder = os.path.join(BASE, f"CSMGlobal-{num}-{slug}")
    os.makedirs(folder, exist_ok=True)
    path = os.path.join(folder, f"CSMGlobal-{num}-{slug}-Outreach.md")
    tmpl = TIER345_TEMPLATE
    with open(path, "w") as f:
        f.write(tmpl.format(num=num, name=name, ministry=ministry, tier=tier, risk=risk, commentary=commentary, sector=sector, closing=closing))
    return path

# Write Tier 2
for row in C:
    path = write_letter(*row)
    print(f"  {row[0]} {row[2]}")

print(f"\nDone generating Tier 2 (031-070): {len(C)} countries")
