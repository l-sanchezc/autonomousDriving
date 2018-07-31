package com.here.autonomous.driving.utils.validators;

public interface Validator<T1, T2> {

    void validate(T1 t1) throws Exception;

    void validate(T1 t1, T2 t2) throws Exception;

}
