package com.example.bookmanagement.dto

data class BookResponse(
    val id: Long,
    val title: String,
    val author: String,
    val price: Double
)