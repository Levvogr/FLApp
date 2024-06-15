package com.levog.flapp.ui.screens.home.settings.components

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
fun NotificationInformationElement(
    onClick: () -> Unit
){
    Column {
        InformationHeader(
            text = stringResource(R.string.notifications),
            colorText = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.padding(bottom = 10.dp))
        InformationWithDescriptionElement(
            text = stringResource(R.string.notificate_periodic_medical_examination),
            colorText = MaterialTheme.colorScheme.onBackground,
            textDescription = stringResource(R.string.of_week),
            colorTextDescription = MaterialTheme.colorScheme.inverseOnSurface,
            height = 70.dp,
            modifier = Modifier
                .clickable(onClick = onClick)
        )
        Spacer(modifier = Modifier.padding(bottom = 5.dp))
        InformationWithDescriptionElement(
            text = stringResource(R.string.notificate_sleep),
            colorText = MaterialTheme.colorScheme.onBackground,
            textDescription = stringResource(R.string.no_notificate),
            colorTextDescription = MaterialTheme.colorScheme.inverseOnSurface,
            height = 70.dp,
            modifier = Modifier
                .clickable(onClick = onClick)
        )
    }
}