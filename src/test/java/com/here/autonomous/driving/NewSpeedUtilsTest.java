package com.here.autonomous.driving;

import com.here.autonomous.driving.model.DrivingMode;
import com.here.autonomous.driving.utils.DrivingModeSpecUtils;
import com.here.autonomous.driving.utils.NewSpeedUtils;
import com.here.autonomous.driving.utils.validators.Exception.InvalidDrivingModeException;
import com.here.autonomous.driving.utils.validators.Exception.SensorEventException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Random;

public class NewSpeedUtilsTest {

    private static HashMap<Integer, Integer> normalDrivingModeSpec;
    private static HashMap<Integer, Integer> sportDrivingModeSpec;
    private static HashMap<Integer, Integer> safeDrivingModeSpec;
    private static int currentSpeed;
    private static int newSpeed;
    private static int expectedSpeed;
    private static NewSpeedUtils newSpeedUtils;
    private static final int MINIMUM_SPEED = 10;
    private static int randomMoreThan10;

    @BeforeClass
    public static void setUp() throws InvalidDrivingModeException {
        DrivingModeSpecUtils normalDrivingModeSpecUtils = new DrivingModeSpecUtils(DrivingMode.NORMAL);
        DrivingModeSpecUtils sportDrivingModeSpecUtils = new DrivingModeSpecUtils(DrivingMode.SPORT);
        DrivingModeSpecUtils safeDrivingModeSpecUtils = new DrivingModeSpecUtils(DrivingMode.SAFE);
        normalDrivingModeSpec = normalDrivingModeSpecUtils.getDrivingModeSpecifications();
        sportDrivingModeSpec = sportDrivingModeSpecUtils.getDrivingModeSpecifications();
        safeDrivingModeSpec = safeDrivingModeSpecUtils.getDrivingModeSpecifications();
        newSpeedUtils = new NewSpeedUtils();
        randomMoreThan10 = new Random().nextInt(150) + 10;
    }

    @Before
    public void setUpbeforeTests() {
        currentSpeed = new Random().nextInt(100) + 10;
    }

    @Test
    public void newSpeedUtils_eventId1_normalDrivingMode() throws SensorEventException {
        newSpeed = newSpeedUtils.getNewSpeed(1, currentSpeed, normalDrivingModeSpec);
        expectedSpeed = (currentSpeed - 10 >= MINIMUM_SPEED) ? currentSpeed - 10 : MINIMUM_SPEED;
        Assert.assertEquals(expectedSpeed, newSpeed);
    }

    @Test
    public void newSpeedUtils_eventId1_sportDrivingMode() throws SensorEventException {
        newSpeed = newSpeedUtils.getNewSpeed(1, currentSpeed, sportDrivingModeSpec);
        expectedSpeed = (currentSpeed - 5 >= MINIMUM_SPEED) ? currentSpeed - 5 : MINIMUM_SPEED;
        Assert.assertEquals(expectedSpeed, newSpeed);
    }

    @Test
    public void newSpeedUtils_eventId1_safeDrivingMode() throws SensorEventException {
        newSpeed = newSpeedUtils.getNewSpeed(1, currentSpeed, safeDrivingModeSpec);
        expectedSpeed = (currentSpeed - 15 >= MINIMUM_SPEED) ? currentSpeed - 15 : MINIMUM_SPEED;
        Assert.assertEquals(expectedSpeed, newSpeed);
    }

    @Test
    public void newSpeedUtils_eventId2_normalDrivingMode() throws SensorEventException {
        newSpeed = newSpeedUtils.getNewSpeed(2, currentSpeed, normalDrivingModeSpec);
        expectedSpeed = (currentSpeed + 10 >= MINIMUM_SPEED) ? currentSpeed + 10 : MINIMUM_SPEED;
        Assert.assertEquals(expectedSpeed, newSpeed);
    }

    @Test
    public void newSpeedUtils_eventId2_sportDrivingMode() throws SensorEventException {
        newSpeed = newSpeedUtils.getNewSpeed(2, currentSpeed, sportDrivingModeSpec);
        expectedSpeed = (currentSpeed + 5 >= MINIMUM_SPEED) ? currentSpeed + 5 : MINIMUM_SPEED;
        Assert.assertEquals(expectedSpeed, newSpeed);
    }

