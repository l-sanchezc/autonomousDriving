package com.here.autonomous.driving.controller.strategies;

import com.here.autonomous.driving.model.SensorMessage;
import com.here.autonomous.driving.model.Vehicle;
import com.here.autonomous.driving.utils.DrivingModeSpecUtils;
import com.here.autonomous.driving.utils.NewSpeedUtils;
import com.here.autonomous.driving.utils.validators.Exception.InvalidDrivingModeException;
import com.here.autonomous.driving.utils.validators.Exception.InvalidEventException;
import com.here.autonomous.driving.utils.validators.Exception.SensorEventException;
import com.here.autonomous.driving.utils.validators.SensorEventValidator;
import com.here.autonomous.driving.utils.validators.Validator;

import java.util.HashMap;

public class SpeedStatCalculationStrategy implements StatCalculationStrategy<Vehicle, SensorMessage> {

    private final Validator<Integer, HashMap<Integer, Integer>> sensorEventValidator = new SensorEventValidator();
    private static final NewSpeedUtils newSpeedUtils = new NewSpeedUtils();

    @Override
    public int calculateStat(Vehicle vehicle, SensorMessage sensorMessage) throws Exception {
        DrivingModeSpecUtils drivingModeSpecUtils = new DrivingModeSpecUtils(vehicle.getDrivingMode());
        HashMap<Integer, Integer> drivingModeSpecMap = drivingModeSpecUtils.getDrivingModeSpecifications();
        try {
            sensorEventValidator.validate(sensorMessage.getEventId(), drivingModeSpecMap);
            return newSpeedUtils.getNewSpeed(sensorMessage.getEventId(), vehicle.getCurrentSpeed(), drivingModeSpecMap);
        } catch (InvalidEventException | InvalidDrivingModeException i) {
            System.out.println(i.getMessage());
        } catch (SensorEventException e) {
        }
        return vehicle.getCurrentSpeed();
    }

}
