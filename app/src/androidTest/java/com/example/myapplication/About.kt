package com.example.myapplication

import android.view.Gravity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerActions.open
import androidx.test.espresso.contrib.DrawerMatchers.isClosed
import androidx.test.espresso.contrib.NavigationViewActions.navigateTo
import androidx.test.espresso.matcher.ViewMatchers.withId

private fun openAboutViaDrawer() {
    onView(withId(R.id.drawer_layout))
        .check(matches(isClosed(Gravity.LEFT)))
        .perform(open())

    onView(withId(R.id.drawer_nav_view))
        .perform(navigateTo(R.id.to_about))
}

fun openAbout() = openAboutViaDrawer()