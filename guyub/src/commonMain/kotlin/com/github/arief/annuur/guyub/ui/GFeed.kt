package com.github.arief.annuur.guyub.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.github.arief.annuur.guyub.model.ItemFeed
import com.github.arief.annuur.guyub.model.UIField
import com.github.arief.annuur.guyub.model.UIFieldType

@Composable
fun GFeed(data: UIField.Feed, onItemClick: ((ItemFeed) -> Unit)? = null) {
    if (data.type == UIFieldType.LIST) {
        LazyColumn {
            items(data.data) {
                GItemFeed(it) {
                    onItemClick?.invoke(it)
                }
            }
        }
    } else {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 150.dp)
        ) {
            items(data.data) {
                GItemFeed(it) {
                    onItemClick?.invoke(it)
                }
            }
        }
    }
}