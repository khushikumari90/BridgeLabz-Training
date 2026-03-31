//Problem 1: Time Zones and ZonedDateTime Write a program that displays the current time in different time zones:
package BuiltInFunction;
import java.time.ZonedDateTime;
import java.time.ZoneId;
public class TimeZones {

	public static void main(String[] args) {
		    ZonedDateTime gmtTime = ZonedDateTime.now(ZoneId.of("GMT"));
	        ZonedDateTime istTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
	        ZonedDateTime pstTime = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));

	        System.out.println("Current Time in GMT : " + gmtTime);
	        System.out.println("Current Time in IST : " + istTime);
	        System.out.println("Current Time in PST : " + pstTime);
	}

}
