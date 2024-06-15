package com.levog.flapp.ui.components.card

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.levog.flapp.R

@Composable
fun NavigationCardWithDescription(
    text: String,
    colorText: Color,
    textDetails: String,
    colorTextDetails: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 15.sp,
    textDetailsFontSize: TextUnit = 13.sp,
    cardPadding: Dp = 15.dp,
    textPadding: Dp = 5.dp,
    height: Dp = 120.dp
){
    Card(
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        modifier = modifier
            .height(height)
            .fillMaxWidth()
            .padding(cardPadding)
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(10.dp)
            )
            .clip(RoundedCornerShape(10.dp))
            .clickable(onClick = onClick)

    ){
        Row (
            modifier = modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ){
            Column (
                modifier = Modifier
                    .width(300.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    modifier = modifier
                        .padding(textPadding),
                    text = text,
                    fontSize = fontSize,
                    color = colorText
                )
                Text(
                    modifier = modifier
                        .padding(textPadding),
                    text = textDetails,
                    fontSize = textDetailsFontSize,
                    color = colorTextDetails
                )
            }
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = stringResource(R.string.arrow_right)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
private fun NavigateCardPreview(){
    NavigationCardWithDescription(
        text = "Текст",
        colorText = MaterialTheme.colorScheme.onBackground,
        textDetails = "Какой-то дополительный текст",
        colorTextDetails = MaterialTheme.colorScheme.inverseOnSurface ,
        //height = ,
        onClick = { }
    )
}
@Preview(showBackground = true, showSystemUi = false)
@Composable
private fun NavigateCardPreview2(){

    NavigationCardWithDescription(
        text = "Календарь медосмотров",
        colorText = MaterialTheme.colorScheme.onBackground,
        textDetails = "Позволяет в удобном виде просмотреть пройденные медосмотры",
        colorTextDetails = MaterialTheme.colorScheme.inverseOnSurface,
        onClick = {}
    )
}