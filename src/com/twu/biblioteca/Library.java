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

    void printAvailableBooks() {
        System.out.printf("%-10s %-10s %-10s %-10s%n", "Index", "Title", "Author", "Year");
        for (Book b : this.bookList) {
            if (b.isAvailability()) {
                System.out.printf("%-10.10s %-10.10s %-10.10s %-10.10s%n", this.bookList.indexOf(b), b.getTitle(), b.getAuthor(), String.valueOf(b.getYear()));

            }
        }
    }


}
