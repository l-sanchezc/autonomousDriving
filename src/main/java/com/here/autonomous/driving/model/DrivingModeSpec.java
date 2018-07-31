package com.here.autonomous.driving.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DrivingModeSpec {

    private DrivingMode drivingMode;
    private List<SensorEvent> sensorEvents;

    public DrivingModeSpec(@JsonProperty(required = true, value = "drivingMode") DrivingMode drivingMode,
                           @JsonProperty(required = true, value = "sensorEvents") List<SensorEvent> sensorEvents) {
        this.drivingMode = drivingMode;
        this.sensorEvents = sensorEvents;
    }
}
