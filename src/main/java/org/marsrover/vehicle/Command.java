package org.marsrover.vehicle;

import java.util.HashMap;
import java.util.Map;

public enum Command {
    LEFT('L'),
    RIGHT('R'),
    MOVE('M');

    private static final Map<Character, Command> BY_COMMAND = new HashMap<>();

    static {
        for (Command c : values()) {
            BY_COMMAND.put(c.value, c);
        }
    }

    final char value;

    Command(char value) {
        this.value = value;
    }

    public static Command valueOfCommand(char command) {
        return BY_COMMAND.get(command);
    }
}
