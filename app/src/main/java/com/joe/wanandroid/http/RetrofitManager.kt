package com.joe.wanandroid.http

import com.joe.wanandroid.base.jsonPrint
import com.joe.wanandroid.base.kLogger
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitManager {

    private val logger = kLogger<RetrofitManager>()
    private var BASE_URL = "https://www.wanandroid.com"

    val apiService: Apis = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(genericOkClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(Apis::class.java)

    private fun genericOkClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor(
            object : HttpLoggingInterceptor.Logger{
                override fun log(message: String) {
                    logger.jsonPrint{ message }
                }
            }
        )
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .connectTimeout(5_000L, TimeUnit.MILLISECONDS)
            .readTimeout(10_000, TimeUnit.MILLISECONDS)
            .writeTimeout(30_000, TimeUnit.MILLISECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }
}