package com.flowable.machacasaurios;

import java.util.List;

public class Library {

    long signupDays;

    long numberOfBooksPerDay;

    List<Book> books;

    public Library(long signupDays, long numberOfBooksPerDay, List<Book> books) {
        this.signupDays = signupDays;
        this.numberOfBooksPerDay = numberOfBooksPerDay;
        this.books = books;
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
