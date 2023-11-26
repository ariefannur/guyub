package com.github.arief.annuur.guyub.form

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.github.arief.annuur.guyub.model.FormField
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.MaterialDialogButtons
import com.vanpra.composematerialdialogs.datetime.date.DatePickerDefaults
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import kotlinx.datetime.DayOfWeek

@Composable
fun GDatePicker(
    data: FormField.DatePicker,
    validField: ((Boolean) -> Unit)? = null
) {
    var text by remember { mutableStateOf("") }
    var showDate by remember { mutableStateOf(false) }
    val dialogState = rememberMaterialDialogState()

    Column {
        Box(modifier = ModifierForm) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().onFocusChanged {
                    if (it.isFocused) {
                        dialogState.show()
                    }
                },
                readOnly = true,
                value = text,
                onValueChange = {
                    text = it
                    data.value = it
                    validField?.invoke(it.isNotEmpty())
                },
                label = { Text(data.label) },
                isError = text.isEmpty()
            )
            IconButton(modifier = Modifier.align(Alignment.CenterEnd), onClick = {
                dialogState.show()
            }) {
                Icon(
                    imageVector = Icons.Filled.DateRange,
                    modifier = Modifier.size(16.dp),
                    contentDescription = "GDatePicker_${data.label}"
                )
            }
        }
        if (text.isEmpty() && data.required) {
            Text(data.message, Modifier.padding(start = 16.dp, end = 16.dp), color = Color.Red)
        }
    }

    MaterialDialog(dialogState = dialogState, buttons = {
        this.defaultDateTimeDialogButtons()
    }) {
        datepicker(colors = DatePickerDefaults.colors(headerBackgroundColor = Color.Red)) {
            text = "${it.dayOfMonth}-${it.monthNumber}-${it.year}"
            data.value = text
        }
    }

}

@Composable
private fun MaterialDialogButtons.defaultDateTimeDialogButtons() {
    positiveButton("Ok")
    negativeButton("Cancel")
}