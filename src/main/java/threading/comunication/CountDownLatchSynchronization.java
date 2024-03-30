package threading.comunication;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchSynchronization {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(2);

        new Thread(new DownloadHalfOfPage(latch)).start();
        new Thread(new DownloadHalfOfPage(latch)).start();
        latch.await();
    }
}

class DownloadHalfOfPage implements Runnable {

    CountDownLatch latch;

    public DownloadHalfOfPage(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        sleep();
        latch.countDown();
        System.out.println("Done. %s".formatted(Thread.currentThread().getName()));

    }

    private static void sleep() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
