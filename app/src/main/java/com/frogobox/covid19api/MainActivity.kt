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
        consumeCovid19Api.usingChuckInterceptor(this) // This is Code Chuck Interceptor
        consumeCovid19Api.getSummaryData(object : Covid19ResultCallback<ReponseSummary> {
            override fun getResultData(data: ReponseSummary) {
                // * PLACE YOUR CODE HERE FOR UI / ARRAYLIST *
            }

            override fun failedResult(statusCode: Int, errorMessage: String?) {
                // failed result
            }

            override fun onShowProgress() {
                // showing your progress view
            }

            override fun onHideProgress() {
                // hiding your progress view
            }
        })

    }
}
