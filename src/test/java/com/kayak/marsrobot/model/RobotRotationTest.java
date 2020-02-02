package com.kayak.marsrobot.model;

import com.kayak.marsrobot.enums.FacingDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotRotationTest {

    @Test
    public void shouldDoA360Turn() {
        Robot robot = new Robot(FacingDirection.NORTH);
        robot.move("RRRR");
        assertEquals(FacingDirection.NORTH, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.NORTH);
        robot.move("LLLL");
        assertEquals(FacingDirection.NORTH, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.EAST);
        robot.move("RRRR");
        assertEquals(FacingDirection.EAST, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.EAST);
        robot.move("LLLL");
        assertEquals(FacingDirection.EAST, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.SOUTH);
        robot.move("RRRR");
        assertEquals(FacingDirection.SOUTH, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.SOUTH);
        robot.move("LLLL");
        assertEquals(FacingDirection.SOUTH, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.WEST);
        robot.move("RRRR");
        assertEquals(FacingDirection.WEST, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.WEST);
        robot.move("LLLL");
        assertEquals(FacingDirection.WEST, robot.getCurrentFacingDirection());
    }

    @Test
    public void shouldDoA270Turn() {
        Robot robot = new Robot(FacingDirection.NORTH);
        robot.move("RRR");
        assertEquals(FacingDirection.WEST, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.NORTH);
        robot.move("LLL");
        assertEquals(FacingDirection.EAST, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.EAST);
        robot.move("RRR");
        assertEquals(FacingDirection.NORTH, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.EAST);
        robot.move("LLL");
        assertEquals(FacingDirection.SOUTH, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.SOUTH);
        robot.move("RRR");
        assertEquals(FacingDirection.EAST, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.SOUTH);
        robot.move("LLL");
        assertEquals(FacingDirection.WEST, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.WEST);
        robot.move("RRR");
        assertEquals(FacingDirection.SOUTH, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.WEST);
        robot.move("LLL");
        assertEquals(FacingDirection.NORTH, robot.getCurrentFacingDirection());
    }

    @Test
    public void shouldDoA180Turn() {
        Robot robot = new Robot(FacingDirection.NORTH);
        robot.move("RR");
        assertEquals(FacingDirection.SOUTH, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.NORTH);
        robot.move("LL");
        assertEquals(FacingDirection.SOUTH, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.EAST);
        robot.move("RR");
        assertEquals(FacingDirection.WEST, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.EAST);
        robot.move("LL");
        assertEquals(FacingDirection.WEST, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.SOUTH);
        robot.move("RR");
        assertEquals(FacingDirection.NORTH, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.SOUTH);
        robot.move("LL");
        assertEquals(FacingDirection.NORTH, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.WEST);
        robot.move("RR");
        assertEquals(FacingDirection.EAST, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.WEST);
        robot.move("LL");
        assertEquals(FacingDirection.EAST, robot.getCurrentFacingDirection());
    }

    @Test
    public void shouldDoA90Turn() {
        Robot robot = new Robot(FacingDirection.NORTH);
        robot.move("R");
        assertEquals(FacingDirection.EAST, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.NORTH);
        robot.move("L");
        assertEquals(FacingDirection.WEST, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.EAST);
        robot.move("R");
        assertEquals(FacingDirection.SOUTH, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.EAST);
        robot.move("L");
        assertEquals(FacingDirection.NORTH, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.SOUTH);
        robot.move("R");
        assertEquals(FacingDirection.WEST, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.SOUTH);
        robot.move("L");
        assertEquals(FacingDirection.EAST, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.WEST);
        robot.move("R");
        assertEquals(FacingDirection.NORTH, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.WEST);
        robot.move("L");
        assertEquals(FacingDirection.SOUTH, robot.getCurrentFacingDirection());
    }

}
