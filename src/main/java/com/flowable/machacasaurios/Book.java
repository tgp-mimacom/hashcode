package com.flowable.machacasaurios;

public class Book {

    long id;

    long score;

    boolean scanned;

    public Book(long id) {
        this.id = id;
    }

    public Book(long id, long score) {
        this.id = id;
        this.score = score;
    }

    public boolean hasScanned() {
        return scanned;
    }

    public void setScanned(boolean scanned) {
        this.scanned = scanned;
    }



    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public Book(long id, long score, boolean scanned) {
        this.id = id;
        this.score = score;
        this.scanned = scanned;
    }
}
