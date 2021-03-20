package com.vend.test2.response.login

data class Data(
    val firstName: String,
    val id: String,
    val isBusinessUser: Int,
    val jwtToken: String,
    val lastName: String,
    val name: String,
    val refreshToken: String
)