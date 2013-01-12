/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.insight;

import java.util.Hashtable;

/**
 * Implement this interface to provide a strategy for using the
 *   InsightController's gathered data to form output for the Insight LT display
 * @author josh
 */
public interface InsightDisplayStrategy {
    
    /**
     * @param data table of data from the InsightController
     * @return A 20-character string to put on the first line of the Insight 
     *   display
     */
    public String buildDisplayLine1(Hashtable data);
    
    /**
     * @param data table of data from the InsightController
     * @return A 20-character string to put on the second line of the Insight 
     *   display
     */
    public String buildDisplayLine2(Hashtable data);
    
}
