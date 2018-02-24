package com.paulmdavies.yahtzeeScorer.moves;

import com.paulmdavies.yahtzeeScorer.Hand;

import java.util.Comparator;

public abstract class NumberOfAKindMove implements Move {
    private Integer number;

    public NumberOfAKindMove(Integer number) {
        this.number = number;
    }

    @Override
    public Integer score(Hand hand) {
        if (hand.nonZeroDieGroups().stream().max(Comparator.comparingInt(Integer::intValue)).get() >= number) {
            return hand.sumOfDice();
        }
        return 0;
    }
}
