package com.levog.flapp.ui.components.calendar

import android.app.DatePickerDialog

import android.os.Build
import android.widget.DatePicker
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.ui.res.stringResource
import com.levog.flapp.R
import java.time.DayOfWeek
import java.time.Instant
import java.time.ZoneId
import java.util.Calendar
import java.util.TimeZone

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarDialog(
    state: DatePickerState,
    shouldDisplay: Boolean,
    onConfirmClicked: (selectedDateInMillis: Long) -> Unit,
    dismissRequest: () -> Unit
) {
    if (shouldDisplay) {
        DatePickerDialog(
            onDismissRequest = dismissRequest ,
            confirmButton = {
                Button(
                    modifier = Modifier.padding(0.dp, 0.dp, 8.dp, 0.dp),
                    onClick = {
                        state.selectedDateMillis?.let {
                            onConfirmClicked(it)
                        }
                        dismissRequest()
                    }
                ) {
                    Text(text = stringResource(R.string.select))
                }
            },
            dismissButton = {
                TextButton(onClick = dismissRequest) {
                    Text(text = stringResource(R.string.cancel))
                }
            },
            content = {
                DatePicker(
                    state = state,
                    showModeToggle = false
                )
            }
        )
    }
}