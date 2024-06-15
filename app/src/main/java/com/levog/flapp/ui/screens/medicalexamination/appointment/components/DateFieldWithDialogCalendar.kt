package com.levog.flapp.ui.screens.medicalexamination.appointment.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.levog.flapp.extension.toFormattedDateString
import com.levog.flapp.ui.components.calendar.CalendarDialog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateFieldWithDialogCalendar(
    textHeader: String,
    colorTextHeader: Color,
    textValue: String,
    colorTextValue: Color,
    onValueChange: (String) -> Unit,
    textFieldContainerColor: Color,
    enabledAndVisibilityAndCreated: Boolean,
    onClick: () -> Unit,
    shouldDisplayCalendar: Boolean,
    onConfirmClickedCalendar: (Long) -> Unit,
    dismissRequestCalendar: () -> Unit,
    validDates: List<String>,
    modifier: Modifier = Modifier
){

    val datePickerState = rememberDatePickerState(
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                return validDates
                    .contains(utcTimeMillis.toFormattedDateString())
            }

            override fun isSelectableYear(year: Int): Boolean {
                return year >= 2000
            }
        }
    )

    CalendarDialog(
        state = datePickerState,
        shouldDisplay = shouldDisplayCalendar,
        onConfirmClicked = onConfirmClickedCalendar,
        dismissRequest = dismissRequestCalendar
    )

    if(enabledAndVisibilityAndCreated){
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = textHeader,
                color = colorTextHeader
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onClick() },
                readOnly = true,
                value = textValue,
                enabled = false,
                onValueChange = onValueChange,
                colors = TextFieldDefaults
                    .colors(
                        disabledTextColor = colorTextValue,
                        unfocusedContainerColor = textFieldContainerColor,
                        focusedContainerColor = textFieldContainerColor,
                        disabledContainerColor = textFieldContainerColor
                    )
            )
        }
    }


}