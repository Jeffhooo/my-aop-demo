package jeff;

import org.springframework.stereotype.Component;

@Component
public class AImpl implements A {
    public void say(String s) {
//        PerformanceRecorder.begin("jeff.A.say");
         System.out.println("A say \"" + s + "\"");
//        PerformanceRecorder.end();
    }
}
