package com.github.arief.annuur.guyub.form

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.github.arief.annuur.guyub.model.FormField

@Composable
fun GPassword(data: FormField.Password, onChecking: ((String) ->Unit)? = null) {

    var text by remember { mutableStateOf(data.value) }
    var show by remember { mutableStateOf(false) }

    Column {
        Box (
            modifier = ModifierForm,
        ){
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = text,
                onValueChange = {
                    text = it
                    data.value = it
                    onChecking?.invoke(it)
                },
                label = { Text(data.label) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                visualTransformation = if (!show) PasswordVisualTransformation() else VisualTransformation.None,
                isError = data.isError && text.isNotEmpty()
            )
            IconButton(modifier = Modifier.align(Alignment.CenterEnd), onClick = {
                show = !show
            }) {
                Icon(modifier = Modifier.size(16.dp),imageVector = if (show) Icons.Default.Clear else Icons.Default.Check, contentDescription = null)
            }
        }
        if (data.isError) {
            Text(data.message, Modifier.padding(start = 16.dp, end = 16.dp), color = Color.Red)
        }
    }
}