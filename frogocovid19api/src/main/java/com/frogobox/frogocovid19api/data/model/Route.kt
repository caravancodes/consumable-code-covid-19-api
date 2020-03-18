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
data class Route(

    @SerializedName("Name")
    var name : String? = null,

    @SerializedName("Description")
    var description : String? = null,

    @SerializedName("Path")
    var path : String? = null,

    @SerializedName("Params")
    var params : List<String>? = null

)