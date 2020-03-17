package com.frogobox.frogocovid19api

import android.content.Context
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
}