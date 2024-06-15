package com.levog.flapp.ui.screens.authentication.authentication

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.levog.flapp.R
import com.levog.flapp.ui.AppViewModelProvider
import com.levog.flapp.ui.screens.authentication.authentication.components.LoginFields
import com.levog.flapp.ui.screens.authentication.authentication.components.LoginFooter
import com.levog.flapp.ui.screens.authentication.authentication.components.LoginHeader
import com.levog.flapp.ui.screens.authentication.registration.RegistrationViewModel


@Composable
fun AuthenticationScreen(
    goToHomeScreen: () -> Unit,
    goToRegistrationScreen: () -> Unit,
    authenticationViewModel: AuthenticationViewModel = viewModel()
) {
    val authenticationUiState by authenticationViewModel.uiState.collectAsState()
    val context: Context = LocalContext.current


    if(authenticationViewModel.isAuthenticated){
        authenticationViewModel.updateFalseIsAuthenticated()
        goToHomeScreen()
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(35.dp)
                .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween){
            LoginHeader()
            Spacer(modifier = Modifier.height(70.dp))
            LoginFields(
                username = authenticationUiState.username,
                onUsernameChange =  {authenticationViewModel.updateUsername(it)},
                enabledUsernameField = authenticationUiState.enabledUsernameField,
                password = authenticationUiState.password,
                onPasswordChange={ authenticationViewModel.updatePassword(it)},
                enabledPasswordField = authenticationUiState.enabledPasswordField,
                visibilityPassword = authenticationUiState.isVisiblePassword,
                onVisibilityPasswordChange = {authenticationViewModel.inversionIsVisiblePassword()},
                errorMessage =  authenticationViewModel.errorMessage
            )


            LoginFooter(
                enabledSignInButton = authenticationUiState.enabledAuthenticationButton,
                onSignInClick = {
                    authenticationViewModel.updateErrorMessage("")
                    if(authenticationViewModel.fieldsIsNotFilled()){
                        authenticationViewModel.updateErrorMessage(context.getString(R.string.error_message_fields_is_not_filled))
                    } else{
                        authenticationViewModel.authentication(context.getString(R.string.error_message_connection_api))
                    }
                },
                enabledSignUpButton = authenticationUiState.enabledGoToRegistrationButton,
                onSignUpClick = {
                    authenticationViewModel.blockAllElements()
                    goToRegistrationScreen()
                    authenticationViewModel.updateErrorMessage("")
                    authenticationViewModel.unblockAllElements()
                }
            )
        }
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewAuthenticationScreen(){
    AuthenticationScreen({},{})
}