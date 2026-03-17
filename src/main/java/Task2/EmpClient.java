package Task2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpClient {

    public static void main(String[] args) {

        // Load Spring context
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");

        // Get Employee bean
        Employe emp = (Employe) context.getBean("employeeBean");

        // Display details
        emp.displayDetails();

        // Close context
        ((ClassPathXmlApplicationContext) context).close();
    }
}
