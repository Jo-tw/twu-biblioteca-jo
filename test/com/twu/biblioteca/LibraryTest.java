package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class LibraryTest {
    private Book b1 = new Book("To Kill a Mockingbird", "Harper Lee", 1964);
    private List<Book> emptyList = new ArrayList<Book>();
    private Library bangaloreLibrary = new Library(emptyList);

    @Test
    public void emptyBookListTest() {
        List returnedList = bangaloreLibrary.getBookList();
        assertEquals(emptyList, returnedList);

    }

    @Test
    public void BookListTest() {
        bangaloreLibrary.getBookList().add(b1);

        assertEquals(1, bangaloreLibrary.getBookList().size());

    }
}
