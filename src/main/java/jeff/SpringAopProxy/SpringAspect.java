package jeff.SpringAopProxy;

import jeff.PerformanceRecorder;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.lang.reflect.Method;

@Aspect
public class SpringAspect {

    @Before("execution(* say(..)) && target(jeff.AImpl)")
    public void beforeSay() {
        PerformanceRecorder.begin("jeff.AImpl.say");
    }

    @After("execution(* say(..)) && target(jeff.AImpl)")
    public void afterSay() {
        PerformanceRecorder.end();
    }
}
