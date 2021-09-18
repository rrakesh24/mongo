package com.example.mongo.controller;

import com.example.mongo.entity.Book;
import com.example.mongo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService ;

    @PostMapping("/book")
    public Book saveBook(@RequestBody Book book)
    {
       return  bookService.saveBook(book);
    }


    @GetMapping("/books/getAllBooks")
    public List<Book> getAllBooks()
    {
        return bookService.findAll();
    }
}
