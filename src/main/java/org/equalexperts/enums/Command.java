package org.equalexperts.enums;

import java.util.Arrays;

public enum Command {
    F(1),
    B(-1),
    L(0),
    R(0);

    private final int sens;

    Command(int sens) {
       this.sens = sens;
    }

    public int getSens() {
        return sens;
    }

    public static boolean isValidCommand(String input){
        return Arrays.stream(values())
                .map(Command::name)
                .anyMatch(cmd -> cmd.equals(input));
    }
}
