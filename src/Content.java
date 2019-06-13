package src;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Content {

	public static void main(String[] args) throws ParseException {
		List<Event> listEvent = new ArrayList<Event>();
		SimpleDateFormat format = new SimpleDateFormat("y M D H m");
		Date date = format.parse("2016 7 1 10 30"); // July 1st, 10:30
		Date endDate = format.parse("2016 7 1 14 00"); // July 1st, 14:00
		listEvent.add(new Event(true, true, date, endDate)); // weekly recurring opening in calendar
		
		date = format.parse("2016 7 8 11 30"); // July 8th 11:30
		endDate = format.parse("2016 7 8 12 30"); // July 8th 12:30
		listEvent.add(new Event(false, false, date, endDate)); // intervention scheduled
		
		Date fromDate = format.parse("2016 7 4 10 00"); // July 4th 10:00
		Date toDate = format.parse("2016 7 10 10 00"); // July 10th 10:00
		List<Date> answer = Event.availabilities(fromDate, toDate, listEvent); // When are you available between these dates ?

        for (Date slot : answer){
            System.out.println(slot);
        }
		/*
		 * Answer should be : 
		 * I'm available from July 8th, at 10:30, 11:00, 12:30, 13:00, and 13:30
		 * I'm not available any other time !
		 */
	}

}
