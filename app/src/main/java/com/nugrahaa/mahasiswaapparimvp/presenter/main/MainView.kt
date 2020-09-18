package com.nugrahaa.mahasiswaapparimvp.presenter.main

import com.nugrahaa.mahasiswaapparimvp.model.Mahasiswa

interface MainView {

    fun onSuccessGetAllData(listMahasiswa: ArrayList<Mahasiswa>)
    fun onError(msg: String)
    fun onSuccessDeleteData()

}