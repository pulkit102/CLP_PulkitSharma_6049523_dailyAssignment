package JDBC.assignment1;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        EmployeeDAO dao = new EmployeeDAO();

        int choice;

        do {

            System.out.println("\n==== EMPLOYEE MENU ====");
            System.out.println("1 Create Table");
            System.out.println("2 Insert Employee");
            System.out.println("3 Update Salary");
            System.out.println("4 Delete Employee");
            System.out.println("5 Fetch All Employees");
            System.out.println("6 Fetch Employee by ID");
            System.out.println("7 Drop Table");
            System.out.println("8 Exit");

            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    dao.createTable();
                    break;

                case 2:

                    System.out.print("Enter Id: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    int salary = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    Employee e = new Employee(id,name,salary,dept);

                    dao.insert(e);

                    break;

                case 3:

                    System.out.print("Enter Employee Id: ");
                    int uid = sc.nextInt();

                    System.out.print("Enter New Salary: ");
                    int ns = sc.nextInt();

                    dao.updateSalary(uid,ns);

                    break;

                case 4:

                    System.out.print("Enter Employee Id: ");
                    int did = sc.nextInt();

                    dao.delete(did);

                    break;

                case 5:

                    dao.fetchAll();

                    break;

                case 6:

                    System.out.print("Enter Employee Id: ");
                    int fid = sc.nextInt();

                    dao.fetchById(fid);

                    break;

                case 7:

                    dao.dropTable();

                    break;

                case 8:

                    System.out.println("Exiting...");
                    break;

                default:

                    System.out.println("Invalid Choice!");
            }

        } while(choice != 8);

    }
}