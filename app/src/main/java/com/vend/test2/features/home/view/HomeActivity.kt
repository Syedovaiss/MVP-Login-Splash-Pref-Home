package com.vend.test2.features.home.view

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.vend.test2.R
import com.vend.test2.features.home.adapter.HomeAdapter
import com.vend.test2.features.home.contracts.HomeContract
import com.vend.test2.features.home.presenter.HomePresenter
import com.vend.test2.response.home.CarTemplateResponse
import com.vend.test2.response.home.Caradvetisement
import com.vend.test2.utils.Constants.UI_CONSTANTS.PREFERENCE_FILE
import com.vend.test2.utils.Constants.UI_CONSTANTS.PREFERENCE_HOME
import com.vend.test2.utils.displayToast
import kotlinx.android.synthetic.main.activity_home.*

/**
Created By Syed Ovais Akhtar On 3/20/21 5:27 PM2
 **/
class HomeActivity : AppCompatActivity(), HomeContract.View {

    private lateinit var presenter: HomePresenter
    private lateinit var homeAdapter: HomeAdapter

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        homeAdapter = HomeAdapter()
        presenter = HomePresenter(this)
        isDataAvailable()
        setupRecyclerView()
    }

    private fun isDataAvailable() {

        val data = getSharedPreferences(PREFERENCE_FILE, Context.MODE_PRIVATE).getString(PREFERENCE_HOME, null)

        presenter.getDataFromStorage(data)
    }

    override fun onNoDataFound() {
        displayToast("Nothing.....")
    }

    override fun onSuccess(data: CarTemplateResponse) {
        displayToast("$data")
        homeAdapter.addAdvertisement(data.data.caradvetisement as ArrayList<Caradvetisement>)
    }

    private fun setupRecyclerView() {
        carRecyclerView.adapter = homeAdapter
        carRecyclerView.layoutManager = LinearLayoutManager(this)

    }
}