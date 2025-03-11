package com.aspen_android_app.data

data class Place(
    val name: String,
    val imageRes: Int,
    val rating: String = "",
    val duration: String = "",
    var isFavorite: Boolean = false,
)