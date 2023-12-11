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
    }

    data class Button(
        override val label: String,
        override val key: String,
        override val required: Boolean = false,
        val enable: Boolean,
        val buttonType: ButtonType = ButtonType.PRIMARY
    ): FormField()

    data class Label(
        override val label: String,
        override val key: String,
        override val required: Boolean = false,
        val type: LabelType
    ): FormField()

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

    data class Password(
        override val label: String,
        override val key: String,
        val type: PasswordType = PasswordType.PASSWORD,
        override val required: Boolean
    ) : FormField()

    data class PhoneNumber(
        override val label: String,
        override val key: String,
        override val required: Boolean
    ) : FormField()

    data class Email(
        override val label: String,
        override val key: String,
        override val required: Boolean
    ) : FormField()
}