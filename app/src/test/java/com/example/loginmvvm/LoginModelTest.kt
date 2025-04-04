package com.example.loginmvvm.model

import org.junit.Assert.*
import org.junit.Test

class LoginModelTest {

    private val loginModel = LoginModel()

    @Test
    fun `login with correct credentials should return true`() {
        val result = loginModel.login("admin", "password")
        assertTrue(result)
    }

    @Test
    fun `login with incorrect credentials should return false`() {
        val result = loginModel.login("user", "wrongpassword")
        assertFalse(result)
    }
}

