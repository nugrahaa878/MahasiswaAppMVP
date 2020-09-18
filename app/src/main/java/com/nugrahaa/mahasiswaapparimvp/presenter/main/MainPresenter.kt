package com.nugrahaa.mahasiswaapparimvp.presenter.main

import com.nugrahaa.mahasiswaapparimvp.model.Mahasiswa
import com.nugrahaa.mahasiswaapparimvp.network.ApiConfig
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainPresenter(private val mainView: MainView) {

    fun getAllData() {
        ApiConfig.getApiService().getDataMahasiswa()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val status = it.isSuccess
                val message = it.message
                val listMahasiswa = it.data as ArrayList<Mahasiswa>

                if (status == true) {
                    mainView.onSuccessGetAllData(listMahasiswa)
                } else {
                    message?.let { mainView.onError(it) }
                }
            }, {
                mainView.onError(it.localizedMessage)

            })
    }

    fun deleteMahasiswa(id: String) {
        ApiConfig.getApiService().deleteData(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val message = it.message
                val isSuccess = it.isSuccess

                if (isSuccess == true) {
                    mainView.onSuccessDeleteData()
                    getAllData()
                } else {
                    mainView.onError(message ?: "")
                }
            }, {
                mainView.onError(it.localizedMessage)
            })
    }

}