package com.levog.flapp.ui.components.fields

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.levog.flapp.R

@Composable
fun EmailField(
    email: String,
    onEmailChange: (String) -> Unit,
    enabled: Boolean = true
) {

    Field(value=email,
        onValueChange=onEmailChange,
        enabled = enabled,
        label= stringResource(R.string.e_mail),
        placeholder= stringResource(R.string.input_e_mail),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next),
        leadingIcon = {
            Icon(
                Icons.Default.Email,
                contentDescription = stringResource(R.string.e_mail)
            )
        }
    )
}
@Preview
@Composable
private fun EmailFieldPreview(){
    EmailField("",{})
}
