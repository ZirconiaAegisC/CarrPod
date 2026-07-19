================================================================================
119TH CONGRESS — 2ND SESSION                                             H.R. _____
================================================================================

           TITLE V — DIGITAL TWIN AND STRUCTURAL MONITORING

================================================================================

SECTION 501. BRIDGE INFORMATION MODELING MANDATE.

    (a) BRIM REQUIREMENT. — Effective for all Federal-aid highway
    bridge projects with a total estimated cost exceeding
    $20,000,000 and advertised for bid on or after October 1, 2028,
    the project owner shall develop and deliver a Bridge Information
    Model (BrIM) conforming to the requirements of this section.

    (b) BRIM MINIMUM ELEMENTS. — Each BrIM shall include:

        (1) A three-dimensional geometric model of all structural
        elements, including foundations, substructure units,
        superstructure components, bearings, expansion joints,
        deck, barriers, and appurtenances, with dimensional
        accuracy sufficient for construction and future
        rehabilitation;

        (2) Material properties, including concrete compressive
        strength, reinforcing steel grade and configuration,
        structural steel grade, coating system specifications,
        and prestressing steel properties;

        (3) Construction sequencing, including pour sequences,
        erection stages, and temporary works;

        (4) Design calculations, load ratings, and design
        assumptions, linked to the relevant model elements;

        (5) As-built documentation of all deviations from design
        drawings or specifications;

        (6) A complete coating system schedule identifying the
        system applied to each steel element, application date,
        applicator, dry film thickness measurements, and adhesion
        test results;

        (7) Locations and specifications of all installed sensors,
        including type, manufacturer, model, installation date,
        calibration data, and baseline readings; and

        (8) A maintenance manual specific to the bridge, generated
        from the BrIM, identifying inspection frequencies, access
        requirements, and maintenance procedures for each
        structural element and protective system.

    (c) DATA FORMAT STANDARDIZATION. — Within 18 months of enactment,
    the Secretary, in consultation with AASHTO, the National
    Institute of Building Sciences, and the buildingSMART
    International organization, shall publish a National Bridge
    Information Modeling Standard establishing:

        (1) Required data schemas and exchange formats (Industry
        Foundation Classes — IFC-Bridge or successor);

        (2) Level of Development (LOD) requirements at each
        project phase (planning, design, construction, as-built);

        (3) Naming conventions and classification systems for
        bridge elements and properties; and

        (4) Quality assurance and validation procedures for
        BrIM deliverables.

    (d) RETROSPECTIVE BRIM. — For existing bridges not subject
    to subsection (a) that are classified as NIPR-C or below, the
    State department of transportation shall, within 5 years of
    enactment, develop a Level of Development 300 (LOD 300) BrIM
    based on available design documents, inspection records, and
    field verification measurements.

SECTION 502. STRUCTURAL HEALTH MONITORING SENSOR DEPLOYMENT.

    (a) MANDATORY MONITORING. — Structural health monitoring (SHM)
    sensors shall be installed on the following bridges:

        (1) All bridges classified as NIPR-D or NIPR-F, within
        3 years of such classification and within 2 years of
        enactment for bridges already so classified;

        (2) All bridges in Seismic Design Categories D, E, or F
        with an NIPR score below 60, within 5 years of enactment;

        (3) All bridges with a main span exceeding 500 feet,
        within 5 years of enactment; and

        (4) All new bridges with a total estimated cost exceeding
        $100,000,000, at the time of construction.

    (b) MINIMUM SENSOR SUITE. — Each SHM system shall include,
    at a minimum:

        (1) Accelerometers (triaxial) at mid-span and quarter-span
        locations of main spans and at the top of slender columns,
        to measure structural dynamic response for modal analysis
        and seismic event recording;

        (2) Strain gauges (vibrating wire or fiber optic) at
        critical sections including mid-span of main girders,
        locations of maximum negative moment over piers, and
        regions of known fatigue sensitivity;

        (3) Displacement transducers or tiltmeters at expansion
        joints and bearing locations, and at the tops of tall
        piers to measure long-term movements;

        (4) Corrosion sensors, including half-cell probes and
        linear polarization resistance sensors, embedded in
        concrete decks and substructures at locations of
        anticipated chloride ingress;

        (5) Temperature sensors (thermocouples or thermistors)
        at deck level, mid-depth of box girders, and at bearing
        locations to correlate thermal effects with measured
        strains and displacements; and

        (6) Scour monitoring devices (sonar, float-out, or
        tilt-based) at piers in waterways classified as scour-
        critical under 23 CFR 650.313.

    (c) DATA ACQUISITION AND TRANSMISSION. — All SHM systems shall
    include:

        (1) On-site data acquisition hardware with battery backup
        capable of 72 hours of continuous operation without grid
        power;

        (2) Cellular or satellite data telemetry to the State
        bridge management system and the National Bridge Digital
        Twin Data Platform; and

        (3) Automated alerting configured to notify designated
        bridge management personnel when any monitored parameter
        exceeds preset thresholds, including vibration levels
        exceeding design spectra, strains approaching yield,
        displacement exceeding design limits, or corrosion rates
        exceeding 2 mils per year.

    (d) SENSOR CALIBRATION AND MAINTENANCE. — Each State shall
    establish a sensor calibration and maintenance program ensuring
    that all SHM sensors are calibrated at intervals not exceeding
    2 years and that malfunctioning sensors are repaired or replaced
    within 90 days of detection.

