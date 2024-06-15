package com.levog.flapp.ui.screens.medicalexamination.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.levog.flapp.R
import com.levog.flapp.extension.toFormattedDateString
import com.levog.flapp.extension.toFormattedTimeString
import com.levog.flapp.ui.AppViewModelProvider
import com.levog.flapp.ui.components.appbars.MainSmallTopAppBar
import com.levog.flapp.ui.screens.medicalexamination.details.components.DateInformationElement
import com.levog.flapp.ui.screens.medicalexamination.details.components.DoctorInformationElement
import com.levog.flapp.ui.screens.medicalexamination.details.components.MainInformationElement
import com.levog.flapp.ui.screens.medicalexamination.details.components.OrganizationInformationElement
import com.levog.flapp.ui.screens.medicalexamination.details.components.OtherInformationElement
import com.levog.flapp.ui.theme.Purple40
import java.time.LocalTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicalExaminationDetailsScreen(
    goToBack: () -> Unit,
    medicalExaminationDetailsViewModel: MedicalExaminationDetailsViewModel =
        viewModel(factory = AppViewModelProvider.Factory)
){
    val medicalExaminationDetailsUiState by
    medicalExaminationDetailsViewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            MainSmallTopAppBar(
                text = stringResource(R.string.details),
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
                        .verticalScroll(rememberScrollState())
                ) {
                    MainInformationElement(
                        typeExamination = medicalExaminationDetailsUiState.typeExamination,
                        status = medicalExaminationDetailsUiState.status,
                        conclusion = if (medicalExaminationDetailsUiState.conclusion== null){
                            stringResource(R.string.no_data)
                        }
                        else{
                            medicalExaminationDetailsUiState.conclusion!!
                        }
                    )
                    Spacer(modifier = Modifier.padding(bottom = 30.dp))
                    DateInformationElement(
                        plannedDateFrom =
                        if (medicalExaminationDetailsUiState.plannedDateFrom== null){
                            stringResource(R.string.no_data)
                        }
                        else{
                            medicalExaminationDetailsUiState.plannedDateFrom!!.toFormattedDateString()
                        },
                        plannedDateFor =
                        if (medicalExaminationDetailsUiState.plannedDateFor== null){
                            stringResource(R.string.no_data)
                        }
                        else{
                            medicalExaminationDetailsUiState.plannedDateFor!!.toFormattedDateString()
                        },
                        dateExamination = if (medicalExaminationDetailsUiState.dateExamination== null){
                            stringResource(R.string.no_data)
                        }
                        else{
                            medicalExaminationDetailsUiState.dateExamination!!.toFormattedDateString()
                        },
                        timeExamination = if ((medicalExaminationDetailsUiState.hourExamination == null) or (medicalExaminationDetailsUiState.minuteExamination == null)){
                                stringResource(R.string.no_data)
                        }
                        else{
                            LocalTime.of(medicalExaminationDetailsUiState.hourExamination!!,
                                medicalExaminationDetailsUiState.minuteExamination!!
                            ).toFormattedTimeString()
                        },
                        datePreparationAct = if (medicalExaminationDetailsUiState.datePreparationAct== null){
                            stringResource(R.string.no_data)
                        }
                        else{
                            medicalExaminationDetailsUiState.datePreparationAct!!.toFormattedDateString()
                        }
                    )
                    Spacer(modifier = Modifier.padding(bottom = 30.dp))
                    OrganizationInformationElement(
                        medicalOrganization = medicalExaminationDetailsUiState.medicalOrganization,
                        organization =
                        if (medicalExaminationDetailsUiState.organization== null){
                            stringResource(R.string.no_data)
                        }
                        else{
                            medicalExaminationDetailsUiState.organization!!
                        }
                    )
                    Spacer(modifier = Modifier.padding(bottom = 30.dp))
                    DoctorInformationElement(
                        fullNameDoctor =
                        if (medicalExaminationDetailsUiState.fullNameDoctor== null){
                            stringResource(R.string.no_data)
                        }
                        else{
                            medicalExaminationDetailsUiState.fullNameDoctor!!
                        },
                        medicalSpecialty =
                        if (medicalExaminationDetailsUiState.medicalSpecialty== null){
                            stringResource(R.string.no_data)
                        }
                        else{
                            medicalExaminationDetailsUiState.medicalSpecialty!!
                        }
                    )
                    Spacer(modifier = Modifier.padding(bottom = 30.dp))
                    OtherInformationElement(
                        harmfulFactorsExamination =
                        if (medicalExaminationDetailsUiState.harmfulFactorsExamination== null){
                            stringResource(R.string.no_data)
                        }
                        else{
                            medicalExaminationDetailsUiState.harmfulFactorsExamination!!
                        }
                    )
                }
            }
        }
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMedicalExaminationDetailsScreen(){
    MedicalExaminationDetailsScreen({})
}
