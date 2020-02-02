package com.kayak.marsrobot.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IllegalFacingDirectionExceptionTest {

    @Test
    public void shouldValidateExceptionTest() {
        assertEquals("null is not a valid facing direction", new IllegalFacingDirectionException(null).getMessage());
    }
}
