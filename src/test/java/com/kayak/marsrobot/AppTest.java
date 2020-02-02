package com.kayak.marsrobot;

import com.kayak.marsrobot.enums.FacingDirection;
import com.kayak.marsrobot.model.Robot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    public void shouldMoveRobotToASpecificLocation() {
        Robot robot = new Robot(FacingDirection.NORTH);
        robot.move("FFR");
        assertEquals("[0,2]", robot.getCoordinate().toString());
        assertEquals(FacingDirection.EAST, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.NORTH);
        robot.move("FFRRFF");
        assertEquals("[0,0]", robot.getCoordinate().toString());
        assertEquals(FacingDirection.SOUTH, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.SOUTH);
        robot.move("FFFLLRFFF");
        assertEquals("[3,-3]", robot.getCoordinate().toString());
        assertEquals(FacingDirection.EAST, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.EAST);
        robot.move("FFFFLLLLRRR");
        assertEquals("[4,0]", robot.getCoordinate().toString());
        assertEquals(FacingDirection.NORTH, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.WEST);
        robot.move("FFFFLFFLFFLFFFL");
        assertEquals("[-2,1]", robot.getCoordinate().toString());
        assertEquals(FacingDirection.WEST, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.EAST);
        robot.move("LFFFRFFFRRFFF");
        assertEquals("[0,3]", robot.getCoordinate().toString());
        assertEquals(FacingDirection.WEST, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.EAST);
        robot.move("FLLRRFLRFFLLLRRFRL");
        assertEquals("[4,1]", robot.getCoordinate().toString());
        assertEquals(FacingDirection.NORTH, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.EAST);
        robot.move("FFFLFFRRFFFLFRFRFLLF");
        assertEquals("[4,-2]", robot.getCoordinate().toString());
        assertEquals(FacingDirection.EAST, robot.getCurrentFacingDirection());

        robot = new Robot(FacingDirection.EAST);
        robot.move("LFRFLRFLRL");
        assertEquals("[2,1]", robot.getCoordinate().toString());
        assertEquals(FacingDirection.NORTH, robot.getCurrentFacingDirection());
    }

}
