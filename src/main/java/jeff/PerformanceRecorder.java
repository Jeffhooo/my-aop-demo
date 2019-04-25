package jeff;

public class PerformanceRecorder {

    private static ThreadLocal<Performance> performance = new ThreadLocal<Performance>();

    public static void begin(String method) {
        System.out.println("Begin record...");
        Performance p = new Performance(method);
        performance.set(p);
    }

    public static void end() {
        System.out.println("End record...");
        Performance p = performance.get();
        p.printPerformance();
    }
}
