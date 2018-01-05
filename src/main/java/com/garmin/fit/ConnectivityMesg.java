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
import java.math.BigInteger;


public class ConnectivityMesg extends Mesg {

   
   public static final int BluetoothEnabledFieldNum = 0;
   
   public static final int BluetoothLeEnabledFieldNum = 1;
   
   public static final int AntEnabledFieldNum = 2;
   
   public static final int NameFieldNum = 3;
   
   public static final int LiveTrackingEnabledFieldNum = 4;
   
   public static final int WeatherConditionsEnabledFieldNum = 5;
   
   public static final int WeatherAlertsEnabledFieldNum = 6;
   
   public static final int AutoActivityUploadEnabledFieldNum = 7;
   
   public static final int CourseDownloadEnabledFieldNum = 8;
   
   public static final int WorkoutDownloadEnabledFieldNum = 9;
   
   public static final int GpsEphemerisDownloadEnabledFieldNum = 10;
   
   public static final int IncidentDetectionEnabledFieldNum = 11;
   
   public static final int GrouptrackEnabledFieldNum = 12;
   

   protected static final  Mesg connectivityMesg;
   static {
      // connectivity
      connectivityMesg = new Mesg("connectivity", MesgNum.CONNECTIVITY);
      connectivityMesg.addField(new Field("bluetooth_enabled", BluetoothEnabledFieldNum, 0, 1, 0, "", false, Profile.Type.BOOL));
      
      connectivityMesg.addField(new Field("bluetooth_le_enabled", BluetoothLeEnabledFieldNum, 0, 1, 0, "", false, Profile.Type.BOOL));
      
      connectivityMesg.addField(new Field("ant_enabled", AntEnabledFieldNum, 0, 1, 0, "", false, Profile.Type.BOOL));
      
      connectivityMesg.addField(new Field("name", NameFieldNum, 7, 1, 0, "", false, Profile.Type.STRING));
      
      connectivityMesg.addField(new Field("live_tracking_enabled", LiveTrackingEnabledFieldNum, 0, 1, 0, "", false, Profile.Type.BOOL));
      
      connectivityMesg.addField(new Field("weather_conditions_enabled", WeatherConditionsEnabledFieldNum, 0, 1, 0, "", false, Profile.Type.BOOL));
      
      connectivityMesg.addField(new Field("weather_alerts_enabled", WeatherAlertsEnabledFieldNum, 0, 1, 0, "", false, Profile.Type.BOOL));
      
      connectivityMesg.addField(new Field("auto_activity_upload_enabled", AutoActivityUploadEnabledFieldNum, 0, 1, 0, "", false, Profile.Type.BOOL));
      
      connectivityMesg.addField(new Field("course_download_enabled", CourseDownloadEnabledFieldNum, 0, 1, 0, "", false, Profile.Type.BOOL));
      
      connectivityMesg.addField(new Field("workout_download_enabled", WorkoutDownloadEnabledFieldNum, 0, 1, 0, "", false, Profile.Type.BOOL));
      
      connectivityMesg.addField(new Field("gps_ephemeris_download_enabled", GpsEphemerisDownloadEnabledFieldNum, 0, 1, 0, "", false, Profile.Type.BOOL));
      
      connectivityMesg.addField(new Field("incident_detection_enabled", IncidentDetectionEnabledFieldNum, 0, 1, 0, "", false, Profile.Type.BOOL));
      
      connectivityMesg.addField(new Field("grouptrack_enabled", GrouptrackEnabledFieldNum, 0, 1, 0, "", false, Profile.Type.BOOL));
      
   }

   public ConnectivityMesg() {
      super(Factory.createMesg(MesgNum.CONNECTIVITY));
   }

   public ConnectivityMesg(final Mesg mesg) {
      super(mesg);
   }


   /**
    * Get bluetooth_enabled field
    * Comment: Use Bluetooth for connectivity features
    *
    * @return bluetooth_enabled
    */
   public Bool getBluetoothEnabled() {
      Short value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      if (value == null)
         return null;
      return Bool.getByValue(value);
   }

