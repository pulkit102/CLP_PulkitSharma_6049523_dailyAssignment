package JDBC.assignment2;

import java.util.*;

public class MainClass {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        int choice;

        do{

            System.out.println("\n===== MENU =====");
            System.out.println("1 Insert Employee");
            System.out.println("2 Update Employee");
            System.out.println("3 Delete Employee");
            System.out.println("4 Fetch All");
            System.out.println("5 Fetch By Id");
            System.out.println("6 Fetch By Salary");
            System.out.println("7 Sort By Salary");
            System.out.println("8 Fetch By Mobile");
            System.out.println("9 Exit");

            choice=sc.nextInt();

            switch(choice){

                case 1:

                    System.out.println("Enter id name salary department");

                    int id=sc.nextInt();
                    String name=sc.next();
                    double sal=sc.nextDouble();
                    String dept=sc.next();

                    System.out.println("Enter number of mobile numbers");

                    int n=sc.nextInt();

                    Set<Long> mobiles=new HashSet<>();

                    for(int i=0;i<n;i++){
                        mobiles.add(sc.nextLong());
                    }

                    Employee e=new Employee(id,name,sal,dept,mobiles);

                    dao.insert(e);

                    break;

                case 2:

                    System.out.println("Enter id and new salary");

                    dao.update(sc.nextInt(),sc.nextDouble());

                    break;

                case 3:

                    System.out.println("Enter id");

                    dao.delete(sc.nextInt());

                    break;

                case 4:

                    dao.fetchAll();
                    break;

                case 5:

                    System.out.println("Enter id");

                    dao.fetchById(sc.nextInt());

                    break;

                case 6:

                    System.out.println("Enter salary");

                    dao.fetchBySalary(sc.nextDouble());

                    break;

                case 7:

                    dao.sortBySalary();
                    break;

                case 8:

                    System.out.println("Enter mobile number");

                    dao.fetchByMobile(sc.nextLong());

                    break;

            }

        }while(choice!=9);

    }
}