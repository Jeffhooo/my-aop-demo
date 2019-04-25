package jeff.jdkProxy;

import jeff.A;
import jeff.AImpl;

import java.lang.reflect.Proxy;

public class jdkProxyDemo {

    public static void main(String[] args) {
        // create common A
        A a = new AImpl();

        // weave methods to A with jdk proxy
        PerformanceHandler performanceHandler = new PerformanceHandler(a);
        A aopA = (A) Proxy.newProxyInstance(
                a.getClass().getClassLoader(),
                a.getClass().getInterfaces(),
                performanceHandler);

        // test
        a.say("I am a!");
        aopA.say("I am aopA!");
        System.out.println("a class name: " + a.getClass().getName());
        System.out.println("aopA class name: " + aopA.getClass().getName());

//        console output:
//        A say "I am a!"
//        Begin record...
//        A say "I am aopA!"
//        End record...
//        jeff.AImpl.say takes 1ms
//        a class name: jeff.AImpl
//        aopA class name: com.sun.proxy.$Proxy0
    }
}
