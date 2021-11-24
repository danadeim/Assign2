package Employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


public final class Manager extends Worker {

    // attributes
    // * subordinates (a list of immediate subordinates)
    // * all subordinates (derived --- i.e. calculated on the fly --- a list of subordinates in all hierarchy)
    private List<Employee> _subordinates;
    public Manager(String firstName , String surName, LocalDate date, BigDecimal salary, Manager manager,
                   LocalDate employmentdate , BigDecimal bonus, List<Employee> subordinates) {
        super(firstName,surName,date, salary,manager,employmentdate,bonus);
        _subordinates = subordinates;
    }
    public List<Employee> getSub(){
        return _subordinates;
    }

    public void setSubordinates(List<Employee> _subordinates) {
        this._subordinates = _subordinates;
    }
}
