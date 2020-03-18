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
data class Status(

    @SerializedName("Country")
    var country: String? = null,

    @SerializedName("Province")
    var province: String? = null,

    @SerializedName("Lat")
    var lat: String? = null,

    @SerializedName("Lon")
    var lon: String? = null,

    @SerializedName("Date")
    var date: String? = null,

    @SerializedName("Cases")
    var cases: String? = null,

    @SerializedName("Status")
    var status: String? = null

)