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
    private Book b2 = new Book("1984", "George Orwell", 1949);
    private List<Book> emptyList = new ArrayList<Book>();
    private Library bangaloreLibrary = new Library(emptyList);
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

    @Test
    public void printNoBooksTest() {
        bangaloreLibrary.printAvailableBooks();
        assertEquals("There are no books available right now\n", outContent.toString());
    }

    @Test
    public void printNoAvailableBooksTest() {
        b1.setAvailability(false);
        bangaloreLibrary.printAvailableBooks();
        assertEquals("There are no books available right now\n", outContent.toString());
    }

    @Test
    public void isBookInLibraryTest() {
        bangaloreLibrary.getBookList().add(b1);
        bangaloreLibrary.getBookList().add(b1);
        assertEquals(true, bangaloreLibrary.isBookInLibrary(0));

    }

    @Test
    public void isNotBookInLibraryTest() {
        assertEquals(false, bangaloreLibrary.isBookInLibrary(5));

    }

    @Test
    public void successRentBookMsgTest() {
        bangaloreLibrary.getBookList().add(b1);
        bangaloreLibrary.getBookList().add(b2);
        bangaloreLibrary.rentBook(1);
        assertEquals("Thank you! Enjoy the book\n", outContent.toString());

    }


    @Test
    public void unSuccessRentBookMsgTest() {
        bangaloreLibrary.rentBook(25);
        assertEquals("That book is not available\n", outContent.toString());

    }

    @Test
    public void successRentBookTest() {
        bangaloreLibrary.getBookList().add(b1);
        bangaloreLibrary.getBookList().add(b2);
        bangaloreLibrary.rentBook(0);
        assertEquals(false, bangaloreLibrary.getBookList().get(0).isAvailability());

    }

    @Test
    public void SuccesReturnTest() {
        bangaloreLibrary.getBookList().add(b1);
        bangaloreLibrary.getBookList().add(b2);
        bangaloreLibrary.rentBook(1);
        assertEquals(false, bangaloreLibrary.getBookList().get(1).isAvailability());
        bangaloreLibrary.returnBook(1);
        assertEquals(true, bangaloreLibrary.getBookList().get(1).isAvailability());

    }

    @Test
    public void SuccessReturnBookMsgTest() {
        bangaloreLibrary.getBookList().add(b1);
        bangaloreLibrary.getBookList().add(b2);
        bangaloreLibrary.rentBook(1);
        outContent.reset();
        bangaloreLibrary.returnBook(1);
        assertEquals("Thank you for returning the book\n", outContent.toString());

    }

    @Test
    public void unSuccessReturnBookMsgTest() {
        bangaloreLibrary.getBookList().add(b1);
        bangaloreLibrary.getBookList().add(b2);
        bangaloreLibrary.returnBook(1);
        assertEquals("That is not a valid book to return\n", outContent.toString());

    }

    @Test
    public void loadBooksTest() {
        bangaloreLibrary.loadBooks();
        assertEquals(9, bangaloreLibrary.getBookList().size());

    }


}
