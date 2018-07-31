package com.here.autonomous.driving.controller.strategies;

import com.here.autonomous.driving.model.BusAddresses;

public class StatCalculationStrategyFactory {

    private final StatCalculationStrategy speedCalculationStrategy = new SpeedStatCalculationStrategy();

    public StatCalculationStrategy getStatCalculationStrategy(BusAddresses busAddresses) {
        switch (busAddresses) {
            case SPEED_BUS_ADDRESS:
                return speedCalculationStrategy;
            default:
                return null;
        }
    }

}
