package com.nugrahaa.mahasiswaapparimvp.presenter.input

interface MahasiswaView {

    fun onStatusAdd()
    fun onStatusUpdate()
    fun onError(msg: String)
    fun onSuccess(msg: String)

}