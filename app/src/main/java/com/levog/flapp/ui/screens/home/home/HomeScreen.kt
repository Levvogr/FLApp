package com.levog.flapp.ui.screens.home.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.levog.flapp.ui.components.appbars.mainbottomappbar.MainBottomAppBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    goToProfileScreen: () -> Unit,
    goToSettingsScreen: () -> Unit,
    goToMedicalExaminationScreen: () -> Unit,
    goToHealthSleepScreen: () -> Unit
){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){
        Scaffold(
            bottomBar = {
                MainBottomAppBar(
                    containerColor = MaterialTheme.colorScheme.tertiary,
                    contentColor = MaterialTheme.colorScheme.onTertiary,
                    goToProfileScreen = goToProfileScreen,
                    goToSettingsScreen = goToSettingsScreen,
                    goToMedicalExaminationScreen = goToMedicalExaminationScreen,
                    goToHealthSleepScreen = goToHealthSleepScreen
                )
            },
            content = { padding ->
                Box(
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxSize()
                )
            }
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHomeScreen(){
    HomeScreen({},{},{},{})
}