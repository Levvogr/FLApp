package com.levog.flapp.ui.screens.medicalexamination.list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.levog.flapp.R
import com.levog.flapp.data.room.medicalexamination.MedicalExaminationData
import com.levog.flapp.extension.toFormattedDateString
import com.levog.flapp.extension.toFormattedTimeString
import com.levog.flapp.extension.toLong
import java.time.LocalDate
import java.time.LocalTime

@Composable
fun MedicalExaminationCard(
    medicalExamination: MedicalExaminationData,
    goToDetailsScreen: (Int) -> Unit
){
    Card(
        modifier = Modifier
            .clickable(onClick = {
                goToDetailsScreen(medicalExamination.id)
            })
            .fillMaxWidth()
            .padding(5.dp, 10.dp, 5.dp, 10.dp)
            .border(
                width = 4.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(20.dp)
            ),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
    ){
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 4.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(20.dp)
                ),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(5.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background
            )
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
                        color =  MaterialTheme.colorScheme.onBackground,
                        text = medicalExamination.medicalOrganization
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                ){
                    Text(
                        modifier = Modifier
                            .padding(15.dp,2.dp,2.dp,2.dp),
                        color = MaterialTheme.colorScheme.onBackground,
                        text = stringResource(R.string.type_medical_examination) +
                                ": ${medicalExamination.typeExamination}"
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Text(
                        modifier = Modifier
                            .padding(15.dp,2.dp,2.dp,2.dp),
                        color = MaterialTheme.colorScheme.onBackground,
                        text = stringResource(R.string.date)+
                                ": ${medicalExamination.dateExamination.toFormattedDateString()}"+" "+
                                LocalTime.of(medicalExamination.hourExamination,
                                    medicalExamination.minuteExamination).toFormattedTimeString()
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(width = 1.dp, color = MaterialTheme.colorScheme.onBackground)
                        .padding(0.dp, 0.dp, 0.dp, 4.dp)
                ){
                    Text(
                        modifier = Modifier
                            .padding(15.dp,2.dp,2.dp,2.dp),
                        color = MaterialTheme.colorScheme.onBackground,
                        text = stringResource(R.string.status)+
                                ": ${medicalExamination.status}"
                    )
                }
            }

        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .background(MaterialTheme.colorScheme.primary)
        ){
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = stringResource(R.string.details),
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 18.sp,
                fontWeight = FontWeight(1000),
                textAlign = TextAlign.Center
            )
        }
    }

}

@Preview(showBackground = false, showSystemUi = false)
@Composable
private fun PreviewMedicalExaminationCard(){
    MedicalExaminationCard(
        MedicalExaminationData(
            typeExamination ="Периодический",
            status = "Отменён",
            conclusion = "Осмотр не пройден",
            medicalOrganization ="ООО \"М-Лайн\"",
            organization ="ПАО Детский мир",
            fullNameDoctor = "Петрова Екатерина Сидорона",
            medicalSpecialty ="Медсестра",
            harmfulFactorsExamination ="(А1.36.2) Бута-1,3-диен (1,3-бутадиен, дивинил))",
            plannedDateFrom = null,
            plannedDateFor = LocalDate.of(2020,1,1).toLong(),
            dateExamination = LocalDate.of(2020,1,1).toLong(),
            datePreparationAct = null,
            hourExamination = 10,
            minuteExamination = 30
        )
        ,{})
}