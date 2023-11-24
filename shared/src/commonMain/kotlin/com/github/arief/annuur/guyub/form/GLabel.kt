package com.github.arief.annuur.guyub.form

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.github.arief.annuur.guyub.model.FormField
import com.github.arief.annuur.guyub.model.LabelType

@Composable
fun GLabel(data: FormField.Label) {
    Text(modifier = ModifierForm,
        text = data.label,
        style = when(data.type) {
            LabelType.TITLE -> MaterialTheme.typography.h5
            LabelType.SUBTITLE -> MaterialTheme.typography.subtitle1
            LabelType.BODY -> MaterialTheme.typography.body1
            LabelType.CAPTION -> MaterialTheme.typography.caption
        }
    )
}