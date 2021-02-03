package com.byfrunze.blizzworld.data.source.remote

import com.byfrunze.blizzworld.data.models.OAuth
import okhttp3.Credentials
import retrofit2.http.*

interface OAuthApi {

    @FormUrlEncoded
    @POST("/oauth/token")
    suspend fun getToken(
        @Header(
            "Authorization"
        ) credentials: String,
        @Field(
            "grant_type"
        ) grantType: String
    ): OAuth
}