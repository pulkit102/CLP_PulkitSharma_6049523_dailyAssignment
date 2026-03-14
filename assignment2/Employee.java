package JDBC.assignment2;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    private int id;

    private String name;
    private double salary;
    private String department;

    @ElementCollection
    @CollectionTable(name="employee_mobile",
            joinColumns=@JoinColumn(name="emp_id"))
    @Column(name="mobile_number")
    private Set<Long> mobileNumbers;

    public Employee(){}

    public Employee(int id, String name, double salary, String department, Set<Long> mobileNumbers) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.mobileNumbers = mobileNumbers;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
    public Set<Long> getMobileNumbers() { return mobileNumbers; }

    public void setSalary(double salary) { this.salary = salary; }
}