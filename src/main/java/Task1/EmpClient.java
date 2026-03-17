package Task1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpClient {

    public static void main(String[] args) {

        // Load Spring context
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get Employee bean — values already injected by Spring!
        Employee emp = (Employee) context.getBean("employeeBean");

        // Display all values
        emp.displayDetails();

        // Close context
        ((ClassPathXmlApplicationContext) context).close();
    }
}