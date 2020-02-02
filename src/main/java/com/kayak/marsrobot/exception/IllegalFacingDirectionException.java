package com.kayak.marsrobot.exception;

import com.kayak.marsrobot.enums.FacingDirection;

public class IllegalFacingDirectionException extends RuntimeException {

    public IllegalFacingDirectionException(FacingDirection direction) {
        super(direction + " is not a valid facing direction");
    }
}
