package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

class Library {
    private List<Book> bookList;

    Library() {
        this.bookList = new ArrayList<Book>();
    }

    List<Book> getBookList() {
        return bookList;
    }

    void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    void loadBooks() {
        this.bookList.add(new Book("To Kill a Mockingbird", "Harper Lee", 1964));
        this.bookList.add(new Book("1984", "George Orwell", 1949));
        this.bookList.add(new Book("The Great Gatsby", "F. Scott Fitzgerald  ", 1964));
        this.bookList.add(new Book("Harry Potter and the Sorcerer's Stone", "J. K. Rowling", 1996));
        this.bookList.add(new Book("The Hobbit", "J.R.R. Tolkien", 1964));
        this.bookList.add(new Book(" The Diary of a Young Girl", "Anne Frank", 1949));
        this.bookList.add(new Book("Fahrenheit 451", "Ray Bradbury", 1964));
        this.bookList.add(new Book("The grapes of Wrath", "John Steinbeck", 1949));
        this.bookList.add(new Book("The Catcher in the Rye ", "J.D. Salinger", 1964));
    }

    void printAvailableBooks() {
        boolean firstLoop = true;
        String formatText;
        for (Book b : this.bookList) {
            if (b.isAvailable()) {

                if (firstLoop) {
                    formatText = String.format("%-10s %-30s %-10s %-10s", "ID", "Title", "Author", "Year");
                    BibliotecaApp.printer(formatText);
                            firstLoop = false;
                }

                //System.out.printf("%-10s %-30.20s %-10.10s %-10.10s%n", this.bookList.indexOf(b), b.getTitle(), b.getAuthor(), String.valueOf(b.getYear()));
                formatText = String.format("%-10s %-30.25s %-10.10s %-10.10s", this.bookList.indexOf(b), b.getTitle(), b.getAuthor(), String.valueOf(b.getYear()));
                BibliotecaApp.printer(formatText);
            }

        }
        if (firstLoop) {
            BibliotecaApp.printer("There are no books available right now");
        }
    }

    boolean isBookInLibrary(int id) {
        return 0 <= id && id < this.bookList.size();
    }

    void rentBook(int id) {
        if (this.isBookInLibrary(id) && this.bookList.get(id).isAvailable()) {

            this.bookList.get(id).setAvailable(false);
            BibliotecaApp.printer("Thank you! Enjoy the book");
            return;

        }
        BibliotecaApp.printer("That book is not available");


    }

    void returnBook(int id) {
        if (this.isBookInLibrary(id) && !this.bookList.get(id).isAvailable()) {
            this.bookList.get(id).setAvailable(true);
            BibliotecaApp.printer("Thank you for returning the book");
        } else {
            BibliotecaApp.printer("That is not a valid book to return");
        }

    }

}
