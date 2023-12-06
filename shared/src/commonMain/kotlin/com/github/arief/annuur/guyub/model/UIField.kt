package com.github.arief.annuur.guyub.model

sealed class UIField {
    data class Feed(
        val type: UIFieldType,
        val data: List<ItemFeed>
        ): UIField()

    data class Basic(
        val data: List<ItemBasic>
    ): UIField()

    data class Profile(
        val userField: UserField,
        val settings: List<String>
    ): UIField()
}


data class ItemBasic(
    val userField: UserField? = null,
    val title: String
)

data class ItemFeed(
    val image: String,
    val userField: UserField,
    val title: String
)