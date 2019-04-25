package jeff.AspectJAopProxy;

import jeff.A;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectJAopDemo {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        A a = (A) context.getBean("a");
        a.say("I am a!");
        System.out.println("a class name: " + a.getClass().getName());

//        console output:
//        Begin record...
//        A say "I am a!"
//        End record...
//        jeff.AImpl.say takes 0ms
//        a class name: com.sun.proxy.$Proxy9
    }
}
