package com.kayak.marsrobot.model;

import com.kayak.marsrobot.enums.FacingDirection;

public interface RobotInterface {
    void move(String commands);

    Coordinate getCoordinate();

    FacingDirection getCurrentFacingDirection();
}
