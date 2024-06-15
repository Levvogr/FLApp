package com.levog.flapp.ui.components.fields

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.levog.flapp.R

@Composable
fun PasswordField(
    password: String,
    onPasswordChange: (String) -> Unit,
    visibilityPassword: Boolean,
    onPasswordVisibilityChange: () -> Unit,
    enabled: Boolean = true
) {

    var passwordVisibility: Boolean by remember { mutableStateOf(visibilityPassword) }
    Field(value=password,
        onValueChange=onPasswordChange,
        enabled = enabled,
        label= stringResource(R.string.password),
        placeholder= stringResource(R.string.input_password),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Go),
        leadingIcon = {
            Icon(Icons.Default.Lock, stringResource(R.string.lock_description_password))
        },
        trailingIcon = {
            IconButton(
                enabled = enabled,
                onClick = {
                passwordVisibility = !passwordVisibility
                onPasswordVisibilityChange()
                }
            ) {
                Icon(painter = if(passwordVisibility){
                    painterResource(id = R.drawable.baseline_visibility_24)
                }else{
                    painterResource(id = R.drawable.baseline_visibility_off_24)
                },
                    contentDescription = stringResource(R.string.visibility_description_visibility)
                )
            }
        },
        visualTransformation = if(passwordVisibility){
            VisualTransformation.None
        }else{
            PasswordVisualTransformation()
        }
    )
}