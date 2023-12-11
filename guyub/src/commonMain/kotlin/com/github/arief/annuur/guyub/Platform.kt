package com.github.arief.annuur.guyub

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform