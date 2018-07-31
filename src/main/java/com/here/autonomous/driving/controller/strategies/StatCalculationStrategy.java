package com.here.autonomous.driving.controller.strategies;

public interface StatCalculationStrategy<T1, T2> {

    int calculateStat(T1 t1, T2 t2) throws Exception;
}
