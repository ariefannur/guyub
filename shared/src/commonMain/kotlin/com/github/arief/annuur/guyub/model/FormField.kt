package com.github.arief.annuur.guyub.model

sealed class FormField {
    abstract val label: String
    abstract val key: String
    abstract val required: Boolean
    var value: String = ""
    var isError = false
    var message: String = "*Required please fill this field"

    fun initValue() {
        isError = required
        println("isError : $isError")
    }
    data class TextField(override val label: String,
                         val type: TextFieldType,
                         override val key: String,
                         override val required: Boolean = false
    ): FormField() {

        init {
            initValue()
        }
    }

    data class TextFieldOption(override val label: String,
                         val options: List<String>,
                         override val key: String,
                               override val required: Boolean = false
    ): FormField() {
        init {
            initValue()
        }

    }

    data class DatePicker(override val label: String,
                               override val key: String,
                          override val required: Boolean = false
        ): FormField() {
            init {
                initValue()
            }
        }

    data class RadioButton(override val label: String,
                           val options: List<String>,
                           override val key: String,
                           override val required: Boolean = false
        ): FormField() {
            init {
                initValue()
            }
        }
}