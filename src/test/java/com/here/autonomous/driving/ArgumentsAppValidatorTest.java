package com.here.autonomous.driving;

import com.here.autonomous.driving.utils.validators.ArgumentsAppValidator;
import com.here.autonomous.driving.utils.validators.Exception.ArgumentsAppException;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArgumentsAppValidatorTest {
    private static ArgumentsAppValidator argumentsAppValidator;
    private static List<String> listDrivingModes;

    @BeforeClass
    public static void setUp() {
        argumentsAppValidator = new ArgumentsAppValidator();
        listDrivingModes = new ArrayList<>();
        listDrivingModes.add("normal");
        listDrivingModes.add("sport");
        listDrivingModes.add("integration/safe");
    }

    private String generateRandomUpperLowerCase() {
        int random = new Random().nextInt(2);
        String drivingMode = listDrivingModes.get(random);
        StringBuilder buf = new StringBuilder(drivingMode.length());
        for (int i = 0; i < drivingMode.length(); i++) {
            boolean lowerCase = new Random().nextBoolean();
            char c = drivingMode.charAt(i);
            if (lowerCase) {
                buf.append(Character.toLowerCase(c));
            } else {
                buf.append(Character.toUpperCase(c));
            }
        }
        return buf.toString();
    }

    @Test
    public void argumentsAppValidator_validArguments() throws ArgumentsAppException {
        List<String> args = new ArrayList<>();
        args.add("run");
        args.add("com.here.autonomous.driving.MainVerticle");
        args.add(generateRandomUpperLowerCase());
        argumentsAppValidator.validate(args);
    }

    @Test(expected = ArgumentsAppException.class)
    public void argumentsAppValidator_inValidArguments_noRunArgument() throws ArgumentsAppException {
        List<String> args = new ArrayList<>();
        args.add("com.here.autonomous.driving.MainVerticle");
        args.add(generateRandomUpperLowerCase());
        argumentsAppValidator.validate(args);
    }

    @Test(expected = ArgumentsAppException.class)
    public void argumentsAppValidator_inValidArguments_noMainVerticleArgument() throws ArgumentsAppException {
        List<String> args = new ArrayList<>();
        args.add("run");
        args.add(generateRandomUpperLowerCase());
        argumentsAppValidator.validate(args);
    }

    @Test(expected = ArgumentsAppException.class)
    public void argumentsAppValidator_inValidArguments_noDrivingModeArgument() throws ArgumentsAppException {
        List<String> args = new ArrayList<>();
        args.add("run");
        args.add("com.here.autonomous.driving.MainVerticle");
        argumentsAppValidator.validate(args);
    }

    @Test(expected = ArgumentsAppException.class)
    public void argumentsAppValidator_inValidArguments_noRunArgument_noMainVerticleArgument() throws ArgumentsAppException {
        List<String> args = new ArrayList<>();
        args.add(generateRandomUpperLowerCase());
        argumentsAppValidator.validate(args);
    }

    @Test(expected = ArgumentsAppException.class)
    public void argumentsAppValidator_inValidArguments_noRunArgument_noDrivingModeArgument() throws ArgumentsAppException {
        List<String> args = new ArrayList<>();
        args.add("com.here.autonomous.driving.MainVerticle");
        argumentsAppValidator.validate(args);
    }

    @Test(expected = ArgumentsAppException.class)
    public void argumentsAppValidator_inValidArguments_noMainVerticleArgument_noDrivingModeArgument() throws ArgumentsAppException {
        List<String> args = new ArrayList<>();
        args.add("run");
        args.add(generateRandomUpperLowerCase());
        argumentsAppValidator.validate(args);
    }

    @Test(expected = ArgumentsAppException.class)
    public void argumentsAppValidator_inValidArguments_invalidDrivingModeArgument() throws ArgumentsAppException {
        List<String> args = new ArrayList<>();
        args.add("run");
        args.add("com.here.autonomous.driving.MainVerticle");
        args.add(RandomStringUtils.randomAlphabetic(new Random().nextInt(100) + 1));
        argumentsAppValidator.validate(args);
    }

}
