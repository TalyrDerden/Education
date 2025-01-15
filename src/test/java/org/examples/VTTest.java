package org.examples;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;

public class VTTest {

    @Test
    void test() {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 1000_001; i++) {
                //AtomicInteger taskId = new AtomicInteger();
                //taskId.set(i);
                int taskId = i;
                executor.submit(() -> {
                    System.out.println("Задача " + taskId + " выполняется виртуальным потоком: " + Thread.currentThread());
                    try {
                        Thread.sleep(100); // Симуляция работы
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        }
    }
}
