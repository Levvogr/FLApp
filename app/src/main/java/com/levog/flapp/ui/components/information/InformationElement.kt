package com.levog.flapp.ui.components.information

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
fun InformationElement(
    text: String,
    colorText: Color,
    height: Dp,
    modifier: Modifier = Modifier,
    startPadding: Dp = 15.dp,
    fontSize: TextUnit = 15.sp
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .size(width = 0.dp, height = height),
        verticalArrangement = Arrangement.Center
    ){
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(startPadding),
            text = text,
            color = colorText,
            fontSize = fontSize,
            fontWeight = FontWeight(400)
        )
    }
}