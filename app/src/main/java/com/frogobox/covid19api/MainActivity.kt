package com.frogobox.covid19api

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.frogocovid19api.ConsumeCovid19Api
import com.frogobox.frogocovid19api.callback.Covid19ResultCallback
import com.frogobox.frogocovid19api.data.reponse.ReponseSummary

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val consumeCovid19Api = ConsumeCovid19Api()
        consumeCovid19Api.usingChuckInterceptor(this)
        consumeCovid19Api.getSummaryData(object : Covid19ResultCallback<ReponseSummary> {
            override fun getResultData(data: ReponseSummary) {
                println(data.countries?.get(0)?.country)
            }

            override fun failedResult(statusCode: Int, errorMessage: String?) {

            }

            override fun onShowProgress() {

            }

            override fun onHideProgress() {

            }
        })

    }
}
