package com.paulmdavies.yahtzeeScorer.moves;

import com.paulmdavies.yahtzeeScorer.Hand;
import com.paulmdavies.yahtzeeScorer.exceptions.HandMustContainFiveDiceException;
import com.paulmdavies.yahtzeeScorer.exceptions.HandMustNotContainsInvalidDieValuesException;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HighStraightMoveTest {
    @Test
    public void shouldScoreFortyForHandContainingFiveContiguousDice() throws HandMustContainFiveDiceException, HandMustNotContainsInvalidDieValuesException {
        HighStraightMove highStraightMove = new HighStraightMove();

        Integer score = highStraightMove.score(new Hand(Arrays.asList(1, 2, 3, 4, 5)));

        assertThat(score, is(equalTo(40)));
    }


    @Test
    public void shouldScoreZeroForHandNotContainingFiveContiguousDice() throws HandMustContainFiveDiceException, HandMustNotContainsInvalidDieValuesException {
        HighStraightMove highStraightMove = new HighStraightMove();

        Integer score = highStraightMove.score(new Hand(Arrays.asList(1, 2, 4, 5, 6)));

        assertThat(score, is(equalTo(0)));
    }
}