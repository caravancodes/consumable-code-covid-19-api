package com.frogobox.frogocovid19api

import android.content.Context
import com.frogobox.frogocovid19api.callback.Covid19ResultCallback
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
 * com.frogobox.frogocovid19api
 *
 */
interface ConsumeCovid19ApiView {

    // Switch For Using Chuck Interceptor
    fun usingChuckInterceptor(context: Context)

    // List Routes
    // List all routes with parameters and descriptions.
    fun getRoutes(callback: Covid19ResultCallback<List<Route>>)

    // Get Summary Data
    // Return new cases and total cases per country.
    fun getSummaryData(callback: Covid19ResultCallback<ReponseSummary>)

    // Get All Data
    // This call returns ~8MB of data and currently takes around 5 seconds.
    fun getAllData(callback: Covid19ResultCallback<List<Status>>)

    // Get All Countries
    // List all countries and their provinces.
    fun getAllCountries(callback: Covid19ResultCallback<List<Country>>)

    // Get Status By Country
    // {country} must be the country_slug the API call above
    // {status} must be one of: confirmed, deaths, recovered
    fun getStatusByCountry(
        country: String,
        status: String,
        callback: Covid19ResultCallback<List<Status>>
    )

    // Get Status By Country And Province
    // {country} must be the country_slug the API call above
    // {status} must be one of: confirmed, deaths, recovered
    fun getStatusByCountryProvince(
        country: String,
        status: String,
        callback: Covid19ResultCallback<List<Status>>
    )

    // Get Status By Country From First Recorded Case
    // {country} must be the country_slug the API call above
    // {status} must be one of: confirmed, deaths, recovered
    fun getFirstRecordedByCountry(
        country: String,
        status: String,
        callback: Covid19ResultCallback<List<Status>>
    )

    // Get Status By Country And Province From First Recorded Case
    // {country} must be the country_slug the API call above
    // {status} must be one of: confirmed, deaths, recovered
    fun getFirstRecordedByCountryProvince(
        country: String,
        status: String,
        callback: Covid19ResultCallback<List<Status>>
    )

}