package threading.comunication;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreThreadSynchronization {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2, true);
        DatabaseConnection databaseOps = new DatabaseConnection(semaphore);
        new Thread(databaseOps).start();
        new Thread(databaseOps).start();
        new Thread(databaseOps).start();

        CyclicBarrier cb = new CyclicBarrier(2);

    }
}

class DatabaseConnection implements Runnable {
    private Semaphore semaphore;

    public DatabaseConnection(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            while (true) {
                this.semaphore.acquire(1);
                System.out.println("Database operation. Available permit %s"
                        .formatted(this.semaphore.availablePermits()));
                TimeUnit.SECONDS.sleep(1);
                this.semaphore.release();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}