package com.github.mstavares.cm.acalculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class TestApplication {

    /**
     * Use [ActivityScenarioRule] to create and launch the activity under test before each test,
     * and close it after each test.
     */
    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun press2Then2ShouldBeDisplayed2() {
        onView(withId(R.id.text_visor)).check(matches(withText("0")))
        onView(withId(R.id.button_2)).perform(click())
        onView(withId(R.id.button_adition)).perform(click())
        onView(withId(R.id.button_3)).perform(click())
        onView(withId(R.id.button_equals)).perform(click())
        onView(withId(R.id.text_visor)).check(matches(withText("5.0")))
        onView(withId(R.id.drawer)).perform(DrawerActions.open());
        onView(withId(R.id.nav_history)).perform(click())
        onView(withId(R.id.rv_history))
           .check(matches(hasDescendant(withText("5.0"))))
    }

    @Test
    fun press2Then2ShouldBeDisplayed() {
        onView(withId(R.id.text_visor)).check(matches(withText("0")))
        onView(withId(R.id.button_2)).perform(click())
        onView(withId(R.id.text_visor)).check(matches(withText("2")))
    }

    @Test
    fun press2Plus3Then5ShouldBeDisplayed() {
        onView(withId(R.id.text_visor)).check(matches(withText("0")))
        onView(withId(R.id.button_2)).perform(click())
        onView(withId(R.id.button_adition)).perform(click())
        onView(withId(R.id.button_3)).perform(click())
        onView(withId(R.id.button_equals)).perform(click())
        onView(withId(R.id.text_visor)).check(matches(withText("5.0")))
    }
}