package JDBC.assignment1;

import java.sql.*;

public class EmployeeDAO {

    Connection con;

    public EmployeeDAO() throws Exception {

        Class.forName("org.postgresql.Driver");

        con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/EmplyeeDB",
                "postgres",
                "Majorsaab1@");
    }

    // 1 Create Table
    public void createTable() throws Exception {

        Statement stmt = con.createStatement();

        stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS employee(" +
                        "id INT PRIMARY KEY," +
                        "name VARCHAR(50)," +
                        "salary INT," +
                        "department VARCHAR(50))");

        System.out.println("Table created successfully!");
    }

    // 2 Insert Data
    public void insert(Employee e) throws Exception {

        PreparedStatement ps =
                con.prepareStatement("INSERT INTO employee VALUES(?,?,?,?)");

        ps.setInt(1, e.getId());
        ps.setString(2, e.getName());
        ps.setInt(3, e.getSalary());
        ps.setString(4, e.getDepartment());

        ps.executeUpdate();

        System.out.println("Employee inserted successfully!");
    }

    // 3 Update
    public void updateSalary(int id, int salary) throws Exception {

        PreparedStatement ps =
                con.prepareStatement("UPDATE employee SET salary=? WHERE id=?");

        ps.setInt(1, salary);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();

        if(rows > 0)
            System.out.println("Salary updated!");
        else
            System.out.println("Employee not found!");
    }

    // 4 Delete
    public void delete(int id) throws Exception {

        PreparedStatement ps =
                con.prepareStatement("DELETE FROM employee WHERE id=?");

        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if(rows > 0)
            System.out.println("Employee deleted!");
        else
            System.out.println("Employee not found!");
    }

    // 5 Fetch All
    public void fetchAll() throws Exception {

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

        while(rs.next()) {

            System.out.println(
                    rs.getInt("id")+" "+
                            rs.getString("name")+" "+
                            rs.getInt("salary")+" "+
                            rs.getString("department"));
        }
    }

    // 6 Fetch by ID
    public void fetchById(int id) throws Exception {

        PreparedStatement ps =
                con.prepareStatement("SELECT * FROM employee WHERE id=?");

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {

            System.out.println(
                    rs.getInt("id")+" "+
                            rs.getString("name")+" "+
                            rs.getInt("salary")+" "+
                            rs.getString("department"));
        }
        else
            System.out.println("Employee not found!");
    }

    // 7 Drop Table
    public void dropTable() throws Exception {

        Statement stmt = con.createStatement();

        stmt.executeUpdate("DROP TABLE employee");

        System.out.println("Table dropped successfully!");
    }
}