package com.levog.flapp.ui.screens.healthsleep.schedule

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScheduleSleepScreen(
    goToStartScreen: () -> Unit,
    goToDurationScreen: () -> Unit){
    Column (
        modifier = Modifier
            .padding(16.dp)
            //.background(Color.Magenta)
            .fillMaxSize()
        ,
        horizontalAlignment= Alignment.CenterHorizontally
    ){
        Text(
            text = "ScheduleSleepScreen",
            fontSize = 50.sp,
            modifier = Modifier
            //.background(Color.Blue)

        )
        Spacer(modifier = Modifier.padding(16.dp))
        Button(onClick = goToStartScreen){
            Text(text = "go to start sleep screen")
        }
        Button(onClick = goToDurationScreen){
            Text(text = "go to duration sleep screen")
        }


    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewScheduleSleepScreen(){
    ScheduleSleepScreen({},{})
}