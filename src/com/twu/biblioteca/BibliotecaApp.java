package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    static void printer(String toBePrinted) {
        System.out.println(toBePrinted);
    }

    static void printer(String toBePrinted, String type) {
        System.out.printf(toBePrinted, type);
    }



    public static void main(String[] args) {
        BibliotecaApp.printer("\nWelcome to Bangalore Public Library");
        Library bangolore = new Library();
        bangolore.loadBooks();
        bangolore.loadMovies();
        bangolore.loadUsers();
        int id;
        String libNumber;
        String pass;
        Scanner scan = new Scanner(System.in);
        do{

            BibliotecaApp.printer("Please login in the system to continue");
            BibliotecaApp.printer("Enter your Library Number:");
            libNumber = scan.nextLine();
            BibliotecaApp.printer("Enter your Password:");
            pass = scan.nextLine();



        }while (!bangolore.login(libNumber, pass));
        String choice ;
        do {

            BibliotecaApp.printer("\n\nPlease select an option: \n a. List books \n b. List movies \n c. Checkout an item \n d. Return an item \n q. Quit\n\n");
            choice = scan.nextLine();
            switch (choice) {
                case "a":
                    bangolore.printAvailableItems("book");
                    break;
                case "b":
                    bangolore.printAvailableItems("movie");
                    break;
                case "c":
                    BibliotecaApp.printer("Enter the Number ID of the item you want to check out: ");
                    id = Integer.parseInt(scan.nextLine());
                    bangolore.rentItem(id,libNumber);
                    break;

                case "d":
                    BibliotecaApp.printer("Enter the Number ID of the item you want to return: ");
                    id = Integer.parseInt(scan.nextLine());
                    bangolore.returnItem(id, libNumber);
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
