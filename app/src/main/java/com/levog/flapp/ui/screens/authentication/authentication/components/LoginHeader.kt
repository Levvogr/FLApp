package com.levog.flapp.ui.screens.authentication.authentication.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.levog.flapp.R

@Composable
fun LoginHeader()
{
    Column {
        Text(text = stringResource(R.string.sign_in_account),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold)
    }
}