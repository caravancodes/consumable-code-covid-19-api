package com.frogobox.frogocovid19api.data.source

import android.content.Context

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

}