package com.github.arief.annuur.guyub.ui.group

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.github.arief.annuur.guyub.model.LayoutField
import com.github.arief.annuur.guyub.model.UIField
import com.github.arief.annuur.guyub.ui.GBasicList
import com.github.arief.annuur.guyub.ui.GFeed
import com.github.arief.annuur.guyub.ui.GProfile

@Composable
fun GTabLayout(data: LayoutField) {

    var page by remember { mutableStateOf(0) }
    Scaffold (
        bottomBar = {
            GBottomAppBar(data.bottomNav, page) {
                page = it
            }
        }
    ) {
        Surface(modifier = Modifier.padding(it)) {
            when (val dataPage = data.pages[page]) {
                is UIField.Profile -> GProfile(dataPage)
                is UIField.Basic -> GBasicList(dataPage)
                is UIField.Feed -> GFeed(dataPage)
            }
        }
    }
}