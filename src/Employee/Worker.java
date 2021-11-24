package Employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;


public class Worker extends Employee {

    // attributes
    // * employment date
    // * bonus
    private LocalDate _employmentdate;
    private BigDecimal _bonus;

    public Worker(String firstName , String surName, LocalDate date,BigDecimal salary, Manager manager, LocalDate employmentdate,BigDecimal bonus) {

        super(firstName,surName,date,salary,manager);
        _employmentdate = employmentdate;
        _bonus = bonus;
    }
    public LocalDate getEdate(){
        return _employmentdate;
    }
    public BigDecimal getBonus(){
        return _bonus;
    }
}
