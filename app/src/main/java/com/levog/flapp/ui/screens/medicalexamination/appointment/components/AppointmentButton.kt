package com.levog.flapp.ui.screens.medicalexamination.appointment.components


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.levog.flapp.R

@Composable
fun AppointmentButton(
    onClick: () -> Unit,
    enabledAndVisibilityAndCreated: Boolean
){
    if(enabledAndVisibilityAndCreated){
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Button(
                modifier = Modifier
                    .size(210.dp,40.dp),
                onClick = onClick
            ) {
                Text(text = stringResource(R.string.make_an_appointment))
            }
        }
    }
}