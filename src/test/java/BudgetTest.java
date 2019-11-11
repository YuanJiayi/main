//@@author Ryan-Wong-Ren-Wei
import mistermusik.commons.budgeting.Budgeting;
import mistermusik.commons.budgeting.CostExceedsBudgetException;
import mistermusik.commons.events.eventtypes.Event;
import mistermusik.commons.events.eventtypes.eventsubclasses.Concert;
import mistermusik.logic.ClashException;
import mistermusik.logic.EndBeforeStartException;
import mistermusik.logic.EventList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

public class BudgetTest {
    @Test
    public void testBudget() {
        ArrayList<String> readFromFile = new ArrayList<String>();
        String fileContent;
        fileContent = "XT/fawpeifwe/02-12-2019";
        readFromFile.add(fileContent);
        fileContent = "XP/apiejfpwiefw/03-12-2019 1500/03-12-2019 1800";
        readFromFile.add(fileContent);
        fileContent = "XC/halloween/04-12-2019 1600/04-12-2019 1930/5";
        readFromFile.add(fileContent);

        EventList eventListTest = new EventList(readFromFile);
        try {
            eventListTest.addEvent(new Concert("good concert", "05-12-2019 1500",
                    "05-12-2019 1600",44));
        } catch (CostExceedsBudgetException | EndBeforeStartException | ClashException e) {
            fail();
        }

        assertThrows(CostExceedsBudgetException.class, () -> {
            eventListTest.addEvent(new Concert("good concert", "06-12-2019 1500",
                    "06-12-2019 1600",2));
        });
    }

    @Test
    public void testSetBudget() {
        Budgeting testBudgeting = new Budgeting(new ArrayList<Event>(), 5);
        assertEquals(5, testBudgeting.getBudget());

        assertThrows(CostExceedsBudgetException.class, () -> {
            testBudgeting.updateMonthlyCost(new Concert("test1", "2-12-2019 1500",
                    "2-12-2019 1600", 6));
        });

        testBudgeting.setBudget(75);
        assertEquals(75, testBudgeting.getBudget());

        try {
            testBudgeting.updateMonthlyCost(new Concert("test1", "2-12-2019 1500",
                    "2-12-2019 1600", 5));
        } catch (CostExceedsBudgetException e) {
            fail();
        }

        try {
            testBudgeting.updateMonthlyCost(new Concert("test2", "2-12-2019 1500",
                    "2-12-2019 1600", 5));
        } catch (CostExceedsBudgetException e) {
            fail();
        }

        try {
            testBudgeting.updateMonthlyCost(new Concert("test3", "2-12-2019 1500",
                    "2-12-2019 1600", 5));
        } catch (CostExceedsBudgetException e) {
            fail();
        }

        assertThrows(CostExceedsBudgetException.class, () -> {
            testBudgeting.updateMonthlyCost(new Concert("test4", "2-12-2019 1500",
                    "2-12-2019 1600", 61));
        });
    }
}
