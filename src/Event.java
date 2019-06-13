package src;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Event {
	private boolean opening;
	private boolean recurring;
	private Date date;
	private Date endDate;

	public Event(boolean opening, boolean recurring, Date date, Date endDate) {
		super();
		this.opening = opening;
		this.recurring = recurring;
		this.date = date;
		this.endDate = endDate;
	}

	public boolean isOpening(){
		return opening;
	}
	
	public boolean isBusy(){
		return !opening;
	}
	
	public boolean isRecurring(){
		return recurring;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getEndDate() {
		return endDate;
	}
	
	public static List<Date> availabilities(Date fromDate, Date toDate, List<Event> listEvent){
		return EventsManagement.getAvailabilities(fromDate, toDate, EventsManagement.recurentManagement(fromDate,listEvent));
	}
}
