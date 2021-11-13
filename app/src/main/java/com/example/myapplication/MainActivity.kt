package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.Activity1Binding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = Activity1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bnToSecond.setOnClickListener { goToSecond() }
        binding.toAbout.setOnClickListener { goToAbout() }
    }

    private fun goToSecond() {
        startActivity(Intent(this, activity2::class.java))
    }

    private fun goToAbout() {
        startActivity(Intent(this, activityAbout::class.java))
    }
}