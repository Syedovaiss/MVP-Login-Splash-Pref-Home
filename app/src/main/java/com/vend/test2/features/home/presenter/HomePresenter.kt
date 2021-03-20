package com.vend.test2.features.home.presenter

import android.annotation.SuppressLint
import com.google.gson.Gson
import com.vend.test2.features.home.contracts.HomeContract
import com.vend.test2.response.home.CarTemplateResponse

/**
Created By Syed Ovais Akhtar On 3/20/21 5:43 PM2
 **/
class HomePresenter(private var view: HomeContract.View) : HomeContract.Presenter {


    @SuppressLint("CommitPrefEdits")
    override fun getDataFromStorage(data: String?) {

        data?.let {
            val gson = Gson()
            val model = gson.fromJson(it, CarTemplateResponse::class.java)
            view.onSuccess(model)


        } ?: run {
            view.onNoDataFound()
        }

    }
}