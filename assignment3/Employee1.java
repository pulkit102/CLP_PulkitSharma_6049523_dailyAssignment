package JDBC.assignment3;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee1 {

    @Id
    private int id;

    private String name;
    private double salary;

    @ElementCollection
    @CollectionTable(name="employee_mobile",
            joinColumns=@JoinColumn(name="emp_id"))
    private Set<Long> mobileNumbers;

    @ManyToOne
    @JoinColumn(name="dept_id")
    private Department1 department;

    public Employee1(){}

    public Employee1(int id, String name, double salary,
                     Set<Long> mobileNumbers, Department1 department){

        this.id=id;
        this.name=name;
        this.salary=salary;
        this.mobileNumbers=mobileNumbers;
        this.department=department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    public Set<Long> getMobileNumbers() {
        return mobileNumbers;
    }

    public void setMobileNumbers(Set<Long> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }


    public Department1 getDepartment() {
        return department;
    }

    public void setDepartment(Department1 department) {
        this.department = department;
    }
}
