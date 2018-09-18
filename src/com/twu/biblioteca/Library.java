package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

class Library {
    private List<Item> itemList;
    private List<User> userList;


    Library() {
        this.itemList = new ArrayList<>();
        this.userList = new ArrayList<>();
    }


    List<Item> getItemList() {
        return this.itemList;
    }


    Item getItem(int id) {
        for (Item item : this.itemList) {
            if (item.getId() == id) {
                return item;
            }

        }
        return null;
    }

    void loadBooks() {
        this.itemList.add(new Book("To Kill a Mockingbird", 101, "Harper Lee", 1964));
        this.itemList.add(new Book("1984", 102, "George Orwell", 1949));
        this.itemList.add(new Book("The Great Gatsby", 103, "F. Scott Fitzgerald  ", 1964));
        this.itemList.add(new Book("Harry Potter and the Sorcerer's Stone", 104, "J. K. Rowling", 1996));
        this.itemList.add(new Book("The Hobbit", 105, "J.R.R. Tolkien", 1964));
        this.itemList.add(new Book("The Diary of a Young Girl", 106, "Anne Frank", 1949));
        this.itemList.add(new Book("Fahrenheit 451", 107, "Ray Bradbury", 1964));
        this.itemList.add(new Book("The grapes of Wrath", 108, "John Steinbeck", 1949));
        this.itemList.add(new Book("The Catcher in the Rye ", 109, "J.D. Salinger", 1964));
    }


    void loadMovies() {
        this.itemList.add(new Movie("Pride & Prejudice", 201, "Joe Wright", 8, 2005));
        this.itemList.add(new Movie("V for Vendetta", 202, "Wachowski Systers", 9, 2005));
        this.itemList.add(new Movie("The Reader", 203, "Stephen Daldry", 8, 2009));
        this.itemList.add(new Movie("The Godfather", 204, "Francis Ford Coppola", 9, 1972));
        this.itemList.add(new Movie("The Lord of the Rings", 205, " Peter Jackson", 10, 2001));

    }

    void loadUsers() {
        this.userList.add(new User("Juandi", "juandi@tw.com", "123456789", "1111-1111"));
        this.userList.add(new User("Noemi", "noemi@tw.com", "223456789", "2222-2222"));
        this.userList.add(new User("Susan", "susan@tw.com", "323456789", "3333-3333"));
        this.userList.add(new User("Sergio", "sergio@tw.com", "423456789", "4444-4444"));
        this.userList.add(new User("Berta", "berta@tw.com", "523456789", "5555-5555"));

    }


    void printAvailableItems(String type) {
        boolean firstLoop = true;
        for (Item item : this.itemList) {
            if (item.isAvailable() && item.getType().equals(type)) {
                firstLoop = false;
                item.print();
            }
        }
            if (firstLoop) {
                BibliotecaApp.printer("There are no movies nor books available right now" );
            }
    }


    boolean isItemInLibrary(int id) {
        for (Item m : this.itemList) {
            if (m.isId(id)) {
                return true;
            }
        }
        return false;
    }


    void rentItem(int id, String libraryNumber) {
        if (this.isItemInLibrary(id)) {
            if (getItem(id).isAvailable()) {

                getItem(id).setBorrowedBy(libraryNumber);
                BibliotecaApp.printer("Thank you! Enjoy the %s", getItem(id).getType());
                return;
            }
        }
        BibliotecaApp.printer("That book is not available");


    }

    void returnItem(int id, String libraryNumber) {
        if (this.isItemInLibrary(id) && !getItem(id).isAvailable()) {
            if (getItem(id).borrowedBy.equals(libraryNumber)) {
                getItem(id).setBorrowedBy(null);
                BibliotecaApp.printer("Thank you for returning the %s", getItem(id).getType());
            } else {
                BibliotecaApp.printer("Invalid User");
            }
        } else {
            BibliotecaApp.printer("That is not a valid %s to return", getItem(id).getType());
        }

    }


    boolean login(String libNumber, String password) {

        for (User user : this.userList) {
            if (user.getLibraryNumber().equals(libNumber) && user.getPassword().equals(password)) {

                return true;
            }
        }

        return false;
    }


}
