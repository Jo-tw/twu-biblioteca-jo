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
        String testBook = String.format("%-10s %-30.25s %-10.10s %-10.10s%n", 0, b1.getTitle(), b1.getAuthor(), String.valueOf(b1.getYear()));
        String testHeader = String.format("%-10s %-30s %-10s %-10s%n", "ID", "Title", "Author", "Year");
        String testBoth = testHeader + testBook;
        assertEquals(testBoth , outContent.toString());
    }

    @Test
    public void printNoBooksTest() {
        bangaloreLibrary.printAvailableBooks();
        assertEquals("There are no books available right now\n", outContent.toString());
    }

    @Test
    public void printNoAvailableBooksTest() {
        b1.setAvailable(false);
        bangaloreLibrary.printAvailableBooks();
        assertEquals("There are no books available right now\n", outContent.toString());
    }

    @Test
    public void isBookInLibraryTest() {
        bangaloreLibrary.getBookList().add(b1);
        bangaloreLibrary.getBookList().add(b1);
        assertTrue( bangaloreLibrary.isBookInLibrary(0));

    }

    @Test
    public void isNotBookInLibraryTest() {
        assertFalse(bangaloreLibrary.isBookInLibrary(5));

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
        assertFalse(bangaloreLibrary.getBookList().get(0).isAvailable());

    }

    @Test
    public void succesReturnTest() {
        bangaloreLibrary.getBookList().add(b1);
        bangaloreLibrary.getBookList().add(b2);
        bangaloreLibrary.rentBook(1);
        assertFalse(bangaloreLibrary.getBookList().get(1).isAvailable());
        bangaloreLibrary.returnBook(1);
        assertTrue( bangaloreLibrary.getBookList().get(1).isAvailable());

    }

    @Test
    public void successReturnBookMsgTest() {
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
