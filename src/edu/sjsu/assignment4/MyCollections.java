package edu.sjsu.assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.*;

public class MyCollections {

    /**
     * print the content of a collection of file
     * @param fileQueue the collection of file
     * @throws FileNotFoundException
     */
    public static void printFiles(Queue <File> fileQueue) throws FileNotFoundException {
        while (!fileQueue.isEmpty())
        {
            File toPrint = fileQueue.peek();
            printFile(toPrint);
            fileQueue.poll();
        }
    }

    /**
     * Print the content of a file
     * @param file file whose content need to be printed
     * @throws FileNotFoundException
     */
    private static void printFile(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);

        while (input.hasNextLine())
        {
            System.out.println(input.nextLine());
        }
        System.out.println("***");
    }

    /**
     * to remove every nth element of a collection of employee names
     * @param name the linked list that will be downsize
     * @param n the index of removal
     */
    public static void downsize(LinkedList<String> name, int n)
    {
        ListIterator<String> iterator = name.listIterator();
        int index = 1;
        while (iterator.hasNext())
        {
            iterator.next();
            if (index%n==0)
            {
                iterator.remove();
            }
            index++;
        }


    }

    /**
     * Check that the ( and [ character are balance and mathematically correct
     * @param input the string to check if it is balance
     * @return true or false if it is balance or not
     */
    public static boolean isBalanced(String input){
        Stack<Character> list = new Stack<>();
        // navigate the entire string
        for (int index = 0; index<input.length();index++)
        {
            char temp = input.charAt(index);
            // push ( and [ character no matter which one it is
            if (temp == '(' || temp == '[' )
            {
                list.push(temp);
            }
            // if temp is ), check that the peek returns (
            else if (temp == ')')
            {
                if (list.peek()!='(')
                {
                    return false;
                }
                else
                {
                    list.pop();
                }

            }
            else if (temp == ']')
            {
                if (list.peek()!='[')
                {
                    return false;
                }
                else
                {
                    list.pop();
                }
            }
        }

        return list.isEmpty();
    }


}
