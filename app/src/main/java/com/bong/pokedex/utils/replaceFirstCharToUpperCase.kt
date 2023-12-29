package com.bong.pokedex.utils

fun replaceFirstCharToUpperCase(char: String) : String {
    return char.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
}