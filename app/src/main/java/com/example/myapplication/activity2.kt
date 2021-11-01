package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.Activity2Binding

class activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = Activity2Binding.inflate(layoutInflater)

        binding.toFirst.setOnClickListener { goToFirst() }
        binding.toThird.setOnClickListener { goToThird() }
        binding.toAbout.setOnClickListener { goToAbout() }
        setContentView(binding.root)
    }

    private fun goToThird() {
        startActivity(Intent(this, activity3::class.java))
    }

    private fun goToAbout() {
        startActivity(Intent(this, activityAbout::class.java))
    }

    private fun goToFirst() {
        finish()
    }

}