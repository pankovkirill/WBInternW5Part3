package com.example.wbinternw5part3.model.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ImageResponse(
    val id: String,
    val url: String,
)