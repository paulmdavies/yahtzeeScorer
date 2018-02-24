package com.paulmdavies.yahtzeeScorer.moves;

import com.paulmdavies.yahtzeeScorer.Hand;

import java.util.Arrays;
import java.util.Collections;

public abstract class StraightMove implements Move {
    private final Integer length;
    private final Integer score;

    public StraightMove(Integer length, Integer score) {
        this.length = length;
        this.score = score;
    }

    @Override
    public Integer score(Hand hand) {
        if (Collections.indexOfSubList(hand.diePresences(), Collections.nCopies(length, 1)) != -1) {
            return score;
        }
        return 0;
    }
}
