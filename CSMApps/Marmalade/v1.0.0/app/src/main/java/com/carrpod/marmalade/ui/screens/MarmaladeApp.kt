package com.carrpod.marmalade.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.carrpod.marmalade.models.*
import com.carrpod.marmalade.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarmaladeApp(viewModel: MarmaladeViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    val messages by viewModel.messages.collectAsState()
    val agents by viewModel.agents.collectAsState()
    var selectedTab by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Marmalade — Agent Hub", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MarmaladeSurface,
                    titleContentColor = MarmaladeOrange
                ),
                actions = {
                    Badge(
                        containerColor = MarmaladeGreen,
                        contentColor = MarmaladeNight,
                        modifier = Modifier.padding(end = 8.dp)
                    ) { Text("${viewModel.getOnlineCount()}") }
                    IconButton(onClick = { viewModel.refresh() }) {
                        Icon(Icons.Default.Refresh, "Refresh", tint = MarmaladeGreen)
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar(containerColor = MarmaladeSurface) {
                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    icon = { Icon(Icons.Default.Forum, "Messages") },
                    label = { Text("Messages") }
                )
                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    icon = { Icon(Icons.Default.People, "Agents") },
                    label = { Text("Agents") }
                )
                NavigationBarItem(
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2 },
                    icon = { Icon(Icons.Default.Public, "Sessions") },
                    label = { Text("Sessions") }
                )
                NavigationBarItem(
                    selected = selectedTab == 3,
                    onClick = { selectedTab = 3 },
                    icon = { Icon(Icons.Default.Terminal, "Console") },
                    label = { Text("Console") }
                )
            }
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding).fillMaxSize()) {
            when (selectedTab) {
                0 -> MessageStream(messages, viewModel)
                1 -> AgentRoster(agents, viewModel)
                2 -> SessionBrowser()
                3 -> CommandConsole(viewModel)
            }
        }
    }
}

@Composable
fun MessageStream(messages: List<Message>, viewModel: MarmaladeViewModel) {
    val listState = rememberLazyListState()
    LaunchedEffect(messages.size) { if (messages.isNotEmpty()) listState.animateScrollToItem(0) }
    Column(modifier = Modifier.fillMaxSize()) {
        if (messages.isEmpty()) {
            Box(Modifier.fillMaxSize().weight(1f), contentAlignment = Alignment.Center) {
                Text("No messages. Pull to refresh.", color = MarmaladeTextDim)
            }
        } else {
            LazyColumn(
                state = listState,
                modifier = Modifier.weight(1f).padding(horizontal = 8.dp),
                reverseLayout = true,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(messages, key = { it.id }) { msg -> MessageCard(msg) }
            }
        }
        MessageInputBar(viewModel)
    }
}

@Composable
fun MessageCard(msg: Message) {
    Card(Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = MarmaladeSurfaceLight)) {
        Column(Modifier.padding(12.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(msg.fromAgentId.take(8), style = MaterialTheme.typography.labelMedium,
                    color = MarmaladeOrange, fontWeight = FontWeight.Bold)
                if (msg.isDirective) {
                    Spacer(Modifier.width(8.dp))
                    Surface(color = MarmaladeRed, shape = MaterialTheme.shapes.small) {
                        Text("DIRECTIVE", Modifier.padding(horizontal = 4.dp),
                            style = MaterialTheme.typography.labelSmall, color = MarmaladeText)
                    }
                }
                Spacer(Modifier.weight(1f))
                Text(msg.vocalMode.name, style = MaterialTheme.typography.labelSmall, color = MarmaladeTextDim)
            }
            Spacer(Modifier.height(4.dp))
            Text(msg.body, style = MaterialTheme.typography.bodyMedium, color = MarmaladeText)
            Spacer(Modifier.height(2.dp))
            Text(msg.subject, style = MaterialTheme.typography.labelSmall, color = MarmaladeTextDim,
                maxLines = 1, overflow = TextOverflow.Ellipsis)
        }
    }
}

