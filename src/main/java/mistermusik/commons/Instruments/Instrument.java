package mistermusik.commons.instruments;

import mistermusik.commons.events.formatting.EventDate;

import java.util.ArrayList;

public class Instrument {
    private String instrumentName;
    private ArrayList<ServiceInfo> serviceInfoList;


    /**
     * Creates an Instrument instance with the input name.
     *
     * @param name Name of instrument
     */
    public Instrument(String name) {
        this.instrumentName = name;
        serviceInfoList = new ArrayList<>();
    }

    public String getName() {
        return instrumentName;
    }

    /**
     * Adds service information.
     */
    public int addService(EventDate date, String description) {
        ServiceInfo newServiceInfo = new ServiceInfo(date, description);
        serviceInfoList.add(newServiceInfo);
        return serviceInfoList.size();
    }

    /**
     * Gets service information.
     * @return
     */
    public String getServiceInfos() {
        String res = "";
        int j;
        for (int i = 0; i < serviceInfoList.size(); i++) {
            j = i + 1;
            res += j + ". " + serviceInfoList.get(i).getServiceInfo() + "\n";
        }
        return res;
    }

    public String getIndexAndService(int index) {
        return index + ". " + serviceInfoList.get(index - 1).getServiceInfo();
    }

}
