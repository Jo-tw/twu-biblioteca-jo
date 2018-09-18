package com.twu.biblioteca;

class Item {


    private String name;
    private int id;
    private int year;
    String borrowedBy;
    private String type;


    Item(String name, int id, int year, String type) {
        this.name = name;
        this.id = id;
        this.borrowedBy = null;
        this.year = year;
        this.type = type;

    }


    int getId() {
        return id;
    }
    boolean isAvailable() {
        return borrowedBy == null;
    }

    void setBorrowedBy(String libraryNumber) {
        this.borrowedBy = libraryNumber;
    }

    void print(){
        System.out.println("\n- - - - - - - - - - - - - - ");
        System.out.printf("\n\nID: %s%nName: %s%nYear: %s%n", this.id, this.name, String.valueOf(year));
    }

    String getName() {
        return name;
    }

    String getType() {
        return type;
    }


    boolean isId(int id){
        return this.id == id;
    }
}
