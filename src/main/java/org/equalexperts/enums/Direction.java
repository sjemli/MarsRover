package org.equalexperts.enums;

import java.util.Arrays;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Direction rotateRight() {
        Direction[] values = Direction.values();
        return values[(this.ordinal() + 1) % values.length];
    }

    public Direction rotateLeft() {
        Direction[] values = Direction.values();
        return values[(this.ordinal() - 1 + values.length) % values.length];
    }

    public static boolean isValidDirection(String input){
        return Arrays.stream(values())
                .map(Direction::name)
                .anyMatch(direction -> direction.equals(input));
    }
}
