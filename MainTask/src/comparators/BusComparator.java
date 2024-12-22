package comparators;

import models.Bus;

import java.util.Comparator;

public class BusComparator {

    public static class ByNumber implements Comparator<Bus> {

        @Override
        public int compare(Bus bus1, Bus bus2) {
            return bus1.getNumber().compareTo(bus2.getNumber());
        }
    }

    public static class ByModel implements Comparator<Bus> {

        @Override
        public int compare(Bus bus1, Bus bus2) {
            return bus1.getModel().compareTo(bus2.getModel());
        }
    }

    public static class ByMileage implements Comparator<Bus> {

        @Override
        public int compare(Bus bus1, Bus bus2) {
            return bus1.getMileage().compareTo(bus2.getMileage());
        }
    }
}
