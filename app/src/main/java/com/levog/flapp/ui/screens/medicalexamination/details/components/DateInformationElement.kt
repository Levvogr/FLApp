package com.levog.flapp.ui.screens.medicalexamination.details.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.levog.flapp.R
import com.levog.flapp.ui.components.information.InformationHeader
import com.levog.flapp.ui.components.information.InformationWithDescriptionElement

@Composable
fun DateInformationElement(
    plannedDateFrom: String,
    plannedDateFor: String,
    dateExamination: String,
    timeExamination: String,
    datePreparationAct: String,
){
    Column{
        InformationHeader(
            text = stringResource(R.string.date),
            colorText = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.padding(bottom = 10.dp))
        InformationWithDescriptionElement(
            text = stringResource(R.string.planned_date_from),
            colorText = MaterialTheme.colorScheme.onBackground,
            textDescription = plannedDateFrom,
            colorTextDescription = MaterialTheme.colorScheme.inverseOnSurface,
            height = 50.dp
        )
        Spacer(modifier = Modifier.padding(bottom = 10.dp))
        InformationWithDescriptionElement(
            text = stringResource(R.string.planned_date_for),
            colorText = MaterialTheme.colorScheme.onBackground,
            textDescription = plannedDateFor,
            colorTextDescription = MaterialTheme.colorScheme.inverseOnSurface,
            height = 50.dp
        )
        Spacer(modifier = Modifier.padding(bottom = 10.dp))
        InformationWithDescriptionElement(
            text = stringResource(R.string.date_examination),
            colorText = MaterialTheme.colorScheme.onBackground,
            textDescription = dateExamination,
            colorTextDescription = MaterialTheme.colorScheme.inverseOnSurface,
            height = 50.dp
        )
        InformationWithDescriptionElement(
            text = stringResource(R.string.time_examination),
            colorText = MaterialTheme.colorScheme.onBackground,
            textDescription = timeExamination,
            colorTextDescription = MaterialTheme.colorScheme.inverseOnSurface,
            height = 50.dp
        )
        Spacer(modifier = Modifier.padding(bottom = 10.dp))
        InformationWithDescriptionElement(
            text = stringResource(R.string.date_of_preparation_of_the_act),
            colorText = MaterialTheme.colorScheme.onBackground,
            textDescription = datePreparationAct,
            colorTextDescription = MaterialTheme.colorScheme.inverseOnSurface,
            height = 50.dp
        )
    }
}