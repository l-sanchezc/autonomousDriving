package com.here.autonomous.driving.utils.validators;

import com.here.autonomous.driving.model.Constants;
import com.here.autonomous.driving.utils.validators.Exception.InvalidEventException;
import com.here.autonomous.driving.utils.validators.Exception.SensorEventException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static com.here.autonomous.driving.model.Constants.messages;

public class SensorEventValidator implements Validator<Integer, HashMap<Integer, Integer>> {

    private Set<Integer> pastEvents = new HashSet<>();

    @Override
    public void validate(Integer integer) throws Exception {
    }

    @Override
    public void validate(Integer sensorEventId, HashMap<Integer, Integer> drivingModeSpecMap) throws Exception {
        if (sensorEventId > Constants.MAX_EVENT_ID || sensorEventId <= Constants.SPEED_LIMIT_ID && !drivingModeSpecMap.containsKey(sensorEventId))
            throw new InvalidEventException(messages.getString("invalid"));
        else {
            if (pastEvents.contains(sensorEventId))
                throw new SensorEventException();
            else {
                if (sensorEventId >= Constants.SPEED_LIMIT_ID) {
                    pastEvents.add(sensorEventId);
                    if (pastEvents.contains(Constants.EMERGENCY_TURBO_ID))
                        pastEvents.remove(Constants.EMERGENCY_TURBO_ID);
                } else if (sensorEventId == Constants.EMERGENCY_TURBO_ID && pastEvents.contains(Constants.SLIPPERY_ROAD_ID))
                    throw new SensorEventException();
                else if (sensorEventId < Constants.SPEED_LIMIT_ID && sensorEventId % 2 == 0) {
                    if (!pastEvents.contains(sensorEventId - 1))
                        throw new SensorEventException();
                    else {
                        pastEvents.remove(sensorEventId - 1);
                    }
                } else
                    pastEvents.add(sensorEventId);
            }
        }
    }
}
