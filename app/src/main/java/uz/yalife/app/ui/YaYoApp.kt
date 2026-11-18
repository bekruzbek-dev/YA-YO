package uz.yalife.app.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.Checklist
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.SmartToy
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

private data class Dest(val route: String, val label: String, val icon: ImageVector)

private val destinations = listOf(
    Dest("home", "Bosh sahifa", Icons.Outlined.Home),
    Dest("scanner", "Skaner", Icons.Outlined.CameraAlt),
    Dest("ingredients", "Tarkib", Icons.Outlined.Checklist),
    Dest("assistant", "Yordamchi", Icons.Outlined.SmartToy),
    Dest("settings", "Sozlamalar", Icons.Outlined.Settings)
)

@Composable
fun YaYoApp() {
    val nav = rememberNavController()
    val backStack by nav.currentBackStackEntryAsState()
    val current = backStack?.destination?.route

    Scaffold(
        bottomBar = {
            NavigationBar {
                destinations.forEach { d ->
                    NavigationBarItem(
                        selected = current == d.route,
                        onClick = {
                            nav.navigate(d.route) {
                                popUpTo(nav.graph.findStartDestination().id) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(d.icon, contentDescription = d.label) },
                        label = { Text(d.label) }
                    )
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = nav,
            startDestination = "home",
            modifier = Modifier.padding(padding)
        ) {
            destinations.forEach { d ->
                composable(d.route) {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(d.label)
                    }
                }
            }
        }
    }
}
