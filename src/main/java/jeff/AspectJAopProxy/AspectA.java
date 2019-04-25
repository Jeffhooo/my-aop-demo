package jeff.AspectJAopProxy;

import jeff.PerformanceRecorder;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectA {

    @Before("execution(* say(..)) && target(jeff.AImpl)")
    public void beforeSay() {
        PerformanceRecorder.begin("jeff.AImpl.say");
    }

    @After("execution(* say(..)) && target(jeff.AImpl)")
    public void afterSay() {
        PerformanceRecorder.end();
    }
}
