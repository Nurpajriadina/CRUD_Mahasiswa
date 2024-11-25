package com.nurpajria.crudmahasiswa

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailPageActivity : AppCompatActivity() {
    private lateinit var txtNamaDetail: TextView
    private lateinit var txtNimDetail: TextView
    private lateinit var txtJurusanDetail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_page)

        txtNamaDetail = findViewById(R.id.txtNamaDetail)
        txtNimDetail = findViewById(R.id.txtNimDetail)
        txtJurusanDetail = findViewById(R.id.txtJurusanDetail)

        val nama = intent.getStringExtra("nama")
        val nim = intent.getStringExtra("nim")
        val jurusan = intent.getStringExtra("jurusan")

        txtNamaDetail.text = nama
        txtNimDetail.text = nim
        txtJurusanDetail.text = jurusan

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}