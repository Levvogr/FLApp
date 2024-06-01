package com.levog.flapp.ui.screens.home.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.levog.flapp.ui.demo.DemoSmallTopAppBar
import com.levog.flapp.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(goToHomeScreen: () -> Unit){
    Scaffold(
        topBar = { DemoSmallTopAppBar(
            text = "Настройки",
            fontSize= 27.sp,
            goToBackScreen = goToHomeScreen
        ) },
        content = {padding ->
            Box(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .fillMaxSize()
                ) {
                    Text(
                        modifier = Modifier
                            .padding(start = 15.dp),
                        text = "Экран",
                        color = Purple40,
                        fontSize = 15.sp,
                        fontWeight = FontWeight(700)
                    )
                    Spacer(modifier = Modifier.padding(bottom = 10.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(width = 0.dp,height = 70.dp)
                            .clickable(onClick = {}),
                        verticalArrangement = Arrangement.Center
                    ){
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 15.dp),
                            text = "Тема",
                            color = Color.Black,
                            fontSize = 15.sp,
                            fontWeight = FontWeight(400)
                        )
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 15.dp),
                            text = "По умолчанию",
                            color = Color.Gray,
                            fontSize = 13.sp,
                            fontWeight = FontWeight(400)
                        )
                    }
                }
            }
        }
    )
    /*
    Column (
        modifier = Modifier
            .padding(16.dp)
            //.background(Color.Magenta)
            .fillMaxSize()
        ,
        horizontalAlignment= Alignment.CenterHorizontally
    ){
        Text(
            text = "SettingsScreen",
            fontSize = 50.sp,
            modifier = Modifier
            //.background(Color.Blue)

        )
        Spacer(modifier = Modifier.padding(16.dp))
        Button(onClick = goToHomeScreen){
            Text(text = "go to home screen")
        }


    }

     */
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewSettingsScreen(){
    SettingsScreen({})
}