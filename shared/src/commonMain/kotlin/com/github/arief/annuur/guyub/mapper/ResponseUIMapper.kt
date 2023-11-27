package com.github.arief.annuur.guyub.mapper

import com.github.arief.annuur.guyub.model.UIField
import com.github.arief.annuur.guyub.model.UIFieldType
import com.github.arief.annuur.guyub.model.UserField

fun Map<String, Any>.toUIField(): UIField {
    return when(this["ui-type"]) {
        "feed" -> UIField.Feed(
            type = when(this["feed-type"]) {
                "grid" -> UIFieldType.GRID
                else -> UIFieldType.LIST
            },
            data = listOf()
        )
        "basic" -> UIField.Basic(
            data = listOf()
        )
        else -> UIField.Profile(
            userField = UserField(
                "","", ""
            ),
            settings = listOf()
        )
    }
}