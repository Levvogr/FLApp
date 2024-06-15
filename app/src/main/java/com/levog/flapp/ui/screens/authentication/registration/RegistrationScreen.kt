package com.levog.flapp.ui.screens.authentication.registration

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.levog.flapp.R
import com.levog.flapp.ui.screens.authentication.registration.components.RegistrationFields
import com.levog.flapp.ui.screens.authentication.registration.components.RegistrationFooter
import com.levog.flapp.ui.screens.authentication.registration.components.RegistrationHeader


@Composable
fun RegistrationScreen(
    goToHomeScreen: () -> Unit,
    goToAuthenticationScreen: () -> Unit,
    registrationViewModel: RegistrationViewModel
) {
    val registrationUiState by registrationViewModel.uiState.collectAsState()
    val context: Context = LocalContext.current

    if(registrationViewModel.isRegistered){
        registrationViewModel.updateFalseIsRegistered()
        goToHomeScreen()
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(35.dp)
            .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween){
            RegistrationHeader()
            Spacer(modifier = Modifier.height(5.dp))
            RegistrationFields(
                username = registrationUiState.username,
                onUsernameChange =  {registrationViewModel.updateUsername(it)},
                enabledUsernameField = registrationUiState.enabledUsernameField,
                email = registrationUiState.email,
                onEmailChange =  {registrationViewModel.updateEmail(it)},
                enabledEmailField = registrationUiState.enabledEmailField,
                password = registrationUiState.password,
                onPasswordChange={ registrationViewModel.updatePassword(it)},
                enabledPasswordField = registrationUiState.enabledPasswordField,
                visibilityPassword = registrationUiState.isVisiblePassword,
                onVisibilityPasswordChange = {registrationViewModel.inversionIsVisiblePassword()},
                errorMessage =  registrationViewModel.errorMessage
            )
            RegistrationFooter(
                enabledSignUpButton = registrationUiState.enabledRegistrationButton,
                onSignUpClick = {
                    registrationViewModel.updateErrorMessage("")
                    if(registrationViewModel.fieldsIsNotFilled()){
                        registrationViewModel.updateErrorMessage(context.getString(R.string.error_message_fields_is_not_filled))
                    } else{
                        registrationViewModel.registration(context.getString(R.string.error_message_connection_api))
                    }
                },
                enabledSignInButton = registrationUiState.enabledGoToAuthenticationButton,
                onSignInClick = {
                    registrationViewModel.blockAllElements()
                    goToAuthenticationScreen()
                    registrationViewModel.updateErrorMessage("")
                    registrationViewModel.unblockAllElements()
                }
            )
        }
    }
}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewRegistrationScreen(){
    RegistrationScreen({},{}, viewModel())
}