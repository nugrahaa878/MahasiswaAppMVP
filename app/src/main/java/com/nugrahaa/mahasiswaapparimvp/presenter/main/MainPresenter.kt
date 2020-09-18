package com.nugrahaa.mahasiswaapparimvp.presenter.main

import com.nugrahaa.mahasiswa_app_ari.model.Mahasiswa
import com.nugrahaa.mahasiswa_app_ari.model.ResponseAction
import com.nugrahaa.mahasiswa_app_ari.model.ResponseMahasiswa
import com.nugrahaa.mahasiswaapparimvp.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val mainView: MainView) {

    fun getAllData() {
        ApiConfig.getApiService().getDataMahasiswa()
            .enqueue(object : Callback<ResponseMahasiswa> {
                override fun onResponse(
                    call: Call<ResponseMahasiswa>,
                    response: Response<ResponseMahasiswa>
                ) {
                    if (response.isSuccessful) {
                        val status = response.body()?.isSuccess
                        val message = response.body()?.message
                        val listMahasiswa = response.body()?.data as ArrayList<Mahasiswa>

                        if (status == true) {
                            mainView.onSuccessGetAllData(listMahasiswa)
                        } else {
                            message?.let { mainView.onError(it) }
                        }

                    }
                }

                override fun onFailure(call: Call<ResponseMahasiswa>, t: Throwable) {
                    mainView.onError(t.localizedMessage)
                }

            })
    }

    fun deleteMahasiswa(id: String) {
        ApiConfig.getApiService().deleteData(id)
            .enqueue(object : Callback<ResponseAction> {
                override fun onResponse(
                    call: Call<ResponseAction>,
                    response: Response<ResponseAction>
                ) {
                    val message = response.body()?.message
                    val isSuccess = response.body()?.isSuccess

                    if (isSuccess == true) {
                        mainView.onSuccessDeleteData()
                        getAllData()
                    } else {
                        mainView.onError(message ?: "")
                    }
                }

                override fun onFailure(call: Call<ResponseAction>, t: Throwable) {
                    mainView.onError(t.localizedMessage)
                }

            })
    }

}