package pub.benny.test.thread;

import java.util.List;

public class VirtualThreadTest {
    public static void main(String[] args) throws InterruptedException {
        var list = List.of(10, 20, 30, 40, 50);
        for (Integer item : list) {
            var vt = Thread.ofVirtual().name("vt-" + item);
            vt.uncaughtExceptionHandler((Thread t, Throwable e)->{
                // 异常处理
                System.out.println(t.getName() + " " + e.getMessage());
            });
            vt.start(()->{
                // task
                System.out.println("thread:" + Thread.currentThread().getName() );
            });
        }
        System.out.println("MAIN: " + Thread.currentThread().getName());
        Thread.sleep(1000L);
    }
}
