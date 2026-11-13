package com.jpod.music

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Background = Color(0xFF111111)
private val Surface = Color(0xFF232323)
private val Accent = Color(0xFF69D58B)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { JPodApp() }
    }
}

@Composable
private fun JPodApp() {
    var selected by remember { mutableIntStateOf(0) }
    val labels = listOf("Home", "Search", "Your Library")
    MaterialTheme(colorScheme = darkColorScheme(primary = Accent, background = Background, surface = Surface)) {
        Scaffold(
            containerColor = Background,
            bottomBar = {
                Column {
                    // Placeholder mini-player; connect it to Media3 after playback is implemented.
                    Surface(color = Surface, shape = RoundedCornerShape(10.dp), modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)) {
                        Row(Modifier.padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
                            Text("♫", color = Accent, fontSize = 22.sp)
                            Spacer(Modifier.width(12.dp))
                            Column {
                                Text("Nothing playing", color = Color.White, fontWeight = FontWeight.SemiBold)
                                Text("Connect your Navidrome server", color = Color.LightGray, fontSize = 12.sp)
                            }
                        }
                    }
                    NavigationBar(containerColor = Background) {
                        val icons = listOf(Icons.Default.Home, Icons.Default.Search, Icons.Default.LibraryMusic)
                        labels.forEachIndexed { index, label ->
                            NavigationBarItem(
                                selected = selected == index,
                                onClick = { selected = index },
                                icon = { Icon(icons[index], contentDescription = label) },
                                label = { Text(label) },
                                colors = NavigationBarItemDefaults.colors(selectedIconColor = Accent, selectedTextColor = Color.White, unselectedIconColor = Color.Gray, unselectedTextColor = Color.Gray, indicatorColor = Surface)
                            )
                        }
                    }
                }
            }
        ) { padding ->
            LazyColumn(Modifier.fillMaxSize().padding(padding).padding(horizontal = 20.dp)) {
                item {
                    Spacer(Modifier.height(28.dp))
                    Text(labels[selected], color = Color.White, fontSize = 30.sp, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(24.dp))
                    Text(when (selected) {
                        0 -> "Good music starts here"
                        1 -> "Find your favorite tracks"
                        else -> "Your albums, artists, and playlists"
                    }, color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                    Spacer(Modifier.height(12.dp))
                    Text("Navidrome connection and music browsing are coming in the next milestone.", color = Color.LightGray)
                }
            }
        }
    }
}
