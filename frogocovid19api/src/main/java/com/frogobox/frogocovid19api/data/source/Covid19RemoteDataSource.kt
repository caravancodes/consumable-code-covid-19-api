package com.frogobox.frogocovid19api.data.source

import android.content.Context
import com.frogobox.frogocovid19api.data.model.Country
import com.frogobox.frogocovid19api.data.model.Status
import com.frogobox.frogocovid19api.data.reponse.ReponseSummary
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

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
        apiService.getApiService
            .getSummaryData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .subscribe(object : Covid19ApiCallback<ReponseSummary>() {
                override fun onSuccess(model: ReponseSummary) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {}
            })
    }

    override fun getAllData(callback: Covid19DataSource.GetRemoteCallback<List<Status>>) {
        apiService.getApiService.getAllData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .subscribe(object : Covid19ApiCallback<List<Status>>() {
                override fun onSuccess(model: List<Status>) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {}
            })
    }

    override fun getAllCountries(callback: Covid19DataSource.GetRemoteCallback<List<Country>>) {
        apiService.getApiService.getAllCountries()
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .subscribe(object : Covid19ApiCallback<List<Country>>() {
                override fun onSuccess(model: List<Country>) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {}
            })
    }

    override fun getStatusByCountry(
        country: String,
        status: String,
        callback: Covid19DataSource.GetRemoteCallback<List<Status>>
    ) {
        apiService.getApiService.getStatusByCountry(country, status)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .subscribe(object : Covid19ApiCallback<List<Status>>() {
                override fun onSuccess(model: List<Status>) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {}
            })
    }

    override fun getStatusByCountryProvince(
        country: String,
        status: String,
        callback: Covid19DataSource.GetRemoteCallback<List<Status>>
    ) {
        apiService.getApiService.getStatusByCountryProvince(country, status)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .subscribe(object : Covid19ApiCallback<List<Status>>() {
                override fun onSuccess(model: List<Status>) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {}
            })

    }

    override fun getFirstRecordedByCountry(
        country: String,
        status: String,
        callback: Covid19DataSource.GetRemoteCallback<List<Status>>
    ) {
        apiService.getApiService.getFirstRecordedByCountry(country, status)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .subscribe(object : Covid19ApiCallback<List<Status>>() {
                override fun onSuccess(model: List<Status>) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {}
            })
    }

    override fun getFirstRecordedByCountryProvince(
        country: String,
        status: String,
        callback: Covid19DataSource.GetRemoteCallback<List<Status>>
    ) {
        apiService.getApiService.getFirstRecordedByCountryProvince(country, status)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .subscribe(object : Covid19ApiCallback<List<Status>>() {
                override fun onSuccess(model: List<Status>) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {}
            })
    }
}