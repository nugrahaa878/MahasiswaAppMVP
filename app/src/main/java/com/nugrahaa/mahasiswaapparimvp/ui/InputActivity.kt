package com.nugrahaa.mahasiswaapparimvp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.nugrahaa.mahasiswa_app_ari.model.Mahasiswa
import com.nugrahaa.mahasiswaapparimvp.R
import com.nugrahaa.mahasiswaapparimvp.presenter.input.MahasiswaPresenter
import com.nugrahaa.mahasiswaapparimvp.presenter.input.MahasiswaView
import kotlinx.android.synthetic.main.activity_input.*
import kotlinx.android.synthetic.main.list_item.*

class InputActivity : AppCompatActivity(), MahasiswaView {

    private var presenter: MahasiswaPresenter? = null
    private var id: String = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        val getData = intent.getParcelableExtra<Mahasiswa>("DATA")
        Log.d("DATA YANG DIBAWA ", getData?.mahasiswaNama.toString())

        var nama = getData?.mahasiswaNama.toString()
        var nohp = getData?.mahasiswaNohp.toString()
        var alamat = getData?.mahasiswaAlamat.toString()

        setEditText(nama, nohp, alamat)

        presenter = MahasiswaPresenter(this)

        presenter?.checkStatus(nama, nohp, alamat)

        btn_submit.setOnClickListener {
            nama = edt_nama.text.toString()
            nohp = edt_nohp.text.toString()
            alamat = edt_alamat.text.toString()
            presenter?.changeData(btn_submit.text.toString(), id, nama, nohp, alamat)
        }

    }

    private fun setEditText(nama: String, nohp: String, alamat: String) {
        edt_nama.setText(nama)
        edt_nohp.setText(nohp)
        edt_alamat.setText(alamat)
    }

    override fun onStatusAdd() {
        btn_submit.text = "TAMBAH"
    }

    override fun onStatusUpdate() {
        btn_submit.text = "UPDATE"
    }

    override fun onError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun onSuccess(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        val mIntent = Intent(this@InputActivity, MainActivity::class.java)
        startActivity(mIntent)
    }
}