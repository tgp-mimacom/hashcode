package com.flowable.machacasaurios;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryScoreCalculator {

    public static Long calculateScore(long totalDays,
                                      long daysToSignup,
                                      List<Book> books,
                                      long numberOfBooksPerDay ) {

        long totalDaysToScan = totalDays - daysToSignup;

        ArrayList<Long> bookScores = new ArrayList<>();
        for( Book b : books ){
            bookScores.add(b.score);
        }
        bookScores.sort(Comparator.reverseOrder());

        int it = 0;
        long scoreTotal = 0;
        while( totalDaysToScan > 0 ) {
            for( int i = 0; i < numberOfBooksPerDay; i++) {
                if( it < bookScores.size())
                    scoreTotal += bookScores.get(it);
                it++;
            }
            totalDaysToScan--;
        }

        return scoreTotal;
    }
}
