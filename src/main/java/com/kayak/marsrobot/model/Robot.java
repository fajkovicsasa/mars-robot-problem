package com.kayak.marsrobot.model;

import com.kayak.marsrobot.enums.FacingDirection;
import com.kayak.marsrobot.enums.MovementCommands;
import com.kayak.marsrobot.exception.IllegalCommandException;
import com.kayak.marsrobot.model.Coordinate;
import com.kayak.marsrobot.resolver.FacingDirectionResolver;

public class Robot {
    private FacingDirection facingDirection;
    private Coordinate coordinate;

    public Robot(FacingDirection initialFacingDirection) {
        if (initialFacingDirection == null) {
            throw new IllegalArgumentException("Invalid facing direction");
        }
        this.facingDirection = initialFacingDirection;
        this.coordinate = new Coordinate(0, 0);
    }

    public void move(String commandString) {
        if (commandString == null || commandString.isBlank()) {
            throw new IllegalArgumentException("Input command can't empty.");
        }

        if (!isValidCommand(commandString)) {
            throw new IllegalCommandException(commandString);
        }

        String[] commandCharacters = commandString.split("");
        for (int i = 0; i < commandCharacters.length; i++) {
            if (commandCharacters[i].equals(MovementCommands.FORWARD.getValue())) {
                moveForward();
            } else if (commandCharacters[i].equals(MovementCommands.TURN_LEFT.getValue())) {
                turnLeft();
            } else if (commandCharacters[i].equals(MovementCommands.TURN_RIGHT.getValue())) {
                turnRight();
            }
        }

    }

    protected void moveForward() {
        if (facingDirection == FacingDirection.NORTH) {
            coordinate.setY(coordinate.getY() + 1);
        }

        if (facingDirection == FacingDirection.EAST) {
            coordinate.setX(coordinate.getX() + 1);
        }

        if (facingDirection == FacingDirection.SOUTH) {
            coordinate.setY(coordinate.getY() - 1);
        }

        if (facingDirection == FacingDirection.WEST) {
            coordinate.setX(coordinate.getX() - 1);
        }
    }

    protected void turnLeft() {
        facingDirection = FacingDirectionResolver.getNewFacingDirection(facingDirection, MovementCommands.TURN_LEFT);
    }

    protected void turnRight() {
        facingDirection = FacingDirectionResolver.getNewFacingDirection(facingDirection, MovementCommands.TURN_RIGHT);
    }

    protected boolean isValidCommand(String commands) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (MovementCommands mc : MovementCommands.class.getEnumConstants()) {
            sb.append(mc.getValue());
        }
        sb.append("]+");

        return commands.matches(sb.toString());
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
