package org.equalexperts.main;

import org.equalexperts.enums.Direction;
import org.equalexperts.input.InputReader;
import org.equalexperts.rover.Rover;

public class MarsRoverApp {

    public static void main(String[] args) {

        InputReader inputReader = new InputReader();

        System.out.println("Enter Rover initial Position : X, Y, Direction");

        Integer x = inputReader.readCoordinate("X");
        Integer y = inputReader.readCoordinate("Y");
        Direction direction = inputReader.readDirection();

        Rover rover = new Rover(x, y, direction);

        String commands = inputReader.readCommands();

        rover.applyCommands(commands);
        System.out.println("Rover final position is " + rover);
    }
}
