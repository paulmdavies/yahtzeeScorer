package com.paulmdavies.yahtzeeScorer.moves;

import com.paulmdavies.yahtzeeScorer.Hand;
import com.paulmdavies.yahtzeeScorer.exceptions.HandMustContainFiveDiceException;
import com.paulmdavies.yahtzeeScorer.exceptions.HandMustNotContainsInvalidDieValuesException;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class YahtzeeMoveTest {
    @Test
    public void shouldScoreFiftyIfAllDiceTheSame() throws HandMustContainFiveDiceException, HandMustNotContainsInvalidDieValuesException {
        YahtzeeMove yahtzeeMove = new YahtzeeMove();

        Integer score = yahtzeeMove.score(new Hand(Arrays.asList(1, 1, 1, 1, 1)));

        assertThat(score, is(equalTo(50)));
    }

    @Test
    public void shouldScoreZeroIfNotAllDiceTheSame() throws HandMustContainFiveDiceException, HandMustNotContainsInvalidDieValuesException {
        YahtzeeMove yahtzeeMove = new YahtzeeMove();

        Integer score = yahtzeeMove.score(new Hand(Arrays.asList(1, 1, 1, 1, 2)));

        assertThat(score, is(equalTo(0)));
    }
}