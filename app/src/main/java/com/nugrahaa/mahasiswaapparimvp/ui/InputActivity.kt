package com.nugrahaa.mahasiswaapparimvp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nugrahaa.mahasiswaapparimvp.R
import com.nugrahaa.mahasiswaapparimvp.presenter.input.MahasiswaPresenter
import com.nugrahaa.mahasiswaapparimvp.presenter.input.MahasiswaView
import kotlinx.android.synthetic.main.activity_input.*

class InputActivity : AppCompatActivity(), MahasiswaView {

    private var presenter: MahasiswaPresenter? = null
    private var id: String = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        var nama = edt_nama.text.toString()
        var nohp = edt_nohp.text.toString()
        var alamat = edt_alamat.text.toString()

        presenter = MahasiswaPresenter(this)

        presenter?.checkStatus("asd", "asd", "asd")

        btn_submit.setOnClickListener {
            nama = edt_nama.text.toString()
            nohp = edt_nohp.text.toString()
            alamat = edt_alamat.text.toString()
            presenter?.changeData(btn_submit.text.toString(), id, nama, nohp, alamat)
        }

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