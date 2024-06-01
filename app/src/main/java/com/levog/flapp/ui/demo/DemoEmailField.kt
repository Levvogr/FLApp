package com.levog.flapp.ui.demo

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun DemoEmailField(email: String,
                   onEmailChange: (String) -> Unit)
{

    DemoField(value=email,
        onValueChange=onEmailChange,
        label="e-mail",
        placeholder="Введите e-mail",
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next),
        leadingIcon = {
            Icon(Icons.Default.Email,"Email")
        }
    )
}
