package com.vend.test2.features.login.presenter

import com.vend.test2.features.login.contracts.LoginContracts
import com.vend.test2.features.login.model.User
import com.vend.test2.network.instance.NetworkInstance
import com.vend.test2.response.login.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
Created By Syed Ovais Akhtar On 3/20/21 5:17 PM2
 **/
class LoginPresenter(private var view: LoginContracts.View) : LoginContracts.Presenter {

    private val instance = NetworkInstance.getInstance()

    override fun validateInfo(user: User) {

        when {

            user.email.isEmpty() -> view.onEmptyEmail()

            user.password.isEmpty() -> view.onEmptyPassword()

            else -> callLoginAPI(user)
        }

    }

    private fun callLoginAPI(user: User) {
        instance?.loginUser(user)?.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful){
                    view.onLoginSuccess(response.body())
                } else {
                    view.onLoginFailure(response.message())
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                view.onLoginFailure(t.message!!)
            }
        })

    }
}