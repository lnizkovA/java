package epam.com.java.module2.threads.maintask.parking.model;

public class Parking {
    public static final int MAX_PARKING_PLACES = 3;
    public static final boolean[] PARKING_PLACES = new boolean[MAX_PARKING_PLACES];
    private int countAttemp = 0;

    public synchronized int tryToPark(long maxWaitingTime, Car car) throws InterruptedException {
        int parkingPlace = -1;
        for (int i = 0; i < MAX_PARKING_PLACES; i++) {
            if (PARKING_PLACES[i]) {
                PARKING_PLACES[i] = false;
                parkingPlace = i;
                System.out.printf("\tCar %d reserved parking place #%d.\n", car.getId(), i);
                return parkingPlace;
            }
        }
        try {
            countAttemp++;
            if (checkAttemptCountToPark()){
                return parkingPlace;
            } else {
                wait(maxWaitingTime);
                System.out.println("\tCar id = " + car.getId() + " is waiting for parking place");
                return tryToPark(maxWaitingTime,car);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return parkingPlace;
    }

    private synchronized boolean checkAttemptCountToPark() {
        return countAttemp != 2;
    }

    public synchronized void returnParkingPlace(int place) {
        PARKING_PLACES[place] = true;
        notify();
    }

}
