package com.byfrunze.blizzworld.data.repository

import com.byfrunze.blizzworld.data.models.OAuth
import com.byfrunze.blizzworld.data.source.remote.OAuthApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Credentials
import javax.inject.Inject

class RemoteRepository
@Inject constructor(
    val oAuthApi: OAuthApi
) {

    fun getToken(): Flow<OAuth> {
        return flow {
            val token = oAuthApi.getToken(
                credentials = Credentials.basic(
                    CLIENT_ID,
                    CLIENT_SECRET
                ),

                grantType = GRANT_TYPE
            )
            emit(token)
        }.flowOn(Dispatchers.IO)
    }

    companion object {
        const val CLIENT_ID = "651e08abbdfd41f7a3a76dd8a55c7681"
        const val CLIENT_SECRET = "hUXh7z3P3EOIbrz13r0heKliLMIcK0UE"
        const val GRANT_TYPE = "client_credentials"
    }
}