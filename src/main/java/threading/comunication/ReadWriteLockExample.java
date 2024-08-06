package threading.comunication;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

    public static void main(String[] args) {

        ReadWriteLock lock = new ReentrantReadWriteLock(true);
        Lock readLock = lock.readLock();
        Lock writeLock = lock.writeLock();

        readLock.tryLock();
        readLock.unlock();

        writeLock.tryLock();
        writeLock.unlock();

    }

    public String getService() {
        return "Something";
    }

    public void setSomething(String something) {
        String concat = something.concat("-AnotherThing");
    }
}
