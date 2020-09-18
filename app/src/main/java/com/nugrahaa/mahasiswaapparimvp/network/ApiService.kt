package com.nugrahaa.mahasiswaapparimvp.network

import com.nugrahaa.mahasiswa_app_ari.model.ResponseAction
import com.nugrahaa.mahasiswa_app_ari.model.ResponseMahasiswa
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("getData.php")
    fun getDataMahasiswa(): Call<ResponseMahasiswa>

    @GET("getData.php")
    fun getDataMahasiswaById(@Query("id_mahasiswa") id_mahasiswa: String): Call<ResponseMahasiswa>

    @FormUrlEncoded
    @POST("insert.php")
    fun insertData(@Field("mahasiswa_nama") mahasiswa_nama: String,
                   @Field("mahasiswa_nohp") mahasiswa_nohp: String,
                   @Field("mahasiswa_alamat") mahasiswa_alamat: String): Call<ResponseAction>

    @FormUrlEncoded
    @POST("update.php")
    fun updateData(@Field("id_mahasiswa") id_mahasiswa: String,
                   @Field("mahasiswa_nama") mahasiswa_nama: String,
                   @Field("mahasiswa_nohp") mahasiswa_nohp: String,
                   @Field("mahasiswa_alamat") mahasiswa_alamat: String): Call<ResponseAction>

    @FormUrlEncoded
    @POST("delete.php")
    fun deleteData(@Field("id_mahasiswa") id_mahasiswa: String): Call<ResponseAction>

}