package edu.sjsu.assignment4;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static edu.sjsu.assignment4.MyCollections.downsize;
import static edu.sjsu.assignment4.MyCollections.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class MyCollectionsTest {


    @Test
    void printFilesTest() {
        Queue<File> test = new LinkedList<>();
        test.add(new File("./file1"));
        test.add(new File("./file2"));
        try {
            MyCollections.printFiles(test);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    void downsizeTest() {
        String [] array = {"Tom", "Bob", "Cathy", "Alice", "Trudy", "Harry", "Denny"};
        String [] test = {"Tom", "Bob",  "Alice", "Trudy",  "Denny"};
        List<String> l = Arrays.asList(array);
        List<String> l2 = Arrays.asList(test);
        LinkedList<String> s = new LinkedList<>();
        LinkedList<String> testList = new LinkedList<>();
        s.addAll(l);
        testList.addAll(l2);




        downsize(s,3);
        assertEquals(testList,s);


    }

    @Test
    void isBalancedTest() {
        String test1 = "((([[[]]])))";//should return true
        String test2 = "(([))]"; // should return false
        String test3 = "(((()))";// should return false
        String test4 = "(([[]]))"; //should return true

        assertTrue(isBalanced(test1));
        assertTrue(isBalanced(test4));
        assertFalse(isBalanced(test2));
        assertFalse(isBalanced(test3));




    }
}