package JDBC.assignment3;



import java.util.*;

public class MainClass1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO1 dao = new EmployeeDAO1();

        int choice;

        do{

            System.out.println("\n===== MENU =====");
            System.out.println("1 Insert Employee");
            System.out.println("2 Fetch All Employees");
            System.out.println("3 Employee Count By Department");
            System.out.println("4 Employees By Department");
            System.out.println("5 Department Details By Mobile");
            System.out.println("6 Exit");

            choice = sc.nextInt();

            switch(choice){

                case 1:

                    System.out.println("Enter Employee id name salary");

                    int id = sc.nextInt();
                    String name = sc.next();
                    double salary = sc.nextDouble();

                    System.out.println("Enter Department id name managerName");

                    int did = sc.nextInt();
                    String dname = sc.next();
                    String manager = sc.next();

                    Department1 d =
                            new Department1(did,dname,manager);

                    System.out.println("Enter number of mobile numbers");

                    int n = sc.nextInt();

                    Set<Long> mobiles = new HashSet<>();

                    for(int i=0;i<n;i++){

                        mobiles.add(sc.nextLong());
                    }

                    Employee1 e =
                            new Employee1(id,name,salary,mobiles,d);

                    dao.insertEmployee(e);

                    break;

                case 2:

                    dao.fetchAllEmployees();

                    break;

                case 3:

                    dao.employeeCountByDepartment();

                    break;

                case 4:

                    System.out.println("Enter Department name");

                    dao.employeesByDepartment(sc.next());

                    break;

                case 5:

                    System.out.println("Enter Mobile number");

                    dao.departmentByMobile(sc.nextLong());

                    break;

            }

        }while(choice!=6);

    }
}
