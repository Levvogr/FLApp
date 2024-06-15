package com.levog.flapp.ui.screens.healthsleep.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.levog.flapp.ui.components.information.InformationWithDescriptionElement

@Composable
fun InformationSleepElement(
    textDate: String,
    colorTextDate: Color,
    textSleep: String,
    colorTextSleep: Color,
    height: Dp = 80.dp
){
    InformationWithDescriptionElement(
        text = textDate,
        colorText = colorTextDate,
        textDescription = textSleep,
        colorTextDescription = colorTextSleep,
        height = height
    )
}