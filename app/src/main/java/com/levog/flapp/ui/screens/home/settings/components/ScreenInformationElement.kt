package com.levog.flapp.ui.screens.home.settings.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import com.levog.flapp.ui.components.information.InformationWithDescriptionElement
import com.levog.flapp.ui.theme.Purple40


@Composable
fun ScreenInformationElement(
    onClick: () -> Unit
){
    Column {
        InformationHeader(
            text = stringResource(R.string.screen),
            colorText = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.padding(bottom = 10.dp))
        InformationWithDescriptionElement(
            text = stringResource(R.string.theme),
            colorText = MaterialTheme.colorScheme.onBackground,
            textDescription = stringResource(R.string.default_theme),
            colorTextDescription = MaterialTheme.colorScheme.inverseOnSurface,
            height = 70.dp,
            modifier = Modifier
                .clickable(onClick = onClick)
        )
    }
}