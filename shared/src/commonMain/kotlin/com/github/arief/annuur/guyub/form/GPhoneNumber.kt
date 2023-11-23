package com.github.arief.annuur.guyub.form

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.github.arief.annuur.guyub.model.FormField

@Composable
fun GPhoneNumber(data: FormField.PhoneNumber) {

    var text by remember { mutableStateOf("") }
    var textCode by remember { mutableStateOf("") }

    Column {
        Row (modifier = ModifierForm) {
            OutlinedTextField(
                modifier = Modifier.weight(2f),
                label = { Text("Code") },
                value = textCode,
                onValueChange = {
                    textCode = it
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                isError = textCode.isEmpty()
            )
            Spacer(Modifier.padding(start = 8.dp))
            OutlinedTextField(
                modifier = Modifier.weight(8f),
                value = text,
                onValueChange = {
                    text = it
                    data.value = it
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                label = { Text(data.label) },
                isError = text.isEmpty()
            )
        }

        if (data.isError) {
            Text(data.message, Modifier.padding(start = 16.dp, end = 16.dp), color = Color.Red)
        }
    }
}