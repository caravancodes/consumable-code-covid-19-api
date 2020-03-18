package com.frogobox.frogocovid19api.data.reponse

import com.frogobox.frogocovid19api.data.model.Summary
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
 * com.frogobox.frogocovid19api.data.reponse
 *
 */
data class ReponseSummary(

    @SerializedName("Countries")
    var countries: List<Summary>? = null

)