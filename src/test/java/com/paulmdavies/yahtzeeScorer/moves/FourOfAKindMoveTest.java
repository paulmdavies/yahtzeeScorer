package com.paulmdavies.yahtzeeScorer.moves;

import com.paulmdavies.yahtzeeScorer.Hand;
import com.paulmdavies.yahtzeeScorer.exceptions.HandMustContainFiveDiceException;
import com.paulmdavies.yahtzeeScorer.exceptions.HandMustNotContainsInvalidDieValuesException;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FourOfAKindMoveTest {
    @Test
    public void shouldScoreSumOfDiceForHandWithAQuadruple() throws HandMustContainFiveDiceException, HandMustNotContainsInvalidDieValuesException {
        FourOfAKindMove fourOfAKindMove = new FourOfAKindMove();

        Integer score = fourOfAKindMove.score(new Hand(Arrays.asList(1, 1, 1, 1, 2)));

        assertThat(score, is(equalTo(6)));
    }

    @Test
    public void shouldScoreSumOfDiceForHandWithAQuintiple() throws HandMustContainFiveDiceException, HandMustNotContainsInvalidDieValuesException {
        FourOfAKindMove fourOfAKindMove = new FourOfAKindMove();

        Integer score = fourOfAKindMove.score(new Hand(Arrays.asList(6, 6, 6, 6, 6)));

        assertThat(score, is(equalTo(30)));
    }

    @Test
    public void shouldScoreZeroForHandWithoutAQuadruple() throws HandMustContainFiveDiceException, HandMustNotContainsInvalidDieValuesException {
        FourOfAKindMove fourOfAKindMove = new FourOfAKindMove();

        Integer score = fourOfAKindMove.score(new Hand(Arrays.asList(1, 1, 2, 2, 2)));

        assertThat(score, is(equalTo(0)));
    }
}