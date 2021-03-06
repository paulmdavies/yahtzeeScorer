package com.paulmdavies.yahtzeeScorer.moves;

import com.paulmdavies.yahtzeeScorer.Hand;

import java.util.Arrays;

public class FullHouseMove implements Move {
    @Override
    public Integer score(Hand hand) {
        if (hand.nonZeroDieGroups().equals(Arrays.asList(2,3)) || hand.nonZeroDieGroups().equals(Arrays.asList(5))) {
            return 25;
        }
        return 0;
    }
}
