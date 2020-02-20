package com.flowable.machacasaurios;

import java.util.List;

public class Library {
    long id;

    long signupDays;

    long numberOfBooksPerDay;

    long numberOfBooksInLibrary;

    public Library(long id, long signupDays, long numberOfBooksPerDay, long numberOfBooksInLibrary) {
        this.id = id;
        this.signupDays = signupDays;
        this.numberOfBooksPerDay = numberOfBooksPerDay;
        this.numberOfBooksInLibrary = numberOfBooksInLibrary;
    }

    List<Book> books;

    public Library(long id) {
        this.id = id;
    }

    public long getSignupDays() {
        return signupDays;
    }

    public void setSignupDays(long signupDays) {
        this.signupDays = signupDays;
    }

    public long getNumberOfBooksPerDay() {
        return numberOfBooksPerDay;
    }

    public void setNumberOfBooksPerDay(long numberOfBooksPerDay) {
        this.numberOfBooksPerDay = numberOfBooksPerDay;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
