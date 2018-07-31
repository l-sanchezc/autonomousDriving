package com.here.autonomous.driving.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SensorMessage {

    private int eventId;

    @JsonCreator
    public SensorMessage(@JsonProperty(required = true, value = "eventId") int eventId) {
        this.eventId = eventId;
    }
}
