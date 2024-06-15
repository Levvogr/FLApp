package com.levog.flapp.ui.screens.healthsleep.start.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.levog.flapp.R
import com.levog.flapp.data.room.sleep.SleepData
import com.levog.flapp.extension.toFormattedDateString
import com.levog.flapp.extension.toFormattedDateStringFull
import com.levog.flapp.extension.toFormattedTimeString
import com.levog.flapp.ui.components.information.InformationHeader
import com.levog.flapp.ui.components.information.InformationWithDescriptionElement
import com.levog.flapp.ui.screens.medicalexamination.list.components.MedicalExaminationCard
import java.time.LocalDate

@Composable
fun InformationSleepLatestDaysElement(
    items: List<SleepData>,
    countDays: Int,
    modifier: Modifier = Modifier,
    heightElements: Dp = 80.dp
){
    Column(
        modifier = modifier
    ){
        val ld = LocalDate.now()
        InformationHeader(
            text = stringResource(R.string.latest_data),
            colorText = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.padding(bottom = 10.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            reverseLayout = false
        ){
            items(
                items = items/*.subList(0,countDays)*/,
                key = {it.id}
            ){item ->
                InformationSleepIntervalAndDurationElement(
                    textDate = item.endSleep.toFormattedDateString(),
                    colorTextDate = MaterialTheme.colorScheme.onBackground,
                    colorTextSleep = MaterialTheme.colorScheme.inverseOnSurface,
                    sleepInterval = if(item.startSleep == null){
                        stringResource(R.string.no_latest_data)
                    } else {
                        "${item.startSleep.toFormattedTimeString()}-${item.endSleep.toFormattedTimeString()}"
                    },
                    durationSleep = if(item.startSleep == null){
                        stringResource(R.string.no_latest_data)
                    } else {
                        (item.endSleep - item.startSleep).toFormattedTimeString()
                    },
                )
                Spacer(modifier = Modifier.padding(5.dp))
            }
        }
    }
}