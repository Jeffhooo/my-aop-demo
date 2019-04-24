package jeff.cgLibProxy;

import jeff.PerformanceRecorder;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class AProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        PerformanceRecorder.begin(object.getClass().getName() + "." + method.getName());
        Object result = methodProxy.invokeSuper(object, args);
        PerformanceRecorder.end();
        return result;
    }
}
