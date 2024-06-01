package com.levog.flapp.ui.screens.home.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.levog.flapp.ui.demo.DemoBottomAppBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    goToProfileScreen: () -> Unit,
    goToSettingsScreen: () -> Unit,
    goToMedicalExaminationScreen: () -> Unit,
    goToHealthSleepScreen: () -> Unit){
    Scaffold(
        bottomBar = {
            DemoBottomAppBar(
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHomeScreen(){
    HomeScreen({},{},{},{})
}