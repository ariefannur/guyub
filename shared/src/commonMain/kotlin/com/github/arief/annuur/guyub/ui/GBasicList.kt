package com.github.arief.annuur.guyub.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.github.arief.annuur.guyub.model.ItemBasic
import com.github.arief.annuur.guyub.model.UIField

@Composable
fun GBasicList(data: UIField.Basic, onItemClick: ((ItemBasic) -> Unit)? = null) {

    LazyColumn {
        items(data.data) {
            GItemList(it) {
                onItemClick?.invoke(it)
            }
        }
    }
}