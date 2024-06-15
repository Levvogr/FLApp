package com.levog.flapp.ui.components.information

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.levog.flapp.R

@Composable
fun InformationHeader(
    text: String,
    colorText: Color,
    startPadding: Dp = 15.dp,
    fontSize: TextUnit = 15.sp
){
    Text(
        modifier = Modifier
            .padding(start = startPadding),
        text = text,
        color = colorText,
        fontSize = fontSize,
        fontWeight = FontWeight(700)
    )
}