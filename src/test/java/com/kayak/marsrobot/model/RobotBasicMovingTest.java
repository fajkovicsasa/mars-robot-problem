package com.kayak.marsrobot.model;

import com.kayak.marsrobot.enums.FacingDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotBasicMovingTest {

    @Test
    public void shouldMoveRobotFor1Step() {
        Robot robot = new Robot(FacingDirection.NORTH);
        robot.move("F");
        assertEquals(FacingDirection.NORTH, robot.getCurrentFacingDirection());
        assertEquals("[0,1]", robot.getCoordinate().toString());

        robot = new Robot(FacingDirection.EAST);
        robot.move("F");
        assertEquals(FacingDirection.EAST, robot.getCurrentFacingDirection());
        assertEquals("[1,0]", robot.getCoordinate().toString());

        robot = new Robot(FacingDirection.SOUTH);
        robot.move("F");
        assertEquals(FacingDirection.SOUTH, robot.getCurrentFacingDirection());
        assertEquals("[0,-1]", robot.getCoordinate().toString());

        robot = new Robot(FacingDirection.WEST);
        robot.move("F");
        assertEquals(FacingDirection.WEST, robot.getCurrentFacingDirection());
        assertEquals("[-1,0]", robot.getCoordinate().toString());
    }

    @Test
    public void shouldMoveInACubeFormat() {
        Robot robot = new Robot(FacingDirection.EAST);
        assertEquals("[0,0]", robot.getCoordinate().toString());

        robot.move("F");
        assertEquals(FacingDirection.EAST, robot.getCurrentFacingDirection());
        assertEquals("[1,0]", robot.getCoordinate().toString());

        robot.move("R");
        assertEquals(FacingDirection.SOUTH, robot.getCurrentFacingDirection());
        assertEquals("[1,0]", robot.getCoordinate().toString());

        robot.move("F");
        assertEquals(FacingDirection.SOUTH, robot.getCurrentFacingDirection());
        assertEquals("[1,-1]", robot.getCoordinate().toString());

        robot.move("R");
        assertEquals(FacingDirection.WEST, robot.getCurrentFacingDirection());
        assertEquals("[1,-1]", robot.getCoordinate().toString());

        robot.move("F");
        assertEquals(FacingDirection.WEST, robot.getCurrentFacingDirection());
        assertEquals("[0,-1]", robot.getCoordinate().toString());

        robot.move("R");
        assertEquals(FacingDirection.NORTH, robot.getCurrentFacingDirection());
        assertEquals("[0,-1]", robot.getCoordinate().toString());

        robot.move("F");
        assertEquals(FacingDirection.NORTH, robot.getCurrentFacingDirection());
        assertEquals("[0,0]", robot.getCoordinate().toString());
    }
}
