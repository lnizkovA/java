package epam.com.java.module2.threads.maintask.model;

public class ParkingPlace {
    private int placeId;
    private Parking parking;
    private Car car;

    public ParkingPlace(int placeId, Parking parking){
        this.placeId = placeId;
        this.parking = parking;
        System.out.println("Parking place #"+placeId+" is created. Parking '"+parking.getName()+"'.");
    }

    public int getPlaceId() {
        return placeId;
    }

//    public Parking getParking() {
//        return parking;
//    }
//
//    public Car getCar() {
//        return car;
//    }

    public void setCar(Car car) {
        this.car = car;
    }

//    public void reserveParkingPlace(){
//        try{
//            System.out.println("Parking place #"+placeId+" is reserved by car id = "+ car.getId()+". Parking '"+parking.getName()+"'.");
//            Thread.sleep(1000);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
}
