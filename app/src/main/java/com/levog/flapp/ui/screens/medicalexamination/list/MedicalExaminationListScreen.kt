package com.levog.flapp.ui.screens.medicalexamination.list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.levog.flapp.R
import com.levog.flapp.ui.AppViewModelProvider
import com.levog.flapp.ui.components.appbars.MainSmallTopAppBar
import com.levog.flapp.ui.screens.medicalexamination.components.AppointmentFloatingActionButton
import com.levog.flapp.ui.screens.medicalexamination.list.components.MedicalExaminationCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicalExaminationListScreen(
    goToStartScreen: () -> Unit,
    goToDetailsScreen: (Int) -> Unit,
    goToAppointmentScreen: () -> Unit,
    medicalExaminationListViewModel: MedicalExaminationListViewModel =
        viewModel(factory = AppViewModelProvider.Factory)
){

    val medicalExaminationListUiState by
    medicalExaminationListViewModel.uiState.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){
        val fabVisibility = rememberSaveable { (mutableStateOf(true)) }
        Scaffold(
            modifier = Modifier.padding(16.dp, 0.dp),
            topBar = { MainSmallTopAppBar(
                text = stringResource(R.string.list_of_medical_examination),
                fontSize= 27.sp,
                goToBackScreen = goToStartScreen
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
            ){padding ->
            Box(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp),
                    reverseLayout = false
                ){
                    items(
                        items = medicalExaminationListUiState.itemList,
                        key = {it.id}
                    ){item ->
                        MedicalExaminationCard(
                            medicalExamination = item,
                            goToDetailsScreen = goToDetailsScreen
                        )
                        Spacer(modifier = Modifier.padding(5.dp))
                    }
                }
            }
        }
    }


}
@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewMedicalExaminationListScreen(){
    MedicalExaminationListScreen({},{},{})
}

