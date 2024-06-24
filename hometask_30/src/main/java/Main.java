import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app.xml");

        SpringClass contextBean = context.getBean(SpringClass.class);

        context.registerShutdownHook();

    }
}
