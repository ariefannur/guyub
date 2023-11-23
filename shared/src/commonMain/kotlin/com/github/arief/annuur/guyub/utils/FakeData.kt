package com.github.arief.annuur.guyub.utils

import com.github.arief.annuur.guyub.model.FormField
import com.github.arief.annuur.guyub.model.PasswordType
import com.github.arief.annuur.guyub.model.TextFieldType

object FakeData {

    val singleFormData = listOf<FormField>(
        FormField.TextField(
            "Input Number",
            TextFieldType.NUMBER,
            "input_number",
            true
        ),
        FormField.TextField(
            "Input Nominal",
            TextFieldType.NOMINAL,
            "input_nominal",
            true
        ),
        FormField.TextField(
            "Input Text",
            TextFieldType.TEXT,
            "input_text",
            true
        ),
        FormField.TextFieldOption(label = "Option", options = listOf(
            "Option 1",
            "Option 2",
            "Option 3",
            "Option 4",
        ), key = "option_1"),
        FormField.DatePicker(
            "Input Tanggal",
            "date"
        ),
        FormField.RadioButton(label = "Select option below", options = listOf(
            "Option 1",
            "Option 2",
            "Option 3",
        ), key = "radio_1"),
        FormField.RadioButton(label = "Pilih salah satu", options = listOf(
            "Option 1",
            "Option 2",
            "Option 3",
            "Option 4",
            "Option 5",
            "Option 6",
            "Option 7",
        ), key = "radio_2")
    )

    val sampleAuthForm = listOf(
        FormField.PhoneNumber("Phone Number", "phone_number", true),
        FormField.Email("Email", "email", true).apply {
           message = "Wrong email format"
        },
        FormField.Password("Password", "password", required = true),
        FormField.Password("Retype Password", "password", type = PasswordType.CHECK_PASSWORD,required = true)
    )
}