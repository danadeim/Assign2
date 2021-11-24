import Employee.Employee;
import Employee.Manager;
import Employee.Trainee;
import Employee.Worker;
import Payroll.PayrollEntry;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public final class HumanResourcesStatistics {

    public static List<PayrollEntry> payroll(List<Employee> employees) {
        if (employees == null)
            return null;
        return employees
                .stream()
                .map(HumanResourcesStatistics::payrollEntry)
                .collect(Collectors.toList());
    }

    public static BigDecimal traineeCheckForBonus(Employee e) {
        return e instanceof Trainee ? BigDecimal.ZERO : ((Worker) e).getBonus();
    }

    private static PayrollEntry payrollEntry(Employee e) {
        if (e == null)
            return null;
        // BigDecimal bonus = e instanceof Trainee ? BigDecimal.valueOf(0) : ((Worker)e).getBonus();
        return new PayrollEntry(e, e.getsal(), traineeCheckForBonus(e));
    }

    // payroll for all subordinates
    public static List<PayrollEntry> subordinatesPayroll(Manager manager) {
        if (manager == null)
            return null;
        List<Employee> employees = manager.getSub();
        return payroll(employees);
    }

    public static BigDecimal bonusTotal(List<Employee> employees) {
        if (employees == null)
            return null;
        return employees
                .stream()
                .map(e -> e instanceof Trainee ? BigDecimal.valueOf(0) : ((Worker) e).getBonus())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static Employee longestSeniority(List<Employee> employees) {
        return employees
                .stream()
                .filter(e -> e instanceof Worker)
                .reduce(null, HumanResourcesStatistics::maxSeniority);
    }

    public static BigDecimal largestSalaryWithoutBonus(List<Employee> employees) {
        return employees
                .stream()
                .map(Employee::getsal)
                .reduce(BigDecimal.ZERO, HumanResourcesStatistics::biggestSalary);
    }

    public static BigDecimal largestSalaryWithBonus(List<Employee> employees) {
        return employees
                .stream()
                .map(e -> e instanceof Trainee ? e.getsal() : e.getsal().add(((Worker) e).getBonus()))
                .reduce(BigDecimal.ZERO, HumanResourcesStatistics::biggestSalary);
    }

    public static List<Employee> namesStartWithA(Manager manager) {
        List<Employee> employees = manager.getSub();
        return employees
                .stream()
                .filter(e -> e.getSurName().startsWith("A"))
                .collect(Collectors.toList());
    }

    public static List<Employee> earnMoreThan1000(List<Employee> employees) {
        return employees
                .stream()
                .filter(e -> e.getsal().intValue() > 1000)
                .collect(Collectors.toList());
    }

    public static Employee maxSeniority(Employee emp1, Employee emp2) {
        if (emp1 == null)
            return emp2;
        if (((Worker) emp1).getEdate().isAfter(((Worker) emp2).getEdate()))
            return emp2;
        else
            return emp1;
    }

    public static BigDecimal biggestSalary(BigDecimal s1, BigDecimal s2) {
        return s1.compareTo(s2) < 0 ? s2 : s1;

    }
}

