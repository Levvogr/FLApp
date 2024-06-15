package com.levog.flapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.levog.flapp.navigation.AppNavigation
import com.levog.flapp.ui.theme.FLAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FLApplicationContent()
        }
    }
}
