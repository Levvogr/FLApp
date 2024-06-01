package com.levog.flapp.ui.screens.medicalexamination.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
fun MedicalExaminationDetailsScreen(
    goToListScreen: () -> Unit
){
    Scaffold(
        topBar = {
            DemoSmallTopAppBar(
                text = "",
                fontSize= 27.sp,
                goToBackScreen = goToListScreen
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
                        .verticalScroll(rememberScrollState())
                ) {
                    DemoHeaderBlockInfo("Основное")
                    Spacer(modifier = Modifier.padding(bottom = 10.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center
                    ){
                        DemoPartBlockInfo("Тип осмотра","Периодический")
                        Spacer(modifier = Modifier.padding(bottom = 10.dp))
                        DemoPartBlockInfo("Статус","Отменён")
                        Spacer(modifier = Modifier.padding(bottom = 10.dp))
                        DemoPartBlockInfo("Заключение","осмотр не пройден")
                        Spacer(modifier = Modifier.padding(bottom = 10.dp))
                    }
                    Spacer(modifier = Modifier.padding(bottom = 30.dp))
                    DemoHeaderBlockInfo("Дата")
                    Spacer(modifier = Modifier.padding(bottom = 10.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center
                    ){
                        DemoPartBlockInfo("Плановая дата с","-")
                        Spacer(modifier = Modifier.padding(bottom = 10.dp))
                        DemoPartBlockInfo("Плановая дата по","01.01.2000")
                        Spacer(modifier = Modifier.padding(bottom = 10.dp))
                        DemoPartBlockInfo("Дата осмотра","01.01.2000")
                        Spacer(modifier = Modifier.padding(bottom = 10.dp))
                        DemoPartBlockInfo("Дата составления акта","-")
                        Spacer(modifier = Modifier.padding(bottom = 10.dp))
                    }
                    Spacer(modifier = Modifier.padding(bottom = 30.dp))
                    DemoHeaderBlockInfo("Организация")
                    Spacer(modifier = Modifier.padding(bottom = 10.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center
                    ){
                        DemoPartBlockInfo("Медицинская организация","ООО \"М-Лайн\"")
                        Spacer(modifier = Modifier.padding(bottom = 10.dp))
                        DemoPartBlockInfo("Организация","ПАО Детский мир")
                        Spacer(modifier = Modifier.padding(bottom = 10.dp))
                    }
                    Spacer(modifier = Modifier.padding(bottom = 30.dp))
                    DemoHeaderBlockInfo("Врач")
                    Spacer(modifier = Modifier.padding(bottom = 10.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center
                    ){
                        DemoPartBlockInfo("ФИО врача","Петрова Екатерина Сидорона")
                        Spacer(modifier = Modifier.padding(bottom = 10.dp))
                        DemoPartBlockInfo("Специальность врача","Медсестра")
                        Spacer(modifier = Modifier.padding(bottom = 10.dp))
                    }
                    Spacer(modifier = Modifier.padding(bottom = 30.dp))
                    DemoHeaderBlockInfo("Прочее")
                    Spacer(modifier = Modifier.padding(bottom = 10.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center
                    ){
                        DemoPartBlockInfo("Вредные факторы осмотра",
                            "(А1.36.2) Бута-1,3-диен (1,3-бутадиен, дивинил))")
                        Spacer(modifier = Modifier.padding(bottom = 10.dp))
                    }
                }
            }
        }
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMedicalExaminationDetailsScreen(){
    MedicalExaminationDetailsScreen({})
}

@Composable
fun DemoHeaderBlockInfo(
    text:String
){
    Text(
        modifier = Modifier
            .padding(start = 15.dp),
        text = text,
        color = Purple40,
        fontSize = 15.sp,
        fontWeight = FontWeight(700)
    )
}
@Composable
fun DemoPartBlockInfo(
    textFirst:String,
    textSecond:String,
){
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp),
        text = textFirst,
        color = Color.Black,
        fontSize = 15.sp,
        fontWeight = FontWeight(400)
    )
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp),
        text = textSecond,
        color = Color.Gray,
        fontSize = 13.sp,
        fontWeight = FontWeight(400)
    )
}