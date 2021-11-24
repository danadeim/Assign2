package Employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Employee extends Person {

    //
    // attributes:
    // * salary (use BigDecimal type for representing currency values)
    // * manager (empty if at top of hierarchy)
    private BigDecimal _salary;
    private Manager _manager;
    protected Employee(String firstName , String surName, LocalDate date ,BigDecimal salary, Manager manager) {
        super(firstName , surName , date);
        _salary = salary;
        _manager = manager;
    }
    public BigDecimal getsal(){
        return _salary;
    }
    public Manager getmanager(){
        return _manager;
    }
}