package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void isLibNumberWellFormedTest(){
        User user = new User("Juan", "juan@gmail.com", "342342342", "1234-5678");
        assertTrue(user.isLibNumberWellFormed());
    }

    @Test
    public void isNotLibNumberWellFormedTest(){
        User user = new User("Juan", "juan@gmail.com", "342342342", "134D-5368");
        assertFalse(user.isLibNumberWellFormed());
    }

    @Test
    public void isEmailWellFormedTest(){
        User user = new User("Juan", "juan@gmail.com", "342342342", "1234-5678");
        assertTrue(user.isEmailWellFormed());
    }

    @Test
    public void isNotEmailWellFormedTest(){
        User user = new User("Juan", "juan@gmail", "342342342", "1234-568");
        assertFalse(user.isEmailWellFormed());
    }

    @Test
    public void isPhoneWellFormedTest(){
        User user = new User("Juan", "juan@gmail.com", "123456789", "1234-5678");
        assertTrue(user.isPhoneWellFormed());
    }

    @Test
    public void isNotPhoneWellFormedTest(){
        User user = new User("Juan", "juan@gmail", "3422kasdhklas342342", "1234-568");
        assertFalse(user.isPhoneWellFormed());
    }

}
