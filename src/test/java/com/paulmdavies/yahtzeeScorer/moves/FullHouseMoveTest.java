package com.paulmdavies.yahtzeeScorer.moves;

import com.paulmdavies.yahtzeeScorer.Hand;
import com.paulmdavies.yahtzeeScorer.exceptions.HandMustContainFiveDiceException;
import com.paulmdavies.yahtzeeScorer.exceptions.HandMustNotContainsInvalidDieValuesException;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FullHouseMoveTest {
    @Test
    public void shouldScoreTwentyFiveForAHandOfAPairAndATriple() throws HandMustContainFiveDiceException, HandMustNotContainsInvalidDieValuesException {
        FullHouseMove fullHouseMove = new FullHouseMove();

        Integer score = fullHouseMove.score(new Hand(Arrays.asList(1, 1, 2, 2, 2)));

        assertThat(score, is(equalTo(25)));
    }

    @Test
    public void shouldScoreTwentyFiveForAHandOfAQuintiple() throws HandMustContainFiveDiceException, HandMustNotContainsInvalidDieValuesException {
        FullHouseMove fullHouseMove = new FullHouseMove();

        Integer score = fullHouseMove.score(new Hand(Arrays.asList(1, 1, 1, 1, 1)));

        assertThat(score, is(equalTo(25)));
    }

    @Test
    public void shouldScoreZeroForANonFullHouseHand() throws HandMustContainFiveDiceException, HandMustNotContainsInvalidDieValuesException {
        FullHouseMove fullHouseMove = new FullHouseMove();

        Integer score = fullHouseMove.score(new Hand(Arrays.asList(1, 1, 2, 2, 3)));

        assertThat(score, is(equalTo(0)));
    }
}