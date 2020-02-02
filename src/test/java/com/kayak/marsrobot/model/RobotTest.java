package com.kayak.marsrobot.model;

import com.kayak.marsrobot.enums.FacingDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RobotTest {

    @Test
    public void shouldThrowExceptionOnInvalidFacingDirection() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Robot(null);
        });
    }

    @Test
    public void shouldCreateRobotFacingSpecificOrientation() {
        assertEquals(FacingDirection.NORTH, new Robot(FacingDirection.NORTH).getCurrentFacingDirection());
        assertEquals(FacingDirection.EAST, new Robot(FacingDirection.EAST).getCurrentFacingDirection());
        assertEquals(FacingDirection.SOUTH, new Robot(FacingDirection.SOUTH).getCurrentFacingDirection());
        assertEquals(FacingDirection.WEST, new Robot(FacingDirection.WEST).getCurrentFacingDirection());
    }

    @Test
    public void shouldCreateARobotWithInitialCoordinates0_0() {
        Robot robot = new Robot(FacingDirection.NORTH);
        assertEquals(0, robot.getCoordinate().getX());
        assertEquals(0, robot.getCoordinate().getY());
    }

    @Test
    public void shouldThrowExceptionOnInvalidMovementCommands() {
        Robot robot = new Robot(FacingDirection.NORTH);
        assertThrows(IllegalArgumentException.class, () -> {
           robot.move(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            robot.move("");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            robot.move(" ");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            robot.move("   ");
        });
    }

}
