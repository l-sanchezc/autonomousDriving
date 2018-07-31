package com.here.autonomous.driving.model;

import java.util.Locale;
import java.util.ResourceBundle;

public class Constants {

    public static int MINIMUM_SPEED = 10;
    public static int SPEED_LIMIT_ID = 10;
    public static int MAX_EVENT_ID = 100;
    public static int EMERGENCY_TURBO_ID = 7;
    public static int SLIPPERY_ROAD_ID = 5;
    public static int INITIAL_SPEED = 20;
    public static final ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", Locale.getDefault());

}
