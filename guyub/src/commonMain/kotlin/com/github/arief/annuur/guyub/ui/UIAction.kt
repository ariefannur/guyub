package com.github.arief.annuur.guyub.ui

import com.github.arief.annuur.guyub.model.ItemBasic
import com.github.arief.annuur.guyub.model.ItemFeed

sealed class UIAction {
    data class ActionFeed(val item: ItemFeed): UIAction()
    data class ActionBasic(val item: ItemBasic): UIAction()
    data class ActionProfile(val item: String): UIAction()
}