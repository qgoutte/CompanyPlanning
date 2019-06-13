package test;

import src.Event;
import src.EventsManagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EventsManagementTest {

    public List<Event> prepareTest() throws ParseException {
        List<Event> listEvent = new ArrayList<Event>();
        SimpleDateFormat format = new SimpleDateFormat("y M D H m");
        listEvent.add(new Event(true, true, format.parse("2016 7 1 10 30"), format.parse("2016 7 1 14 00")));
        listEvent.add(new Event(false, false, format.parse("2016 7 8 11 30"), format.parse("2016 7 8 12 30")));
        return listEvent;
    }

    @org.junit.jupiter.api.Test
    //We want that the return object wasn't null
    void recurentManagementTest() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("y M D H m");
        assertNotNull(EventsManagement.recurentManagement(format.parse("2016 7 4 10 00"),prepareTest()));
    }

    @org.junit.jupiter.api.Test
    //We test the method by recurentManagement method because it contains the new Event
    void updateListEventTest() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("y M D H m");
        assertEquals(3,EventsManagement.recurentManagement(format.parse("2016 7 4 10 00"),prepareTest()).size());

    }

    @org.junit.jupiter.api.Test
    void getAvailabilitiesTest() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("y M D H m");
        assertFalse(EventsManagement.getAvailabilities(format.parse("2016 7 4 10 00"),format.parse("2016 7 10 10 00"),EventsManagement.recurentManagement(format.parse("2016 7 4 10 00"),prepareTest())).contains(format.parse("2016 7 8 12 00")));
        assertTrue(EventsManagement.getAvailabilities(format.parse("2016 7 4 10 00"),format.parse("2016 7 10 10 00"),EventsManagement.recurentManagement(format.parse("2016 7 4 10 00"),prepareTest())).contains(format.parse("2016 7 8 13 00")));
    }
}