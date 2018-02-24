package com.paulmdavies.yahtzeeScorer.moves;

import com.paulmdavies.yahtzeeScorer.Hand;

import java.util.Comparator;

public class FourOfAKindMove implements Move {
    @Override
    public Integer score(Hand hand) {
        if (hand.nonZeroDieGroups().stream().max(Comparator.comparingInt(Integer::intValue)).get() >= 4) {
            return hand.sumOfDice();
        }
        return 0;
    }
}
