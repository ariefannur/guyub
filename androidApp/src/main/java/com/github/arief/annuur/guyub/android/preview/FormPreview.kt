package com.github.arief.annuur.guyub.android.preview

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.github.arief.annuur.guyub.form.GDatePicker
import com.github.arief.annuur.guyub.form.GRadioButton
import com.github.arief.annuur.guyub.form.GTextField
import com.github.arief.annuur.guyub.form.GTextFieldOption
import com.github.arief.annuur.guyub.model.FormField
import com.github.arief.annuur.guyub.model.TextFieldType

@Preview
@Composable
fun PreviewTextField() {
    Column {
        GTextField(FormField.TextField(
            "Input Number",
            TextFieldType.NUMBER,
            ""
        ))
        GTextField(FormField.TextField(
            "Input Nominal",
            TextFieldType.NOMINAL, ""
        ))
        GTextField(FormField.TextField(
            "Input Text",
            TextFieldType.TEXT,""
        ))
        GTextFieldOption(FormField.TextFieldOption(label = "Option", options = listOf(
            "Option 1",
            "Option 2",
            "Option 3",
            "Option 4",
        ), key = ""))
        GDatePicker(FormField.DatePicker(
            "Input Tanggal",
            ""
        ))
        GRadioButton(FormField.RadioButton(label = "Select option below", options = listOf(
            "Option 1",
            "Option 2",
            "Option 3",
            "Option 4",
        ), key = ""))
        GRadioButton(FormField.RadioButton(label = "Pilih salah satu", options = listOf(
            "Option 1",
            "Option 2",
            "Option 3",
            "Option 4",
            "Option 5",
            "Option 6",
            "Option 7",
        ), key = ""))
    }
}