package com.here.autonomous.driving.controller;

import com.here.autonomous.driving.controller.strategies.StatCalculationStrategy;
import com.here.autonomous.driving.controller.strategies.StatCalculationStrategyFactory;
import com.here.autonomous.driving.model.SensorMessage;
import com.here.autonomous.driving.model.BusAddresses;
import com.here.autonomous.driving.model.Vehicle;

class StatCalculator {

    private final StatCalculationStrategyFactory statCalculationStrategyFactory = new StatCalculationStrategyFactory();

    int calculateStat(BusAddresses busAddresses, Vehicle vehicle, SensorMessage sensorMessage) throws Exception {
        StatCalculationStrategy statCalculationStrategy = statCalculationStrategyFactory.getStatCalculationStrategy(busAddresses);

        return statCalculationStrategy.calculateStat(vehicle, sensorMessage);
    }

}
