package com.github.arief.annuur.guyub.form

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.github.arief.annuur.guyub.model.FormField

@Composable
fun GButton(data: FormField.Button, onSubmit: ()-> Unit) {
    Button(
        modifier = ModifierForm.fillMaxWidth().height(48.dp),
        onClick = {
         onSubmit.invoke()
        },
        enabled = data.enable
    ) {
        Text(data.label)
    }
}