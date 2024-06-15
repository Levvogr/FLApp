package com.levog.flapp.ui.screens.authentication.authentication.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.levog.flapp.R


@Composable
fun LoginFooter(
    enabledSignInButton: Boolean,
    onSignInClick: () -> Unit,
    enabledSignUpButton: Boolean,
    onSignUpClick: () -> Unit
) {
    Column(horizontalAlignment= Alignment.CenterHorizontally) {
        Button(
            modifier = Modifier.size(210.dp,40.dp),
            onClick = onSignInClick,
            enabled = enabledSignInButton
        ) {
            Text(text = stringResource(R.string.sign_in))
        }
        Spacer(modifier = Modifier.height(150.dp))
        Column(horizontalAlignment= Alignment.CenterHorizontally) {
            Text(text = stringResource(R.string.dont_have_an_account))
            TextButton(
                onClick = onSignUpClick,
                enabled = enabledSignUpButton
            ) {
                Text(text = stringResource(R.string.sign_up))
            }
        }
    }
}
