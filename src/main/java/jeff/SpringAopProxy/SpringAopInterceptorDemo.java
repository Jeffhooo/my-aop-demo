package jeff.SpringAopProxy;

import jeff.A;
import jeff.AImpl;
import org.springframework.aop.framework.ProxyFactory;

public class SpringAopInterceptorDemo {

    public static void main(String[] args) {
        // create a common A
        A a = new AImpl();

        // weave methods to A with proxyFactory
        ProxyFactory proxyFactory = new ProxyFactory(a);
        proxyFactory.addAdvice(new SpringAInterceptor());
        proxyFactory.setProxyTargetClass(false);
        A aopA = (A) proxyFactory.getProxy();

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
//        jeff.AImpl.say takes 0ms
//        a class name: jeff.AImpl
//        aopA class name: com.sun.proxy.$Proxy0
    }
}
