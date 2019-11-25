package com.example.musicservice.common

import android.util.Patterns
import kotlinx.android.synthetic.main.activity_login.*

class Validator {
    companion object {
        private val MIN_PASSWORD_LENGTH = 8
        private val MIN_USERNAME_LENGTH = 3

        fun isEmailValid(email: String) = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        fun isPasswordValid(password: String) = password.length >= MIN_PASSWORD_LENGTH
        fun isUsernameValid(username: String) = username.length >= MIN_USERNAME_LENGTH
    }
}