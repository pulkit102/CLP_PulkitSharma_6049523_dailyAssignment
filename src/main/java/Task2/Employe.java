package Task2;

public class Employe {

    private int employeeId;
    private String employeeName;
    private double salary;
    private SBU businessUnit;   // ← SBU object injected here!

    // Default Constructor
    public Employe() {}

    // Getters & Setters
    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public SBU getBusinessUnit() { return businessUnit; }
    public void setBusinessUnit(SBU businessUnit) { this.businessUnit = businessUnit; }

    // Method to get SBU details
    public SBU getSbuDetails() {
        return businessUnit;
    }

    // Display method
    public void displayDetails() {
        System.out.println("Employee details");
        System.out.println("----------------------");
        System.out.println("Employee [empAge=40, empId=" + employeeId +
                ", empName=" + employeeName +
                ", empSalary=" + salary + "]");
        System.out.println("sbu details=" + getSbuDetails());
    }
}