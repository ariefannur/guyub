package com.github.arief.annuur.guyub.form

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp



val ModifierForm = Modifier.fillMaxWidth().padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)

enum class CustomDialogPosition {
    BOTTOM, TOP
}

fun Modifier.customDialogModifier(pos: CustomDialogPosition) = layout { measurable, constraints ->

    val placeable = measurable.measure(constraints);
    layout(constraints.maxWidth, constraints.maxHeight){
        when(pos) {
            CustomDialogPosition.BOTTOM -> {
                placeable.place(0, constraints.maxHeight - placeable.height, 10f)
            }
            CustomDialogPosition.TOP -> {
                placeable.place(0,0,10f)
            }
        }
    }
}