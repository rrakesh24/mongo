package com.example.mongo.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "BookStore")
public class Book {

    private int id;
    private String bookName;
    private String author;
}
