package com.twu.biblioteca;

class Movie extends Item {
    private String director;
    private int rating;

    Movie(String name, int id, String director, int rating, int year) {
        super(name, id, year, "movie");
        this.director = director;
        this.rating = rating;

    }

    void print(){
        super.print();
        System.out.printf("Director: %s%nRating: %d%n", this.director, this.rating);
    }

}
