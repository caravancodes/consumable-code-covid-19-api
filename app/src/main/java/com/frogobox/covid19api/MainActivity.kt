package com.frogobox.covid19api

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.frogobox.frogocovid19api.ConsumeCovid19Api
import com.frogobox.frogocovid19api.callback.Covid19ResultCallback
import com.frogobox.frogocovid19api.data.model.Summary
import com.frogobox.frogocovid19api.data.reponse.ReponseSummary
import com.frogobox.recycler.boilerplate.viewrclass.FrogoViewAdapterCallback
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_main.view.*

class MainActivity : AppCompatActivity(), FrogoViewAdapterCallback<Summary> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupConsumableApi()
    }

    private fun consumeCovid19Api(): ConsumeCovid19Api {
        val consumeApi = ConsumeCovid19Api()
        consumeApi.usingChuckInterceptor(this) // This is Code Chuck Interceptor
        return consumeApi
    }

    private fun setupConsumableApi() {
        consumeCovid19Api().getSummaryData(object : Covid19ResultCallback<ReponseSummary> {
            override fun getResultData(data: ReponseSummary) {
                // * PLACE YOUR CODE HERE FOR UI / ARRAYLIST *
                data.countries?.let { setupFrogoRecyclerView(it) }
            }

            override fun failedResult(statusCode: Int, errorMessage: String?) {
                // failed result
            }

            override fun onShowProgress() {
                // showing your progress view
                runOnUiThread {
                    progress_view.visibility = View.VISIBLE
                }
            }

            override fun onHideProgress() {
                // hiding your progress view
                runOnUiThread {
                    progress_view.visibility = View.GONE
                }
            }
        })
    }

    private fun setupFrogoRecyclerView(data: List<Summary>) {
        frogo_rv.injector<Summary>()
            .addData(data)
            .addCustomView(R.layout.item_main)
            .addEmptyView(null)
            .addCallback(this)
            .createLayoutLinearVertical(false)
            .build()
    }

    private fun countryFlagUrl(countryCode: String) =
        "https://www.countryflags.io/$countryCode/flat/64.png"

    override fun onItemClicked(data: Summary) {

    }

    override fun onItemLongClicked(data: Summary) {

    }

    override fun setupInitComponent(view: View, data: Summary) {

        view.tvCountry.text = data.country
        view.tvConfirmed.text = data.totalConfirmed.toString()
        view.tvDeath.text = data.totalDeaths.toString()
        view.tvRecovered.text = data.totalRecovered.toString()

        Glide.with(view.context).load(data.countryCode?.let { countryFlagUrl(it) }).into(view.ivFlag)

    }

}
