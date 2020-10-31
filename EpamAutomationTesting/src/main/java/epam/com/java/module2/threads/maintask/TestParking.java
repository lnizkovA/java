package epam.com.java.module2.threads.maintask;

import epam.com.java.module2.threads.maintask.model.Car;
import epam.com.java.module2.threads.maintask.model.Parking;
import epam.com.java.module2.threads.maintask.model.ParkingPlace;

public class TestParking {

    public static final int MAX_PARKING_PLACES = 3;
    public static final int MAX_CARS = 7;

    public static void main(String[] args) throws InterruptedException {
        Parking parking_1 = new Parking("Parking_1", MAX_PARKING_PLACES);

        for (int i=1; i <= parking_1.getMaxParkingPlaces(); i++) {
           parking_1.addParkingPlace(new ParkingPlace(i, parking_1));
        }

        for (int i=1; i <= MAX_CARS; i++ ){
            Thread thread = new Thread(new Car(i, parking_1));
            thread.start();
//            TimeUnit.MILLISECONDS.sleep(400);
        }

    }
}
