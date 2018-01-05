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


public class AccelerometerDataMesg extends Mesg {

   
   public static final int TimestampFieldNum = 253;
   
   public static final int TimestampMsFieldNum = 0;
   
   public static final int SampleTimeOffsetFieldNum = 1;
   
   public static final int AccelXFieldNum = 2;
   
   public static final int AccelYFieldNum = 3;
   
   public static final int AccelZFieldNum = 4;
   
   public static final int CalibratedAccelXFieldNum = 5;
   
   public static final int CalibratedAccelYFieldNum = 6;
   
   public static final int CalibratedAccelZFieldNum = 7;
   
   public static final int CompressedCalibratedAccelXFieldNum = 8;
   
   public static final int CompressedCalibratedAccelYFieldNum = 9;
   
   public static final int CompressedCalibratedAccelZFieldNum = 10;
   

   protected static final  Mesg accelerometerDataMesg;
   static {
      // accelerometer_data
      accelerometerDataMesg = new Mesg("accelerometer_data", MesgNum.ACCELEROMETER_DATA);
      accelerometerDataMesg.addField(new Field("timestamp", TimestampFieldNum, 134, 1, 0, "s", false, Profile.Type.DATE_TIME));
      
      accelerometerDataMesg.addField(new Field("timestamp_ms", TimestampMsFieldNum, 132, 1, 0, "ms", false, Profile.Type.UINT16));
      
      accelerometerDataMesg.addField(new Field("sample_time_offset", SampleTimeOffsetFieldNum, 132, 1, 0, "ms", false, Profile.Type.UINT16));
      
      accelerometerDataMesg.addField(new Field("accel_x", AccelXFieldNum, 132, 1, 0, "counts", false, Profile.Type.UINT16));
      
      accelerometerDataMesg.addField(new Field("accel_y", AccelYFieldNum, 132, 1, 0, "counts", false, Profile.Type.UINT16));
      
      accelerometerDataMesg.addField(new Field("accel_z", AccelZFieldNum, 132, 1, 0, "counts", false, Profile.Type.UINT16));
      
      accelerometerDataMesg.addField(new Field("calibrated_accel_x", CalibratedAccelXFieldNum, 136, 1, 0, "g", false, Profile.Type.FLOAT32));
      
      accelerometerDataMesg.addField(new Field("calibrated_accel_y", CalibratedAccelYFieldNum, 136, 1, 0, "g", false, Profile.Type.FLOAT32));
      
      accelerometerDataMesg.addField(new Field("calibrated_accel_z", CalibratedAccelZFieldNum, 136, 1, 0, "g", false, Profile.Type.FLOAT32));
      
      accelerometerDataMesg.addField(new Field("compressed_calibrated_accel_x", CompressedCalibratedAccelXFieldNum, 131, 1, 0, "mG", false, Profile.Type.SINT16));
      
      accelerometerDataMesg.addField(new Field("compressed_calibrated_accel_y", CompressedCalibratedAccelYFieldNum, 131, 1, 0, "mG", false, Profile.Type.SINT16));
      
      accelerometerDataMesg.addField(new Field("compressed_calibrated_accel_z", CompressedCalibratedAccelZFieldNum, 131, 1, 0, "mG", false, Profile.Type.SINT16));
      
   }

   public AccelerometerDataMesg() {
      super(Factory.createMesg(MesgNum.ACCELEROMETER_DATA));
   }

   public AccelerometerDataMesg(final Mesg mesg) {
      super(mesg);
   }


