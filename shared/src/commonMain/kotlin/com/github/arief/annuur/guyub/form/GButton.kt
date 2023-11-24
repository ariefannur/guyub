package com.github.arief.annuur.guyub.form

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.github.arief.annuur.guyub.model.FormField

@Composable
fun GButton(data: FormField.Button, onSubmit: ()-> Unit) {
    Button(
        modifier = ModifierForm.fillMaxWidth().background(color = MaterialTheme.colors.primary,shape = MaterialTheme.shapes.medium),
        onClick = {
         onSubmit.invoke()
        },
        enabled = data.enable
    ) {
        Text(data.label)
    }
}