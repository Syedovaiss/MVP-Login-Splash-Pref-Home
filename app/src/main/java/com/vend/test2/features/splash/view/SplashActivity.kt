package com.vend.test2.features.splash.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.gson.Gson
import com.vend.test2.R
import com.vend.test2.features.home.view.HomeActivity
import com.vend.test2.features.login.view.LoginActivity
import com.vend.test2.features.splash.contracts.SplashContracts
import com.vend.test2.features.splash.presenter.SplashPresenter
import com.vend.test2.response.home.CarTemplateResponse
import com.vend.test2.utils.Constants.UI_CONSTANTS.PREFERENCE_FILE
import com.vend.test2.utils.Constants.UI_CONSTANTS.PREFERENCE_HOME
import com.vend.test2.utils.displayToast
import com.vend.test2.utils.routeTo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
Created By Syed Ovais Akhtar On 3/20/21 4:11 PM2
 **/
class SplashActivity : AppCompatActivity(), SplashContracts.View {

    private lateinit var presenter: SplashPresenter
    private val gson = Gson()

    private lateinit var sharedPrefs: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupPresenter()
        setupListeners()
    }

    private fun setupPresenter() {
        presenter = SplashPresenter(this)
    }


    @SuppressLint("CommitPrefEdits")
    private fun setupListeners() {
        sharedPrefs = getSharedPreferences(PREFERENCE_FILE, Context.MODE_PRIVATE) ?: return
        editor = sharedPrefs.edit()
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                presenter.getCars()
            }
        }

    }

    override fun onFailure(message: String?) {
        displayToast(message!!)
    }

    @SuppressLint("CommitPrefEdits")
    override fun onSuccess(data: CarTemplateResponse?) {
        val jsonData = gson.toJson(data)
        editor.putString(PREFERENCE_HOME, jsonData)
        editor.commit()
        routeTo(LoginActivity::class.java)

    }
}