package com.byfrunze.blizzworld.data.models

data class OAuth(
    val access_token: String,
    val token_type: String,
    val expires_in: Int
)