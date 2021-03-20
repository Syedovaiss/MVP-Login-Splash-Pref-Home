package com.vend.test2.network.client

import com.vend.test2.features.login.model.User
import com.vend.test2.response.home.CarTemplateResponse
import com.vend.test2.response.login.LoginResponse
import com.vend.test2.utils.Constants.API_CONSTANTS.HOME_ENDPOINT
import com.vend.test2.utils.Constants.API_CONSTANTS.LOGIN_ENDPOINT
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
Created By Syed Ovais Akhtar On 3/20/21 4:04 PM2
 **/
interface NetworkClient {

    @POST(LOGIN_ENDPOINT)
    fun loginUser(@Body user: User): Call<LoginResponse>


    @GET(HOME_ENDPOINT)
    fun getCarInfo(): Call<CarTemplateResponse>
}