package com.levog.flapp.ui.screens.authentication.registration.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.levog.flapp.ui.components.fields.EmailField
import com.levog.flapp.ui.components.fields.PasswordField
import com.levog.flapp.ui.components.fields.UsernameField

@Composable
fun RegistrationFields(
    username: String,
    onUsernameChange: (String) -> Unit,
    enabledUsernameField: Boolean,
    email: String,
    onEmailChange: (String) -> Unit,
    enabledEmailField: Boolean,
    password: String,
    onPasswordChange: (String) -> Unit,
    enabledPasswordField: Boolean,
    visibilityPassword: Boolean,
    onVisibilityPasswordChange:() -> Unit,
    errorMessage: String
) {
    Column(horizontalAlignment= Alignment.CenterHorizontally) {
        UsernameField(
            username = username,
            onUsernameChange = onUsernameChange,
            enabled = enabledUsernameField
        )
        EmailField(
            email = email,
            onEmailChange = onEmailChange,
            enabled = enabledEmailField
        )
        PasswordField(
            password = password,
            onPasswordChange =  onPasswordChange,
            visibilityPassword = visibilityPassword,
            onPasswordVisibilityChange = onVisibilityPasswordChange,
            enabled = enabledPasswordField
        )
        Text(modifier = Modifier.padding(25.dp,10.dp),
            color= MaterialTheme.colorScheme.error,
            textAlign= TextAlign.Start,
            text = errorMessage)
    }
}
