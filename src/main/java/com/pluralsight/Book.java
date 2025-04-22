package com.pluralsight;


//properties. We are defining a singular book. and weather it is check in or not
//Think about what we can do with the book we are creating. The computed doesnt know what a book is
public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;



    //predefined var. "this" refers to current object. belongs to the var above: to distinguish which one we are working with. which is what is changed in the main class
    //starts out that it is not checked out
    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    //setters and getters: Think about what we can do with the book we are creating

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //method to check if its checked out
    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    //method
    public String getCheckedOutTo() {
        return checkedOutTo;
    }

//    //we use 'this' because we already have a 'checkedOutTo ' variable which makes it ambigious which checkedOut to use. This referes to using the variable checkedOut but the one we can change
//    public void setCheckedOutTo(String checkedOutTo) {
//        this.checkedOutTo = checkedOutTo;
//    }

    //method checkOut. Takes in the string name for who checked out book. Data is being remembered. so we create a method
    //'this' is being extra explicit. It isn't needed, but it takes away any ambiguity.
    public void checkOut(String name){
        //the paramaters we are checking method 'checkOut' for. Is it checked out? has to be true. whos it checked out too-> name
        this.isCheckedOut = true;
        this.checkedOutTo = name;

    }

    //method checkin. Takes in nothing because we are just checking in. So we tell it how to behave when book is checked in
    public void checkIn(){
        this.checkedOutTo = "";
        this.isCheckedOut = false;

    }
}
