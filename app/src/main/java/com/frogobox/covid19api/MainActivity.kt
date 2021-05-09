package com.frogobox.covid19api

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.frogobox.covid19api.databinding.ActivityMainBinding
import com.frogobox.frogocovid19api.ConsumeCovid19Api
import com.frogobox.frogocovid19api.callback.Covid19ResultCallback
import com.frogobox.frogocovid19api.data.model.Summary
import com.frogobox.frogocovid19api.data.reponse.ReponseSummary
import com.frogobox.recycler.core.IFrogoViewAdapter

class MainActivity : AppCompatActivity(), IFrogoViewAdapter<Summary> {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
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
                    binding.progressView.visibility = View.VISIBLE
                }
            }

            override fun onHideProgress() {
                // hiding your progress view
                runOnUiThread {
                    binding.progressView.visibility = View.GONE
                }
            }
        })
    }

    private fun setupFrogoRecyclerView(data: List<Summary>) {
        binding.frogoRv.injector<Summary>()
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

        view.findViewById<TextView>(R.id.tvCountry).text = data.country
        view.findViewById<TextView>(R.id.tvConfirmed).text = data.totalConfirmed.toString()
        view.findViewById<TextView>(R.id.tvDeath).text = data.totalDeaths.toString()
        view.findViewById<TextView>(R.id.tvRecovered).text = data.totalRecovered.toString()

        Glide.with(view.context).load(data.countryCode?.let { countryFlagUrl(it) }).into(view.findViewById(R.id.ivFlag))

    }

}
