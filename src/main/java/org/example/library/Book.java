package org.example.library;

import java.util.List;

public class Book {

    private String name;
    private String position;
    private String author;
    private List<Book> books;

    public Book(String name,String author){
        this.name = name;
        this.author = author;


    }

    public String getName(){
        return this.name;
    }

    public String getAuthor(){
        return  this.author;
    }


}
