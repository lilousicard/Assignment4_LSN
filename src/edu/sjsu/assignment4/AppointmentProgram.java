package edu.sjsu.assignment4;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;
import java.io.*;

public class AppointmentProgram {

    public static void start() {
        AppointmentManager apptManager = new AppointmentManager();
        System.out.println("Welcome to this appointment manager.");
        String input ;
        do {
            input = optionInput();
            switch (input) {
                case "a":
                    Appointment toAdd = createAppointment();
                    boolean added = apptManager.addAppointment(toAdd);
                    if (!added)
                    {
                        System.out.println("The appointment could not be added since it already exists.");
                    }
                    break;
                case "d":
                    if (apptManager.apptMap.isEmpty()) System.out.println("Sorry, there is nothing to remove.");
                    else {
                        String description;
                        boolean success = false;
                        do{
                            description=getDeleteAppointment();
                            success= apptManager.deleteAppointment(description);
                            if (!success) System.out.println("Appointment not found. Please try again!");
                        }while (!success);


                    }
                    break;
                case "v":
                    apptManager.printAppointment();
                    break;
                case "q":
                    System.out.println("GoodBye");
                    break;
                default:
                    System.out.println("Sorry, I did not understand that");
                    break;
            }
        } while (!input.equals("q"));
    }

    private static String getDeleteAppointment() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the description of the appointment you want to delete: ");
        return scan.next();

    }

    private static Appointment createAppointment() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the type (onetime, daily or monthly");
        String type = scan.next();
        String description;
        LocalDate start;
        LocalDate end;
        switch (type)
        {
            case "onetime":
                description = getDescription();
                start = getOneDate("event");
                Appointment oneTime = new OnetimeAppointment(description,start);
                return oneTime;
            case "daily":
                description = getDescription();
                start = getOneDate("start");
                end = getOneDate("end");
                Appointment daily = new DailyAppointment(description,start,end);
                return daily;
            case "monthly":
                description = getDescription();
                start = getOneDate("start");
                end = getOneDate("end");
                Appointment monthly = new MonthlyAppointment(description,start,end);
                return monthly;
            default:
                System.out.println("Sorry, wrong input! Lets try again.");
                createAppointment();
                break;

        }

        return null;
    }

    private static String getDescription() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a description");
        return scan.next();
    }

    private static LocalDate getOneDate(String info)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the "+info+" date (yyyy-mm-dd): ");
        String input = scan.next();
        try
        {
            LocalDate tDate = LocalDate.parse(input);
            return tDate;

        } catch (Exception e) {
            System.out.println("Sorry wrong date");
            //e.printStackTrace();
        }
        return getOneDate(info);
    }




    private static String optionInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What do you wish to do? Press");
        System.out.println("(a) for adding an appointment;");
        System.out.println("(d) for deleting an appointment;");
        System.out.println("(v) for viewing all appointments");
        System.out.println("(q) for quitting the program");
        String s = scan.next();
        if ("avqd".contains(s)) {
            return s;
        }
        System.out.println("Sorry, wrong option! Lets try again.");
        return optionInput();
    }

}
