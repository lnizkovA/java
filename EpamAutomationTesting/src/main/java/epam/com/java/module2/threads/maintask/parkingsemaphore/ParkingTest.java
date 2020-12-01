package epam.com.java.module2.threads.maintask.parkingsemaphore;

import java.util.concurrent.Semaphore;

import static epam.com.java.module2.threads.maintask.parkingsemaphore.Car.COUNT_PARKING_PLACES;
import static epam.com.java.module2.threads.maintask.parkingsemaphore.Car.PARKING_PLACES;

public class ParkingTest {
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < COUNT_PARKING_PLACES; i++) {
            PARKING_PLACES[i] = true;
        }

        Semaphore semaphore = new Semaphore(PARKING_PLACES.length, true);

        for (int i = 1; i <= Car.TOTAL_CARS; i++) {
            new Thread(new Car(i, semaphore)).start();
            Thread.sleep(400);
        }

    }
}
