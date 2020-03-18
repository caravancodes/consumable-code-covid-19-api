package com.frogobox.frogocovid19api

import android.content.Context
import com.frogobox.frogocovid19api.callback.Covid19ResultCallback
import com.frogobox.frogocovid19api.data.model.Country
import com.frogobox.frogocovid19api.data.model.Status
import com.frogobox.frogocovid19api.data.reponse.ReponseSummary
import com.frogobox.frogocovid19api.data.source.Covid19DataSource
import com.frogobox.frogocovid19api.data.source.Covid19RemoteDataSource
import com.frogobox.frogocovid19api.data.source.Covid19Repository

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
class ConsumeCovid19Api : ConsumeCovid19ApiView {

    private val covid19Repository = Covid19Repository(Covid19RemoteDataSource)

    override fun usingChuckInterceptor(context: Context) {
        covid19Repository.usingChuckInterceptor(context)
    }

    override fun getSummaryData(callback: Covid19ResultCallback<ReponseSummary>) {
        covid19Repository.getSummaryData(object :
            Covid19DataSource.GetRemoteCallback<ReponseSummary> {
            override fun onSuccess(data: ReponseSummary) {
                callback.getResultData(data)
            }

            override fun onFailed(statusCode: Int, errorMessage: String?) {
                callback.failedResult(statusCode, errorMessage)
            }

            override fun onShowProgress() {
                callback.onShowProgress()
            }

            override fun onHideProgress() {
                callback.onHideProgress()
            }
        })
    }

    override fun getAllData(callback: Covid19ResultCallback<List<Status>>) {
        covid19Repository.getAllData(object : Covid19DataSource.GetRemoteCallback<List<Status>> {
            override fun onSuccess(data: List<Status>) {
                callback.getResultData(data)
            }

            override fun onFailed(statusCode: Int, errorMessage: String?) {
                callback.failedResult(statusCode, errorMessage)
            }

            override fun onShowProgress() {
                callback.onShowProgress()
            }

            override fun onHideProgress() {
                callback.onHideProgress()
            }
        })
    }

    override fun getAllCountries(callback: Covid19ResultCallback<List<Country>>) {
        covid19Repository.getAllCountries(object :
            Covid19DataSource.GetRemoteCallback<List<Country>> {
            override fun onSuccess(data: List<Country>) {
                callback.getResultData(data)
            }

            override fun onFailed(statusCode: Int, errorMessage: String?) {
                callback.failedResult(statusCode, errorMessage)
            }

            override fun onShowProgress() {
                callback.onShowProgress()
            }

            override fun onHideProgress() {
                callback.onHideProgress()
            }
        })
    }

    override fun getStatusByCountry(
        country: String,
        status: String,
        callback: Covid19ResultCallback<List<Status>>
    ) {
        covid19Repository.getStatusByCountry(
            country,
            status,
            object : Covid19DataSource.GetRemoteCallback<List<Status>> {
                override fun onSuccess(data: List<Status>) {
                    callback.getResultData(data)
                }

                override fun onFailed(statusCode: Int, errorMessage: String?) {
                    callback.failedResult(statusCode, errorMessage)
                }

                override fun onShowProgress() {
                    callback.onShowProgress()
                }

                override fun onHideProgress() {
                    callback.onHideProgress()
                }
            })
    }

    override fun getStatusByCountryProvince(
        country: String,
        status: String,
        callback: Covid19ResultCallback<List<Status>>
    ) {
        covid19Repository.getStatusByCountryProvince(
            country,
            status,
            object : Covid19DataSource.GetRemoteCallback<List<Status>> {
                override fun onSuccess(data: List<Status>) {
                    callback.getResultData(data)
                }

                override fun onFailed(statusCode: Int, errorMessage: String?) {
                    callback.failedResult(statusCode, errorMessage)
                }

                override fun onShowProgress() {
                    callback.onShowProgress()
                }

                override fun onHideProgress() {
                    callback.onHideProgress()
                }
            })
    }

    override fun getFirstRecordedByCountry(
        country: String,
        status: String,
        callback: Covid19ResultCallback<List<Status>>
    ) {
        covid19Repository.getFirstRecordedByCountry(
            country,
            status,
            object : Covid19DataSource.GetRemoteCallback<List<Status>> {
                override fun onSuccess(data: List<Status>) {
                    callback.getResultData(data)
                }

                override fun onFailed(statusCode: Int, errorMessage: String?) {
                    callback.failedResult(statusCode, errorMessage)
                }

                override fun onShowProgress() {
                    callback.onShowProgress()
                }

                override fun onHideProgress() {
                    callback.onHideProgress()
                }
            })
    }

    override fun getFirstRecordedByCountryProvince(
        country: String,
        status: String,
        callback: Covid19ResultCallback<List<Status>>
    ) {
        covid19Repository.getFirstRecordedByCountryProvince(
            country,
            status,
            object : Covid19DataSource.GetRemoteCallback<List<Status>> {
                override fun onSuccess(data: List<Status>) {
                    callback.getResultData(data)
                }

                override fun onFailed(statusCode: Int, errorMessage: String?) {
                    callback.failedResult(statusCode, errorMessage)
                }

                override fun onShowProgress() {
                    callback.onShowProgress()
                }

                override fun onHideProgress() {
                    callback.onHideProgress()
                }
            })
    }
}