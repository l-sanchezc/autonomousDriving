package com.here.autonomous.driving;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        ArgumentsAppValidatorTest.class,
        DrivingModeSpecUtilsTest.class,
        NewSpeedUtilsTest.class,
        ScannerUtilsTest.class,
        SensorEventValidatorTest.class
})
public class JunitTestSuite {
}