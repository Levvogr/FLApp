package com.levog.flapp.ui.components.fields

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.levog.flapp.R

@Composable
fun UsernameField(
    username: String,
    onUsernameChange: (String) -> Unit,
    enabled: Boolean = true
){
    Field(value=username,
        onValueChange=onUsernameChange,
        enabled = enabled,
        label= stringResource(R.string.username),
        placeholder= stringResource(R.string.input_username),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next),
        leadingIcon = {
            Icon(
                Icons.Default.AccountCircle,
                contentDescription = stringResource(R.string.account_circle_description_username)
            )
        }
    )
}