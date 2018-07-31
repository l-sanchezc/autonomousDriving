package com.here.autonomous.driving.model;

public enum DrivingMode {

    NORMAL, SPORT, SAFE, NOT_VALID;

    public static DrivingMode validate(String drivingMode) {
        try {
            return DrivingMode.valueOf(drivingMode);
        } catch (IllegalArgumentException e) {
            return NOT_VALID;
        }
    }
}
