package integration.normal;

import com.here.autonomous.driving.controller.VehicleController;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import integration.TestUtils;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import org.junit.Assert;

import java.util.List;


public class NormalDrivingModeSteps {
    private Vertx vertx;
    private EventBus eventBus;
    private VehicleController vehicleController;

    @Before
    public void setUp() {
        vertx = Vertx.vertx();
        eventBus = vertx.eventBus();
    }

    @Given("A vehicle with (.*) driving mode")
    public void vehicleWithNormalDrivingMode(String drivingMode) {
        vehicleController = new VehicleController(drivingMode);
        vertx.deployVerticle(vehicleController);
    }

    @When("I have the following sensor events: (.*)")
    public void gotEvents(List<Integer> events) {
        TestUtils.sensorMockup(eventBus, events);
    }

    @Then("The vehicle speed is (\\d+)")
    public void currentSpeedIsCorrect(int currentSpeed) {
        int newSpeed = TestUtils.getCurrentVehicleSpeed(vehicleController);
        Assert.assertEquals(currentSpeed, newSpeed);
    }
}
