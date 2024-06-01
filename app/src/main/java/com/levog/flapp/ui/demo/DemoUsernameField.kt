package com.levog.flapp.ui.demo

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun DemoUsernameField(username: String,
                      onUsernameChange: (String) -> Unit){

    DemoField(value=username,
        onValueChange=onUsernameChange,
        label="Имя пользователя",
        placeholder="Введите имя пользователя",
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next),
        leadingIcon = {
            Icon(Icons.Default.AccountCircle,"Username")
        }
    )
}