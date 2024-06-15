package com.levog.flapp.ui.screens.medicalexamination.appointment.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecurrenceDropdownMenu(
    textHeader: String,
    colorTextHeader: Color,
    values: List<String>,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    onDismissRequestDropdownMenu: () -> Unit,
    onClickDropdownMenu: (String) -> Unit,
    selectedOptionText: String,
    textFieldColor: Color,
    modifier: Modifier = Modifier,
    enabledAndVisibilityAndCreated: Boolean = true
) {
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

            ExposedDropdownMenuBox(
                modifier = Modifier
                    .fillMaxWidth(),
                expanded = expanded,
                onExpandedChange = onExpandedChange,
            ) {
                TextField(
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth(),
                    readOnly = true,
                    value = selectedOptionText,
                    onValueChange = {},
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    colors = TextFieldDefaults
                        .colors(
                            unfocusedContainerColor = textFieldColor,
                            focusedContainerColor = textFieldColor,
                        )
                )
                ExposedDropdownMenu(
                    modifier = Modifier
                        .fillMaxWidth(),
                    expanded = expanded,
                    onDismissRequest = onDismissRequestDropdownMenu,
                ) {
                    values.forEach { selectionOption ->
                        DropdownMenuItem(
                            text = { Text(selectionOption) },
                            onClick = {
                                onClickDropdownMenu(selectionOption)
                            }
                        )
                    }
                }
            }
        }
    }
}