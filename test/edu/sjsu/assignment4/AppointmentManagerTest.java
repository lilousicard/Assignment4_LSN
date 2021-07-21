package edu.sjsu.assignment4;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentManagerTest {

    @Test
    void addAppointment() {
        AppointmentManager test = new AppointmentManager();
        LocalDate startDate = LocalDate.parse("2021-06-01");
        LocalDate endDate = LocalDate.parse("2021-08-05");
        Appointment coffee= new DailyAppointment("Coffee",startDate,endDate);
        Appointment Alphabet = new MonthlyAppointment("Coffee", startDate,endDate);
        test.addAppointment(coffee);
        assertFalse(test.addAppointment(Alphabet));
    }

    @Test
    void deleteAppointment() {
    }

    @Test
    void printAppointment() {
        AppointmentManager test = new AppointmentManager();
        LocalDate startDate = LocalDate.parse("2021-06-01");
        LocalDate endDate = LocalDate.parse("2021-08-05");
        Appointment coffee= new DailyAppointment("Coffee",startDate,endDate);
        Appointment Alphabet = new MonthlyAppointment("ACoffee", startDate,endDate);
        test.addAppointment(coffee);
        test.addAppointment(Alphabet);
        for (int i = 0; i < 50; i++) {
            test.addAppointment(new DailyAppointment("appt"+i, startDate, endDate));
        }
        test.printAppointment();
        test.deleteAppointment("Coffee");
        test.printAppointment();

    }
}