package com.github.arief.annuur.guyub.utils



fun String.checkEmail(): Boolean {
    return this.matches(Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"))
}

fun String.checkPhoneNumber(): Boolean {
    return this.matches(Regex("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}\$"))
}