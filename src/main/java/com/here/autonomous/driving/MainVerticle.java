package com.here.autonomous.driving;

import com.here.autonomous.driving.controller.VehicleController;
import com.here.autonomous.driving.controller.SensorController;
import com.here.autonomous.driving.utils.validators.ArgumentsAppValidator;
import com.here.autonomous.driving.utils.validators.Validator;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;

import java.util.List;

public class MainVerticle extends AbstractVerticle {

    private static final Validator<List<String>, Object> argumentsAppValidator = new ArgumentsAppValidator();

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        super.start(startFuture);
        try {
            argumentsAppValidator.validate(processArgs());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            vertx.close();
        }
        DeploymentOptions optionsWorker = new DeploymentOptions().setWorker(true);
        SensorController sensorController = new SensorController();
        vertx.deployVerticle(sensorController, optionsWorker);
        vertx.deployVerticle(new VehicleController(processArgs().get(2)));
    }

}
