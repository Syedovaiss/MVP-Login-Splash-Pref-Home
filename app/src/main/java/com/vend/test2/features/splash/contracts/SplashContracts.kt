package com.vend.test2.features.splash.contracts

import com.vend.test2.response.home.CarTemplateResponse

/**
Created By Syed Ovais Akhtar On 3/20/21 4:16 PM2
 **/
interface SplashContracts {

    interface View {

        fun onFailure(message:String?)
        fun onSuccess(data: CarTemplateResponse?)

    }

    interface Presenter {

        fun getCars()
    }
}