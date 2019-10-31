package UserElements;

import Events.EventTypes.Event;
import Events.EventTypes.EventSubclasses.Concert;
import Events.Storage.Contact;
import Events.Storage.EventList;
import Events.Storage.Goal;

import java.util.ArrayList;
import java.util.Queue;


/**
 * User interface: contains all methods pertaining to user interaction.
 */
public class UI {
    private static String lineSeparation = "____________________________________________________________\n";

    /**
     * Comparator function codes
     */
    private static final int EQUAL = 0;
    private static final int GREATER_THAN = 1;
    private static final int SMALLER_THAN = 2;

    /**
     * Filter type codes
     */
    private static final int DATE = 0;
    private static final int TYPE = 1;

    /**
     * prints welcome message and instructions for use.
     */
    public void welcome() {
        String logo = " ___    ___   __________    __________   __________   __________   _________" + "\n"
                + "|   \\  /   | |___    ___|  /  ________| |___    ___| |   _______| |   ____  \\" + "\n"
                + "| |\\ \\/ /| |     |  |     /  /              |  |     |  |         |  |    \\  \\" + "\n"
                + "| | \\  / | |     |  |     \\  \\_______       |  |     |  |____     |  |____/  /" + "\n"
                + "| |  \\/  | |     |  |      \\_______  \\      |  |     |   ____|    |   ___   /" + "\n"
                + "| |      | |     |  |              \\  \\     |  |     |  |         |  |   \\  \\" + "\n"
                + "| |      | |  ___|  |___   ________/  /     |  |     |  |_______  |  |    |  |" + "\n"
                + "|_|      |_| |__________| |__________/      |__|     |__________| |__|    |__|" + "\n"
                + " ___    ___   __      __    __________   __________   __      __ " + "\n"
                + "|   \\  /   | |  |    |  |  /  ________| |___    ___| |  |    /  /" + "\n"
                + "| |\\ \\/ /| | |  |    |  | /  /              |  |     |  |   /  /" + "\n"
                + "| | \\  / | | |  |    |  | \\  \\_______       |  |     |  |__/  /" + "\n"
                + "| |  \\/  | | |  |    |  |  \\_______  \\      |  |     |   __  |" + "\n"
                + "| |      | | |  |    |  |          \\  \\     |  |     |  |  \\  \\" + "\n"
                + "| |      | | |  |____|  |  ________/  /  ___|  |___  |  |   \\  \\" + "\n"
                + "|_|      |_| |__________| |__________/  |__________| |__|    \\__\\" + "\n";
        System.out.println(logo);
        System.out.println(lineSeparation + "Hello! I'm MisterMusik!\nWhat can I do for you?\n");

        System.out.println("Commands:");
        System.out.println("1. list: Print a list of events currently stored.");
        System.out.println("2. todo <description of event>: Adds a simple event with no time or date involved");
        System.out.println("3. event OR deadline <description of event> /at OR /by <time>: adds an event/deadline to the list of events.");
        System.out.println("4. done <event number>: completes a event");
        System.out.println("5. bye: exits the program\n");
        System.out.println("6. reminder: view your upcoming events for the next 3 days");
        System.out.println("When entering dates and times, you may do so in the following format for faster entry : \n" +
                "dd-MM-yyyy HHmm\n" + lineSeparation);
//        printReminder(Events);
        System.out.println("Enter a command:");
    }

    /**
     * Obtains the current date and prints the events to be completed within the next
     * three days as a reminder.
     *
     * @param events the EventList used in the Duke function.
     */

    public void printReminder(EventList events) {
        System.out.print(lineSeparation);
        System.out.print(events.getReminder());
        System.out.print(lineSeparation);
    }

    /**
     * Prints a message when an invalid command is entered.
     */
    public void printInvalidCommand() {
        System.out.print(lineSeparation);
        System.out.println("Sorry! I don't know what that means.");
        System.out.print(lineSeparation);
    }

    public void contactAdded() {
        System.out.print(lineSeparation);
        System.out.println("Ok, the contact has been added to the event.");
        System.out.print(lineSeparation);
    }

    public void contactDeleted() {
        System.out.print(lineSeparation);
        System.out.println("Ok, the contact has been deleted from the event.");
        System.out.print(lineSeparation);
    }

