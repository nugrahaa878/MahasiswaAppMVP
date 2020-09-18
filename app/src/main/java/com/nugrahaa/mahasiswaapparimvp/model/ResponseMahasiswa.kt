package com.nugrahaa.mahasiswaapparimvp.model

import com.google.gson.annotations.SerializedName
import com.nugrahaa.mahasiswaapparimvp.model.Mahasiswa

data class ResponseMahasiswa(

    @field:SerializedName("data")
	val data: List<Mahasiswa?>? = null,

    @field:SerializedName("message")
	val message: String? = null,

    @field:SerializedName("isSuccess")
	val isSuccess: Boolean? = null

)