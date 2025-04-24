package com.pluralsight;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Console console = new Console();
    private static Scanner scanner = new Scanner(System.in);
    private static Book[] library = getPopulatedBooks();

    public static void main(String[] args) {


        showScreenHome();

        // book.checkOut("Chris");
    }

    private static void showScreenHome() {

        String homeScreeenPrompt = "Welcome to the library \n" +
                "Please select an option from the following \n" +
                "    1 - Show Avaliable Books\n" +
                "    2 - Show Checked Out Books\n" +
                "    0 - Exit app \n" +
                "(1,2,0)";


        int option;

        //do-if statment because we always want to see the homeScreenPrompt

        do {
            //when we assign 'int option' above we have to take away the 'int' from below.
            option = console.promptForInt(homeScreeenPrompt);
            if (option == 1) {
                showScreenAvaliableBooks();
            } else if (option == 2) {
                showScreenCheckedOutBooks();
            } else if (option == 0) {
                System.out.println("Exiting library. Have a nice day");

            } else {
                System.out.println("not a valid option, try again");
            }
        } while (option != 0);


    }

    //Think of static as shared
    private static void showScreenAvaliableBooks() {
        //Step 1: Loop through every book in book lib
        //Step 2: Check if each book is avaliable or not
        //Step 3: Show book details of avaliable
        displayAvilableBooks();
        String YorN;
        do {
            System.out.println("\n D0 you want to check out a book?   (Y/N)");
            YorN = scanner.nextLine();
            if (YorN.equalsIgnoreCase("y")) {
                showScreenCheckOutBookYes();
            } else {
                YorN.equalsIgnoreCase("n");

            }
        } while (!YorN.equals("n"));


//        for (int i = 0; i < library.length; i++) {
//            if (!library[i].isCheckedOut()) {
//                //always object.method
//                //looked up way to print to line it up
//                System.out.printf(
//                        "Title: %-30s %-25s ID: %-5d%n",
//                        library[i].getTitle(),
//                        library[i].getIsbn(),
//                        library[i].getId()
//                );
//
//
//            }
//        }
    }

    private static void showScreenCheckOutBookYes() {

        int bookId = console.promptForInt("Please enter the book Id: ");
        String name = console.promptForString("What is your name: ");

        Book theSelectedBook = getBookById(library, bookId);

        assert theSelectedBook != null;

        theSelectedBook.checkOut(name);

        System.out.printf("%s you have checkout out successfully.\n", name);



    }





    public static void displayAvilableBooks() {
        System.out.printf("%-30s %-25s %-5s%n", "Title", "ISBN", "ID");  // Header
        System.out.println("------------------------------------------------------------");
        for (int i = 0; i < library.length; i++) {
            if (!library[i].isCheckedOut()) {
                //always object.method
                //looked up way to print to line it up
                System.out.printf(
                        "%-30s %-25s %-5d%n",
                        //"Title: %-30s %-25s ID: %-5d%n",
                        library[i].getTitle(),
                        library[i].getIsbn(),
                        library[i].getId()
                );


            }
        }
    }

    public static void showScreenCheckedOutBooks() {
        for (int i = 0; i < library.length; i++) {
            if (library[i].isCheckedOut()) {
                //always object.method
                //looked up way to print to line it up
                System.out.printf(
                        //"Title: %-30s %-25s ID: %-5d%n",
                        library[i].getTitle(),
                        library[i].getIsbn(),
                        library[i].getId() + "\n"
                );
            }
        }
        
    }



    private static Book getBookById(Book[] books, int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
    //a method to make a library called getPopulatedLibrary. can be it sown class. but not enough instructions to do so.
    //job of this method is to return an array in the shape of "book" that we names library.
    private static Book[] getPopulatedBooks() {


        //we create the books and return the whole array by naming it library
        Book[] library = new Book[20];

        library[0] = new Book(1, "978-3-16-148410-0", "To Kill a Mockingbird");
        library[1] = new Book(2, "979-1-23-456789-1", "The Great Gatsby");
        library[2] = new Book(3, "978-0-12-345678-9", "Moby-Dick");
        library[3] = new Book(4, "978-1-61-729494-5", "Pride and Prejudice");
        library[4] = new Book(5, "979-0-14-044926-6", "The Catcher in the Rye");
        library[5] = new Book(6, "978-1-86197-876-9", "The Lord of the Rings");
        library[6] = new Book(7, "979-0-06-112008-4", "Brave New World");
        library[7] = new Book(8, "978-0-395-19395-8", "The Hobbit");
        library[8] = new Book(9, "978-0-679-64100-4", "Crime and Punishment");
        library[9] = new Book(10, "978-1-59448-000-3", "The Kite Runner");
        library[10] = new Book(11, "978-0-679-64037-3", "War and Peace");
        library[11] = new Book(12, "979-0-553-21311-7", "The Book Thief");
        library[12] = new Book(13, "978-0-14-144114-6", "Jane Eyre");
        library[13] = new Book(14, "978-0-452-28424-1", "Animal Farm");
        library[14] = new Book(15, "979-1-56619-909-4", "Wuthering Heights");
        library[15] = new Book(16, "978-0-06-112241-5", "The Alchemist");
        library[16] = new Book(17, "978-0-14-026886-7", "The Odyssey");
        library[17] = new Book(18, "978-0-14-313556-2", "Little Women");
        library[18] = new Book(19, "979-0-14-243726-1", "Dracula");
        library[19] = new Book(20, "978-0-14-243726-0", "The Scarlet Letter");

        return library;

    }

}