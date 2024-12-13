package com.example.cupcake.data

import java.sql.Date

data class OrderUiState(
    val quantity: Int = 0,
    val flavor: String = "",
    val date: String = "",
    val price: String = "",
    /** Available pickup dates for the order*/
    val pickupOptions: List<String> = listOf()
)