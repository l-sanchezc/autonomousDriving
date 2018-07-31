package com.here.autonomous.driving.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SensorEvent {

    private int id;
    private String description;
    private int action;

}