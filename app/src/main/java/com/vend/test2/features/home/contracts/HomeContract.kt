package com.vend.test2.features.home.contracts

import com.vend.test2.response.home.CarTemplateResponse

/**
Created By Syed Ovais Akhtar On 3/20/21 5:41 PM2
 **/
interface HomeContract {
    interface View {

        fun onNoDataFound()
        fun onSuccess(data: CarTemplateResponse)

    }

    interface Presenter {

        fun getDataFromStorage(data:String?)

    }
}