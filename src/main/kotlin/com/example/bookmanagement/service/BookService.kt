package com.example.bookmanagement.service

import com.example.bookmanagement.dto.BookRequest
import com.example.bookmanagement.dto.BookResponse
import com.example.bookmanagement.entity.Book
import com.example.bookmanagement.exception.BookNotFoundException
import com.example.bookmanagement.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    private val bookRepository: BookRepository
) {

    // Add a book
    fun addBook(request: BookRequest): BookResponse {

        val book = Book(
            title = request.title,
            author = request.author,
            price = request.price
        )

        val savedBook = bookRepository.save(book)

        return BookResponse(
            id = savedBook.id!!,
            title = savedBook.title,
            author = savedBook.author,
            price = savedBook.price
        )
    }

    // Get all books
    fun getAllBooks(): List<BookResponse> {

        return bookRepository.findAll().map { book ->
            BookResponse(
                id = book.id!!,
                title = book.title,
                author = book.author,
                price = book.price
            )
        }
    }

    // Get a book by ID
    fun getBookById(id: Long): BookResponse {

        val book = bookRepository.findById(id)
            .orElseThrow {
                BookNotFoundException("Book not found with id: $id")
            }

        return BookResponse(
            id = book.id!!,
            title = book.title,
            author = book.author,
            price = book.price
        )
    }

    // Update a book
    fun updateBook(id: Long, request: BookRequest): BookResponse {

        val book = bookRepository.findById(id)
            .orElseThrow {
                BookNotFoundException("Book not found with id: $id")
            }

        book.title = request.title
        book.author = request.author
        book.price = request.price

        val updatedBook = bookRepository.save(book)

        return BookResponse(
            id = updatedBook.id!!,
            title = updatedBook.title,
            author = updatedBook.author,
            price = updatedBook.price
        )
    }

    // Delete a book
    fun deleteBook(id: Long) {

        val book = bookRepository.findById(id)
            .orElseThrow {
                BookNotFoundException("Book not found with id: $id")
            }

        bookRepository.delete(book)
    }
}