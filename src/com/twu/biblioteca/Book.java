package com.twu.biblioteca;

public class Book {


    private String title;
    private String Author;
    private int year;
    private boolean availability;

    Book(String title, String author, int year) {
        this.title = title;
        Author = author;
        this.year = year;
        this.availability = true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
