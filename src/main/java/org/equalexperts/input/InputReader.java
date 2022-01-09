package org.equalexperts.input;

import org.equalexperts.enums.Command;
import org.equalexperts.enums.Direction;

import java.util.Scanner;

import static org.equalexperts.enums.Direction.isValidDirection;

public class InputReader {

    private final Scanner scanner;

    public InputReader() {
        scanner = new Scanner(System.in);
    }

    public InputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Integer readCoordinate(String coordinateName) {
        Integer x = null;
        while (x == null) {
            System.out.println("Enter an integer for coordinate " + coordinateName + ":");
            if (scanner.hasNextInt()) x = scanner.nextInt();
            else scanner.next();
        }
        return x;
    }

    public Direction readDirection() {
        Direction direction = null;
        while (direction == null) {
            System.out.println("Enter the Rover initial Direction (NORTH, SOUTH, EAST, WEST) :");
            String input = scanner.next();
            if (isValidDirection(input)) direction = Direction.valueOf(input);
        }
        return direction;
    }

    public String readCommands() {
        String commands = null;
        while (commands == null) {
            System.out.println("Enter List of commands (F, B, L, R) :");
            String input = scanner.next();
            if (isValidCommandsInput(input)) commands = input;
        }
        return commands;
    }

    private boolean isValidCommandsInput(String input) {
        return input.chars()
                .mapToObj(c -> Character.toString((char) c))
                .allMatch(Command::isValidCommand);
    }
}
