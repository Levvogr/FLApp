package com.levog.flapp.ui.screens.authentication.registration.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.levog.flapp.R

@Composable
fun RegistrationHeader()
{
    Column {
        Text(text= stringResource(R.string.create_an_account),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold)
    }
}
