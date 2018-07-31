package com.here.autonomous.driving;

import com.here.autonomous.driving.utils.ScannerUtils;
import com.here.autonomous.driving.utils.validators.Exception.ExitException;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class ScannerUtilsTest {
    private static ScannerUtils scannerUtils = new ScannerUtils();

    @Test
    public void scannerUtils_validInput() throws ExitException{
        String input = (new Random().nextInt(99) + 1) + "";
        Assert.assertEquals((long) Integer.parseInt(input), (long) scannerUtils.getInputReader(input));
    }

    @Test
    public void scannerUtils_inValidInput_inputLessThan1() throws ExitException{
        String input = (new Random().nextInt(99)) * -1 + "";
        Assert.assertEquals(null, scannerUtils.getInputReader(input));
    }

    @Test
    public void scannerUtils_inValidInput_inputNoNumber() throws ExitException{
        String input = RandomStringUtils.randomAlphabetic(new Random().nextInt(100)+1);
        Assert.assertEquals(null, scannerUtils.getInputReader(input));
    }
}