   /**
    * Set bluetooth_enabled field
    * Comment: Use Bluetooth for connectivity features
    *
    * @param bluetoothEnabled
    */
   public void setBluetoothEnabled(Bool bluetoothEnabled) {
      setFieldValue(0, 0, bluetoothEnabled.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get bluetooth_le_enabled field
    * Comment: Use Bluetooth Low Energy for connectivity features
    *
    * @return bluetooth_le_enabled
    */
   public Bool getBluetoothLeEnabled() {
      Short value = getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      if (value == null)
         return null;
      return Bool.getByValue(value);
   }

   /**
    * Set bluetooth_le_enabled field
    * Comment: Use Bluetooth Low Energy for connectivity features
    *
    * @param bluetoothLeEnabled
    */
   public void setBluetoothLeEnabled(Bool bluetoothLeEnabled) {
      setFieldValue(1, 0, bluetoothLeEnabled.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get ant_enabled field
    * Comment: Use ANT for connectivity features
    *
    * @return ant_enabled
    */
   public Bool getAntEnabled() {
      Short value = getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      if (value == null)
         return null;
      return Bool.getByValue(value);
   }

   /**
    * Set ant_enabled field
    * Comment: Use ANT for connectivity features
    *
    * @param antEnabled
    */
   public void setAntEnabled(Bool antEnabled) {
      setFieldValue(2, 0, antEnabled.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get name field
    *
    * @return name
    */
   public String getName() {
      return getFieldStringValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set name field
    *
    * @param name
    */
   public void setName(String name) {
      setFieldValue(3, 0, name, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get live_tracking_enabled field
    *
    * @return live_tracking_enabled
    */
   public Bool getLiveTrackingEnabled() {
      Short value = getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      if (value == null)
         return null;
      return Bool.getByValue(value);
   }

   /**
    * Set live_tracking_enabled field
    *
    * @param liveTrackingEnabled
    */
   public void setLiveTrackingEnabled(Bool liveTrackingEnabled) {
      setFieldValue(4, 0, liveTrackingEnabled.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get weather_conditions_enabled field
    *
    * @return weather_conditions_enabled
    */
   public Bool getWeatherConditionsEnabled() {
      Short value = getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      if (value == null)
         return null;
      return Bool.getByValue(value);
   }

   /**
    * Set weather_conditions_enabled field
    *
    * @param weatherConditionsEnabled
    */
   public void setWeatherConditionsEnabled(Bool weatherConditionsEnabled) {
      setFieldValue(5, 0, weatherConditionsEnabled.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get weather_alerts_enabled field
    *
    * @return weather_alerts_enabled
    */
   public Bool getWeatherAlertsEnabled() {
      Short value = getFieldShortValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      if (value == null)
         return null;
      return Bool.getByValue(value);
   }

   /**
    * Set weather_alerts_enabled field
    *
    * @param weatherAlertsEnabled
    */
   public void setWeatherAlertsEnabled(Bool weatherAlertsEnabled) {
      setFieldValue(6, 0, weatherAlertsEnabled.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get auto_activity_upload_enabled field
    *
    * @return auto_activity_upload_enabled
    */
   public Bool getAutoActivityUploadEnabled() {
      Short value = getFieldShortValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      if (value == null)
         return null;
      return Bool.getByValue(value);
   }

   /**
    * Set auto_activity_upload_enabled field
    *
    * @param autoActivityUploadEnabled
    */
   public void setAutoActivityUploadEnabled(Bool autoActivityUploadEnabled) {
      setFieldValue(7, 0, autoActivityUploadEnabled.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get course_download_enabled field
    *
    * @return course_download_enabled
    */
   public Bool getCourseDownloadEnabled() {
      Short value = getFieldShortValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      if (value == null)
         return null;
      return Bool.getByValue(value);
   }

   /**
    * Set course_download_enabled field
    *
    * @param courseDownloadEnabled
    */
   public void setCourseDownloadEnabled(Bool courseDownloadEnabled) {
      setFieldValue(8, 0, courseDownloadEnabled.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get workout_download_enabled field
    *
    * @return workout_download_enabled
    */
   public Bool getWorkoutDownloadEnabled() {
      Short value = getFieldShortValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      if (value == null)
         return null;
      return Bool.getByValue(value);
   }

   /**
    * Set workout_download_enabled field
    *
    * @param workoutDownloadEnabled
    */
   public void setWorkoutDownloadEnabled(Bool workoutDownloadEnabled) {
      setFieldValue(9, 0, workoutDownloadEnabled.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get gps_ephemeris_download_enabled field
    *
    * @return gps_ephemeris_download_enabled
    */
   public Bool getGpsEphemerisDownloadEnabled() {
      Short value = getFieldShortValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      if (value == null)
         return null;
      return Bool.getByValue(value);
   }

   /**
    * Set gps_ephemeris_download_enabled field
    *
    * @param gpsEphemerisDownloadEnabled
    */
   public void setGpsEphemerisDownloadEnabled(Bool gpsEphemerisDownloadEnabled) {
      setFieldValue(10, 0, gpsEphemerisDownloadEnabled.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get incident_detection_enabled field
    *
    * @return incident_detection_enabled
    */
   public Bool getIncidentDetectionEnabled() {
      Short value = getFieldShortValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      if (value == null)
         return null;
      return Bool.getByValue(value);
   }

   /**
    * Set incident_detection_enabled field
    *
    * @param incidentDetectionEnabled
    */
   public void setIncidentDetectionEnabled(Bool incidentDetectionEnabled) {
      setFieldValue(11, 0, incidentDetectionEnabled.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get grouptrack_enabled field
    *
    * @return grouptrack_enabled
    */
   public Bool getGrouptrackEnabled() {
      Short value = getFieldShortValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      if (value == null)
         return null;
      return Bool.getByValue(value);
   }

   /**
    * Set grouptrack_enabled field
    *
    * @param grouptrackEnabled
    */
   public void setGrouptrackEnabled(Bool grouptrackEnabled) {
      setFieldValue(12, 0, grouptrackEnabled.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

}
