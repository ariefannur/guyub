package com.github.arief.annuur.guyub.form

import androidx.compose.foundation.layout.Column
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
import com.github.arief.annuur.guyub.model.TextFieldType

@Composable
fun GTextField(data: FormField.TextField, validField: ((Boolean) -> Unit)? = null) {
    var text by remember { mutableStateOf("") }

    Column {
        OutlinedTextField(
            modifier = ModifierForm,
            value = text,
            onValueChange = {
                text = it
                data.value = it
                validField?.invoke(it.isEmpty())
            },
            label = { Text(data.label) },
            keyboardOptions = KeyboardOptions(
                keyboardType = when (data.type) {
                    TextFieldType.TEXT -> KeyboardType.Text
                    TextFieldType.NOMINAL -> KeyboardType.Decimal
                    else -> KeyboardType.Number
                }
            ),
            isError = text.isEmpty()
        )
        if (text.isEmpty() && data.required) {
            Text(data.message, Modifier.padding(start = 16.dp, end = 16.dp), color = Color.Red)
        }
    }
}

