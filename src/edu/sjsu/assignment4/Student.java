package edu.sjsu.assignment4;

public class Student implements Comparable<Student> {

    private int id;
    private String name;

    /** Create an unnamed student with an id
     * @param id Student id
     */
    public Student (int id)
    {
        this.id = id;
        this.name = "Unnamed";

    }

    /** Create a named student with an id
     * @param id student id
     * @param name student's name
     */
    public Student (int id, String name){
        this.id = id;
        this.name = name;
    }

    /**
     * return the id of the student object
     * @return Student id
     */
    public int getId() {
        return id;
    }

    /**
     * return the name of the student
     * @return student name
     */
    public String getName() {
        return name;
    }


    /** compare student object by id
     * @param o student to be compare to
     * @return id difference
     */
    @Override
    public int compareTo(Student o) {
       if (this.id!=o.id) return this.id-o.id;
       else return 0;
       //else return this.name.compareTo(o.name);
    }
}
