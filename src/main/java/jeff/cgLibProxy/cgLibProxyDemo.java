package jeff.cgLibProxy;

import jeff.A;
import jeff.AImpl;

public class cgLibProxyDemo {

    public static void main(String[] args) {
        // create a common A
        A a = new AImpl();

        // Weave method to A with cgLib proxy
        AProxy proxy = new AProxy();
        A aopA = (A) proxy.getProxy(AImpl.class);

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
//        jeff.AImpl$$EnhancerByCGLIB$$2950523e.say takes 23ms
//        a class name: jeff.AImpl
//        aopA class name: jeff.AImpl$$EnhancerByCGLIB$$2950523e
    }
}
