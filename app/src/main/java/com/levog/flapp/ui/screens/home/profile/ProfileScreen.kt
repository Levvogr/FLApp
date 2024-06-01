package com.levog.flapp.ui.screens.home.profile


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.levog.flapp.ui.demo.DemoSmallTopAppBar
import com.levog.flapp.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    goToHomeScreen: () -> Unit,
    goToAuthenticationScreen: () -> Unit
){

    Scaffold(
        topBar = { DemoSmallTopAppBar(
            text = "Профиль",
            fontSize= 27.sp,
            goToBackScreen = goToHomeScreen
        ) },
        content = {padding ->
            Box(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .fillMaxSize()
                ) {
                    Text(
                        modifier = Modifier
                            .padding(start = 15.dp),
                        text = "Аккаунт",
                        color = Purple40,
                        fontSize = 15.sp,
                        fontWeight = FontWeight(700)
                    )
                    Spacer(modifier = Modifier.padding(bottom = 10.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(width = 0.dp,height = 70.dp)
                            .clickable(onClick = goToAuthenticationScreen),
                        verticalArrangement = Arrangement.Center
                    ){
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 15.dp),
                            text = "Выйти из аккаунта",
                            color = Color.Black,
                            fontSize = 15.sp,
                            fontWeight = FontWeight(400)
                        )
                    }
                }
            }
        }
        
    )
    /*
    Column (
        modifier = Modifier
            .padding(16.dp)
            //.background(Color.Magenta)
            .fillMaxSize()
        ,
        horizontalAlignment= Alignment.CenterHorizontally
    ){
        Text(
            text = "ProfileScreen",
            fontSize = 50.sp,
            modifier = Modifier
            //.background(Color.Blue)

        )
        Spacer(modifier = Modifier.padding(16.dp))
        Button(onClick = goToHomeScreen){
            Text(text = "go to home screen")
        }
        Button(onClick = goToAuthenticationScreen){
            Text(text = "go to auth screen")
        }
    }

     */
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewProfileScreen(){
    ProfileScreen({},{})
}


val CardBackgroundColor = Color(0xFFE6E6E6)

val SecondaryTextColor = Color(0x4C181818)
//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewInformationCard(){
    InformationCard("first name","",{})
}

@Composable
fun InformationCard(
    title: String,
    information: String,
    onTextChange: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(CardBackgroundColor),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)
        ) {
            Text(
                text = title,
                color = SecondaryTextColor,
                //fontFamily = Rubik,
                fontWeight = FontWeight.Normal,
                fontSize = 9.sp
            )
            BasicTextField(
                value = information,
                onValueChange = onTextChange
            )
        }
    }
}
