package com.route.islami.Api

import retrofit2.Call
import retrofit2.http.GET

interface WebServices {

    @GET ("radio/radio_ar.json")
    fun getRadioChannels():Call<RadiosRisponse>


}