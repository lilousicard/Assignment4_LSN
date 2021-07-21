package edu.sjsu.assignment4;


import java.util.*;

public class AppointmentManager {
    Map <String,Appointment> apptMap = new TreeMap<>();
    public boolean addAppointment(Appointment appointment)
    {
        if (!apptMap.containsKey(appointment.getDescription()))
        {
            apptMap.put(appointment.getDescription(),appointment);
            return true;
        }
        return false;

    }

    public boolean deleteAppointment (String appointment)
    {
        if (apptMap.containsKey(appointment))
        {
            apptMap.remove(appointment);
            return true;
        }
        return false;

    }

    public void printAppointment()
    {
        if(apptMap.isEmpty())
        {
            System.out.println("No appointment now.");
        }
        else
        {
            for(Map.Entry<String,Appointment> entry: apptMap.entrySet())
            {
               System.out.println(entry.getValue().toString());
            }
        }
    }

}
