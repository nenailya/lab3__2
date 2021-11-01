package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.Activity3Binding

class activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = Activity3Binding.inflate(layoutInflater)
        binding.toSecond.setOnClickListener { goToSecond() }
        binding.toFirst.setOnClickListener { goToFirst() }
        binding.toAbout.setOnClickListener { goToAbout() }
        setContentView(binding.root)
    }
    private fun goToFirst() {
        this.setResult(Activity.RESULT_OK)
        finish()
    }
    private fun goToSecond() {
        finish()
    }

    private fun goToAbout() {
        startActivity(Intent(this, activityAbout::class.java))
    }
}