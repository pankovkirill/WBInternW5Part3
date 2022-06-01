package com.example.wbinternw5part3.model.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class VoteRequest(
    val image_id: String,
    val sub_id: String,
    val value: Int
)
