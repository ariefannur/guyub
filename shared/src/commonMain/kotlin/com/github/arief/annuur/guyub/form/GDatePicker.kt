package com.github.arief.annuur.guyub.form

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.github.arief.annuur.guyub.model.FormField

@Composable
fun GDatePicker(
    data: FormField.DatePicker
) {
    var text by remember { mutableStateOf("") }
    var showDate by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    Box(modifier = ModifierForm) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().onFocusChanged {
                if (it.isFocused) {
                    showDate = true
                    focusManager.clearFocus()
                }
            },
            value = text,
            onValueChange = { text = it },
            label = { Text(data.label) },
        )
        Icon(imageVector = Icons.Filled.DateRange, modifier = Modifier.align(Alignment.CenterEnd).padding(end = 8.dp).clickable {
            showDate = true
        }, contentDescription = "GDatePicker_${data.label}")
    }

    if (showDate) {

    }
}