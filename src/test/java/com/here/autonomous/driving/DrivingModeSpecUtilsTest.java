package com.here.autonomous.driving;

import com.here.autonomous.driving.model.DrivingMode;
import com.here.autonomous.driving.model.SensorEvent;
import com.here.autonomous.driving.utils.DrivingModeSpecUtils;
import com.here.autonomous.driving.utils.validators.Exception.InvalidDrivingModeException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DrivingModeSpecUtilsTest {
    private static DrivingModeSpecUtils normalDrivingModeSpecUtils;
    private static DrivingModeSpecUtils sportDrivingModeSpecUtils;
    private static DrivingModeSpecUtils safeDrivingModeSpecUtils;
    private static DrivingModeSpecUtils invalidDrivingModeSpecUtils;
    private static HashMap<Integer, Integer> normalDrivindModeSpecMap;
    private static HashMap<Integer, Integer> sportDrivindModeSpecMap;
    private static HashMap<Integer, Integer> safeDrivindModeSpecMap;

    @BeforeClass
    public static void setUp() {
        normalDrivingModeSpecUtils = new DrivingModeSpecUtils(DrivingMode.NORMAL);
        sportDrivingModeSpecUtils = new DrivingModeSpecUtils(DrivingMode.SPORT);
        safeDrivingModeSpecUtils = new DrivingModeSpecUtils(DrivingMode.SAFE);
        invalidDrivingModeSpecUtils = new DrivingModeSpecUtils(DrivingMode.NOT_VALID);

        normalDrivindModeSpecMap = new HashMap<>();
        sportDrivindModeSpecMap = new HashMap<>();
        safeDrivindModeSpecMap = new HashMap<>();

        List<SensorEvent> normalSensorEventList = new ArrayList<>();
        List<SensorEvent> sportSensorEventList = new ArrayList<>();
        List<SensorEvent> safeSensorEventList = new ArrayList<>();

        normalSensorEventList.add(new SensorEvent(1, "Traffic", -10));
        normalSensorEventList.add(new SensorEvent(2, "Traffic Clear", 10));
        normalSensorEventList.add(new SensorEvent(3, "Weather Rainy", -5));
        normalSensorEventList.add(new SensorEvent(4, "Weather Clear", +5));
        normalSensorEventList.add(new SensorEvent(5, "Slippery Road", -15));
        normalSensorEventList.add(new SensorEvent(6, "Slippery Road Clear", 15));
        normalSensorEventList.add(new SensorEvent(7, "Emergency Turbo", 20));
        normalSensorEventList.add(new SensorEvent(10, "Speed Limit Sign X", 0));

        sportSensorEventList.add(new SensorEvent(1, "Traffic", -5));
        sportSensorEventList.add(new SensorEvent(2, "Traffic Clear", +5));
        sportSensorEventList.add(new SensorEvent(3, "Weather Rainy", -5));
        sportSensorEventList.add(new SensorEvent(4, "Weather Clear", +5));
        sportSensorEventList.add(new SensorEvent(5, "Slippery Road", -15));
        sportSensorEventList.add(new SensorEvent(6, "Slippery Road Clear", 15));
        sportSensorEventList.add(new SensorEvent(7, "Emergency Turbo", 30));
        sportSensorEventList.add(new SensorEvent(10, "Speed Limit Sign X", 5));

        safeSensorEventList.add(new SensorEvent(1, "Traffic", -15));
        safeSensorEventList.add(new SensorEvent(2, "Traffic Clear", 15));
        safeSensorEventList.add(new SensorEvent(3, "Weather Rainy", -5));
        safeSensorEventList.add(new SensorEvent(4, "Weather Clear", +5));
        safeSensorEventList.add(new SensorEvent(5, "Slippery Road", -15));
        safeSensorEventList.add(new SensorEvent(6, "Slippery Road Clear", 15));
        safeSensorEventList.add(new SensorEvent(7, "Emergency Turbo", 10));
        safeSensorEventList.add(new SensorEvent(10, "Speed Limit Sign X", -5));

        normalSensorEventList.forEach(sensorEvent ->
                normalDrivindModeSpecMap.put(sensorEvent.getId(), sensorEvent.getAction())
        );
        sportSensorEventList.forEach(sensorEvent ->
                sportDrivindModeSpecMap.put(sensorEvent.getId(), sensorEvent.getAction())
        );
        safeSensorEventList.forEach(sensorEvent ->
                safeDrivindModeSpecMap.put(sensorEvent.getId(), sensorEvent.getAction())
        );
    }

    @Test
    public void drivingModeSpecUtils_normalDrivingMode() throws InvalidDrivingModeException {
        Assert.assertEquals(normalDrivindModeSpecMap, normalDrivingModeSpecUtils.getDrivingModeSpecifications());
    }

    @Test
    public void drivingModeSpecUtils_sportDrivingMode() throws InvalidDrivingModeException {
        Assert.assertEquals(sportDrivindModeSpecMap, sportDrivingModeSpecUtils.getDrivingModeSpecifications());
    }

    @Test
    public void drivingModeSpecUtils_safeDrivingMode() throws InvalidDrivingModeException {
        Assert.assertEquals(safeDrivindModeSpecMap, safeDrivingModeSpecUtils.getDrivingModeSpecifications());
    }

    @Test(expected = InvalidDrivingModeException.class)
    public void drivingModeSpecUtils_invalidDrivingMode() throws InvalidDrivingModeException {
        Assert.assertEquals(null, invalidDrivingModeSpecUtils.getDrivingModeSpecifications());
    }
}
