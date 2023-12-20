package com.bong.pokedex.utils

import android.graphics.Color

fun String.toAndroidColor(): Int {
    return try {
        Color.parseColor(this)
    } catch (e: IllegalArgumentException) {
        // Handle invalid color format gracefully
        Color.TRANSPARENT // Return a default color (transparent) in case of an error
    }
}