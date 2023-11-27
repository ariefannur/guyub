package com.github.arief.annuur.guyub.ui.group

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.arief.annuur.guyub.model.BottomNavField

@Composable
fun GBottomAppBar(icons: List<BottomNavField>, selected: Int, onPage: ((Int) -> Unit)? = null) {
    LazyRow (modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ){
        itemsIndexed(icons) { page , item ->
            val color = if (selected == page) Color.Black else Color.LightGray
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
             modifier = Modifier.padding(8.dp)
                .clickable {
                onPage?.invoke(page)
            }) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "", tint = color)
                Text(text = item.title, style = MaterialTheme.typography.button, color = color)
            }
        }
    }
}