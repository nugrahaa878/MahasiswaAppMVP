package com.nugrahaa.mahasiswaapparimvp.presenter.input

import com.nugrahaa.mahasiswaapparimvp.network.ApiConfig
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MahasiswaPresenter(private val mahasiswaView: MahasiswaView) {

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
    
    private fun addMahasiswa(nama: String, nohp: String, alamat: String) {

        if (nama.isNotEmpty() && nohp.isNotEmpty() && alamat.isNotEmpty()) {
            ApiConfig.getApiService().insertData(nama, nohp, alamat)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val message = it.message
                    val isSuccess = it.isSuccess

                    if (isSuccess == true) {
                        mahasiswaView.onSuccess(message ?: "")
                    } else {
                        mahasiswaView.onError(message ?: "")
                    }
                }, {
                    mahasiswaView.onError(it.localizedMessage)
                })
        } else {
            mahasiswaView.onError("Harap isi semua data")
        }

    }

    private fun updateMahasiswa(id: String, nama: String, nohp: String, alamat: String) {
        ApiConfig.getApiService().updateData(id, nama, nohp, alamat)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val message = it.message
                val isSuccess = it.isSuccess

                if (isSuccess == true) {
                    mahasiswaView.onSuccess(message ?: "")
                } else {
                    mahasiswaView.onError(message ?: "")
                }
            }, {
                mahasiswaView.onError(it.localizedMessage)
            })
    }

}