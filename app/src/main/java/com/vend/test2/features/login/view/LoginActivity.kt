package com.vend.test2.features.login.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vend.test2.R
import com.vend.test2.features.home.view.HomeActivity
import com.vend.test2.features.login.contracts.LoginContracts
import com.vend.test2.features.login.model.User
import com.vend.test2.features.login.presenter.LoginPresenter
import com.vend.test2.response.login.LoginResponse
import com.vend.test2.utils.displayToast
import com.vend.test2.utils.hide
import com.vend.test2.utils.routeTo
import com.vend.test2.utils.show
import kotlinx.android.synthetic.main.activity_login.*

/**
Created By Syed Ovais Akhtar On 3/20/21 5:06 PM2
 **/
class LoginActivity : AppCompatActivity(), LoginContracts.View {

    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter = LoginPresenter(this)
        setupListeners()
    }

    private fun setupListeners() {
        loginButton.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val user = User(email, password)
            progressBar.show()
            presenter.validateInfo(user)

        }

    }

    override fun onEmptyEmail() = displayToast(getString(R.string.empty_value, getString(R.string.email)))

    override fun onEmptyPassword() = displayToast(getString(R.string.empty_value, getString(R.string.password)))

    override fun onLoginFailure(message: String) {
        progressBar.hide()
        displayToast(message)

    }

    override fun onLoginSuccess(body: LoginResponse?) {
        progressBar.hide()
        routeTo(HomeActivity::class.java)
    }


}