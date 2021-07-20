package edu.sjsu.assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.*;

public class MyCollections {

    public static void printFiles(Queue <File> fileQueue) throws FileNotFoundException {
        while (!fileQueue.isEmpty())
        {
            File toPrint = fileQueue.peek();
            printFile(toPrint);
            fileQueue.poll();
        }


    }
    private static void printFile(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);

        while (input.hasNextLine())
        {
            System.out.println(input.nextLine());
        }
        System.out.println("***");
    }

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
