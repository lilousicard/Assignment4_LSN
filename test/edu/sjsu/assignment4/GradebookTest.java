package edu.sjsu.assignment4;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class GradebookTest {



    @Test
    void addStudentTest() {
        Gradebook test = new Gradebook();
        assertTrue(test.addStudent(1010,"Helen",'A'));
        assertFalse(test.addStudent(1010,"John",'B'));
        
    }

    @Test
    void deleteStudentTest() {
        Gradebook test = new Gradebook();
        test.addStudent(1010,"Helen",'A');
        test.addStudent(1020,"Helen",'A');
        assertTrue(test.deleteStudent(1010));
        assertFalse(test.deleteStudent(1021));
        assertFalse(test.sm.isEmpty());
        assertTrue(test.deleteStudent(1020));
        assertTrue(test.sm.isEmpty());



    }

    @Test
    void addStudent() {
    }

    @Test
    void testAddStudent() {
    }

    @Test
    void deleteStudent() {
    }

    @Test
    void updateGrade() {
    }

    @Test
    void printGradeTest() {
        Gradebook test = new Gradebook();
        test.addStudent(1010,"Helen",'A');
        test.addStudent(1020,"John",'B');
        test.addStudent(1013, "Maria", 'C');
        //test.printGrade();


    }
}