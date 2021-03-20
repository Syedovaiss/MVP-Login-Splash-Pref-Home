package com.vend.test2.features.splash.presenter

import com.vend.test2.features.splash.contracts.SplashContracts
import com.vend.test2.network.instance.NetworkInstance
import com.vend.test2.response.home.CarTemplateResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
Created By Syed Ovais Akhtar On 3/20/21 4:17 PM2
 **/

class SplashPresenter(private val view: SplashContracts.View) : SplashContracts.Presenter {

    private val instance = NetworkInstance.getInstance()

    override fun getCars() {


        instance?.getCarInfo()?.enqueue(object : Callback<CarTemplateResponse> {
                override fun onResponse(call: Call<CarTemplateResponse>, response: Response<CarTemplateResponse>) {

                    if (response.isSuccessful){
                        view.onSuccess(response.body())

                    } else {
                        view.onFailure(response.message().toString())
                    }

                }

                override fun onFailure(call: Call<CarTemplateResponse>, t: Throwable) {
                    view.onFailure(t.message)
                }
            })
    }
}