    public void printEventContacts(Event viewEventContact) {
        System.out.print(lineSeparation);
        System.out.println("Here is the list of contacts for the following event " + viewEventContact.toString());
        int contactNo = 1;
        for (Contact currContact : viewEventContact.getContactList()) {
            System.out.println(contactNo + ". Name: " + currContact.getName() + " Email: " + currContact.getEmail()
            + " Phone Number: " + currContact.getPhoneNo());
            contactNo++;
        }
        System.out.print(lineSeparation);
    }

    public void contactEdited(Contact newContact) {
        System.out.print(lineSeparation);
        System.out.println("The contact has been edited to: Name: " + newContact.getName() + " Email: "
                + newContact.getEmail() + " Phone Number: " +newContact.getPhoneNo());
        System.out.print(lineSeparation);
    }

    public void noContactInEvent() {
        System.out.print(lineSeparation);
        System.out.println("Do not have any contact in this event.");
        System.out.print(lineSeparation);
    }

    /**
     * prints entire list of events stored.
     *
     * @param events Model_Class.EventList object containing all stored classes and pertaining methods.
     */
    public static void printListOfEvents(EventList events) {
        System.out.print(lineSeparation);
        System.out.print(events.listOfEvents_String());
        System.out.print(lineSeparation);
    }

    /**
     * prints goodbye message
     */
    public static void bye() {
        System.out.print(lineSeparation + "Bye. Hope to see you again soon!\n" + lineSeparation);
    }

    /**
     * @return line of underscores to separate different Model_Class.UI outputs.
     */
    public String getLineSeparation() {
        return lineSeparation;
    }

    /**
     * prints message when a event is successfully added
     *
     * @param eventAdded event in question
     * @param numEvents  total number of events
     */
    public void eventAdded(Event eventAdded, int numEvents) {
        try {
            System.out.println(lineSeparation + "Got it. I've added this event:");
            System.out.println("[" + eventAdded.getDoneSymbol() + "][" + eventAdded.getType() + "] " +
                    eventAdded.getDescription() + " START: " + eventAdded.getStartDate().getFormattedDateString() +
                    " END: " + eventAdded.getEndDate().getFormattedDateString());
            System.out.println("Now you have " + numEvents + " events in the list.");
            System.out.print(lineSeparation);
        } catch (NullPointerException e) {
            System.out.println("[" + eventAdded.getDoneSymbol() + "][" + eventAdded.getType() + "] " +
                    eventAdded.getDescription() + " BY: " + eventAdded.getStartDate().getFormattedDateString());
            System.out.println("Now you have " + numEvents + " events in the list.");
            System.out.print(lineSeparation);
        }
    }

    public void inputDetails() {
        System.out.println("Please input the event details below in the format" + "\n" +
                "<venue>/<teachers or assessors>/<pieces to practice>/<performers>. For non-applicable categories please input 'NA'.");
    }

    /**
     * prints message when a event is marked as completed
     *
     * @param event event in question
     */
    public void eventDone(Event event) {
        System.out.print(lineSeparation);
        System.out.println("Nice! I've marked this event as done:");
        System.out.println(event.toString());
        System.out.print(lineSeparation);
    }

    /**
     * prints message when a event is deleted successfully
     *
     * @param event event in question to be deleted
     */
    public void eventDeleted(Event event) {
        System.out.print(lineSeparation);
        System.out.println("Noted. I've removed this event:");
        System.out.println(event.toString());
        System.out.print(lineSeparation);
    }

    /**
     * prints message containing events found when a search is performed.
     * prints error message if no events are found
     *
     * @param allFoundEvents string containing all the events found, separated by newline character
     * @param found          boolean signifying whether or not any events were found
     */
    public void printFoundEvents(String allFoundEvents, boolean found) {
        if (found) {
            System.out.print(lineSeparation);
            System.out.println("Here are the matching events in your list:");
            System.out.print(allFoundEvents);
            System.out.print(lineSeparation);
        } else {
            System.out.print(lineSeparation);
            System.out.println("No such events were found! Please try again.");
            System.out.print(lineSeparation);
        }
    }

    /**
     * prints message if command does not contain valid input for related event.
     */
    public void noSuchEvent() {
        System.out.print(lineSeparation);
        System.out.println("There is no such event! Please try again.");
        System.out.print(lineSeparation);
    }

    public void rescheduleFormatWrong() {
        System.out.print(lineSeparation);
        System.out.println("Please enter command in the following format:\n" +
                "reschedule <taskIndex> dd-MM-yyyy HHmm HHmm\n" +
                "Please ensure that the taskIndex is a valid integer as well!");
        System.out.print(lineSeparation);
    }

