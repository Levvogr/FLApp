package com.levog.flapp.ui.screens.authentication.authentication

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.levog.flapp.R
import com.levog.flapp.ui.demo.DemoPasswordField
import com.levog.flapp.ui.demo.DemoUsernameField


@Composable
fun AuthenticationScreen(
    goToHomeScreen: () -> Unit,
    goToRegistrationScreen: () -> Unit,
    authenticationViewModel: AuthenticationViewModel = viewModel()
) {
    val authenticationUiState by authenticationViewModel.uiState.collectAsState()
    val context: Context = LocalContext.current

//    var token = remember(){
//        mutableStateOf("Ожидание токена")
//    }


    /*
    Пример правильных данных
    "username": "user222",
  "email": "shtigun@yandex.ru",
  "password": "Shtigun1999M"

  "username": "testUser",
  "email": "testUser@yandex.ru",
  "password": "testUser123"
     */
//    var username by remember {
//        mutableStateOf("user222")
//    }
//    var password by remember {
//        mutableStateOf("Shtigun1999M")
//    }
//    var errorMessage = remember {
//        mutableStateOf("")
//    }
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
            password = authenticationUiState.password,
            onPasswordChange={ authenticationViewModel.updatePassword(it)},
            isVisiblePassword = authenticationUiState.isVisiblePassword,
            onIsVisiblePasswordChange = {authenticationViewModel.inversionIsVisiblePassword()},
            errorMessage =  authenticationViewModel.errorMessage
        )


        LoginFooter(onSignInClick = {
            if(authenticationViewModel.fieldsIsNotFilled()){
                authenticationViewModel.updateErrorMessage(context.getString(R.string.error_message_fields_is_not_filled))
            }
            else if(true/*добавь проверку авторизаци*/){
                //Auth(token,username,password,contxet)
                //authenticationViewModel.updateErrorMessage(context.getString(R.string.error_message_connection_api))


                goToHomeScreen()
                authenticationViewModel.updateErrorMessage("")

            }
        },//goToHomeScreen,
            onSignUpClick = {
                goToRegistrationScreen()
                authenticationViewModel.updateErrorMessage("")
            }/*onSignInClick={

            if(username.equals("")||password.equals("")){
                errorMessage.value="Не все поля заполнены"
            }else{
                errorMessage.value=""
                Auth(token,username,password,context)
                /*val intent = Intent(context, ResultActivity::class.java)
                intent.putExtra("token", token.value)
                context.startActivity(intent)*/
            }


        },
            onSignUpClick={}//{
                //context.startActivity(Intent(context, RegistrationActivity::class.java))
            //})
        */)
    }
}

@Composable
fun LoginHeader()
{
    Column {
        Text(text="Войдите в аккаунт",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold)
    }
}

@Composable
fun LoginFields(
    username: String,
    onUsernameChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    isVisiblePassword: Boolean,
    onIsVisiblePasswordChange:() -> Unit,
    errorMessage: String
) {


    Column(horizontalAlignment= Alignment.CenterHorizontally) {
        DemoUsernameField(username, onUsernameChange)
        DemoPasswordField(password, onPasswordChange, isVisiblePassword, onIsVisiblePasswordChange)
        Text(
            modifier = Modifier.padding(25.dp,10.dp),
            color= Color.Red,
            textAlign= TextAlign.Start,
            text = errorMessage
        )
    }
}

@Composable
fun LoginFooter(
    onSignInClick: () -> Unit,
    onSignUpClick: () -> Unit
) {
    Column(horizontalAlignment= Alignment.CenterHorizontally) {
        Button(modifier = Modifier.size(210.dp,40.dp),
            onClick = onSignInClick) {
            Text(text = "Войти")
        }
        Spacer(modifier = Modifier.height(150.dp))
        Column(horizontalAlignment= Alignment.CenterHorizontally) {
            Text(text = "Ещё нет аккаунта?")
            TextButton(onClick = onSignUpClick) {
                Text(text = "Зарегистрироваться")
            }
        }
    }
}


fun Auth(
    tokenString: String,
    username: String,
    password: String
) {

    //val intent = Intent(context, ResultActivity::class.java)
/*
    val client=RetrofitClient().getClient()
    val api=client.create(AuthenticationApi::class.java)
    CoroutineScope(Dispatchers.IO).launch {
        try {
            tokenString.value =api.authorisation(
                AuthorisationRequest(username,password))
                .token
        }
        catch (e: Exception) {
            tokenString.value ="Ошибка подключения к api или введены неверные данные"
        }
        //intent.putExtra("token", tokenString.value)
        //context.startActivity(intent)
    }
    */

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewAuthenticationScreen(){
    AuthenticationScreen({},{})
}