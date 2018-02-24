package com.paulmdavies.yahtzeeScorer.moves;

import com.paulmdavies.yahtzeeScorer.Hand;

public interface Move {
    Integer score(Hand hand);
}
