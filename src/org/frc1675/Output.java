/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675;

import java.util.Vector;

/**
 *
 * @author josh
 */
public class Output {
    
    public static final String DRIVER_LEFT_STICK_X = "driverLeftStickX";
    
    public static Vector strings = new Vector();
    public static Vector numbers = new Vector();
    public static Vector booleans = new Vector();
    
    public static void putString(String key, String value){
        strings.addElement(new OutputString(key, value));
    }
    
    public static void putNumber(String key, double value){
        numbers.addElement(new OutputNumber(key, Double.valueOf(value)));
    }
    
    public static void putBoolean(String key, boolean value){
        booleans.addElement(new OutputBoolean(key, Boolean.valueOf(value)));
    }
    
    public static String getString(String key){
        return (String) strings.elementAt(strings.indexOf(new OutputString(key, null)));
    }
    
    public static double getNumber(String key){
        return ((Double) numbers.elementAt(numbers.indexOf(new OutputNumber(key, null)))).doubleValue();
    }
    
    public static boolean getBoolean(String key){
        return ((Boolean) booleans.elementAt(numbers.indexOf(new OutputBoolean(key, null)))).booleanValue();
    }
    
    public static void consoleOutput(){
        
    }
    
    public static void dashboardOutput(){
        
    }
    
    
    private static class OutputString{
        
        private String key;
        private String value;
        
        public OutputString(String theKey, String theValue){
           key = theKey;
           value = theValue;
        }
        
        public String getValue(){
            return value;
        }
        
        public String getKey(){
            return key;
        }
        
        public boolean equals(OutputString outputString){
            return key.equals(outputString.getKey());
        }
    }
    
    private static class OutputNumber{
        
        private String key;
        private Double value;
        
        public OutputNumber(String theKey, Double theValue){
           key = theKey;
           value = theValue;
        }
        
        public Double getValue(){
            return value;
        }
        
        public boolean equals(OutputNumber outputNumber){
            return key.equals(outputNumber.getKey());
        }

        private String getKey() {
            return key;
        }
        
    }
    
    private static class OutputBoolean{
        
        private String key;
        private Boolean value;
        
        public OutputBoolean(String theKey, Boolean theValue){
           key = theKey;
           value = theValue;
        }
        
        public String getKey(){
           return key;
        }
        
        public Boolean getValue(){
            return value;
        }
        
        public boolean equals(OutputBoolean outputBoolean){
            return key.equals(outputBoolean.getKey());
        }
    }
    
}
