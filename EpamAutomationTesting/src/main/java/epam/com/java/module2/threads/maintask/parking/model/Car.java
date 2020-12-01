package epam.com.java.module2.threads.maintask.parking.model;

import java.util.concurrent.TimeUnit;

public class Car implements Runnable {
    private int id;
    private Parking parking;
    private static final long WAITING_TIME = 5000;

    public Car(int id, Parking parking) {
        this.id = id;
        this.parking = parking;
        System.out.println("car id = " + id + " is created");
    }

    public int getId() {
        return id;
    }

    @Override
    public void run() {
        int place = -1;
        try {
            System.out.println("Car id = " + id + " is trying to find parking place");
            place = parking.tryToPark(WAITING_TIME, this);
            if (place < 0) {
                System.out.println("Car id = " + id + " could not find parking place for time " + WAITING_TIME + " mls and left parking.");
                return;
            }
            TimeUnit.MILLISECONDS.sleep((long) ((Math.random()*10+1)*1000));


        } catch (Exception ex) {
            ex.getMessage();
        } finally {
            if (place >= 0) {
                parking.returnParkingPlace(place);
                System.out.println("\t\tCar id = " + id + " unpark  parking place #" + place);
            }
        }
    }

}
