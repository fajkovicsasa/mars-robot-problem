package com.kayak.marsrobot.model;

import com.kayak.marsrobot.enums.FacingDirection;
import com.kayak.marsrobot.enums.MovementInstruction;
import com.kayak.marsrobot.exception.IllegalCommandException;
import com.kayak.marsrobot.resolver.FacingDirectionResolver;
import com.kayak.marsrobot.util.CommandValidationUtil;

public class Robot {
    private FacingDirection currentFacingDirection;
    private Coordinate coordinate;

    public Robot(FacingDirection initialFacingDirection) {
        if (initialFacingDirection == null) {
            throw new IllegalArgumentException("Invalid facing direction");
        }
        this.currentFacingDirection = initialFacingDirection;
        this.coordinate = new Coordinate(0, 0);
    }

    public void move(String commands) {
        if (commands == null || commands.isBlank()) {
            throw new IllegalArgumentException("Input command can't empty.");
        }

        if (!CommandValidationUtil.isValidCommand(commands)) {
            throw new IllegalCommandException(commands);
        }

        String[] commandCharacters = commands.split("");
        for (int i = 0; i < commandCharacters.length; i++) {
            if (commandCharacters[i].equals(MovementInstruction.FORWARD.getValue())) {
                moveForward();
            } else if (commandCharacters[i].equals(MovementInstruction.TURN_LEFT.getValue())) {
                turnLeft();
            } else if (commandCharacters[i].equals(MovementInstruction.TURN_RIGHT.getValue())) {
                turnRight();
            }
        }
    }

    protected void moveForward() {
        if (currentFacingDirection == FacingDirection.NORTH) {
            coordinate.setY(coordinate.getY() + 1);
        }

        if (currentFacingDirection == FacingDirection.EAST) {
            coordinate.setX(coordinate.getX() + 1);
        }

        if (currentFacingDirection == FacingDirection.SOUTH) {
            coordinate.setY(coordinate.getY() - 1);
        }

        if (currentFacingDirection == FacingDirection.WEST) {
            coordinate.setX(coordinate.getX() - 1);
        }
    }

    protected void turnLeft() {
        currentFacingDirection = FacingDirectionResolver.changeFacingDirection(currentFacingDirection, MovementInstruction.TURN_LEFT);
    }

    protected void turnRight() {
        currentFacingDirection = FacingDirectionResolver.changeFacingDirection(currentFacingDirection, MovementInstruction.TURN_RIGHT);
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public FacingDirection getCurrentFacingDirection() {
        return currentFacingDirection;
    }
}
