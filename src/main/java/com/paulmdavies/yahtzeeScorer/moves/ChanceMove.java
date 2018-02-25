package com.paulmdavies.yahtzeeScorer.moves;

import com.paulmdavies.yahtzeeScorer.Hand;

public class ChanceMove implements Move {
    @Override
    public Integer score(Hand hand) {
        return hand.sumOfDice();
    }
}
