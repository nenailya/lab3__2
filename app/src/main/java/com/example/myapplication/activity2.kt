package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.myapplication.databinding.Activity2Binding

class activity2 : AppCompatActivity() {
    private lateinit var binding: Activity2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity2Binding.inflate(layoutInflater)
        binding.bnToFirst.setOnClickListener { goToFirst() }
        binding.bnToThird.setOnClickListener { goToThird() }
        binding.drawerNavView.setNavigationItemSelectedListener { goToAbout(it) }
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun goToThird() {
        startActivityForResult(Intent(this, activity3::class.java), THIRD)
    }

    private fun goToFirst() {
        finish()
    }

    private fun goToAbout(it: MenuItem): Boolean {
        if (it.itemId == R.id.to_about) {
            binding.drawerLayout.closeDrawer(GravityCompat.START, true)
            startActivity(Intent(this, activityAbout::class.java))
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == THIRD) {
            when (resultCode) {
                activity3.FIRST -> finish()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        private const val THIRD = 3
    }
}