package org.equalexperts.rover;

import org.equalexperts.enums.Command;
import org.equalexperts.enums.Direction;
import org.equalexperts.localization.Coordinate;

import static org.equalexperts.enums.Direction.*;

public class Rover {

    private Coordinate coordinate;
    private Direction direction;

    public Rover(int x, int y, Direction direction) {
        this.coordinate = new Coordinate(x, y);
        this.direction = direction;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Direction getDirection() {
        return direction;
    }

    public void applyCommands(String commands) {
        commands.chars()
                .mapToObj(c -> Character.toString((char) c))
                .map(Command::valueOf)
                .forEach(this::applyCommand);
    }

    void applyCommand(Command command) {
        switch (command) {
            case F:
            case B:
                coordinate = moveToNextCoordinate(command);
                break;
            case R:
                direction = direction.rotateRight();
                break;
            case L:
                direction = direction.rotateLeft();
                break;
        }
    }

    Coordinate moveToNextCoordinate(Command command) {
        int x = coordinate.getX();
        int y = coordinate.getY();

        if (direction == EAST) {
            return new Coordinate(x + command.getSens(), y);
        } else if (direction == WEST) {
            return new Coordinate(x - command.getSens(), y);
        } else if (direction == NORTH) {
            return new Coordinate(x, y + command.getSens());
        } else if (direction == SOUTH) {
            return new Coordinate(x, y - command.getSens());
        } else {
            throw new IllegalArgumentException("Unknown Direction!");
        }
    }


    @Override
    public String toString() {
        return String.format("(%s, %s) %s", coordinate.getX(), coordinate.getY(), direction);
    }
}
