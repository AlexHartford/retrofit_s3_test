package com.example.playground.network

import retrofit2.Retrofit
import okhttp3.logging.HttpLoggingInterceptor

import okhttp3.OkHttpClient

object RetrofitClientInstance {

    private var retrofit: Retrofit? = null
    private const val BASE_URL = "https://jsonplaceholder.typicode.com"

    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                val logging = HttpLoggingInterceptor()
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                val client: OkHttpClient = OkHttpClient().newBuilder()
                    .addInterceptor(logging)
                    .build()
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .build()
            }
            return retrofit
        }
}

