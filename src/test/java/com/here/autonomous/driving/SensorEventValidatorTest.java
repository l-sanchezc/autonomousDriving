package com.here.autonomous.driving;

import com.here.autonomous.driving.model.DrivingMode;
import com.here.autonomous.driving.utils.DrivingModeSpecUtils;
import com.here.autonomous.driving.utils.validators.Exception.InvalidDrivingModeException;
import com.here.autonomous.driving.utils.validators.Exception.InvalidEventException;
import com.here.autonomous.driving.utils.validators.SensorEventValidator;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Random;

public class SensorEventValidatorTest {
    private static SensorEventValidator sensorEventValidator;
    private static HashMap<Integer, Integer> drivingModeSpecMap;
    private static DrivingMode drivingMode;
    private static int randomBig;

    @BeforeClass
    public static void setUp() throws InvalidDrivingModeException {
        sensorEventValidator = new SensorEventValidator();
        drivingModeSpecMap = new HashMap<>();
        randomBig = new Random().nextInt(10000);
        drivingMode = DrivingMode.values()[new Random().nextInt(2)];
        drivingModeSpecMap = new DrivingModeSpecUtils(drivingMode).getDrivingModeSpecifications();
    }

    @Test
    public void sensorEventValidator_validEventId() throws Exception {
        int random = new Random().nextInt(99) + 1;
        while (random == 8 || random == 9)
            random = new Random().nextInt(99) + 1;
        sensorEventValidator.validate(random, drivingModeSpecMap);
    }

    @Test(expected = InvalidEventException.class)
    public void sensorEventValidator_invalidEventId_eventIdMoreThan101() throws Exception {
        sensorEventValidator.validate(randomBig + 101, drivingModeSpecMap);
    }

    @Test(expected = InvalidEventException.class)
    public void sensorEventValidator_invalidEventId_eventIdLessThan1() throws Exception {
        sensorEventValidator.validate(randomBig * -1, drivingModeSpecMap);
    }

    @Test(expected = InvalidEventException.class)
    public void sensorEventValidator_invalidEventId_eventId0() throws Exception {
        sensorEventValidator.validate(0, drivingModeSpecMap);
    }

    @Test(expected = InvalidEventException.class)
    public void sensorEventValidator_invalidEventId_eventId101() throws Exception {
        sensorEventValidator.validate(101, drivingModeSpecMap);
    }

    @Test(expected = InvalidEventException.class)
    public void sensorEventValidator_invalidEventId_eventId8() throws Exception {
        sensorEventValidator.validate(8, drivingModeSpecMap);
    }

    @Test(expected = InvalidEventException.class)
    public void sensorEventValidator_invalidEventId_eventId9() throws Exception {
        sensorEventValidator.validate(9, drivingModeSpecMap);
    }
}
