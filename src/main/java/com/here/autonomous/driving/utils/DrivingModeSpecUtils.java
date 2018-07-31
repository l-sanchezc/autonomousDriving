package com.here.autonomous.driving.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.here.autonomous.driving.model.DrivingMode;
import com.here.autonomous.driving.model.DrivingModeSpec;
import com.here.autonomous.driving.model.SensorEvent;
import com.here.autonomous.driving.utils.validators.Exception.InvalidDrivingModeException;

import static com.here.autonomous.driving.model.Constants.messages;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class DrivingModeSpecUtils {

    private HashMap<Integer, Integer> drivingModeSpecMap = new HashMap<>();
    private DrivingMode drivingMode;

    public DrivingModeSpecUtils(DrivingMode drivingMode) {
        this.drivingMode = drivingMode;
    }

    public HashMap<Integer, Integer> getDrivingModeSpecifications() throws InvalidDrivingModeException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            InputStream in = classLoader.getResourceAsStream("speed-spec/" + drivingMode + "-driving-mode.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            return createDrivingModeSpecMap(objectMapper.readValue(reader, DrivingModeSpec.class));
        } catch (Exception e) {
            throw new InvalidDrivingModeException(messages.getString("specifications_file_not_found"));
        }
    }

    private HashMap<Integer, Integer> createDrivingModeSpecMap(DrivingModeSpec drivingModeSpec) {
        for (SensorEvent sensorEvent : drivingModeSpec.getSensorEvents()) {
            drivingModeSpecMap.put(sensorEvent.getId(), sensorEvent.getAction());
        }
        return drivingModeSpecMap;
    }
}
