package ParkingLotSystem;

public class Bike extends Vehicle{
    public Bike(ParkingFeeStrategy parkingFeeStrategy, String licensePlate) {
        super(parkingFeeStrategy, VehicleType.BIKE, licensePlate);
    }}
