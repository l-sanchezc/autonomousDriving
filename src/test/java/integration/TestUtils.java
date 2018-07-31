package integration;

import com.here.autonomous.driving.controller.VehicleController;
import com.here.autonomous.driving.model.BusAddresses;
import com.here.autonomous.driving.model.SensorMessage;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.Json;

import java.util.List;

public class TestUtils {

    public static void sensorMockup(EventBus eventBus, List<Integer> events) {
        for (int event : events) {
            try {
                Thread.sleep(200L);
                SensorMessage sensorMessage = new SensorMessage(event);
                eventBus.send(BusAddresses.SPEED_BUS_ADDRESS.SpeedBusAddress(), Json.encodePrettily(sensorMessage));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getCurrentVehicleSpeed(VehicleController vehicleController) {
        int currentSpeed = 0;
        try {
            Thread.sleep(10L);
            currentSpeed = vehicleController.getVehicle().getCurrentSpeed();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return currentSpeed;
    }
}
