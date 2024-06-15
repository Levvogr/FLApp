package com.levog.flapp.ui.screens.healthsleep.duration.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.levog.flapp.R
import com.levog.flapp.ui.screens.healthsleep.components.InformationSleepElement

@Composable
fun InformationSleepDurationElement(
    textDate: String,
    colorTextDate: Color,
    durationSleep: String,
    colorTextSleep: Color
){
    InformationSleepElement(
        textDate = textDate,
        colorTextDate = colorTextDate,
        textSleep = stringResource(R.string.duration_sleep) +
                stringResource(R.string.colon_separeter_with_space) +
                durationSleep,
        colorTextSleep = colorTextSleep
    )

}