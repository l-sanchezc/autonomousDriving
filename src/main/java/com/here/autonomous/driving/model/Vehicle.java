package com.here.autonomous.driving.model;

import lombok.Data;

@Data
public class Vehicle {

    private DrivingMode drivingMode;
    private int currentSpeed = Constants.INITIAL_SPEED;

}
