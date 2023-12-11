package com.github.arief.annuur.guyub.form

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.arief.annuur.guyub.model.ButtonType
import com.github.arief.annuur.guyub.model.FormField

@Composable
fun GButton(data: FormField.Button, modifier: Modifier? = null , onSubmit: ()-> Unit) {
    val buttonStyle = when(data.buttonType) {
        ButtonType.PRIMARY -> ButtonDefaults.buttonColors()
        ButtonType.SECONDARY -> ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.secondary
        )
        ButtonType.TERTIARY -> ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.onSurface
        )
    }
    Button(
        modifier = modifier?.height(48.dp) ?: ModifierForm.height(48.dp),
        onClick = {
         onSubmit.invoke()
        },
        enabled = data.enable,
        colors = buttonStyle
    ) {
        Text(data.label)
    }
}