package org.equalexperts.enums;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class DirectionTest {

    @ParameterizedTest(name = "{index} should right rotation give Direction {1} when Direction is {0}")
    @CsvSource({
            "NORTH, EAST",
            "EAST, SOUTH",
            "SOUTH, WEST",
            "WEST, NORTH",
    })
    void testRotateRight(Direction direction, Direction rightDirection) {
        assertThat(direction.rotateRight(), is(rightDirection));
    }

    @ParameterizedTest(name = "{index} should left rotation give Direction {1} when Direction is {0}")
    @CsvSource({
            "NORTH, WEST",
            "EAST, NORTH",
            "SOUTH, EAST",
            "WEST, SOUTH",
    })
    void testRotateLeft(Direction direction, Direction leftDirection) {
        assertThat(direction.rotateLeft(), is(leftDirection));
    }

    @ParameterizedTest(name = "{index} should isValidDirection be {1} when input is {0}")
    @CsvSource({
            "NORTH, true",
            "EAST,  true",
            "SOUTH, true",
            "WEST,  true",
            "xy  ,  false"
    })
    void testIsValidDirection(String input, boolean isValid) {
        assertThat(Direction.isValidDirection(input), is(isValid));
    }
}