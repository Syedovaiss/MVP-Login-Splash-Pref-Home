package com.vend.test2.features.login.contracts

import com.vend.test2.features.login.model.User
import com.vend.test2.response.login.LoginResponse

/**
Created By Syed Ovais Akhtar On 3/20/21 5:09 PM2
 **/
interface LoginContracts {

    interface View {

        fun onEmptyEmail()
        fun onEmptyPassword()
        fun onLoginFailure(message: String)
        fun onLoginSuccess(body: LoginResponse?)

    }

    interface Presenter {
        fun validateInfo(user: User)

    }
}