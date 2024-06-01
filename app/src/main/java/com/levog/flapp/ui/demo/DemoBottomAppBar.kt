package com.levog.flapp.ui.demo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.levog.flapp.R


@Composable
fun DemoBottomAppBar(
    goToProfileScreen: () -> Unit,
    goToSettingsScreen: () -> Unit,
    goToMedicalExaminationScreen: () -> Unit,
    goToHealthSleepScreen: () -> Unit
){
    BottomAppBar(
        actions = {
            Row (
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround
            ){
                /*
                Column (
                    modifier = Modifier
                        .clickable(onClick = {})
                        .fillMaxHeight()
                        .width(75.dp)
                        .focusable(enabled = true),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Icon(painterResource(id = R.drawable.baseline_home_24),
                        contentDescription = "Localized description")
                    Text(text = "Главная")
                }

                 */
                Column (
                    modifier = Modifier
                        .clickable(onClick = goToMedicalExaminationScreen)
                        .fillMaxHeight()
                        .width(75.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Icon(painterResource(id = R.drawable.baseline_medical_services_24),
                        contentDescription = "Осмотр")
                    Text(text = "Осмотр")
                }

                Column (
                    modifier = Modifier
                        .clickable(onClick = goToHealthSleepScreen)
                        .fillMaxHeight()
                        .width(70.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Icon(painterResource(id = R.drawable.baseline_bedtime_24),
                        contentDescription = "Сон")
                    Text(text = "Сон")
                }


                Column (
                    modifier = Modifier
                        .clickable(onClick = goToProfileScreen)
                        .fillMaxHeight()
                        .width(80.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Icon(painterResource(id = R.drawable.baseline_person_24),
                        contentDescription = "Профиль")
                    Text(text = "Профиль")
                }
                Column (
                    modifier = Modifier
                        .clickable(onClick = goToSettingsScreen)
                        .fillMaxHeight()
                        .width(90.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Icon(painterResource(id = R.drawable.baseline_settings_24),
                        contentDescription = "Настройки")
                    Text(text = "Настройки")
                }
            }
        }
    )
}
@Preview(showBackground = true)
@Composable
fun PreviewDemoBottomAppBar() {
    DemoBottomAppBar({},{},{},{})
}