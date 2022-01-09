package org.equalexperts.rover;


import org.equalexperts.enums.Command;
import org.equalexperts.enums.Direction;
import org.equalexperts.localization.Coordinate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.equalexperts.enums.Command.*;
import static org.equalexperts.enums.Direction.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RoverTest {

    @Test
    void should_create_rover_with_direction_EAST_and_coordinates_4_2() {
        Rover rover = new Rover(4, 2, EAST);
        assertThat(rover.getCoordinate(), equalTo(new Coordinate(4, 2)));
        assertThat(rover.getDirection(), equalTo(EAST));
    }


    @ParameterizedTest(name = "{index} should next Position should be ({4}, {5}) {6} when Direction is {3} and currentPosition is ({0}, {1}) {2}")
    @MethodSource("provideArgumentsForApplyCommandTest")
    void testApplyCommand(int currentX,
                          int currentY,
                          Direction currentDirection,
                          Command command,
                          int expectedX,
                          int expectedY,
                          Direction expectedDirection) {
        //Given
        Rover rover = new Rover(currentX, currentY, currentDirection);
        //When
        rover.applyCommand(command);
        //Then
        assertThat(rover.getCoordinate(), equalTo(new Coordinate(expectedX, expectedY)));
        assertThat(rover.getDirection(), equalTo(expectedDirection));
    }


    private static Stream<Arguments> provideArgumentsForApplyCommandTest() {
        return Stream.of(
                Arguments.of(0, 0, EAST, F, 1, 0, EAST),
                Arguments.of(0, 0, EAST, R, 0, 0, SOUTH),
                Arguments.of(0, 0, EAST, B, -1, 0, EAST),
                Arguments.of(0, 0, EAST, L, 0, 0, NORTH),

                Arguments.of(0, 0, WEST, F, -1, 0, WEST),
                Arguments.of(0, 0, WEST, R, 0, 0, NORTH),
                Arguments.of(0, 0, WEST, B, 1, 0, WEST),
                Arguments.of(0, 0, WEST, L, 0, 0, SOUTH),

                Arguments.of(0, 0, NORTH, F, 0, 1, NORTH),
                Arguments.of(0, 0, NORTH, R, 0, 0, EAST),
                Arguments.of(0, 0, NORTH, B, 0, -1, NORTH),
                Arguments.of(0, 0, NORTH, L, 0, 0, WEST),

                Arguments.of(0, 0, SOUTH, F, 0, -1, SOUTH),
                Arguments.of(0, 0, SOUTH, R, 0, 0, WEST),
                Arguments.of(0, 0, SOUTH, B, 0, 1, SOUTH),
                Arguments.of(0, 0, SOUTH, L, 0, 0, EAST)
        );
    }

    @ParameterizedTest(name = "{index} should next coordinate be ({4}, {5}) when direction is {2}, command is {3}" +
            "and coordinate is ({0}, {1})")
    @MethodSource("provideArgumentsForNextCoordinateTest")
    void testNextCoordinate(int x, int y, Direction direction, Command command, int expectedX, int expectedY) {
        Rover rover = new Rover(x, y, direction);
        assertThat(rover.moveToNextCoordinate(command),
                equalTo(new Coordinate(expectedX, expectedY)));
    }


    private static Stream<Arguments> provideArgumentsForNextCoordinateTest() {
        return Stream.of(
                Arguments.of(0, 0, EAST, F, 1, 0),
                Arguments.of(0, 0, EAST, B, -1, 0),

                Arguments.of(0, 0, WEST, B, 1, 0),
                Arguments.of(0, 0, WEST, F, -1, 0),

                Arguments.of(0, 0, NORTH, F, 0, 1),
                Arguments.of(0, 0, NORTH, B, 0, -1),

                Arguments.of(0, 0, SOUTH, F, 0, -1),
                Arguments.of(0, 0, SOUTH, B, 0, 1)
        );
    }

    @Test
    void should_throw_exception_when_direction_unknown() {
        Direction direction = null;
        Rover rover = new Rover(0, 0, direction);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> rover.moveToNextCoordinate(F));

        assertThat(exception.getMessage(), equalTo("Unknown Direction!"));
    }

    @ParameterizedTest(name = "{index} should Rover Position be ({4}, {5}) {6} when commands are {3}" +
            " and currentPosition is ({0}, {1}) {2}")
    @MethodSource("provideArgumentsForApplyCommandsTest")
    void testApplyCommands(int currentX,
                           int currentY,
                           Direction currentDirection,
                           String commands,
                           int expectedX,
                           int expectedY,
                           Direction expectedDirection) {
        //Given
        Rover rover = new Rover(currentX, currentY, currentDirection);
        //When
        rover.applyCommands(commands);
        //Then
        assertThat(rover.getCoordinate(), equalTo(new Coordinate(expectedX, expectedY)));
        assertThat(rover.getDirection(), equalTo(expectedDirection));
    }


    private static Stream<Arguments> provideArgumentsForApplyCommandsTest() {
        return Stream.of(
                Arguments.of(4, 2, EAST, "FLFFFRFLB", 6, 4, NORTH)
        );
    }


    @Test
    void testToString() {
        //Given
        Rover rover = new Rover(1, 5, EAST);
        //When
        String roverString = rover.toString();
        //Then
        assertThat(roverString, equalTo("(1, 5) EAST"));
    }
}