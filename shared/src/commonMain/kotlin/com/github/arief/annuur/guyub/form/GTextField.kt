package com.github.arief.annuur.guyub.form

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import com.github.arief.annuur.guyub.model.FormField
import com.github.arief.annuur.guyub.model.TextFieldType

@Composable
fun GTextField(data: FormField.TextField) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = ModifierForm,
        value = text,
        onValueChange = { text = it },
        label = { Text(data.label) },
        keyboardOptions = KeyboardOptions(
            keyboardType = when(data.type) {
                TextFieldType.TEXT -> KeyboardType.Text
                TextFieldType.NOMINAL -> KeyboardType.Decimal
                else -> KeyboardType.Number
            }
        )
    )
}

