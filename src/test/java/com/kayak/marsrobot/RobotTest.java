package com.kayak.marsrobot;

import com.kayak.marsrobot.enums.FacingDirection;
import com.kayak.marsrobot.exception.IllegalCommandException;
import com.kayak.marsrobot.model.Robot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RobotTest {

    private Robot robot = new Robot(FacingDirection.EAST);

    @Test
    public void shouldThrowExceptionOnNullInputCommand() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            robot.move(null);
        });
    }

    @Test
    public void shouldThrowExceptionOnEmptyStringInputCommand() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            robot.move("");
        });
    }

    @Test
    public void shouldThrowExceptionOnStringWithSpacesOnlyForInputCommand() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            robot.move("  ");
        });
    }

    @Test
    public void shouldReturnTrueForValidInputCommand() {
        assertTrue(robot.isValidCommand("F"));
        assertTrue(robot.isValidCommand("L"));
        assertTrue(robot.isValidCommand("R"));
        assertTrue(robot.isValidCommand("FLR"));
        assertTrue(robot.isValidCommand("FFLRR"));
        assertTrue(robot.isValidCommand("FFLLRR"));
        assertTrue(robot.isValidCommand("FLRLFLRLFRFLRFLRFLRFRLFRFLRFLRLFLFRRRLFLFLFLFLLRRFFF"));
        assertFalse(robot.isValidCommand("A"));
        assertFalse(robot.isValidCommand("FALR"));
        assertFalse(robot.isValidCommand("RAFL"));
        assertFalse(robot.isValidCommand("LLFFRRFASLKKS"));
        assertFalse(robot.isValidCommand(" FF L RR"));
        assertFalse(robot.isValidCommand(" FLR"));
        assertFalse(robot.isValidCommand("FLR "));
    }

    @Test
    public void shouldThrowIllegalCommandException() {
        Throwable throwable = assertThrows(IllegalCommandException.class, () -> {
            robot.move("AFLR");
        });
        assertEquals("Command AFLR contains invalid instruction!", throwable.getMessage());
        throwable = assertThrows(IllegalCommandException.class, () -> {
            robot.move(" FLR");
        });
        assertEquals("Command  FLR contains invalid instruction!", throwable.getMessage());
        throwable = assertThrows(IllegalCommandException.class, () -> {
            robot.move("FLR ");
        });
        assertEquals("Command FLR  contains invalid instruction!", throwable.getMessage());
    }

    @Test
    public void shouldThrowExceptionOnSettingNullAsInitialFacingDirection() {
        assertThrows(IllegalArgumentException.class, () -> {
            Robot r = new Robot(null);
        });
    }

}
