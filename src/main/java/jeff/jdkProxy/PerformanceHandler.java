package jeff.jdkProxy;

import jeff.PerformanceRecorder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformanceHandler implements InvocationHandler {

    private Object target;

    public PerformanceHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceRecorder.begin(target.getClass().getName() + "." + method.getName());
        Object object = method.invoke(target, args);
        PerformanceRecorder.end();
        return object;
    }
}
