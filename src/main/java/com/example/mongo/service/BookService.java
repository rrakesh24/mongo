package com.example.mongo.service;

import com.example.mongo.entity.Book;
import com.example.mongo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findAll() {
        List<Book> book = bookRepository.findAll();
        System.out.println("Mocking Data" + book);
        return book;
    }

    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    public Book addBook(Book book) {
        Book book1 = bookRepository.save(book);
        System.out.println("Mock Objects being Returned"+book1);
        return book1;
    }
}
