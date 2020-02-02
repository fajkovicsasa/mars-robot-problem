package com.kayak.marsrobot.enums;

public enum MovementInstruction {

    FORWARD("F"),
    TURN_RIGHT("R"),
    TURN_LEFT("L");

    private final String value;

    private MovementInstruction(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
