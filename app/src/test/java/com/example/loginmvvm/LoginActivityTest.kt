package com.example.loginmvvm

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.loginmvvm.view.LoginActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @Test
    fun `successful login displays success message`() {
        ActivityScenario.launch(LoginActivity::class.java)

        onView(withId(R.id.editTextUsername)).perform(typeText("admin"), closeSoftKeyboard())
        onView(withId(R.id.editTextPassword)).perform(typeText("password"), closeSoftKeyboard())
        onView(withId(R.id.buttonLogin)).perform(click())

        onView(withText("Login Successful!")).inRoot(ToastMatcher()).check(matches(isDisplayed()))
    }

    @Test
    fun `failed login displays error message`() {
        ActivityScenario.launch(LoginActivity::class.java)

        onView(withId(R.id.editTextUsername)).perform(typeText("wronguser"), closeSoftKeyboard())
        onView(withId(R.id.editTextPassword)).perform(typeText("wrongpassword"), closeSoftKeyboard())
        onView(withId(R.id.buttonLogin)).perform(click())

        onView(withText("Invalid Credentials")).inRoot(ToastMatcher()).check(matches(isDisplayed()))
    }


}
