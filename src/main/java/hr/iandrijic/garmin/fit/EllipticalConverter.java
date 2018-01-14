/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.iandrijic.garmin.fit;

import com.garmin.fit.Decode;
import com.garmin.fit.DeveloperField;
import com.garmin.fit.Factory;
import com.garmin.fit.Field;
import com.garmin.fit.FieldBase;
import com.garmin.fit.FieldDescriptionMesg;
import com.garmin.fit.FileEncoder;
import com.garmin.fit.Fit;
import com.garmin.fit.FitRuntimeException;
import com.garmin.fit.Mesg;
import com.garmin.fit.MesgBroadcaster;
import com.garmin.fit.MesgListener;
import com.garmin.fit.MesgNum;
import com.garmin.fit.Profile;
import com.garmin.fit.RecordMesg;
import com.garmin.fit.examples.DecodeExample;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iandrijic
 */
public class EllipticalConverter {
     public static void main(String[] args) {
         EllipticalConverter converter = new EllipticalConverter();
         converter.recode();
    }
     
     public void recode(){
         
          /**ENCODER**/
        FileEncoder encode;
                
        try {
            encode = new FileEncoder( new java.io.File( "ExampleActivity.fit" ), Fit.ProtocolVersion.V2_0 );
        } catch ( FitRuntimeException e ) {
            System.err.println( "Error opening file ExampleActivity.fit" );
            return;
        }
         
         /**DECODER**/
                  Decode decode = new Decode();
        //decode.skipHeader();        // Use on streams with no header and footer (stream contains FIT defn and data messages only)
        //decode.incompleteStream();  // This suppresses exceptions with unexpected eof (also incorrect crc)
        MesgBroadcaster mesgBroadcaster = new MesgBroadcaster( decode );    
        mesgBroadcaster.addListener(new MyMessageListener(encode));
        FileInputStream in;
        
                
//        URL url = DecodeExample.class.getClass().getResource("/2431593594.fit");
//        URL url = DecodeExample.class.getClass().getResource("/rowingindoor.fit");
//        URL url = DecodeExample.class.getClass().getResource("/outdoorrunning.fit");
        URL url = DecodeExample.class.getClass().getResource("/ExampleActivity.fit");
        File file = null;
        
        try {
            file = new File( url.toURI());
        } catch (URISyntaxException ex) {
            Logger.getLogger(DecodeExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {           
            
            in = new FileInputStream( file);
        } catch (Exception e ) {
            throw new RuntimeException( "Error opening file ");
        }

        try {
            if ( !decode.checkFileIntegrity( (InputStream) in ) ) {
                throw new RuntimeException( "FIT file integrity failed." );
            }
        } catch ( RuntimeException e ) {
            System.err.print( "Exception Checking File Integrity: " );
            System.err.println( e.getMessage() );
            System.err.println( "Trying to continue..." );
        } finally {
            try {
                in.close();
            } catch ( java.io.IOException e ) {
                throw new RuntimeException( e );
            }
        }

        try {
            in = new FileInputStream( file);
        } catch ( java.io.IOException e ) {
            throw new RuntimeException( "Error opening file" );
        }
        
        //add missing fields cadence and speed
        FieldDescriptionMesg fieldDescMesg = new FieldDescriptionMesg();
        fieldDescMesg.setDeveloperDataIndex( (short) 0 );
        fieldDescMesg.setFieldDefinitionNumber( (short) 0 );
        fieldDescMesg.setFitBaseTypeId( (short) Fit.BASE_TYPE_FLOAT32 );
        fieldDescMesg.setFieldName( 0, "speed" );
        fieldDescMesg.setUnits( 0, "m/s" );
        fieldDescMesg.setNativeFieldNum((short)6);
        encode.write(fieldDescMesg);
        
        fieldDescMesg = new FieldDescriptionMesg();
        fieldDescMesg.setDeveloperDataIndex( (short) 0 );
        fieldDescMesg.setFieldDefinitionNumber( (short) 0 );
        fieldDescMesg.setFitBaseTypeId( (short) Fit.BASE_TYPE_FLOAT32 );
        fieldDescMesg.setFieldName( 0, "cadence" );
        fieldDescMesg.setUnits( 0, "rpm" );
        fieldDescMesg.setNativeFieldNum((short)4);
        encode.write(fieldDescMesg);
        
        if(decode.read(in, mesgBroadcaster, mesgBroadcaster) == true){
             try {
                encode.close();
            } catch ( FitRuntimeException e ) {
                System.err.println( "Error closing encode." );                
            }
        }
     }
     
     private class MyMessageListener implements MesgListener{
         
         FileEncoder encoder;
         private float last_distance = 0;
         
         public MyMessageListener(FileEncoder encoder){
             this.encoder = encoder;
         }

        @Override
        public void onMesg(Mesg mesg) {
//            if(mesg.getNum() == MesgNum.RECORD){
//                RecordMesg recMesg = new RecordMesg(mesg);
//                
//                //edit values test
//                Integer newValue = new Integer(recMesg.getHeartRate().intValue()+100);
//                recMesg.setHeartRate(newValue.shortValue());                
//                mesg = recMesg;
//             }
            
            StringBuffer buffer = new StringBuffer();
            for(Field field: mesg.getFields()){
                buffer.append(field.getName()+"["+field.getNum()+"]=>"+field.getValue()+" "+field.getUnits()+", ");                
            }
            
            for(DeveloperField field: mesg.getDeveloperFields()){
                buffer.append("\nDEVS: "+field.getName()+"["+field.getNum()+"]=>"+field.getValue()+" "+field.getUnits()+", ");
               
               
               
               if(field.getName().equalsIgnoreCase("distance")){                   
                    Field original_field = mesg.getField("distance");
                    if(original_field != null){
                        System.out.println("replacing speed distance");
                        
                        original_field.setValue(field.getValue());
                    }else{
                        System.out.println("adding new speed distance");
                        
                        Field new_field = Factory.createField("distance", 5);
                        new_field.setValue(field.getValue());
                        mesg.addField(new_field);
                    }
                    
                    last_distance = (Float)field.getValue();
               }
               
               if(field.getName().equalsIgnoreCase("speed")){                   
                    Field original_field = mesg.getField("speed");
                    if(original_field != null){
                        System.out.println("replacing speed fields");
                        
                        original_field.setValue(field.getValue());
                    }else{
                        System.out.println("adding new speed field");
                        
                        Field new_field = Factory.createField("speed", 6);
                        new_field.setValue(field.getValue());
                        mesg.addField(new_field);
                    }
               }
               
               if(field.getName().equalsIgnoreCase("cadence")){                   
                    Field original_field = mesg.getField("cadence");
                    if(original_field != null){
                        System.out.println("replacing cadence fields");
                        
                        original_field.setValue(field.getValue());
                    }else{
                        System.out.println("adding new cadence field");
                        
                        Field new_field = Factory.createField("cadence", 4);
                        new_field.setValue(field.getValue());
                        mesg.addField(new_field);
                    }
               }
            }
            
            
            if(mesg.getField("total_distance") != null){
                mesg.getField("total_distance").setValue(last_distance);
            }
           
      
      
            System.out.println(buffer.toString());
            
            encoder.write(mesg);
        }
         
         
     }
}
