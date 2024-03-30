package threading.comunication;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompletableFutureUsage {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Instant now = Instant.now();
//        runMultipleAsycTask();

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "Something";
                })
                .thenApplyAsync(s -> s + " Something ");

        String s = cf.get();
        System.out.println(s);
        System.out.println("Time taken %d".formatted(Duration.between(now, Instant.now()).toSeconds()));
    }

    private static void runMultipleAsycTask() {
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> {
            sleep(2);
            return "data1";
        });
        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> {
            sleep(2);
            return "data2";
        });

//        CompletableFuture.

        CompletableFuture<Void> combinedTask = task1.thenAcceptBoth(task2, (result1, result2) -> {
            System.out.println("Result of task1: %s".formatted(result1));
            System.out.println("Result of task2: %s".formatted(result2));
        });


        combinedTask.join();
    }

    private static void sleep(int seconds)  {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
