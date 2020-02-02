package com.kayak.marsrobot.resolver;

import com.kayak.marsrobot.enums.FacingDirection;
import com.kayak.marsrobot.enums.MovementCommands;
import com.kayak.marsrobot.exception.IllegalCommandException;

public final class FacingDirectionResolver {

    private FacingDirectionResolver() {
    }

    public static FacingDirection getNewFacingDirection(FacingDirection currentFacingDirection, MovementCommands command) {
        if (currentFacingDirection == null) {
            throw new IllegalArgumentException("Facing direction is not valid.");
        }

        if (command == null) {
            throw new IllegalCommandException(null);
        }

        if (command != MovementCommands.TURN_LEFT && command != MovementCommands.TURN_RIGHT) {
            throw new IllegalArgumentException(command + " is not a valid command to change facing direction.");
        }

        return command.equals(MovementCommands.TURN_LEFT) ? rotateLeft(currentFacingDirection) : rotateRight(currentFacingDirection);
    }

    private static FacingDirection rotateRight(FacingDirection facingDirection) {
        if (facingDirection == FacingDirection.NORTH) {
            return FacingDirection.EAST;
        }

        if (facingDirection == FacingDirection.EAST) {
            return FacingDirection.SOUTH;
        }

        if (facingDirection == FacingDirection.SOUTH) {
            return FacingDirection.WEST;
        }

        if (facingDirection == FacingDirection.WEST) {
            return FacingDirection.NORTH;
        }

        throw new IllegalArgumentException("Unsupported facing direction value: " + facingDirection);
    }

    private static FacingDirection rotateLeft(FacingDirection facingDirection) {
        if (facingDirection == FacingDirection.NORTH) {
            return FacingDirection.WEST;
        }

        if (facingDirection == FacingDirection.WEST) {
            return FacingDirection.SOUTH;
        }

        if (facingDirection == FacingDirection.SOUTH) {
            return FacingDirection.EAST;
        }

        if (facingDirection == FacingDirection.EAST) {
            return FacingDirection.NORTH;
        }

        throw new IllegalArgumentException("Unsupported facing direction value: " + facingDirection);
    }

}
