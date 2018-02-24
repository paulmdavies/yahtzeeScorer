package com.paulmdavies.yahtzeeScorer;

import com.paulmdavies.yahtzeeScorer.exceptions.HandMustContainFiveDiceException;
import com.paulmdavies.yahtzeeScorer.exceptions.HandMustNotContainsInvalidDieValuesException;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Hand {
    private List<Integer> dice;

    public Hand(List<Integer> dice) throws HandMustContainFiveDiceException, HandMustNotContainsInvalidDieValuesException {
        this.dice = dice;
        checkDieCount();
        checkDieValues();
    }

    public List<Integer> dieGroups() {
        Map<Integer, Integer> dieCounts = dice
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.reducing(0, die -> 1, Integer::sum)));
        return dieCounts
                .values()
                .stream()
                .filter(aLong -> aLong != 0)
                .sorted()
                .collect(Collectors.toList());
    }

    private void checkDieValues() throws HandMustNotContainsInvalidDieValuesException {
        List<Integer> validDieValues = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> invalidValues = dice.stream().filter(die -> !validDieValues.contains(die)).collect(Collectors.toList());
        if (invalidValues.size() > 0) {
            throw new HandMustNotContainsInvalidDieValuesException("Hand must only contain values 1-6; found invalid values");
        }
    }

    private void checkDieCount() throws HandMustContainFiveDiceException {
        if (dice.size() != 5) {
            throw new HandMustContainFiveDiceException(String.format("Hand must contain 5 dice; got %d", dice.size()));
        }
    }
}
