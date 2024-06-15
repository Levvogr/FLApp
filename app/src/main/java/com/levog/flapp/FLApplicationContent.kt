package com.levog.flapp

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.levog.flapp.data.protodatastore.MainDataStoreManager
import com.levog.flapp.navigation.AppNavigation
import com.levog.flapp.ui.screens.load.LoadScreen
import com.levog.flapp.ui.theme.FLAppTheme

@Composable
fun FLApplicationContent(){
    FLAppTheme{
        AppNavigation()
    }
}
