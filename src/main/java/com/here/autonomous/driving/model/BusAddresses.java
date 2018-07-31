package com.here.autonomous.driving.model;

public enum BusAddresses {

    SPEED_BUS_ADDRESS("SPEED");

    private String speedBusAddress;

    BusAddresses(String speedBusAddress) {
        this.speedBusAddress = speedBusAddress;
    }

    public String SpeedBusAddress() {
        return speedBusAddress;
    }
}