package com.here.autonomous.driving.controller;

import com.here.autonomous.driving.model.SensorEvent;
import com.here.autonomous.driving.utils.validators.Exception.ExitException;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.Json;
import com.here.autonomous.driving.model.BusAddresses;
import com.here.autonomous.driving.model.SensorMessage;
import com.here.autonomous.driving.utils.ScannerUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.here.autonomous.driving.model.Constants.messages;

public class SensorController extends AbstractVerticle {

    private static final ScannerUtils scannerUtils = new ScannerUtils();

    public void start(Future<Void> startFuture) throws Exception {
        super.start(startFuture);
        EventBus eventBus = vertx.eventBus();
        eventColector(eventBus);
    }

    private void eventColector(EventBus eventBus) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        vertx.setPeriodic(100L, event -> {
            try {
                if (reader.ready()) {
                    String input = reader.readLine();
                    int eventId = scannerUtils.getInputReader(input);
                    SensorMessage sensorMessage = new SensorMessage(eventId);
                    eventBus.send(BusAddresses.SPEED_BUS_ADDRESS.SpeedBusAddress(), Json.encodePrettily(sensorMessage), result -> {
                        System.out.print(messages.getString("enter_event"));
                    });
                }
            } catch (ExitException e) {
                vertx.close();
            } catch (IOException i) {
            } catch (NullPointerException e) {
                System.out.println(messages.getString("only_positive_integers"));
                System.out.print(messages.getString("enter_event"));
            }
        });
    }
}