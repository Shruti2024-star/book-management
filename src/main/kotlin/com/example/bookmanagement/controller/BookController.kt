package com.example.bookmanagement.controller

import com.example.bookmanagement.dto.BookRequest
import com.example.bookmanagement.dto.BookResponse
import com.example.bookmanagement.service.BookService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
class BookController(
    private val bookService: BookService
) {

    // Add a book
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addBook(@RequestBody request: BookRequest): BookResponse {
        return bookService.addBook(request)
    }

    // Get all books
    @GetMapping
    fun getAllBooks(): List<BookResponse> {
        return bookService.getAllBooks()
    }

    // Get book by ID
    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: Long): BookResponse {
        return bookService.getBookById(id)
    }

    // Update book
    @PutMapping("/{id}")
    fun updateBook(
        @PathVariable id: Long,
        @RequestBody request: BookRequest
    ): BookResponse {
        return bookService.updateBook(id, request)
    }

    // Delete book
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBook(@PathVariable id: Long) {
        bookService.deleteBook(id)
    }
}