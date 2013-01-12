/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.insight;

import java.util.Hashtable;

/**
 * prints "NO STRATEGY IMPLEMENTED" on the Insight display
 * @author josh
 */
public class DefaultInsightDisplayStrategy implements InsightDisplayStrategy {

    public String buildDisplayLine1(Hashtable data) {
        return "    NO STRATEGY     ";
    }

    public String buildDisplayLine2(Hashtable data) {
        return "    IMPLEMENTED     ";
    }
    
}
