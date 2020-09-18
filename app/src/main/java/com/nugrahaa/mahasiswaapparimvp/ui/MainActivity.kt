package com.nugrahaa.mahasiswaapparimvp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nugrahaa.mahasiswa_app_ari.model.Mahasiswa
import com.nugrahaa.mahasiswaapparimvp.R
import com.nugrahaa.mahasiswaapparimvp.adapter.ListMahasiswaAdapter
import com.nugrahaa.mahasiswaapparimvp.presenter.main.MainPresenter
import com.nugrahaa.mahasiswaapparimvp.presenter.main.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    var presenter: MainPresenter? = null

    private lateinit var rvMahasiswa: RecyclerView
    private lateinit var listMahasiswaAdapter: ListMahasiswaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab_add.setOnClickListener {
            val mIntent = Intent(this@MainActivity, InputActivity::class.java)
            startActivity(mIntent)
        }

        presenter = MainPresenter(this)

        presenter?.getAllData()

    }

    override fun onSuccessGetAllData(listMahasiswa: ArrayList<Mahasiswa>) {
        rvMahasiswa = rv_mahasiswa
        rvMahasiswa.setHasFixedSize(true)

        rvMahasiswa.layoutManager = LinearLayoutManager(this)
        listMahasiswaAdapter = ListMahasiswaAdapter(listMahasiswa)
        rvMahasiswa.adapter = listMahasiswaAdapter

    }

    override fun onError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}