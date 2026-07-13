# Marmalade Testing Framework
## SENTINEL Research — Android QA Architecture

### Test Pyramid
```
         E2E (10%)
        /────────\
       / Unit     \
      /────────────\
     /  Integration  \
    /────────────────\
   /      Unit 70%     \
  /──────────────────────\
```

### Testing Stack
- **JUnit 5** — Unit tests for ViewModels, Repositories, UseCases
- **Espresso** — UI interaction tests
- **UI Automator** — Cross-app/system tests
- **Robolectric** — Local unit tests with Android framework

### Unit Tests (70%)
```kotlin
@Test
fun agentRegistration_storesInDatabase() {
    val agent = Agent(directorId = "0019", codename = "CORTEX", name = "Kael Forge")
    agentManager.registerAgent(agent)
    val stored = agentDao.getAgent(agent.id)
    assert(stored?.codename == "CORTEX")
}

@Test
fun messageRouter_deliversToCorrectAgent() {
    val msg = Message(fromAgentId = "0001", toAgentId = "0019", body = "Test")
    agentManager.routeMessage(msg)
    val msgs = messageDao.getMessagesForAgent("0019").first()
    assert(msgs.any { it.body == "Test" })
}
```

### Integration Tests (20%)
```kotlin
@Test
fun messageFlow_fromInputToDatabase() {
    // Simulate message input → ViewModel → Database → UI readback
    viewModel.sendMessage("0019", "Test directive")
    advanceUntilIdle()
    val msgs = viewModel.messages.first()
    assert(msgs.isNotEmpty())
}
```

### Performance Benchmarks
| Target | Threshold |
|--------|-----------|
| Cold start | < 500ms |
| Message send latency | < 100ms |
| Memory (100 sessions) | < 100MB |
| Battery drain (always-on) | < 5%/hr |
| Agent list scroll | 60fps at 100 items |

### Security Test Cases
1. **Keystore access** — Verify secrets stored in Android Keystore, not SharedPreferences
2. **Certificate pinning** — Verify HTTPS connections only to kilo.ai/github.com
3. **Permission audit** — No extra permissions beyond manifest
4. **ProGuard obfuscation** — Verify release APK is obfuscated
5. **Input sanitization** — XSS/script injection in message body
6. **File upload validation** — MIME type checking, size limits

### Regression Wall SOP
```
BUG FOUND → Write reproduction test → Verify test FAILS → Fix code → Verify test PASSES → Deploy to CI
                                                                                      ↓
                                                                         Test gates deploy
                                                                                      ↓
                                                                         Push to main
```

Every bug becomes a regression test within 1 development cycle.
