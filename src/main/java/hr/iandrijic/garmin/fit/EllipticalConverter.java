/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.iandrijic.garmin.fit;

import com.garmin.fit.Decode;
import com.garmin.fit.DeveloperField;
import com.garmin.fit.Field;
import com.garmin.fit.FieldBase;
import com.garmin.fit.FileEncoder;
import com.garmin.fit.Fit;
import com.garmin.fit.FitRuntimeException;
import com.garmin.fit.Mesg;
import com.garmin.fit.MesgBroadcaster;
import com.garmin.fit.MesgListener;
import com.garmin.fit.MesgNum;
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
        
                
        URL url = DecodeExample.class.getClass().getResource("/2423623036.fit");
//        URL url = DecodeExample.class.getClass().getResource("/rowingindoor.fit");
//        URL url = DecodeExample.class.getClass().getResource("/outdoorrunning.fit");
//        URL url = DecodeExample.class.getClass().getResource("/ExampleActivity.fit");
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
            
            /*for(Field field: mesg.getFields()){
                int subFieldIndex = mesg.getActiveSubFieldIndex(field.getNum());
                buffer.append("\nSUBS: "+field.getName(subFieldIndex)+"["+subFieldIndex+"]=>"+field.getValue(field.getNum(), subFieldIndex)+" "+field.getUnits(subFieldIndex)+", ");
            }*/
      
            for(DeveloperField field: mesg.getDeveloperFields()){
                buffer.append("\nDEVS: "+field.getName()+"["+field.getNum()+"]=>"+field.getValue()+" "+field.getUnits()+", ");
            }
      
      
            System.out.println(buffer.toString());
            
            encoder.write(mesg);
        }
         
         
     }
}
