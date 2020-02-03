package com.kayak.marsrobot.model;

import com.kayak.marsrobot.enums.FacingDirection;
import com.kayak.marsrobot.enums.MovementInstruction;
import com.kayak.marsrobot.exception.IllegalCommandException;
import com.kayak.marsrobot.resolver.FacingDirectionResolver;
import com.kayak.marsrobot.util.CommandValidationUtil;

public class Robot implements RobotInterface {
    private FacingDirection currentFacingDirection;
    private Coordinate coordinate;

    /**
     * Initial constructor. Requires initial facing direction which can be any of the {@link FacingDirection} values
     *
     * @param initialFacingDirection
     */
    public Robot(FacingDirection initialFacingDirection) {
        if (initialFacingDirection == null) {
            throw new IllegalArgumentException("Invalid facing direction");
        }
        this.currentFacingDirection = initialFacingDirection;
        this.coordinate = new Coordinate(0, 0);
    }

    /**
     * Move the robot giving it one or more characters combined into a single command. All valid characters are listd
     * in the {@link MovementInstruction}
     *
     * @param commands
     */
    @Override
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

    /**
     * Move the robot 1 step forward
     */
    protected void moveForward() {
        if (currentFacingDirection == FacingDirection.NORTH) {
            coordinate.setY(coordinate.getY() + 1);
            return;
        }

        if (currentFacingDirection == FacingDirection.EAST) {
            coordinate.setX(coordinate.getX() + 1);
            return;
        }

        if (currentFacingDirection == FacingDirection.SOUTH) {
            coordinate.setY(coordinate.getY() - 1);
            return;
        }

        if (currentFacingDirection == FacingDirection.WEST) {
            coordinate.setX(coordinate.getX() - 1);
            return;
        }

        throw new RuntimeException("Unsupported current facing direction!");
    }

    /**
     * Rotate the robot 90 degrees to the left
     */
    protected void turnLeft() {
        currentFacingDirection = FacingDirectionResolver.changeFacingDirection(currentFacingDirection, MovementInstruction.TURN_LEFT);
    }

    /**
     * Rotate the robot 90 degrees to the right
     */
    protected void turnRight() {
        currentFacingDirection = FacingDirectionResolver.changeFacingDirection(currentFacingDirection, MovementInstruction.TURN_RIGHT);
    }

    /**
     * Get current coordinates
     *
     * @return
     */
    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * Get current facing direction
     *
     * @return
     */
    @Override
    public FacingDirection getCurrentFacingDirection() {
        return currentFacingDirection;
    }
}
