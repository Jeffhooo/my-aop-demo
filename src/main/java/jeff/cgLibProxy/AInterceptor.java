package jeff.cgLibProxy;

import jeff.PerformanceRecorder;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class AInterceptor implements MethodInterceptor {

    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        PerformanceRecorder.begin(object.getClass().getName() + "." + method.getName());
        Object result = methodProxy.invokeSuper(object, args);
        PerformanceRecorder.end();
        return result;
    }

}
