package org.equalexperts.input;

import org.equalexperts.enums.Direction;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class InputReaderTest {

    private static final String LINE_SEPARATOR = "\n";

    @Test
    void testReadCoordinate() {
        //Given
        String testInput = String.join(LINE_SEPARATOR, "random", "23");
        InputReader inputReader = getInputReader(testInput);
        //When
        int x = inputReader.readCoordinate("X");
        //Then
        assertThat(x, equalTo(23));
    }


    @Test
    void testReadDirection() {
        //Given
        String testInput = String.join(LINE_SEPARATOR, "random", "23", "EAST");
        InputReader inputReader = getInputReader(testInput);
        //When
        Direction direction = inputReader.readDirection();
        //Then
        assertThat(direction, equalTo(Direction.EAST));
    }

    @Test
    void testReadCommands() {
        //Given
        String testInput = String.join(LINE_SEPARATOR, "random", "23", "EAST", "FFLLRBR");
        InputReader inputReader = getInputReader(testInput);
        //When
        String commands = inputReader.readCommands();
        //Then
        assertThat(commands, equalTo("FFLLRBR"));
    }

    private InputReader getInputReader(String testInput) {
        Scanner testScanner = new Scanner(testInput);
        return new InputReader(testScanner);
    }
}