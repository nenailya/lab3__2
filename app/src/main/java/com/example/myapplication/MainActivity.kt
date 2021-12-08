package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.myapplication.databinding.Activity1Binding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: Activity1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bnToSecond.setOnClickListener { goToSecond() }
        binding.drawerNavView.setNavigationItemSelectedListener { goToAbout(it) }
    }

    private fun goToSecond() {
        startActivity(Intent(this, activity2::class.java))
    }

    private fun goToAbout(it: MenuItem): Boolean {
        if (it.itemId == R.id.to_about) {
            binding.drawerLayout.closeDrawer(GravityCompat.START, true)
            startActivity(Intent(this, activityAbout::class.java))
        }
        return true
    }
}


