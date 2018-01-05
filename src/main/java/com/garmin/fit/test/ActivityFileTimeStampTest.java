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


package com.garmin.fit.test;

import com.garmin.fit.*;
import java.util.ArrayList;

public class ActivityFileTimeStampTest implements Test, MesgListener {
   private int fileType = 0;
   private String szError = null;
   private ArrayList<Session> SessionList; // array of session objects
   private float activity_total_timer_time = -1;

   public ActivityFileTimeStampTest() {
      SessionList = new ArrayList<Session>();
   }

   // each session has an instance of object MesgIndexList to keep track of it's laps and records
   private class Session {
      private Integer timestamp; // session timestamp
      private Integer start_time; // session start time
      private float total_elapsed_time; // session total elapsed time
      private float total_timer_time; // session total timer time

      private ArrayList<Integer> Laps; // array of Lap timestamps
      private ArrayList<Integer> Lap_start_time; // array of lap start times
      private ArrayList<Float> Lap_total_elapsed_time; // array of lap elapsed times
      private ArrayList<Float> Lap_total_timer_time; // array of lap total times

      private ArrayList<Integer> Records; // array of Records timestamps

      Session(Integer timestamp) {
         Laps = new ArrayList<Integer>();
         Lap_start_time = new ArrayList<Integer>();
         Lap_total_elapsed_time = new ArrayList<Float>();
         Lap_total_timer_time = new ArrayList<Float>();
         Records = new ArrayList<Integer>();

         this.timestamp = timestamp;
         start_time = 0;
         total_elapsed_time = 0;
         total_timer_time = 0;
      }

      public void setStartTime(int value) {
         start_time = value;
      }

      public void setTotalElapsedTime(Float value) {
         total_elapsed_time = value;
      }

      public void setTotalTimerTime(Float value) {
         total_timer_time = value;
      }

      public void addLap(int value) {
         Laps.add(value);
      }

      public void addStartTime(int value) {
         Lap_start_time.add(value);
      }

      public void addLapTotalElapsedTime(Float value) {
         Lap_total_elapsed_time.add(value);
      }

      public void addLapTotalTimerTime(Float value) {
         Lap_total_timer_time.add(value);
      }

      public void addRecord(int value) {
         Records.add(value);
      }

      public float getTotalTimerTime() {
         return total_timer_time;
      }

      public String verifyTimeStamps() {
         int i;

         if (Laps.size() > 0) {
            Object stList[] = Laps.toArray();
            for (i = 0; i < Laps.size(); i++) {
               if (((Integer) stList[i]) > timestamp)
                  return "Timestamp of lap " + i + ": " + ((Integer) stList[i]) + " is greater than timestamp of session: " + timestamp;
            }
         }

         if (Lap_start_time.size() > 0) {
            Object stList[] = Lap_start_time.toArray();
            for (i = 0; i < Lap_start_time.size(); i++) {
               if (((Integer) stList[i]) < start_time)
                  return "Start time of lap " + i + ": " + ((Integer) stList[i]) + " is less than start time of session: " + start_time;
            }
         }

         if (Records.size() > 0) {
            Object stList[] = Records.toArray();
            for (i = 0; i < Records.size(); i++) {
               if (((Integer) stList[i]) > timestamp)
                  return "Timestamp of record " + i + ": " + ((Integer) stList[i]) + " is greater than timestamp of session: " + timestamp;
            }
         }
         return null;
      }

      public String verifyTotalTimes() {
         int i;

         if ((Lap_total_elapsed_time.size() > 0) && (total_elapsed_time != 0)) {
            float sum_total_elapsed_time = 0;
            Object stList[] = Lap_total_elapsed_time.toArray();

            for (i = 0; i < Lap_total_elapsed_time.size(); i++)
               sum_total_elapsed_time += (Float) stList[i];
            if ((int) sum_total_elapsed_time != (int) total_elapsed_time)
               return "Session's total elapsed time: " + total_elapsed_time + " is not equal to the sum of the lap's total elapsed time: " + sum_total_elapsed_time;
         }

         if ((Lap_total_timer_time.size() > 0) && (total_timer_time != 0)) {
            float sum_total_timer_time = 0;
            Object stList[] = Lap_total_timer_time.toArray();

            for (i = 0; i < Lap_total_timer_time.size(); i++)
               sum_total_timer_time += (Float) stList[i];
            if ((int) sum_total_timer_time != (int) total_timer_time)
               return "Session's total timer time: " + total_timer_time + " is not equal to the sum of the lap's total total time: " + sum_total_timer_time;
         }

         return null;
      }