    /**
     * prints message if no event description is found when adding a new event to the list
     */
    public void eventDescriptionEmpty() {
        System.out.print(lineSeparation);
        System.out.println("The description of your event cannot be empty!");
        System.out.print(lineSeparation);
    }

    public void eventEndsBeforeStart() {
        System.out.print(lineSeparation);
        System.out.println("The event you added ends before it starts! Please try again.");
        System.out.print(lineSeparation);
    }

    /**
     * prints message when event index from input is not an integer
     */
    public void notAnInteger() {
        System.out.print(lineSeparation);
        System.out.println("That is not a valid integer! Please enter the index of the event you intend to alter.");
        System.out.print(lineSeparation);
    }

    /**
     * prints message when input format is wrong for addition of new event type event.
     */
    public void eventFormatWrong() {
        System.out.print(lineSeparation);
        System.out.println("Please enter the date in the format 'dd-MM-yyyy HHmm HHmm' or 'dd-MM-yyyy'.\n" +
                "First time entered is start time, second time entered is end time.");
        System.out.print(lineSeparation);
    }

    public void scheduleClash(Event event) {
        System.out.print(lineSeparation);
        System.out.println("That event clashes with another in the schedule! " +
                "Please resolve the conflict and try again!");
        System.out.println("Clashes with: " + event.toString());
        System.out.print(lineSeparation);
    }

    /**
     * prints message when recurring events are added to the list successfully
     */
    public void recurringEventAdded(Event eventAdded, int numEvents, int period) {
        System.out.println(lineSeparation + "Got it. I've added these recurring events:");
        System.out.println("[" + eventAdded.getDoneSymbol() + "][" + eventAdded.getType() + "] " +
                eventAdded.getDescription() + " START: " + eventAdded.getStartDate().getFormattedDateString() +
                " END: " + eventAdded.getEndDate().getFormattedDateString() + " (every " + period + " days)");
        System.out.println("Now you have " + numEvents + " events in the list.");
        System.out.print(lineSeparation);
    }

    /**
     * prints next 3 days that are free
     *
     * @param freeDays queue of free days of type DateObj
     */
    public void printFreeDays(Queue<String> freeDays) {
        System.out.print(lineSeparation);
        System.out.println("Here are the next 3 free days!");
        for (int i = 0; i <= freeDays.size(); i++) {
            System.out.println(freeDays.poll());
        }
        System.out.print(lineSeparation);
    }

    /**
     * prints message when reschedule an event successfully
     *
     * @param event event after rescheduled
     */
    public void rescheduleEvent(Event event) {
        System.out.print(lineSeparation);
        System.out.println("Rescheduled event to " + event.toString() + " successfully!");
        System.out.print(lineSeparation);
    }

    public void errorWritingToFile() {
        System.out.print(lineSeparation);
        System.out.println("Error writing to file! Details not saved!");
        System.out.print(lineSeparation);
    }

    /**
     * Prints message to show success of edit command.
     *
     * @param eventIndex  The index of the edited event.
     * @param eventEdited The event after edit.
     */
    public void printEditedEvent(int eventIndex, Event eventEdited) {
        try {
            System.out.println(lineSeparation + "Got it. Successfully edited event" + eventIndex + ":");
            System.out.println("[" + eventEdited.getDoneSymbol() + "][" + eventEdited.getType() + "] " +
                    eventEdited.getDescription() + " START: " + eventEdited.getStartDate().getFormattedDateString() +
                    " END: " + eventEdited.getEndDate().getFormattedDateString());
            System.out.print(lineSeparation);
        } catch (NullPointerException e) {
            System.out.println("[" + eventEdited.getDoneSymbol() + "][" + eventEdited.getType() + "] " +
                    eventEdited.getDescription() + " BY: " + eventEdited.getStartDate().getFormattedDateString());
            System.out.print(lineSeparation);
        }
    }

    public void printCalendar(String calendarInfo) {
        System.out.print(lineSeparation);
        System.out.println("Here is the calendar of the 7 days!");
        System.out.println(calendarInfo);
        System.out.println("\nEnter a command:");
    }

