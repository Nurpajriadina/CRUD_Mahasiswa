package com.nurpajria.crudmahasiswa

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.nurpajria.crudmahasiswa.adapter.NotesAdapter
import com.nurpajria.crudmahasiswa.databinding.ActivityMainBinding
import com.nurpajria.crudmahasiswa.helper.NoteDatabaseHelper
import com.nurpajria.crudmahasiswa.screen.AddNoteActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var notesAdapter: NotesAdapter
    private lateinit var db : NoteDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NoteDatabaseHelper(this)
        notesAdapter = NotesAdapter(db.getAllNotes(),this)

        binding.notesRecycleview.layoutManager = LinearLayoutManager(this)
        binding.notesRecycleview.adapter = notesAdapter

        binding.addButton.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }
    }
    //ketika item list note diklik akan pergi ke detail sesuai item dan contentnya
    override fun onResume() {
        super.onResume()
        val notes = db.getAllNotes()
        notesAdapter.refreshData(notes)
    }
}