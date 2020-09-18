package com.nugrahaa.mahasiswaapparimvp.network

import com.nugrahaa.mahasiswaapparimvp.model.ResponseAction
import com.nugrahaa.mahasiswaapparimvp.model.ResponseMahasiswa
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface ApiService {

    @GET("getData.php")
    fun getDataMahasiswa(): Flowable<ResponseMahasiswa>

    @FormUrlEncoded
    @POST("insert.php")
    fun insertData(@Field("mahasiswa_nama") mahasiswa_nama: String,
                   @Field("mahasiswa_nohp") mahasiswa_nohp: String,
                   @Field("mahasiswa_alamat") mahasiswa_alamat: String): Single<ResponseAction>

    @FormUrlEncoded
    @POST("update.php")
    fun updateData(@Field("id_mahasiswa") id_mahasiswa: String,
                   @Field("mahasiswa_nama") mahasiswa_nama: String,
                   @Field("mahasiswa_nohp") mahasiswa_nohp: String,
                   @Field("mahasiswa_alamat") mahasiswa_alamat: String): Single<ResponseAction>

    @FormUrlEncoded
    @POST("delete.php")
    fun deleteData(@Field("id_mahasiswa") id_mahasiswa: String): Single<ResponseAction>

}