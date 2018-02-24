package com.paulmdavies.yahtzeeScorer;

import com.paulmdavies.yahtzeeScorer.exceptions.HandMustContainFiveDiceException;
import com.paulmdavies.yahtzeeScorer.exceptions.HandMustNotContainsInvalidDieValuesException;
import org.junit.Test;

import java.util.Arrays;

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
}