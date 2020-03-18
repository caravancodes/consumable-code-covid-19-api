package com.frogobox.frogocovid19api.data.source

import android.content.Context
import com.frogobox.frogocovid19api.data.model.Country
import com.frogobox.frogocovid19api.data.model.Status
import com.frogobox.frogocovid19api.data.reponse.ReponseSummary

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * Covid19Api
 * Copyright (C) 17/03/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.frogocovid19api.data.source
 *
 */
object Covid19RemoteDataSource : Covid19DataSource {

    private val apiService = Covid19ApiService

    override fun usingChuckInterceptor(context: Context) {
        apiService.usingChuckInterceptor(context)
    }

    override fun getSummaryData(callback: Covid19DataSource.GetRemoteCallback<ReponseSummary>) {
        TODO("Not yet implemented")
    }

    override fun getAllData(callback: Covid19DataSource.GetRemoteCallback<List<Status>>) {
        TODO("Not yet implemented")
    }

    override fun getAllCountries(callback: Covid19DataSource.GetRemoteCallback<List<Country>>) {
        TODO("Not yet implemented")
    }

    override fun getStatusByCountry(
        country: String,
        status: String,
        callback: Covid19DataSource.GetRemoteCallback<List<Status>>
    ) {
        TODO("Not yet implemented")
    }

    override fun getStatusByCountryProvince(
        country: String,
        status: String,
        callback: Covid19DataSource.GetRemoteCallback<List<Status>>
    ) {
        TODO("Not yet implemented")
    }

    override fun getFirstRecordedByCountry(
        country: String,
        status: String,
        callback: Covid19DataSource.GetRemoteCallback<List<Status>>
    ) {
        TODO("Not yet implemented")
    }

    override fun getFirstRecordedByCountryProvince(
        country: String,
        status: String,
        callback: Covid19DataSource.GetRemoteCallback<List<Status>>
    ) {
        TODO("Not yet implemented")
    }
}