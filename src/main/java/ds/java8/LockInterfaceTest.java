package ds.java8;

import java.io.Serializable;
import java.nio.file.Files;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockInterfaceTest {
    public static void main(String[] args) throws InterruptedException {



    }
}

class Singleton implements Serializable {

    private static volatile Singleton singleton ;
    private Singleton() {
    }

    public static Singleton singleton() {

        synchronized (Singleton.class) {
            if (singleton == null) {
                singleton = new Singleton();
            }
        }
        return singleton;
    }

    protected Object readResolve() {
        throw new RuntimeException();
    }
}

record Record(String name) {
    Record {

    }
}