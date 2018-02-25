package com.paulmdavies.yahtzeeScorer.moves;

import com.paulmdavies.yahtzeeScorer.Hand;
import com.paulmdavies.yahtzeeScorer.exceptions.HandMustContainFiveDiceException;
import com.paulmdavies.yahtzeeScorer.exceptions.HandMustNotContainsInvalidDieValuesException;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ChanceMoveTest {
    @Test
    public void shouldScoreSumOfAllDice() throws HandMustContainFiveDiceException, HandMustNotContainsInvalidDieValuesException {
        ChanceMove chanceMove = new ChanceMove();

        Integer score = chanceMove.score(new Hand(Arrays.asList(2, 4, 5, 5, 6)));

        assertThat(score, is(equalTo(22)));
    }
}