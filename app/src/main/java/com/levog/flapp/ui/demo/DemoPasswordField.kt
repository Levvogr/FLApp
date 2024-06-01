package com.levog.flapp.ui.demo

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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.levog.flapp.R

@Composable
fun DemoPasswordField(
    password: String,
    onPasswordChange: (String) -> Unit,
    isVisiblePassword: Boolean,
    onPasswordVisibilityChange: () -> Unit
) {

    var passwordVisibility: Boolean by remember { mutableStateOf(isVisiblePassword) }
    DemoField(value=password,
        onValueChange=onPasswordChange,
        label="Пароль",
        placeholder="Введите пароль",
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Go),
        leadingIcon = {
            Icon(Icons.Default.Lock,"Password")
        },
        trailingIcon = {
            IconButton(onClick = {
                passwordVisibility = !passwordVisibility
                onPasswordVisibilityChange()
            }) {
                Icon(painter = if(passwordVisibility){
                    painterResource(id = R.drawable.baseline_visibility_24)
                }else{
                    painterResource(id = R.drawable.baseline_visibility_off_24)
                },
                    contentDescription = "visibility")
            }
        },
        visualTransformation = if(passwordVisibility){
            VisualTransformation.None
        }else{
            PasswordVisualTransformation()
        }
    )
}