package Task3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpClient {

    public static void main(String[] args) {


        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext3.xml");


        SBU sbu = (SBU) context.getBean("sbuBean");


        sbu.displayDetails();

        ((ClassPathXmlApplicationContext) context).close();
    }
}