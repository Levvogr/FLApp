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
fun MainInformationElement(
    typeExamination: String,
    status: String,
    conclusion: String
){
    Column{
        InformationHeader(
            text = stringResource(R.string.main),
            colorText = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.padding(bottom = 10.dp))
        InformationWithDescriptionElement(
            text = stringResource(R.string.type_examination),
            colorText = MaterialTheme.colorScheme.onBackground,
            textDescription = typeExamination,
            colorTextDescription = MaterialTheme.colorScheme.inverseOnSurface,
            height = 50.dp
        )
        Spacer(modifier = Modifier.padding(bottom = 10.dp))
        InformationWithDescriptionElement(
            text = stringResource(R.string.status),
            colorText = MaterialTheme.colorScheme.onBackground,
            textDescription = status,
            colorTextDescription = MaterialTheme.colorScheme.inverseOnSurface,
            height = 50.dp
        )
        Spacer(modifier = Modifier.padding(bottom = 10.dp))
        InformationWithDescriptionElement(
            text = stringResource(R.string.conclusion),
            colorText = MaterialTheme.colorScheme.onBackground,
            textDescription = conclusion,
            colorTextDescription = MaterialTheme.colorScheme.inverseOnSurface,
            height = 50.dp
        )
    }
}