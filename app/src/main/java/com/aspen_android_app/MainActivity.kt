package com.aspen_android_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aspen_android_app.navigation.AspenNavGraph
import com.aspen_android_app.ui.theme.AspenAndroidAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AspenAndroidAppTheme(darkTheme = false, dynamicColor = false) {
                AspenNavGraph()
            }
        }
    }
}