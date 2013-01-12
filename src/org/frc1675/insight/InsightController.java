/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.insight;

import java.util.Hashtable;

/**
 *
 * @author josh
 */
public class InsightController {
    
    private static Hashtable data = new Hashtable();
    private static InsightDisplayStrategy display = new DefaultInsightDisplayStrategy();
    
    /**
     * Initializes the InsightDisplayStrategy for this controller.
     * @param newDisplay 
     */
    public static void setDisplayStrategy(InsightDisplayStrategy newDisplay){
        display = newDisplay;
    }
    
    public static void updateInsightDisplay(){
        String line1 = display.buildDisplayLine1(data);
        String line2 = display.buildDisplayLine2(data);
        
        //TODO send these lines to the insight
    }
    
    public static void put(String key, Object value){
        data.put(key, value);
    }
}
