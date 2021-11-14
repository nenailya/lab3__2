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
        binding.bnToFirst.setOnClickListener { goToFirst() }
        binding.bnToThird.setOnClickListener { goToThird() }
        setContentView(binding.root)
    }

    private fun goToThird() {
        startActivityForResult(Intent(this, activity3::class.java), REQUEST)
    }

    private fun goToFirst() {
        finish()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == REQUEST && resultCode == Activity.RESULT_OK) {
            finish()
        }
    }

    companion object {
        private const val REQUEST = 0
    }
}