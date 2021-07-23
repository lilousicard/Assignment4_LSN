package edu.sjsu.assignment4;

import java.util.*;

public class Gradebook {
    HashMap<Student,Character> sm;
    public Gradebook(){
        sm = new HashMap<Student,Character>();
    }

    /**
     * The function update the hash map so that a student object will be added. The student object is created in the function
     * @param id student id
     * @param name student name
     * @param grade student grade
     * @return true or false if the student was successfully added
     */
    public boolean addStudent(int id, String name, char grade)
    {
        Student student = new Student(id,name);
        if (!this.sm.containsKey(student)&& isValidGrade(grade))
        {
            sm.put(student,grade);
            return true;

        }
        if (!this.sm.containsKey(student))
        {
            sm.put(student,'N');
            return true;
        }
        return false;
    }


    /**
     * Add a student to the hash map without an official grade
     * @param id student id
     * @param name student name
     * @return true or false
     */
    public boolean addStudent(int id, String name)
    {
        return addStudent(id, name, 'N');
    }

    /**
     * Delete a particular student from the hashmap
     * @param id the student's id of the student that will be deleted
     * @return true or false
     */
    public boolean deleteStudent(int id)
    {
        Student temp = new Student(id);
        if(sm.containsKey(temp))
        {
            sm.remove(temp);
            return true;
        }
        return false;
    }

    /**
     * Change the grade of a student if that grade is valid
     * @param id student's id
     * @param newGrade the new grade
     * @return true or false
     */
    public boolean updateGrade (int id, char newGrade)
    {
        Student temp = new Student(id);
        if (sm.containsKey(temp)&& isValidGrade(newGrade))
        {
            sm.replace(temp,newGrade);
            return true;
        }
        return false;
    }

    /**
     * Print every element of the treemap in the format id.name: grade
     * @param comparator the parameter to sort the display
     */
    public void printGrade(Comparator<Student> comparator)
    {

        if (comparator == null) {

            for (Map.Entry<Student, Character> entry : sm.entrySet()) {
                System.out.println(entry.getKey().getId() + "." + entry.getKey().getName() + ": " + entry.getValue());

            }

        } else {
            ArrayList<Student> ls;
            ls = new ArrayList<>(sm.keySet());
            ls.sort(comparator);
            for (Student s : ls) {
                StringBuilder sb = new StringBuilder();
                sb.append(s.getId())
                        .append(".")
                        .append(s.getName())
                        .append(": ")
                        .append(sm.get(s));
                System.out.println(sb.toString());
            }
        }


    }


    /**
     * Check if the grade enter is either A, B, C, D, F. Return true if it is.
     * @param grade The char that needs to be check
     * @return true or false
     */
    private boolean isValidGrade(char grade) {
        return "ABCDF".contains(String.valueOf(grade));
    }

}
