package JDBC.assignment2;

import javax.persistence.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class EmployeeDAO {
    public EmployeeDAO() throws Exception {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/EmplyeeDB",
                "postgres",
                "Majorsaab1@");
    }

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("JPA-PU");

    EntityManager em = emf.createEntityManager();

    // 1 Insert
    public void insert(Employee e){

        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(e);

        et.commit();

        System.out.println("Employee inserted successfully");
    }

    // 2 Update
    public void update(int id,double salary){

        EntityTransaction et = em.getTransaction();
        et.begin();

        Employee e = em.find(Employee.class,id);

        if(e!=null){
            e.setSalary(salary);
            System.out.println("Salary updated");
        }else{
            System.out.println("Employee not found");
        }

        et.commit();
    }

    // 3 Delete
    public void delete(int id){

        EntityTransaction et = em.getTransaction();
        et.begin();

        Employee e = em.find(Employee.class,id);

        if(e!=null){
            em.remove(e);
            System.out.println("Employee deleted");
        }else{
            System.out.println("Employee not found");
        }

        et.commit();
    }

    // 4 Fetch All
    public void fetchAll(){

        Query q = em.createQuery("from Employee");

        List<Employee> list = q.getResultList();

        for(Employee e:list){
            System.out.println(e.getId()+" "+e.getName()+" "+e.getSalary()+" "+e.getDepartment()+" "+e.getMobileNumbers());
        }
    }

    // 5 Fetch By Id
    public void fetchById(int id){

        Employee e = em.find(Employee.class,id);

        if(e!=null)
            System.out.println(e.getId()+" "+e.getName()+" "+e.getSalary()+" "+e.getDepartment()+" "+e.getMobileNumbers());
        else
            System.out.println("Employee not found");
    }

    // 6 Fetch By Salary
    public void fetchBySalary(double salary){

        Query q = em.createQuery("from Employee where salary=?1");

        q.setParameter(1,salary);

        List<Employee> list = q.getResultList();

        for(Employee e:list)
            System.out.println(e.getId()+" "+e.getName()+" "+e.getSalary());
    }

    // 7 Sorted by Salary
    public void sortBySalary(){

        Query q = em.createQuery("from Employee order by salary");

        List<Employee> list = q.getResultList();

        for(Employee e:list)
            System.out.println(e.getId()+" "+e.getName()+" "+e.getSalary());
    }

    // 8 Fetch by Mobile Number
    public void fetchByMobile(long mobile){

        Query q = em.createQuery(
                "select e from Employee e join e.mobileNumbers m where m=?1");

        q.setParameter(1,mobile);

        List<Employee> list = q.getResultList();

        for(Employee e:list)
            System.out.println(e.getId()+" "+e.getName()+" "+e.getSalary());
    }
}