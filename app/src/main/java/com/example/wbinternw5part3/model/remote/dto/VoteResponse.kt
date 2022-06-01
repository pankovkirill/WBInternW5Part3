package com.example.wbinternw5part3.model.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class VoteResponse(
    val image_id: String,
    val created_at: String,
    val value: Int
)