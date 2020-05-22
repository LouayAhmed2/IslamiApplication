package com.route.islami.Api

import com.google.gson.annotations.SerializedName

data class RadiosItem(

	@field:SerializedName("Name")
	val name: String?=null,

	@field:SerializedName("URL")
	val uRL: String?=null
)