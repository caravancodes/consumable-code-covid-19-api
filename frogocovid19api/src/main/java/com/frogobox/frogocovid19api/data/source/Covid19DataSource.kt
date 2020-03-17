package com.frogobox.frogocovid19api.data.source

import android.content.Context
import com.frogobox.frogocovid19api.base.BaseCovid19DataSource

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
interface Covid19DataSource {

    // Switch For Using Chuck Interceptor
    fun usingChuckInterceptor(context: Context)


    // Response Callback
    interface GetRemoteCallback<T> : BaseCovid19DataSource.ResponseCallback<T>


}