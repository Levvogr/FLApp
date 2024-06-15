package com.levog.flapp.ui.screens.medicalexamination.details.components

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
fun DoctorInformationElement(
    fullNameDoctor: String,
    medicalSpecialty: String,
){
    Column{
        InformationHeader(
            text = stringResource(R.string.doctor),
            colorText = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.padding(bottom = 10.dp))
        InformationWithDescriptionElement(
            text = stringResource(R.string.full_name_of_the_doctor),
            colorText = MaterialTheme.colorScheme.onBackground,
            textDescription = fullNameDoctor,
            colorTextDescription = MaterialTheme.colorScheme.inverseOnSurface,
            height = 50.dp
        )
        Spacer(modifier = Modifier.padding(bottom = 10.dp))
        InformationWithDescriptionElement(
            text = stringResource(R.string.medical_specialty),
            colorText = MaterialTheme.colorScheme.onBackground,
            textDescription = medicalSpecialty,
            colorTextDescription = MaterialTheme.colorScheme.inverseOnSurface,
            height = 50.dp
        )
    }
}