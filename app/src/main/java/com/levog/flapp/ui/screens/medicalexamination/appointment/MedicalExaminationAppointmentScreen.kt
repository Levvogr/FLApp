package com.levog.flapp.ui.screens.medicalexamination.appointment

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.levog.flapp.R
import com.levog.flapp.extension.toFormattedDateString
import com.levog.flapp.extension.toFormattedTimeString
import com.levog.flapp.extension.toLong
import com.levog.flapp.ui.AppViewModelProvider
import com.levog.flapp.ui.components.appbars.MainSmallTopAppBar
import com.levog.flapp.ui.screens.medicalexamination.appointment.components.AppointmentButton
import com.levog.flapp.ui.screens.medicalexamination.appointment.components.DateFieldWithDialogCalendar
import com.levog.flapp.ui.screens.medicalexamination.appointment.components.RecurrenceDropdownMenu
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoField
import java.util.Date
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes


@Composable
fun MedicalExaminationAppointmentScreen(
    goToBack: () -> Unit,
    medicalExaminationAppointmentViewModel: MedicalExaminationAppointmentViewModel =
        viewModel(factory = AppViewModelProvider.Factory)
){
    val appointmentUiState by medicalExaminationAppointmentViewModel
        .uiState.collectAsState()

    val coroutineScope = rememberCoroutineScope()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){
        Scaffold(
            topBar = { MainSmallTopAppBar(
                text = stringResource(R.string.appointment_for_a_medical_examination),
                fontSize= 27.sp,
                goToBackScreen = goToBack
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
                    ){
                        RecurrenceDropdownMenu(
                            modifier = Modifier
                                .padding(15.dp)
                                .fillMaxWidth(),
                            textHeader = stringResource(R.string.select_organiztion),
                            colorTextHeader = MaterialTheme.colorScheme.onTertiary,
                            textFieldColor = MaterialTheme.colorScheme.tertiary,
                            values = medicalExaminationAppointmentViewModel
                                .listMedicalExaminationOrganiztions,
                            expanded = appointmentUiState.expandedOrganizationDropdownMenu,
                            onExpandedChange = {
                                medicalExaminationAppointmentViewModel
                                    .updateExpandedOrganizationDropdownMenu(
                                        !appointmentUiState.expandedOrganizationDropdownMenu
                                    )
                            },
                            onDismissRequestDropdownMenu = {
                                medicalExaminationAppointmentViewModel
                                    .updateExpandedOrganizationDropdownMenu(false)
                            },
                            onClickDropdownMenu = {
                                medicalExaminationAppointmentViewModel
                                    .updateExpandedOrganizationDropdownMenu(false)
                                medicalExaminationAppointmentViewModel
                                    .updateMedicalOrganization(it)
                                medicalExaminationAppointmentViewModel
                                    .updateListFormattedDatesOfOrganization(it)
                                medicalExaminationAppointmentViewModel
                                    .updateEnabledAndVisibilityDateField(true)
                            },
                            selectedOptionText = appointmentUiState.medicalOrganization
                        )

                        DateFieldWithDialogCalendar(
                            modifier = Modifier
                                .padding(15.dp)
                                .fillMaxWidth(),
                            textHeader = stringResource(R.string.select_date),
                            colorTextHeader =  MaterialTheme.colorScheme.onBackground,
                            textValue = appointmentUiState.dateMedicalExamination,
                            colorTextValue = MaterialTheme.colorScheme.onTertiary,
                            textFieldContainerColor = MaterialTheme.colorScheme.tertiary,
                            onValueChange = {
                                medicalExaminationAppointmentViewModel
                                    .updateDateMedicalExamination(it)
                            },
                            enabledAndVisibilityAndCreated = appointmentUiState.enabledAndVisibilityDateField,
                            onClick = {
                                medicalExaminationAppointmentViewModel
                                    .updateDisplayCalendar(true)
                            },
                            shouldDisplayCalendar = appointmentUiState.displayCalendar,
                            onConfirmClickedCalendar = {
                                medicalExaminationAppointmentViewModel
                                    .updateDateMedicalExamination(it.toFormattedDateString())
                                medicalExaminationAppointmentViewModel
                                    .updateDisplayCalendar(false)
                                medicalExaminationAppointmentViewModel
                                    .updateListTimeOfDateAndOrganization()
                                medicalExaminationAppointmentViewModel
                                    .updateEnabledAndVisibilityTimeField(true)
                            },
                            dismissRequestCalendar = {
                                medicalExaminationAppointmentViewModel.updateDisplayCalendar(false)
                            },
                            validDates = medicalExaminationAppointmentViewModel
                                .listMedicalExaminationFormattedDates

                        )

                        RecurrenceDropdownMenu(
                            modifier = Modifier
                                .padding(15.dp)
                                .fillMaxWidth(),
                            textHeader = stringResource(R.string.select_time),
                            colorTextHeader = MaterialTheme.colorScheme.onBackground,
                            textFieldColor = MaterialTheme.colorScheme.tertiary,
                            values = medicalExaminationAppointmentViewModel
                                .listMedicalExaminationTimes,
                            expanded = appointmentUiState.expandedTimeDropdownMenu,
                            onExpandedChange = {
                                medicalExaminationAppointmentViewModel
                                    .updateExpandedTimeDropdownMenu(
                                        !appointmentUiState.expandedOrganizationDropdownMenu
                                    )
                            },
                            onDismissRequestDropdownMenu = {
                                medicalExaminationAppointmentViewModel
                                    .updateExpandedTimeDropdownMenu(false)
                            },
                            onClickDropdownMenu = {
                                medicalExaminationAppointmentViewModel
                                    .updateExpandedTimeDropdownMenu(false)
                                medicalExaminationAppointmentViewModel
                                    .updateTimeMedicalExamination(it)
                                medicalExaminationAppointmentViewModel
                                    .updateEnabledAndVisibilityAppointmentButton(true)
                            },
                            selectedOptionText = appointmentUiState.timeMedicalExamination,
                            enabledAndVisibilityAndCreated = appointmentUiState.enabledAndVisibilityTimeField
                        )

                        AppointmentButton(
                            onClick = {
                                coroutineScope.launch {
                                    medicalExaminationAppointmentViewModel.saveItem()
                                }
                                goToBack()
                            },
                            enabledAndVisibilityAndCreated = appointmentUiState.enabledAndVisibilityAppointmentButton
                        )
                    }
                }
            }
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMedicalExaminationAppointmentScreen(){
    MedicalExaminationAppointmentScreen({})
}