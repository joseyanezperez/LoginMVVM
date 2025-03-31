package com.example.loginmvvm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.loginmvvm.model.UserRepository
import com.example.loginmvvm.viewmodel.LoginViewModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class LoginViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule() // Allows LiveData to update synchronously

    private val repository: UserRepository = mockk()
    private val viewModel = LoginViewModel(repository) // Pass mock repository

    @Test
    fun `login with valid credentials should update LiveData with true`() {
        every { repository.login("admin", "password") } returns true

        val observer = mockk<Observer<Boolean>>(relaxed = true)
        viewModel.loginResult.observeForever(observer)

        viewModel.login("admin", "password")

        verify { observer.onChanged(true) }
        assertEquals(true, viewModel.loginResult.value)
    }

    @Test
    fun `login with invalid credentials should update LiveData with false`() {
        every { repository.login("user", "wrongpassword") } returns false

        val observer = mockk<Observer<Boolean>>(relaxed = true)
        viewModel.loginResult.observeForever(observer)

        viewModel.login("user", "wrongpassword")

        verify { observer.onChanged(false) }
        assertEquals(false, viewModel.loginResult.value)
    }
}
