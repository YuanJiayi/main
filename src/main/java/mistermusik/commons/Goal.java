//@@author yenpeichih
package mistermusik.commons;

public class Goal {

    private String goalDescription;

    private boolean isAchieved;

    /**
     * Creates a Goal instance with the goal input by user and a boolean to check if goal is achieved.
     *
     * @param description
     */
    public Goal(String description) {
        goalDescription = description;
        isAchieved = false;
    }

    public String getGoal() {
        return goalDescription;
    }

    public void setAchieved() {
        isAchieved = true;
    }

    public boolean getBooleanStatus() {
        return isAchieved;
    }

    public String getStatus() {
        if (isAchieved) {
            return "Yes";
        } else {
            return "No";
        }
    }
}
