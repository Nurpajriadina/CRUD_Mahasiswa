package com.nurpajria.crudmahasiswa.screen

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nurpajria.crudmahasiswa.R
import com.nurpajria.crudmahasiswa.databinding.ActivityAddNoteBinding
import com.nurpajria.crudmahasiswa.helper.NoteDatabaseHelper
import com.nurpajria.crudmahasiswa.model.Note

class AddNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var db: NoteDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NoteDatabaseHelper(this)

        binding.saveButton.setOnClickListener {
            val nama = binding.titleEditText.text.toString()
            val nim = binding.nimEditText.text.toString()
            val jurusan = binding.jurusanEditText.text.toString()
            val note = Note(0, nama, nim, jurusan)
            db.insertNote(note)
            finish()
            Toast.makeText(this, "Catatan disimpan", Toast.LENGTH_SHORT).show()
        }

//        enableEdgeToEdge()
//        setContentView(R.layout.activity_add_note)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}