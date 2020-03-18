package com.frogobox.frogocovid19api.data.source

import android.content.Context
import com.frogobox.frogocovid19api.data.model.Country
import com.frogobox.frogocovid19api.data.model.Route
import com.frogobox.frogocovid19api.data.model.Status
import com.frogobox.frogocovid19api.data.reponse.ReponseSummary
import com.frogobox.frogocovid19api.util.Covid19Constant
import com.frogobox.frogocovid19api.util.Covid19Url
import com.readystatesoftware.chuck.ChuckInterceptor
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

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
interface Covid19ApiService {

    // List Routes
    // List all routes with parameters and descriptions.
    @GET(Covid19Url.URL_ROUTE)
    fun getRoutes(): Observable<List<Route>>

    // Get Summary Data
    // Return new cases and total cases per country.
    @GET(Covid19Url.URL_SUMMARY)
    fun getSummaryData(): Observable<ReponseSummary>

    // Get All Data
    // This call returns ~8MB of data and currently takes around 5 seconds.
    @GET(Covid19Url.URL_ALL)
    fun getAllData(): Observable<List<Status>>

    // Get All Countries
    // List all countries and their provinces.
    @GET(Covid19Url.URL_COUNTRIES)
    fun getAllCountries(): Observable<List<Country>>

    // Get Status By Country
    // {country} must be the country_slug the API call above
    // {status} must be one of: confirmed, deaths, recovered
    @GET(Covid19Url.URL_STATUS_TOTAL)
    fun getStatusByCountry(
        @Path(Covid19Constant.PATH_COUNTRY) country: String,
        @Path(Covid19Constant.PATH_STATUS) status: String
    ): Observable<List<Status>>

    // Get Status By Country And Province
    // {country} must be the country_slug the API call above
    // {status} must be one of: confirmed, deaths, recovered
    @GET(Covid19Url.URL_STATUS)
    fun getStatusByCountryProvince(
        @Path(Covid19Constant.PATH_COUNTRY) country: String,
        @Path(Covid19Constant.PATH_STATUS) status: String
    ): Observable<List<Status>>

    // Get Status By Country From First Recorded Case
    // {country} must be the country_slug the API call above
    // {status} must be one of: confirmed, deaths, recovered
    @GET(Covid19Url.URL_DAYONE_TOTAL)
    fun getFirstRecordedByCountry(
        @Path(Covid19Constant.PATH_COUNTRY) country: String,
        @Path(Covid19Constant.PATH_STATUS) status: String
    ): Observable<List<Status>>

    // Get Status By Country And Province From First Recorded Case
    // {country} must be the country_slug the API call above
    // {status} must be one of: confirmed, deaths, recovered
    @GET(Covid19Url.URL_DAYONE)
    fun getFirstRecordedByCountryProvince(
        @Path(Covid19Constant.PATH_COUNTRY) country: String,
        @Path(Covid19Constant.PATH_STATUS) status: String
    ): Observable<List<Status>>

    companion object Factory {

        private var isUsingChuckInterceptor = false
        private lateinit var context: Context

        fun usingChuckInterceptor(context: Context) {
            isUsingChuckInterceptor = true
            this.context = context
        }

        val getApiService: Covid19ApiService by lazy {
            val mLoggingInterceptor = HttpLoggingInterceptor()
            mLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val mClient = if (isUsingChuckInterceptor) {
                OkHttpClient.Builder()
                    .addInterceptor(mLoggingInterceptor)
                    .addInterceptor(ChuckInterceptor(context))
                    .readTimeout(30, TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build()
            } else {
                OkHttpClient.Builder()
                    .readTimeout(30, TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build()
            }

            val mRetrofit = Retrofit.Builder()
                .baseUrl(Covid19Url.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(mClient)
                .build()

            mRetrofit.create(Covid19ApiService::class.java)
        }
    }


}