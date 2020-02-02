package com.kayak.marsrobot.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandValidationUtilTest {

    @Test
    public void shouldValidateCommand() {
        assertTrue(CommandValidationUtil.isValidCommand("F"));
        assertTrue(CommandValidationUtil.isValidCommand("R"));
        assertTrue(CommandValidationUtil.isValidCommand("F"));
        assertTrue(CommandValidationUtil.isValidCommand("FR"));
        assertTrue(CommandValidationUtil.isValidCommand("FL"));
        assertTrue(CommandValidationUtil.isValidCommand("FFRRLL"));
        assertTrue(CommandValidationUtil.isValidCommand("LFLRLFLFR"));
        assertFalse(CommandValidationUtil.isValidCommand("AF"));
        assertFalse(CommandValidationUtil.isValidCommand(" AF"));
        assertFalse(CommandValidationUtil.isValidCommand("AF "));
        assertFalse(CommandValidationUtil.isValidCommand("FALRLR"));
        assertFalse(CommandValidationUtil.isValidCommand("F LRLR"));
        assertFalse(CommandValidationUtil.isValidCommand(""));
        assertFalse(CommandValidationUtil.isValidCommand(" "));
        assertFalse(CommandValidationUtil.isValidCommand(null));
    }
}
