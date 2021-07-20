package edu.sjsu.assignment4;

public class Student implements Comparable<Student> {

    private int id;
    private String name;

    public Student (int id)
    {
        this.id = id;
        this.name = "Unnamed";

    }
    public Student (int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    @Override
    public int compareTo(Student o) {
        return this.id-o.id;
    }
}
