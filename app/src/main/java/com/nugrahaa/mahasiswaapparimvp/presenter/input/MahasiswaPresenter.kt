package com.nugrahaa.mahasiswaapparimvp.presenter.input

import com.nugrahaa.mahasiswa_app_ari.model.ResponseAction
import com.nugrahaa.mahasiswaapparimvp.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MahasiswaPresenter(val mahasiswaView: MahasiswaView) {

    fun checkStatus(nama: String, nohp: String, alamat: String) {

        if (nama.isNotEmpty() && nohp.isNotEmpty() && alamat.isNotEmpty()) {
            mahasiswaView.onStatusUpdate()
        } else {
            mahasiswaView.onStatusAdd()
        }
        
    }

    fun changeData(textButton: String, id: String, nama: String, nohp: String, alamat: String) {
        if (textButton == "TAMBAH") {
            addMahasiswa(nama, nohp, alamat)
        } else {
            updateMahasiswa(id, nama, nohp, alamat)
        }
    }
    
    fun addMahasiswa(nama: String, nohp: String, alamat: String) {

        if (nama.isNotEmpty() && nohp.isNotEmpty() && alamat.isNotEmpty()) {
            ApiConfig.getApiService().insertData(nama, nohp, alamat)
                .enqueue(object : Callback<ResponseAction> {
                    override fun onResponse(
                        call: Call<ResponseAction>,
                        response: Response<ResponseAction>
                    ) {
                        if (response.isSuccessful) {
                            val message = response.body()?.message
                            val isSuccess = response.body()?.isSuccess

                            if (isSuccess == true) {
                                mahasiswaView.onSuccess(message ?: "")
                            } else {
                                mahasiswaView.onError(message ?: "")
                            }
                        }
                    }

                    override fun onFailure(call: Call<ResponseAction>, t: Throwable) {
                        mahasiswaView.onError(t.localizedMessage)
                    }

                })
        } else {
            mahasiswaView.onError("Harap isi semua data")
        }

    }

    fun updateMahasiswa(id: String, nama: String, nohp: String, alamat: String) {
        ApiConfig.getApiService().updateData(id, nama, nohp, alamat)
            .enqueue(object : Callback<ResponseAction> {
                override fun onResponse(
                    call: Call<ResponseAction>,
                    response: Response<ResponseAction>
                ) {
                    if (response.isSuccessful) {
                        val message = response.body()?.message
                        val isSuccess = response.body()?.isSuccess

                        if (isSuccess == true) {
                            mahasiswaView.onSuccess(message ?: "")
                        } else {
                            mahasiswaView.onError(message ?: "")
                        }
                    }
                }

                override fun onFailure(call: Call<ResponseAction>, t: Throwable) {
                    mahasiswaView.onError(t.localizedMessage)
                }

            })
    }

}