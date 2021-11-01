package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.Activity3Binding

class activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = Activity3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toSecond.setOnClickListener {
            goToSecond()
        }
        binding.toFirst.setOnClickListener {
            goToFirst()
        }
        binding.toAbout.setOnClickListener { goToAbout() }
    }
    private fun goToFirst() {
        startActivity(Intent(this, activity1::class.java))
    }
    private fun goToSecond() {
        setResult(activity2.SECOND)
        finish()
    }

    private fun goToAbout() {
        startActivity(Intent(this, activityAbout::class.java))
    }
}