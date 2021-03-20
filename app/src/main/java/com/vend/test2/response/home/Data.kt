package com.vend.test2.response.home

data class Data(
    val caradvetisement: List<Caradvetisement>,
    val generaladvetisement: List<Any>,
    val propertyadvetisement: List<Any>,
    val recentadvetisement: List<Recentadvetisement>
)