package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.Activity1Binding
import com.google.android.material.navigation.NavigationView
import android.widget.Toast
import androidx.navigation.NavController


import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.*
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.contrib.DrawerMatchers.isClosed
import androidx.test.espresso.contrib.NavigationViewActions.navigateTo
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.viewbinding.ViewBinding
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: Activity1Binding
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bnToSecond.setOnClickListener { goToSecond() }

        //com.example.myapplication.About()



        //navController = (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment).navController

        //  drawer_nav_view.setNavigationItemSelectedListener {
        //      if (it.itemId == R.id.to_about) {
        //          drawer_layout.closeDrawer(GravityCompat.START, true)
        //          launchActivity<activityAbout>()
        //          //navController.navigate(R.id.action_to_activityAbout)
        //      }
        //      true
        //  }

        //  val appBarConfiguration = AppBarConfiguration(navController.graph, binding.drawer_layout)
        //  setupActionBarWithNavController(navController, appBarConfiguration)
        //  binding.drawerNavView.setupWithNavController(navController)

    }

    private fun goToSecond() {
        startActivity(Intent(this, activity2::class.java))
    }


}