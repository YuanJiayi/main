package UserElements.ConcertBudgeting;

import Events.EventTypes.Event;
import Events.Formatting.EventDate;
import java.util.*;

public class Budgeting {

    /**
     * Map that stores all information regarding monthly budgeting for concerts
     * String is the month followed by year <MM-yyyy> representing the month that we analyze budget
     * MonthlyBudget is the class corresponding to the month being analyzed, stores all details
     * for budget analysis including the corresponding Concert objects.
     */
    private Map<String, MonthlyBudget> monthlyCosts;

    int budget; //current user defined budget

    /**
     * Constructor for budgeting system.
     *
     * @param eventList List of Event objects containing all events currently in the list, to be used
     *                  in monthly budget/cost calculation
     */
    public Budgeting(ArrayList<Event> eventList, int budget) {
        this.budget = budget;
        createMap(eventList);
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    /**
     * Creates a map where key is the month(MM-yyyy format) and value is the MonthlyBudget object for that month.
     *
     * @param eventList list of all events in the current list.
     * @return created map.
     */
    private void createMap(ArrayList<Event> eventList) {
        monthlyCosts = new HashMap<String, MonthlyBudget>();
        EventDate monthlyDate = null; //stores a date of a day in the month we are currently checking for
        ArrayList<Event> listOfConcerts = new ArrayList<Event>(); //to store the concerts in a given month
        String monthAndYear = "";

        for (Event currEvent : eventList) {
            if (currEvent.getType() != 'C') //if not concert type event, skip iteration
                continue;

            if (!isSameMonth(currEvent.getStartDate(), monthlyDate)) {
                if (!listOfConcerts.isEmpty()) {
                    this.monthlyCosts.put(monthAndYear, new MonthlyBudget(listOfConcerts));
                }

                monthlyDate = currEvent.getStartDate();
                monthAndYear = getMonthAndYear(monthlyDate);
                listOfConcerts.clear();
            }

            listOfConcerts.add(currEvent);
        }

        this.monthlyCosts.put(monthAndYear, new MonthlyBudget(listOfConcerts));
    }

    private boolean isSameMonth(EventDate eventDateA, EventDate eventDateB) {
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(eventDateA.getEventJavaDate());

            int monthA = cal.get(Calendar.MONTH);
            int yearA = cal.get(Calendar.YEAR);

            cal.setTime(eventDateB.getEventJavaDate());

            int monthB = cal.get(Calendar.MONTH);
            int yearB = cal.get(Calendar.YEAR);

            return (monthA == monthB) && (yearA == yearB);
        } catch (NullPointerException e) {
            return false;
        }
    }

    private String getMonthAndYear(EventDate date) {
        String MonthAndYear = date.getUserInputDateString();
        MonthAndYear = MonthAndYear.substring(3, 10); //get MM-yyyy from dd-MM-yyyy HHmm

        return MonthAndYear;
    }
}