   /**
    * Get timestamp field
    * Units: s
    * Comment: Whole second part of the timestamp
    *
    * @return timestamp
    */
   public DateTime getTimestamp() {
      return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD));
   }

   /**
    * Set timestamp field
    * Units: s
    * Comment: Whole second part of the timestamp
    *
    * @param timestamp
    */
   public void setTimestamp(DateTime timestamp) {
      setFieldValue(253, 0, timestamp.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get timestamp_ms field
    * Units: ms
    * Comment: Millisecond part of the timestamp.
    *
    * @return timestamp_ms
    */
   public Integer getTimestampMs() {
      return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set timestamp_ms field
    * Units: ms
    * Comment: Millisecond part of the timestamp.
    *
    * @param timestampMs
    */
   public void setTimestampMs(Integer timestampMs) {
      setFieldValue(0, 0, timestampMs, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   public Integer[] getSampleTimeOffset() {
      
      return getFieldIntegerValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      
   }

   /**
    * @return number of sample_time_offset
    */
   public int getNumSampleTimeOffset() {
      return getNumFieldValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get sample_time_offset field
    * Units: ms
    * Comment: Each time in the array describes the time at which the accelerometer sample with the corrosponding index was taken. Limited to 30 samples in each message. The samples may span across seconds. Array size must match the number of samples in accel_x and accel_y and accel_z
    *
    * @param index of sample_time_offset
    * @return sample_time_offset
    */
   public Integer getSampleTimeOffset(int index) {
      return getFieldIntegerValue(1, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set sample_time_offset field
    * Units: ms
    * Comment: Each time in the array describes the time at which the accelerometer sample with the corrosponding index was taken. Limited to 30 samples in each message. The samples may span across seconds. Array size must match the number of samples in accel_x and accel_y and accel_z
    *
    * @param index of sample_time_offset
    * @param sampleTimeOffset
    */
   public void setSampleTimeOffset(int index, Integer sampleTimeOffset) {
      setFieldValue(1, index, sampleTimeOffset, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   public Integer[] getAccelX() {
      
      return getFieldIntegerValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      
   }

   /**
    * @return number of accel_x
    */
   public int getNumAccelX() {
      return getNumFieldValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get accel_x field
    * Units: counts
    * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
    *
    * @param index of accel_x
    * @return accel_x
    */
   public Integer getAccelX(int index) {
      return getFieldIntegerValue(2, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set accel_x field
    * Units: counts
    * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
    *
    * @param index of accel_x
    * @param accelX
    */
   public void setAccelX(int index, Integer accelX) {
      setFieldValue(2, index, accelX, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   public Integer[] getAccelY() {
      
      return getFieldIntegerValues(3, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      
   }

   /**
    * @return number of accel_y
    */
   public int getNumAccelY() {
      return getNumFieldValues(3, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get accel_y field
    * Units: counts
    * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
    *
    * @param index of accel_y
    * @return accel_y
    */
   public Integer getAccelY(int index) {
      return getFieldIntegerValue(3, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set accel_y field
    * Units: counts
    * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
    *
    * @param index of accel_y
    * @param accelY
    */
   public void setAccelY(int index, Integer accelY) {
      setFieldValue(3, index, accelY, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   public Integer[] getAccelZ() {
      
      return getFieldIntegerValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      
   }

   /**
    * @return number of accel_z
    */
   public int getNumAccelZ() {
      return getNumFieldValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get accel_z field
    * Units: counts
    * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
    *
    * @param index of accel_z
    * @return accel_z
    */
   public Integer getAccelZ(int index) {
      return getFieldIntegerValue(4, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set accel_z field
    * Units: counts
    * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
    *
    * @param index of accel_z
    * @param accelZ
    */
   public void setAccelZ(int index, Integer accelZ) {
      setFieldValue(4, index, accelZ, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   public Float[] getCalibratedAccelX() {
      
      return getFieldFloatValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      
   }

   /**
    * @return number of calibrated_accel_x
    */
   public int getNumCalibratedAccelX() {
      return getNumFieldValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get calibrated_accel_x field
    * Units: g
    * Comment: Calibrated accel reading
    *
    * @param index of calibrated_accel_x
    * @return calibrated_accel_x
    */
   public Float getCalibratedAccelX(int index) {
      return getFieldFloatValue(5, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set calibrated_accel_x field
    * Units: g
    * Comment: Calibrated accel reading
    *
    * @param index of calibrated_accel_x
    * @param calibratedAccelX
    */
   public void setCalibratedAccelX(int index, Float calibratedAccelX) {
      setFieldValue(5, index, calibratedAccelX, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   public Float[] getCalibratedAccelY() {
      
      return getFieldFloatValues(6, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      
   }

   /**
    * @return number of calibrated_accel_y
    */
   public int getNumCalibratedAccelY() {
      return getNumFieldValues(6, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get calibrated_accel_y field
    * Units: g
    * Comment: Calibrated accel reading
    *
    * @param index of calibrated_accel_y
    * @return calibrated_accel_y
    */
   public Float getCalibratedAccelY(int index) {
      return getFieldFloatValue(6, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set calibrated_accel_y field
    * Units: g
    * Comment: Calibrated accel reading
    *
    * @param index of calibrated_accel_y
    * @param calibratedAccelY
    */
   public void setCalibratedAccelY(int index, Float calibratedAccelY) {
      setFieldValue(6, index, calibratedAccelY, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   public Float[] getCalibratedAccelZ() {
      
      return getFieldFloatValues(7, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      
   }

   /**
    * @return number of calibrated_accel_z
    */
   public int getNumCalibratedAccelZ() {
      return getNumFieldValues(7, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get calibrated_accel_z field
    * Units: g
    * Comment: Calibrated accel reading
    *
    * @param index of calibrated_accel_z
    * @return calibrated_accel_z
    */
   public Float getCalibratedAccelZ(int index) {
      return getFieldFloatValue(7, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set calibrated_accel_z field
    * Units: g
    * Comment: Calibrated accel reading
    *
    * @param index of calibrated_accel_z
    * @param calibratedAccelZ
    */
   public void setCalibratedAccelZ(int index, Float calibratedAccelZ) {
      setFieldValue(7, index, calibratedAccelZ, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   public Short[] getCompressedCalibratedAccelX() {
      
      return getFieldShortValues(8, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      
   }

   /**
    * @return number of compressed_calibrated_accel_x
    */
   public int getNumCompressedCalibratedAccelX() {
      return getNumFieldValues(8, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get compressed_calibrated_accel_x field
    * Units: mG
    * Comment: Calibrated accel reading
    *
    * @param index of compressed_calibrated_accel_x
    * @return compressed_calibrated_accel_x
    */
   public Short getCompressedCalibratedAccelX(int index) {
      return getFieldShortValue(8, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set compressed_calibrated_accel_x field
    * Units: mG
    * Comment: Calibrated accel reading
    *
    * @param index of compressed_calibrated_accel_x
    * @param compressedCalibratedAccelX
    */
   public void setCompressedCalibratedAccelX(int index, Short compressedCalibratedAccelX) {
      setFieldValue(8, index, compressedCalibratedAccelX, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   public Short[] getCompressedCalibratedAccelY() {
      
      return getFieldShortValues(9, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      
   }

   /**
    * @return number of compressed_calibrated_accel_y
    */
   public int getNumCompressedCalibratedAccelY() {
      return getNumFieldValues(9, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get compressed_calibrated_accel_y field
    * Units: mG
    * Comment: Calibrated accel reading
    *
    * @param index of compressed_calibrated_accel_y
    * @return compressed_calibrated_accel_y
    */
   public Short getCompressedCalibratedAccelY(int index) {
      return getFieldShortValue(9, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set compressed_calibrated_accel_y field
    * Units: mG
    * Comment: Calibrated accel reading
    *
    * @param index of compressed_calibrated_accel_y
    * @param compressedCalibratedAccelY
    */
   public void setCompressedCalibratedAccelY(int index, Short compressedCalibratedAccelY) {
      setFieldValue(9, index, compressedCalibratedAccelY, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   public Short[] getCompressedCalibratedAccelZ() {
      
      return getFieldShortValues(10, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      
   }

   /**
    * @return number of compressed_calibrated_accel_z
    */
   public int getNumCompressedCalibratedAccelZ() {
      return getNumFieldValues(10, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get compressed_calibrated_accel_z field
    * Units: mG
    * Comment: Calibrated accel reading
    *
    * @param index of compressed_calibrated_accel_z
    * @return compressed_calibrated_accel_z
    */
   public Short getCompressedCalibratedAccelZ(int index) {
      return getFieldShortValue(10, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set compressed_calibrated_accel_z field
    * Units: mG
    * Comment: Calibrated accel reading
    *
    * @param index of compressed_calibrated_accel_z
    * @param compressedCalibratedAccelZ
    */
   public void setCompressedCalibratedAccelZ(int index, Short compressedCalibratedAccelZ) {
      setFieldValue(10, index, compressedCalibratedAccelZ, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

}
