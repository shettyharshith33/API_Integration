package com.shettyharshith33.apiintegration

import android.app.StatusBarManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import com.shettyharshith33.apiintegration.ui.theme.APIIntegrationTheme
import com.shettyharshith33.apiintegration.ui.theme.Purple40
import com.shettyharshith33.apiintegration.ui.theme.Purple80
import com.shettyharshith33.apiintegration.ui.view.PostListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            SystemBarStyle.light(
                Purple80.toArgb(),
                darkScrim = Purple80.toArgb()
            )
        )
        setContent {
            PostListScreen()
        }
    }
}
