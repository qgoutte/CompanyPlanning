package src;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class EventsManagement {
    public static List<Event> recurentManagement(Date fromDate,List<Event> listEvent){
        List<Event> newEvents = new ArrayList<>();
        for (Event event :listEvent) {
            //Part Recurrent
            if (event.getEndDate().before(fromDate)) {
                if (event.isRecurring()) {
                    Calendar c = Calendar.getInstance();
                    c.setTime(event.getDate());
                    c.add(Calendar.DAY_OF_MONTH, 7);
                    Date dateEvent = c.getTime();
                    c.setTime(event.getEndDate());
                    c.add(Calendar.DAY_OF_MONTH, 7);
                    Date endDateEvent = c.getTime();
                    newEvents.add(new Event(event.isOpening(), event.isRecurring(), dateEvent, endDateEvent));
                }
            }
        }
        listEvent=EventsManagement.updateListEvent(newEvents,listEvent);
        return listEvent;
    }

    public static List<Event> updateListEvent(List<Event> listEvents,List<Event> listResult){
        for (Event event : listEvents) {
            listResult.add(event);
        }
        return listResult;
    }

    public static List<Date> getAvailabilities(Date fromDate, Date toDate,List<Event> listEvent ){
        List<Date> availabilities = new ArrayList<>();
        List<Date> openingDate = new ArrayList<>();
        List<Date> closingDate = new ArrayList<>();

        for (Event event :listEvent) {
            //src.Event Part
            if (event.getEndDate().before(toDate) && event.getDate().after(fromDate)) {
                Calendar start =Calendar.getInstance();
                Calendar end =Calendar.getInstance();
                start.setTime(event.getDate());
                end.setTime(event.getEndDate());
                if (event.isOpening()){
                    for (Date date  = start.getTime(); start.before(end); start.add(Calendar.MINUTE,30), date = start.getTime()){
                        openingDate.add(date);
                    }
                } else if (event.isBusy()){
                    for (Date date  = start.getTime(); start.before(end); start.add(Calendar.MINUTE,30), date = start.getTime()){
                        closingDate.add(date);
                    }
                }
            }
        }

        for (Date d : openingDate){
            if (!closingDate.contains(d)){
                availabilities.add(d);
            }
        }

        return availabilities;
    }

}
