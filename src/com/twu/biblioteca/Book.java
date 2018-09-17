package com.twu.biblioteca;

public class Book {


    private String title;
    private String author;
    private int year;
    private boolean available;

    Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true;
    }

    String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    boolean isAvailable() {
        return available;
    }

    void setAvailable(boolean available) {
        this.available = available;
    }
}
