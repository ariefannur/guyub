package com.github.arief.annuur.guyub.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.More
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

object IconsMapper {

    fun getIcon(name: String): ImageVector {
        return when (name) {
            "home" -> Icons.Filled.Home
            "profile" -> Icons.Filled.Person
            "star"-> Icons.Filled.Star
            "burger" -> Icons.Filled.Menu
            "group" -> Icons.Filled.Group
            "add" -> Icons.Filled.Add
            "edit" -> Icons.Filled.Edit
            "submit" -> Icons.Filled.Send
            "option" -> Icons.Filled.More
            else -> Icons.Filled.More
        }
    }
}