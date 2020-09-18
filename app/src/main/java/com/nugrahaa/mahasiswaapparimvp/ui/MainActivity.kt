package com.nugrahaa.mahasiswaapparimvp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nugrahaa.mahasiswaapparimvp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab_add.setOnClickListener {
            val mIntent = Intent(this@MainActivity, InputActivity::class.java)
            startActivity(mIntent)
        }

    }
}