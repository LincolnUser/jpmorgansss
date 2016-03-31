/**
 * 
 */
package com.jpmorgan.sss.model;

import java.sql.Timestamp;
import java.util.Random;

/**
 * @author Tayo
 *
 */
public class Utils {

	/**
	 * Static method generate a timestamp
	 * @return timestamp
	 */
	public static String generateTimeStamp(){
	
		 java.util.Date date= new java.util.Date();
		 System.out.println(new Timestamp(date.getTime()));
		 return new Timestamp(date.getTime()).toString();
	}
    
	/**
	 * Static method to generate a random value
	 * @param iMin
	 * @param iMax
	 * @return
	 */
	public static Double generateRandomValue(int iMin, int iMax){
		
 		Random r = new Random();
		double rValue = iMin + (iMax - iMin) * r.nextDouble();
        return rValue;
	}
}
