import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import Employee.Employee;
import Employee.Manager;
import Employee.Trainee;
import Employee.Worker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class HumanResourcesStatisticsTest {
    private Manager d, m1, m2;
    private Worker w1, w2, w3, w4, w5;
    private Trainee t1, t2, t3, t4;
    private LinkedList<Employee> dSub;
    private LinkedList<Employee> m1Sub;
    private LinkedList<Employee> m2Sub;
    private List<Employee> _allEmployees;


    @Before
    public void emp() {
        d = new Manager("Valerie", "Thomson", LocalDate.of(1969,4,20),
                new BigDecimal(15000), null, LocalDate.of(2004, 6, 11),
                new BigDecimal(4000), dSub);


        m1 = new Manager("Courtney ", "Mall", LocalDate.of(1976,3,17),
                new BigDecimal(12000), null, LocalDate.of(2010, 12, 28),
                new BigDecimal(3200), m1Sub);

        m2 = new Manager("Mandrew", "Joseph", LocalDate.of(1966,6,6),
                new BigDecimal(12000), null, LocalDate.of(2008, 4, 10),
                new BigDecimal(1200), m2Sub);


        w1 = new Worker("Patricia", "Martel", LocalDate.of(1990, 7, 3),
                new BigDecimal(500), m1, LocalDate.of(2015, 7, 4), new BigDecimal(300));

        w2 = new Worker("Katherine ", "Zam", LocalDate.of(1974, 2, 7),
                new BigDecimal(450), m1, LocalDate.of(2013, 10, 23), new BigDecimal(200));

        w3 = new Worker("Victoria", "Ard", LocalDate.of(1980, 1, 3),
                new BigDecimal(600), m2, LocalDate.of(2018, 8, 3), new BigDecimal(200));

        w4 = new Worker("Dorothy", "Rin", LocalDate.of(1964, 6, 4),
                new BigDecimal(350), d, LocalDate.of(2009, 3, 3), new BigDecimal(360));

        w5 = new Worker("Jodie", "Foster", LocalDate.of(1989, 10, 16),
                new BigDecimal(300), d, LocalDate.of(2014, 8, 10), new BigDecimal(315));


        t1 = new Trainee("Neigh", "Tran", LocalDate.of(1978, 8, 27),
                new BigDecimal(200), m1, LocalDate.of(2021, 1, 5), 30);

        t2 = new Trainee("Angela", "Aens", LocalDate.of(1989, 7, 7),
                new BigDecimal(200), m2, LocalDate.of(2021, 8, 11), 40);

        t3 = new Trainee("Kylie", "Sonson", LocalDate.of(1999, 10, 2),
                new BigDecimal(200), m2, LocalDate.of(2021, 9, 4), 20);

        t4 = new Trainee("Carol", "Chaning", LocalDate.of(1962, 2, 12),
                new BigDecimal(200), d, LocalDate.of(2021, 10, 12), 50);


        dSub = new LinkedList<>();
        dSub.add(w4);
        dSub.add(w5);
        dSub.add(t4);
        d.setSubordinates(dSub);


        m1Sub = new LinkedList<>();
        m1Sub.add(w1);
        m1Sub.add(w2);
        m1Sub.add(t1);
        m1.setSubordinates(m1Sub);


        m2Sub = new LinkedList<>();
        m2Sub.add(w3);
        m2Sub.add(t2);
        m2Sub.add(t3);
        m2.setSubordinates(m2Sub);


        _allEmployees = new LinkedList<>();
        _allEmployees.add(d);
        _allEmployees.add(m1); _allEmployees.add(m2);
        _allEmployees.add(w1); _allEmployees.add(w2); _allEmployees.add(w3); _allEmployees.add(w4); _allEmployees.add(w5);
        _allEmployees.add(t1); _allEmployees.add(t2); _allEmployees.add(t3); _allEmployees.add(t4);
    }


    @Test
    public void payroll() {
        HumanResourcesStatistics.payroll(_allEmployees);
    }


    @Test
    public void subordinatesPayroll() {
        HumanResourcesStatistics.subordinatesPayroll(m1);
    }


    @Test
    public void bonusTotal() {
        BigDecimal total = HumanResourcesStatistics.bonusTotal(_allEmployees);
        Assert.assertEquals(new BigDecimal("9775"), total);
    }

    @Test
    public void longestSeniority() {
        Employee e = HumanResourcesStatistics.longestSeniority(_allEmployees);
        Assert.assertSame(d, e);
    }

    @Test
    public void largestSalaryWithoutBonus() {
        BigDecimal result = HumanResourcesStatistics.largestSalaryWithoutBonus(_allEmployees);
        Assert.assertEquals(15000, result.intValue());
    }

    @Test
    public void largestSalaryWithBonus() {
        BigDecimal result = HumanResourcesStatistics.largestSalaryWithBonus(_allEmployees);
        Assert.assertEquals(19000, result.intValue());
    }

    @Test
    public void namesStartWithA() {
        LinkedList<Employee> startsWithA = new LinkedList<>();
        startsWithA.add(w3);
        startsWithA.add(t2);
        Assert.assertEquals(startsWithA, HumanResourcesStatistics.namesStartWithA(m2));
    }

    @Test
    public void earnMoreThan1000() {
        List<Employee> more1000 = new LinkedList<>();
        more1000.add(d); more1000.add(m1); more1000.add(m2);
        Assert.assertEquals(more1000, HumanResourcesStatistics.earnMoreThan1000(_allEmployees));
    }
}