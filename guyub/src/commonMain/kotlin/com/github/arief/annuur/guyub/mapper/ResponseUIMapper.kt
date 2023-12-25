package com.github.arief.annuur.guyub.mapper

import com.github.arief.annuur.guyub.model.ItemBasic
import com.github.arief.annuur.guyub.model.ItemFeed
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
            data = (this["data"] as List<Map<String, Any>>).map {
                it.toFeedField()
            }
        )
        "basic" -> {
            UIField.Basic(
                data = (this["data"] as List<Map<String, Any>>).map {
                    it.toBasicField()
                }
            )
        }
        else -> UIField.Profile(
            userField = UserField(
                username = (this["user"] as Map<*, *>) ["username"] as String,
                imgAvatar = (this["user"] as Map<*, *>) ["avatar"] as String,
                realName = (this["user"] as Map<*, *>) ["realname"] as String,
            ),
            settings = this["data"] as List<String>
        )
    }
}

fun Map<String, Any>.toBasicField(): ItemBasic {
    return ItemBasic(
        title = this["title"] as String,
        userField = UserField(
            username = (this["user"] as Map<*, *>) ["username"] as String,
            imgAvatar = (this["user"] as Map<*, *>) ["avatar"] as String,
            realName = (this["user"] as Map<*, *>) ["realname"] as String,
        )
    )
}

fun Map<String, Any>.toFeedField(): ItemFeed {
    return ItemFeed(
        title = this["title"] as String,
        image = this["image"] as String,
        userField = UserField(
            username = (this["user"] as Map<*, *>) ["username"] as String,
            imgAvatar = (this["user"] as Map<*, *>) ["avatar"] as String,
            realName = (this["user"] as Map<*, *>) ["realname"] as String,
        )
    )
}
