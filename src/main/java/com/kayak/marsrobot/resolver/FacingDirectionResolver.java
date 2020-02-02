package com.kayak.marsrobot.resolver;

import com.kayak.marsrobot.enums.FacingDirection;
import com.kayak.marsrobot.enums.MovementInstruction;
import com.kayak.marsrobot.exception.IllegalCommandException;
import com.kayak.marsrobot.exception.IllegalFacingDirectionException;

public final class FacingDirectionResolver {

    private FacingDirectionResolver() {
    }

    public static FacingDirection changeFacingDirection(FacingDirection currentFacingDirection, MovementInstruction movementInstruction) {
        if (currentFacingDirection == null) {
            throw new IllegalFacingDirectionException(null);
        }

        if (movementInstruction == null) {
            throw new IllegalCommandException(null);
        }

        if (movementInstruction != MovementInstruction.TURN_LEFT && movementInstruction != MovementInstruction.TURN_RIGHT) {
            throw new IllegalArgumentException(movementInstruction + " is not a valid command to change facing direction.");
        }
        return movementInstruction.equals(MovementInstruction.TURN_LEFT) ? rotateLeft(currentFacingDirection) : rotateRight(currentFacingDirection);
    }

    private static FacingDirection rotateRight(FacingDirection currentFacingDirection) {
        if (currentFacingDirection == FacingDirection.NORTH) {
            return FacingDirection.EAST;
        }

        if (currentFacingDirection == FacingDirection.EAST) {
            return FacingDirection.SOUTH;
        }

        if (currentFacingDirection == FacingDirection.SOUTH) {
            return FacingDirection.WEST;
        }

        if (currentFacingDirection == FacingDirection.WEST) {
            return FacingDirection.NORTH;
        }
        throw new IllegalArgumentException("Unsupported facing direction value: " + currentFacingDirection);
    }

    private static FacingDirection rotateLeft(FacingDirection currentFacingDirection) {
        if (currentFacingDirection == FacingDirection.NORTH) {
            return FacingDirection.WEST;
        }

        if (currentFacingDirection == FacingDirection.WEST) {
            return FacingDirection.SOUTH;
        }

        if (currentFacingDirection == FacingDirection.SOUTH) {
            return FacingDirection.EAST;
        }

        if (currentFacingDirection == FacingDirection.EAST) {
            return FacingDirection.NORTH;
        }
        throw new IllegalArgumentException("Unsupported facing direction value: " + currentFacingDirection);
    }

}
