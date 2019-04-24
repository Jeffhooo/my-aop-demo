package jeff.cgLibProxy;

import jeff.A;
import jeff.AImpl;

public class cgLibProxyDemo {

    public static void main(String[] args) {
        A a = new AImpl();

        AProxy proxy = new AProxy();
        A aopA = (A) proxy.getProxy(AImpl.class);

        a.say("I am a!");
        aopA.say("I am aopA!");
        System.out.println("a class name: " + a.getClass().getName());
        System.out.println("aopA class name: " + aopA.getClass().getName());
    }
}
