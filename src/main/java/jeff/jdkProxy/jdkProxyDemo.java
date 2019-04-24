package jeff.jdkProxy;

import jeff.A;
import jeff.AImpl;

import java.lang.reflect.Proxy;

public class jdkProxyDemo {

    public static void main(String[] args) {
        A a = new AImpl();

        PerformanceHandler performanceHandler = new PerformanceHandler(a);

        A aopA = (A) Proxy.newProxyInstance(
                a.getClass().getClassLoader(),
                a.getClass().getInterfaces(),
                performanceHandler);

        a.say("I am a!");
        aopA.say("I am aopA!");
        System.out.println("a class name: " + a.getClass().getName());
        System.out.println("aopA class name: " + aopA.getClass().getName());
    }
}
