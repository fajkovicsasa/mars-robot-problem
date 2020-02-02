package com.kayak.marsrobot.resolver;

import com.kayak.marsrobot.enums.FacingDirection;
import com.kayak.marsrobot.enums.MovementInstruction;
import com.kayak.marsrobot.exception.IllegalCommandException;
import com.kayak.marsrobot.exception.IllegalFacingDirectionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FacingDirectionResolverTest {

    @Test
    public void shouldThrowException() {
        assertThrows(IllegalFacingDirectionException.class, () -> {
            FacingDirectionResolver.changeFacingDirection(null, null);
        });
        assertThrows(IllegalCommandException.class, () -> {
            FacingDirectionResolver.changeFacingDirection(FacingDirection.EAST, null);
        });
        assertThrows(IllegalFacingDirectionException.class, () -> {
            FacingDirectionResolver.changeFacingDirection(null, MovementInstruction.FORWARD);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FacingDirectionResolver.changeFacingDirection(FacingDirection.EAST, MovementInstruction.FORWARD);
        });
    }

    @Test
    public void shouldRotateRight() {
        assertEquals(FacingDirection.EAST, FacingDirectionResolver.changeFacingDirection(FacingDirection.NORTH, MovementInstruction.TURN_RIGHT));
        assertEquals(FacingDirection.SOUTH, FacingDirectionResolver.changeFacingDirection(FacingDirection.EAST, MovementInstruction.TURN_RIGHT));
        assertEquals(FacingDirection.WEST, FacingDirectionResolver.changeFacingDirection(FacingDirection.SOUTH, MovementInstruction.TURN_RIGHT));
        assertEquals(FacingDirection.NORTH, FacingDirectionResolver.changeFacingDirection(FacingDirection.WEST, MovementInstruction.TURN_RIGHT));
    }

    @Test
    public void shouldRotateLeft() {
        assertEquals(FacingDirection.WEST, FacingDirectionResolver.changeFacingDirection(FacingDirection.NORTH, MovementInstruction.TURN_LEFT));
        assertEquals(FacingDirection.NORTH, FacingDirectionResolver.changeFacingDirection(FacingDirection.EAST, MovementInstruction.TURN_LEFT));
        assertEquals(FacingDirection.EAST, FacingDirectionResolver.changeFacingDirection(FacingDirection.SOUTH, MovementInstruction.TURN_LEFT));
        assertEquals(FacingDirection.SOUTH, FacingDirectionResolver.changeFacingDirection(FacingDirection.WEST, MovementInstruction.TURN_LEFT));
    }
}
