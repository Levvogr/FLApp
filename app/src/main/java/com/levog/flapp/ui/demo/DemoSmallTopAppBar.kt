package com.levog.flapp.ui.demo

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoSmallTopAppBar(
    text:String,
    fontSize: TextUnit = 18.sp,
    goToBackScreen: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = text, fontSize = fontSize)
        },
        navigationIcon = {
            IconButton(onClick = goToBackScreen) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "back to navigation"
                )
            }
        }

        )
}

@Preview(showBackground = true)
@Composable
fun PreviewTopBar() {
    DemoSmallTopAppBar("text", 18.sp, {})
}