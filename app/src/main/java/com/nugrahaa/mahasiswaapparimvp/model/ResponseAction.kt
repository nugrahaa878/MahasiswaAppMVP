package com.nugrahaa.mahasiswa_app_ari.model

import com.google.gson.annotations.SerializedName

data class ResponseAction(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("isSuccess")
	val isSuccess: Boolean? = null

)
