package org.example.library;

import java.util.ArrayList;
import java.util.List;

public class Library {

    // 속석
    private String name;
    private String position;
    private List<Book> books;

    //생성자
    public Library(){
        this.name = "A";
        this.books = new ArrayList<>();
    }


    //기능

    public void addBook(Book book){
        books.add(book);
    }

    public Book findBook(String bookName){
        for(Book book : books){
            if (bookName.equals(book.getName())){
                return book;
            };
        }
        return null;
    }

    public Book rentBook(){
        return books.get(0);
    }
}
