package Employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;


public class Trainee extends Employee {

    // attributes:
    // * apprenticeship start date
    // * apprenticeship length (in days)
    private LocalDate _startdate;
    private int _applength;

    public Trainee(String firstName , String surName, LocalDate date, BigDecimal salary, Manager manager, LocalDate startdate, int applength) {

        super(firstName,surName,date,salary,manager);
        _applength = applength;
        _startdate = startdate;
    }

}
