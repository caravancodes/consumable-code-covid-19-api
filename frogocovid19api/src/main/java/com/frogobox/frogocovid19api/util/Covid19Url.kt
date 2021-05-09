package com.frogobox.frogocovid19api.util

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
 * com.frogobox.frogocovid19api.util
 *
 */
object Covid19Url {

    const val BASE_URL = "https://api.covid19api.com/"

    // List Routes
    // List all routes with parameters and descriptions.
    const val URL_ROUTE = ""

    // Get Summary Data
    // Return new cases and total cases per country.
    const val URL_SUMMARY = "summary"

    // Get All Data
    // This call returns ~8MB of data and currently takes around 5 seconds.
    const val URL_ALL = "all"

    // Get All Countries
    // List all countries and their provinces.
    const val URL_COUNTRIES = "countries"

    // Get Status By Country
    // {country} must be the country_slug the API call above
    // {status} must be one of: confirmed, deaths, recovered
    const val URL_STATUS_TOTAL = "total/country/{country}/status/{status}"

    // Get Status By Country And Province
    // {country} must be the country_slug the API call above
    // {status} must be one of: confirmed, deaths, recovered
    const val URL_STATUS = "country/{country}/status/{status}"

    // Get Status By Country From First Recorded Case
    // {country} must be the country_slug the API call above
    // {status} must be one of: confirmed, deaths, recovered
    const val URL_DAYONE_TOTAL = "total/dayone/country/{country}/status/{status}"

    // Get Status By Country And Province From First Recorded Case
    // {country} must be the country_slug the API call above
    // {status} must be one of: confirmed, deaths, recovered
    const val URL_DAYONE = "dayone/country/{country}/status/{status}"


}