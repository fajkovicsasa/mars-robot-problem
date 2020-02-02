package com.kayak.marsrobot.util;

import com.kayak.marsrobot.enums.MovementInstruction;

public class CommandValidationUtil {
    public static boolean isValidCommand(String commands) {
        if (commands == null) {
            return false;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (MovementInstruction mc : MovementInstruction.class.getEnumConstants()) {
            sb.append(mc.getValue());
        }
        sb.append("]+");

        return commands.matches(sb.toString());
    }
}
