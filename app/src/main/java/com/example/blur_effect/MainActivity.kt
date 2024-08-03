package com.example.blur_effect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.blur_effect.ui.theme.BlurEffectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BlurEffectTheme {
                // But only works on android 12+.
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}