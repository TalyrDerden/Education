package org.examples;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VolayileTest {
    int i = 0;
    volatile boolean b = false;

    @Test
    void test() {
        Runnable thread1 = () -> {
            while (!b) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(i);
        };

        Runnable thread2 = () -> {
            i = 10;
            b = true;
        };

        List<Runnable> tasks = List.of(thread1,thread2);
        try(ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            tasks.forEach(executor::submit);
        }
    }
}
