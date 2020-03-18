package com.frogobox.frogocovid19api.data.source

import android.content.Context
import com.frogobox.frogocovid19api.data.model.Country
import com.frogobox.frogocovid19api.data.model.Route
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
 * com.frogobox.frogocovid19api.data
 *
 */
class Covid19Repository(private val remoteDataSource: Covid19RemoteDataSource) : Covid19DataSource {

    override fun usingChuckInterceptor(context: Context) {
        remoteDataSource.usingChuckInterceptor(context)
    }

    override fun getRoutes(callback: Covid19DataSource.GetRemoteCallback<List<Route>>) {
        remoteDataSource.getRoutes(callback)
    }

    override fun getSummaryData(callback: Covid19DataSource.GetRemoteCallback<ReponseSummary>) {
        remoteDataSource.getSummaryData(callback)
    }

    override fun getAllData(callback: Covid19DataSource.GetRemoteCallback<List<Status>>) {
        remoteDataSource.getAllData(callback)
    }

    override fun getAllCountries(callback: Covid19DataSource.GetRemoteCallback<List<Country>>) {
        remoteDataSource.getAllCountries(callback)
    }

    override fun getStatusByCountry(
        country: String,
        status: String,
        callback: Covid19DataSource.GetRemoteCallback<List<Status>>
    ) {
        remoteDataSource.getStatusByCountry(country, status, callback)
    }

    override fun getStatusByCountryProvince(
        country: String,
        status: String,
        callback: Covid19DataSource.GetRemoteCallback<List<Status>>
    ) {
        remoteDataSource.getStatusByCountryProvince(country, status, callback)
    }

    override fun getFirstRecordedByCountry(
        country: String,
        status: String,
        callback: Covid19DataSource.GetRemoteCallback<List<Status>>
    ) {
        remoteDataSource.getFirstRecordedByCountry(country, status, callback)
    }

    override fun getFirstRecordedByCountryProvince(
        country: String,
        status: String,
        callback: Covid19DataSource.GetRemoteCallback<List<Status>>
    ) {
        remoteDataSource.getFirstRecordedByCountryProvince(country, status, callback)
    }
}