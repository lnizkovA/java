package epam.com.java.module2.threads.maintask.model;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Parking {
    private String name;
    private int maxParkingPlaces;
    private Queue<ParkingPlace> parkingPlaces;
    private Semaphore semaphore;

    public Parking(String name, int maxParkingPlaces) {
        this.name = name;
        this.maxParkingPlaces = maxParkingPlaces;
//        this.semaphore = new Semaphore(1,true);
        this.semaphore = new Semaphore(maxParkingPlaces, true);
        parkingPlaces = new ConcurrentLinkedQueue<>();
    }

    public String getName() {
        return name;
    }

    public int getMaxParkingPlaces() {
        return maxParkingPlaces;
    }


    public void addParkingPlace(ParkingPlace parkingPlace) {
        if (parkingPlaces.size() <= maxParkingPlaces) {
            parkingPlaces.add(parkingPlace);
        }
    }

    public  ParkingPlace tryToPark(long maxWaitingTime, Car car) {
        ParkingPlace parkingPlace = null;
        try {
            if (semaphore.tryAcquire(maxWaitingTime, TimeUnit.MILLISECONDS)) {

                parkingPlace = parkingPlaces.poll();

                TimeUnit.MILLISECONDS.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return parkingPlace;
    }

    public  void returnParkingPlace(ParkingPlace place) {

        place.setCar(null);
        parkingPlaces.add(place);

        semaphore.release();
    }

//    public ParkingPlace tryToPark(long maxWaitingTime, Car car) {
//        ParkingPlace parkingPlace = null;
//        try {
//            if (semaphore.tryAcquire(maxWaitingTime, TimeUnit.MILLISECONDS)) {
//                synchronized (parkingPlaces) {
//                    parkingPlace = parkingPlaces.poll();
//                }
//                TimeUnit.MILLISECONDS.sleep(1000);
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return parkingPlace;
//    }
//
//    public void returnParkingPlace(ParkingPlace place) {
//        synchronized (parkingPlaces) {
//            place.setCar(null);
//            parkingPlaces.add(place);
//        }
//        semaphore.release();
//    }

}
