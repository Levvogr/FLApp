package com.levog.flapp.ui.screens.medicalexamination.list

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.levog.flapp.R
import com.levog.flapp.ui.demo.DemoSmallTopAppBar
import com.levog.flapp.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicalExaminationListScreen(
    goToHomeScreen: () -> Unit,
    goToDetailsScreen: () -> Unit,
    goToAppointmentScreen: () -> Unit
){
    val itemsLC = listOf(listOf("01.01.2000","Отменён", "Периодический","ООО \"М-Лайн\""),
        listOf("01.01.2000","Отменён", "Периодический","ООО \"М-Лайн\""),
        listOf("01.01.2000","Отменён", "Периодический","ООО \"М-Лайн\""),
        listOf("01.01.2000","Отменён", "Периодический","ООО \"М-Лайн\""))
    Scaffold(
        topBar = { DemoSmallTopAppBar(
            text = "Список медосмотров",
            fontSize= 27.sp,
            goToBackScreen = goToHomeScreen
        ) },
        content = {padding ->
            Box(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp)
                ){
                    items(itemsLC){item -> MECard(item[0],item[1],item[2],item[3],goToDetailsScreen )}
                }
            }
        }

    )
}


@Composable
fun MECard(
    date: String,
    status: String,
    type: String,
    medicalOrganization: String,
    goToDetailsScreen: () -> Unit
){
    Card(
        modifier = Modifier
            .clickable(onClick = goToDetailsScreen)
            .fillMaxWidth()
            .padding(5.dp, 10.dp, 5.dp, 10.dp)
            .border(width = 4.dp, color = Purple40, shape = RoundedCornerShape(20.dp)),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(containerColor = Purple40)
    ){
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(width = 4.dp, color = Purple40, shape = RoundedCornerShape(20.dp)),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(5.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ){
            Column (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceBetween
            ){
                Box(
                    modifier = Modifier
                        .padding(0.dp, 3.dp, 0.dp, 0.dp)
                        .fillMaxWidth()
                ){
                    Text(
                        modifier = Modifier
                            .padding(15.dp,2.dp,2.dp,2.dp),
                        color = Color.Black,
                        text = medicalOrganization
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(width = 1.dp, color = Color.Black)
                ){
                    Text(
                        modifier = Modifier
                            .padding(15.dp,2.dp,2.dp,2.dp),
                        color = Color.Black,
                        text = "Тип медосмотра: ${type}"
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        //.border(width = 0.dp, color = Color.Black)
                ){
                    Text(
                        modifier = Modifier
                            .padding(15.dp,2.dp,2.dp,2.dp),
                        color = Color.Black,
                        text = "Дата: ${date}"
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(width = 1.dp, color = Color.Black)
                        .padding(0.dp, 0.dp, 0.dp, 4.dp)
                ){
                    Text(
                        modifier = Modifier
                            .padding(15.dp,2.dp,2.dp,2.dp),
                        color = Color.Black,
                        text = "Статус: ${status}"
                    )
                }
            }

        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .background(Purple40)
        ){
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Подробнее",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight(1000),
                textAlign = TextAlign.Center
            )
        }
    }
    
}

@Preview(showBackground = false, showSystemUi = false)
@Composable
fun PreviewMECard(){
    MECard("01.01.2000","Отменён", "Периодический","ООО \"М-Лайн\"",{})
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMedicalExaminationListScreen(){
    MedicalExaminationListScreen({},{},{})
}

