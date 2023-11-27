package com.github.arief.annuur.guyub.model

data class LayoutField (
    val pages: List<UIField>,
    val bottomNav: List<BottomNavField>
)

data class BottomNavField(
    val icon: String,
    val title: String
)