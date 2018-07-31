package com.here.autonomous.driving.utils;

import com.here.autonomous.driving.utils.validators.Exception.ExitException;

public class ScannerUtils {

    public Integer getInputReader(String input) throws ExitException {
        int inputEventId;
        if (input.equals("exit")) {
            throw new ExitException("Bye!");
        }
        try {
            inputEventId = Integer.parseInt(input);
            if (inputEventId < 1) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            return null;
        }
        return inputEventId;
    }
}
