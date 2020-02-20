package com.flowable.machacasaurios;

import java.util.ArrayList;
import java.util.Comparator;

public class LibraryScoreCalculator {

    public static Long calculateScore(long totalDays,
                                      long daysToSignup,
                                      ArrayList<Long> books) {

        long totalDaysToScan = totalDays - daysToSignup;

        //books.sort(Comparator.reverseOrder());

        return totalDaysToScan;
    }
}
