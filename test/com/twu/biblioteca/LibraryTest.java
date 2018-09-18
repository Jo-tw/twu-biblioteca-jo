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
    private Book b1 = new Book("To Kill a Mockingbird", 101,"Harper Lee", 1964);
    private Book b2 = new Book("1984", 102,"George Orwell", 1949);
    private User testUser = new User("Sergio","sergio@tw.com", "423456789", "4444-4444");
    private List<Item> emptyList = new ArrayList<>();
    private Library bangaloreLibrary = new Library();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }


    @Test
    public void emptyBookListTest() {
        List returnedList = bangaloreLibrary.getItemList();
        assertEquals(emptyList, returnedList);

    }

    @Test
    public void bookListTest() {
        bangaloreLibrary.getItemList().add(b1);
        assertEquals(1, bangaloreLibrary.getItemList().size());

    }


    @Test
    public void printNoBooksTest() {
        bangaloreLibrary.printAvailableItems("book");
        assertEquals("There are no movies nor books available right now\n", outContent.toString());
    }

    @Test
    public void printNoAvailableBooksTest() {
        bangaloreLibrary.printAvailableItems("movie");
        assertEquals("There are no movies nor books available right now\n", outContent.toString());
    }

    @Test
    public void isBookInLibraryTest() {
        bangaloreLibrary.getItemList().add(b1);
        bangaloreLibrary.getItemList().add(b1);
        assertTrue( bangaloreLibrary.isItemInLibrary(101));

    }

    @Test
    public void isNotBookInLibraryTest() {
        assertFalse(bangaloreLibrary.isItemInLibrary(5));

    }

    @Test
    public void successRentBookMsgTest() {
        bangaloreLibrary.getItemList().add(b1);
        bangaloreLibrary.getItemList().add(b2);
        bangaloreLibrary.rentItem(101, testUser.getLibraryNumber());
        assertEquals("Thank you! Enjoy the book", outContent.toString());

    }


    @Test
    public void unSuccessRentBookMsgTest() {
        bangaloreLibrary.rentItem(25, testUser.getLibraryNumber());
        assertEquals("That book is not available\n", outContent.toString());

    }

    @Test
    public void successRentBookTest() {
        bangaloreLibrary.getItemList().add(b1);
        bangaloreLibrary.rentItem(101, testUser.getLibraryNumber());
        assertFalse(bangaloreLibrary.getItemList().get(0).isAvailable());

    }

    @Test
    public void succesReturnTest() {
        bangaloreLibrary.getItemList().add(b1);
        bangaloreLibrary.rentItem(101, testUser.getLibraryNumber());
        assertFalse(bangaloreLibrary.getItem(101).isAvailable());
        bangaloreLibrary.returnItem(101, testUser.getLibraryNumber());
        assertTrue( bangaloreLibrary.getItem(101).isAvailable());

    }

    @Test
    public void successReturnBookMsgTest() {
        bangaloreLibrary.getItemList().add(b1);
        bangaloreLibrary.getItemList().add(b2);
        bangaloreLibrary.rentItem(101, testUser.getLibraryNumber());
        outContent.reset();
        bangaloreLibrary.returnItem(101, testUser.getLibraryNumber());
        assertEquals("Thank you for returning the book", outContent.toString());

    }

    @Test
    public void unSuccessReturnBookMsgTest() {
        bangaloreLibrary.getItemList().add(b1);
        bangaloreLibrary.getItemList().add(b2);
        bangaloreLibrary.returnItem(101, testUser.getLibraryNumber());
        assertEquals("That is not a valid book to return", outContent.toString());

    }

    @Test
    public void loadBooksTest() {
        bangaloreLibrary.loadBooks();
        assertEquals(9, bangaloreLibrary.getItemList().size());

    }


}