SECTION 503. NATIONAL BRIDGE DIGITAL TWIN DATA PLATFORM.

    (a) ESTABLISHMENT. — The Secretary, in coordination with the
    Director of the National Institute of Standards and Technology
    (NIST), shall establish and maintain a secure, cloud-based
    National Bridge Digital Twin Data Platform (the "Platform") for
    the storage, integration, analysis, and visualization of BrIM
    and SHM data from bridges on the National Bridge Inventory.

    (b) PLATFORM CAPABILITIES. — The Platform shall provide:

        (1) Secure storage for BrIM models, inspection records,
        SHM sensor data, and condition assessment reports;

        (2) Integration of BrIM geometry with real-time SHM data
        streams for live visualization of bridge structural
        response;

        (3) Automated condition assessment algorithms using
        data analytics and structural performance metrics;

        (4) Predictive deterioration modeling using historical
        SHM data, environmental data (temperature, humidity,
        chloride deposition rates), and traffic loading data;

        (5) A public-facing dashboard displaying NIPR scores, key
        performance indicators, and summary condition data for
        all bridges, subject to security restrictions under
        subsection (e); and

        (6) Application Programming Interfaces (APIs) enabling
        State bridge management systems to upload and retrieve
        data programmatically.

    (c) DATA SUBMISSION REQUIREMENTS. — Each State shall submit
    to the Platform, at intervals not exceeding 30 days:

        (1) SHM sensor data for all instrumented bridges;

        (2) BrIM updates reflecting any structural modifications,
        rehabilitations, or condition changes; and

        (3) Inspection reports generated under section 103.

    (d) INTEROPERABILITY. — The Secretary shall ensure that the
    Platform is interoperable with the AASHTOWare Bridge Management
    (BrM) software and with the FHWA Long-Term Bridge Performance
    (LTBP) Program database.

    (e) CYBERSECURITY. — The Secretary shall implement, in
    coordination with the Cybersecurity and Infrastructure Security
    Agency (CISA), security protocols for the Platform including:

        (1) Encryption of data in transit and at rest;

        (2) Role-based access controls and multifactor authentication;

        (3) Continuous security monitoring and annual penetration
        testing; and

        (4) An incident response plan for data breaches or
        unauthorized access.

    (f) DATA PRIVACY. — SHM data collected and stored on the
    Platform shall be anonymized with respect to individual
    vehicle identification and shall not be used for automated
    enforcement of traffic laws.

SECTION 504. INTERAGENCY DATA SHARING AND CYBERSECURITY.

    (a) INTERAGENCY ACCESS. — The Secretary shall grant read-only
    access to the Platform to the following entities for research
    and planning purposes:

        (1) The National Institute of Standards and Technology;

        (2) The United States Geological Survey;

        (3) The Department of Homeland Security (for critical
        infrastructure protection);

        (4) The Federal Emergency Management Agency (for
        post-disaster damage assessment);

        (5) University Transportation Centers designated under
        23 U.S.C. 505; and

        (6) Other Federal agencies with a demonstrated need for
        bridge condition data in support of their statutory
        missions.

    (b) RESEARCH DATA ACCESS. — The Secretary shall establish a
    procedure for qualified academic researchers to access
    anonymized SHM and BrIM data for non-commercial research
    purposes, subject to data use agreements and Institutional
    Review Board approval where applicable.

    (c) SECURITY REVIEW. — Not later than 3 years after the Platform
    becomes operational, and every 3 years thereafter, the Secretary
    shall contract for an independent security review of the
    Platform's architecture, access controls, and vulnerability to
    cyber threats.

================================================================================
