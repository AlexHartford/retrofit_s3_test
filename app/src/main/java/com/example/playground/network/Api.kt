package com.example.playground.network

import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.PUT
import retrofit2.http.Url

interface ApiService {
    @PUT
    suspend fun uploadFile(
//        @Header("Content-Type") contentType: String,
        @Url uploadUrl: String,
        @Body file: RequestBody
    ): Response<Unit>

    @PUT
    suspend fun uploadFileSimple(
//        @Header("Content-Type") contentType: String,
        @Url uploadUrl: String,
//        @Body file: RequestBody
    ): Response<Unit>
}
