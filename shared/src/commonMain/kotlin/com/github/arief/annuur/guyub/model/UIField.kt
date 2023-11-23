package com.github.arief.annuur.guyub.model

sealed class UIField {
    data class Feed(val type: UIFieldType,
                    val image: String,
                    val userField: UserField,
                    val title: String
        ): UIField()

    data class Basic(
        val userField: UserField,
        val title: String
    ): UIField()
}