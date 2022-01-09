package org.equalexperts.enums;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class CommandTest {


    @ParameterizedTest(name = "{index} should sens be {1} when Command is {0}")
    @CsvSource({
            "F, 1",
            "B, -1",
            "R, 0",
            "L, 0"
    })
    void testGetSens(Command command, int sens){
        assertThat(command.getSens(), equalTo(sens));
    }

    @ParameterizedTest(name = "{index} should isValidCommand be {1} when input is {0}")
    @CsvSource({
            "F, true",
            "B,  true",
            "R, true",
            "L,  true",
            "xy , false"
    })
    void testIsValidCommand(String input, boolean isValid){
        assertThat(Command.isValidCommand(input), is(isValid));
    }
}