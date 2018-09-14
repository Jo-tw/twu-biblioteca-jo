package com.twu.biblioteca;


import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BibliotecaAppTest {

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
    public void welcomeMessageTest() {

        BibliotecaApp.printer("Welcome to Bangalore Public Library");
        assertEquals("Welcome to Bangalore Public Library\n", outContent.toString());

    }


}





