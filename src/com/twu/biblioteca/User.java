package com.twu.biblioteca;

import java.util.regex.Pattern;

class User {
    private String name;
    private String email;
    private String phone;

    private String libraryNumber;
    private String password;


    User(String name, String email, String phone, String libraryNumber) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.libraryNumber = libraryNumber;
        this.password = "123";
    }

    String getPassword() {
        return password;
    }

    boolean isLibNumberWellFormed() {
        Pattern libNumPattern = Pattern.compile("\\d{4}-\\d{4}");
        return libNumPattern.matcher(this.libraryNumber).matches();

    }

    boolean isEmailWellFormed(){
        Pattern emailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        return emailPattern.matcher(this.email).matches();
    }

    boolean isPhoneWellFormed() {
        Pattern phonePattern = Pattern.compile("\\d{9}");
        return phonePattern.matcher(this.phone).matches();

    }
    String getLibraryNumber() {
        return libraryNumber;
    }



    void print(){
        System.out.printf("Name: %s%nEmail: %s%nPhone: %s%nLibrary Number: %s%n", this.name, this.email, this.phone, this.libraryNumber);
    }
}
