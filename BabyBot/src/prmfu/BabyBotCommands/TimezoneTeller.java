package prmfu.BabyBotCommands;

import java.util.Date;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TimezoneTeller {

	public static void getCurrentTimeUsingDate() {
        Date date = new Date();
        String strDateFormat = "hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat.format(date);
        System.out.println("Current time of the day using Date - 12 hour format: " + formattedDate);
	}
	
	public static void getCurrentTimeWithTimeZone(){
	    System.out.println("-----Current time of a different time zone using LocalTime-----");
	    ZoneId zoneId = ZoneId.of("America/Los_Angeles");
	    LocalTime localTime=LocalTime.now(zoneId);
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	    String formattedTime=localTime.format(formatter);
	    System.out.println("Current time of the day in Los Angeles: " + formattedTime);
	}
}
