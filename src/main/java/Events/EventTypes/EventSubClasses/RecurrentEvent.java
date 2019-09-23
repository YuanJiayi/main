package Events.EventTypes.EventSubClasses;

import Events.EventTypes.Event;

public class RecurrentEvent extends Event {
    /**
     * Creates recurrent event with isDone boolean for reading from files
     * @param eventType type of event denoted by character
     */
    public RecurrentEvent(String description, boolean isDone, String startDateAndTime, String endDateAndTime, char eventType) {
        super(description, isDone, startDateAndTime, endDateAndTime, eventType);
    }

    /**
     * Creates recurrent event without isDone boolean for user input (assumes task entered is incomplete)
     * @param eventType type of event denoted by character
     */
    public RecurrentEvent(String description, String startDateAndTime, String endDateAndTime, char eventType) {
        super(description, false, startDateAndTime, endDateAndTime, eventType);
    }
}
