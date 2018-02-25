package com.paulmdavies.yahtzeeScorer.moves;

import com.paulmdavies.yahtzeeScorer.Hand;
import com.paulmdavies.yahtzeeScorer.exceptions.HandMustContainFiveDiceException;
import com.paulmdavies.yahtzeeScorer.exceptions.HandMustNotContainsInvalidDieValuesException;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NumberMoveTest {
    @Test
    public void shouldScoreTheSumOfTheSpecifiedNumber() throws HandMustContainFiveDiceException, HandMustNotContainsInvalidDieValuesException {
        NumberMove numberMove = new NumberMove(6);

        Integer score = numberMove.score(new Hand(Arrays.asList(3, 4, 6, 6, 6)));

        assertThat(score, is(equalTo(18)));
    }

    @Test
    public void shouldScoreZeroIfTheSpecifiedNumberIsNotPresent() throws HandMustContainFiveDiceException, HandMustNotContainsInvalidDieValuesException {
        NumberMove numberMove = new NumberMove(5);

        Integer score = numberMove.score(new Hand(Arrays.asList(3, 4, 6, 6, 6)));

        assertThat(score, is(equalTo(0)));
    }
}