package com.example.myapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.contrib.NavigationViewActions


fun openAbout() {
    onView(withId(R.id.drawer_layout)).perform(DrawerActions.open())
    onView(withId(R.id.drawer_nav_view))
        .perform(NavigationViewActions.navigateTo(R.id.activityAbout))
}