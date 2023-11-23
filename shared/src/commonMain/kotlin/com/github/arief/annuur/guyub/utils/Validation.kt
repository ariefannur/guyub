package com.github.arief.annuur.guyub.utils



fun String.checkEmail(): Boolean {
    return this.matches(Regex(".+@.+\\\\.[a-z]+"))
}

fun String.checkPhoneNumber(): Boolean {
    return this.matches(Regex("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}\$"))
}