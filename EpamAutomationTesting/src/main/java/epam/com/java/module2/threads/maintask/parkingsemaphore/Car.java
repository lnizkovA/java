package epam.com.java.module2.threads.maintask.parkingsemaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Car implements Runnable {
    public static final int COUNT_PARKING_PLACES = 3;
    public static final int TOTAL_CARS         = 7;

    public static final boolean[] PARKING_PLACES = new boolean[COUNT_PARKING_PLACES];

    private static final long WAITING_TIME = 5000;

    private Semaphore semaphore ;
    private int carNumber;

    public Car (int carNumber, Semaphore semaphore){
        this.carNumber = carNumber;
        this.semaphore = semaphore;
        System.out.printf("Car # %d is created.\n",carNumber);
    }

    public int getCarNumber() {
        return carNumber;
    }

    @Override
    public void run() {
        System.out.println("Car #"+ this.getCarNumber() +" is trying to find parking place.");
        int parkingPlace = -1;
        try{
            parkingPlace = reserveParkingPlace();
            if (parkingPlace < 0){
                System.out.printf("Car #%d could not find parking place for time %d mls and left parking.\n", this.getCarNumber(), WAITING_TIME);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            if (parkingPlace >= 0){
                releaseParkingPlace(parkingPlace);
            }
        }
    }

    private int reserveParkingPlace() throws InterruptedException {
        int parkingPlace = -1;
        if ( semaphore.tryAcquire(WAITING_TIME, TimeUnit.MILLISECONDS)){
//            synchronized (PARKING_PLACES){
            for (int i = 0; i < COUNT_PARKING_PLACES; i++)
                if (PARKING_PLACES[i]) {
                    // Занимаем место
                    PARKING_PLACES[i] = false;
                    parkingPlace = i;
                    System.out.printf("\tCar #%d reserved parking place # %d. \n",  this.getCarNumber(), i);
                    break;
                }
//            }
            TimeUnit.MILLISECONDS.sleep((long) ((Math.random()*10+1)*1000));
//            TimeUnit.MILLISECONDS.sleep(4000);
        }
        return parkingPlace;
    }

    private void releaseParkingPlace(int parkingPlace){
//        synchronized (PARKING_PLACES) {
        PARKING_PLACES[parkingPlace] = true;
//        }
        semaphore.release();
        System.out.printf("\t\tCar # %d unparked parking place # %d\n", this.getCarNumber(), parkingPlace);
    }
}
