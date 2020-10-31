package epam.com.java.module2.threads.optinaltask;

import java.util.concurrent.Semaphore;

public class TestAirport {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for (int i=1; i<11; i++) {
            new Thread(new Airplane(i, semaphore)).start();
        }
    }
}
