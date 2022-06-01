package com.example.wbinternw5part3.model

import kotlinx.serialization.Serializable

@Serializable
data class FavoriteData(
    val created_at: String,
    val value: Int,
    val url: String
)