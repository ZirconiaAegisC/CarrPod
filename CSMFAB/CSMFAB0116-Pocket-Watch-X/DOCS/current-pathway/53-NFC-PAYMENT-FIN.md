# CSMFAB0116-53 — NFC PAYMENT FIN
## 1. NFC CONTROLLER
| Parameter | Value |
|-----------|-------|
| Controller | NXP PN7150 or ST ST54K |
| Standards | ISO 14443 A/B, ISO 15693, ISO 18092, FeliCa, MIFARE |
| Card emulation | HCE + eSE |
| Secure element | NXP P61 (CC EAL 6+) |
| Antenna | Flexible PCB coil around battery (4 turns) |
| Operating frequency | 13.56 MHz |
| Range | Up to 4 cm |
| Transaction time | < 300 ms |
| EMVCo | L1 certified |
| Payment networks | Visa, Mastercard, Amex, Discover, UnionPay |
## 2. TRANSIT AND ACCESS
| Protocol | Standard |
|----------|----------|
| FeliCa | Sony FeliCa (Suica, Octopus) |
| MIFARE | Classic, DESFire, Plus |
| Calypso | ISO 14443-B |
| CIPURSE | OSPT Alliance |
## 3. VERIFICATION
| Test | Method | Criterion |
|------|--------|-----------|
| EMVCo L1 | EMVCo test bench | Pass all test cases |
| Interoperability | Test with 20 terminals | 100% success |
| Range | Reference PCD at 4 cm | Transaction complete |

