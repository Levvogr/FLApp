package com.levog.flapp.ui.screens.healthsleep.start.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.levog.flapp.R
import com.levog.flapp.ui.screens.healthsleep.components.InformationSleepElement

@Composable
fun InformationSleepIntervalAndDurationElement(
    textDate: String,
    colorTextDate: Color,
    sleepInterval: String,
    durationSleep: String,
    colorTextSleep: Color
){
    InformationSleepElement(
        textDate = textDate,
        colorTextDate = colorTextDate,
        textSleep = stringResource(R.string.sleep_interval) +
                stringResource(R.string.colon_separeter_with_space) +
                sleepInterval +
                "\n" +
                stringResource(R.string.duration_sleep) +
                stringResource(R.string.colon_separeter_with_space) +
                durationSleep,
        colorTextSleep = colorTextSleep
    )

}