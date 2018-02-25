package com.paulmdavies.yahtzeeScorer.moves;

import com.paulmdavies.yahtzeeScorer.Hand;

public class NumberMove implements Move {
    private final Integer number;

    public NumberMove(Integer number) {
        this.number = number;
    }

    @Override
    public Integer score(Hand hand) {
        return hand.dieGroups().get(number) * number;
    }
}
