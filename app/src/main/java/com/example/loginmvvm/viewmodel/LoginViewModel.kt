package com.example.loginmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loginmvvm.model.UserRepository

class LoginViewModel(private val repository: UserRepository = UserRepository()) : ViewModel() {
    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> get() = _loginResult

    fun login(username: String, password: String) {
        _loginResult.value = repository.login(username, password)
    }
}

