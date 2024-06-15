package com.levog.flapp.ui.components.fields

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Composable
fun Field(
    value:String,
    onValueChange: (String) -> Unit,
    enabled: Boolean = true,
    label:String,
    placeholder: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    leadingIcon: @Composable (()->Unit)?=null,
    trailingIcon: @Composable (()->Unit)?=null
){
    OutlinedTextField(
        modifier = Modifier.size(305.dp,65.dp),
        value = value,
        onValueChange = onValueChange,
        enabled = enabled,
        label={
            Text(text=label)
        },
        placeholder={
            Text(text=placeholder)
        },
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon
    )
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
private fun FieldPreview(){
    Field(
        value = "FieldValue",
        onValueChange = {},
        label = "FieldLabel",
        placeholder = "FieldPlaceholder"
    )
}