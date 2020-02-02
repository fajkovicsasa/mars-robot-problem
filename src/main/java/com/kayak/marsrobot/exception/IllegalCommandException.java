package com.kayak.marsrobot.exception;

public class IllegalCommandException extends RuntimeException {
    public IllegalCommandException(String command) {
        super("Command " + command + " contains invalid instruction!");
    }
}
