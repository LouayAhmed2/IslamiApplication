package com.route.islami.Api

import com.google.gson.annotations.SerializedName

data class RadiosRisponse(

	@field:SerializedName("Radios")
	val radios: List<RadiosItem?>?=null
)