package models;

import java.util.Comparator;

public interface Filterable<T> {

    /**
     * @param obj compared object
     * @return negative num if this object less than argument abject (this < obj), zero if objects are equal and positive num if this object less than argument abject (this > obj)
     */
    public int compTo(T obj);
}
