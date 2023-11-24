package com.github.arief.annuur.guyub.mapper

import com.github.arief.annuur.guyub.model.FormField
import com.github.arief.annuur.guyub.model.LabelType
import com.github.arief.annuur.guyub.model.PasswordType

fun Map<String, Any>.toFormField(): FormField {
    return when(this["type"]) {
        "label" -> FormField.Label(
            this["label"] as String,
            this["key"] as String,
            type = when(this["label-type"] as String) {
                "title" -> LabelType.TITLE
                "subtitle" -> LabelType.SUBTITLE
                "body" -> LabelType.BODY
                else -> LabelType.CAPTION
            }
        )
        "button" -> FormField.Button(
            this["label"] as String,
            this["key"] as String,
            this["required"] as Boolean,
        )
        "email" -> FormField.Email(
            this["label"] as String,
            this["key"] as String,
            this["required"] as Boolean,
        )
        "phone" -> FormField.PhoneNumber(
            this["label"] as String,
            this["key"] as String,
            this["required"] as Boolean,
        )
        "password" -> FormField.Password(
            this["label"] as String,
            this["key"] as String,
            type = PasswordType.PASSWORD,
            required = this["required"] as Boolean,
        )
        "re-password" -> FormField.Password(
            this["label"] as String,
            this["key"] as String,
            type = PasswordType.CHECK_PASSWORD,
            required = this["required"] as Boolean,
        )

        else -> FormField.Button(
            this["label"] as String,
            this["key"] as String,
            this["required"] as Boolean,
        )
    }
}