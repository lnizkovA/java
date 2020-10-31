package epam.com.java.module2.threads.maintask.model;

public class Car implements Runnable {
    private int id;
    private Parking parking;
    private static final long WAITING_TIME = 1500;

    public Car (int id, Parking parking){
        this.id = id;
        this.parking = parking;
        System.out.println("car id = "+id+" is created");
    }

    public int getId() {
        return id;
    }

    @Override
    public void run() {
        ParkingPlace place = null;
        try {
            System.out.println("Car id = " + id + " is trying to find parking place");
            place = parking.tryToPark(WAITING_TIME, this);
            if (place == null) {
                System.out.println("Car id = "+id+" could not find parking place for time "+WAITING_TIME+" mls and left parking '"+parking.getName()+"'.");
                return;
            }
            System.out.println("Car id = " + id + " reserved parking place #" + place.getPlaceId() + ". Parking '" + parking.getName()+"'.");

        } catch (Exception ex){
            ex.getMessage();
        }
        finally {
            if (place !=null){
                System.out.println("Car id = "+id+" unpark  parking place #"+place.getPlaceId()+". Parking '"+parking.getName()+"'.");
                parking.returnParkingPlace(place);
            }
        }
    }

}