@Composable
fun AgentRoster(agents: List<Agent>, viewModel: MarmaladeViewModel) {
    Column(Modifier.fillMaxSize()) {
        Surface(color = MarmaladeSurfaceLight, modifier = Modifier.fillMaxWidth()) {
            Row(Modifier.padding(12.dp)) {
                Text("${viewModel.getOnlineCount()} ONLINE", color = MarmaladeGreen,
                    style = MaterialTheme.typography.labelLarge)
                Spacer(Modifier.width(16.dp))
                Text("${viewModel.getAwaitingCount()} AWAITING", color = MarmaladeOrange,
                    style = MaterialTheme.typography.labelMedium)
            }
        }
        LazyColumn {
            items(agents, key = { it.id }) { agent -> AgentCard(agent) }
        }
    }
}

@Composable
fun AgentCard(agent: Agent) {
    Card(Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 2.dp),
        colors = CardDefaults.cardColors(containerColor = MarmaladeSurfaceLight)) {
        Row(Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            val statusColor = when (agent.status) {
                AgentStatus.ONLINE -> MarmaladeGreen
                AgentStatus.AWAITING -> MarmaladeOrange
                else -> MarmaladeTextDim
            }
            Surface(Modifier.size(10.dp), shape = MaterialTheme.shapes.extraLarge, color = statusColor) {}
            Spacer(Modifier.width(12.dp))
            Column(Modifier.weight(1f)) {
                Text(agent.codename, fontWeight = FontWeight.Bold, color = MarmaladeText)
                Text(agent.name, style = MaterialTheme.typography.bodySmall, color = MarmaladeTextDim)
            }
            Text(agent.directorId, style = MaterialTheme.typography.labelSmall, color = MarmaladeOrange)
        }
    }
}

@Composable
fun MessageInputBar(viewModel: MarmaladeViewModel) {
    var text by remember { mutableStateOf("") }
    var toAgent by remember { mutableStateOf("ALL") }
    Surface(color = MarmaladeSurface, tonalElevation = 4.dp) {
        Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(value = toAgent, onValueChange = { toAgent = it },
                modifier = Modifier.width(80.dp), label = { Text("TO") }, singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MarmaladeOrange, unfocusedBorderColor = MarmaladeSurfaceLight))
            Spacer(Modifier.width(8.dp))
            OutlinedTextField(value = text, onValueChange = { text = it },
                modifier = Modifier.weight(1f), placeholder = { Text("Type message...", color = MarmaladeTextDim) },
                maxLines = 2, colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MarmaladeOrange, unfocusedBorderColor = MarmaladeSurfaceLight))
            Spacer(Modifier.width(8.dp))
            FilledIconButton(onClick = { if (text.isNotBlank()) { viewModel.sendMessage(toAgent, text); text = "" } },
                colors = IconButtonDefaults.filledIconButtonColors(containerColor = MarmaladeOrange)) {
                Icon(Icons.Default.Send, "Send")
            }
        }
    }
}

@Composable
fun SessionBrowser() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Kilo Session Hub", color = MarmaladeOrange, style = MaterialTheme.typography.headlineMedium)
            Spacer(Modifier.height(16.dp))
            Text("Active sessions appear here.", color = MarmaladeTextDim)
            Text("Tap + to open a new Kilo session.", color = MarmaladeTextDim)
        }
    }
}

@Composable
fun CommandConsole(viewModel: MarmaladeViewModel) {
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("COMMAND CONSOLE", style = MaterialTheme.typography.headlineMedium, color = MarmaladeOrange)
        Spacer(Modifier.height(16.dp))
        Card(Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = MarmaladeSurfaceLight)) {
            Column(Modifier.padding(16.dp)) {
                Text("Online: ${viewModel.getOnlineCount()}", color = MarmaladeGreen, fontWeight = FontWeight.Bold)
                Text("Awaiting: ${viewModel.getAwaitingCount()}", color = MarmaladeOrange)
                Text("Total agents: ${viewModel.getAgentCount()}", color = MarmaladeTextDim)
                Text("Messages: ${viewModel.getMessageCount()}", color = MarmaladeText)
            }
        }
    }
}
