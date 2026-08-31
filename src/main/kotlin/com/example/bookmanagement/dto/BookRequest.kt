package com.example.bookmanagement.dto

data class BookRequest(
    val title: String,
    val author: String,
    val price: Double
)