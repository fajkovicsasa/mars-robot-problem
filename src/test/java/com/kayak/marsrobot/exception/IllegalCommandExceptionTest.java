package com.kayak.marsrobot.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IllegalCommandExceptionTest {

    @Test
    public void shouldValidateExceptionMessage() {
        assertEquals("Command ABC contains invalid instruction!", new IllegalCommandException("ABC").getMessage());
        assertEquals("Command null contains invalid instruction!", new IllegalCommandException(null).getMessage());
        assertEquals("Command  contains invalid instruction!", new IllegalCommandException("").getMessage());
    }
}
