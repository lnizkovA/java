package epam.com.java.module2.threads.maintask.parking;

import epam.com.java.module2.threads.maintask.parking.model.Car;
import epam.com.java.module2.threads.maintask.parking.model.Parking;

import java.util.concurrent.TimeUnit;

import static epam.com.java.module2.threads.maintask.parking.model.Parking.MAX_PARKING_PLACES;
import static epam.com.java.module2.threads.maintask.parking.model.Parking.PARKING_PLACES;

public class TestParking {

    public static final int MAX_CARS = 7;

    public static void main(String[] args) throws InterruptedException {

        Parking parking = new Parking();

        for (int i = 0; i< MAX_PARKING_PLACES; i++) {
            PARKING_PLACES[i] = true;
        }

        for (int i=1; i <= MAX_CARS; i++ ){
            Thread thread = new Thread(new Car(i,parking));
            thread.start();
            TimeUnit.MILLISECONDS.sleep(400);
        }

    }
}
