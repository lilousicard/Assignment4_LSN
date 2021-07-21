package edu.sjsu.assignment4;

import java.util.Comparator;

public class DesComparator implements Comparator<Appointment> {
    /**+
     * This function compares two appointments using their description to compare them
     * @param o1 First appointment to compare
     * @param o2 Second appointment to compare
     * @return the comparison of the two appointment beginning with the description, then using start date and end date
     */
    @Override
    public int compare(Appointment o1, Appointment o2) {
        if (o1.getDescription().equals(o2.getDescription())) return  o1.compareTo(o2);
        return o1.getDescription().compareTo(o2.getDescription());
    }
}
