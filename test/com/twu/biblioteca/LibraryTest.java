package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class LibraryTest {
    private Book b1 = new Book("To Kill a Mockingbird", "Harper Lee", 1964);
    private List<Book> emptyList = new ArrayList<Book>();
    private Library bangaloreLibrary = new Library(emptyList);
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {System.setOut(originalOut);
    }


    @Test
    public void emptyBookListTest() {
        List returnedList = bangaloreLibrary.getBookList();
        assertEquals(emptyList, returnedList);

    }

    @Test
    public void bookListTest() {
        bangaloreLibrary.getBookList().add(b1);
        assertEquals(1, bangaloreLibrary.getBookList().size());

    }

    @Test
    public void printAvailableBooksTest() {
        bangaloreLibrary.getBookList().add(b1);
        bangaloreLibrary.printAvailableBooks();
        assertEquals("Index      Title      Author     Year      \n0          To Kill a  Harper Lee 1964      \n", outContent.toString());
    }
}
