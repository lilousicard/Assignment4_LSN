package edu.sjsu.assignment4;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    /** Compare student by their name
     * @param o1 First student that get compare
     * @param o2 Second student that get compare
     * @return the name comparaison
     */
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
