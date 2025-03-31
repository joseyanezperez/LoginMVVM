package com.example.loginmvvm.model

import org.junit.Assert.*
import org.junit.Test

class UserRepositoryTest {

    private val userRepository = UserRepository()

    @Test
    fun `login with correct credentials should return true`() {
        val result = userRepository.login("admin", "password")
        assertTrue(result)
    }

    @Test
    fun `login with incorrect credentials should return false`() {
        val result = userRepository.login("user", "wrongpassword")
        assertFalse(result)
    }
}

