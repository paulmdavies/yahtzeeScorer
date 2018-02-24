package com.paulmdavies.yahtzeeScorer.moves;

import com.paulmdavies.yahtzeeScorer.Hand;

import java.util.Comparator;

public class ThreeOfAKindMove implements Move {
    @Override
    public Integer score(Hand hand) {
        if (hand.nonZeroDieGroups().stream().max(Comparator.comparingInt(Integer::intValue)).get() >= 3) {
            return hand.sumOfDice();
        }
        return 0;
    }
}
