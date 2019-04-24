package jeff;

public class Performance {
    private long beginTime;
    private long endTime;
    private  String method;

    public Performance(String method) {
        this.method = method;
        this.beginTime = System.currentTimeMillis();
    }

    public void printPerformance() {
        this.endTime = System.currentTimeMillis();
        long durition = endTime - beginTime;
        System.out.println(method + " takes " + durition + "ms");
    }
}