    @Test
    public void newSpeedUtils_eventId2_safeDrivingMode() throws SensorEventException {
        newSpeed = newSpeedUtils.getNewSpeed(2, currentSpeed, safeDrivingModeSpec);
        expectedSpeed = (currentSpeed + 15 >= MINIMUM_SPEED) ? currentSpeed + 15 : MINIMUM_SPEED;
        Assert.assertEquals(expectedSpeed, newSpeed);
    }

    @Test
    public void newSpeedUtils_eventId3_normalDrivingMode() throws SensorEventException {
        newSpeed = newSpeedUtils.getNewSpeed(3, currentSpeed, normalDrivingModeSpec);
        expectedSpeed = (currentSpeed - 5 >= MINIMUM_SPEED) ? currentSpeed - 5 : MINIMUM_SPEED;
        Assert.assertEquals(expectedSpeed, newSpeed);
    }

    @Test
    public void newSpeedUtils_eventId3_sportDrivingMode() throws SensorEventException {
        newSpeed = newSpeedUtils.getNewSpeed(3, currentSpeed, sportDrivingModeSpec);
        expectedSpeed = (currentSpeed - 5 >= MINIMUM_SPEED) ? currentSpeed - 5 : MINIMUM_SPEED;
        Assert.assertEquals(expectedSpeed, newSpeed);
    }

    @Test
    public void newSpeedUtils_eventId3_safeDrivingMode() throws SensorEventException {
        newSpeed = newSpeedUtils.getNewSpeed(3, currentSpeed, safeDrivingModeSpec);
        expectedSpeed = (currentSpeed - 5 >= MINIMUM_SPEED) ? currentSpeed - 5 : MINIMUM_SPEED;
        Assert.assertEquals(expectedSpeed, newSpeed);
    }

    @Test
    public void newSpeedUtils_eventId4_normalDrivingMode() throws SensorEventException {
        newSpeed = newSpeedUtils.getNewSpeed(4, currentSpeed, normalDrivingModeSpec);
        expectedSpeed = (currentSpeed + 5 >= MINIMUM_SPEED) ? currentSpeed + 5 : MINIMUM_SPEED;
        Assert.assertEquals(expectedSpeed, newSpeed);
    }

    @Test
    public void newSpeedUtils_eventId4_sportDrivingMode() throws SensorEventException {
        newSpeed = newSpeedUtils.getNewSpeed(4, currentSpeed, sportDrivingModeSpec);
        expectedSpeed = (currentSpeed + 5 >= MINIMUM_SPEED) ? currentSpeed + 5 : MINIMUM_SPEED;
        Assert.assertEquals(expectedSpeed, newSpeed);
    }

    @Test
    public void newSpeedUtils_eventId4_safeDrivingMode() throws SensorEventException {
        newSpeed = newSpeedUtils.getNewSpeed(4, currentSpeed, safeDrivingModeSpec);
        expectedSpeed = (currentSpeed + 5 >= MINIMUM_SPEED) ? currentSpeed + 5 : MINIMUM_SPEED;
        Assert.assertEquals(expectedSpeed, newSpeed);
    }

    @Test
    public void newSpeedUtils_eventId5_normalDrivingMode() throws SensorEventException {
        newSpeed = newSpeedUtils.getNewSpeed(5, currentSpeed, normalDrivingModeSpec);
        expectedSpeed = (currentSpeed - 15 >= MINIMUM_SPEED) ? currentSpeed - 15 : MINIMUM_SPEED;
        Assert.assertEquals(expectedSpeed, newSpeed);
    }

    @Test
    public void newSpeedUtils_eventId5_sportDrivingMode() throws SensorEventException {
        newSpeed = newSpeedUtils.getNewSpeed(5, currentSpeed, sportDrivingModeSpec);
        expectedSpeed = (currentSpeed - 15 >= MINIMUM_SPEED) ? currentSpeed - 15 : MINIMUM_SPEED;
        Assert.assertEquals(expectedSpeed, newSpeed);
    }

    @Test
    public void newSpeedUtils_eventId5_safeDrivingMode() throws SensorEventException {
        newSpeed = newSpeedUtils.getNewSpeed(5, currentSpeed, safeDrivingModeSpec);
        expectedSpeed = (currentSpeed - 15 >= MINIMUM_SPEED) ? currentSpeed - 15 : MINIMUM_SPEED;
        Assert.assertEquals(expectedSpeed, newSpeed);
    }

