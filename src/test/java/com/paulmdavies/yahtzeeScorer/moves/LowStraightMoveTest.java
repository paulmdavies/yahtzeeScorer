package com.paulmdavies.yahtzeeScorer.moves;

import com.paulmdavies.yahtzeeScorer.Hand;
import com.paulmdavies.yahtzeeScorer.exceptions.HandMustContainFiveDiceException;
import com.paulmdavies.yahtzeeScorer.exceptions.HandMustNotContainsInvalidDieValuesException;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LowStraightMoveTest {
    @Test
    public void shouldScoreThirtyForHandContainingFourContiguousDice() throws HandMustContainFiveDiceException, HandMustNotContainsInvalidDieValuesException {
        LowStraightMove lowStraightMove = new LowStraightMove();

        Integer score = lowStraightMove.score(new Hand(Arrays.asList(1, 2, 3, 4, 6)));

        assertThat(score, is(equalTo(30)));
    }

    @Test
    public void shouldScoreThirtyForHandContainingFourContiguousDiceWithDuplicates() throws HandMustContainFiveDiceException, HandMustNotContainsInvalidDieValuesException {
        LowStraightMove lowStraightMove = new LowStraightMove();

        Integer score = lowStraightMove.score(new Hand(Arrays.asList(1, 2, 3, 4, 3)));

        assertThat(score, is(equalTo(30)));
    }

    @Test
    public void shouldScoreZeroForHandNotContainingFourContiguousDice() throws HandMustContainFiveDiceException, HandMustNotContainsInvalidDieValuesException {
        LowStraightMove lowStraightMove = new LowStraightMove();

        Integer score = lowStraightMove.score(new Hand(Arrays.asList(1, 2, 4, 5, 6)));

        assertThat(score, is(equalTo(0)));
    }
}