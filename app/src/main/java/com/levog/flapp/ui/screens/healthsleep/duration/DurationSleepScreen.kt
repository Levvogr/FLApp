package com.levog.flapp.ui.screens.healthsleep.duration

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.levog.flapp.R
import com.levog.flapp.ui.AppViewModelProvider
import com.levog.flapp.ui.components.appbars.MainSmallTopAppBar
import com.levog.flapp.ui.screens.healthsleep.duration.components.DurationLineChart
import com.levog.flapp.ui.screens.healthsleep.duration.components.InformationSleepDurationLatestDaysElement
import com.levog.flapp.ui.screens.healthsleep.start.StartHealthSleepViewModel

@Composable
fun DurationSleepScreen(
    goToStartScreen: () -> Unit,
    goToScheduleScreen: () -> Unit,
    durationSleepViewModel: DurationSleepViewModel =
        viewModel(factory = AppViewModelProvider.Factory)
) {
    val durationSleepUiState by
    durationSleepViewModel.uiState.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){
        Scaffold(
            topBar = { MainSmallTopAppBar(
                text = stringResource(R.string.duration),
                fontSize= 27.sp,
                goToBackScreen = goToStartScreen
            ) },
            content = {padding ->
                Box(
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxSize()
                ){
                    Column(
                        modifier = Modifier
                            .padding(top = 15.dp)
                            .fillMaxSize()
                    ){
                        if(durationSleepUiState.itemList.size>6){
                            DurationLineChart(durationSleepUiState.itemList)
                            InformationSleepDurationLatestDaysElement(
                                items = durationSleepUiState.itemList,
                                countDays = 7
                            )
                        }
                    }
                }
            }
        )
    }






















    /*Column (
        modifier = Modifier
            .padding(16.dp)
            //.background(Color.Magenta)
            .fillMaxSize()
        ,
        horizontalAlignment= Alignment.CenterHorizontally
    ){
        Text(
            text = "DurationSleepScreen",
            fontSize = 50.sp,
            modifier = Modifier
            //.background(Color.Blue)

        )
        Spacer(modifier = Modifier.padding(16.dp))
        Button(onClick = goToStartScreen){
            Text(text = "go to start sleep screen")
        }
        Button(onClick = goToScheduleScreen){
            Text(text = "go to schedule sleep screen")
        }


    }*/
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewDurationSleepScreen(){
    DurationSleepScreen({},{})
}