package com.paulmdavies.yahtzeeScorer.moves;

import com.paulmdavies.yahtzeeScorer.Hand;

import java.util.Arrays;
import java.util.Collections;

public class LowStraightMove implements Move {
    @Override
    public Integer score(Hand hand) {
        if (Collections.indexOfSubList(hand.diePresences(), Arrays.asList(1,1,1,1)) != -1) {
            return 30;
        }
        return 0;
    }
}
