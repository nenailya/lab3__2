package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.Activity2Binding

class activity2 : AppCompatActivity() {
    companion object {
        private const val THIRD = 100
        const val FIRST = THIRD + 1
        const val SECOND = THIRD + 2
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toFirst.setOnClickListener { finish() }
        binding.toThird.setOnClickListener { goToThird() }
        binding.toAbout.setOnClickListener { goToAbout() }
    }

    private fun goToThird() {
        startActivityForResult(Intent(this, activity3::class.java), THIRD)
    }

    private fun goToAbout() {
        startActivity(Intent(this, activityAbout::class.java))
    }

    private fun goToFirst() {
        startActivity(Intent(this, activity1::class.java))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == THIRD) {
            when(resultCode){
                FIRST -> {goToFirst()}
                SECOND -> return
                else -> return
            }
            return
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}