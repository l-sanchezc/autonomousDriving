package com.here.autonomous.driving.utils.validators;

import com.here.autonomous.driving.model.DrivingMode;
import com.here.autonomous.driving.utils.validators.Exception.ArgumentsAppException;

import java.util.List;

import static com.here.autonomous.driving.model.Constants.messages;

public class ArgumentsAppValidator implements Validator<List<String>, Object> {

    @Override
    public void validate(List<String> args) throws ArgumentsAppException {
        if (args.size() != 3)
            throw new ArgumentsAppException(messages.getString("not_valid_arguments"));
        else {
            DrivingMode drivingMode = DrivingMode.validate(args.get(2).toUpperCase());
            if (drivingMode == DrivingMode.NOT_VALID)
                throw new ArgumentsAppException(messages.getString("not_valid_arguments"));
        }
    }

    @Override
    public void validate(List<String> o, Object o2) throws Exception {

    }

}
