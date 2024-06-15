package com.levog.flapp.ui.screens.home.profile.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.levog.flapp.R
import com.levog.flapp.ui.components.information.InformationElement
import com.levog.flapp.ui.components.information.InformationHeader

@Composable
fun ProfileInformationAccountElement(
    goToAuthenticationScreen: () -> Unit
){
    Column {
        InformationHeader(
            text = stringResource(R.string.account),
            colorText = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.padding(bottom = 10.dp))
        InformationElement(
            text = stringResource(R.string.exit_account),
            colorText = MaterialTheme.colorScheme.onBackground,
            height = 70.dp,
            modifier = Modifier
                .clickable(onClick = goToAuthenticationScreen)
        )
    }
}