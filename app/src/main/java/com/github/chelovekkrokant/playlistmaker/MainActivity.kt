package com.github.chelovekkrokant.playlistmaker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.github.chelovekkrokant.playlistmaker.ui.navigation.PlaylistHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaylistMakerApp()
        }
    }
}

@Composable
fun PlaylistMakerApp() {
    val navController = rememberNavController()
    PlaylistHost(navController = navController)
}
