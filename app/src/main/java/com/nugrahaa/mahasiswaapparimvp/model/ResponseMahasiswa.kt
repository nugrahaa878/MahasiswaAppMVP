package com.nugrahaa.mahasiswa_app_ari.model

import com.google.gson.annotations.SerializedName

data class ResponseMahasiswa(

	@field:SerializedName("data")
	val data: List<Mahasiswa?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("isSuccess")
	val isSuccess: Boolean? = null

)