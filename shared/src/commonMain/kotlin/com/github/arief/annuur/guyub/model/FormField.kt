package com.github.arief.annuur.guyub.model

sealed class FormField {
    abstract val label: String
    abstract val key: String
    var value: String = ""
    data class TextField(override val label: String,
                         val type: TextFieldType,
                         override val key: String): FormField()

    data class TextFieldOption(override val label: String,
                         val options: List<String>,
                         override val key: String): FormField()

    data class DatePicker(override val label: String,
                               override val key: String): FormField()

    data class RadioButton(override val label: String,
                           val options: List<String>,
                          override val key: String): FormField()
}