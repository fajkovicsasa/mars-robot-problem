package com.kayak.marsrobot.enums;

public enum MovementCommands {

    FORWARD("F"),
    TURN_RIGHT("R"),
    TURN_LEFT("L");

    private final String value;

    private MovementCommands(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
