package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    static void printer(String toBePrinted) {
        System.out.println(toBePrinted);
    }


    public static void main(String[] args) {
        //new BibliotecaApp(new Library(), new Scanner());
        BibliotecaApp.printer("\nWelcome to Bangalore Public Library");
        Library bangolore = new Library();
        bangolore.loadBooks();
        int id;
        String choice ;
        Scanner scan = new Scanner(System.in);
        do {
            BibliotecaApp.printer("\n\nPlease select an option: \n a. List books \n b. Checkout a book \n c. Return a book \n q. Quit\n\n");
            choice = scan.nextLine();
            switch (choice) {
                case "a":
                    bangolore.printAvailableBooks();
                    break;
                case "b":
                    BibliotecaApp.printer("Enter the Number ID of the book you want to check out: ");
                    id = Integer.parseInt(scan.nextLine());
                    bangolore.rentBook(id);
                    break;

                case "c":
                    BibliotecaApp.printer("Enter the Number ID of the book you want to return: ");
                    id = Integer.parseInt(scan.nextLine());
                    bangolore.returnBook(id);
                    break;

                case "q":
                    BibliotecaApp.printer("Thanks for using the Bangalore Public Library System - Have a nice day");
                    System.exit(0);

                default:
                    BibliotecaApp.printer("Invalid option please select again");
            }
        } while (!choice.equals("q")); // end of loop
    }


}
