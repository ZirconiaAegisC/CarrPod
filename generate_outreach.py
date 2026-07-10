#!/usr/bin/env python3
"""Generate 200 country outreach directories under CSMGeneralOutreach-Global/"""
import os

BASE = "/workspace/bb8f9c5f-e866-4346-a29c-8d72daa0ad2d/sessions/agent_7f75d87e-7fa5-4dcf-88b2-42c5585e758b/CarrPod/CSMGeneralOutreach-Global"

COUNTRIES = [
    # TIER 1 - CRITICAL (001-030)
    ("001", "United-States", "United States", "CRITICAL — TIER 1",
     "Longest interconnected HV grid globally (~200K mi); massive steel bridge/rail infrastructure; transformer dependency critical",
     "Department of Homeland Security — Cybersecurity and Infrastructure Security Agency (CISA)",
     "330 million people on one of the most electrically interconnected grids ever built. Three major interconnections — Eastern, Western, Texas — each a continental-scale conductor during a geomagnetic storm. The May 2024 Gannon Storm already cost you half a billion dollars in agricultural GPS disruption alone. That was a practice round. You have the National Space Weather Strategy. You have NOAA SWPC. What you still need is the physical shielding layer on top of the monitoring. We built it. The transformer replacement lead time in this country is still twelve months. There is exactly one window to close that gap, and it is closing now.",
     "01-Federal-State-Emergency-Management-Agencies",
     "You already have the warning system. Now you need the shield to match it."),

    ("002", "China", "China", "CRITICAL — TIER 1",
     "World's largest power grid by capacity; UHV AC/DC transmission lines spanning thousands of km; 90% global rare-earth magnet production at risk",
     "National Energy Administration — State Grid Corporation of China",
     "Two billion people and the largest integrated power system on the planet. Your Ultra-High-Voltage transmission corridors — stretching from Xinjiang to Shanghai — are among the longest unbroken conductors anywhere, which is precisely the geometry a geomagnetic storm exploits. You produce ninety percent of the world's rare-earth permanent magnets. A Carrington-class event doesn't just threaten your grid; it threatens the global magnet supply chain that every electric motor and wind turbine depends on. We have a dielectric alternative made from iron-nitride chemistry. We would like to discuss a materials partnership before the storm makes the discussion academic.",
     "02-Electric-Grid-Reliability-Regulators-and-Agencies",
     "The factory that builds the world's magnets should not be the one most vulnerable to the storm that destroys them."),

    ("003", "Russia", "Russia", "CRITICAL — TIER 1",
     "Vast east-west HV lines at high latitude (extreme GIC); oil/gas pipeline network is world's largest metallic corridor; rail electrification extensive",
     "Ministry of Energy of the Russian Federation",
     "You occupy the highest geomagnetic latitudes of any major industrialized nation — the same latitudes where the 1859 Carrington aurora was visible in the tropics. Your Unified Energy System stretches from Kaliningrad to Vladivostok, nine time zones of continuous conductor. Your oil and gas pipeline network — the largest metallic corridor on Earth — presents a storm-current path that no existing monitoring system fully models. The Rossian Far East transformer stations are among the most remote and difficult-to-replace anywhere. This is not hypothetical. We mapped it. We have the composite transmission tower design. We would like to share it.",
     "02-Electric-Grid-Reliability-Regulators-and-Agencies",
     "Geography gave you the longest wire. Engineering can give you the best shield."),

    ("004", "India", "India", "CRITICAL — TIER 1",
     "Third-largest power grid; massive rural-urban transmission expansion; 1.4B population; transformer supply chain concentrated in few manufacturing zones",
     "Ministry of Power — Central Electricity Authority",
     "One-point-four billion people. One national grid that has undergone the fastest expansion of any major economy in the last decade — which means brand-new transmission corridors with minimal geomagnetic hardening history. Your transformer manufacturing capacity is concentrated in a handful of industrial zones in Gujarat and Maharashtra. A single directed storm event hitting the right latitude could cascade across the entire subcontinental grid in minutes. We have a low-cost passive field monitor that can give your rural substations the same early warning your urban ones already have. We built it for exactly this scale: massive, distributed, and too important to guess about.",
     "02-Electric-Grid-Reliability-Regulators-and-Agencies",
     "The fastest-growing grid on Earth deserves the fastest-growing shield."),

    ("005", "Japan", "Japan", "CRITICAL — TIER 1",
     "Island grid highly interconnected; seismic-hardened but not GIC-hardened; dense urban concentration (Tokyo metro ~37M); bullet train signaling at risk",
     "Ministry of Economy, Trade and Industry (METI) — Agency for Natural Resources and Energy",
     "Your grid survived Fukushima. It is arguably the most seismically resilient electrical system on the planet. But geomagnetic induced current doesn't care about earthquake dampers — it cares about the length and orientation of your conductors, and Japan's north-south island geometry aligns perfectly with the east-west geomagnetic field variation that produces the strongest induced voltages. Your Shinkansen signaling network, your Tokyo Metro power distribution, your maritime port electrification — all of it runs on copper paths that have never been stress-tested against a G5 event at Kp9. We have the composite shielding retrofit. We have the non-conductive structural materials. Your engineers would understand our datasheets on first reading.",
     "02-Electric-Grid-Reliability-Regulators-and-Agencies",
     "You already build for the ground shaking. Let us help you build for the sky."),

    ("006", "Germany", "Germany", "CRITICAL — TIER 1",
     "Europe's largest industrial power consumer; Energiewende grid with massive north-south HVDC corridors; dense rail electrification; automotive supply chain at risk",
     "Bundesministerium für Wirtschaft und Klimaschutz (BMWK)",
     "Eighty-three million people, Europe's industrial engine, and a grid undergoing the most ambitious energy transition on the continent. Your new north-south HVDC corridors — SuedLink, SuedOstLink — are precisely the long, high-amperage, buried-conductor geometry that couples most efficiently to geomagnetic storm currents. Your automotive supply chain — BMW, Mercedes, VW, and every Tier 1 supplier feeding them — runs on just-in-time logistics that assume continuous grid power. The gap between those assumptions and a Carrington-class event is the gap this entire research corpus was built to close. We have MXene-based EMI shielding rated at 90+ dB. We would like to discuss pilot deployment on a Bavarian substation.",
     "02-Electric-Grid-Reliability-Regulators-and-Agencies",
     "The Energiewende is brilliant. It deserves a dielectric layer as advanced as its inverters."),

    ("007", "Brazil", "Brazil", "CRITICAL — TIER 1",
     "Largest grid in Latin America; Itaipu HVDC link (~800km); Amazon-Manaus isolated grid; equatorial/low-latitude GIC still significant during superstorms",
     "Ministério de Minas e Energia — Operador Nacional do Sistema Elétrico (ONS)",
     "Your Itaipu transmission system — 800 kilometers of HVDC connecting the world's second-largest hydroelectric plant to São Paulo — is a textbook geomagnetic coupling antenna. At lower latitudes you get less frequent GIC events, but the ones you get during a genuine Carrington-class superstorm are no less intense. Your northern isolated systems — Manaus, Macapá — depend on thermal backup that assumes functional fuel logistics. In a continent-wide grid disruption, those assumptions break. We mapped this. We have a non-conductive transmission tower design that removes the structure itself as a GIC path. We built it with exactly your kind of continental-scale architecture in mind.",
     "02-Electric-Grid-Reliability-Regulators-and-Agencies",
     "Equatorial does not mean immune. It means less practiced — which is exactly why preparation matters more."),

    ("008", "Canada", "Canada", "CRITICAL — TIER 1",
     "Highest GIC exposure globally (auroral zone); Hydro-Québec 1989 blackout precedent; long east-west lines; oil sands electrification; Arctic communities on diesel",
     "Natural Resources Canada — Canadian Space Weather Forecast Centre",
     "March 13, 1989. Hydro-Québec. Ninety seconds from normal operation to complete blackout. Six million people. Nine hours of darkness. That was a Kp9 event smaller than the May 2024 Gannon Storm. You already know what geomagnetic induced current does to your grid — you wrote the case study the rest of the world learned from. Your auroral zone exposure is the highest of any industrialized nation on Earth. Your Arctic communities depend on diesel generators with resupply chains measured in weeks, not hours. We have ceramic-based water heaters that work without the grid. We have LoRa mesh communications that self-organize for thirty days. This is not theoretical for Canada. This is a replay of something that already happened, waiting for a bigger storm.",
     "02-Electric-Grid-Reliability-Regulators-and-Agencies",
     "You taught the world what GIC looks like. Let us help you finish the lesson with the shield it deserves."),

    ("009", "South-Korea", "South Korea", "CRITICAL — TIER 1",
     "Dense urban grid (Seoul metro ~25M); semiconductor fabrication clusters (Samsung/SK Hynix) require ultra-stable power; peninsula isolation limits grid imports",
     "Ministry of Trade, Industry and Energy (MOTIE)",
     "Your semiconductor fabrication facilities — the most advanced chip manufacturing cluster on the planet — require power stability measured in microseconds. A single voltage fluctuation during a G5-class event can scrap millions of dollars of wafers in process, and recovery time for a cleanroom power event is measured in days, not hours. You cannot import grid stability from China or Japan during a simultaneous regional event — the Korean peninsula's electrical isolation becomes a liability the moment the storm current hits. We have MXene-based EMI shielding rated at 90+ dB that can be applied to existing fab facility enclosures. We have solid-state GaN microwave technology that eliminates magnetron vulnerability. Your engineers would recognize the specifications immediately.",
     "02-Electric-Grid-Reliability-Regulators-and-Agencies",
     "The chips that run the world should not be the first thing the storm takes offline."),

    ("010", "France", "France", "CRITICAL — TIER 1",
     "Nuclear-dominant grid (~70%); dense rail electrification (TGV network); cross-channel interconnectors to UK; transformer manufacturing concentrated",
     "Ministère de la Transition Énergétique — RTE (Réseau de Transport d'Électricité)",
     "Seventy percent of your electricity comes from nuclear reactors — a fleet that depends on offsite power for cooling even when shut down. Your cross-channel interconnectors to the UK and your interconnections with Belgium, Germany, Italy, Spain, and Switzerland form a mesh that, during a Carrington event, couples induced currents across the entire Western European grid simultaneously. Your TGV network — 2,800 kilometers of electrified high-speed rail — is a continuous conductor at precisely the scale a storm loves. We have composite substation fencing. We have dielectric geopolymer concrete for nuclear facility hardening. We built the materials around the architecture you already have. We would like to present them to RTE's grid security division.",
     "02-Electric-Grid-Reliability-Regulators-and-Agencies",
     "Nuclear safety has a dielectric dimension. Let us show you the materials that close it."),

    ("011", "United-Kingdom", "United Kingdom", "CRITICAL — TIER 1",
     "Island grid with extensive subsea interconnectors; London Underground electrification; offshore wind farm GIC coupling; financial sector power dependency",
     "Department for Energy Security and Net Zero — National Grid ESO",
     "Your subsea interconnectors — to France, Netherlands, Belgium, Norway, Denmark — are undersea conductors coupling to both the ocean and the atmosphere during a geomagnetic event. Your London financial sector processes trillions in transactions daily on power assumptions that have never been stress-tested against a simultaneous grid-and-satellite disruption. Your offshore wind farms — the largest in Europe — present a distributed conductor geometry with partial undersea cabling that GIC models only recently began accounting for. We have the passive field monitor. We have the composite structural materials. We have the MXene coating that can be applied to existing substation enclosures. All of it built for exactly this kind of interconnected island-grid architecture.",
     "02-Electric-Grid-Reliability-Regulators-and-Agencies",
     "An island grid does not mean isolation. It means each interconnector is a doorway the storm knows how to use."),

    ("012", "Italy", "Italy", "CRITICAL — TIER 1",
     "North-south HV backbone along Apennines; seismic + GIC compound risk; dense rail network; transformer aging fleet concerns",
     "Ministero dell'Ambiente e della Sicurezza Energetica — Terna S.p.A.",
     "Your north-south transmission backbone follows the spine of the Apennines — nearly 1,200 kilometers of continuous high-voltage conductor oriented precisely in the direction that maximizes geomagnetic induced voltage. You have one of the oldest average transformer fleet ages in Western Europe. You also have a seismic risk profile that compels rapid grid restoration after earthquakes — but a simultaneous seismic-plus-GIC compound event is a scenario your emergency planners deserve to have modeled. We have the non-conductive transmission tower design. We have the chemically-bonded phosphate ceramic water heater that works without grid power. We built these for countries where the ground and the sky can fail simultaneously.",
     "02-Electric-Grid-Reliability-Regulators-and-Agencies",
     "A country that already prepares for the ground to shake should only need one more data set to prepare for the sky."),

    ("013", "Mexico", "Mexico", "CRITICAL — TIER 1",
     "Integrated with US grid (Texas interconnection); manufacturing corridor from Monterrey to Mexico City; oil refinery concentration; seismic + GIC compound risk",
     "Secretaría de Energía (SENER) — Comisión Federal de Electricidad (CFE)",
     "Your grid interconnects with the United States at multiple points along the Texas border — the same interconnection where the May 2024 Gannon Storm induced measurable transformer stress. Your manufacturing corridor from Monterrey to Mexico City runs on assembly lines that assume continuous production power. Your oil refinery concentration in the Gulf region depends on pipeline electrification that shares the same long-conductor vulnerability as transmission lines. We have the composite non-metallic transmission structure design. We have the low-cost passive field monitor that can give your substations early warning. We built these tools for exactly the kind of integrated North American grid architecture your economy depends on.",
     "02-Electric-Grid-Reliability-Regulators-and-Agencies",
     "Your grid already talks to the United States'. Make sure it also talks to the early warning systems."),

    ("014", "Turkey", "Turkey", "CRITICAL — TIER 1",
     "Eurasian energy corridor; major Bosphorus crossing infrastructure; rapidly expanding industrial base; seismic + GIC compound risk",
     "T.C. Enerji ve Tabii Kaynaklar Bakanlığı — Türkiye Elektrik İletim A.Ş. (TEİAŞ)",
     "You sit at the junction of two continents and you run one of the fastest-growing electricity demand curves in the OECD. Your Bosphorus crossings — both the bridges and the undersea cable corridors — concentrate infrastructure at a single geographic pinch point that a geomagnetic event can target with surgical precision. Your industrial expansion along the Anatolian corridor has added thousands of kilometers of new transmission in the last decade, almost none of which has been modeled for GIC vulnerability. We have the bridge audit methodology — already applied to four major metro areas. We have the dielectric substation fencing. We built this for countries where east meets west and the grid carries both directions of current.",
     "02-Electric-Grid-Reliability-Regulators-and-Agencies",
     "The crossroads of continents should not be the crossroads of electrical failure."),

    ("015", "Spain", "Spain", "CRITICAL — TIER 1",
     "Iberian peninsula semi-isolated grid; limited interconnections through France; high solar/wind penetration; converter-based generation GIC uncertainty",
     "Ministerio para la Transición Ecológica — Red Eléctrica de España",
     "Your Iberian peninsula grid is more electrically isolated than most European systems — which sounds protective but actually means fewer paths for induced currents to dissipate harmlessly. Your high penetration of solar and wind — among the highest in Europe — introduces converter-interfaced generation whose GIC response is less understood than conventional synchronous machines. Your limited interconnections through France are a bottleneck under normal conditions; under storm conditions, they become a single-point vulnerability. We have the solid-state GaN power electronics research. We have the MXene coating for existing substation enclosures. We would like to work with Red Eléctrica on a peninsula-specific GIC vulnerability assessment.",
     "02-Electric-Grid-Reliability-Regulators-and-Agencies",
     "Electrical isolation during normal operation becomes electrical vulnerability during a storm. Let us close that gap."),

    ("016", "Australia", "Australia", "CRITICAL — TIER 1",
     "Long-distance transmission (National Electricity Market ~5,000km); isolated mining-grid systems; southern states at higher GIC latitude; bushfire + grid compound risk",
     "Department of Climate Change, Energy, the Environment and Water — Australian Energy Market Operator (AEMO)",
     "Your National Electricity Market spans five thousand kilometers of transmission — the longest interconnected system in the Southern Hemisphere. Your southern states — Victoria, Tasmania, South Australia — sit at the highest geomagnetic latitudes in the country, directly exposed to the same auroral electrojet that drives GIC events in Canada and Scandinavia. Your isolated mining-grid systems in Western Australia and Queensland depend on diesel backup with logistics chains that a continent-wide storm disruption would sever. We have the non-conductive building materials suite. We have the LoRa mesh emergency communications. We built these for exactly the kind of long, distributed, latitude-exposed grid architecture your continent presents.",
     "02-Electric-Grid-Reliability-Regulators-and-Agencies",
     "The longest grid in the Southern Hemisphere deserves the strongest shield in either hemisphere."),

    ("017", "Poland", "Poland", "CRITICAL — TIER 1",
     "Central European grid hub; coal-dominant with rapid renewables transition; Baltic interconnectors; NATO eastern flank energy security concerns",
     "Ministerstwo Klimatu i Środowiska — Polskie Sieci Elektroenergetyczne (PSE)",
     "Your position as the Central European grid hub — interconnected with Germany, Czech Republic, Slovakia, Ukraine, Belarus, Lithuania, and Sweden via the SwePol Link — means a GIC event anywhere in Central Europe propagates through your transmission system. Your Baltic interconnectors traverse an undersea corridor at the same latitude where the 2003 Halloween Storm blacked out Malmö. Your ongoing coal-to-renewables transition is adding inverter-based generation whose GIC behavior is still being characterized. We have the composite transmission tower. We have the passive field monitor. We built these for countries that sit at the center of a continent's electrical nervous system.",
     "02-Electric-Grid-Reliability-Regulators-and-Agencies",
     "A grid at the center of Europe carries both power and responsibility. We have the shield for both."),

    ("018", "Iran", "Iran", "CRITICAL — TIER 1",
     "Large interconnected national grid; oil/gas infrastructure electrification; mountainous transmission corridors; transformer import dependency",
     "Ministry of Energy — Tavanir",
     "Your national grid spans 1.6 million square kilometers across mountainous terrain that makes transformer replacement logistics extraordinarily difficult. Your oil and gas infrastructure electrification — compressor stations, pumping stations, refinery power — puts critical energy infrastructure on the same conductor paths as civilian load. Your transformer import dependency means replacement lead times are measured in months under normal conditions, and in years under a global supply-chain disruption caused by a Carrington event. We have the dielectric geopolymer concrete. We have the basalt-fiber-reinforced-polymer rebar alternative to steel. We built these materials for countries whose geography makes logistics the hardest variable in the equation.",
     "02-Electric-Grid-Reliability-Regulators-and-Agencies",
     "Mountains protect your borders. They don't protect your transformers from induced current."),

    ("019", "Indonesia", "Indonesia", "CRITICAL — TIER 1",
     "Largest archipelagic grid (17,000+ islands); submarine cable network extensive; equatorial + maritime GIC; 275M population; Jakarta sinking + grid stress",
     "Kementerian Energi dan Sumber Daya Mineral — PT PLN (Persero)",
     "Seventeen thousand islands. Two hundred seventy-five million people. Submarine power cables connecting Java, Sumatra, Kalimantan, Sulawesi — an undersea conductor network whose GIC coupling to equatorial electrojet currents is genuinely understudied relative to the population it serves. Your Jakarta metropolitan area — thirty million people — faces compound risks from land subsidence, seismic activity, and now, the same satellite-and-grid disruption that the May 2024 storm demonstrated. We have the non-conductive building materials. We have the solid-state GaN microwave technology for medical and kitchen applications. We built these for archipelagic nations where every submarine cable is a promise the storm can test.",
     "02-Electric-Grid-Reliability-Regulators-and-Agencies",
     "An archipelago is only as strong as its longest undersea cable. Let us make sure yours keeps the lights on."),

    ("020", "Netherlands", "Netherlands", "CRITICAL — TIER 1",
     "Dense coastal grid; offshore wind GIC exposure; below-sea-level pumping station electrification; Rotterdam port electrification; data center concentration",
     "Ministerie van Economische Zaken en Klimaat — TenneT",
     "Your country sits below sea level and depends on electric pumping stations to stay dry. Your offshore wind farm network — among the densest in Europe — presents a distributed undersea conductor geometry directly exposed to North Sea geomagnetic coupling. Your Rotterdam port — Europe's largest — runs on an electrified logistics chain that has never been stress-tested against a simultaneous grid-and-satellite failure. Your data center concentration in the Amsterdam metropolitan area processes a significant fraction of European cloud traffic on power assumptions we know are vulnerable. We have the MXene EMI coating for existing facilities. We have the LoRa mesh for emergency water-management communications. We built this for exactly your profile: dense, coastal, electrified, and irreplaceable.",
     "02-Electric-Grid-Reliability-Regulators-and-Agencies",
     "A country that already fights the sea should have the best shield against the sky."),

    ("021", "Saudi-Arabia", "Saudi Arabia", "CRITICAL — TIER 1",
     "Oil infrastructure electrification critical; desalination plant power dependency; NEOM/giga-project grid expansion; extreme temperature cooling load",
     "Ministry of Energy — Saudi Electricity Company",
     "Your desalination plants produce seventy percent of your drinking water and depend on continuous grid power to run reverse-osmosis pumps — there is no backup water supply at national scale. Your oil infrastructure electrification — Aramco's entire production chain — runs on a grid whose GIC vulnerability has never been publicly modeled against a Carrington-class event. Your NEOM and giga-project expansions are adding thousands of kilometers of new transmission at a pace that makes concurrent hardening the most cost-effective moment to act. We have the electrocaloric cooling technology — Stellar-Chill — that doesn't depend on a compressor cycle. We have the dielectric geopolymer concrete. We built these for countries where water and power are the same equation.",
     "02-Electric-Grid-Reliability-Regulators-and-Agencies",
     "When the grid fails in the desert, the water fails next. We built the materials that keep both running."),

    ("022", "Argentina", "Argentina", "CRITICAL — TIER 1",
     "Southern latitude GIC exposure; long north-south transmission corridors; Yacyretá and Salto Grande HV links; mining grid electrification in Andes",
     "Secretaría de Energía — CAMMESA",
     "Your southern region — Patagonia, Tierra del Fuego — sits at geomagnetic latitudes comparable to southern Canada, directly exposed to the Southern Hemisphere auroral electrojet. Your north-south transmission corridors stretch over 3,000 kilometers — one of the longest unbroken conductor paths in South America. Your hydroelectric links at Yacyretá and Salto Grande are long-distance HV connections of precisely the geometry that couples most efficiently to storm currents. We have the non-metallic composite transmission structures. We have the basalt-fiber rebar. We have the passive field monitor. We built these for countries where the grid has to travel farther than most people commute in a year.",
     "02-Electric-Grid-Reliability-Regulators-and-Agencies",
     "Your grid crosses the distance most countries span end-to-end. It deserves protection scaled to match."),

    ("023", "Sweden", "Sweden", "CRITICAL — TIER 1",
     "High-latitude GIC extreme exposure; 2003 Halloween Storm blackout precedent (Malmö); extensive north-south hydro transmission; iron ore mining rail electrification",
     "Klimat- och näringslivsdepartementet — Svenska kraftnät",
     "October 30, 2003. Malmö goes dark. The Halloween Storm — a G5 event — blacked out a major Swedish city for an hour. Not because the grid was weak, but because it was working exactly as designed — it just wasn't designed for the current the storm induced in it. Your north-south hydro transmission corridors from the Arctic Circle to southern population centers are thousands of kilometers of continuous high-voltage conductor at the highest geomagnetic latitudes in Europe. Your iron ore mining rail electrification — the Malmbanan line — carries the same long-conductor geometry as your transmission system. We have the non-conductive composite structures. We have the MXene EMI shielding. We have the Schumann Resonance early-warning network concept that could give you four to six hours instead of your current warning window. You already know what a storm can do to your grid. Let us help you make sure the next one finds a different answer.",
     "02-Electric-Grid-Reliability-Regulators-and-Agencies",
     "You already experienced the warning shot. Let us make sure the next round finds a shield."),

    ("024", "Norway", "Norway", "CRITICAL — TIER 1",
     "Extreme high-latitude GIC exposure; subsea power cables to continental Europe; offshore oil platform electrification; fjord-spanning transmission corridors",
     "Olje- og energidepartementet — Statnett SF",
     "Your grid is the most electrified per capita in Europe, and your latitude exposes it to the strongest geomagnetic induced currents on the continent. Your subsea power cables — NorNed to the Netherlands, NordLink to Germany, North Sea Link to the UK — are hundreds of kilometers of undersea conductor coupling directly to both ocean and atmospheric storm currents. Your offshore oil platform electrification from shore adds another layer of undersea conductor exposure that conventional GIC models have only recently begun to incorporate. We have the composite non-conductive transmission towers. We have the dielectric substation fencing. We built these materials for countries whose geography — fjords, mountains, undersea corridors — makes every installation a one-of-a-kind engineering project, and every replacement an even harder one.",
     "02-Electric-Grid-Reliability-Regulators-and-Agencies",
     "A grid powered by water and exposed to the aurora deserves a shield as resilient as both."),

    ("025", "Belgium", "Belgium", "CRITICAL — TIER 1",
     "Dense European grid hub; nuclear power (Doel/Tihange) offsite power dependency; Brussels EU institutions/NATO HQ; chemical corridor electrification",
     "Service public fédéral Économie — Elia",
     "Your position as the European grid hub — interconnecting France, Netherlands, Germany, Luxembourg, and the UK via Nemo Link — makes your transmission system the electrical crossroads of Western Europe. Your nuclear plants at Doel and Tihange depend on offsite power for cooling. Your Brussels institutional density — EU headquarters, NATO HQ — means a grid disruption here has diplomatic consequences measured in continents, not neighborhoods. Your Antwerp chemical corridor runs processes that cannot be safely interrupted without sequenced shutdown procedures requiring hours of stable power. We have the passive field monitor. We have the MXene EMI coating. We have the non-conductive building materials suite. We built these for countries whose size belies their electrical centrality.",
     "02-Electric-Grid-Reliability-Regulators-and-Agencies",
     "Small country. Enormous electrical footprint. The math on hardening is the most favorable on the continent."),

    ("026", "Thailand", "Thailand", "CRITICAL — TIER 1",
     "Rapidly industrializing grid; Bangkok metro ~15M in flood-prone delta; manufacturing supply chain concentration; tourism infrastructure electrification",
     "Ministry of Energy — Electricity Generating Authority of Thailand (EGAT)",
     "Your Bangkok metropolitan area — fifteen million people in a flood-prone delta — presents a compound risk profile where grid failure, satellite disruption, and water management crisis can cascade simultaneously during a geomagnetic event. Your manufacturing supply chain concentration — automotive, electronics, food processing — depends on just-in-time logistics that assume continuous power and functional GPS. Your tourism infrastructure electrification — hotels, airports, transit — supports an industry that represents roughly twenty percent of your GDP. We have the electrocaloric cooling technology that works without compressors. We have the solid-state GaN microwave for food service continuity. We built these for countries where the economy and the grid are the same emergency.",
     "02-Electric-Grid-Reliability-Regulators-and-Agencies",
     "A delta city of fifteen million deserves a backup plan for the day the sky decides to speak."),

    ("027", "Austria", "Austria", "CRITICAL — TIER 1",
     "Alpine transmission corridors; significant pumped-hydro storage (grid stabilization role); Central European interconnector hub; winter tourism electrification",
     "Bundesministerium für Klimaschutz, Umwelt, Energie — Austrian Power Grid (APG)",
     "Your Alpine transmission corridors carry some of the most physically difficult-to-replace infrastructure in Europe — transformers and switchgear installed at altitudes where winter access alone is a logistical challenge. Your pumped-hydro storage facilities — Malta, Reißeck — are critical to European grid stability, and a Carrington event that disables them would propagate frequency instability across the entire ENTSO-E interconnection. Your winter tourism electrification — ski lifts, snowmaking, hotel heating — represents a concentrated seasonal load that, if lost during peak season, converts an infrastructure problem into an evacuation problem. We have the composite transmission tower design. We have the dielectric substation fencing. We built these for countries where every installation site is a mountain and every replacement window is measured in seasons.",
     "02-Electric-Grid-Reliability-Regulators-and-Agencies",
     "Transformers at altitude are not replaced in a day. Let us make sure they don't have to be."),

    ("028", "Switzerland", "Switzerland", "CRITICAL — TIER 1",
     "European grid hub (9 interconnectors); pumped-hydro storage concentration; banking/financial sector power dependency; Alpine GIC coupling understudied",
     "Eidgenössisches Departement für Umwelt, Verkehr, Energie und Kommunikation — Swissgrid",
     "Nine international interconnectors. The densest pumped-hydro storage concentration in Europe. A financial sector whose transaction integrity depends on microsecond-level timing from GPS satellites that a geomagnetic storm disables. Your Gotthard Base Tunnel — the world's longest railway tunnel — runs electrified rail through the Alps on power systems whose GIC coupling through mountain geology is a genuinely understudied phenomenon. We have the MXene EMI shielding for data center facilities. We have the basalt-fiber-reinforced-polymer rebar for tunnel infrastructure. We built these materials for the intersection of finance, mountains, and electricity — which is, uniquely, exactly where you live.",
     "02-Electric-Grid-Reliability-Regulators-and-Agencies",
     "The world's money sleeps in Swiss servers. Make sure the storm doesn't wake it up."),

    ("029", "Taiwan", "Taiwan", "CRITICAL — TIER 1",
     "Island grid isolation; semiconductor foundry concentration (TSMC ~90% advanced chips); seismic + GIC compound risk; limited interconnector options",
     "Ministry of Economic Affairs — Taiwan Power Company (Taipower)",
     "Your semiconductor foundries — TSMC alone produces roughly ninety percent of the world's most advanced chips — require power stability at a level most national grids never need to guarantee. You are an electrically isolated island with no interconnector redundancy. A Carrington-class event that destabilizes your grid is not just a Taiwanese problem; it is a global semiconductor supply chain event measured in quarters of lost production. The May 2024 Gannon Storm demonstrated GPS disruption at scale. Your foundries' process control depends on precisely the same GNSS timing. We have MXene-based EMI shielding rated at 90+ dB for cleanroom enclosures. We have the solid-state GaN power electronics research. We built these specifically for fabrication facilities whose power requirements make them the most demanding grid customers on Earth.",
     "02-Electric-Grid-Reliability-Regulators-and-Agencies",
     "The world's most advanced factories deserve the world's most advanced electrical shield."),

    ("030", "South-Africa", "South Africa", "CRITICAL — TIER 1",
     "Coal-dominant aging grid; load-shedding operational precedent; southern latitude GIC; mining industry electrification; Cape Town- Gauteng long transmission corridor",
     "Department of Mineral Resources and Energy — Eskom",
     "Your grid has already demonstrated, through years of load-shedding, exactly what cascading failure looks like under normal operating conditions. Now add a geomagnetic induced current superimposed on an already-stressed transmission system. Your Cape Town to Gauteng transmission corridor — over 1,400 kilometers across the Karoo — is a long, continuous conductor at southern latitudes that couple to the Southern Hemisphere auroral electrojet. Your mining industry electrification — platinum, gold, manganese — represents an economic concentration that a prolonged grid failure would convert directly into a national balance-of-payments crisis. We have the composite non-metallic transmission structures. We have the dielectric geopolymer concrete. We have the LoRa mesh emergency communications. We built these for countries that already know what grid fragility costs, and need the materials to make the next chapter different.",
     "02-Electric-Grid-Reliability-Regulators-and-Agencies",
     "You already know what the lights going out costs. Let us show you what keeping them on is worth."),
]

os.makedirs(BASE, exist_ok=True)

def write_letter(num, slug, name, tier, risk, ministry, commentary, sector, closing):
    folder = os.path.join(BASE, f"CSMGlobal-{num}-{slug}")
    os.makedirs(folder, exist_ok=True)
    filepath = os.path.join(folder, f"CSMGlobal-{num}-{slug}-Outreach.md")

    content = f"""================================================================================
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
    with open(filepath, "w") as f:
        f.write(content)
    return filepath

for num, slug, name, tier, risk, ministry, commentary, sector, closing in COUNTRIES:
    path = write_letter(num, slug, name, tier, risk, ministry, commentary, sector, closing)
    print(f"  Created: {path}")

print(f"\nDone generating {len(COUNTRIES)} country outreach files.")
