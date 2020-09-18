package com.nugrahaa.mahasiswaapparimvp.presenter.main

import com.nugrahaa.mahasiswa_app_ari.model.Mahasiswa

interface MainView {

    fun onSuccessGetAllData(listMahasiswa: ArrayList<Mahasiswa>)
    fun onError(msg: String)

}