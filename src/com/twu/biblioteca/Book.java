package com.twu.biblioteca;

class Book extends Item {

    private String author;

    Book(String name, int id, String author, int year) {
        super(name, id, year, "book");
        this.author = author;

    }



    void print(){
        super.print();
        System.out.printf("Author: %s%n", this.author);
    }


}
