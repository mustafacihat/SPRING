import interfaces.Mentor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class CybertekApp {


    public static void main(String[] args) {
        //BeanFactory container = new ClassPathXmlApplicationContext("config.xml");

        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

        Mentor mentor = (Mentor)container.getBean("fullTimeMentor");
        mentor.createAccount();

        Mentor mentor1 = container.getBean("partTimeMentor",Mentor.class);
        mentor1.createAccount();
    }
}
