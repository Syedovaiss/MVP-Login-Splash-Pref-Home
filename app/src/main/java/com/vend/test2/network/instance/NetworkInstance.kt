package com.vend.test2.network.instance

import com.vend.test2.network.client.NetworkClient
import com.vend.test2.utils.Constants.API_CONSTANTS.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
Created By Syed Ovais Akhtar On 3/20/21 3:58 PM2
 **/

object NetworkInstance {

    fun getInstance(): NetworkClient? {

        val httpL = HttpLoggingInterceptor()
        httpL.level = HttpLoggingInterceptor.Level.HEADERS

        val httpLogger = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val httpClient = OkHttpClient.Builder().addInterceptor(httpLogger).build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(NetworkClient::class.java)

    }

}