    public void costExceedsBudget(Concert concert, int budget) {
        System.out.print(lineSeparation);
        System.out.println("The following concert you wanted to add causes you to exceed the stipulated budget for that month!");
        System.out.println(concert.toString());
        String date = concert.getStartDate().getFormattedDateString().substring(8, 16);
        System.out.println("exceeds budget of $" + budget + " for the month of " + date);
        System.out.println("Operation has been cancelled.");
        System.out.print(lineSeparation);
    }

    public static void printCostForMonth(String monthAndYear, int cost) {
        System.out.print(lineSeparation);
        System.out.println("Your total concert costs for " + monthAndYear + " is:");
        System.out.println("$" + cost);
        System.out.print(lineSeparation);
    }

    public static void printNoCostsForThatMonth() {
        System.out.print(lineSeparation);
        System.out.println("There are no concerts for that month!");
        System.out.print(lineSeparation);
    }

    public void printEventGoals(Event viewEventGoal) {
        System.out.println("Here is the list of goals for the following event: " + viewEventGoal.toString());
        if (!viewEventGoal.getGoalList().isEmpty()) {
            int goalIndex = 1;
            for (Goal goalObject : viewEventGoal.getGoalList()) {
                System.out.println(goalIndex + ". " + goalObject.getGoal() + " - " + "Achieved: " + goalObject.getStatus());
                goalIndex += 1;
            }
        } else {
            System.out.println("You currently have no goals for this event.");
        }
    }

    public void goalAdded() {
        System.out.println("Ok, the goal has been added to the event.");
    }

    public void goalDeleted() {
        System.out.println("Ok, the goal has been deleted from the event.");
    }

    public void goalUpdated() {
        System.out.println("Ok, the goal has been updated.");
    }

    public void goalSetAsAchieved() {
        System.out.println("Ok, the goal has been set as achieved. Congratulations for achieving the goal!");
    }

    public void noSuchGoal() {
        System.out.println("Sorry, the specified goal does not exist!");
    }
  
    public void checklistDeleted(int eventIndex) {
        System.out.print(lineSeparation);
        System.out.println("Ok, checklist of event " + eventIndex + 1 + " has been deleted.");
        System.out.print(lineSeparation);
    }

    public void checklistEdited(String newChecklistItem, int eventIndex) {
        System.out.print(lineSeparation);
        System.out.println("Ok, checklist of event " + eventIndex + 1 + " has been edited to:");
        System.out.println(newChecklistItem);
        System.out.print(lineSeparation);
    }

    public void checklistAdded(String newChecklistItem, int eventIndex) {
        System.out.print(lineSeparation);
        System.out.println("Ok, the following item has been added to checklist of event " + eventIndex + 1 + ":");
        System.out.println(newChecklistItem);
        System.out.print(lineSeparation);
    }

    public void printEventChecklist(ArrayList<String> thisChecklist, int eventIndex, Event eventAdded) {
        System.out.print(lineSeparation);
        System.out.println("Here is the checklist for the following event: ");
        System.out.println("[" + eventAdded.getDoneSymbol() + "][" + eventAdded.getType() + "] " +
                eventAdded.getDescription());
        System.out.println("Checklist: ");
        int checklistIndex = 1;
        for (String checklistItem : thisChecklist) {
            System.out.println(checklistIndex + ". " + checklistItem);
            checklistIndex += 1;
        }
        System.out.print(lineSeparation);
    }
    
    public void instrumentAdded(String instrumentIndexAndName) {
    	System.out.print(lineSeparation);
    	System.out.println("Ok, the following instrument has been added: ");
    	System.out.println(instrumentIndexAndName);
    	System.out.println(lineSeparation);
    }
    
    public void serviceAdded(String serviceIndexAndName, String instrumentIndexAndName) {
    	System.out.println(lineSeparation);
    	System.out.println("Ok, the following service: ");
    	System.out.println(serviceIndexAndName);
    	System.out.println("has been added for the following instrument: ");
    	System.out.println(instrumentIndexAndName);
    	System.out.println(lineSeparation);
    }
    
    public void printInstruments(String instruments) {
    	System.out.println(lineSeparation);
    	System.out.println("Here are the list of instruments stored in the system: ");
    	System.out.println(instruments);
    	System.out.println(lineSeparation);
    }
    
    public void printServices(String services, String instrumentIndexAndName) {
    	System.out.println(lineSeparation);
    	System.out.println("Here are the list of services: ");
    	System.out.println(services);
    	System.out.println("Done before for the following instrument: ");
    	System.out.println(instrumentIndexAndName);
    	System.out.println(lineSeparation);
    }
}
