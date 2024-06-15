package com.levog.flapp.ui.screens.medicalexamination.start

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.levog.flapp.R
import com.levog.flapp.extension.toFormattedDateString
import com.levog.flapp.ui.AppViewModelProvider
import com.levog.flapp.ui.components.appbars.MainSmallTopAppBar
import com.levog.flapp.ui.components.calendar.CalendarDialog
import com.levog.flapp.ui.components.card.NavigationCardWithDescription
import com.levog.flapp.ui.components.information.InformationWithDescriptionElement
import com.levog.flapp.ui.screens.medicalexamination.components.AppointmentFloatingActionButton
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicalExaminationStartScreen(
    goToHomeScreen: () -> Unit,
    goToDetailsScreen: (Int) -> Unit,
    goToAppointmentScreen: () -> Unit,
    goToListScreen: () -> Unit,
    medicalExaminationStartViewModel: MedicalExaminationStartViewModel =
        viewModel(factory = AppViewModelProvider.Factory)
){
    val medicalExaminationStartUiState
    by medicalExaminationStartViewModel.uiState.collectAsState()

    val coroutineScope = rememberCoroutineScope()

    val datePickerState = rememberDatePickerState(
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                return medicalExaminationStartUiState
                    .listFormattedDates
                    .contains(utcTimeMillis.toFormattedDateString())
            }

            override fun isSelectableYear(year: Int): Boolean {
                return year >= 2000
            }
        }
    )
    val fabVisibility = rememberSaveable { (mutableStateOf(true)) }

    CalendarDialog(
        state = datePickerState,
        shouldDisplay = medicalExaminationStartUiState.displayCalendar,
        onConfirmClicked = {
            coroutineScope.launch {
                goToDetailsScreen(
                    medicalExaminationStartViewModel
                        .getMedicalExaminationIdByDate(it)
                )
            }
        },
        dismissRequest = {
            medicalExaminationStartViewModel.updateDisplayCalendar(false)
        }
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){
        Scaffold(
            topBar = { MainSmallTopAppBar(
                text = stringResource(R.string.examination),
                fontSize= 27.sp,
                goToBackScreen = goToHomeScreen
            ) },
            floatingActionButton = {

                AnimatedVisibility(
                    visible = fabVisibility.value,
                    enter = slideInVertically(initialOffsetY = { it }),
                    exit = slideOutVertically(targetOffsetY = { it }),
                    content = {
                        AppointmentFloatingActionButton(goToAppointmentScreen)
                    }
                )
            },
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
                    ){
                        InformationWithDescriptionElement(
                            modifier = Modifier
                                .padding(5.dp),
                            text = stringResource(R.string.date_next_periodic_medical_examination),
                            colorText = MaterialTheme.colorScheme.onBackground,
                            textDescription = medicalExaminationStartUiState.dateNextPeriodMedicalExamination,
                            colorTextDescription = MaterialTheme.colorScheme.inverseOnSurface,
                            height = 100.dp
                        )
                        NavigationCardWithDescription(
                            text = stringResource(R.string.list_of_medical_examination),
                            colorText = MaterialTheme.colorScheme.onBackground,
                            textDetails = stringResource(R.string.last_medical_examination_passed) +"10.06.2024",
                            colorTextDetails = MaterialTheme.colorScheme.inverseOnSurface,
                            onClick = goToListScreen
                        )
                        NavigationCardWithDescription(
                            text = stringResource(R.string.calendar_medical_examination),
                            colorText = MaterialTheme.colorScheme.onBackground,
                            textDetails = stringResource(R.string.allow_view_medical_examinations_in_calendar),
                            colorTextDetails = MaterialTheme.colorScheme.inverseOnSurface,
                            onClick = {
                                medicalExaminationStartViewModel.updateDisplayCalendar(true)
                            }
                        )
                    }
                }
            }
        )
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun MedicalExaminationStartScreenPreview(){
    MedicalExaminationStartScreen({},{},{},{})
}