package com.levog.flapp.ui.components.appbars.mainbottomappbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.levog.flapp.R


@Composable
fun MainBottomAppBar(
    containerColor: Color,
    contentColor: Color,
    goToMedicalExaminationScreen: () -> Unit,
    goToHealthSleepScreen: () -> Unit,
    goToProfileScreen: () -> Unit,
    goToSettingsScreen: () -> Unit,
){
    BottomAppBar(
        containerColor = containerColor,
        contentColor = contentColor,
        actions = {
            Row (
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround
            ){
                MainBottomAppBarElement(
                    onClick = goToMedicalExaminationScreen,
                    width = 75.dp,
                    painter = painterResource(id = R.drawable.baseline_medical_services_24),
                    painterDescription = stringResource(R.string.examination),
                    text = stringResource(R.string.examination)
                )
                MainBottomAppBarElement(
                    onClick = goToHealthSleepScreen,
                    width = 70.dp,
                    painter = painterResource(id = R.drawable.baseline_bedtime_24),
                    painterDescription = stringResource(R.string.sleep),
                    text = stringResource(R.string.sleep)
                )
                MainBottomAppBarElement(
                    onClick = goToProfileScreen,
                    width = 80.dp,
                    painter = painterResource(id = R.drawable.baseline_person_24),
                    painterDescription = stringResource(R.string.profile),
                    text = stringResource(R.string.profile)
                )
                MainBottomAppBarElement(
                    onClick = goToSettingsScreen,
                    width = 90.dp,
                    painter = painterResource(id = R.drawable.baseline_settings_24),
                    painterDescription = stringResource(R.string.settings),
                    text = stringResource(R.string.settings)
                )
            }

        }
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewMainBottomAppBar() {
    MainBottomAppBar(
        MaterialTheme.colorScheme.tertiary,
        MaterialTheme.colorScheme.onTertiary,
        {},
        {},
        {},
        {})
}