package com.twu.biblioteca;

import java.util.List;

class Library {
    private List<Book> bookList;

    Library(List<Book> bookList) {
        this.bookList = bookList;
    }


    List<Book> getBookList() {
        return bookList;
    }

     void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }





}
