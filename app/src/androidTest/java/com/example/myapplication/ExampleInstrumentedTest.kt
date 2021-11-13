package com.example.myapplication


import android.content.pm.ActivityInfo
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import junit.framework.Assert.assertEquals

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import java.lang.Thread.sleep


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    var activityActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun test1Fragment() {
        openAbout()
        onView(withId(R.id.activityAbout)).check(matches(isDisplayed()))
    }

    @Test
    fun test1FragmentNA() {
        openAbout()
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
    }

    @Test
    fun test2Fragment() {
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        openAbout()
        onView(withId(R.id.activityAbout)).check(matches(isDisplayed()))
    }

    @Test
    fun test2FragmentN() {
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        openAbout()
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
    }

    @Test
    fun test2FragmentTo1() {
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToFirst)).perform(click())
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
    }

    @Test
    fun test3Fragment() {
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        openAbout()
        onView(withId(R.id.activityAbout)).check(matches(isDisplayed()))
    }

    @Test
    fun test3FragmentTo1() {
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.bnToFirst)).perform(click())
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
    }

    @Test
    fun test3FragmentTo2() {
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))

    }

    @Test
    fun testBackFrom1(){
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToFirst)).perform(click())
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        pressBackUnconditionally()
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        pressBackUnconditionally()
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
    }

    @Test
    fun testBackFrom31(){
        launchActivity<MainActivity>()
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.bnToFirst)).perform(click())
        pressBackUnconditionally()
        val x = activityScenario.state
        val y = Lifecycle.State.DESTROYED
        assertEquals(x, y)
    }

    @Test
    fun test1() {
        activityActivityTestRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        sleep(1000)
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        activityActivityTestRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        sleep(1000)
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
    }

    @Test
    fun test2() {
        openAbout()
        activityActivityTestRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        sleep(1000)
        onView(withId(R.id.activityAbout)).check(matches(isDisplayed()))
        activityActivityTestRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        sleep(1000)
        onView(withId(R.id.activityAbout)).check(matches(isDisplayed()))
    }

}