      public String verifyRecordTimes() {
         int i;

         if (Records.size() > 0) {
            Object stList[] = Records.toArray();
            for (i = 0; i < Records.size(); i++) {
               if (((Integer) stList[i]) < start_time)
                  return "Timestamp of record " + i + ": " + ((Integer) stList[i]) + " is less than start time of session: " + start_time;

               if (((Integer) stList[i]) > (start_time + total_elapsed_time))
                  return "Timestamp of record " + i + ": " + ((Integer) stList[i]) + " is greater than start time of session + session duration: " + (start_time + total_elapsed_time);
            }
         }
         return null;
      }
   }

   public void onMesg(Mesg mesg) {
      Object stList[] = SessionList.toArray();
      Field stTimeField;

      if (szError != null)
         return;

      if (mesg.getName() == "file_id") {
         fileType = Integer.parseInt(mesg.getField("type").getValue().toString());
         return;
      }

      if (fileType != 4) // continue if activity file
         return;

      stTimeField = mesg.getField("timestamp");
      if (stTimeField == null) {
         szError = "\"timestamp\" field does not exist for message: " + mesg.getName();
         return;
      }

      // store fields in session message
      if (mesg.getName() == "session") {
         int index;

         index = Integer.parseInt(mesg.getField("timestamp").getValue().toString());
         Session stNewSession = new Session(index);

         stTimeField = mesg.getField("start_time");
         if (stTimeField != null)
            stNewSession.setStartTime(Integer.parseInt(stTimeField.getValue().toString()));

         stTimeField = mesg.getField("total_elapsed_time");
         if (stTimeField != null)
            stNewSession.setTotalElapsedTime(Float.parseFloat(stTimeField.getValue().toString()));

         stTimeField = mesg.getField("total_timer_time");
         if (stTimeField != null)
            stNewSession.setTotalTimerTime(Float.parseFloat(stTimeField.getValue().toString()));

         SessionList.add(stNewSession);
         return;
      } else if (mesg.getName() == "activity") {
         stTimeField = mesg.getField("total_timer_time");
         if (stTimeField != null)
            activity_total_timer_time = Float.parseFloat(stTimeField.getValue().toString());

         return;
      } else if (SessionList.size() == 0) {
         return;
      }

      // store fields in lap message
      if (mesg.getName() == "lap") {
         stTimeField = mesg.getField("timestamp");
         if (stTimeField != null)
            ((Session) stList[SessionList.size() - 1]).addLap(Integer.parseInt(stTimeField.getValue().toString()));

         stTimeField = mesg.getField("start_time");
         if (stTimeField != null)
            ((Session) stList[SessionList.size() - 1]).addStartTime(Integer.parseInt(stTimeField.getValue().toString()));

         stTimeField = mesg.getField("total_elapsed_time");
         if (stTimeField != null)
            ((Session) stList[SessionList.size() - 1]).addLapTotalElapsedTime(Float.parseFloat(stTimeField.getValue().toString()));

         stTimeField = mesg.getField("total_timer_time");
         if (stTimeField != null)
            ((Session) stList[SessionList.size() - 1]).addLapTotalTimerTime(Float.parseFloat(stTimeField.getValue().toString()));

      }
      // store fields in record message
      else if (mesg.getName() == "record") {
         stTimeField = mesg.getField("timestamp");
         if (stTimeField != null)
            ((Session) stList[SessionList.size() - 1]).addRecord(Integer.parseInt(stTimeField.getValue().toString()));
      }
   }

   public String getError() {
      float activityTime = 0;
      Object stList[] = SessionList.toArray();

      if (szError != null)
         return szError;

      for (int i = 0; i < SessionList.size(); i++) {
         if ((szError = ((Session) stList[i]).verifyTimeStamps()) != null)
            return szError;

         if ((szError = ((Session) stList[i]).verifyTotalTimes()) != null)
            return szError;

         if ((szError = ((Session) stList[i]).verifyRecordTimes()) != null)
            return szError;

         activityTime += ((Session) stList[i]).getTotalTimerTime();
      }

      if (activity_total_timer_time != -1) {
         if ((int) activityTime != (int) activity_total_timer_time)
            return "Activity total timer time: " + activity_total_timer_time + " is not equal to sum of sessions' total timer time: " + activityTime;

      }
      return szError;
   }
}
