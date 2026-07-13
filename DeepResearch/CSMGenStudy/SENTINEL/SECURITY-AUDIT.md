# Marmalade Security Audit
## SENTINEL Research — Android Security Requirements

### Encryption
- **Android Keystore** — Store agent auth tokens, API keys
- **EncryptedSharedPreferences** — Agent configuration, session data
- **Room database** — No built-in encryption; wrap with SQLCipher for v2

### Network Security
- **HTTPS only** — Network Security Config restricts cleartext
- **Certificate pinning** — Pin kilo.ai and github.com certificates
- **OkHttp interceptors** — Log all network calls, block non-approved domains

### ProGuard/R8 Obfuscation
```
# Keep model classes for serialization
-keep class com.carrpod.marmalade.models.** { *; }
# Obfuscate everything else
-obfuscationdictionary dictionary.txt
```

### Permission Audit
```
INTERNET              — REQUIRED (message routing)
FOREGROUND_SERVICE    — REQUIRED (always-on hub)
BLUETOOTH_CONNECT     — OPTIONAL (v2+)
BLUETOOTH_SCAN        — OPTIONAL (v2+)
ACCESS_FINE_LOCATION  — OPTIONAL (v4+ GPS mapping)
```

### Input Validation
- Message body: HTML/script tag stripping
- File uploads: MIME type whitelist, size limit 50MB
- Agent IDs: UUID format validation
- URLs: Only kilo.ai/github.com domains

### Minimum requirements for APK release:
- [x] HTTPS enforcement
- [x] Keystore-backed secrets
- [x] ProGuard enabled
- [x] Permission audit passed
- [x] Input sanitization
- [ ] SQLCipher (v2)
- [ ] Biometric auth for CITADEL console (v2)
- [ ] BLE pairing encryption (v2)
