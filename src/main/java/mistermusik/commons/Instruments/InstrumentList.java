package mistermusik.commons.instruments;

import mistermusik.commons.events.formatting.EventDate;

import java.util.ArrayList;

public class InstrumentList {
    private ArrayList<Instrument> instrumentList;

    /**
     * Creates a Goal instance with the goal input by user and a boolean to check if goal is achieved.
     */
    public InstrumentList() {
        instrumentList = new ArrayList<>();
    }

    public String getInstruments() {
        String res = "";
        int j;
        for (int i = 0; i < instrumentList.size(); i++) {
            j = i + 1;
            res += j + ". " + instrumentList.get(i).getName() + "\n";
        }
        return res;
    }

    public int addInstrument(String name) {
        Instrument newInstrument = new Instrument(name);
        instrumentList.add(newInstrument);
        return instrumentList.size();
    }

    public String getInstrumentServiceInfo(int index) {
        int indexInList = index - 1;
        return instrumentList.get(indexInList).getServiceInfos();
    }

    public int service(int index, EventDate date, String description) {
        int indexInList = index - 1;
        return instrumentList.get(indexInList).addService(date, description);
    }

    public String getIndexAndInstrument(int index) {
        return index + ". " + instrumentList.get(index - 1).getName();
    }

    public String getIndexAndService(int instrumentIndex, int serviceIndex) {
        return instrumentList.get(instrumentIndex - 1).getIndexAndService(serviceIndex);
    }
}

