package jeff.SpringAopProxy;

import jeff.PerformanceRecorder;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

public class SpringAInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object target = methodInvocation.getThis();
        Method method = methodInvocation.getMethod();
        PerformanceRecorder.begin(target.getClass().getName() + "." + method.getName());
        Object object = methodInvocation.proceed();
        PerformanceRecorder.end();
        return object;
    }

}
