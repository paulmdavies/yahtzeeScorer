package com.paulmdavies.yahtzeeScorer;

import com.paulmdavies.yahtzeeScorer.exceptions.HandMustContainFiveDiceException;
import com.paulmdavies.yahtzeeScorer.exceptions.HandMustNotContainsInvalidDieValuesException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HandTest {
    @Test
    public void shouldAllowConstructionOfHandWithFiveDice() throws HandMustContainFiveDiceException, HandMustNotContainsInvalidDieValuesException {
        new Hand(Arrays.asList(1, 1, 1, 1, 1));
    }

    @Test(expected = HandMustContainFiveDiceException.class)
    public void shouldThrowErrorIfHandConstructedWithOtherThanFiveDice() throws HandMustContainFiveDiceException, HandMustNotContainsInvalidDieValuesException {
        new Hand(Arrays.asList(1));
    }

    @Test(expected = HandMustNotContainsInvalidDieValuesException.class)
    public void shouldThrowErrorIfHandConstructedWithInvalidDiceValues() throws HandMustContainFiveDiceException, HandMustNotContainsInvalidDieValuesException {
        new Hand(Arrays.asList(1, 2, 3, 4, 7));
    }

    @Test
    public void shouldReturnNonZeroDieGroupsInIncreasingOrder() throws HandMustContainFiveDiceException, HandMustNotContainsInvalidDieValuesException {
        Hand hand = new Hand(Arrays.asList(1, 1, 2, 2, 3));

        List<Integer> groups = hand.nonZeroDieGroups();

        assertThat(groups, is(equalTo(Arrays.asList(1, 2, 2))));
    }

    @Test
    public void shouldReturnDiePresences() throws HandMustContainFiveDiceException, HandMustNotContainsInvalidDieValuesException {
        Hand hand = new Hand(Arrays.asList(2, 2, 4, 4, 5));

        List<Integer> groups = hand.diePresences();

        assertThat(groups, is(equalTo(Arrays.asList(0, 1, 0, 1, 1, 0))));
    }
}