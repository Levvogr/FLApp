package com.levog.flapp.ui.screens.healthsleep.start

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.levog.flapp.R
import com.levog.flapp.extension.toFormattedDateStringFull
import com.levog.flapp.ui.AppViewModelProvider
import com.levog.flapp.ui.components.appbars.MainSmallTopAppBar
import com.levog.flapp.ui.components.card.NavigationCard
import com.levog.flapp.ui.components.information.InformationHeader
import com.levog.flapp.ui.components.information.InformationWithDescriptionElement
import com.levog.flapp.ui.screens.healthsleep.start.components.InformationSleepLatestDaysElement
import com.levog.flapp.ui.screens.medicalexamination.start.MedicalExaminationStartViewModel
import java.time.LocalDate


@Composable
fun StartHealthSleepScreen(
    goToHomeScreen: () -> Unit,
    goToScheduleScreen: () -> Unit,
    goToDurationScreen: () -> Unit,
    startHealthSleepViewModel: StartHealthSleepViewModel =
        viewModel(factory = AppViewModelProvider.Factory)
){

    val startHealthSleepUiState by
    startHealthSleepViewModel.uiState.collectAsState()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){
        Scaffold(
            topBar = { MainSmallTopAppBar(
                text = stringResource(R.string.sleep),
                fontSize= 27.sp,
                goToBackScreen = goToHomeScreen
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
                        NavigationCard(
                            text = stringResource(R.string.duration_sleep),
                            colorText = MaterialTheme.colorScheme.onBackground,
                            onClick = goToDurationScreen
                        )
                        NavigationCard(
                            text = stringResource(R.string.schedule_sleep),
                            colorText = MaterialTheme.colorScheme.onBackground,
                            onClick = goToScheduleScreen
                        )

                        Spacer(modifier = Modifier.padding(30.dp))

                        InformationSleepLatestDaysElement(
                            items = startHealthSleepUiState.itemList,
                            countDays = 7
                        )
                    }
                }
            }
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewStartHealthSleep(){
    StartHealthSleepScreen({},{},{})
}