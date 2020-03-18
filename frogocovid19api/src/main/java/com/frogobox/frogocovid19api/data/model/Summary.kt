package com.frogobox.frogocovid19api.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * Covid19Api
 * Copyright (C) 18/03/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.frogocovid19api.data.model
 *
 */
data class Summary(

    @SerializedName("Country")
    var country: String? = null,

    @SerializedName("NewConfirmed")
    var newConfirmed: Int? = null,

    @SerializedName("TotalConfirmed")
    var totalConfirmed: Int? = null,

    @SerializedName("NewDeaths")
    var newDeaths: Int? = null,

    @SerializedName("TotalDeaths")
    var totalDeaths: Int? = null,

    @SerializedName("NewRecovered")
    var newRecovered: Int? = null,

    @SerializedName("TotalRecovered")
    var totalRecovered: Int? = null
)