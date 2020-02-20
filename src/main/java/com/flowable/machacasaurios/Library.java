package com.flowable.machacasaurios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Library implements Comparable<Library> {
    long id;

    long signupDays;

    long numberOfBooksPerDay;

    long numberOfBooksInLibrary;

    long score;

    public Long calculateScore(long totalDays,
                                      long daysToSignup,
                                      List<Book> books,
                                      long numberOfBooksPerDay ) {

        long totalDaysToScan = totalDays - daysToSignup;

        ArrayList<Long> bookScores = new ArrayList<>();
        for( Book b : books ){
            bookScores.add(b.score);
        }
        bookScores.sort(Comparator.reverseOrder());

        long scoreTotal = 0;
        int it = 0;
        while( totalDaysToScan >= 0 && bookScores.size() > 0 ) {
            for( int i = 0; i < numberOfBooksPerDay; i++) {
                if( it < bookScores.size() && it >= 0)
                {
                    scoreTotal += bookScores.get(it);
                    //System.out.println(it);
                }
                it++;
            }
            totalDaysToScan--;
        }

        score = scoreTotal;

        return scoreTotal;
    }

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

    @Override
    public int compareTo(Library o) {
        return this.score<o.score?-1:
                this.score>o.score?1:0;
    }
}
