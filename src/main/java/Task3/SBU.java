package Task3;

import java.util.List;

public class SBU {

    private String sbuCode;
    private String sbuName;
    private String sbuHead;
    private List<Employee1> empList;   // ← Employee1 here

    public SBU() {}

    public String getSbuCode() { return sbuCode; }
    public void setSbuCode(String sbuCode) { this.sbuCode = sbuCode; }

    public String getSbuName() { return sbuName; }
    public void setSbuName(String sbuName) { this.sbuName = sbuName; }

    public String getSbuHead() { return sbuHead; }
    public void setSbuHead(String sbuHead) { this.sbuHead = sbuHead; }

    public List<Employee1> getEmpList() { return empList; }
    public void setEmpList(List<Employee1> empList) { this.empList = empList; }

    public void displayDetails() {
        System.out.println("SBU details");
        System.out.println("----------------------");
        System.out.println("sbuCode=" + sbuCode +
                ", sbuHead=" + sbuHead +
                ", sbuName=" + sbuName);
        System.out.println("Employee details:--------------");
        for (Employee1 emp : empList) {
            System.out.println(emp);
        }
    }
}