package com.levog.flapp.ui.screens.home.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.levog.flapp.R
import com.levog.flapp.ui.components.appbars.MainSmallTopAppBar
import com.levog.flapp.ui.screens.home.settings.components.NotificationInformationElement
import com.levog.flapp.ui.screens.home.settings.components.ScreenInformationElement
import com.levog.flapp.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(goToHomeScreen: () -> Unit){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){
        Scaffold(
            topBar = { MainSmallTopAppBar(
                text = stringResource(R.string.settings),
                fontSize= 27.sp,
                goToBackScreen = goToHomeScreen
            ) },
            content = {padding ->
                Box(
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxSize()
                ) {

                    Column(
                        modifier = Modifier
                            .padding(top = 15.dp)
                            .fillMaxSize()
                    ) {
                        ScreenInformationElement({})
                        Spacer(modifier = Modifier.padding(10.dp))
                        NotificationInformationElement({})
                    }
                }
            }
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewSettingsScreen(){
    SettingsScreen({})
}