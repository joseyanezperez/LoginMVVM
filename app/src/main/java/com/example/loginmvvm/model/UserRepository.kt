package com.example.loginmvvm.model

class UserRepository {
    fun login(username: String, password: String): Boolean {
        // Simulated authentication (replace with real authentication logic)
        return username == "admin" && password == "password"
    }
}
