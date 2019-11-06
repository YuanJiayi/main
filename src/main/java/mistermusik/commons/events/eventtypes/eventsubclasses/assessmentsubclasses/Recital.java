package mistermusik.commons.events.eventtypes.eventsubclasses.assessmentsubclasses;

import mistermusik.commons.events.eventtypes.eventsubclasses.Assessment;

public class Recital extends Assessment {
    /**
     * Creates recital event with isDone boolean for reading from files
     */
    public Recital(String description, boolean isDone, String startDateAndTime, String endDateAndTime) {
        super(description, isDone, startDateAndTime, endDateAndTime, 'R');
    }

    /**
     * Creates recital without isDone boolean for user input (assumes event entered is incomplete)
     */
    public Recital(String description, String startDateAndTime, String endDateAndTime) {
        super(description, false, startDateAndTime, endDateAndTime, 'R');
    }
}
