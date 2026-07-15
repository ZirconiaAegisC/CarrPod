
# TECHNICAL FRAMEWORK
## ACS-MAERSK-CONTAINER-FLEET-PROTECTION
### Maritime GIC Protection Architecture

**CLASSIFICATION: COMMERCIAL-IN-CONFIDENCE**

---

## 1. HULL POTENTIAL MANAGEMENT SYSTEM (HPMS)

Based on CSM-CF-700 Charlemagne Fleet technology. The HPMS is installed in the ship's engine room, connected to hull reference electrodes (Ag/AgCl seawater reference cells) at bow, midships, and stern. During a GMD event:

- **Sensing:** Three-axis fluxgate magnetometer on the bridge roof measures local dB/dt (rate of change of magnetic field, typically 100-500 nT/min during Kp 8-9 events). Six hull reference electrodes measure hull-to-seawater potential at distributed points.
- **Processing:** HPMS controller (redundant PLC, 1 ms control loop) calculates GIC current distribution across hull and determines compensating current vector.
- **Compensation:** Active current injection through counter-electrodes at bow and stern. DCI (directionally-controlled injection) maintains hull potential within ±0.5V of seawater reference.
- **Power:** HPMS draws from ship's emergency bus (440V 3-phase, battery-backed). 50 kW continuous, 150 kW peak during GMD event compensation. Transformer-isolated input with CSM-NBC-2400 miniature NBC on HPMS input.
- **Monitoring:** Continuous data logging to Voyage Data Recorder (VDR). Real-time display on bridge. Automated alarm to Captain and Chief Engineer upon GIC detection.

**Williams Heuristic:** "Think of the ship as a giant battery sitting in saltwater. During a solar storm, the storm tries to charge and discharge this battery, pushing electrical current through the ship's steel hull into the wiring. Our system measures where the current is trying to go and pushes back with an equal and opposite current, like noise-canceling headphones for a ship."

## 2. BRIDGE ELECTRONICS HARDENING

**GIC-Rated Equipment Rack (CSM-BER-1800):**
- Integrated 19-inch rack with built-in NBC on AC input
- MXene DC-link capacitors on internal DC bus (24V and 48V control power)
- Shielded enclosure with CSM-MX-2400 MXene coating (60 dB attenuation DC to 10 GHz)
- Fiber-optic isolation for all Ethernet, NMEA 0183/2000, and CAN bus interfaces
- Protonic backup communication module (CSM-PC-5000 miniaturized)
- Cost per rack: $380,000. Installation time: 2 days in port.

## 3. PROTONIC FLEET COMMUNICATION

**CSM-PC-5000 Maritime Node:**
- Shipboard transceiver: 2U rack-mount, 250W, integrated with ship's existing antenna mast
- Shore station: CSM-PC-5000-T (terminal version), installed at 10 priority Maersk ports
- Network topology: Mesh — each vessel relays for others. Shore stations provide land-side connectivity.
- Performance: 10 Mbps, 5,000 km range. Packet loss <0.1% during Kp 9 event (validated on Charlemagne test flights)
- Cost: $40,000 per vessel + $1.03M per shore station

## 4. REEFER POWER PROTECTION

Container ship reefer (refrigerated container) electrical buses distribute 440V 3-phase power to 500-2,000 individual reefer containers. Each reefer draws 5-15 kW. Total reefer load on a large container vessel: 2.5-10 MW.

**CSM-RP-1500 Reefer Bus Protector:**
- Installed at reefer bus distribution panel
- Active harmonic filter (CSM-MX-2400 miniaturized) maintains <2% THD
- NBC on bus input blocks GIC from entering reefer bus
- Continuous insulation monitoring per IEC 61557-8
- Cost: $25,000 per bus. Installation: 1 day in port.

## 5. PORT SHORE-POWER PROTECTION

**CSM-SPC-2200 Shore Power Conditioner:**
- Installed between shore transformer and ship connection
- 6.6 kV or 11 kV rated (standard shore-power voltages)
- NBC on shore-side neutral connection
- Harmonic filter for quay crane power quality
- Communications: Modbus TCP/IP to terminal operating system

---

**CLASSIFICATION: COMMERCIAL-IN-CONFIDENCE**
