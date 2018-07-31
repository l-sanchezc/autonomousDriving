package com.here.autonomous.driving.controller;

import com.here.autonomous.driving.model.BusAddresses;
import com.here.autonomous.driving.model.DrivingMode;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.Json;
import com.here.autonomous.driving.model.SensorMessage;
import com.here.autonomous.driving.model.Vehicle;

import static com.here.autonomous.driving.model.Constants.messages;

public class VehicleController extends AbstractVerticle {

    private final StatCalculator statCalculator = new StatCalculator();
    private Vehicle vehicle;
    private DrivingMode drivingMode;
    private String drivingModeArgument;

    public VehicleController(String drivingModeArgument) {
        this.drivingModeArgument = drivingModeArgument.toUpperCase();
    }

    @Override
    public void start(Future<Void> startFuture) {
        EventBus eventBus = vertx.eventBus();
        vehicle = new Vehicle();
        vertx.setTimer(100, id -> {
            drivingMode = DrivingMode.validate(drivingModeArgument.toUpperCase());
            vehicle.setDrivingMode(drivingMode);
            System.out.println(messages.getString("welcome_msg") + drivingMode);
            System.out.println(vehicle.getCurrentSpeed());
            System.out.print(messages.getString("enter_event"));
        });
        eventBus.consumer(BusAddresses.SPEED_BUS_ADDRESS.SpeedBusAddress(), m -> {
            SensorMessage sensorMessage = Json.decodeValue(m.body().toString(), SensorMessage.class);
            try {
                int newSpeed = statCalculator.calculateStat(BusAddresses.SPEED_BUS_ADDRESS, vehicle, sensorMessage);
                vehicle.setCurrentSpeed(newSpeed);
                System.out.println(newSpeed);
                m.reply(newSpeed);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