    @Test
    public void newSpeedUtils_eventId6_normalDrivingMode() throws SensorEventException {
        newSpeed = newSpeedUtils.getNewSpeed(6, currentSpeed, normalDrivingModeSpec);
        expectedSpeed = (currentSpeed + 15 >= MINIMUM_SPEED) ? currentSpeed + 15 : MINIMUM_SPEED;
        Assert.assertEquals(expectedSpeed, newSpeed);
    }

    @Test
    public void newSpeedUtils_eventId6_sportDrivingMode() throws SensorEventException {
        newSpeed = newSpeedUtils.getNewSpeed(6, currentSpeed, sportDrivingModeSpec);
        expectedSpeed = (currentSpeed + 15 >= MINIMUM_SPEED) ? currentSpeed + 15 : MINIMUM_SPEED;
        Assert.assertEquals(expectedSpeed, newSpeed);
    }

    @Test
    public void newSpeedUtils_eventId6_safeDrivingMode() throws SensorEventException {
        newSpeed = newSpeedUtils.getNewSpeed(6, currentSpeed, safeDrivingModeSpec);
        expectedSpeed = (currentSpeed + 15 >= MINIMUM_SPEED) ? currentSpeed + 15 : MINIMUM_SPEED;
        Assert.assertEquals(expectedSpeed, newSpeed);
    }

    @Test
    public void newSpeedUtils_eventId7_normalDrivingMode() throws SensorEventException {
        newSpeed = newSpeedUtils.getNewSpeed(7, currentSpeed, normalDrivingModeSpec);
        expectedSpeed = (currentSpeed + 20 >= MINIMUM_SPEED) ? currentSpeed + 20 : MINIMUM_SPEED;
        Assert.assertEquals(expectedSpeed, newSpeed);
    }

    @Test
    public void newSpeedUtils_eventId7_sportDrivingMode() throws SensorEventException {
        newSpeed = newSpeedUtils.getNewSpeed(7, currentSpeed, sportDrivingModeSpec);
        expectedSpeed = (currentSpeed + 30 >= MINIMUM_SPEED) ? currentSpeed + 30 : MINIMUM_SPEED;
        Assert.assertEquals(expectedSpeed, newSpeed);
    }

    @Test
    public void newSpeedUtils_eventId7_safeDrivingMode() throws SensorEventException {
        newSpeed = newSpeedUtils.getNewSpeed(7, currentSpeed, safeDrivingModeSpec);
        expectedSpeed = (currentSpeed + 10 >= MINIMUM_SPEED) ? currentSpeed + 10 : MINIMUM_SPEED;
        Assert.assertEquals(expectedSpeed, newSpeed);
    }

    @Test
    public void newSpeedUtils_eventId10_normalDrivingMode() throws SensorEventException {
        newSpeed = newSpeedUtils.getNewSpeed(10, currentSpeed, normalDrivingModeSpec);
        Assert.assertEquals(10, newSpeed);
    }

    @Test
    public void newSpeedUtils_eventId10_sportDrivingMode() throws SensorEventException {
        newSpeed = newSpeedUtils.getNewSpeed(10, currentSpeed, sportDrivingModeSpec);
        Assert.assertEquals(15, newSpeed);
    }

    @Test
    public void newSpeedUtils_eventId10_safeDrivingMode() throws SensorEventException {
        newSpeed = newSpeedUtils.getNewSpeed(10, currentSpeed, safeDrivingModeSpec);
        Assert.assertEquals(10, newSpeed);
    }

    @Test
    public void newSpeedUtils_eventIdMoreThan10_normalDrivingMode() throws SensorEventException {
        newSpeed = newSpeedUtils.getNewSpeed(randomMoreThan10, currentSpeed, normalDrivingModeSpec);
        Assert.assertEquals(randomMoreThan10, newSpeed);
    }

    @Test
    public void newSpeedUtils_eventIdMoreThan10_sportDrivingMode() throws SensorEventException {
        newSpeed = newSpeedUtils.getNewSpeed(randomMoreThan10, currentSpeed, sportDrivingModeSpec);
        Assert.assertEquals(randomMoreThan10 + 5, newSpeed);
    }

    @Test
    public void newSpeedUtils_eventIdMoreThan10_safeDrivingMode() throws SensorEventException {
        newSpeed = newSpeedUtils.getNewSpeed(randomMoreThan10, currentSpeed, safeDrivingModeSpec);
        expectedSpeed = (randomMoreThan10 - 5 >= MINIMUM_SPEED) ? randomMoreThan10 - 5 : MINIMUM_SPEED;
        Assert.assertEquals(expectedSpeed, newSpeed);
    }

}
