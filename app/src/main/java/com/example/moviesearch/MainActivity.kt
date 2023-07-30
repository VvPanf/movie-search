package com.example.moviesearch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.start_second).apply { setOnClickListener { startSecond() } }
    }

    private fun startSecond() {
        intent = Intent(this, MovieDetailsActivity::class.java)
        startActivity(intent)
    }
}