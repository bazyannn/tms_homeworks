import lombok.NoArgsConstructor;
import org.springframework.beans.factory.BeanNameAware;


public class SpringClass implements BeanNameAware {

    public SpringClass() {
        System.out.println("phase 1 constructor");
    }

    public void init(){
        System.out.println("phase 2 constructor - init message");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanName for: " + name);
    }

    public void destroy() {
        System.out.println("Destroy this Bean");
    }



}
