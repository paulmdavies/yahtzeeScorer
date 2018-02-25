package com.paulmdavies.yahtzeeScorer.moves;

import com.paulmdavies.yahtzeeScorer.Hand;

import java.util.Arrays;

public class YahtzeeMove implements Move {
    @Override
    public Integer score(Hand hand) {
        if (hand.nonZeroDieGroups().equals(Arrays.asList(5))) {
            return 50;
        }
        return 0;
    }
}
