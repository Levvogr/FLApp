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
fun OtherInformationElement(
    harmfulFactorsExamination: String
){
    Column{
        InformationHeader(
            text = stringResource(R.string.other),
            colorText = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.padding(bottom = 10.dp))
        InformationWithDescriptionElement(
            text = stringResource(R.string.harmful_factors_of_examination),
            colorText = MaterialTheme.colorScheme.onBackground,
            textDescription = harmfulFactorsExamination,
            colorTextDescription = MaterialTheme.colorScheme.inverseOnSurface,
            height = 50.dp
        )
    }
}