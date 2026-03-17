package JDBC.assignment3;



import javax.persistence.*;
import java.util.*;

public class EmployeeDAO1 {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("JPA-PU");

    EntityManager em = emf.createEntityManager();

    // 1 Insert Employee
    public void insertEmployee(Employee1 e){

        EntityTransaction et = em.getTransaction();
        et.begin();

        Department1 d = e.getDepartment();

        Department1 existingDept = em.find(Department1.class, d.getId());

        if(existingDept == null){
            em.persist(d);   // save department first
        } else {
            e.setDepartment(existingDept);
        }

        em.persist(e);

        et.commit();

        System.out.println("Employee inserted successfully");
    }

    // 2 Fetch all employees with department details
    public void fetchAllEmployees(){

        Query q = em.createQuery("from Employee1");

        List<Employee1> list = q.getResultList();

        for(Employee1 e : list){

            System.out.println(
                    e.getId()+" "+
                            e.getName()+" "+
                            e.getSalary()+" "+
                            e.getDepartment().getName()+" "+
                            e.getDepartment().getManagerName()
            );
        }
    }

    // 3 Number of employees in each department
    public void employeeCountByDepartment(){

        Query q = em.createQuery(
                "select e.department.name, count(e) from Employee1 e group by e.department.name");

        List<Object[]> list = q.getResultList();

        for(Object[] obj : list){

            System.out.println(
                    "Department: "+obj[0]+"  Employees: "+obj[1]
            );
        }
    }

    // 4 Employees by department name
    public void employeesByDepartment(String deptName){

        Query q = em.createQuery(
                "select e from Employee1 e where e.department.name=?1");

        q.setParameter(1, deptName);

        List<Employee1> list = q.getResultList();

        for(Employee1 e : list){

            System.out.println(
                    e.getId()+" "+
                            e.getName()+" "+
                            e.getSalary()+" "+
                            e.getDepartment().getName()
            );
        }
    }

    // 5 Fetch department details using mobile number
    public void departmentByMobile(long mobile){

        Query q = em.createQuery(
                "select e from Employee1 e join e.mobileNumbers m where m=?1");

        q.setParameter(1, mobile);

        List<Employee1> list = q.getResultList();

        for(Employee1 e : list){

            Department1 d = e.getDepartment();

            System.out.println(
                    "Employee Id: "+e.getId()+
                            " Name: "+e.getName()+
                            " Department: "+d.getName()+
                            " Manager: "+d.getManagerName()
            );
        }
    }

}
