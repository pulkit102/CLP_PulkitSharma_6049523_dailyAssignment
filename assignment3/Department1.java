package JDBC.assignment3;

import javax.persistence.*;
import java.util.List;

@Entity
public class Department1 {

    @Id
    private int id;

    private String name;

    private String managerName;

    // One department has many employees
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee1> employees;

    public Department1() {
    }

    public Department1(int id, String name, String managerName) {
        this.id = id;
        this.name = name;
        this.managerName = managerName;
    }

    // Getters and Setters

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


    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }


    public List<Employee1> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee1> employees) {
        this.employees = employees;
    }
}