package com.example.bookmanagement.repository

import com.example.bookmanagement.entity.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Long>