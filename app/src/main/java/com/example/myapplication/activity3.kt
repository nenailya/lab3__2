package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.myapplication.databinding.Activity3Binding

class activity3 : AppCompatActivity() {
    private lateinit var binding: Activity3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = Activity3Binding.inflate(layoutInflater)
        binding.bnToSecond.setOnClickListener { goToSecond() }
        binding.bnToFirst.setOnClickListener { goToFirst() }
        binding.drawerNavView.setNavigationItemSelectedListener { goToAbout(it) }
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun goToFirst() {
        setResult(FIRST)
        finish()
    }

    private fun goToSecond() {
        finish()
    }

    private fun goToAbout(it: MenuItem): Boolean {
        binding = Activity3Binding.inflate(layoutInflater)
        if (it.itemId == R.id.to_about) {
            binding.drawerLayout.closeDrawer(GravityCompat.START, true)
            startActivity(Intent(this, activityAbout::class.java))
        }
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        val FIRST = 1
    }

}