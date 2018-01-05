////////////////////////////////////////////////////////////////////////////////
// The following FIT Protocol software provided may be used with FIT protocol
// devices only and remains the copyrighted property of Dynastream Innovations Inc.
// The software is being provided on an "as-is" basis and as an accommodation,
// and therefore all warranties, representations, or guarantees of any kind
// (whether express, implied or statutory) including, without limitation,
// warranties of merchantability, non-infringement, or fitness for a particular
// purpose, are specifically disclaimed.
//
// Copyright 2017 Dynastream Innovations Inc.
////////////////////////////////////////////////////////////////////////////////
// ****WARNING****  This file is auto-generated!  Do NOT edit this file.
// Profile Version = 20.51Release
// Tag = production/akw/20.51.00-0-g012aa19
////////////////////////////////////////////////////////////////////////////////


package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

public class ShoulderPressExerciseName {
    public static final int ALTERNATING_DUMBBELL_SHOULDER_PRESS = 0;
    public static final int ARNOLD_PRESS = 1;
    public static final int BARBELL_FRONT_SQUAT_TO_PUSH_PRESS = 2;
    public static final int BARBELL_PUSH_PRESS = 3;
    public static final int BARBELL_SHOULDER_PRESS = 4;
    public static final int DEAD_CURL_PRESS = 5;
    public static final int DUMBBELL_ALTERNATING_SHOULDER_PRESS_AND_TWIST = 6;
    public static final int DUMBBELL_HAMMER_CURL_TO_LUNGE_TO_PRESS = 7;
    public static final int DUMBBELL_PUSH_PRESS = 8;
    public static final int FLOOR_INVERTED_SHOULDER_PRESS = 9;
    public static final int WEIGHTED_FLOOR_INVERTED_SHOULDER_PRESS = 10;
    public static final int INVERTED_SHOULDER_PRESS = 11;
    public static final int WEIGHTED_INVERTED_SHOULDER_PRESS = 12;
    public static final int ONE_ARM_PUSH_PRESS = 13;
    public static final int OVERHEAD_BARBELL_PRESS = 14;
    public static final int OVERHEAD_DUMBBELL_PRESS = 15;
    public static final int SEATED_BARBELL_SHOULDER_PRESS = 16;
    public static final int SEATED_DUMBBELL_SHOULDER_PRESS = 17;
    public static final int SINGLE_ARM_DUMBBELL_SHOULDER_PRESS = 18;
    public static final int SINGLE_ARM_STEP_UP_AND_PRESS = 19;
    public static final int SMITH_MACHINE_OVERHEAD_PRESS = 20;
    public static final int SPLIT_STANCE_HAMMER_CURL_TO_PRESS = 21;
    public static final int SWISS_BALL_DUMBBELL_SHOULDER_PRESS = 22;
    public static final int WEIGHT_PLATE_FRONT_RAISE = 23;
    public static final int INVALID = Fit.UINT16_INVALID;

    private static final Map<Integer, String> stringMap;

    static {
        stringMap = new HashMap<Integer, String>();
        stringMap.put(ALTERNATING_DUMBBELL_SHOULDER_PRESS, "ALTERNATING_DUMBBELL_SHOULDER_PRESS");
        stringMap.put(ARNOLD_PRESS, "ARNOLD_PRESS");
        stringMap.put(BARBELL_FRONT_SQUAT_TO_PUSH_PRESS, "BARBELL_FRONT_SQUAT_TO_PUSH_PRESS");
        stringMap.put(BARBELL_PUSH_PRESS, "BARBELL_PUSH_PRESS");
        stringMap.put(BARBELL_SHOULDER_PRESS, "BARBELL_SHOULDER_PRESS");
        stringMap.put(DEAD_CURL_PRESS, "DEAD_CURL_PRESS");
        stringMap.put(DUMBBELL_ALTERNATING_SHOULDER_PRESS_AND_TWIST, "DUMBBELL_ALTERNATING_SHOULDER_PRESS_AND_TWIST");
        stringMap.put(DUMBBELL_HAMMER_CURL_TO_LUNGE_TO_PRESS, "DUMBBELL_HAMMER_CURL_TO_LUNGE_TO_PRESS");
        stringMap.put(DUMBBELL_PUSH_PRESS, "DUMBBELL_PUSH_PRESS");
        stringMap.put(FLOOR_INVERTED_SHOULDER_PRESS, "FLOOR_INVERTED_SHOULDER_PRESS");
        stringMap.put(WEIGHTED_FLOOR_INVERTED_SHOULDER_PRESS, "WEIGHTED_FLOOR_INVERTED_SHOULDER_PRESS");
        stringMap.put(INVERTED_SHOULDER_PRESS, "INVERTED_SHOULDER_PRESS");
        stringMap.put(WEIGHTED_INVERTED_SHOULDER_PRESS, "WEIGHTED_INVERTED_SHOULDER_PRESS");
        stringMap.put(ONE_ARM_PUSH_PRESS, "ONE_ARM_PUSH_PRESS");
        stringMap.put(OVERHEAD_BARBELL_PRESS, "OVERHEAD_BARBELL_PRESS");
        stringMap.put(OVERHEAD_DUMBBELL_PRESS, "OVERHEAD_DUMBBELL_PRESS");
        stringMap.put(SEATED_BARBELL_SHOULDER_PRESS, "SEATED_BARBELL_SHOULDER_PRESS");
        stringMap.put(SEATED_DUMBBELL_SHOULDER_PRESS, "SEATED_DUMBBELL_SHOULDER_PRESS");
        stringMap.put(SINGLE_ARM_DUMBBELL_SHOULDER_PRESS, "SINGLE_ARM_DUMBBELL_SHOULDER_PRESS");
        stringMap.put(SINGLE_ARM_STEP_UP_AND_PRESS, "SINGLE_ARM_STEP_UP_AND_PRESS");
        stringMap.put(SMITH_MACHINE_OVERHEAD_PRESS, "SMITH_MACHINE_OVERHEAD_PRESS");
        stringMap.put(SPLIT_STANCE_HAMMER_CURL_TO_PRESS, "SPLIT_STANCE_HAMMER_CURL_TO_PRESS");
        stringMap.put(SWISS_BALL_DUMBBELL_SHOULDER_PRESS, "SWISS_BALL_DUMBBELL_SHOULDER_PRESS");
        stringMap.put(WEIGHT_PLATE_FRONT_RAISE, "WEIGHT_PLATE_FRONT_RAISE");
    }


    /**
     * Retrieves the String Representation of the Value
     * @return The string representation of the value, or empty if unknown
     */
    public static String getStringFromValue( Integer value ) {
        if( stringMap.containsKey( value ) ) {
            return stringMap.get( value );
        }

        return "";
    }

    /**
     * Retrieves a value given a string representation
     * @return The value or INVALID if unkwown
     */
    public static Integer getValueFromString( String value ) {
        for( Map.Entry<Integer, String> entry : stringMap.entrySet() ) {
            if( entry.getValue().equals( value ) ) {
                return entry.getKey();
            }
        }

        return INVALID;
    }

}
