package threading.comunication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ThreadComunicationWaitAndNotify {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>(5);
        Thread producer = new Thread(new ProducerTask(tasks));
        Thread consumer = new Thread(new ConsumerTask(tasks));
        producer.start();
        consumer.start();

    }
}

class ProducerTask implements Runnable {
    List<String> tasks = new ArrayList<>();

    public ProducerTask(List<String> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (tasks) {
                if (tasks.size() == 5) {
                    try {
                        this.tasks.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                sleep(1);
                String task = String.valueOf(new Random().nextInt(100));
                System.out.println("Task added: %s. Task queue: %d".formatted(task, tasks.size()));
                this.tasks.add(task);
                this.tasks.notify();
            }
        }
    }

    private  void sleep(int i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class ConsumerTask implements Runnable {
    List<String> tasks = new ArrayList<>();

    public ConsumerTask(List<String> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this.tasks) {
                if (this.tasks.size() == 0) {
                    try {
                        this.tasks.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                sleep(2);
                String task = this.tasks.remove(0);
                System.out.println("Task processed: %s. Task queue: %d".formatted(task, this.tasks.size()));
                this.tasks.notify();
            }
        }
    }

    private static void sleep(int i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
