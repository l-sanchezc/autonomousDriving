package com.here.autonomous.driving.utils;

import com.here.autonomous.driving.model.Constants;

import java.util.HashMap;

public class NewSpeedUtils {

    public int getNewSpeed(int eventId, int currentSpeed, HashMap<Integer, Integer> specMap) {
        int newSpeed;
        if (eventId >= Constants.SPEED_LIMIT_ID)
            newSpeed = eventId + specMap.get(Constants.SPEED_LIMIT_ID);
        else
            newSpeed = currentSpeed + specMap.get(eventId);
        return (newSpeed >= Constants.MINIMUM_SPEED) ? newSpeed : Constants.MINIMUM_SPEED;
    }
}
