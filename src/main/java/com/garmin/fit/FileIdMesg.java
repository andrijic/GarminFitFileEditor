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


public class FileIdMesg extends Mesg {

   
   public static final int TypeFieldNum = 0;
   
   public static final int ManufacturerFieldNum = 1;
   
   public static final int ProductFieldNum = 2;
   
   public static final int SerialNumberFieldNum = 3;
   
   public static final int TimeCreatedFieldNum = 4;
   
   public static final int NumberFieldNum = 5;
   
   public static final int ProductNameFieldNum = 8;
   

   protected static final  Mesg fileIdMesg;
   static {
      int field_index = 0;
      int subfield_index = 0;
      // file_id
      fileIdMesg = new Mesg("file_id", MesgNum.FILE_ID);
      fileIdMesg.addField(new Field("type", TypeFieldNum, 0, 1, 0, "", false, Profile.Type.FILE));
      field_index++;
      fileIdMesg.addField(new Field("manufacturer", ManufacturerFieldNum, 132, 1, 0, "", false, Profile.Type.MANUFACTURER));
      field_index++;
      fileIdMesg.addField(new Field("product", ProductFieldNum, 132, 1, 0, "", false, Profile.Type.UINT16));
      subfield_index = 0;
      fileIdMesg.fields.get(field_index).subFields.add(new SubField("garmin_product", 132, 1, 0, ""));
      fileIdMesg.fields.get(field_index).subFields.get(subfield_index).addMap(1, 1);
      fileIdMesg.fields.get(field_index).subFields.get(subfield_index).addMap(1, 15);
      fileIdMesg.fields.get(field_index).subFields.get(subfield_index).addMap(1, 13);
      subfield_index++;
      field_index++;
      fileIdMesg.addField(new Field("serial_number", SerialNumberFieldNum, 140, 1, 0, "", false, Profile.Type.UINT32Z));
      field_index++;
      fileIdMesg.addField(new Field("time_created", TimeCreatedFieldNum, 134, 1, 0, "", false, Profile.Type.DATE_TIME));
      field_index++;
      fileIdMesg.addField(new Field("number", NumberFieldNum, 132, 1, 0, "", false, Profile.Type.UINT16));
      field_index++;
      fileIdMesg.addField(new Field("product_name", ProductNameFieldNum, 7, 1, 0, "", false, Profile.Type.STRING));
      field_index++;
   }

   public FileIdMesg() {
      super(Factory.createMesg(MesgNum.FILE_ID));
   }

   public FileIdMesg(final Mesg mesg) {
      super(mesg);
   }


   /**
    * Get type field
    *
    * @return type
    */
   public File getType() {
      Short value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      if (value == null)
         return null;
      return File.getByValue(value);
   }

   /**
    * Set type field
    *
    * @param type
    */
   public void setType(File type) {
      setFieldValue(0, 0, type.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get manufacturer field
    *
    * @return manufacturer
    */
   public Integer getManufacturer() {
      return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set manufacturer field
    *
    * @param manufacturer
    */
   public void setManufacturer(Integer manufacturer) {
      setFieldValue(1, 0, manufacturer, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get product field
    *
    * @return product
    */
   public Integer getProduct() {
      return getFieldIntegerValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set product field
    *
    * @param product
    */
   public void setProduct(Integer product) {
      setFieldValue(2, 0, product, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get garmin_product field
    *
    * @return garmin_product
    */
   public Integer getGarminProduct() {
      return getFieldIntegerValue(2, 0, Profile.SubFields.FILE_ID_MESG_PRODUCT_FIELD_GARMIN_PRODUCT);
   }

   /**
    * Set garmin_product field
    *
    * @param garminProduct
    */
   public void setGarminProduct(Integer garminProduct) {
      setFieldValue(2, 0, garminProduct, Profile.SubFields.FILE_ID_MESG_PRODUCT_FIELD_GARMIN_PRODUCT);
   }

   /**
    * Get serial_number field
    *
    * @return serial_number
    */
   public Long getSerialNumber() {
      return getFieldLongValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set serial_number field
    *
    * @param serialNumber
    */
   public void setSerialNumber(Long serialNumber) {
      setFieldValue(3, 0, serialNumber, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get time_created field
    * Comment: Only set for files that are can be created/erased.
    *
    * @return time_created
    */
   public DateTime getTimeCreated() {
      return timestampToDateTime(getFieldLongValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD));
   }

   /**
    * Set time_created field
    * Comment: Only set for files that are can be created/erased.
    *
    * @param timeCreated
    */
   public void setTimeCreated(DateTime timeCreated) {
      setFieldValue(4, 0, timeCreated.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get number field
    * Comment: Only set for files that are not created/erased.
    *
    * @return number
    */
   public Integer getNumber() {
      return getFieldIntegerValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set number field
    * Comment: Only set for files that are not created/erased.
    *
    * @param number
    */
   public void setNumber(Integer number) {
      setFieldValue(5, 0, number, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get product_name field
    * Comment: Optional free form string to indicate the devices name or model
    *
    * @return product_name
    */
   public String getProductName() {
      return getFieldStringValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set product_name field
    * Comment: Optional free form string to indicate the devices name or model
    *
    * @param productName
    */
   public void setProductName(String productName) {
      setFieldValue(8, 0, productName, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

}
