package edu.sjsu.assignment4;

import java.util.*;

public class Gradebook {
    TreeMap<Student,Character> sm;
    public Gradebook(){
        sm = new TreeMap<Student,Character>();
    }

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


    public boolean addStudent(int id, String name)
    {
        return addStudent(id, name, 'N');
    }

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

    public void printGrade(Comparator<Student> comparator)
    {
        //TODO
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




    private boolean isValidGrade(char grade) {
        return "ABCDF".contains(String.valueOf(grade));
    }
    private boolean isEmpty()
    {
        return sm.isEmpty();
    }

}
