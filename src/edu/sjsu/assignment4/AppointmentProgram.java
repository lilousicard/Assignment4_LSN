package edu.sjsu.assignment4;

import java.time.LocalDate;
import java.util.*;


public class AppointmentProgram {

    /**
     * This function is use to run the entire program. It is called in main and contain the entire idea of the
     * program. The main menu is display has long as the user do not wish to quit.
     */
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

    /**
     * This function is used to get the user input on the appointment description to then delete the appointment
     * @return the user input
     */
    private static String getDeleteAppointment() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the description of the appointment you want to delete: ");
        return scan.next();

    }

    /**
     * Create a new appointment using user input. The user input is check only once since other function take care of
     * most of input check. It return the newly created appointment.
     * @return The new appointment
     */
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

    /**
     * Use to get the user input for the appointment's description
     * @return the user input
     */
    private static String getDescription() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a description");
        return scan.next();
    }

    /**
     * Use to get the user input on a date and check if this one is valid before returning it
     * @param info The string describing which date will be updated
     * @return a local date
     */
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


    /**
     * Main menu display and get the user input to keep the program going. Also check the user input before returning it
     * @return User input
     */
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
