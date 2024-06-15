package com.levog.flapp.ui.components.appbars.mainbottomappbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp

@Composable
fun MainBottomAppBarElement(
    onClick: () -> Unit,
    width: Dp,
    painter: Painter,
    painterDescription: String,
    text: String
){
    Column (
        modifier = Modifier
            .clickable(onClick = onClick)
            .fillMaxHeight()
            .width(width),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Icon(
            painter = painter,
            contentDescription = painterDescription
        )
        Text(text = text)
    }
}
